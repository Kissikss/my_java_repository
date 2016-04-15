/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.ejb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author AlexKis
 */
@Stateless
@Remote(DAOInterface.class)
public class DAOImpl implements DAOInterface {

    @Resource(name = "jdbc/mainDataSource")
    private DataSource dataSource;

    @Override
    public List<Product> getAllGoods() {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM goods");
            ResultSet res = stmt.executeQuery();
            List<Product> products = new ArrayList();
            while (res.next()) {
                Product product = new Product();
                product.setId(res.getInt(1));
                product.setName(res.getString(2));
                product.setCost(res.getInt(3));
                product.setQuantity(res.getInt(4));
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            throw new RuntimeException("Failed to select all goods", e);
        }
    }
}
