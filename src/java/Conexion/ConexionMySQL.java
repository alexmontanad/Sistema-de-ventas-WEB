/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class ConexionMySQL {
    private static ConexionMySQL instance; //sibgleton
    private Connection cnn;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String pss = "";
    private String nom_bd ="bd_sistemaventas";
    private String url = "jdbc:mysql://localhost:3306/";
    
    public ConexionMySQL() {
        try {
            Class.forName(driver);
            cnn = DriverManager.getConnection(url + nom_bd, user, pss);
        } catch (ClassNotFoundException ex) {
            System.out.println("error en driver MySQL: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized ConexionMySQL getInstace(){
    if(instance == null){
        instance = new ConexionMySQL();
    }
    return instance;
    }
    
    public void CerrarConexion(){
    instance = null;
    }

    public Connection getCnn() {
        return cnn;
    }

    
    
}
