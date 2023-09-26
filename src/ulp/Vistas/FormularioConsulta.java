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
import ulp.Entidades.inscripcion;
import ulp.Entidades.materia;
import ulp.Service.alumnoService;
import ulp.Service.inscripcionService;
import ulp.Service.materiaService;

/**
 *
 * @author Cristian
 */
public class FormularioConsulta extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormularioConsulta
     */
    public FormularioConsulta() {
        initComponents();
        llenarComboBoxAlumno();
        llenarTabla();
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
        comboBoxMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/alumno.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(18, 123, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Listado Alumnos por Materia");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 21, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 65, 397, 10));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione una Materia : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 98, -1, -1));

        comboBoxMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMateriaActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 93, 214, -1));

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
        jScrollPane1.setViewportView(tablaAlumno);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 125, -1, 265));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 396, 61, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ulp,fondo,forms.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 470));

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

    private void comboBoxMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMateriaActionPerformed

        llenarTabla();
    }//GEN-LAST:event_comboBoxMateriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<materia> comboBoxMateria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaAlumno;
    // End of variables declaration//GEN-END:variables
public void llenarComboBoxAlumno() {
        materiaService m = new materiaService();

        try {
            for (materia o : m.listarMateria()) {
                comboBoxMateria.addItem(o);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Inhabilitamos temporalmente el listado de los alumnos por materia");
        }
    }

    public void llenarTabla() {

        try {
            //guardo en una variable el id recogido del alumno del combobox
            int id = comboBoxMateria.getItemAt(comboBoxMateria.getSelectedIndex()).getIdMateria();

            //Instancio una clase "inscripcionService" para poder acceder a sus metodos
            inscripcionService ins = new inscripcionService();

            ArrayList alumnos = ins.obtenerAlumnoPorMateria(id);

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Dni");
            modelo.addColumn("Fecha Nacimiento");
            modelo.addColumn("Estado");
            tablaAlumno.setModel(modelo);

            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.
            Object alum[] = null;
            
            for (int i = 0; i < alumnos.size(); i++) {
                modelo.addRow(alum);
                alumno getal = (alumno) alumnos.get(i);

                modelo.setValueAt(getal.getIdAlumno(), i, 0);
                modelo.setValueAt(getal.getNombre(), i, 1);
                modelo.setValueAt(getal.getApellido(), i, 2);
                modelo.setValueAt(getal.getDni(), i, 3);
                modelo.setValueAt(getal.getFechaNacimiento(), i, 4);
                modelo.setValueAt(getal.isEstado(), i, 5);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No tenemos registros de materias en la base de datos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
}
