/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp;

import ulp.Vistas.Principal;

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
            Principal p = new Principal();
            p.setVisible(true);
            p.setLocationRelativeTo(null);
        } catch (Exception e) {
        }
    }
}
