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
 * La clase inscripcionService al igual que las clases alumnoSerices y
 * materiaServices estan en constante comunicacion con el paquete vista y el
 * paquete acceso a datos. Esta clase al igual que las anteriores reciben la
 * informacion de las vista realizan una serie de trabajos programados y se
 * comunica con ServiceDAO la cual le envia los datos corroborados.
 *
 */
public class inscripcionService {

    /*
     * Este metodo crea una inscripcion, dentro del metodo tendremos las
     * instanciaciones de alumnoSerivce,materiaService y con la comunicacion a
     * base de datos inscripcionDAO
     */
    public void crearInscripcion(double nota, int id_Alumno, int id_Materia) {
        try {
            /**
             * Esta restriccion creada realiza el trabajo que el alumno no se
             * vuelva a inscribir a esa materia que ya esta inscripto.
             */
            for (inscripcion aux : obtenerInscripciones()) {
                if (aux.getIdAlumno().getIdAlumno() == id_Alumno && aux.getIdMateria().getIdMateria() == id_Materia) {
                    JOptionPane.showMessageDialog(null, "El alumno ya esta inscripto a esa materia");
                    return;
                }
            }
            /**
             * Se crean las instanciaciones.
             */
            alumnoService as = new alumnoService();
            materiaService ms = new materiaService();
            inscripcionDAO dao = new inscripcionDAO();
            /**
             * Se crea e instancia un alumno y una materia.
             */
            alumno aux = new alumno();
            materia index = new materia();
            /**
             * Este metodo por medio de las vistas recibe por parametro un
             * numero entero llamado ID alumno y otro numero entero llamado ID
             * materia; la cual utilizaremos para buscar con los metodos de
             * alumnoService y materiaService y lo setearemos al alumno y
             * materia anteriormente creado.
             */
            aux = as.buscarAlumnoPorID(id_Alumno);
            index = ms.buscarMateria(id_Materia);
            /**
             * Se crea e instancia una inscripcion seteandole todos los valores
             * obtenidos.
             */
            inscripcion ex = new inscripcion();
            ex.setNota(nota);
            ex.setIdAlumno(aux);
            ex.setIdMateria(index);
            dao.guardarInscripcion(ex);
            JOptionPane.showMessageDialog(null, "Alumno Inscripto");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tuvimos incovenientes al crear la inscripcion");
        }
    }

    /*
     * //Este metodo se encarga de retornar toda la lista de inscripciones.
     */
    public ArrayList<inscripcion> obtenerInscripciones() {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerInscripcion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos obtener las inscripciones");
        }
        return null;
    }

    /*
     * Este metodo se encarga de retornar todas las inscripciones que tiene
     * un alumno en concreto.
     */
    public ArrayList<inscripcion> obtenerInscripcionPorAlumno(int id_Alumno) {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerInscripcionPorAlumno(id_Alumno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No pudimos obtener las incripciones del alumno solicitado");
        }
        return null;
    }

    /*
     * //Este metodo retorna una lista de las materias que el alumno esta
     * cursando actualmente.
     */
    public ArrayList<materia> obtenerMateriaCursadas(int idAlumno) {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerMateriaCursadas(idAlumno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No pudimos obtener las materias no cursadas");
        }
        return null;
    }

    /*
     * Este metodo retorna una lista de todas las materias que el alumno no esta
     * inscripto.
     */
    public ArrayList<materia> obtenerMateriaNoCursadas(int idAlumno) {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerMateriaNoCursada(idAlumno);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Tuvimos un error al intentar obtener las materias no cursadas");
        }
        return null;
    }

    /*
     * Este metodo recibe por parametros el id del alumno y materia para
     * efectuar la eliminacion de la inscripcion.
     */
    public void borrarInscripcionAlumnoMateria(int idAlumno, int idMateria) {
        try {
            /**
             * Se necesita actualizar la tabla para esta opcion.
             */
            inscripcionDAO dao = new inscripcionDAO();
            dao.borrarInscripcionAlumnoMateria(idAlumno, idMateria);
            JOptionPane.showMessageDialog(null, "Anulamos con exito la incripcion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No pudimos borrar la inscripcion solicitada");
        }
    }

    /*
     * Este metodo recibe por parametro el id del alumno, la materia y la nota a
     * modificar, la cual le enviara esta informacion a inscripcionDAO
     * actualizarNota
     */
    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            dao.actualizarNota(idAlumno, idMateria, nota);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Tuvimos problemas al intentar actualizar la nota");
        }
    }

    /*
     * Este metodo se encarga de obtener todos los alumnos que estan inscripto a
     * esa materia en especifico.
     */
    public ArrayList<alumno> obtenerAlumnoPorMateria(int idMateria) {
        try {
            inscripcionDAO dao = new inscripcionDAO();
            return dao.obtenerAlumnoPorMateria(idMateria);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tuvimos un problema al intentar obtener las materias del alumno");
        }
        return null;
    }
}
