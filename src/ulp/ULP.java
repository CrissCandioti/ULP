/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp;

import ulp.Entidades.inscripcionService;

/**
 *
 * @author criss
 */
public class ULP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            inscripcionService is = new inscripcionService();
            //System.out.println(is.obtenerMateriaCursadas(7));
            is.crearInscripcion(20, 2, 10);
        } catch (Exception e) {
        }
    }
}
