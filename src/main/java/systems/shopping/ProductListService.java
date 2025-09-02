package systems.shopping;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductListService {
    private final Map<Integer, ProductItem> ProductList=new LinkedHashMap<>();
    public List<ProductItem> getProductList(){
        return this.ProductList.values().stream().toList();
    }
    public void addProduct(Product product){
        Integer id = this.ProductList.isEmpty() ? 0 : this.ProductList.keySet().stream().toList().get(this.ProductList.size()-1)+1;
        ProductList.put(id, new ProductItem(id, 1, product));
    }
    public void deleteProduct(Integer id){
        ProductList.remove(id);
    }
    public void clearProductList(){
        ProductList.clear();
    }
    public void PlusItem(Integer id){
        this.ProductList.get(id).increaseQuantity();
    }
    public void MinusItem(Integer id){
        this.ProductList.get(id).decreaseQuantity();
    }
    public Integer getQuantity(Integer id){
        return this.ProductList.get(id).getQuantity();
    }
    public Double getProductListPrice(){
        Double price=0.0;
        for (ProductItem productItem:ProductList.values()) {
            price=price+productItem.getProduct().getPrice()*productItem.getQuantity();
        }
        return price;
    }
}
