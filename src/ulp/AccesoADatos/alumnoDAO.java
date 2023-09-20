/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ulp.Entidades.alumno;

/**
 * Las clases de entidades DAO heredan los metodos de DAO,la cual consiste en la
 * coneccion a la base de datos, la desconecion a la base de datos, y los
 * metodos de consultas propios de DAO. Esta clase ademas de heredar se declara
 * como "final", debido a que no queremos que continue con la jerarquia de la
 * herencia. Esta clase de alumnoDAO va a contener los metodos necesarios para
 * la comunicacion de la base de datos por medio de los propios comandos.
 *
 */
public final class alumnoDAO extends DAO {
//El metodo guardarAlumno es la encargadar de comunicarse con la base de datos,
//realizar el comando para insertar y llamar al metodo insertarModificarEliminarBaseDatos
//de la clase que hereda.    

    public void guardarAlumno(alumno aux, int index) {
        try {
            String sql = "INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES ('" + aux.getDni() + "','" + aux.getApellido() + "','" + aux.getNombre() + "','" + aux.getFechaNacimiento() + "', " + index + ")";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar guardar el alumno en la base de datos");
        }
    }
//El metodo eliminarEliminarAlumno recibe por parametro un dato entero llamado id
//este metodo se encarga de eliminar el alumno pero no fisicamente sino seteando su estado.    

    public void eliminarEliminarAlumno(int id) {
        try {
            String sql = "UPDATE `alumno` SET `estado`= 0 WHERE idAlumno = " + id;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar eliminar en la base de datos");
        }
    }
//Este metodo recibe por parametro un dato entero llamado id, la cual se encarga de
//buscar al alumno y retornarlo.    
    public alumno buscarAlumnoPorID(int id) {
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
//Este condicional if se creo para crear el tipo de dato correspondiente de la variable estado de la entidad alumno
//En nuestra base de datos el estado es un dato entero y varia entre 1 y 0.
//La entidad alumno la variable estado es de tipo boolean que varia entre true y false.
                if (resultado.getInt(6) == 0) {
                    estado = false;

                } else if (resultado.getInt(6) == 1) {
                    estado = true;
                }
                aux.setEstado(estado);

            }
//Una vez realizada la consulta y tomado los datos correspondientes nos desconectamos de la base de datos.            
            desconectarBaseDatos();
            return aux;
        } catch (Exception e) {
//Si se produce una excepcion primero nos desconectamos de la base de datos, luego mostramos el error producido.            
            desconectarBaseDatos();
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar el alumno por ID en la base de datos");
        }
        return null;
    }
//Este metodo es muy parecido al anterior con la modificacion que el comando busca al alumno por medio del documento
    public alumno buscarAlumnoPorDNI(int dni) {
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
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar el alumno por DNI en la base de datos");
        }
        return null;
    }
//Este metodo me retorna una lista de alumno, sean con estado activo o inactivo la lista me mostrara a todos los alumnos.
    public ArrayList<alumno> listarAlumno() {
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
            JOptionPane.showMessageDialog(null, "No pudimos reornar ningun alumno de la base de datos");
        }
        return null;
    }
//Este metodo se encarga de actualizar o mejor dicho modificar el alumno que esta en la base de datos.
//La principal diferencia con respecto al metodo guardarAlumno es que el comando usa un UPDATE y no insert into.    
    public void modificarAlumno(alumno aux, int index) {
        try {
            String sql = "UPDATE `alumno` SET `dni`='" + aux.getDni() + "',`apellido`='" + aux.getApellido() + "',`nombre`='" + aux.getNombre() + "',`fechaNacimiento`='" + aux.getFechaNacimiento() + "',`estado`='" + index + "' WHERE idAlumno = " + aux.getIdAlumno();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tuvimos un incoveniente al modificar el alumno en la base de datos");
        }
    }
}
