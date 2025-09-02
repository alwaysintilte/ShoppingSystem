document.getElementById('searchInput').addEventListener('input', async function() {
    var input = this.value;
    var products = await GetProductsByString(input);
    if(products){
        console.log("sosiski");
        await LoadProducts(products);
    }
    else{
        ShowMessage(products);
    }
});

async function LoadProducts(products){
    var container = document.querySelector(".products-grid");
    container.innerHTML = "";
    products.forEach(product => {
        var item = document.createElement("div");
        item.classList.add("product-card");
        var img = document.createElement("img");
        img.classList.add("product-image");
        img.src = product.imageUrl;
        var name = document.createElement("div");
        name.classList.add("product-name");
        name.textContent = product.name;
        var details = document.createElement("div");
        details.classList.add("product-details");
        var weight = document.createElement("span");
        weight.classList.add("product-weight");
        weight.textContent = product.weight + " кг";
        var price = document.createElement("span");
        price.classList.add("product-price");
        price.textContent = product.price + " ₽";
        details.appendChild(weight);
        details.appendChild(price);
        item.appendChild(img);
        item.appendChild(name);
        item.appendChild(details);
        container.appendChild(item);
        item.addEventListener("click", async () => {
            await AddProduct(product);
            window.location.href = '/';
        });
    });
}

function ShowMessage(products){
    console.log(products);
}

async function GetProductsByString(string){
    if(string){
        var response = await fetch(`http://localhost:8080/products/find/string/${string}`);
        return await response.json();
    }
    return null;
}

async function AddProduct(product){
    await fetch(`http://localhost:8080/productlist`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(product)
    });
}