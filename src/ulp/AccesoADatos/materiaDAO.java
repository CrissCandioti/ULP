/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ulp.Entidades.materia;

/**
 * La clase materiaDAO tiene las mismas caracteristicas que la clase alumnoDAO.
 * Ambas heredan las variables y los metodos de DAO, ambas son clases final, y
 * ambas tienen metodos parecidos con ligeras diferencias en los comandos de los
 * metodos.
 *
 */
public final class materiaDAO extends DAO {

    public void guardarMateria(materia aux, int index) {
        try {
            String sql = "INSERT INTO `materia`(`nombre`, `año`, `estado`) VALUES ('" + aux.getNombre() + "','" + aux.getAño() + "', " + index + " )";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar guardar la materia en la base de datos");
        }
    }

    public materia buscarMateria(int id) throws Exception {
        try {
            String sql = "SELECT `idMateria`, `nombre`, `año`, `estado` FROM `materia` WHERE idMateria = " + id;
            consultarBaseDatos(sql);
            materia aux = null;
            boolean estado = false;
            while (resultado.next()) {
                aux = new materia();
                aux.setIdMateria(resultado.getInt(1));
                aux.setNombre(resultado.getString(2));
                aux.setAño(resultado.getInt(3));
                if (resultado.getInt(4) == 0) {
                    estado = false;
                } else if (resultado.getInt(4) == 1) {
                    estado = true;
                }
                aux.setEstado(estado);
            }
            desconectarBaseDatos();
            return aux;
        } catch (Exception e) {
            desconectarBaseDatos();
            JOptionPane.showMessageDialog(null, "Se produjo un error al buscar la materia en la base de datos");
        }
        return null;
    }

    public void modificarMateria(materia aux, int index) {
        try {
            String sql = "UPDATE `materia` SET `nombre`='" + aux.getNombre() + "',`año`='" + aux.getAño() + "',`estado`='" + index + "' WHERE idMateria = " + aux.getIdMateria();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al modificar la materia en la base de datos");
        }
    }

    public void eliminarMateria(int id) {
        try {
            String sql = "UPDATE `materia` SET `estado`= 0 WHERE idMateria = " + id;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar eliminar la materia seleccionada en la base de datos");
        }
    }

    public ArrayList<materia> listarMateria() {
        try {
            String sql = "SELECT `idMateria`, `nombre`, `año`, `estado` FROM `materia`";
            consultarBaseDatos(sql);
            ArrayList<materia> listaMateriaARetornar = new ArrayList<>();
            materia aux = null;
            boolean estado = false;
            while (resultado.next()) {
                aux = new materia();
                aux.setIdMateria(resultado.getInt(1));
                aux.setNombre(resultado.getString(2));
                aux.setAño(resultado.getInt(3));
                if (resultado.getInt(4) == 1) {
                    estado = true;
                } else if (resultado.getInt(4) == 0) {
                    estado = false;
                }
                aux.setEstado(estado);
                listaMateriaARetornar.add(aux);
            }
            desconectarBaseDatos();
            return listaMateriaARetornar;
        } catch (Exception e) {
            desconectarBaseDatos();
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar traer todas las materias de la base de datos");
        }
        return null;
    }
}
