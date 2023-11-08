package model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ProductDB {

    public static List<Product> getAllProducts() {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        String query = "SELECT p from Product p";

        TypedQuery<Product> tq = em.createQuery(query, Product.class);

        List<Product> list = null;

        try {
            list = tq.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return list;

    }// end getAllProducts

    public static Optional<Product> getProductByID(int id) {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        Product product = null;
        try {
            product = em.find(Product.class, id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        // Check if the customer exists
        if (product != null) {
            return Optional.of(product);
        } else {
            return Optional.empty(); // Return an empty Optional if customer is not found
        }
    }// end getProductByID
}
