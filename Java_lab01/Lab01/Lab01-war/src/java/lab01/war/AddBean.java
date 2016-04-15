/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.war;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lab01.ejb.DAOAddInterface;
import lab01.ejb.Product;

/**
 *
 * @author AlexKis
 */
@Named("addBean")
@RequestScoped
public class AddBean {

    @Inject
    private AddProductInterface addProductHandler;

    @EJB
    private DAOAddInterface DAO;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Creates a new instance of AddBean
     */
    public AddBean() {
        product = new Product();
    }

    public String addProduct() {
        this.addProductHandler.addProduct(product, DAO);
        return "/index.xhtml";
    }

}
