package Excepciones;

import javax.swing.JTextField;

/**
 *
 * @author UDA Corp.
 */
public class exceptionErroresColores extends Exception{
    
   private JTextField textField;
   private int caso;
   
   public exceptionErroresColores(JTextField tf, int cas){
       
       this.textField= tf;
       this.caso = cas;
   }

    public JTextField getTextField() {
        return textField;
    }
    
    public int getCaso() {
        return caso;
    }
}
