/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ulp.Entidades.alumno;
import ulp.Service.alumnoService;
import ulp.Entidades.inscripcion;
import ulp.Entidades.materia;
import ulp.Service.materiaService;

/**
 * La clase inscripcionDAO se encarga de la relaciones entre entre las dos
 * entidades creadas con anterioridad, las cuales son alumno y materia. Al igual
 * que las otras clases DAO esta hereda las variables y metodos de su clase
 * padre que es DAO.
 *
 */
public final class inscripcionDAO extends DAO {
//Este metodo utiliza los comandos correspondientes para guardar la inscripcion que previamente fue creada y la recibe por medio de parametro.

    public void guardarInscripcion(inscripcion aux) {
        try {
            String sql = "INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`) VALUES ('" + aux.getNota() + "','" + aux.getIdAlumno().getIdAlumno() + "','" + aux.getIdMateria().getIdMateria() + "')";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No pudimos guardar la inscripcion en la base de datos");
        }
    }
//Este metodo retorna la lista de inscripciones realizadas. En su interior contiene instanciaciones de las clases
//services de alumno y materia, la cual van a utilizar sus metodos propios para encontrar y retornar la materia 
//u alumno de la relacion establecida.    

    public ArrayList<inscripcion> obtenerInscripcion() {
        try {
            //Se crean las instancias de alumnoService y materiaSerivce
            alumnoService as = new alumnoService();
            materiaService ms = new materiaService();
            //Se realiza el comando correspondiente para traer de la base de datos la informacion
            String sql = "SELECT `idInscripto`, `nota`, `idAlumno`, `idMateria` FROM `inscripcion`";
            //Se realiza la consulta a la base de datos.
            consultarBaseDatos(sql);
            //Se crea el arrayList que va a contener la informacion a retornar.
            ArrayList<inscripcion> obtenerListaIncripcionesARetornar = new ArrayList<>();
            //Se crea pero se iguala a null una inscripcion.
            inscripcion aux = null;
            //Se crea un bucle while para recorrer la informacion y obtener los datos.
            while (resultado.next()) {
                //A la inscripcion creada anteriormente la hacemos nacer para comenzar a setearles los datos.    
                aux = new inscripcion();
                aux.setIdInscripto(resultado.getInt(1));
                aux.setNota(resultado.getInt(2));
                //Debido a que nuestra base de datos contiene un tipo de dato entero con el ID del alumno.
                //Se crea una variable tomando ese datos.
                Integer idAlumno = resultado.getInt(3);
                //Luego creamos ese alumno y utilizamos a alumnoService para que lo busque y lo traiga.    
                alumno alumno = as.buscarAlumnoPorID(idAlumno);
                //Una vez encontrado lo seteamos.
                //Debido a que nuestra arrayList debe contener inscripciones, estas inscripciones contiene a un alumno
                //y no a un tipo de dato entero llamado ID que es lo que extraemos de la base de datos.
                aux.setIdAlumno(alumno);
                //El proceso con alumno se vuelve a repetir con materia.    
                Integer idMateria = resultado.getInt(4);
                materia materia = ms.buscarMateria(idMateria);
                aux.setIdMateria(materia);
                obtenerListaIncripcionesARetornar.add(aux);
            }
            //Una vez finalizado nos desconectamos a la base de datos.
            desconectarBaseDatos();
            //Retornamos la lista de inscripciones que creamos al inicio del metodo.
            return obtenerListaIncripcionesARetornar;
        } catch (Exception e) {
            desconectarBaseDatos();
            JOptionPane.showMessageDialog(null, "No pudimos obtener la inscripcion de la base de datos");
        }
        return null;
    }
//Este metodo se encarga de retornar un arrayList con todas las incripciones de un unico alumno, la cual 
//resive ese dato por parametro.    

    public ArrayList<inscripcion> obtenerInscripcionPorAlumno(int id_Alumno) {
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
            desconectarBaseDatos();
            JOptionPane.showMessageDialog(null, "No pudimos obtener las inscripciones por alumno de la base de datos");
        }
        return null;
    }
//Este metodo se encarga de retornar una lista de materias con la que esta asociada a ese alumno.
//Para este metodo la consulta que hacemos a la base de datos aplicamos un INNER JOIN.    

    public ArrayList<materia> obtenerMateriaCursadas(int idAlumno) {
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
            desconectarBaseDatos();
            return listaARetornarDeMateriasCursadas;
        } catch (Exception e) {
            desconectarBaseDatos();
            JOptionPane.showMessageDialog(null, "Tuvimos incovenientes al obtener las inscripcion por alumno en la base de datos");
        }
        return null;
    }
//Este metodo actua muy similar al anterior con la diferencia que dentro del comando que creamos para
//consultar a la base de datos utilizamos un NOT IN, la cual nos retorna una lista de materias que el alumno no esta inscripto.    

    public ArrayList<materia> obtenerMateriaNoCursada(int idAlumno) {
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
            desconectarBaseDatos();
            return listaARetornarDeMateriasNoCursadas;
        } catch (Exception e) {
            desconectarBaseDatos();
            JOptionPane.showMessageDialog(null, "Tuvimos problemas al obtener las materias no cursada en la base de datos");
        }
        return null;
    }
//Este metodo se encarga de eliminar esa relacion, es decir de eliminar la inscripcion.

    public void borrarInscripcionAlumnoMateria(int idAlumno, int idMateria) {
        try {
            String sql = "DELETE FROM `inscripcion` WHERE idAlumno = " + idAlumno + " AND idMateria = " + idMateria + "";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tuvimos un incovenientes al borrar la inscripcion del Alumno sobre la materia deseada en la base de datos");
        }
    }
//Este metodo tiene el trabajo de actualizar la nota de la materia que el alumno se inscribio.
//Dentro de la consulta a la base de datos utilizamos un UPDATE para realizar dicha actualizacion.    

    public void actualizarNota(int idAlumno, int idMateria, int nota) {
        try {
            String sql = "UPDATE `inscripcion` SET `nota` = " + nota + " WHERE idAlumno = " + idAlumno + " AND idMateria = " + idMateria + " ";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tuvimos problemas al intentar actualizar la nota en la base de datos");
        }
    }
//Este metodo actua muy similar a materia por alumno. Este metodo retornara una lista de alumnos que esta inscrito a esa materia.
//Dentro de la consulta que se realiza a la base de datos utilizamos un INNER JOIN    

    public ArrayList<alumno> obtenerAlumnoPorMateria(int idMateria) {
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
            JOptionPane.showMessageDialog(null, "Tuvimos problemas al intentar obtener los alumno por materia en la base de datos");
        }
        return null;
    }
}
