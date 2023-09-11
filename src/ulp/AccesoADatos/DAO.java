/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author criss
 */
public abstract class DAO {

    protected Connection coneccion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;

    private final String USER = "root";
    private final String PASSWORD = "";
    private final String DATABASE = "ulap";
    private final String DRIVER = "org.mariadb.jdbc.Driver";

    protected void coneccionBaseDatos() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDatos = "jdbc:mariadb://localhost:3306/" + DATABASE + "?zeroDateTimeBehavior=convertToNull";
            coneccion = DriverManager.getConnection(urlBaseDatos, USER, PASSWORD);
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected void desconectarBaseDatos() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (coneccion != null) {
                coneccion.close();
            }
            System.out.println("Desconectado");
        } catch (Exception e) {
            throw e;
        }
    }

    protected void insertarModificarEliminarBaseDatos(String sql) throws SQLException, ClassNotFoundException, Exception {
        try {
            coneccionBaseDatos();
            sentencia = coneccion.createStatement();
            sentencia.executeUpdate(sql);
            
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            desconectarBaseDatos();
        }
    }

    protected void consultarBaseDatos(String sql) throws Exception {
        try {
            coneccionBaseDatos();
            sentencia = coneccion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }

}
