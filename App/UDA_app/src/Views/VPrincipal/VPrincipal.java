package Views.VPrincipal;

import control.controlador;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 * @since 0.1 alpha
 */

public class VPrincipal extends javax.swing.JFrame {
    static boolean modoayuda = controlador.modoayuda;
    /**
     * Crea una ventana nueva VPrincipal
     */
    //Set de iconos https://www.iconfinder.com/iconsets/customicondesign-mini-deepcolour-png
    public VPrincipal(){
        initComponents();
        //Vamos a llamar a una función que oculte las opciones para el administrador y para un usuario loggeado
        inicializarVentana();
        
    }
    
    /**
     * Código generado, no modificar
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfMensaje1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfMensaje2 = new javax.swing.JLabel();
        tfMensaje3 = new javax.swing.JLabel();
        tfMensaje4 = new javax.swing.JLabel();
        Ayuda = new javax.swing.JLabel();
        TextoAyuda2 = new javax.swing.JLabel();
        TextoAyuda1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuOpciones = new javax.swing.JMenu();
        jmLogin = new javax.swing.JMenuItem();
        jmCs = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenuItem();
        jmHerramientas = new javax.swing.JMenu();
        jmRegistrar = new javax.swing.JMenu();
        jmCUsuario = new javax.swing.JMenuItem();
        jmCJugador = new javax.swing.JMenuItem();
        jmCDueno = new javax.swing.JMenuItem();
        jmCEquipo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmCLiga = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmCAdmin = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmModUsu = new javax.swing.JMenuItem();
        jmModJugador = new javax.swing.JMenuItem();
        jmModDue = new javax.swing.JMenuItem();
        jmModEquipo = new javax.swing.JMenuItem();
        jmEliminar = new javax.swing.JMenu();
        jmDelUsu = new javax.swing.JMenuItem();
        jmDelJug = new javax.swing.JMenuItem();
        jmDelDue = new javax.swing.JMenuItem();
        jmDelEquipo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmListar = new javax.swing.JMenu();
        jmListUsu = new javax.swing.JMenuItem();
        jmListJug = new javax.swing.JMenuItem();
        jmListDue = new javax.swing.JMenuItem();
        jmListEqui = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmListLig = new javax.swing.JMenuItem();
        jmListPart = new javax.swing.JMenuItem();
        jmListJorn = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmListAdmin = new javax.swing.JMenuItem();
        jmPuntuacion = new javax.swing.JMenu();
        jmResultados = new javax.swing.JMenu();
        jmClasificacion = new javax.swing.JMenuItem();
        jmJornadas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestor e-sports");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tfMensaje1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tfMensaje1.setForeground(new java.awt.Color(255, 0, 0));
        tfMensaje1.setText("Por favor, inicie sesión. Opciones>>Login.");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/recursos/Logo_grande.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bienvenido/a al gestor de e-sports");

        tfMensaje2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tfMensaje2.setForeground(new java.awt.Color(255, 0, 0));
        tfMensaje2.setText("o");

        tfMensaje3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tfMensaje3.setForeground(new java.awt.Color(255, 0, 0));
        tfMensaje3.setText("haz click");

        tfMensaje4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tfMensaje4.setForeground(new java.awt.Color(0, 0, 255));
        tfMensaje4.setText("aquí");
        tfMensaje4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfMensaje4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfMensaje4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfMensaje4MouseExited(evt);
            }
        });

        Ayuda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        Ayuda.setForeground(new java.awt.Color(0, 0, 0));
        Ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/b_help.png"))); // NOI18N
        Ayuda.setText("Ayuda");
        Ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AyudaMouseClicked(evt);
            }
        });

        TextoAyuda2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        TextoAyuda2.setText("Texto ayuda");

        TextoAyuda1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        TextoAyuda1.setText("Texto ayuda");

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 2, 2, new java.awt.Color(153, 153, 153)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/Gif.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ayuda)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMensaje1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(156, 156, 156)
                                    .addComponent(tfMensaje2)
                                    .addGap(31, 31, 31))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(105, 105, 105)
                                    .addComponent(tfMensaje3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfMensaje4)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextoAyuda2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextoAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfMensaje1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMensaje2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMensaje4)
                    .addComponent(tfMensaje3))
                .addGap(70, 70, 70)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(TextoAyuda1)
                .addGap(18, 18, 18)
                .addComponent(TextoAyuda2)
                .addGap(68, 68, 68)
                .addComponent(Ayuda)
                .addGap(8, 8, 8))
        );

        MenuOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/configuration_icon.png"))); // NOI18N
        MenuOpciones.setText("Opciones");
        MenuOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuOpcionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuOpcionesMouseExited(evt);
            }
        });

        jmLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/login_icon.png"))); // NOI18N
        jmLogin.setText("Login");
        jmLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLoginActionPerformed(evt);
            }
        });
        MenuOpciones.add(jmLogin);

        jmCs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/loout_icon.png"))); // NOI18N
        jmCs.setText("Cerrar sesión");
        jmCs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCsActionPerformed(evt);
            }
        });
        MenuOpciones.add(jmCs);

        jmSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/exit_icon.png"))); // NOI18N
        jmSalir.setText("Salir");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        MenuOpciones.add(jmSalir);

        jMenuBar1.add(MenuOpciones);

        jmHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/herramientas_icon.png"))); // NOI18N
        jmHerramientas.setText("Herramientas");

        jmRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/add_file_icon.png"))); // NOI18N
        jmRegistrar.setText("Registrar");

        jmCUsuario.setText("Usuario");
        jmCUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCUsuarioActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmCUsuario);

        jmCJugador.setText("Jugador");
        jmCJugador.setToolTipText("");
        jmCJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCJugadorActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmCJugador);

        jmCDueno.setText("Dueño");
        jmCDueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCDuenoActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmCDueno);

        jmCEquipo.setText("Equipo");
        jmCEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCEquipoActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmCEquipo);
        jmRegistrar.add(jSeparator1);

        jmCLiga.setText("Liga");
        jmCLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCLigaActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmCLiga);
        jmRegistrar.add(jSeparator2);

        jmCAdmin.setText("Aministrador");
        jmCAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCAdminActionPerformed(evt);
            }
        });
        jmRegistrar.add(jmCAdmin);

        jmHerramientas.add(jmRegistrar);

        jMenu3.setBorder(null);
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/edit_icon.png"))); // NOI18N
        jMenu3.setText("Modificar");
        jMenu3.setBorderPainted(false);

        jmModUsu.setText("Usuario");
        jmModUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModUsuActionPerformed(evt);
            }
        });
        jMenu3.add(jmModUsu);

        jmModJugador.setText("Jugador");
        jmModJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModJugadorActionPerformed(evt);
            }
        });
        jMenu3.add(jmModJugador);

        jmModDue.setText("Dueño");
        jmModDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModDueActionPerformed(evt);
            }
        });
        jMenu3.add(jmModDue);

        jmModEquipo.setText("Equipo");
        jmModEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModEquipoActionPerformed(evt);
            }
        });
        jMenu3.add(jmModEquipo);

        jmHerramientas.add(jMenu3);

        jmEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/delete_icon.png"))); // NOI18N
        jmEliminar.setText("Eliminar");

        jmDelUsu.setText("Usuario");
        jmDelUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelUsuActionPerformed(evt);
            }
        });
        jmEliminar.add(jmDelUsu);

        jmDelJug.setText("Jugador");
        jmDelJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelJugActionPerformed(evt);
            }
        });
        jmEliminar.add(jmDelJug);

        jmDelDue.setText("Dueño");
        jmDelDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelDueActionPerformed(evt);
            }
        });
        jmEliminar.add(jmDelDue);

        jmDelEquipo.setText("Equipo");
        jmDelEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDelEquipoActionPerformed(evt);
            }
        });
        jmEliminar.add(jmDelEquipo);
        jmEliminar.add(jSeparator5);

        jMenuItem1.setText("Liga");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmEliminar.add(jMenuItem1);

        jmHerramientas.add(jmEliminar);

        jmListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/info_icon.png"))); // NOI18N
        jmListar.setText("Listar");

        jmListUsu.setText("Usuarios");
        jmListUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListUsuActionPerformed(evt);
            }
        });
        jmListar.add(jmListUsu);

        jmListJug.setText("Jugadores");
        jmListJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListJugActionPerformed(evt);
            }
        });
        jmListar.add(jmListJug);

        jmListDue.setText("Dueños");
        jmListDue.setToolTipText("");
        jmListDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListDueActionPerformed(evt);
            }
        });
        jmListar.add(jmListDue);

        jmListEqui.setText("Equipos");
        jmListEqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListEquiActionPerformed(evt);
            }
        });
        jmListar.add(jmListEqui);
        jmListar.add(jSeparator4);

        jmListLig.setText("Ligas");
        jmListLig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListLigActionPerformed(evt);
            }
        });
        jmListar.add(jmListLig);

        jmListPart.setText("Partidos");
        jmListPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListPartActionPerformed(evt);
            }
        });
        jmListar.add(jmListPart);

        jmListJorn.setText("Jornadas");
        jmListJorn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListJornActionPerformed(evt);
            }
        });
        jmListar.add(jmListJorn);
        jmListar.add(jSeparator3);

        jmListAdmin.setText("Administradores");
        jmListAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListAdminActionPerformed(evt);
            }
        });
        jmListar.add(jmListAdmin);

        jmHerramientas.add(jmListar);

        jMenuBar1.add(jmHerramientas);

        jmPuntuacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/save_icon.png"))); // NOI18N
        jmPuntuacion.setText("Gestión de puntuación");
        jmPuntuacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmPuntuacionMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmPuntuacion);

        jmResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/VPrincipal/calendar_icon.png"))); // NOI18N
        jmResultados.setText("Resultados y datos");
        jmResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jmResultadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jmResultadosMouseExited(evt);
            }
        });

        jmClasificacion.setText("Clasificación");
        jmClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClasificacionActionPerformed(evt);
            }
        });
        jmResultados.add(jmClasificacion);

        jmJornadas.setText("Jornadas");
        jmJornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmJornadasActionPerformed(evt);
            }
        });
        jmResultados.add(jmJornadas);

        jMenuBar1.add(jmResultados);

        setJMenuBar(jMenuBar1);

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
     * Action performed del java menú Login que lleva a la ventana VLogin
     * @param evt Evento proporcinado de la ventana
     */
    private void jmLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLoginActionPerformed
        //Funcion que abre la ventana login
        control.controlador.toVLogin(this);
    }//GEN-LAST:event_jmLoginActionPerformed
    
    /**
     * Click del mouse al label que redirige a la ventana VLogin
     * @param evt Evento proporcinado de la ventana
     */
    private void tfMensaje4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMensaje4MouseClicked
        controlador.toVLogin(this);
    }//GEN-LAST:event_tfMensaje4MouseClicked
    
    /**
     * Click del mouse del label para activar la ayuda en la ventana
     * @param evt Evento proporcinado de la ventana
     */
    private void AyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AyudaMouseClicked
        //Muestra la caja de ayuda o la oculta si se desactiva la ayuda
        if (modoayuda == false) { 
            modoayuda = true;
            Ayuda.setText("Cerrar ayuda");
            controlador.JDInfo(this, true, "Modo ayuda activado, sitúa el ratón sobre", "las opciones que quieras saber qué hacen");
        }else{
            modoayuda = false;
            controlador.JDInfo(this, true, "Modo ayuda desactivado");
            Ayuda.setText("Ayuda");
        }
        System.out.println("Modo ayuda: " + modoayuda);
    }//GEN-LAST:event_AyudaMouseClicked
    
    /**
     * Evento del mouse flotando encima del java menú opciones que te da información de la ayuda
     * @param evt Evento proporcinado de la ventana
     */
    private void MenuOpcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuOpcionesMouseEntered
        //Ayuda opciones
        if(modoayuda)
        {
            TextoAyuda1.setText("Aquí podrás hacer login, cerrar sesión o");
            TextoAyuda2.setText("salir de la app");
        }    
    }//GEN-LAST:event_MenuOpcionesMouseEntered
    
    /**
     * Evento del mouse cuando deja de flotar encima del java menú opciones que restablece el texto de ayuda
     * @param evt Evento proporcinado de la ventana
     */
    private void MenuOpcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuOpcionesMouseExited
        //Borra ayuda de opciones
        TextoAyuda1.setText(" ");
        TextoAyuda2.setText(" ");
    }//GEN-LAST:event_MenuOpcionesMouseExited
    
    /**
     * Action performed del java menú salir que acaba el programa
     * @param evt Evento proporcinado de la ventana
     */
    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
        //Cerrar todo
        controlador.JDInfo(this, true, "Cerrando sesión...");
        System.exit(0);
    }//GEN-LAST:event_jmSalirActionPerformed
    
    /**
     * Evento del mouse flotando encima del java menú resultados que te da información de la ayuda
     * @param evt Evento proporcinado de la ventana
     */
    private void jmResultadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmResultadosMouseEntered
        //Ayuda resultados
        if(modoayuda)
        {
            TextoAyuda1.setText("Aquí podrás consultar resultados de partidos y ver");
            TextoAyuda2.setText("futuros partidos en detalle");    
        }    
    }//GEN-LAST:event_jmResultadosMouseEntered
    
    /**
     * Evento del mouse cuando deja de flotar encima del java menú resultados que restablece el texto de ayuda
     * @param evt Evento proporcinado de la ventana
     */
    private void jmResultadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmResultadosMouseExited
        //Borra ayuda de resultados
        TextoAyuda1.setText(" ");
        TextoAyuda2.setText(" ");
    }//GEN-LAST:event_jmResultadosMouseExited
    
    /**
     * Evento del mouse flotando encima del label tfMensaje que te da información de la ayuda
     * @param evt Evento proporcinado de la ventana
     */
    private void tfMensaje4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMensaje4MouseEntered
        if(modoayuda)   
            TextoAyuda1.setText("Haciendo click aquí podras hacer login");
    }//GEN-LAST:event_tfMensaje4MouseEntered
    
    /**
     * Evento del mouse cuando deja de flotar encima del label tfMensaje que restablece el texto de ayuda
     * @param evt Evento proporcinado de la ventana
     */
    private void tfMensaje4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMensaje4MouseExited
        TextoAyuda1.setText(" ");
        
    }//GEN-LAST:event_tfMensaje4MouseExited
    
    /**
     * Action performed del java menú cerrar sesión que muestra una JDInfo y acaba el programa
     * @param evt Evento proporcinado de la ventana
     */
    private void jmCsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCsActionPerformed
        controlador.JDInfo(this, true, "Se va a cerrar la sesión...");
        controlador.cerrarSesion();
        controlador.toVPrincipal(this);
    }//GEN-LAST:event_jmCsActionPerformed
    
    /**
     * Action performed de el java menú crear liga que lleva a la ventana JFLiga
     * @param evt Evento proporcinado de la ventana
     */
    private void jmCLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCLigaActionPerformed
        controlador.toJFLiga(this);
    }//GEN-LAST:event_jmCLigaActionPerformed
    
    /**
     * Action performed de el java menú crear usuario que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmCUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCUsuarioActionPerformed
       controlador.toVRegistro(this, 1, "Nuevo Usuario", 1);
    }//GEN-LAST:event_jmCUsuarioActionPerformed
    
    /**
     * Action performed de el java menú crear jugador que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmCJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCJugadorActionPerformed
        controlador.toVRegistro(this, 2, "Nuevo Jugador", 1);
    }//GEN-LAST:event_jmCJugadorActionPerformed

    /**
     * Action performed de el java menú crear dueño que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmCDuenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCDuenoActionPerformed
        controlador.toVRegistro(this, 1, "Nuevo Dueño", 1);
    }//GEN-LAST:event_jmCDuenoActionPerformed

    /**
     * Action performed de el java menú crear equipo que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmCEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCEquipoActionPerformed
        controlador.toVEquipo(this, 0);
    }//GEN-LAST:event_jmCEquipoActionPerformed
    
    /**
     * Action performed de el java menú gestión de puntuación que lleva a la ventana VPuntos
     * @param evt Evento proporcinado de la ventana
     */
    private void jmPuntuacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmPuntuacionMouseClicked
        controlador.toVPuntos(this);
    }//GEN-LAST:event_jmPuntuacionMouseClicked
    
    /**
     * Evento cuando se va a cerrar la ventana que mustra un JDInfo y termina el programa
     * @param evt Evento proporcinado de la ventana
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(controlador.usu!=null)
            controlador.JDInfo(this, true, "Cerrando sesión...");
        controlador.exit();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Action performed de el java menú crear clasificación que lleva a la ventana VClasificacion
     * @param evt Evento proporcinado de la ventana
     */
    private void jmClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClasificacionActionPerformed
        try 
        {
            controlador.toVClasificacion(this);
        } 
        catch (IOException ex) {
        }
    }//GEN-LAST:event_jmClasificacionActionPerformed

    /**
     * Action performed de el java menú crear administrador que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmCAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCAdminActionPerformed
        controlador.toVRegistro(this, 1, "Nuevo Admin", 1);
    }//GEN-LAST:event_jmCAdminActionPerformed

    /**
     * Action performed de el java menú crear dueño que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmModUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModUsuActionPerformed
        controlador.toVRegistro(this, 3, "Modificar Usuario", 1);
    }//GEN-LAST:event_jmModUsuActionPerformed

    /**
     * Action performed de el java menú modificar jugador que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmModJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModJugadorActionPerformed
        controlador.toVRegistro(this, 4, "Modificar Jugador", 1);
    }//GEN-LAST:event_jmModJugadorActionPerformed

    /**
     * Action performed de el java menú modificar dueño que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmModDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModDueActionPerformed
        controlador.toVRegistro(this, 5, "Modificar Dueño", 1);
    }//GEN-LAST:event_jmModDueActionPerformed

    /**
     * Action performed de el java menú modificar equipo que lleva a la ventana VRegistro
     * @param evt Evento proporcinado de la ventana
     */
    private void jmModEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModEquipoActionPerformed
        controlador.toVEquipo(this, 1);
    }//GEN-LAST:event_jmModEquipoActionPerformed

    /**
     * Action performed de el java menú jornadas que lleva a la ventana VJornadas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmJornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmJornadasActionPerformed
        try {
            controlador.toVJornadas(this);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jmJornadasActionPerformed

    /**
     * Action performed de el java menú listar usuarios que lleva a la ventana VPersonas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListUsuActionPerformed
        controlador.toVPersonas(this, "usuario");
    }//GEN-LAST:event_jmListUsuActionPerformed

    /**
     * Action performed de el java menú listar dueños que lleva a la ventana VPersonas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListDueActionPerformed
        controlador.toVPersonas(this, "dueno");
    }//GEN-LAST:event_jmListDueActionPerformed

    /**
     * Action performed de el java menú listar administradores que lleva a la ventana VPersonas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListAdminActionPerformed
        controlador.toVPersonas(this, "admin");
    }//GEN-LAST:event_jmListAdminActionPerformed

    /**
     * Action performed de el java menú listar jugadores que lleva a la ventana VPersonas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListJugActionPerformed
        controlador.toVJugadores(this);
    }//GEN-LAST:event_jmListJugActionPerformed

    /**
     * Action performed de el java menú listar equipos que lleva a la ventana VPersonas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListEquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListEquiActionPerformed
        controlador.toVequipos(this);
    }//GEN-LAST:event_jmListEquiActionPerformed

    /**
     * Action performed del java menu eliminar usuario que lleva a la ventana JDEliminar
     * @param evt Evento proporcinado de la ventana
     */
    private void jmDelUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelUsuActionPerformed
        controlador.JDEliminar(this, true, "usuario");
    }//GEN-LAST:event_jmDelUsuActionPerformed

    /**
     * Action performed del java menu eliminar jugador que lleva a la ventana JDEliminar
     * @param evt Evento proporcinado de la ventana
     */
    private void jmDelJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelJugActionPerformed
        controlador.JDEliminar(this, true, "jugador");
    }//GEN-LAST:event_jmDelJugActionPerformed

    /**
     * Action performed del java menu eliminar dueño que lleva a la ventana JDEliminar
     * @param evt Evento proporcinado de la ventana
     */
    private void jmDelDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelDueActionPerformed
        controlador.JDEliminar(this, true, "dueno");
    }//GEN-LAST:event_jmDelDueActionPerformed

    /**
     * Action performed del java menu eliminar equipo que lleva a la ventana JDEliminar
     * @param evt Evento proporcinado de la ventana
     */
    private void jmDelEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDelEquipoActionPerformed
        controlador.JDEliminar(this, true, "equipo");
    }//GEN-LAST:event_jmDelEquipoActionPerformed

    /**
     * Action performed del java menu listar liga que lleva a la ventana VLigas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListLigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListLigActionPerformed
        controlador.toVLigas(this);
    }//GEN-LAST:event_jmListLigActionPerformed

    /**
     * Action performed del java menu listar partido que lleva a la ventana Vpartidos
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListPartActionPerformed
        controlador.toVpartidos(this);
    }//GEN-LAST:event_jmListPartActionPerformed

    /**
     * Action performed del java menu listar jornadas que lleva a la ventana VJornadas
     * @param evt Evento proporcinado de la ventana
     */
    private void jmListJornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListJornActionPerformed
        controlador.toVLJornadas(this);     
    }//GEN-LAST:event_jmListJornActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        controlador.JDEliminar(this, true, "liga");
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    /**
     * Función que establece la ventana si ha habido un inicio de sesión o no habilitando o desabilitando funciones dependiendo del tipo de usuario
     */
    public void inicializarVentana(){
        try
        {
            TextoAyuda1.setText(" ");
            TextoAyuda2.setText(" ");
            setLocationRelativeTo(null);
            TextoAyuda2.setText(" ");
            //Esta opción nos va a asignar un favicon a nusetro proyecto
            Image i = ImageIO.read(getClass().getResource("/Views/recursos/logo_u_favicon.png"));
            setIconImage(i);
            
            if(controlador.usu == null)
            {
                jmCs.setVisible(false);
                jmHerramientas.setVisible(false);
                jmPuntuacion.setVisible(false);
                jmResultados.setVisible(false);
                tfMensaje1.setText("Por favor, inicie sesión. Opciones>>Login.");
                tfMensaje2.setText("o");
                tfMensaje1.setForeground(Color.red);
                tfMensaje2.setForeground(Color.red);
                tfMensaje3.setText("haz click");
                tfMensaje4.setText("aquí");
            }
            else
            {
                if(controlador.usu.getPersonaDni().getTipoPersona() != null)
                {
                    switch(controlador.usu.getPersonaDni().getTipoPersona())
                    {
                        case "admin": 
                            setInicioSesion();
                        break;
                    
                        case "usuario":
                            setInicioSesion();
                            jmHerramientas.setVisible(false);
                            jmPuntuacion.setVisible(false);
                        break;
                    } 
                }    
                else
                {
                    setInicioSesion();
                    jmRegistrar.setVisible(false);
                    jmListar.setVisible(false);
                    jmEliminar.setVisible(false);
                    jmModUsu.setVisible(false);
                    jmModDue.setVisible(false);
                    jmPuntuacion.setVisible(false);
                }               
            }
        }
        catch(Exception e){
            controlador.JDError(this, true, "Error en ventana principal");
        }

    }
    
    /**
     * Establece los labels con el nombre del usuario y colores adecuados
     */
    public void setInicioSesion(){
        tfMensaje1.setText("             Bienvenido/a de nuevo");
        tfMensaje2.setText(controlador.usu.getPersonaDni().getNombre());
        tfMensaje1.setForeground(new Color(153,153,153));
        tfMensaje2.setForeground(new Color(153,153,153));
        tfMensaje3.setText(" ");
        tfMensaje4.setText(" ");
        jmLogin.setVisible(false);
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
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ayuda;
    private javax.swing.JMenu MenuOpciones;
    private javax.swing.JLabel TextoAyuda1;
    private javax.swing.JLabel TextoAyuda2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuItem jmCAdmin;
    private javax.swing.JMenuItem jmCDueno;
    private javax.swing.JMenuItem jmCEquipo;
    private javax.swing.JMenuItem jmCJugador;
    private javax.swing.JMenuItem jmCLiga;
    private javax.swing.JMenuItem jmCUsuario;
    private javax.swing.JMenuItem jmClasificacion;
    private javax.swing.JMenuItem jmCs;
    private javax.swing.JMenuItem jmDelDue;
    private javax.swing.JMenuItem jmDelEquipo;
    private javax.swing.JMenuItem jmDelJug;
    private javax.swing.JMenuItem jmDelUsu;
    private javax.swing.JMenu jmEliminar;
    private javax.swing.JMenu jmHerramientas;
    private javax.swing.JMenuItem jmJornadas;
    private javax.swing.JMenuItem jmListAdmin;
    private javax.swing.JMenuItem jmListDue;
    private javax.swing.JMenuItem jmListEqui;
    private javax.swing.JMenuItem jmListJorn;
    private javax.swing.JMenuItem jmListJug;
    private javax.swing.JMenuItem jmListLig;
    private javax.swing.JMenuItem jmListPart;
    private javax.swing.JMenuItem jmListUsu;
    private javax.swing.JMenu jmListar;
    private javax.swing.JMenuItem jmLogin;
    private javax.swing.JMenuItem jmModDue;
    private javax.swing.JMenuItem jmModEquipo;
    private javax.swing.JMenuItem jmModJugador;
    private javax.swing.JMenuItem jmModUsu;
    private javax.swing.JMenu jmPuntuacion;
    private javax.swing.JMenu jmRegistrar;
    private javax.swing.JMenu jmResultados;
    private javax.swing.JMenuItem jmSalir;
    private javax.swing.JLabel tfMensaje1;
    private javax.swing.JLabel tfMensaje2;
    private javax.swing.JLabel tfMensaje3;
    private javax.swing.JLabel tfMensaje4;
    // End of variables declaration//GEN-END:variables
}
