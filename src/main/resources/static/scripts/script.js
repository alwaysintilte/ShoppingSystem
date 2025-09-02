document.addEventListener("DOMContentLoaded", LoadProducts);
document.addEventListener("DOMContentLoaded", LoadPrice);

document.querySelectorAll('.payment-btn').forEach(button => {
    button.addEventListener('click', ClearProducts);
});

async function LoadProducts(){
    var productItems = await GetProductItems();
    var container = document.querySelector(".products-list");
    container.innerHTML = "";
    productItems.forEach(productItem => {
        console.log(productItem);
        var item = document.createElement("div");
        item.className = "product-item";
        const info = document.createElement('div');
        info.className = 'product-info';
        var name = document.createElement("span");
        name.textContent = productItem.product.name;
        var price = document.createElement("span");
        price.className = "product-price";
        price.textContent = productItem.product.price + " ₽";
        info.appendChild(name);
        info.appendChild(price);
        var quantity = document.createElement('div');
        quantity.className = 'product-quantity';
        var minusBtn = document.createElement('button');
        minusBtn.className = 'quantity-btn minus';
        minusBtn.textContent = '-';
        var quantityValue = document.createElement('span');
        quantityValue.className = 'quantity-value';
        quantityValue.textContent = productItem.quantity;
        var plusBtn = document.createElement('button');
        plusBtn.className = 'quantity-btn plus';
        plusBtn.textContent = '+';
        quantity.appendChild(minusBtn);
        quantity.appendChild(quantityValue);
        quantity.appendChild(plusBtn);
        var total = document.createElement('div');
        total.className = 'product-total';
        var totalPrice = document.createElement('span');
        totalPrice.className = 'total-price';
        totalPrice.textContent = (productItem.product.price * productItem.quantity).toFixed(2) + " ₽";
        total.appendChild(totalPrice);
        item.appendChild(info);
        item.appendChild(quantity);
        item.appendChild(total);
        container.appendChild(item);

        plusBtn.addEventListener("click", async () => {
            await IncreaseQuantity(productItem.id);
            var newQuantity = await GetQuantity(productItem.id);
            totalPrice.textContent = (productItem.product.price * newQuantity).toFixed(2) + " ₽";
            quantityValue.textContent = newQuantity;
            await LoadPrice();
        });
        minusBtn.addEventListener("click", async () => {
            await DecreaseQuantity(productItem.id);
            var newQuantity = await GetQuantity(productItem.id);
            totalPrice.textContent = (productItem.product.price * newQuantity).toFixed(2) + " ₽";
            quantityValue.textContent = newQuantity;
            await LoadPrice();
        });
    });
}

async function LoadPrice(){
    var price = await GetPrice();
    var container = document.querySelector(".products-total");
    container.textContent = `Итого: ${price} ₽`;
}

async function ClearProducts(){
    await fetch(`http://localhost:8080/productlist/clear`, {
        method: 'DELETE'
    });
}

async function GetProductItems(){
    var response = await fetch(`http://localhost:8080/productlist`);
    var products = await response.json();
    return products;
}

async function GetPrice(){
    var response = await fetch(`http://localhost:8080/productlist/price`);
    var price = await response.json();
    return price.toFixed(2);
}

async function IncreaseQuantity(id){
    await fetch(`http://localhost:8080/productlist/plus/${id}`);
}

async function DecreaseQuantity(id){
    await fetch(`http://localhost:8080/productlist/minus/${id}`);
}

async function GetQuantity(id){
    var response = await fetch(`http://localhost:8080/productlist/quantity/${id}`);
    var quantity = await response.json();
    return quantity;
}