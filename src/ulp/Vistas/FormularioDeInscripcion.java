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
import ulp.Service.materiaService;

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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnInscribir = new javax.swing.JButton();
        rdbMateriasNoInsc = new javax.swing.JRadioButton();
        rdbTodasLasMaterias = new javax.swing.JRadioButton();
        rdbMateriasInsc = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        comboBoxAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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
        setPreferredSize(new java.awt.Dimension(630, 500));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(18, 123, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Seleccione un alumno:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 85, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripción");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 21, -1, -1));

        btnSalir.setText("Salir1");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 406, 80, -1));

        btnAnular.setText("Anular Inscripcion");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 387, 150, -1));

        btnInscribir.setText("Inscribir");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });
        jPanel1.add(btnInscribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 387, 110, -1));

        buttonGroup1.add(rdbMateriasNoInsc);
        rdbMateriasNoInsc.setText("Materias no Inscriptas");
        rdbMateriasNoInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMateriasNoInscActionPerformed(evt);
            }
        });
        jPanel1.add(rdbMateriasNoInsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 140, -1, -1));

        buttonGroup1.add(rdbTodasLasMaterias);
        rdbTodasLasMaterias.setText("Todas las materias");
        rdbTodasLasMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTodasLasMateriasActionPerformed(evt);
            }
        });
        jPanel1.add(rdbTodasLasMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        buttonGroup1.add(rdbMateriasInsc);
        rdbMateriasInsc.setSelected(true);
        rdbMateriasInsc.setText("Materias Inscriptas");
        rdbMateriasInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMateriasInscActionPerformed(evt);
            }
        });
        jPanel1.add(rdbMateriasInsc, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 140, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 164, 430, 214));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 52, 402, 10));

        comboBoxAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboBoxAlumnoMouseReleased(evt);
            }
        });
        comboBoxAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 80, 330, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Listado de Materias");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 113, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ulp,fondo,forms.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 460));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 620, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método para llenar la tabla con las materias en la que está inscripto el alumno.
    private void rdbMateriasInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMateriasInscActionPerformed
        //activo y desactivo botones correspondientes
        btnAnular.setVisible(true);
        btnAnular.setEnabled(false);
        btnInscribir.setVisible(false);
        llenarMateriasCursadas();

//     
    }//GEN-LAST:event_rdbMateriasInscActionPerformed

    //Método para cerrar la ventana
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rdbMateriasNoInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMateriasNoInscActionPerformed

        //activo y desactivo botones correspondientes
        btnAnular.setVisible(false);
        btnInscribir.setEnabled(false);
        btnInscribir.setVisible(true);
        llenarMateriasNoCursadas();

    }//GEN-LAST:event_rdbMateriasNoInscActionPerformed


    private void comboBoxAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAlumnoActionPerformed

        if (rdbMateriasInsc.isSelected()) {
            llenarMateriasCursadas();
        } else if (rdbMateriasNoInsc.isSelected()) {
            llenarMateriasNoCursadas();
        } else {
            llenarTodasLasMaterias();
        }
    }//GEN-LAST:event_comboBoxAlumnoActionPerformed

    //Método para INSCRIBIR un alumno a una materia
    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed

        try {
            //Creo un modelo y le asigno ese modelo a la jtable
            DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
            boolean estado = (boolean) modelo.getValueAt(tablaAlumno.getSelectedRow(), 3);
            //guardo en una variable booleana el estado de la materia
            if (estado == false) {//si el estado es "false" significa que la materia está eliminada.
                JOptionPane.showMessageDialog(this, "No se puede inscribir en esta Materia por que está Eliminada");
            } else {//Si es "true" prosigo con la inscripción
                //guardo en una variable el id del alumno que esta en el combobox
                int idAlumno = comboBoxAlumno.getItemAt(comboBoxAlumno.getSelectedIndex()).getIdAlumno();
                //obtengo el indice 0 (donde está el id de la materia) de la fila seleccionada en la tabla y lo guardo en una variable
                int idMateria = (int) modelo.getValueAt(tablaAlumno.getSelectedRow(), 0);

                //Instancio IscripcionService, con las variables obtenidas, para acceder al método "crearInscripcion()"
                inscripcionService ins = new inscripcionService();

                ins.crearInscripcion(0, idAlumno, idMateria);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Seleccione una materia para su inscripcion");
        } catch (NullPointerException f) {
            JOptionPane.showMessageDialog(null, "Seleccione un alumno para continuar con la inscripcion ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        llenarMateriasNoCursadas();
    }//GEN-LAST:event_btnInscribirActionPerformed

    //Metodo para habilitar los botones al hacer click en las materias
    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        btnAnular.setEnabled(true);
        btnInscribir.setEnabled(true);
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        //Muestro un mensaje de conformacion si qiuiero elimnar la inscricpcion
        if (JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR INSCRIPCION?", "SALIR", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {

            try {

                DefaultTableModel modelo = (DefaultTableModel) tablaAlumno.getModel();
                //Guardo en variables el valor de idMateria e idAlumno para pasarselo al método
                int idMateria = (int) modelo.getValueAt(tablaAlumno.getSelectedRow(), 0);
                int idAlumno = comboBoxAlumno.getItemAt(comboBoxAlumno.getSelectedIndex()).getIdAlumno();

                //Instancio una inscripción service para acceder al método
                inscripcionService ins = new inscripcionService();
                //llamo al método y le paso los parametros
                ins.borrarInscripcionAlumnoMateria(idAlumno, idMateria);

            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No selecciono ninguna materia para anular su inscripcion");
            } catch (NullPointerException f) {
                JOptionPane.showMessageDialog(null, "No se registraron los datos del alumno y la materia para anular su inscripcion");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        llenarMateriasCursadas();
    }//GEN-LAST:event_btnAnularActionPerformed

    private void rdbTodasLasMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTodasLasMateriasActionPerformed
        btnAnular.setVisible(false);
        btnInscribir.setEnabled(false);
        btnInscribir.setVisible(false);

        llenarTodasLasMaterias();
    }//GEN-LAST:event_rdbTodasLasMateriasActionPerformed

    private void comboBoxAlumnoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxAlumnoMouseReleased

    }//GEN-LAST:event_comboBoxAlumnoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<alumno> comboBoxAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdbMateriasInsc;
    private javax.swing.JRadioButton rdbMateriasNoInsc;
    private javax.swing.JRadioButton rdbTodasLasMaterias;
    private javax.swing.JTable tablaAlumno;
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
                modelo.setValueAt(getm.isEstado(), i, 3);

            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No se registran materias a la cual inscribirse");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void llenarMateriasCursadas() {
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
    }

    public void llenarMateriasNoCursadas() {
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
            modelo.addColumn("Estado");

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
                modelo.setValueAt(getm.isEstado(), i, 3);

            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No se registran materias a la cual inscribirse");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void llenarComboBoxAlumno() {
        alumnoService a = new alumnoService();

        try {
            for (alumno o : a.listarAlumno()) {
                comboBoxAlumno.addItem(o);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
