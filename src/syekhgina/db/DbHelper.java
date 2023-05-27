/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syekhgina.db;
import com.mysql.cj.jdbc.MysqlDataSource;
import syekhgina.dao.*;
import syekhgina.model.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DbHelper {
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException{
        if(connection==null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost/pbo_2211082031");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    public static void main(String[] args) {
        try {
            connection = DbHelper.getConnection();
            AnggotaDao dao = new AnggotaDaoImpl(connection);
            Anggota anggota = new Anggota("A001", "Ali", "Padang", "L");
            dao.insert(anggota);
            JOptionPane.showMessageDialog(null, "Entri data Ok");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
    }
}
