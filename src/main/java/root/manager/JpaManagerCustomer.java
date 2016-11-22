package manager;

import entities.Customer;
import error.Errors;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;

@Repository
public class JpaManagerCustomer implements CustomerDao {

    protected EntityManagerFactory entityManagerFactory;

    public ArrayList<Customer> getCustomers(Errors errors){
        ArrayList<Customer> customers = null;
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("products.spGetCustomers", Customer.class);
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.INOUT);
            query.registerStoredProcedureParameter(2, String.class, ParameterMode.INOUT);

            query.execute();

            Integer errorNumber = (Integer)query.getOutputParameterValue(1);
            String errorMessage = (String)query.getOutputParameterValue(2);

            if (errorNumber == 0){
                customers = new ArrayList<Customer>(query.getResultList());
            }
            else{
                errors.setErrorMessage(errorMessage);
                errors.setErrorNumber(errorNumber);
            }
            entityManager.close();
        }
        catch (Exception exception){
            customers = null;
            errors.setErrorMessage(exception.getMessage());
            errors.setErrorNumber(exception.hashCode());
        }
        return customers;
    }

    @PersistenceUnit(unitName = "myEmf")
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
