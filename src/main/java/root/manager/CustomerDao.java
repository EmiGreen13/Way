package manager;

import entities.Customer;
import error.Errors;

import java.util.ArrayList;

public interface CustomerDao {
    ArrayList<Customer> getCustomers(Errors errors);
}
