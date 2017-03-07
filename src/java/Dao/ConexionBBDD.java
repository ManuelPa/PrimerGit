/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;

public class ConexionBBDD {

    private static ConexionBBDD UnicaConexion = null;
    private Connection Conex;

    private ConexionBBDD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://mysql13839-manuelpg.jelastic.cloudhosted.es:3306/bd_votaciones_mpg";
        Conex = DriverManager.getConnection(connectionUrl, "root", "BACcgq99668");
    }
//LuWnANUyz5QNdm7q
    public synchronized static ConexionBBDD GetConexion()
            throws ClassNotFoundException, SQLException {
        if (UnicaConexion == null) {
            UnicaConexion = new ConexionBBDD();
        }
        return UnicaConexion;
    }

    public Connection GetCon() {
        return Conex;
    }

    public void Destroy() throws SQLException {
        Conex.close();
    }
}

