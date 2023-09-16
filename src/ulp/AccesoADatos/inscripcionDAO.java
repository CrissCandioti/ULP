/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.util.ArrayList;
import ulp.Entidades.alumno;
import ulp.Service.alumnoService;
import ulp.Entidades.inscripcion;
import ulp.Entidades.materia;
import ulp.Service.materiaService;

/**
 *
 * @author criss
 */
public final class inscripcionDAO extends DAO {

    public void guardarInscripcion(inscripcion aux) throws Exception {
        try {
            String sql = "INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`) VALUES ('" + aux.getNota() + "','" + aux.getIdAlumno().getIdAlumno() + "','" + aux.getIdMateria().getIdMateria() + "')";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<inscripcion> obtenerInscripcion() throws Exception {
        try {
            alumnoService as = new alumnoService();
            materiaService ms = new materiaService();
            String sql = "SELECT `idInscripto`, `nota`, `idAlumno`, `idMateria` FROM `inscripcion`";
            consultarBaseDatos(sql);
            ArrayList<inscripcion> obtenerListaIncripcionesARetornar = new ArrayList<>();
            inscripcion aux = null;
            while (resultado.next()) {
                aux = new inscripcion();
                aux.setIdInscripto(resultado.getInt(1));
                aux.setNota(resultado.getInt(2));
                Integer idAlumno = resultado.getInt(3);
                alumno alumno = as.buscarAlumnoPorID(idAlumno);
                aux.setIdAlumno(alumno);
                Integer idMateria = resultado.getInt(4);
                materia materia = ms.buscarMateria(idMateria);
                aux.setIdMateria(materia);
                obtenerListaIncripcionesARetornar.add(aux);
            }
            desconectarBaseDatos();
            return obtenerListaIncripcionesARetornar;
        } catch (Exception e) {
            desconectarBaseDatos();
            throw e;
        }
    }

    public ArrayList<inscripcion> obtenerInscripcionPorAlumno(int id_Alumno) throws Exception {
        try {
            String sql = "SELECT `idInscripto`, `nota`, `idAlumno`, `idMateria` FROM `inscripcion` WHERE idAlumno = " + id_Alumno;
            consultarBaseDatos(sql);
            ArrayList<inscripcion> listaInscripcionPorAlumnoARetornar = new ArrayList<>();
            alumnoService as = new alumnoService();
            materiaService ms = new materiaService();
            inscripcion aux = null;
            while (resultado.next()) {
                aux = new inscripcion();
                aux.setIdInscripto(resultado.getInt(1));
                aux.setNota(resultado.getInt(2));
                Integer idAlumno = resultado.getInt(3);
                alumno alumno = as.buscarAlumnoPorID(idAlumno);
                aux.setIdAlumno(alumno);
                Integer idMateria = resultado.getInt(4);
                materia materia = ms.buscarMateria(idMateria);
                aux.setIdMateria(materia);
                listaInscripcionPorAlumnoARetornar.add(aux);
            }
            desconectarBaseDatos();
            return listaInscripcionPorAlumnoARetornar;
        } catch (Exception e) {

            throw e;
        }
    }

    public ArrayList<materia> obtenerMateriaCursadas(int idAlumno) throws Exception {
        try {
            String sql = "SELECT materia.idMateria FROM inscripcion INNER JOIN materia ON inscripcion.idMateria = materia.idMateria WHERE idAlumno = " + idAlumno;
            consultarBaseDatos(sql);
            ArrayList<materia> listaARetornarDeMateriasCursadas = new ArrayList<>();
            materiaService ms = new materiaService();
            while (resultado.next()) {
                Integer idMateria = resultado.getInt(1);
                materia materia = ms.buscarMateria(idMateria);
                listaARetornarDeMateriasCursadas.add(materia);
            }

            return listaARetornarDeMateriasCursadas;
        } catch (Exception e) {

            throw e;
        } finally {
            desconectarBaseDatos();
        }
    }

    public ArrayList<materia> obtenerMateriaNoCursada(int idAlumno) throws Exception {
        try {
            String sql = "SELECT materia.idMateria FROM materia WHERE materia.idMateria NOT IN (SELECT inscripcion.idMateria FROM inscripcion WHERE inscripcion.idAlumno = " + idAlumno + " );";
            consultarBaseDatos(sql);
            ArrayList<materia> listaARetornarDeMateriasNoCursadas = new ArrayList<>();
            materiaService ms = new materiaService();
            while (resultado.next()) {
                Integer idMateria = resultado.getInt(1);
                materia materia = ms.buscarMateria(idMateria);
                listaARetornarDeMateriasNoCursadas.add(materia);
            }

            return listaARetornarDeMateriasNoCursadas;

        } catch (Exception e) {

            throw e;
        }

    }

    public void borrarInscripcionAlumnoMateria(int idAlumno, int idMateria) throws Exception {
        try {
            String sql = "DELETE FROM `inscripcion` WHERE idAlumno = " + idAlumno + " AND idMateria = " + idMateria + "";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, int nota) throws Exception {
        try {
            String sql = "UPDATE `inscripcion` SET `nota` = " + nota + " WHERE idAlumno = " + idAlumno + " AND idMateria = " + idMateria + " ";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<alumno> obtenerAlumnoPorMateria(int idMateria) throws Exception {
        try {
            String sql = "SELECT alumno.idAlumno FROM inscripcion INNER JOIN alumno ON inscripcion.idAlumno = alumno.idAlumno WHERE idMateria = " + idMateria;
            consultarBaseDatos(sql);
            ArrayList<alumno> listaAlumnoPorMateriaARetornar = new ArrayList<>();
            alumnoService as = new alumnoService();
            while (resultado.next()) {
                Integer idAlumno = resultado.getInt(1);
                alumno alumno = as.buscarAlumnoPorID(idAlumno);
                listaAlumnoPorMateriaARetornar.add(alumno);
            }
            desconectarBaseDatos();
            return listaAlumnoPorMateriaARetornar;
        } catch (Exception e) {
            desconectarBaseDatos();
            throw e;
        }
    }
}
