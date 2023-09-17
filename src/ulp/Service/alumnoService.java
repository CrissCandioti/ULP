/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ulp.AccesoADatos.alumnoDAO;
import ulp.Entidades.alumno;

/**
 *
 * @author criss
 */
public class alumnoService {

    public void crearAlumno(int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) throws NumberFormatException, NullPointerException, DateTimeException, Exception {
        try {
            int dniReglamentarioMinimo = 1234567;
            int dniReglamentarioMaximo = 123456789;
            LocalDate mayorEdad = LocalDate.of(2005, 01, 01);

            String cadenaDni = Integer.toString(dni);
            String cadenaDniReglamentarioMinimo = Integer.toString(dniReglamentarioMinimo);
            String cadenaDniReglamentarioMaximo = Integer.toString(dniReglamentarioMaximo);
            boolean limiteEdad = fechaNacimiento.isAfter(mayorEdad);

            if (buscarAlumnoPorDNI(dni) != null) {
                JOptionPane.showMessageDialog(null, "Tenemos registrado un alumno con el documento ingresado");
                return;
            }
            if (nombre.length() < 3 || apellido.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre u apellido no pueden tener menos de 3 caracteres");
                return;
            }
            if (cadenaDni.length() < cadenaDniReglamentarioMinimo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es menor al reglamentario");
                return;
            }
            if (cadenaDni.length() > cadenaDniReglamentarioMaximo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es mayor al reglamentario");
                return;
            }
            if (limiteEdad == true) {
                JOptionPane.showMessageDialog(null, "Eres menor de edad para proseguir con el registro de inscripcion");
                return;
            }

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
            JOptionPane.showMessageDialog(null, "El alumno fue registrado correctamente");
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarAlumno(int id) throws NumberFormatException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            if (dao.buscarAlumnoPorID(id).isEstado() == false) {
                JOptionPane.showMessageDialog(null, "El alumno ya fue dado de baja");
                return;
            }
            dao.eliminarEliminarAlumno(id);
            JOptionPane.showMessageDialog(null, "Alumno fue dado de baja exitosamente");
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

    public alumno buscarAlumnoPorDNI(int dni) throws Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            return dao.buscarAlumnoPorDNI(dni);
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

    public void modificarAlumno(int id, int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) throws NumberFormatException, NullPointerException, DateTimeException, Exception {
        try {
            int dniReglamentarioMinimo = 1234567;
            int dniReglamentarioMaximo = 123456789;
            LocalDate mayorEdad = LocalDate.of(2005, 01, 01);

            String cadenaDni = Integer.toString(dni);
            String cadenaDniReglamentarioMinimo = Integer.toString(dniReglamentarioMinimo);
            String cadenaDniReglamentarioMaximo = Integer.toString(dniReglamentarioMaximo);
            boolean limiteEdad = fechaNacimiento.isAfter(mayorEdad);

            if (buscarAlumnoPorDNI(dni) != null && buscarAlumnoPorDNI(dni).getDni() != dni) {
                JOptionPane.showMessageDialog(null, "Tenemos registrado un alumno con el documento ingresado");
                JOptionPane.showMessageDialog(null, "Recuerde ingresar correctamente el documento para su modificacion");
                return;
            }
            if (nombre.length() < 3 || apellido.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre u apellido no pueden tener menos de 3 caracteres");
                JOptionPane.showMessageDialog(null, "Debe tener presente el respetar los caracteres reglamentarios para su modificacion");
                return;
            }
            if (cadenaDni.length() < cadenaDniReglamentarioMinimo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es menor al reglamentario");
                return;
            }
            if (cadenaDni.length() > cadenaDniReglamentarioMaximo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es mayor al reglamentario");
                return;
            }
            if (limiteEdad == true) {
                JOptionPane.showMessageDialog(null, "Eres menor de edad para proseguir con el registro de inscripcion");
                return;
            }

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
            JOptionPane.showMessageDialog(null, "Se modifico exitosamente el alumno");
        } catch (Exception e) {
            throw e;
        }
    }
}
