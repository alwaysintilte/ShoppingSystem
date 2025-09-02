package systems.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductWebSocketController {
    @Autowired
    private ProductListService productListService;
    @GetMapping
    public List<ProductItem> getProductList(){
        return productListService.getProductList();
    }
    @PostMapping
    public void addProduct(@RequestBody Product product){
        productListService.addProduct(product);
    }
    @DeleteMapping
    public void deleteProduct(@PathVariable Integer id){
        productListService.deleteProduct(id);
    }
    @DeleteMapping("/clear")
    public void clearProductList(){
        productListService.clearProductList();
    }
    @GetMapping("/plus/{id}")
    public void PlusItem(@PathVariable Integer id){
        productListService.PlusItem(id);
    }
    @GetMapping("/minus/{id}")
    public void MinusItem(@PathVariable Integer id){
        productListService.MinusItem(id);
    }
    @GetMapping("/quantity/{id}")
    public Integer getQuantity(@PathVariable Integer id){
        return productListService.getQuantity(id);
    }
    @GetMapping("/price")
    public Double getProductListPrice(){
        return productListService.getProductListPrice();
    }
}
