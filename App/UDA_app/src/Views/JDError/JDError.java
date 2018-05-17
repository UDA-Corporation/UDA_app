package Views.JDError;

import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 * @since 0.1 alpha
 */

public class JDError extends javax.swing.JDialog {

    /**
     * Constructor por defecto generado
     * @param parent ventana en la que se apoya
     * @param modal booleano que si le pasas true te hace un request focus y no puedes navegar por las demás ventanas
     */
    public JDError(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setFavicon();
    }
    
    /**
     * Primer constructor con un mensaje
     * @param ventana ventana en la que se apoya
     * @param modal booleano que si le pasas true te hace un request focus y no puedes navegar por las demás ventanas
     * @param mensaje mensaje que se va a establecer en la pantalla
     */
    public JDError (java.awt.Frame ventana, boolean modal, String mensaje){
        super(ventana, modal);
        initComponents();
        setLocationRelativeTo(null);
        lTexto1.setText(mensaje);
        tfFocus.requestFocus();
    }
    
    /**
     * Segundo constructor con dos mensajes
     * @param ventana ventana en la que se apoya
     * @param modal booleano que si le pasas true te hace un request focus y no puedes navegar por las demás ventanas
     * @param mensaje mensaje que se va a establecer en la pantalla
     * @param mensaje2 mensaje que se va a establecer debajo del anterior en la pantalla
     */
    public JDError (java.awt.Frame ventana, boolean modal, String mensaje, String mensaje2){
        super(ventana, modal);
        initComponents();
        setLocationRelativeTo(null);
        lTexto1.setText(mensaje);
        lTexto2.setText(mensaje2);
        tfFocus.requestFocus();
    }
    
    /**
     * Función que establece el favicon a la ventana
     */
    public void setFavicon(){
        try
        {
            //Esta opción nos va a asignar un favicon a nusetro proyecto
            Image i = ImageIO.read(getClass().getResource("/Views/recursos/logo_u_favicon.png"));
            setIconImage(i);
        }
        catch(Exception e){
            
        }
        
    }

    /**
     * Código generado, no modificar
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lTexto1 = new javax.swing.JLabel();
        lTexto2 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        tfFocus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Error!");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/JDError/JDErrorIcon.png"))); // NOI18N

        lTexto1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lTexto1.setForeground(new java.awt.Color(0, 0, 0));
        lTexto1.setText("Prueba de texto prueba de texto");

        lTexto2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lTexto2.setForeground(new java.awt.Color(0, 0, 0));
        lTexto2.setToolTipText("");
        lTexto2.setRequestFocusEnabled(false);

        bAceptar.setText("Aceptar");
        bAceptar.setRequestFocusEnabled(false);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        tfFocus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFocusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(bAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfFocus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lTexto1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                    .addComponent(lTexto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bAceptar)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tfFocus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

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

    /**
     * Action performed del botón aceptar que elimina la ventana
     * @param evt Evento proporcinado de la ventana
     */
    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bAceptarActionPerformed

    /**
     * Action performed del text field que hace click en el botón aceptar
     * @param evt Evento proporcinado de la ventana
     */
    private void tfFocusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFocusActionPerformed
        bAceptar.doClick();
    }//GEN-LAST:event_tfFocusActionPerformed

    /**
     * Main de la ventana generado automáticamente
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDError.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDError dialog = new JDError(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lTexto1;
    private javax.swing.JLabel lTexto2;
    private javax.swing.JTextField tfFocus;
    // End of variables declaration//GEN-END:variables
}
