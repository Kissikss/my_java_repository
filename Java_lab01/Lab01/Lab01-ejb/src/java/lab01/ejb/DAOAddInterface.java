/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.ejb;

import javax.ejb.Remote;

/**
 *
 * @author AlexKis
 */
@Remote
public interface DAOAddInterface {

    int addProduct(Product product);

}
