/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.war;

import javax.ejb.Local;
import lab01.ejb.DAOAddInterface;
import lab01.ejb.Product;

/**
 *
 * @author AlexKis
 */
@Local
public interface AddProductInterface {

    void addProduct(Product product, DAOAddInterface DAO);
}
