package systems.shopping;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productlist")
public class ProductList {
    private final List<Product> ProductList=new ArrayList<>();
    @GetMapping
    public List<Product> getProductList(){
        System.out.println(ProductList.size());
        return this.ProductList;
    }
    @PostMapping
    public void addProduct(@RequestBody Product product){
        ProductList.add(product);
        System.out.println(product);
    }
    @DeleteMapping
    public void deleteProduct(@RequestBody Product product){
        ProductList.remove(product);
    }
    @DeleteMapping("/clear")
    public void clearProductList(){
        ProductList.clear();
    }
    @GetMapping("/price")
    public Double getProductListPrice(){
        Double price=0.0;
        for (Product product:ProductList) {
            price=price+product.getPrice();
        }
        return price;
    }
}
