/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Service;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ulp.AccesoADatos.materiaDAO;
import ulp.Entidades.materia;

/**
 *
 * @author criss
 */
public class materiaService {

    public void guardarMateria(String nombre, int año, boolean estado) {
        try {
            /**
             * Comprueba si el primer carácter es un dígito numérico (0-9)
             */
            char primerCaracter = nombre.charAt(0);
            if (Character.isDigit(primerCaracter)) {
                JOptionPane.showMessageDialog(null, "El nombre no puede comenzar con numeros");
                return;
            }
            if (nombre.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre de la materia no debe contener menos de 3 caracteres");
                return;
            }
            if (año <= 0) {
                JOptionPane.showMessageDialog(null, "El año no puede ser 0 o menor");
                return;
            }
            materiaDAO dao = new materiaDAO();
            materia aux = new materia();
            aux.setNombre(nombre);
            aux.setAño(año);
            aux.setEstado(estado);
            int index = 0;
            if (estado == true) {
                index = 1;
            } else if (estado == false) {
                index = 0;
            }
            dao.guardarMateria(aux, index);
            JOptionPane.showMessageDialog(null, "Se guardo con exito la materia");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar guardar la materia");
        }
    }

    public materia buscarMateria(int id) {
        try {
            materiaDAO dao = new materiaDAO();
            return dao.buscarMateria(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar buscar la materia");
        }
        return null;
    }

    public void modificarMateria(int idMateria, String nombre, int año, boolean estado) {
        try {
            char primerCaracter = nombre.charAt(0);
            if (Character.isDigit(primerCaracter)) {
                JOptionPane.showMessageDialog(null, "El nuevo nombre no puede comenzar con numeros");
                return;
            }
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nuevo nombre de la materia no puede estar vacio");
                return;
            }
            if (nombre.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nuevo nombre de la materia no puede tener menos de 3 caracteres");
                return;
            }
            if (año <= 0) {
                JOptionPane.showMessageDialog(null, "El nuevo año no puede ser 0 o menor");
                return;
            }
            materiaDAO dao = new materiaDAO();
            materia aux = new materia();
            aux.setIdMateria(idMateria);
            aux.setNombre(nombre);
            aux.setAño(año);
            aux.setEstado(estado);
            int index = 0;
            if (estado == true) {
                index = 1;
            } else if (estado == false) {
                index = 0;
            }
            dao.modificarMateria(aux, index);
            JOptionPane.showMessageDialog(null, "Se modifico con exito la materia seleccionada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar modificar la materia");
        }
    }

    public void eliminarMateria(int id) {
        try {
            if (buscarMateria(id).isEstado() == false) {
                JOptionPane.showMessageDialog(null, "La materia seleccionada ya fue eliminada");
                return;
            }
            materiaDAO dao = new materiaDAO();
            dao.eliminarMateria(id);
            JOptionPane.showMessageDialog(null, "Materia Eliminada");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No pudimos eliminar la materia seleccionada");
        }
    }

    public ArrayList<materia> listarMateria() {
        try {
            materiaDAO dao = new materiaDAO();
            return dao.listarMateria();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar obtener la lista de materias");
        }
        return null;
    }

}
