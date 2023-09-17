/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.time.LocalDate;
import java.util.ArrayList;
import ulp.Entidades.alumno;

/**
 *
 * @author criss
 */
public final class alumnoDAO extends DAO {

    public void guardarAlumno(alumno aux, int index) throws Exception {
        try {
            String sql = "INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES ('" + aux.getDni() + "','" + aux.getApellido() + "','" + aux.getNombre() + "','" + aux.getFechaNacimiento() + "', " + index + ")";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarEliminarAlumno(int id) throws Exception {
        try {
            String sql = "UPDATE `alumno` SET `estado`= 0 WHERE idAlumno = " + id;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public alumno buscarAlumnoPorID(int id) throws Exception {
        try {
            String sql = "SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado` FROM `alumno` WHERE idAlumno = " + id;
            consultarBaseDatos(sql);
            alumno aux = null;
            boolean estado = false;
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
                if (resultado.getInt(6) == 0) {
                    estado = false;
                } else if (resultado.getInt(6) == 1) {
                    estado = true;
                }
                aux.setEstado(estado);
            }
            desconectarBaseDatos();
            return aux;
        } catch (Exception e) {
            desconectarBaseDatos();
            throw e;
        }
    }

    public alumno buscarAlumnoPorDNI(int dni) throws Exception {
        try {
            String sql = "SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado` FROM `alumno` WHERE dni = " + dni;
            consultarBaseDatos(sql);
            alumno aux = null;
            boolean estado = false;
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
                if (resultado.getInt(6) == 0) {
                    estado = false;
                } else if (resultado.getInt(6) == 1) {
                    estado = true;
                }
                aux.setEstado(estado);
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
            String sql = "SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado` FROM `alumno` ";
            consultarBaseDatos(sql);
            ArrayList<alumno> listaAlumnoARetornar = new ArrayList<>();
            alumno aux = null;
            boolean estado = false;
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
                if (resultado.getInt(6) == 0) {
                    estado = false;
                } else if (resultado.getInt(6) == 1) {
                    estado = true;
                }
                aux.setEstado(estado);
                listaAlumnoARetornar.add(aux);
            }
            desconectarBaseDatos();
            return listaAlumnoARetornar;
        } catch (Exception e) {
            desconectarBaseDatos();
            throw e;
        }
    }

    public void modificarAlumno(alumno aux, int index) throws Exception {
        try {
            String sql = "UPDATE `alumno` SET `dni`='" + aux.getDni() + "',`apellido`='" + aux.getApellido() + "',`nombre`='" + aux.getNombre() + "',`fechaNacimiento`='" + aux.getFechaNacimiento() + "',`estado`='" + index + "' WHERE idAlumno = " + aux.getIdAlumno();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
