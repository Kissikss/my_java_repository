/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01.ejb;

import java.sql.*;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author AlexKis
 */
@Stateless
@Remote(DAOAddInterface.class)
public class DAOAddImpl implements DAOAddInterface {

    @Resource(name = "jdbc/mainDataSource")
    private DataSource dataSource;

    public int addProduct(Product product) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement stat = connection.prepareStatement("INSERT INTO goods (name, cost, quantity) values(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stat.setString(1, product.getName());
            stat.setInt(2, product.getCost());
            stat.setInt(3, product.getQuantity());
            stat.execute();
            ResultSet res = stat.getGeneratedKeys();
            if (res.next()) {
                return res.getInt(1);
            } else {
                return -1;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to add product", e);
        }
    }
}
