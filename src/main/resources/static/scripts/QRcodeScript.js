document.getElementById('submit-btn').addEventListener('click', async function() {
    var barcode = document.getElementById('barcode-input').value;
    var product = await GetProductByBarcode(barcode);
    if(product){
        AddProduct(product);
        window.location.href = '/';
    }
    else{
        ShowMessage(product);
    }
});

function ShowMessage(product){
    console.log(product);
}

async function GetProductByBarcode(barcode){
    if(barcode){
        var response = await fetch(`http://localhost:8080/products/find/barcode/${barcode}`);
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