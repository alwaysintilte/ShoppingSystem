document.querySelector('.submit-btn').addEventListener('click', function() {
    const barcode = document.querySelector('.barcode-input input').value;
    if(barcode) {
        window.location.href = '/';
    }
});