/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Vistas;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.Date;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ulp.Entidades.alumno;
import ulp.Service.alumnoService;

/**
 *
 * @author Cristian
 */
public class FormularioAlumno extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioAlumno
     */
    public FormularioAlumno() {
        initComponents();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        txtId.setVisible(true);
        txtId.setEditable(false);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) datechooser.getDateEditor();
        editor.setEditable(false);
        txtId.setEditable(false);
        txtId.setVisible(false);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        radioBestado = new javax.swing.JRadioButton();
        datechooser = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        labelFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gestión Alumnos");
        setToolTipText("Rellene todos los campos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/alumno.jpg"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(460, 460));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Alumnos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 360, 10));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Documento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Estado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Fecha Nac");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        txtApellido.setToolTipText("Escriba el Apellido");
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 230, 30));

        txtDni.setToolTipText("Escriba el documento");
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 121, 30));

        txtNombre.setToolTipText("Escriba el nombre");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 230, 30));

        radioBestado.setText("Activo");
        jPanel1.add(radioBestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, 20));

        datechooser.setToolTipText("Seleccione");
        datechooser.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 230, 30));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 91, 30));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 89, 30));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, 30));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, 30));

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, 30));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 33, 30));

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 74, -1));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/abstract-gray-simple-background-wallpaper-preview.jpg"))); // NOI18N
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            alumnoService a = new alumnoService();

            int dni = Integer.parseInt(txtDni.getText());
            String apellido = txtApellido.getText();
            String nombre = txtNombre.getText();
            String fechaNac = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
            boolean index = radioBestado.isSelected();

            if (apellido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del apellido esta vacia");
            }
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La celda del nombre esta vacia");
            }
            a.crearAlumno(dni, apellido, nombre, LocalDate.parse(fechaNac), index);
            limpiar();
        } catch (NumberFormatException b) {
            JOptionPane.showMessageDialog(this, "Ingrese los datos numericos del documento correspondiente");
        } catch (DateTimeException d) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al analizar la fecha ingresada");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente los datos");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        this.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            btnEliminar.setEnabled(true);
            btnModificar.setEnabled(true);
            btnGuardar.setEnabled(false);
            txtDni.setEditable(false);

            alumnoService a = new alumnoService();
            int dni = Integer.parseInt(txtDni.getText());
            a.buscarAlumnoPorDNI(dni);
            alumno aux = new alumno();
            //Guardamos en un alumno los valores obtenidos por el método
            aux = a.buscarAlumnoPorDNI(dni);
            // utilizamos la informacioon del alumno para setear los campos
            txtId.setText("" + aux.getIdAlumno());
            txtApellido.setText(aux.getApellido());
            txtNombre.setText(aux.getNombre());
            //Forma de setear el DateChooser
            LocalDate localDate = aux.getFechaNacimiento();
            java.util.Date utilDate = java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            datechooser.setDate(utilDate);
            //Forma de setear el radioButon
            if (aux.isEstado() == true) {
                radioBestado.setSelected(true);
            } else {
                radioBestado.setSelected(false);
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "No se encontro ese alumno en la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese el documento para su busqueda");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText());
            alumnoService a = new alumnoService();
            a.eliminarAlumno(id);
            limpiar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "No se encontro ningun alumno para su eliminacion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al analizar los datos");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            alumnoService a = new alumnoService();
            int id = Integer.parseInt(txtId.getText());
            int dni = Integer.parseInt(txtDni.getText());
            String apellido = txtApellido.getText();
            String nombre = txtNombre.getText();
            String fechaNac = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
            boolean index = radioBestado.isSelected();
            a.modificarAlumno(id, dni, apellido, nombre, LocalDate.parse(fechaNac), index);
            limpiar();
        } catch (NumberFormatException b) {
            JOptionPane.showMessageDialog(this, "Ingrese los datos numericos del documento correspondiente");
        } catch (DateTimeException d) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al analizar la fecha ingresada");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente los datos");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtDni.setEditable(true);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JRadioButton radioBestado;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        txtId.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtNombre.setText("");
        radioBestado.setSelected(false);
        datechooser.setDate(null);
    }
}
