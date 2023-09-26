/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ulp.Entidades.materia;
import ulp.Service.materiaService;

/**
 *
 * @author Cristian
 */
public class TodasMaterias extends javax.swing.JInternalFrame {

    /**
     * Creates new form TodasMaterias
     */
    public TodasMaterias() {
        initComponents();
        llenarTodasLasMaterias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Materias Registradas");
        setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/materia.jpg"))); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Todas Las Materias Registradas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 23, -1, 29));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 84, 447, 10));

        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaMaterias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 106, -1, 332));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 444, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ulp.notas (600x600).jpg"))); // NOI18N
        lblFondo.setText("jLabel2");
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTable tablaMaterias;
    // End of variables declaration//GEN-END:variables
 
    public void llenarTodasLasMaterias() {
        try {

            materiaService ma = new materiaService();
            //Guardo el arraylist que me retorna en una variable para usar luego la variable 
            //y no se esté conectando y desconectando de la base de datos si llamo al metodo varias veces
            ArrayList materias = ma.listarMateria();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Año");
            modelo.addColumn("estado");
            tablaMaterias.setModel(modelo);

            for (Object object : materias) {
                System.out.println(object);
            }
            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.

            Object mate[] = null;
            for (int i = 0; i < materias.size(); i++) {
                modelo.addRow(mate);
                materia getm = (materia) materias.get(i);
                modelo.setValueAt(getm.getIdMateria(), i, 0);
                modelo.setValueAt(getm.getNombre(), i, 1);
                modelo.setValueAt(getm.getAño(), i, 2);
                modelo.setValueAt(getm.isEstado(), i, 3);

            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Inhabilitamos temporalmente el acceso a todas las materias");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
