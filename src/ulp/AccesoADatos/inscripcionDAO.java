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
import java.time.LocalDate;
import java.util.ArrayList;
import ulp.Entidades.alumno;

/**
 *
 * @author criss
 */
public class inscripcionDAO extends DAO {
    
        protected Connection coneccion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;

    private final String USER = "root";
    private final String PASSWORD = "";
    private final String DATABASE = "ulap";
    private final String DRIVER = "org.mariadb.jdbc.Driver";
     public alumno buscarAlumnoPorID(int id) throws Exception {
       
       
        
         try {
            String sql = "SELECT * FROM `alumno` WHERE idAlumno = " + id + " AND estado = 1";
            consultarBaseDatos(sql);
            alumno aux = null;
            while (resultado.next()) {
                aux = new alumno();
                aux.setIdAlumno(resultado.getInt(1));
                aux.setDni(resultado.getInt(2));
                aux.setApellido(resultado.getString(3));
                aux.setNombre(resultado.getString(4));
                // Crear un objeto Date SQL
                java.sql.Date fechaSQL = resultado.getDate(5);
                // Se creal localDate con los valores
                LocalDate localDate = fechaSQL.toLocalDate();
                // Se setea la fecha al alumno a retornar
                aux.setFechaNacimiento(localDate);
                aux.setEstado(true);
               
            }
            desconectarBaseDatos();
            return aux;
        } catch (Exception e) {
            desconectarBaseDatos();
            throw e;
        }
    }
     
     public ArrayList<alumno> listarAlumno() throws Exception {
        try {
            String sql = "SELECT * FROM `alumno` WHERE estado = 1";
            consultarBaseDatos(sql);
            ArrayList<alumno> listaAlumnoARetornar = new ArrayList<>();
            alumno aux = null;
            while (resultado.next()) {
                aux = new alumno();
                aux.setIdAlumno(resultado.getInt(1));
                aux.setDni(resultado.getInt(2));
                aux.setApellido(resultado.getString(3));
                aux.setNombre(resultado.getString(4));
                // Crear un objeto Date SQL
                java.sql.Date fechaSQL = resultado.getDate(5);
                // Se creal localDate con los valores
                LocalDate localDate = fechaSQL.toLocalDate();
                // Se setea la fecha al alumno a retornar
                aux.setFechaNacimiento(localDate);
                aux.setEstado(true);
                listaAlumnoARetornar.add(aux);
            }
            desconectarBaseDatos();
            return listaAlumnoARetornar;
        } catch (Exception e) {
            desconectarBaseDatos();
            throw e;
        }
     }
     public void coneccionBaseDatos() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDatos = "jdbc:mariadb://localhost:3306/" + DATABASE + "?zeroDateTimeBehavior=convertToNull";
            coneccion = DriverManager.getConnection(urlBaseDatos, USER, PASSWORD);
            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
     }
        @Override
      public void consultarBaseDatos(String sql) throws Exception {
        try {
            coneccionBaseDatos();
            sentencia = coneccion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
