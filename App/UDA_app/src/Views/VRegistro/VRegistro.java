package Views.VRegistro;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import Excepciones.*;
import Modelo.BD.exceptions.PreexistingEntityException;
import control.controlador;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 * @since 0.2 alpha
 */

public class VRegistro extends javax.swing.JFrame {

    /**
     * Crea una nueva ventana VRegistro
     */
    private static int tipo, tipoventana;
    
    public VRegistro() {
        initComponents();
        
    }
    
    /**
     * Constructor personalizado que crea la ventana según el tipo y con un título personalizado
     * @param tipo es un parámetro int que hace referencia al tipo de acción que se va a realizar
     * @param mensaje es un parámetro String que va a ser el título que va a tener el label título
     * @param tipoventana es un parámetro int que hace referencia a la ventana de la que se llama a esta ventana
     */
    public VRegistro(int tipo, String mensaje, int tipoventana){
        
        initComponents();
        this.tipo = tipo;
        this.tipoventana = tipoventana;
        //Si hay tiempo se puede poner opción de cambio de contraseña si le llamamos desde el jMenu de Modificación
        inicializarVentana(mensaje);
    }

    /**
     * Código generado, no modificar
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfCalle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfNro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfPiso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfCiudad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfCp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfPais = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfTel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jpCuenta = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfPass1 = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        tfPass2 = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jpJugador = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tfNickname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfSueldo = new javax.swing.JTextField();
        bLupa = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        lTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registro");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/recursos/Logo_grande.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DNI");

        tfDni.setBackground(new java.awt.Color(255, 255, 204));
        tfDni.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfDniCaretUpdate(evt);
            }
        });
        tfDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDniActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");

        tfNombre.setBackground(new java.awt.Color(255, 255, 204));
        tfNombre.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNombreCaretUpdate(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Apellido");

        tfApellido.setBackground(new java.awt.Color(255, 255, 204));
        tfApellido.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfApellidoCaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Calle");

        tfCalle.setBackground(new java.awt.Color(255, 255, 204));
        tfCalle.setToolTipText("");
        tfCalle.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfCalleCaretUpdate(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Número");

        tfNro.setBackground(new java.awt.Color(255, 255, 204));
        tfNro.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNroCaretUpdate(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Piso");

        tfPiso.setBackground(new java.awt.Color(255, 255, 204));
        tfPiso.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfPisoCaretUpdate(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Ciudad");

        tfCiudad.setBackground(new java.awt.Color(255, 255, 204));
        tfCiudad.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfCiudadCaretUpdate(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("C.P");

        tfCp.setBackground(new java.awt.Color(255, 255, 204));
        tfCp.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfCpCaretUpdate(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("País");

        tfPais.setBackground(new java.awt.Color(255, 255, 204));
        tfPais.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfPaisCaretUpdate(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Tel.");

        tfTel.setBackground(new java.awt.Color(255, 255, 204));
        tfTel.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfTelCaretUpdate(evt);
            }
        });

        jpCuenta.setBackground(new java.awt.Color(255, 255, 255));
        jpCuenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuenta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Usuario");

        tfUsuario.setBackground(new java.awt.Color(255, 255, 204));
        tfUsuario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfUsuarioCaretUpdate(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Contraseña");

        tfPass1.setBackground(new java.awt.Color(255, 255, 204));
        tfPass1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfPass1CaretUpdate(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Repite contraseña");

        tfPass2.setBackground(new java.awt.Color(255, 255, 204));
        tfPass2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfPass2CaretUpdate(evt);
            }
        });
        tfPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPass2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCuentaLayout = new javax.swing.GroupLayout(jpCuenta);
        jpCuenta.setLayout(jpCuentaLayout);
        jpCuentaLayout.setHorizontalGroup(
            jpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCuentaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(27, 27, 27)
                .addGroup(jpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfUsuario)
                    .addComponent(tfPass1)
                    .addComponent(tfPass2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpCuentaLayout.setVerticalGroup(
            jpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCuentaLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(1, 1, 1)
                .addGroup(jpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jpJugador.setBackground(new java.awt.Color(255, 255, 255));
        jpJugador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos jugador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Nickname");

        tfNickname.setBackground(new java.awt.Color(255, 255, 204));
        tfNickname.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfNicknameCaretUpdate(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Sueldo");

        tfSueldo.setBackground(new java.awt.Color(255, 255, 204));
        tfSueldo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfSueldoCaretUpdate(evt);
            }
        });
        tfSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSueldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpJugadorLayout = new javax.swing.GroupLayout(jpJugador);
        jpJugador.setLayout(jpJugadorLayout);
        jpJugadorLayout.setHorizontalGroup(
            jpJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJugadorLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpJugadorLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpJugadorLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(77, 77, 77)
                        .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpJugadorLayout.setVerticalGroup(
            jpJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpJugadorLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(1, 1, 1)
                .addGroup(jpJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        bLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VRegistro/find_icon.png"))); // NOI18N
        bLupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLupaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDni, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(tfApellido)
                    .addComponent(tfNro)
                    .addComponent(tfCiudad)
                    .addComponent(tfPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfCp))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfPiso))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfNombre))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfCalle))))))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(194, 194, 194))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bLupa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jpJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        lTitulo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 36)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lTitulo.setText("Nuevo Usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(138, 138, 138)
                        .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(bAceptar)
                        .addGap(157, 157, 157)
                        .addComponent(bCancelar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar)
                    .addComponent(bCancelar))
                .addGap(249, 249, 249))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action performed del botón aceptar que hace la acción en referencia a la variable tipo
     * @param evt Evento proporcinado de la ventana
     * @exception contrasenaDiferenteError que salta cuando las contraseñas no coinciden
     * @exception registroError error que puede generar al realizar el registro
     * @exception camposIncorrectos que salta cuando hay campos incorrectos introducidos
     * @exception PreexistingEntityException error que salta cuando ya existe ese objeto en la base de datos
     * @exception nicknameEnUso error que salta cuando el nickname introducido está ya registrado en la base de datos
     */
    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        
        try
        {
            //Llamaremos a esta función para validar todos los text fields y asignarle un color si es correcto o erróneo
            validarCampos();
            
            Color verde = new Color(46,184,46);
            
            if(tfDni.getForeground().equals(verde) && tfNombre.getForeground().equals(verde) && tfApellido.getForeground().equals(verde) && tfCalle.getForeground().equals(verde) && tfNro.getForeground().equals(verde) && tfPiso.getForeground().equals(verde)&& tfCiudad.getForeground().equals(verde)&& tfCp.getForeground().equals(verde)&& tfPais.getForeground().equals(verde)&& tfTel.getForeground().equals(verde))
            {
                if(tipo == 1)
                {
                    if(tfUsuario.getForeground().equals(verde)&& tfPass1.getForeground().equals(verde)&& tfPass2.getForeground().equals(verde))
                    {
                        String tipo_persona;
                                
                        if(lTitulo.getText().equals("Nuevo Dueño"))
                            tipo_persona = "dueno";
                        else
                            if(lTitulo.getText().equals("Nuevo Usuario"))
                                tipo_persona = "usuario";
                            else
                                tipo_persona = "admin";
                        
                        if(!controlador.registrarUsuario(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), tfCalle.getText(), tfNro.getText(), tfPiso.getText(), tfCiudad.getText(), tfCp.getText(), tfPais.getText(), tfTel.getText(), tfUsuario.getText(), String.valueOf(tfPass1.getPassword()), tipo_persona))
                            throw new registroError();
                        else
                        {
                            controlador.JDInfo(this, true, "Registro realizado");
                            if(tipoventana == 1)
                                controlador.toVPrincipal(this);
                            else
                                controlador.toVLogin(this);
                        }
                    }
                    else
                        throw new camposIncorrectos();
                }
                else
                {
                    switch(tipo)
                    {
                        case 2 :
                            if(!tfSueldo.getForeground().equals(verde))
                                throw new camposIncorrectos();
                            if(controlador.findNickname(tfNickname.getText()))
                                throw new nicknameEnUso();
                            if(!controlador.registrarJugador(tfDni.getText(),tfNickname.getText(), tfSueldo.getText(), tfNombre.getText(), tfApellido.getText(), tfCalle.getText(), tfNro.getText(), tfPiso.getText(), tfCiudad.getText(), tfCp.getText(), tfPais.getText(), tfTel.getText()))
                                throw new registroError();
                            else
                            {
                                controlador.JDInfo(this, true, "Registro realizado");
                            }
                        break;
                        case 3:
                            if(lTitulo.getText().equals("Modificación Usuario"))
                            {
                                controlador.persTemp.setUpdate(tfNombre.getText(), tfApellido.getText(), tfCalle.getText(), tfNro.getText(), tfPiso.getText(), tfCiudad.getText(), tfCp.getText(), tfPais.getText(), tfTel.getText());
                                controlador.updatePersona();
                            }
                            else
                            {
                                controlador.dueTemp.getPersona().setUpdate(tfNombre.getText(), tfApellido.getText(), tfCalle.getText(), tfNro.getText(), tfPiso.getText(), tfCiudad.getText(), tfCp.getText(), tfPais.getText(), tfTel.getText());
                                controlador.updateDueno();
                            }    
                        break;
                        
                        case 4:
                            if(!tfSueldo.getForeground().equals(verde))
                                throw new camposIncorrectos();
                            controlador.jugTemp.setUpdate(Integer.parseInt(tfSueldo.getText()), tfNombre.getText(), tfApellido.getText(), tfCalle.getText(), tfNro.getText(), tfPiso.getText(), tfCiudad.getText(), tfCp.getText(), tfPais.getText(), tfTel.getText());
                            controlador.updateJugador();
                            
                    }
                    if(tipo>2)
                        controlador.JDInfo(this, true, "Modificación realizada corréctamente");
                    controlador.toVPrincipal(this);
                }    
                       
            }
            else
                throw new camposIncorrectos();
        }
        catch(contrasenaDiferenteError e){
            tfPass2.setForeground(Color.red);
            controlador.JDError(this, true, "Las contraseñas no coinciden");
        }
        catch(registroError e){
            controlador.JDError(this, true, "Error, registro no realizado");
        }
        catch(camposIncorrectos e){
            controlador.JDError(this, true, "Error, campos erróneos");
        }
        catch(PreexistingEntityException e){
            if(controlador.tipoE == 1)
            {
                tfDni.setForeground(Color.red);
                controlador.JDError(this, true, "Persona ya registrada con ese DNI");
            }
            else
            {
                controlador.destroyRegistro(tfDni.getText());
                tfUsuario.setForeground(Color.red);
                controlador.JDError(this, true, "Usuario ya existente");
            }
            controlador.tipoE = 0;
        }
        catch(nicknameEnUso e){
            tfNickname.setForeground(Color.red);
            controlador.JDError(this, true, "Nickname en uso");
        }
        catch(Exception e){
            controlador.JDError(this, true, "Errores..."+e.getMessage()+e.getClass());
        }
        
    }//GEN-LAST:event_bAceptarActionPerformed
    
    /**
     * Función que valida los text fields del registro
     * @throws Exception errores varios que puede generar la función
     */
    public void validarCampos() throws Exception{
        
            setErroresColores(tfDni, "^(([A-Z]\\d{8})|(\\d{8}[A-Z]))$");
            setErroresColores(tfNombre, "^([A-Za-z]([ ][A-Za-z])*){2,15}$");
            setErroresColores(tfApellido, "^([A-Za-z]([ ][A-Za-z])*){2,20}$");
            setErroresColores(tfCalle, "^([A-Za-z]([ ][A-Za-z])*){3,40}$");
            setErroresColores(tfNro, "^[0-9]{1,3}$");
            setErroresColores(tfPiso, "^[0-9]{1,3}$");
            setErroresColores(tfCiudad, "^([A-Za-z]){2,20}$");
            setErroresColores(tfCp, "^[0-9A-Z]{4,5}$");
            setErroresColores(tfPais, "^([A-Za-z]){3,20}");
            setErroresColores(tfTel, "^?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$");
            
            if(tipo == 1)
            {
                setErroresColores(tfUsuario, "^[a-z0-9ü][a-z0-9ü_]{3,9}$");
                setErroresColores(tfPass1, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$");
                setErroresColores(tfPass2, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$");
                if(tfPass1.getForeground().equals(new Color(46,184,46)))
                {
                    if(!String.valueOf(tfPass1.getPassword()).equals(String.valueOf(tfPass2.getPassword())))
                    {
                        throw new contrasenaDiferenteError();
                    }    
                }
                else
                    controlador.JDError(this, true, "La contraseña debe tener más de 8 caracteres", "mayúscula, minúscula, digitos y caracter especial");
            }
            else
            {
                setErroresColores(tfNickname, "^[a-z\\d_]{4,15}$");
                setErroresColores(tfSueldo, "^[0-9]{1,7}");
            } 
    }
    
    /**
     * Actualización realizada en el text field usuario que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfUsuarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfUsuarioCaretUpdate
        coloresDefault(tfUsuario);
    }//GEN-LAST:event_tfUsuarioCaretUpdate

    /**
     * Actualización realizada en el text field pass1 que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfPass1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfPass1CaretUpdate
        coloresDefault(tfPass1);
    }//GEN-LAST:event_tfPass1CaretUpdate

    /**
     * Actualización realizada en el text field tel que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfTelCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfTelCaretUpdate
        coloresDefault(tfTel);
    }//GEN-LAST:event_tfTelCaretUpdate

    /**
     * Actualización realizada en el text field pais que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfPaisCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfPaisCaretUpdate
        coloresDefault(tfPais);
    }//GEN-LAST:event_tfPaisCaretUpdate

    /**
     * Actualización realizada en el text field cp que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfCpCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfCpCaretUpdate
        coloresDefault(tfCp);
    }//GEN-LAST:event_tfCpCaretUpdate

    /**
     * Actualización realizada en el text field Ciudad que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfCiudadCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfCiudadCaretUpdate
        coloresDefault(tfCiudad);
    }//GEN-LAST:event_tfCiudadCaretUpdate

    /**
     * Actualización realizada en el text field Piso que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfPisoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfPisoCaretUpdate
        coloresDefault(tfPiso);
    }//GEN-LAST:event_tfPisoCaretUpdate

    /**
     * Actualización realizada en el text field Nro que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfNroCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNroCaretUpdate
        coloresDefault(tfNro);
    }//GEN-LAST:event_tfNroCaretUpdate

    /**
     * Actualización realizada en el text field Calle que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfCalleCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfCalleCaretUpdate
        coloresDefault(tfCalle);
    }//GEN-LAST:event_tfCalleCaretUpdate

    /**
     * Actualización realizada en el text field Apellido que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfApellidoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfApellidoCaretUpdate
        coloresDefault(tfApellido);
    }//GEN-LAST:event_tfApellidoCaretUpdate

    /**
     * Actualización realizada en el text field Nombre que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfNombreCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNombreCaretUpdate
        coloresDefault(tfNombre);
    }//GEN-LAST:event_tfNombreCaretUpdate

    /**
     * Actualización realizada en el text field Dni que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfDniCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfDniCaretUpdate
        coloresDefault(tfDni);
    }//GEN-LAST:event_tfDniCaretUpdate

    /**
     * Función que se ejecuta cuando la ventana se está cerrando que lleva a la ventana correspondiente
     * @param evt Evento proporcinado de la ventana
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(tipoventana == 1)
            controlador.toVPrincipal(this);
        else
            controlador.toVLogin(this);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Actualización realizada en el text field pass2 que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfPass2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfPass2CaretUpdate
        coloresDefault(tfPass2);
    }//GEN-LAST:event_tfPass2CaretUpdate

    /**
     * Action performed del botón cancelar que redirige a la ventana correspondiente
     * @param evt Evento proporcinado de la ventana
     */
    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        if(tipoventana == 1)
            controlador.toVPrincipal(this);
        else
            controlador.toVLogin(this);
    }//GEN-LAST:event_bCancelarActionPerformed

    /**
     * Actualización realizada en el text field pass2 que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPass2ActionPerformed
        bAceptar.doClick();
    }//GEN-LAST:event_tfPass2ActionPerformed

    /**
     * Actualización realizada en el text field nickname que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfNicknameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfNicknameCaretUpdate
        coloresDefault(tfNickname);
    }//GEN-LAST:event_tfNicknameCaretUpdate

    /**
     * Actualización realizada en el text field sueldo que pone los colores default al mismo
     * @param evt Evento proporcinado de la ventana
     */
    private void tfSueldoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfSueldoCaretUpdate
        coloresDefault(tfSueldo);
    }//GEN-LAST:event_tfSueldoCaretUpdate

    /**
     * Action performed del text field sueldo que hace click al botón aceptar
     * @param evt Evento proporcinado de la ventana
     */
    private void tfSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSueldoActionPerformed
        bAceptar.doClick();
    }//GEN-LAST:event_tfSueldoActionPerformed

    /**
     * Action performed del botón lupa que hace la busqueda según el tipo que hemos proporcionado en el constructor
     * @param evt Evento proporcinado de la ventana
     * @exception camposIncorrectos salta cuando los campos son incorrectos
     * @exception dniNoEncontrado salta cuando no se ha encontrado e dni introducido
     * @exception jugadoresEquipo salta cuando el jugador introducido no se encuentra en el equipo del dueño que ha hecho login
     */
    private void bLupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLupaActionPerformed
        try
        {
            setErroresColores(tfDni, "^(([A-Z]\\d{8})|(\\d{8}[A-Z]))$");
            
            if(tfDni.getForeground().equals(new Color(46,184,46)))
            {
                switch(tipo)
                {
                    case 3:
                        controlador.findPerByDni(tfDni.getText());
                        if(controlador.persTemp == null)
                            throw new dniNoEncontrado();
                    break;
                    
                    case 4:
                        if(!controlador.findJugByDni(tfDni.getText()))
                            throw new jugadoresEquipo();
                            
                        if(controlador.jugTemp == null)
                            throw new dniNoEncontrado();
                    break;
                    
                    case 5:
                        controlador.findDueByDni(tfDni.getText());
                        if(controlador.dueTemp == null)
                            throw new dniNoEncontrado();
                        controlador.persTemp = controlador.dueTemp.getPersona();
                        tipo = 3;
                }
                setTfStartUp(false, true);
                  
            }
            else
                throw new camposIncorrectos();
        }
        catch(camposIncorrectos e){
            controlador.JDError(this, true, "Error, campo DNI incorrecto");
        }
        catch(dniNoEncontrado e){
            tfDni.setForeground(Color.orange);
            controlador.JDError(this, true, "El dni introducido no existe");
        }
        catch(jugadoresEquipo e){
            tfNombre.setForeground(Color.orange);
            controlador.JDError(this, true, "El jugador introducido no se encuentra en ", "uno de tus equipos");
        }
        catch(Exception e){
            controlador.JDError(this, true, "Error: "+e.getMessage()+e.getClass());
        }
    }//GEN-LAST:event_bLupaActionPerformed

    /**
     * Action performed del text field dni que hace click en el botón lupa dependiendo el tipo de la ventana
     * @param evt Evento proporcinado de la ventana
     */
    private void tfDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDniActionPerformed
        if(tipo <=2)
            bLupa.doClick();
    }//GEN-LAST:event_tfDniActionPerformed
    
    /**
     * Establece los colores por defecto de los text fields
     * @param tf text field al que se le queire restablecer el color
     */
    public void coloresDefault(JTextField tf){
        tf.setForeground(Color.black);
        tf.setBackground(new Color(255,255,204));
    }
    
    /**
     * Inicializa la ventana sugún el tipo de opción que vamos a realizar
     * @param mensaje va a ser el título que le vamos a asignar a la ventana
     */
    public void inicializarVentana(String mensaje) {
        boolean cambio = false;
        setLocationRelativeTo(null);
        lTitulo.setText(mensaje);
        bLupa.setVisible(false);
        if(tipo == 5)
        {
            cambio = true;
            tipo = 3;
        }    
        
        switch(tipo)
        {
            case 1:
                jpJugador.setVisible(false);
            break;
            
            case 2:
                jpCuenta.setVisible(false);
                jpJugador.setVisible(true);
            break;
            
            case 3:
                bLupa.setVisible(true);
                jpCuenta.setVisible(false);
                jpJugador.setVisible(false);
                setTfStartUp(true, false);
                if(cambio)
                    tipo = 5;
            break;
            
            case 4:
                bLupa.setVisible(true);
                jpCuenta.setVisible(false);
                tfNickname.setEnabled(false);
                setTfStartUp(true, false);
            break;
        }    
        try
        {
            //Esta opción nos va a asignar un favicon a nusetro proyecto
            Image i = ImageIO.read(getClass().getResource("/Views/recursos/logo_u_favicon.png"));
            setIconImage(i);
        }
        catch(Exception e){
            controlador.JDError(this, true, "Error favicon");
        }
        
    }
    
    /**
     * Inicialización de los text fields y los botones según el tipo de ventana
     * @param a boolean para visualizar una parte o ocultar
     * @param b boolean para visualizar o ocultar otra parte
     */
    public void setTfStartUp(boolean a, boolean b){
        tfDni.setEnabled(a);
        bAceptar.setEnabled(b);
        tfNombre.setEnabled(b);
        tfApellido.setEnabled(b);
        tfCalle.setEnabled(b);
        tfNro.setEnabled(b);
        tfPiso.setEnabled(b);
        tfCiudad.setEnabled(b);
        tfCp.setEnabled(b);
        tfPais.setEnabled(b);
        tfTel.setEnabled(b);
        if(tipo == 4)
            tfSueldo.setEnabled(b);
        
        if(b == true)
        {
            if(tipo == 4)
            {
                tfNickname.setText(controlador.jugTemp.getNickname());
                tfSueldo.setText(""+controlador.jugTemp.getSueldo());
                tfNombre.setText(controlador.jugTemp.getNombre());
                tfApellido.setText(controlador.jugTemp.getApellido());
                tfCalle.setText(controlador.jugTemp.getCalle());
                tfNro.setText(controlador.jugTemp.getNro());
                tfPiso.setText(controlador.jugTemp.getPiso());
                tfCiudad.setText(controlador.jugTemp.getCiudad());
                tfCp.setText(controlador.jugTemp.getCp());
                tfPais.setText(controlador.jugTemp.getPais());
                tfTel.setText(controlador.jugTemp.getTlfo());
            }
            else
            {
                tfNombre.setText(controlador.persTemp.getNombre());
                tfApellido.setText(controlador.persTemp.getApellido());
                tfCalle.setText(controlador.persTemp.getCalle());
                tfNro.setText(controlador.persTemp.getNro());
                tfPiso.setText(controlador.persTemp.getPiso());
                tfCiudad.setText(controlador.persTemp.getCiudad());
                tfCp.setText(controlador.persTemp.getCp());
                tfPais.setText(controlador.persTemp.getPais());
                tfTel.setText(controlador.persTemp.getTlfo());
            }    
        }    
        
    }
    
    /**
     * Establecer el color de error según el error que tenga
     * @param tf text field al que se le aplica
     * @param patt expresión regular con la que se va a validar
     */
    public void setErroresColores(JTextField tf, String patt){
        try
        {
            if (tf.getText().isEmpty())
                throw new exceptionErroresColores(tf, 1);
            else
                tf.setBackground(new Color(255,255,204));
            
            if (!validar(tf.getText(), patt))
                throw new exceptionErroresColores(tf, 2);
            else
                tf.setForeground(new Color(46,184,46));
        }
        catch (exceptionErroresColores e){            
            setColorException(e.getTextField(), e.getCaso());
        }
    }
    
    /**
     * El tipo de color que se le va a asignar al text field según el tipo de error
     * @param tf text field al que se le aplica
     * @param caso caso que es
     */
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
    
    /**
     * fución para validar un string
     * @param cadena string que va a validar
     * @param patt expresión regular que va a validar el string
     * @return retorna un boleano que dice si coincide la expresión regular con la cadena o no
     */
    public boolean validar(String cadena, String patt){
        boolean match = false;
        Pattern pat = Pattern.compile(patt);
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) 
            match = true;
        return match;
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
            java.util.logging.Logger.getLogger(VRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bLupa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jpCuenta;
    private javax.swing.JPanel jpJugador;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfCalle;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfCp;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfNickname;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNro;
    private javax.swing.JTextField tfPais;
    private javax.swing.JPasswordField tfPass1;
    private javax.swing.JPasswordField tfPass2;
    private javax.swing.JTextField tfPiso;
    private javax.swing.JTextField tfSueldo;
    private javax.swing.JTextField tfTel;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
