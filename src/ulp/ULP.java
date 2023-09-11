/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp;

import java.time.LocalDate;
import ulp.Entidades.alumnoService;
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
            as.modificarAlumno(6, 10, "PACO", "MERLO", LocalDate.now(), true);
            materiaService ms = new materiaService();
        } catch (Exception e) {
        }
    }

}
