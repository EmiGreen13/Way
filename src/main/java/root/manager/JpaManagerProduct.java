package manager;

import error.Errors;
import entities.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;

@Repository
public class JpaManagerProduct implements ProductDao {


    protected EntityManagerFactory entityManagerFactory;


    public ArrayList<Product> getProducts(Errors errors, Long customerId){
        ArrayList<Product> products = null;
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("products.spGetProducts", Product.class);
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.INOUT);
            query.registerStoredProcedureParameter(2, String.class, ParameterMode.INOUT);
            query.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);

            query.setParameter(3, customerId);

            query.execute();

            Integer errorNumber = (Integer)query.getOutputParameterValue(1);
            String errorMessage = (String)query.getOutputParameterValue(2);

            if (errorNumber == 0){
                products = new ArrayList<>(query.getResultList());
            }
            else{
                errors.setErrorMessage(errorMessage);
                errors.setErrorNumber(errorNumber);
            }
            entityManager.close();
        }
        catch (Exception exception){
            products = null;
            errors.setErrorMessage(exception.getMessage());
            errors.setErrorNumber(exception.hashCode());
        }
        return products;
    }

    @PersistenceUnit(unitName = "myEmf")
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
