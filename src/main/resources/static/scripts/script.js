document.addEventListener("DOMContentLoaded", LoadProducts);
document.addEventListener("DOMContentLoaded", LoadPrice);

document.querySelectorAll('.payment-btn').forEach(button => {
    button.addEventListener('click', ClearProducts);
});

async function LoadProducts(){
    var products = await GetProducts();
    var container = document.querySelector(".products-list");
    container.innerHTML = "";
    products.forEach(product => {
        var item = document.createElement("div");
        item.classList.add("product-item");
        var spanName = document.createElement("span");
        spanName.textContent = product.name;
        var spanPrice = document.createElement("span");
        spanPrice.classList.add("product-price");
        spanPrice.textContent = product.price + " ₽";
        /*// Кнопка удаления
        const deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Удалить";
        deleteBtn.onclick = () => deleteProduct(product);*/
        item.appendChild(spanName);
        item.appendChild(spanPrice);
        //item.appendChild(deleteBtn);
        container.appendChild(item);
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

async function GetProducts(){
    var response = await fetch(`http://localhost:8080/productlist`);
    var products = await response.json();
    return products;
}

async function GetPrice(){
    var response = await fetch(`http://localhost:8080/productlist/price`);
    var price = await response.json();
    return price;
}