/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Service;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ulp.AccesoADatos.inscripcionDAO;
import ulp.Entidades.alumno;
import ulp.Entidades.inscripcion;
import ulp.Entidades.materia;

/**
 *
 * @author criss
 */
public class inscripcionService {

    public void crearInscripcion(int nota, int id_Alumno, int id_Materia) throws NumberFormatException, NullPointerException, Exception {
        try {
            for (inscripcion aux : obtenerInscripciones()) {
                if (aux.getIdAlumno().getIdAlumno() == id_Alumno && aux.getIdMateria().getIdMateria() == id_Materia) {
                    JOptionPane.showMessageDialog(null, "El alumno ya esta inscripto a esa materia");
                    return;
                }
            }
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
            JOptionPane.showMessageDialog(null, "Alumno Inscripto");
        } catch (Exception e) {
            throw e;
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
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<materia> obtenerMateriaCursadas(int idAlumno) throws NumberFormatException, NullPointerException, Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerMateriaCursadas(idAlumno);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<materia> obtenerMateriaNoCursadas(int idAlumno) throws NumberFormatException, Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerMateriaNoCursada(idAlumno);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void borrarInscripcionAlumnoMateria(int idAlumno, int idMateria) throws NumberFormatException, Exception {
        try {
            //Se necesita actualizar la tabla para esta opcion.
            inscripcionDAO dao = new inscripcionDAO();
            dao.borrarInscripcionAlumnoMateria(idAlumno, idMateria);
            JOptionPane.showMessageDialog(null, "Anulamos con exito la incripcion");
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, int nota) throws NumberFormatException, Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            dao.actualizarNota(idAlumno, idMateria, nota);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<alumno> obtenerAlumnoPorMateria(int idMateria) throws Exception {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerAlumnoPorMateria(idMateria);
        } catch (Exception e) {
            throw e;
        }
    }
}
