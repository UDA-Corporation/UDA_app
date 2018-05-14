/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.ResultadosyDatos;

import Parsers.DOMJornadas.ParserDOMJornadas;
import Parsers.SAX.ParserSAXJornadas;
import control.controlador;
import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author danie
 */
public class VJornadas extends javax.swing.JFrame {
    //Jornadas en el array (indice del codigo jornadas)
    int J = 0;
    /**
     * Creates new form VJornadas
     */
    public VJornadas() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel2 = new javax.swing.JLabel();
        SelectorJornada = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        FechaInicio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FechaFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Consulta jornadas");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/recursos/Logo_grande.png"))); // NOI18N

        SelectorJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jornada 1", "Jornada 2", "Jornada 3", "Jornada 4", "Jornada 5", "Jornada 6", "Jornada 7", "Jornada 8", "Jornada 9", "Jornada 10", "Jornada 11", "Jornada 12", "Jornada 13", "Jornada 14" }));
        SelectorJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectorJornadaActionPerformed(evt);
            }
        });

        Table.setAutoCreateRowSorter(true);
        Table.setBackground(new java.awt.Color(255, 255, 204));
        Table.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Recopilando datos...", "Recopilando datos...", "Recopilando datos..."},
                {"Recopilando datos...", "Recopilando datos...", "Recopilando datos..."},
                {"Recopilando datos...", "Recopilando datos...", "Recopilando datos..."},
                {"Recopilando datos...", "Recopilando datos...", "Recopilando datos..."}
            },
            new String [] {
                "Equipo 1", "Equipo 2", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setPreferredSize(new java.awt.Dimension(300, 100));
        Table.setRowHeight(25);
        jScrollPane1.setViewportView(Table);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Haz click en las columnas para ordenar la tabla por ese parámetro");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha inicio:");

        FechaInicio.setText("Recopilando datos...");

        jLabel6.setText("Fecha final:");

        FechaFinal.setText("Recopilando datos...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(SelectorJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FechaInicio)
                                .addGap(183, 183, 183)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FechaFinal))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(Salir)))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FechaInicio)
                    .addComponent(jLabel6)
                    .addComponent(FechaFinal))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(SelectorJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(Salir)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Lee si existe el XML de jornadas y llama al SAX o al DOM en funcion de su existencia, para crearlo o leerlo
     * @param evt Evento ocurrido en la ventana: abrirse
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        File xml = new File("BDD(Jornadas).xml");
        if(xml.exists() && !xml.isDirectory()) { 
            ParserSAXJornadas JornadasSAX = new ParserSAXJornadas();
            JornadasSAX.ejecutar();
        } else {
            try {
                ParserDOMJornadas JornadasDOM = new ParserDOMJornadas();
                JornadasDOM.ejecutar();
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(VJornadas.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        if (ParserSAXJornadas.Jornadasexpirado){
            ParserSAXJornadas JornadasSAX = new ParserSAXJornadas();
            JornadasSAX.ejecutar();
        }
        SelectorJornada.setSelectedIndex(J);
    }//GEN-LAST:event_formWindowOpened

    /**
     * Llama a la ventana principal
     * @param evt Evento ocurrido en la ventana: se esta cerrando la ventana
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.toVPrincipal(this);
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * Llama a la ventana principal
     * @param evt Evento ocurrido en la ventana: boton salir pulsado
     */
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        controlador.toVPrincipal(this);
    }//GEN-LAST:event_SalirActionPerformed

    /**
     * Rellena la tabla con un array rellenado de los elementos especificos de la jornada seleccionada obtenidos del array que genera el SAX con todas las jornadas
     * @param evt Evento ocurrido en la ventana: un elemento del combobox seleccionado
     */
    private void SelectorJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectorJornadaActionPerformed
        J = SelectorJornada.getSelectedIndex() * 15;
        Object[] columns = {"Equipo 1","Equipo 2","Resultado"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        for (int i = (J + 3); i < (J + 15); i++) {
            int x = i + 12;
            Object[] row = new Object[3];
            row = Arrays.copyOfRange(Parsers.SAX.ParserSAXJornadas.Jornadas,i,x);
            model.addRow(row);
            Arrays.fill(row,null);
            i += 2;
        } 
        Table.setModel(model);
        FechaFinal.setText(Parsers.SAX.ParserSAXJornadas.Jornadas[J+1].toString());
        FechaInicio.setText(Parsers.SAX.ParserSAXJornadas.Jornadas[J+2].toString());
    }//GEN-LAST:event_SelectorJornadaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VJornadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FechaFinal;
    private javax.swing.JLabel FechaInicio;
    private javax.swing.JButton Salir;
    private javax.swing.JComboBox<String> SelectorJornada;
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
