package manager;

import error.Errors;
import entities.Product;
import java.util.ArrayList;

public interface ProductDao {
    ArrayList<Product> getProducts(Errors errors, Long customerId);
}
