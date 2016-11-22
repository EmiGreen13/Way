package entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "CustomerProducts")
@Table(name = "tblCustomerProducts")
public class CustomerProduct {
    @Id
    @Column(name = "CustomerProductId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CustomerId", nullable = false)
    private Long customerId;
    @Column(name = "ProductId", nullable = false)
    private Long productId;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CustomerId", insertable = false, updatable = false)
    private Customer customer;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ProductId", insertable = false, updatable = false)
    private Product product;

    public CustomerProduct(){}

    public CustomerProduct(Long id, Long customerId, Long productId){
        this.setId(id);
        this.setCustomerId(customerId);
        this.setProductId(productId);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
