/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.VEquipo;

import Excepciones.*;
import control.controlador;
import java.awt.Color;
import java.awt.Image;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

/**
 * 
 * @author Alejandro
 * @author Daniel
 * @author Unai
 */
public class VEquipo extends javax.swing.JFrame {

    /**
     * Creates new form VEquipo
     */
    private static int max = 100, countTemp, tipo;
    private static boolean errorG;
    
    
    public VEquipo() {
        initComponents();
        inicializarVentana();
    }
    
    public VEquipo(int tipo){
        initComponents();
        this.tipo = tipo;
        inicializarVentana();
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
        lTitulo = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lMax = new javax.swing.JLabel();
        cbDueno = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaJugadores = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        bLupa = new javax.swing.JButton();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/recursos/Logo_grande.png"))); // NOI18N

        lTitulo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 36)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lTitulo.setText("Nuevo Equipo");

        tfNombre.setBackground(new java.awt.Color(255, 255, 204));
        tfNombre.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNombreCaretUpdate(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Descripción");

        taDesc.setBackground(new java.awt.Color(255, 255, 204));
        taDesc.setColumns(20);
        taDesc.setRows(5);
        taDesc.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                taDescCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(taDesc);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Carácteres máximos");

        lMax.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lMax.setForeground(new java.awt.Color(102, 102, 102));
        lMax.setText("100");

        cbDueno.setBackground(new java.awt.Color(255, 255, 204));
        cbDueno.setMaximumRowCount(999);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Selección de dueño");

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        listaJugadores.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane2.setViewportView(listaJugadores);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Selección de jugadores");

        bLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VEquipo/find_icon.png"))); // NOI18N
        bLupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLupaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 139, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lMax))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDueno, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(bAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancelar)
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLupa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDueno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addGap(39, 39, 39))
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

    private void taDescCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_taDescCaretUpdate
        int contador, cont=0;
        contador = taDesc.getText().length();
        if(contador != countTemp)
        {
            
            
           if(contador>countTemp)
           {
               cont = contador - countTemp;
               max = max - cont;
           }     
           else
           {
               cont = countTemp - contador;
               max = max + cont;
           }
           countTemp=contador;
           if(max<10)
               lMax.setForeground(Color.red);
           else
               lMax.setForeground(new Color(102,102,102));
           String letras = "" + max;
           lMax.setText(letras);
        }    
        
        
    }//GEN-LAST:event_taDescCaretUpdate

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        max = 100;
        countTemp = 0;
        controlador.toVPrincipal(this);
    }//GEN-LAST:event_formWindowClosing

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        try
        {
            if (tfNombre.getText().isEmpty())
                throw new exceptionErroresColores(tfNombre, 1);
            else
                tfNombre.setBackground(new Color(255,255,204));
            
            if (!validar(tfNombre.getText(), "^([A-Za-z]([ ][A-Za-z])*){2,15}$"))
                throw new exceptionErroresColores(tfNombre, 2);
            else
                tfNombre.setForeground(new Color(46,184,46));
            
            if(max<0)
                throw new caracteresExcedidos();
            
            if(cbDueno.getSelectedIndex() == 0)
                throw new duenoVacio();
            
            if(controlador.altaEquipo(tfNombre.getText(), taDesc.getText(), cbDueno.getSelectedIndex(), listaJugadores.getSelectedIndices()))
            {
                controlador.JDInfo(this, true, "Equipo generado corréctamente");
                controlador.toVPrincipal(this);
            }
            
        }
        catch (exceptionErroresColores e){            
            setColorException(e.getTextField(), e.getCaso());
        }
        catch(caracteresExcedidos e){
            controlador.JDError(this, true, "Número de caracteres excedido en", "la descripción");
        }
        catch(duenoVacio e){
            controlador.JDError(this, true, "Seleccione un dueño");
        }
        catch(Exception e){
            controlador.JDError(this, true, "Equipo no registrado: "+e.getClass());
        }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void tfNombreCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNombreCaretUpdate
        tfNombre.setForeground(Color.black);
        tfNombre.setBackground(new Color(255,255,204));
    }//GEN-LAST:event_tfNombreCaretUpdate

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        controlador.toVPrincipal(this);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(errorG)
            controlador.toVPrincipal(this);
        errorG = false;
    }//GEN-LAST:event_formWindowOpened

    private void bLupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLupaActionPerformed
        try
        {
            controlador.findEquipoByNombre(tfNombre.getText());
            if(controlador.equipoTemp==null)
                throw new equipoNoEncontrado();
            setTfStartUp(false, true);
        }
        catch(equipoNoEncontrado e){
            controlador.JDError(this, true, "Nombre de equipo no encontrado");
        }
        catch(Exception e){
            controlador.JDError(this, true, "Error:"+e.getMessage()+e.getClass());
        }
        
    }//GEN-LAST:event_bLupaActionPerformed
    
    public void inicializarVentana(){
        try
        {
            String error = "";
            Image i = ImageIO.read(getClass().getResource("/Views/recursos/logo_u_favicon.png"));
            setIconImage(i);
            setLocationRelativeTo(null);
            if(tipo != 1)
            {
                cbDueno.addItem("-- Seleccione Dueño --");
                if(!controlador.llenarDuenos(cbDueno))
                    error = "dueños";
                listaJugadores.setModel(controlador.llenarJugadores(listaJugadores));
                if(listaJugadores.getModel().getSize() == 0)
                {
                    if(error.isEmpty())
                        error = "jugadores";
                    else
                        error = "ni jugadores";
                }    
                
            
                if(!error.isEmpty())
                {
                    controlador.JDError(this, true, "No hay "+error+" registrados, para crear", "un equipo son necesarios");
                    errorG = true;
                }
            }
            else
            {
                setTfStartUp(true, false);
            }    
            
        }
        catch(Exception e){
            controlador.JDError(this, true, "Error inicio ventana");
        }   
    }
    
    public void setTfStartUp(boolean a, boolean b){
        tfNombre.setEnabled(a);
        taDesc.setEnabled(b);
        cbDueno.setEnabled(b);
        listaJugadores.setEnabled(b);
        if(b)
        {
            taDesc.setText(controlador.equipoTemp.getDesripcion());
            tfNombre.setText(controlador.equipoTemp.getNombre());
            cbDueno.addItem(controlador.equipoTemp.getDuenoDni().getPersona().getNombre());
            cbDueno.setEnabled(false);
            listaJugadores.setModel(controlador.llenarJugadores(listaJugadores));
                if(listaJugadores.getModel().getSize() == 0)
                {
                    controlador.JDError(this, true, "No hay jugadores registrados, para editar el equipo");
                }    
        }    
    }
    
    public void setColorException(JTextField tf, int caso){
        Color rojo = new Color(255,77,77);
        if (caso == 1)
        {
            tf.setBackground(rojo);
            tf.setForeground(Color.black);
        }
        else
            tf.setForeground(rojo);
    }  
    
    public boolean validar(String cadena, String patt){
        boolean match = false;
        Pattern pat = Pattern.compile(patt);
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) 
            match = true;
        return match;
    }
    
    /**
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
            java.util.logging.Logger.getLogger(VEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bLupa;
    private javax.swing.JComboBox<String> cbDueno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lMax;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JList<String> listaJugadores;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
