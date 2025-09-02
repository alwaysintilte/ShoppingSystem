package systems.shopping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Optional<Product> findByName(String name);
    @Query("SELECT p FROM Product p WHERE LOWER(p.image_url) = LOWER(:image_url)")
    List<Product> findByImageUrl(String image_url);
    @Query("SELECT p FROM Product p WHERE p.barcode = :barcode")
    Optional<Product> findByBarcode(Integer barcode);
    @Query("SELECT p FROM Product p WHERE LOWER(p.category) = LOWER(:category)")
    List<Product> findByCategory(String category);
    @Query("SELECT p FROM Product p WHERE LOWER(p.brand) = LOWER(:brand)")
    List<Product> findByBrand(String brand);
    @Query("SELECT p FROM Product p WHERE p.price = :price")
    List<Product> findByPrice(Double price);
    @Query("SELECT p FROM Product p WHERE p.discount = :discount")
    List<Product> findByDiscount(Integer discount);
    @Query("SELECT p FROM Product p WHERE p.weight = :weight")
    List<Product> findByWeight(Double weight);
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT(:string, '%'))")
    List<Product> findByString(String string);
}