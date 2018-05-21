package Views.VPuntos;
import control.controlador;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import Excepciones.ResultadoFMT;
import Excepciones.selection;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 * @since 0.5 alpha
 */

public class VPuntos extends javax.swing.JFrame {
static boolean yes = false;
    /**
     * Creates una nueva ventana VPuntos
     */
    public VPuntos() {
        yes = false;
        initComponents();
        initIcon();
        setLocationRelativeTo(null);
        goEnableRes(false);
        cbLiga.addItem("-- Seleccione una liga --");
        controlador.llenarLiga(cbLiga);
        yes = true;
    }

    /**
     * Código generado automáticamente no modificar
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbLiga = new javax.swing.JComboBox<>();
        cbJornadas = new javax.swing.JComboBox<>();
        cbPartidos = new javax.swing.JComboBox<>();
        tfe2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfe1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        le1 = new javax.swing.JLabel();
        le2 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestion de puntuacion");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Clasificacion");

        cbLiga.setBackground(new java.awt.Color(255, 255, 204));
        cbLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLigaActionPerformed(evt);
            }
        });

        cbJornadas.setBackground(new java.awt.Color(255, 255, 204));
        cbJornadas.setEnabled(false);
        cbJornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJornadasActionPerformed(evt);
            }
        });

        cbPartidos.setBackground(new java.awt.Color(255, 255, 204));
        cbPartidos.setEnabled(false);
        cbPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPartidosActionPerformed(evt);
            }
        });

        tfe2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("-");

        tfe1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Resultado");

        le1.setForeground(new java.awt.Color(0, 0, 0));
        le1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        le2.setForeground(new java.awt.Color(0, 0, 0));
        le2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/recursos/Logo_grande.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cbLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(cbJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(tfe2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bAceptar)
                                .addGap(119, 119, 119)
                                .addComponent(bSalir))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfe1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(le1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(le2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)))
                .addGap(169, 169, 169)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPartidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(le1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(le2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 122, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bSalir)
                            .addComponent(bAceptar))
                        .addGap(54, 54, 54))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action performed del combo box liga que establece la jornada
     * @param evt Evento proporcinado de la ventana
     */
    private void cbLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLigaActionPerformed
        if(yes&&cbLiga.getSelectedIndex()!=0){
            yes = false;
            cbJornadas.removeAllItems();
            cbJornadas.addItem("-- Seleccione una jornada --");
            cbJornadas.setEnabled(true);
            controlador.llenarJornadas((String)cbLiga.getSelectedItem(),cbJornadas);
            yes = true;
        }
    }//GEN-LAST:event_cbLigaActionPerformed

    /**
     * Action performed del combo box jornadas que dice si se ha seleccionado algo o no
     * @param evt Evento proporcinado de la ventana
     */
    private void cbJornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJornadasActionPerformed
        try{
            if(yes&&cbJornadas.getSelectedIndex()!=0){
                yes = false;
                rellenarPartidos(false);                
                yes = true;
            }
        }catch (Exception e){
            System.out.println("Parse exception");
        }
    }//GEN-LAST:event_cbJornadasActionPerformed

    /**
     * Action performed del combo box Partidos que dice si esta seleccionado y establece el nombre de dos labels
     * @param evt Evento proporcinado de la ventana
     */
    private void cbPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartidosActionPerformed
        // TODO add your handling code here:
        if(yes&&cbPartidos.getSelectedIndex()!=0){
            yes = false;           
            controlador.StringEquipos((String)cbPartidos.getSelectedItem());           
            le1.setText(controlador.le1());
            le2.setText(controlador.le2());
            goEnableRes(true);
            yes = true;
        }
    }//GEN-LAST:event_cbPartidosActionPerformed

    /**
     * Action performed del botón aceptar que valida y establece el resultado de un partido
     * @param evt Evento proporcinado de la ventana
     */
    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        try{
            String resultado;
            if(validar()){
                if(Integer.parseInt(tfe1.getText())>Integer.parseInt(tfe2.getText())){
                    controlador.resultado(le1.getText(), null);
                    resultado=tfe1.getText()+"-"+tfe2.getText();
                    controlador.resultadoPartido(le1.getText(), resultado, false);
                }else
                    if(Integer.parseInt(tfe2.getText())>Integer.parseInt(tfe1.getText())){
                        controlador.resultado(null, le2.getText());
                        resultado=tfe1.getText()+"-"+tfe2.getText();
                        controlador.resultadoPartido(le2.getText(), resultado, false);
                    }else
                        if(Integer.parseInt(tfe2.getText())==Integer.parseInt(tfe1.getText())){
                            controlador.resultado(le1.getText(), le2.getText());
                            resultado=tfe1.getText()+"-"+tfe2.getText();
                            controlador.resultadoPartido(null, resultado, true);
                        }                
                }  
            else
                throw new ResultadoFMT();
            controlador.JDInfo(this, true, "Resultado introducido correctamente");
            controlador.recalcularClasificacion();
            yes=false;
            rellenarPartidos(true);          
            limpiar();
            yes=true;
        }catch(selection e){
            controlador.JDError(this, true, "Debes seleccionar una liga un equipo y un patido");
        }catch(ResultadoFMT e){
            controlador.JDError(this, true, "Introduce el resultado en un formato correcto");
        }catch (Exception e){
            System.out.println("Problemas puntuacion");
            e.printStackTrace();
        }         
    }//GEN-LAST:event_bAceptarActionPerformed

    /**
     * Action performed que lleva a la ventana VPrincipal
     * @param evt Evento proporcinado de la ventana
     */
    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        controlador.toVPrincipal(this);
    }//GEN-LAST:event_bSalirActionPerformed

    /**
     * Evento que cuando se está cerrando la ventana redirige a la ventana VPrincipal
     * @param evt Evento proporcinado de la ventana
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.toVPrincipal(this);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Función que habilita o desabilita dos text fields
     * @param enabled booleano que establece si está habilitado o no
     */
    public void goEnableRes(boolean enabled){
        tfe1.setEnabled(enabled);
        tfe2.setEnabled(enabled);
    }
    
    /**
     * Establece los partidos en el combo box partidos
     * @param a booleano que nos dice si se ha seleccionado algo en el combo box jornadas o no
     * @throws Exception 
     */
    public void rellenarPartidos(boolean a)throws Exception{
        goEnableRes(false);
        cbPartidos.removeAllItems();
        cbPartidos.addItem("-- Seleccione un partido --");
        if(!a){
            controlador.llenarPartidos((String)cbJornadas.getSelectedItem(),cbPartidos);
            cbPartidos.setEnabled(true);
        }else{
            controlador.llenarPartidos(null,cbPartidos);
            if(cbPartidos.getModel().getSize()==1){
                cbJornadas.removeAllItems();
                cbJornadas.addItem("-- Seleccione una jornada --");
                controlador.llenarJornadas(null, cbJornadas);
            }
                
        }
    }
    
    /**
     * Establecer blanco a dos text fields
     */
    public void limpiar(){
        tfe1.setText("");
        tfe2.setText("");
    }
    
    /**
     * Valida los datos introducidos del resultado en los text fields
     * @return booleano que retorna si la validación es correcta o no
     * @throws Exception 
     */
    public boolean validar()throws Exception{
        if(cbLiga.getSelectedIndex()==0||cbJornadas.getSelectedIndex()==0||cbPartidos.getSelectedIndex()==0)
            throw new selection(); 
        if(!digito(tfe1.getText()))
            throw new ResultadoFMT();
        else 
            if(!digito(tfe2.getText()))
                return false;
        if((tfe1.getText()+tfe2.getText()).length()>4)
            return false;
        return true;
    }
    
    /**
     * Establece un error
     * @param e tipo de error
     * @return booleano
     */
    public boolean digito(String e){
        for (int c=0;c<e.length();c++)
            if(!Character.isDigit(e.charAt(c)))
                return false;
        return true;
    }
    
    /**
     * Establece el favicon a la ventana
     */
    public void initIcon(){
        try{
            Image i = ImageIO.read(getClass().getResource("/Views/recursos/logo_u_favicon.png"));
            setIconImage(i);
        }catch (IOException e){
            System.out.println("Problemas con el icono");
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
            java.util.logging.Logger.getLogger(VPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPuntos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bSalir;
    private javax.swing.JComboBox<String> cbJornadas;
    private javax.swing.JComboBox<String> cbLiga;
    private javax.swing.JComboBox<String> cbPartidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel le1;
    private javax.swing.JLabel le2;
    private javax.swing.JTextField tfe1;
    private javax.swing.JTextField tfe2;
    // End of variables declaration//GEN-END:variables
}
