package entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "Product")
@Table(name = "tblProducts")
public class Product {
    @Id
    @Column(name = "ProductId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ProductName", unique = true, length = 100, nullable = false)
    private String productName;

    public Product(){}

    public Product(Long id, String productName){
        this.setId(id);
        this.setProductName(productName);
    }

    public Product(String productName){
        this.setProductName(productName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static ArrayList<Product> getProductList(){
        ArrayList productList = new ArrayList(15);
        productList.add(new Product(new Long(1), "Diesel"));
        productList.add(new Product(new Long(2), "Gasoline A-92"));
        productList.add(new Product(new Long(3), "Gasoline A-95"));
        productList.add(new Product(new Long(4), "Kerosene"));
        productList.add(new Product(new Long(5), "Fuel oil"));
        productList.add(new Product(new Long(6), "Methane"));
        productList.add(new Product(new Long(7), "Propane"));
        productList.add(new Product(new Long(8), "Butane"));
        productList.add(new Product(new Long(9), "Propylene"));
        productList.add(new Product(new Long(10), "Hydrogen"));
        productList.add(new Product(new Long(11), "Coal"));
        productList.add(new Product(new Long(12), "Peat"));
        productList.add(new Product(new Long(13), "Firewood"));
        productList.add(new Product(new Long(14), "Legnin"));
        productList.add(new Product(new Long(15), "Briquets"));

        return  productList;
    }
}
