/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.Vistas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ulp.Entidades.alumno;

import ulp.Entidades.materia;
import ulp.Service.inscripcionService;

import ulp.Service.alumnoService;

/**
 *
 * @author Cristian
 */
public class FormularioDeInscripcion extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioDeInscripcion
     */
    public FormularioDeInscripcion() {
        initComponents();

        llenarComboBoxAlumno();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        comboBoxAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        btnInscribir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Formulario de Inscrpción");
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripción");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(115, 21, 277, 26);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(51, 53, 402, 10);

        comboBoxAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxAlumno);
        comboBoxAlumno.setBounds(173, 75, 330, 26);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Listado de Materias");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(153, 107, 150, 21);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Materias Inscriptas");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(51, 134, 126, 18);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Materias no Inscriptas");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(310, 134, 143, 18);

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAlumno);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(44, 164, 430, 214);

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });
        getContentPane().add(btnInscribir);
        btnInscribir.setBounds(18, 390, 110, 28);

        btnAnular.setText("Anular Inscripcion");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnular);
        btnAnular.setBounds(198, 390, 150, 28);

        btnSalir.setText("Salir1");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(394, 390, 80, 28);

        jPanel1.setBackground(new java.awt.Color(18, 123, 77));

        jLabel2.setText("Seleccione un alumno:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(362, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel2)
                .addContainerGap(364, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 520, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método para llenar la tabla con las materias en la que está inscripto el alumno.
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        //activo y desactivo botones correspondientes
        btnAnular.setVisible(true);
        btnAnular.setEnabled(false);
        btnInscribir.setVisible(false);

        try {
            //guardo en una variable el id recogido del alumno del combobox
            int id = comboBoxAlumno.getItemAt(comboBoxAlumno.getSelectedIndex()).getIdAlumno();

            //Instancio una clase "inscripcionService" para poder acceder a sus metodos
            inscripcionService ins = new inscripcionService();

            ArrayList materias = ins.obtenerMateriaCursadas(id);

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Año");
            tablaAlumno.setModel(modelo);

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
            JOptionPane.showMessageDialog(null, "No se registra ninguna materia inscripta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    //Método para cerrar la ventana
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

        //activo y desactivo botones correspondientes
        btnAnular.setVisible(false);
        btnInscribir.setEnabled(false);
        btnInscribir.setVisible(true);
        try {
            int id = comboBoxAlumno.getItemAt(comboBoxAlumno.getSelectedIndex()).getIdAlumno();

            inscripcionService ins = new inscripcionService();
            //Guardo el arraylist que me retorna en una variable para usar luego la variable 
            //y no se esté conectando y desconectando de la base de datos si llamo al metodo varias veces
            ArrayList materias = ins.obtenerMateriaNoCursadas(id);

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Año");
            tablaAlumno.setModel(modelo);

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
    }//GEN-LAST:event_jRadioButton2ActionPerformed


    private void comboBoxAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxAlumnoActionPerformed

    //Método para INSCRIBIR un alumno a una materia
    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed

        try {
            //Creo un modelo y le asigno ese modelo a la jtable
            DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();

            //guardo en una variable el id del alumno que esta en el combobox
            int idAlumno = comboBoxAlumno.getItemAt(comboBoxAlumno.getSelectedIndex()).getIdAlumno();
            //obtengo el indice 0 (donde está el id de la materia) de la fila seleccionada en la tabla y lo guardo en una variable
            int idMateria = (int) modelo.getValueAt(tablaAlumno.getSelectedRow(), 0);

            //Instancio IscripcionService, con las variables obtenidas, para acceder al método "crearInscripcion()"
            inscripcionService ins = new inscripcionService();

            ins.crearInscripcion(0, idAlumno, idMateria);
            JOptionPane.showMessageDialog(this, "Alumno Inscripto");

        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Seleccione una materia para su inscripcion");
        } catch (NullPointerException f) {
            JOptionPane.showMessageDialog(null, "Seleccione un alumno para continuar con la inscripcion ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    //Metodo para habilitar los botones al hacer click en las materias
    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        btnAnular.setEnabled(true);
        btnInscribir.setEnabled(true);
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR INSCRIPCION?", "SALIR", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {

            try {

                DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
                int idMateria = (int) modelo.getValueAt(tablaAlumno.getSelectedRow(), 0);
                int idAlumno = comboBoxAlumno.getItemAt(comboBoxAlumno.getSelectedIndex()).getIdAlumno();

                inscripcionService ins = new inscripcionService();

                ins.borrarInscripcionAlumnoMateria(idAlumno, idMateria);

            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No selecciono ninguna materia para anular su inscripcion");
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<alumno> comboBoxAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaAlumno;
    // End of variables declaration//GEN-END:variables

//    public void llenarCombobox() {
//        try {
//            alumnoService a = new alumnoService();
//
//            for (alumno object : a.listarAlumno()) {
//                comboBoxAlumno.addItem(object);
//
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(FormularioDeInscripcion.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    private void borrarFilas() {
//
//        int f = tablaAlumno.getRowCount() - 1;
//
//        for (; f >= 0; f--) {
//            modelo.removeRow(f);
//        }
//    }
    public void llenarComboBoxAlumno() {
        alumnoService a = new alumnoService();

        try {
            for (alumno o : a.listarAlumno()) {
                comboBoxAlumno.addItem(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(FormularioDeInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
