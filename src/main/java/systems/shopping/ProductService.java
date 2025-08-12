package systems.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void deleteById(Integer id){
        if(productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
        }
    }
    public void deleteByName(String name){
        if(productRepository.findByName(name).isPresent()){
            productRepository.deleteById(productRepository.findByName(name).get().getId());
        }
    }
    public Product save(Product product) {
        return productRepository.findByName(product.getName()).orElseGet(()->productRepository.save(product));
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }
    public Optional<Product> findByName(String name){
        return productRepository.findByName(name);
    }
    public List<Product> findByDescription(String description){
        return productRepository.findByDescription(description);
    }
    public Optional<Product> findByBarcode(Integer barcode){
        return productRepository.findByBarcode(barcode);
    }
    public List<Product> findByCategory(String category){
        return productRepository.findByCategory(category);
    }
    public List<Product> findByBrand(String brand){
        return productRepository.findByBrand(brand);
    }
    public List<Product> findByPrice(Double price){
        return productRepository.findByPrice(price);
    }
    public List<Product> findByDiscount(Integer discount){
        return productRepository.findByDiscount(discount);
    }
    public List<Product> findByWeight(Double weight){
        return productRepository.findByWeight(weight);
    }
}
