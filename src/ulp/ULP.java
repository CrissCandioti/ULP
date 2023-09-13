/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp;

import java.time.LocalDate;
import ulp.Entidades.alumnoService;
import ulp.Entidades.inscripcionService;
import ulp.Entidades.materiaService;

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
            alumnoService as = new alumnoService();
            materiaService ms = new materiaService();
            inscripcionService is = new inscripcionService();
        } catch (Exception e) {
        }
    }
}
