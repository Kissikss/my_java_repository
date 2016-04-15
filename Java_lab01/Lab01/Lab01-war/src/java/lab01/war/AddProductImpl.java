/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.war;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import lab01.ejb.*;

/**
 *
 * @author AlexKis
 */
@Stateful
@ConversationScoped
public class AddProductImpl implements AddProductInterface, Serializable {

    @Inject
    Conversation conversation;

    /**
     * Creates a new instance of AddProductBean
     */
    public AddProductImpl() {
    }

    @Override
    public void addProduct(Product product, DAOAddInterface DAO) {
        conversation.begin();
        int result = DAO.addProduct(product);
        if (result != -1) {
            conversation.end();
        }
    }

}
