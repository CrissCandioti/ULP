/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.AccesoADatos;

import java.util.ArrayList;
import ulp.Entidades.materia;

/**
 *
 * @author criss
 */
public final class materiaDAO extends DAO {

    public void guardarMateria(materia aux, int index) throws Exception {
        try {
            String sql = "INSERT INTO `materia`(`nombre`, `año`, `estado`) VALUES ('" + aux.getNombre() + "','" + aux.getAño() + "', " + index + " )";
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public materia buscarMateria(int id) throws Exception {
        try {
            String sql = "SELECT * FROM `materia` WHERE idMateria = " + id + " AND estado = 1 ";
            consultarBaseDatos(sql);
            materia aux = null;
            while (resultado.next()) {
                aux = new materia(resultado.getInt(1), resultado.getString(2), resultado.getInt(3), true);
            }
            desconectarBaseDatos();
            return aux;
        } catch (Exception e) {
            desconectarBaseDatos();
            throw e;
        }
    }

    public void modificarMateria(materia aux, int index) throws Exception {
        try {
            String sql = "UPDATE `materia` SET `nombre`='" + aux.getNombre() + "',`año`='" + aux.getAño() + "',`estado`='" + index + "' WHERE idMateria = " + aux.getIdMateria();
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarMateria(int id) throws Exception {
        try {
            String sql = "DELETE FROM `materia` WHERE idMateria = " + id;
            insertarModificarEliminarBaseDatos(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<materia> listarMateria() throws Exception {
        try {
            String sql = "SELECT * FROM `materia`";
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
            throw e;
        }
    }

}
