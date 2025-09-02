package systems.shopping;

public class ProductItem {
    private Integer id;

    private Integer quantity;

    private Product product;

    public ProductItem() {}

    public ProductItem(Integer id, Integer quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void increaseQuantity(){
        quantity=quantity+1;
    }

    public void decreaseQuantity(){
        quantity=quantity-1;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
