/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.war;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lab01.ejb.DAOInterface;
import lab01.ejb.Product;

/**
 *
 * @author AlexKis
 */
@Named("shopBean")
@RequestScoped
public class ShopBean implements Serializable {

    @EJB
    private DAOInterface DAO;

    /**
     * Creates a new instance of ShopBean
     */
    public ShopBean() {
    }

    public List<Product> getAllGoods() {
        List<Product> products = DAO.getAllGoods();
        return products;
    }

    public String index() {
        return "index.xhtml";
    }

}
