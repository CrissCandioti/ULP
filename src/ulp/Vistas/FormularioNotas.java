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

/**
 *
 * @author Cristian
 */
public class FormularioNotas extends javax.swing.JInternalFrame {

//    DefaultTableModel model = new DefaultTableModel() {
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return columnIndex == 0; // Esto hará que solo la primera columna sea editable
//    }
//};
    /**
     * Creates new form FormularioNotas
     */
    public FormularioNotas() {
        initComponents();
        llenarComboBoxAlumno();
        llenarTabla();
        btnGuardar.setEnabled(false);
        comboNota.setVisible(false);
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
        comboAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboNota = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestión Notas");
        setPreferredSize(new java.awt.Dimension(510, 530));

        jPanel1.setBackground(new java.awt.Color(18, 123, 77));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        comboAlumno.setMaximumRowCount(15);
        comboAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAlumnoActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tablaAlumno);

        btnGuardar.setText("Modificar Nota");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Seleccione la nueva nota:");

        comboNota.setMaximumRowCount(11);
        comboNota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.0", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4,9", "5", "5.1", "5.2", "5.3", "5.4", "5.5", "5.6", "5.7", "5.8", "5.9", "6", "6.1", "6.2", "6.3", "6.4", "6.5", "6.6", "6.7", "6.8", "6.9", "7", "7.1", "7.2", "7.3", "7.4", "7.5", "7.6", "7.7", "7.8", "7.9", "8", "8.1", "8.2", "8.3", "8.4", "8.5", "8.6", "8.7", "8.8", "8.9", "9", "9.1", "9.2", "9.3", "9.4", "9.5", "9.6", "9.7", "9.8", "9.9", "10" }));
        comboNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(comboNota, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void comboAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAlumnoActionPerformed
        llenarTabla();
    }//GEN-LAST:event_comboAlumnoActionPerformed

    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        comboNota.setVisible(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        try {
            inscripcionService ins = new inscripcionService();
            
            DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
            int idMateria = (int) modelo.getValueAt(tablaAlumno.getSelectedRow(), 0);
            double nota = Double.parseDouble(comboNota.getSelectedItem().toString());
            int idAlumno = comboAlumno.getItemAt(comboAlumno.getSelectedIndex()).getIdAlumno();
            
            ins.actualizarNota(idAlumno, idMateria, nota);
            JOptionPane.showMessageDialog(this, "Nota actualizada");
            llenarTabla();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Escriba el decimal con punto");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNotaActionPerformed
//        ArrayList<Double> notas= new ArrayList<>();
//        
//        notas.add(0.1);
//        notas.add(0.2);
//        notas.add(0.3);
//        notas.add(0.4);
//        notas.add(0.5);
//        notas.add(0.6);
//        notas.add(0.7);
//        
//        for (Double nota : notas) {
//            comboNota.addItem(""+nota);
//        }
    }//GEN-LAST:event_comboNotaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<alumno> comboAlumno;
    private javax.swing.JComboBox<String> comboNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaAlumno;
    // End of variables declaration//GEN-END:variables

    public void llenarComboBoxAlumno() {
        alumnoService a = new alumnoService();
        
        try {
            for (alumno o : a.listarAlumno()) {
                comboAlumno.addItem(o);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void llenarTabla() {
        
        btnGuardar.setEnabled(false);
        comboNota.setSelectedIndex(0);
        comboNota.setVisible(false);
        try {
            //guardo en una variable el id recogido del alumno del combobox
            int id = comboAlumno.getItemAt(comboAlumno.getSelectedIndex()).getIdAlumno();

            //Instancio una clase "inscripcionService" para poder acceder a sus metodos
            inscripcionService ins = new inscripcionService();
            
            ArrayList inscripciones = ins.obtenerInscripcionPorAlumno(id);

            //le otorgo un modelo a la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Nota");
            tablaAlumno.setModel(modelo);

            //creo un vector para guardar los datos del array y que luego el modelo de la tabla pueda agregarlo a la tabla.
            Object insc[] = null;
            for (int i = 0; i < inscripciones.size(); i++) {
                modelo.addRow(insc);
                inscripcion geti = (inscripcion) inscripciones.get(i);
                
                modelo.setValueAt(geti.getIdMateria().getIdMateria(), i, 0);
                modelo.setValueAt(geti.getIdMateria().getNombre(), i, 1);
                modelo.setValueAt(geti.getNota(), i, 2);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Inabilitamos temporalmente la manipulacion de notas al no tener alumnos registrados");
        }
    }
}
