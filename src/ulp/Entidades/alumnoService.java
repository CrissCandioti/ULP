/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Entidades;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import ulp.AccesoADatos.alumnoDAO;

/**
 *
 * @author criss
 */
public class alumnoService {

    public void crearAlumno(int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) throws NumberFormatException, NullPointerException, DateTimeException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            alumno aux = new alumno();
            aux.setDni(dni);
            aux.setApellido(apellido);
            aux.setNombre(nombre);
            aux.setFechaNacimiento(fechaNacimiento);
            aux.setEstado(estado);
            int index = 0;
            if (estado == true) {
                index = 1;
            } else if (estado == false) {
                index = 0;
            }
            dao.guardarAlumno(aux, index);
        } catch (NumberFormatException a) {
            throw new NumberFormatException("Ingrese los numero correspondientes");
        } catch (NullPointerException b) {
            throw new NullPointerException("No deje ninguna celda vacia");
        } catch (DateTimeException c) {
            throw new DateTimeException("Error al analizar la fecha");
        } catch (Exception e) {
            throw new Exception("Ingrese correctamente los datos");
        }
    }

    public void eliminarAlumno(int id) throws NumberFormatException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            dao.eliminarEliminarAlumno(id);
        } catch (NumberFormatException f) {
            throw new NumberFormatException("Ingrese correctamente el ID");
        } catch (Exception e) {
            throw e;
        }
    }

    public alumno buscarAlumnoPorID(int id) throws NumberFormatException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            return dao.buscarAlumnoPorID(id);
        } catch (NumberFormatException f) {
            throw new NumberFormatException("Ingrese el id correspondiente para buscar al alumno");
        } catch (Exception e) {
            throw e;
        }
    }

    public alumno buscarAlumnoPorDNI(int dni) throws NumberFormatException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            return dao.buscarAlumnoPorDNI(dni);
        } catch (NumberFormatException f) {
            throw new NumberFormatException("Ingrese el DNI correspondiente para buscar al alumno deseado");
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<alumno> listarAlumno() throws Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            return dao.listarAlumno();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarAlumno(int id,int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) throws NumberFormatException, NullPointerException, DateTimeException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            alumno aux = new alumno();
            aux.setIdAlumno(id);
            aux.setDni(dni);
            aux.setApellido(apellido);
            aux.setNombre(nombre);
            aux.setFechaNacimiento(fechaNacimiento);
            aux.setEstado(estado);
            int index = 0;
            if (estado == true) {
                index = 1;
            } else if (estado == false) {
                index = 0;
            }
            dao.modificarAlumno(aux, index);
        } catch (NumberFormatException a) {
            throw new NumberFormatException("Ingrese los numero correspondientes para su modificacion");
        } catch (NullPointerException b) {
            throw new NullPointerException("No deje ninguna celda vacia");
        } catch (DateTimeException c) {
            throw new DateTimeException("Error al analizar la fecha");
        } catch (Exception e) {
            throw new Exception("Ingrese correctamente los datos para su modificacion");
        }
    }
}
