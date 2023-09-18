/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ulp.AccesoADatos.alumnoDAO;
import ulp.Entidades.alumno;

/**
 * El paquete Service contiene las clases alumnoSerice,materiaService e inscripcionService. Estas clases estan en 
 * constante comunicacion con el paquete "Vista" y con el paquete "Acceso a Datos"
 * Estas clases primero reciben los datos obtenidos de las "Vistas", luego cada uno de los metodos ubicados dentro
 * de las clases Services se encargan de analizar y de cumplir las restricciones programas. Una vez de desempeñar con la tarea asignada
 * cada metodo establece una comunicacion con el paquete "Acceso a Datos", la cual se encarga de enviarle esta informacion.
 */
public class alumnoService {

//El metodo "crearAlumno" recibe toda la informacion establecida en la vistas para completar el registro de los alumnos

    public void crearAlumno(int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) throws NumberFormatException, NullPointerException, DateTimeException, Exception {
//Dentro de un bloque try-catch el metodo procede a analizar estos datos con las restricciones,        
        try {
//Se crean dos variables con los nombre dniReglamentarioMinimo y dniReglamentarioMaximo, estas variables de tipo
//de dato entero sirven para la restriccion del documento establecido mas adelante
            int dniReglamentarioMinimo = 1234567;
            int dniReglamentarioMaximo = 123456789;
//Se crea una variable LocalDate la cual se utiliza para la restriccion de la edad, el programa solo admite alumnos
//mayores de 18 años de edad
            LocalDate mayorEdad = LocalDate.of(2005, 01, 01);
//Se procede a pasar el dato dni y las variables cadenaDniReglamentarioMinimo y cadenaDniReglamentarioMaximo a cadena
//de texto para proceder con su restriccion
            String cadenaDni = Integer.toString(dni);
            String cadenaDniReglamentarioMinimo = Integer.toString(dniReglamentarioMinimo);
            String cadenaDniReglamentarioMaximo = Integer.toString(dniReglamentarioMaximo);
            boolean limiteEdad = fechaNacimiento.isAfter(mayorEdad);
//Las restricciones realizada mas adelante se encargan de desempeñar distintas condiciones.
//Esta restriccion se encarga de buscar un dni en la base de datos para no registrar un alumno con ese documento
            if (buscarAlumnoPorDNI(dni) != null) {
                JOptionPane.showMessageDialog(null, "Tenemos registrado un alumno con el documento ingresado");
                return;
            }
//Esta restriccion se encarga de analizar la cantidad de caracteres que se ingresa por el documento.            
            if (cadenaDni.length() > cadenaDniReglamentarioMaximo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es mayor al reglamentario");
                return;
            }
            if (cadenaDni.length() < cadenaDniReglamentarioMinimo.length()) {
                JOptionPane.showMessageDialog(null, "El documento ingresado es menor al reglamentario");
                return;
            }
//Esta restriccion es la encarga de analizar la cantidad minima de caracter que aceptan los datos del nombre y apellido            
            if (nombre.length() < 3 || apellido.length() < 3) {
                JOptionPane.showMessageDialog(null, "El nombre u apellido no pueden tener menos de 3 caracteres");
                return;
            }
//Esta restriccion se encarga de establecer el limite de edad admitida para el registro            
            if (limiteEdad == true) {
                JOptionPane.showMessageDialog(null, "Eres menor de edad para proseguir con el registro de inscripcion");
                return;
            }
//Una vez cumplida las restricciones el metodo se encarga de instanciar un alumno con esos datos obtenidos            
            alumnoDAO dao = new alumnoDAO();
            alumno aux = new alumno();
            aux.setDni(dni);
            aux.setApellido(apellido);
            aux.setNombre(nombre);
            aux.setFechaNacimiento(fechaNacimiento);
            aux.setEstado(estado);
//Debido que nuestra base de datos la variable "estado" solo acepta un numero entero; si es 0 es false y su es 1 es true
//Este condicional if se encarga de analizar el dato boolean "estado" obtenido de la vista y a crea una variable
//de dato entero para enviar a la base de datos el correspondiente
            int index = 0;
            if (estado == true) {
                index = 1;
            } else if (estado == false) {
                index = 0;
            }
//Se establece la comunicacion con el paquete "Acceso a datos" la cual se envia por argumentos el alumno instanciado
//y la variable entero con el dato correcto del estado para registrar en la base de datos
            dao.guardarAlumno(aux, index);
//Por ultimo se muestra un mensaje completando el registro            
            JOptionPane.showMessageDialog(null, "El alumno fue registrado correctamente");
        } catch (Exception e) {
            throw e;
        }
    }

//El metodo eliminarAlumno se encarga de setear el estado del alumno, este no elimina fisicamente el alumno
//sino cambia su estado a inactivo     
    public void eliminarAlumno(int id) throws NumberFormatException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
//Se crea una restriccion encargada de de verificar si el alumno esta inactivo.            
            if (dao.buscarAlumnoPorID(id).isEstado() == false) {
                JOptionPane.showMessageDialog(null, "El alumno ya fue dado de baja");
                return;
            }
//Se establece la comunicacion con "Acceso a Datos" la cual envia por argumento el id recibido para efectuar la baja            
            dao.eliminarEliminarAlumno(id);
            JOptionPane.showMessageDialog(null, "Alumno fue dado de baja exitosamente");
        } catch (Exception e) {
            throw e;
        }
    }
//El metodo buscarAlumnoPorID se encarga de buscar un alumno que recibe por parametro el id, y este retornara al alumno si lo encuentra
    public alumno buscarAlumnoPorID(int id) throws NumberFormatException, Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            return dao.buscarAlumnoPorID(id);
        } catch (Exception e) {
            throw e;
        }
    }
//El metodo buscarAlumnoPorDNI tiene un desempeño similar al metodo anterior con la peculiar diferencia que busca
//a este alumno por el documento    
    public alumno buscarAlumnoPorDNI(int dni) throws Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            return dao.buscarAlumnoPorDNI(dni);
        } catch (Exception e) {
            throw e;
        }
    }
//El metodo listarAlumno se encarga de mostrar a todos los alumno registrados en la base de datos, esten tanto activo como inactivos
    public ArrayList<alumno> listarAlumno() throws Exception {
        try {
            alumnoDAO dao = new alumnoDAO();
            return dao.listarAlumno();
        } catch (Exception e) {
            throw e;
        }
    }
//El metodo modificar tiene un desempeño muy similar al crear alumno,con la diferencia que en la comunicacion con el
//paquete "Acceso a Datos" el metodo que va a recibir toda esta informacion es modificarAlumno y no guardar como en el metodo crearAlumno.    
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

//Cada metodo crea una instancia con su respectiva entidad DAO del paquete "Acceso a datos" para establecer la comunicacion
//y poder llamar a los metodos correspondientes para enviarles la informacion obtenida.