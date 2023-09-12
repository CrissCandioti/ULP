/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Entidades;

import java.util.ArrayList;
import ulp.AccesoADatos.inscripcionDAO;
import ulp.AccesoADatos.materiaDAO;

/**
 *
 * @author criss
 */
public class inscripcionService {

    public void crearInscripcion(int nota, int id_Alumno, int id_Materia) throws NumberFormatException, NullPointerException, Exception {
        try {
            alumnoService as = new alumnoService();
            materiaService ms = new materiaService();
            inscripcionDAO dao = new inscripcionDAO();
            alumno aux = new alumno();
            materia index = new materia();
            aux = as.buscarAlumnoPorID(id_Alumno);
            index = ms.buscarMateria(id_Materia);
            inscripcion ex = new inscripcion();
            ex.setNota(nota);
            ex.setIdAlumno(aux);
            ex.setIdMateria(index);
            dao.guardarInscripcion(ex);
        } catch (NumberFormatException a) {
            throw new NumberFormatException("Ingrese los numero correspondientes");
        } catch (NullPointerException b) {
            throw new NullPointerException("No deje ninguna celda vacia");
        } catch (Exception e) {
            throw new Exception("Ingrese correctamente los datos");
        }
    }

    public ArrayList<inscripcion> obtenerInscripciones() throws Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerInscripcion();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<inscripcion> obtenerInscripcionPorAlumno(int id_Alumno) throws NumberFormatException, Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerInscripcionPorAlumno(id_Alumno);
        } catch (NumberFormatException f) {
            throw new NumberFormatException("Ingrese el id del alumno correspondiente");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<materia> obtenerMateriaCursadas(int idAlumno) throws NumberFormatException, Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerMateriaCursadas(idAlumno);
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<materia> obtenerMateriaNoCursadas(int idAlumno) throws NumberFormatException, Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerMateriaNoCursada(idAlumno);
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
