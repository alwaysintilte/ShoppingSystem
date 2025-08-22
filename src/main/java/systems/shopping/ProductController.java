package systems.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @DeleteMapping("/{id}")
    public void deleteById(Integer id){
        productService.deleteById(id);
    }
    @DeleteMapping("/name/{name}")
    public void deleteByName(String name){
        productService.deleteByName(name);
    }
    @PostMapping("/product")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    @PutMapping("/product")
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }
    @GetMapping("/")
    public List<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Product> findById(@PathVariable Integer id){
        return productService.findById(id);
    }
    @GetMapping("/find/name/{name}")
    public Optional<Product> findByName(@PathVariable String name){
        return productService.findByName(name);
    }
    @GetMapping("/find/description/{description}")
    public List<Product> findByDescription(@PathVariable String description){
        return productService.findByDescription(description);
    }
    @GetMapping("/find/barcode/{barcode}")
    public Optional<Product> findByBarcode(@PathVariable Integer barcode){
        System.out.println("barcode: "+barcode);
        return productService.findByBarcode(barcode);
    }
    @GetMapping("/find/category/{category}")
    public List<Product> findByCategory(@PathVariable String category){
        return productService.findByCategory(category);
    }
    @GetMapping("/find/brand/{brand}")
    public List<Product> findByBrand(@PathVariable String brand){
        return productService.findByBrand(brand);
    }
    @GetMapping("/find/price/{price}")
    public List<Product> findByPrice(@PathVariable Double price){
        return productService.findByPrice(price);
    }
    @GetMapping("/find/discount/{discount}")
    public List<Product> findByDiscount(@PathVariable Integer discount){
        return productService.findByDiscount(discount);
    }
    @GetMapping("/find/weight/{weight}")
    public List<Product> findByWeight(@PathVariable Double weight){
        return productService.findByWeight(weight);
    }
}