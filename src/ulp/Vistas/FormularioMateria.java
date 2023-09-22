/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Vistas;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ulp.Entidades.materia;

import ulp.Service.materiaService;

/**
 *
 * @author Cristian
 */
public class FormularioMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioMateria
     */
    public FormularioMateria() {
        initComponents();
        jPanel2.setVisible(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        radioActivo = new javax.swing.JRadioButton();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gestión Materias");
        setFont(new java.awt.Font("Bell MT", 0, 12)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/materia.jpg"))); // NOI18N
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 530));

        jPanel1.setBackground(new java.awt.Color(18, 123, 77));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Materias");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 31, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 69, 388, 10));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Código");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 91, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 137, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Año");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 183, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Estado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 224, -1, -1));

        radioActivo.setText("Activo");
        radioActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioActivoActionPerformed(evt);
            }
        });
        jPanel1.add(radioActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 223, -1, -1));

        txtCodigo.setEditable(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 85, 99, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 131, 286, -1));
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 177, 286, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 85, 98, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 253, 84, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 253, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 253, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 446, -1, -1));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 70, 30));

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
        tablaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMaterias);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 312, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ulp,fondo,forms.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        materiaService m = new materiaService();

        try {
            String nombre = txtNombre.getText();
            int año = Integer.parseInt(txtAnio.getText());
            boolean estado = radioActivo.isSelected();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre esta vacia");
                return;
            }
            m.guardarMateria(nombre, año, estado);
            limpiar();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No deje ninguna celda vacia");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correspondientes en el año");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void radioActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioActivoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        jPanel2.setVisible(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);

        llenarTodasLasMaterias();


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        jPanel2.setVisible(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(isIcon);
        limpiar();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void tablaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMateriasMouseClicked
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaMaterias.getModel();
            int idMateria = (int) modelo.getValueAt(tablaMaterias.getSelectedRow(), 0);

            materiaService mate = new materiaService();
            materia m = new materia();

            m = mate.buscarMateria(idMateria);

            txtCodigo.setText("" + m.getIdMateria());
            txtNombre.setText(m.getNombre());
            txtAnio.setText("" + m.getAño());

            if (m.isEstado() == true) {
                radioActivo.setSelected(true);
            } else {
                radioActivo.setSelected(false);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar seleccionar la materia");
        }

    }//GEN-LAST:event_tablaMateriasMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        try {
            materiaService mate = new materiaService();

            int id = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            boolean estado = radioActivo.isSelected();

            mate.modificarMateria(id, nombre, anio, estado);
            limpiar();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Seleccione una materia para modificarla");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correctos para su modificacion");
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR MATERIA?", "SALIR", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
            try {
                materiaService mate = new materiaService();
                int id = Integer.parseInt(txtCodigo.getText());

                mate.eliminarMateria(id);

                limpiar();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Seleccione una materia para su eliminacion");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al analizar los datos");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radioActivo;
    private javax.swing.JTable tablaMaterias;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        txtAnio.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
    }

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

            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No se registran materias a la cual inscribirse");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
