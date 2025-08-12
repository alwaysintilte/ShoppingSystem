package systems.shopping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductLoader implements CommandLineRunner {
    private final ProductService productService;
    public ProductLoader(ProductService productService) {
        this.productService=productService;
    }
    @Override
    public void run(String[] args){
        productService.save(new Product("Молоко", "Молоко", 12345678, "Молоко", "Молоко", 123.4, 20, 123.4, List.of("Молоко","Молоко")));
    }
}
