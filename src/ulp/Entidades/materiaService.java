/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Entidades;

import java.util.ArrayList;
import ulp.AccesoADatos.materiaDAO;

/**
 *
 * @author criss
 */
public class materiaService {

    public void guardarMateria(String nombre, int año, boolean estado) throws NumberFormatException, NullPointerException, Exception {
        try {
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
        } catch (NumberFormatException a) {
            throw new NumberFormatException("Ingrese el año correctamente");
        } catch (NullPointerException b) {
            throw new NullPointerException("Ingrese el nombre de la materia correctamente");
        } catch (Exception e) {
            throw e;
        }
    }

    public materia buscarMateria(int id) throws NumberFormatException, Exception {
        try {
            materiaDAO dao = new materiaDAO();
            return dao.buscarMateria(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ingrese el ID correspondiente para buscar su materia");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificarMateria(int idMateria, String nombre, int año, boolean estado) throws NumberFormatException, NullPointerException, Exception {
        try {
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
        } catch (NumberFormatException a) {
            throw new NumberFormatException("Ingrese los datos numericos correctos");
        } catch (NullPointerException b) {
            throw new NullPointerException("Ingrese el nombre de la materia correctamente");
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarMateria(int id) throws NumberFormatException, Exception {
        try {
            materiaDAO dao = new materiaDAO();
            dao.eliminarMateria(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Introduce el ID correctamente para eliminar la materia deseada");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<materia> listarMateria() throws Exception {
        try {
            materiaDAO dao = new materiaDAO();
            return dao.listarMateria();
        } catch (Exception e) {
            throw e;
        }
    }

}
