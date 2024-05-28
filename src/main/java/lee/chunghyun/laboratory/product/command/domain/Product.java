package lee.chunghyun.laboratory.product.command.domain;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bundle_id")
    private Bundle bundle;

    @Column(name = "options", nullable = false)
    @ElementCollection
    @CollectionTable(name = "product_options", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "option_name")
    @Column(name = "option_value")
    private Map<String, String> options;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    // Constructors, Getters, and Setters
    public Product() {}

    public 상품(Bundle bundle, Map<String, String> options, Double price, Integer stock) {
        this.bundle = bundle;
        this.options = options;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
