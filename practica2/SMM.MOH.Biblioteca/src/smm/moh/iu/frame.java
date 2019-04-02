package smm.moh.iu;





import java.awt.Color;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eyehalcon97
 */
public class frame extends javax.swing.JFrame {

    /**
     * Creates new form frame
     */
    boolean barraestado=true;
    Color color = new Color(0,0,0);
    Formas forma;
    Color colors[] = { Color.RED, Color.BLUE, Color.BLACK, Color.WHITE };
    public frame() {
        initComponents();
        this.setSize(800, 600);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        menu = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        pie = new javax.swing.JPanel();
        estado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        head = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        nav1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        nav2 = new javax.swing.JPanel();
        lapiz = new javax.swing.JToggleButton();
        linea = new javax.swing.JToggleButton();
        rectangulo = new javax.swing.JToggleButton();
        elipse = new javax.swing.JToggleButton();
        Editar = new javax.swing.JToggleButton();
        nav3 = new javax.swing.JPanel();
        colores = new javax.swing.JComboBox<>();
        nav4 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        relleno = new javax.swing.JToggleButton();
        transparencia = new javax.swing.JToggleButton();
        Alisar = new javax.swing.JToggleButton();
        lienzo2D = new smm.moh.graficos.Lienzo2D();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        FileNuevo = new javax.swing.JMenuItem();
        FileAbrir = new javax.swing.JMenuItem();
        FileGuardar = new javax.swing.JMenuItem();
        Edicion = new javax.swing.JMenu();
        EdicionVerbarra = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pie.setLayout(new java.awt.BorderLayout());

        estado.setText("Paint");
        pie.add(estado, java.awt.BorderLayout.PAGE_END);
        pie.add(jSeparator1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pie, java.awt.BorderLayout.PAGE_END);

        head.setLayout(new java.awt.GridLayout(1, 0));

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        nav1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/nuevo.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        nav1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/abrir.png"))); // NOI18N
        nav1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/Guardar.gif"))); // NOI18N
        nav1.add(jButton3);

        jPanel8.add(nav1);

        nav2.setLayout(new java.awt.GridLayout(1, 0));

        lapiz.setName("Lapiz");
        menu.add(lapiz);
        lapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/Lapiz.gif"))); // NOI18N
        lapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herramienta(evt);
            }
        });
        nav2.add(lapiz);

        linea.setName("Linea");
        menu.add(linea);
        linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/Linea.gif"))); // NOI18N
        linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herramienta(evt);
            }
        });
        nav2.add(linea);

        rectangulo.setName("Rectangulo");
        menu.add(rectangulo);
        rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/Rectangulo.gif"))); // NOI18N
        rectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herramienta(evt);
            }
        });
        nav2.add(rectangulo);

        elipse.setName("Elipse");
        menu.add(elipse);
        elipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/Ovalo.gif"))); // NOI18N
        elipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herramienta(evt);
            }
        });
        nav2.add(elipse);

        menu.add(Editar);
        Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/seleccion.png"))); // NOI18N
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herramienta(evt);
            }
        });
        nav2.add(Editar);

        jPanel8.add(nav2);

        nav3.setLayout(new java.awt.GridLayout(1, 0));

        colores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarillo", "Verde", "Azul", "Negro", "Blanco", "Rojo" }));
        nav3.add(colores);

        jPanel8.add(nav3);

        nav4.setLayout(new java.awt.GridLayout(1, 0));
        nav4.add(jSpinner1);

        relleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/rellenar.png"))); // NOI18N
        nav4.add(relleno);

        transparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/transparencia.png"))); // NOI18N
        nav4.add(transparencia);

        Alisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/alisar.png"))); // NOI18N
        nav4.add(Alisar);

        jPanel8.add(nav4);

        head.add(jPanel8);

        getContentPane().add(head, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(lienzo2D, java.awt.BorderLayout.CENTER);

        File.setText("Archivo");
        File.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FileMouseEntered(evt);
            }
        });
        File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileActionPerformed(evt);
            }
        });

        FileNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/NuevoBoceto.GIF"))); // NOI18N
        FileNuevo.setText("Nuevo");
        menu.add(FileNuevo);
        FileNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileNuevoActionPerformed(evt);
            }
        });
        File.add(FileNuevo);

        FileAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/abrir.png"))); // NOI18N
        FileAbrir.setText("Abrir");
        FileAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileAbrirActionPerformed(evt);
            }
        });
        File.add(FileAbrir);

        FileGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smm/moh/iu/Guardar.gif"))); // NOI18N
        FileGuardar.setText("Guardar");
        FileGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileGuardarActionPerformed(evt);
            }
        });
        File.add(FileGuardar);

        jMenuBar1.add(File);

        Edicion.setText("Edición");

        EdicionVerbarra.setSelected(true);
        EdicionVerbarra.setText("Ver barra de estado");
        EdicionVerbarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdicionVerbarraActionPerformed(evt);
            }
        });
        Edicion.add(EdicionVerbarra);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Ver barra de formas");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        Edicion.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Ver barra de atributos");
        Edicion.add(jCheckBoxMenuItem2);

        jMenuBar1.add(Edicion);

        jMenu1.setText("Imagen");

        jCheckBoxMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("Tamaño nueva Imagen");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_FileMouseEntered

    private void FileGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileGuardarActionPerformed
        // TODO add your handling code here:
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
        File f = dlg.getSelectedFile();
        }
    }//GEN-LAST:event_FileGuardarActionPerformed

    private void FileAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileAbrirActionPerformed
        // TODO add your handling code here:
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
        File f = dlg.getSelectedFile();
        }
    }//GEN-LAST:event_FileAbrirActionPerformed

    private void FileNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileNuevoActionPerformed
        // TODO add your handling code here:
         estado.setText("Paint");
        forma = null;
        color = new Color(0,0,0);

        menu.clearSelection();
        System.out.print("");
    }//GEN-LAST:event_FileNuevoActionPerformed

    private void EdicionVerbarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdicionVerbarraActionPerformed
        // TODO add your handling code here:
        barraestado = !barraestado;
        if(barraestado == false){
            estado.setText("");
        }else{
        estado.setText("Paint");
        }
    }//GEN-LAST:event_EdicionVerbarraActionPerformed

    private void herramienta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_herramienta
        // TODO add your handling code here:
        javax.swing.JToggleButton boton;
        boton = (javax.swing.JToggleButton) evt.getSource();
        if(boton.getName() == "Lapiz"){
            forma=Formas.PUNTO;
            
        }else
            if(boton.getName() == "Linea"){
                forma = Formas.LINEA;
            }else
                if(boton.getName() == "Rectangulo"){
                    forma = Formas.RECTANGULO;
                }else
                    if(boton.getName() == "Elipse"){
                        forma = Formas.ELIPSE;
                    }else
                        if(boton.getName() == "Editar"){
                            forma = Formas.EDITAR;
                        }
        estado.setText(forma.toString());
        lienzo2D.setFormas(forma);
        
    }//GEN-LAST:event_herramienta

    private void FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_FileActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    public void actualizarlienzo(){
        Color color= (Color.RED);
        
        
        
        
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
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Alisar;
    private javax.swing.JMenu Edicion;
    private javax.swing.JCheckBoxMenuItem EdicionVerbarra;
    private javax.swing.JToggleButton Editar;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem FileAbrir;
    private javax.swing.JMenuItem FileGuardar;
    private javax.swing.JMenuItem FileNuevo;
    private javax.swing.JComboBox<String> colores;
    private javax.swing.JToggleButton elipse;
    private javax.swing.JLabel estado;
    private javax.swing.JPanel head;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JToggleButton lapiz;
    private smm.moh.graficos.Lienzo2D lienzo2D;
    private javax.swing.JToggleButton linea;
    private javax.swing.ButtonGroup menu;
    private javax.swing.JPanel nav1;
    private javax.swing.JPanel nav2;
    private javax.swing.JPanel nav3;
    private javax.swing.JPanel nav4;
    private javax.swing.JPanel pie;
    private javax.swing.JToggleButton rectangulo;
    private javax.swing.JToggleButton relleno;
    private javax.swing.JToggleButton transparencia;
    // End of variables declaration//GEN-END:variables
}
