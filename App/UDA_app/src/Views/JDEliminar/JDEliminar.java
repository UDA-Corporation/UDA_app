package Views.JDEliminar;

import Modelo.BD.exceptions.NonexistentEntityException;
import java.awt.Image;
import javax.imageio.ImageIO;
import control.controlador;
import java.awt.Frame;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 * @since 0.7 alpha
 */

public class JDEliminar extends javax.swing.JDialog {
static String tipo;
    
    /**
     * Constructor por defecto generado
     * @param parent ventana en la que se apoya
     * @param modal booleano que si le pasas true te hace un request focus y no puedes navegar por las demás ventanas
     */
    public JDEliminar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setFavicon();
    }
    
    /**
     * Coonstructor al que se le pasa un tipo para trabajar con él en otros métodos
     * @param parent ventana en la que se apoya
     * @param modal booleano que si le pasas true te hace un request focus y no puedes navegar por las demás ventanas
     * @param tipo string que se utilizará en otros métodos para modificar la ventana
     */
    public JDEliminar(Frame parent, boolean modal, String tipo) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.tipo = tipo;
        lTitulo.setText("Introduce el dni o el codigo del " + tipo + " que quieres elimiar");
    }      

    /**
     * Código generado, no modificar
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfPK = new javax.swing.JTextField();
        lTitulo = new javax.swing.JLabel();
        bA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tfPK.setBackground(new java.awt.Color(255, 255, 204));
        tfPK.setForeground(new java.awt.Color(0, 0, 0));

        lTitulo.setForeground(new java.awt.Color(0, 0, 0));

        bA.setText("Aceptar");
        bA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfPK, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(lTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(bA)))
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(tfPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bA)
                .addContainerGap(31, Short.MAX_VALUE))
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
     * Action performed del boton aceptar que genera una ventana VDInfo y luego elimina esta ventana
     * @param evt Evento proporcinado de la ventana
     */
    private void bAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAActionPerformed
        try{
            tipo();
            controlador.JDInfo(this, true, tipo+" eliminado correctamente");
            this.dispose(); 
        }catch(NonexistentEntityException e){
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_bAActionPerformed
    
    /**
     * Elimina una persona o jugador dependiendo del tipo que le hemos proporcionado anteriormente en el constructor
     * @throws Exception 
     */
    public void tipo() throws Exception{
        switch (tipo){
            case "usuario":
                controlador.eliminarUsuario(tfPK.getText());
                break;
            case "jugador":
                controlador.eliminarJugador(tfPK.getText());
                break;
            case "dueno":
                controlador.eliminarDueno(tfPK.getText());
                break;
            case "equipo":
                controlador.eliminarEquipo(tfPK.getText());
                break;
        }
    }
    
    /**
     * Función para establecer el favicon a la página
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
            java.util.logging.Logger.getLogger(JDEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDEliminar dialog = new JDEliminar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JTextField tfPK;
    // End of variables declaration//GEN-END:variables
}
