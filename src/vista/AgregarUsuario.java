/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import modelo.Usuario;
import controlador.Controlador;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Susana
 */
public class AgregarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form AgregarUsuario
     */
    public AgregarUsuario() {
        initComponents();
          this.getContentPane().setBackground(new Color ( 201, 228, 197));
          
           Image  icon = new ImageIcon(getClass().getResource("/img/iconohojas.png")).getImage();
              setIconImage(icon);
              
               this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelUsuario = new javax.swing.JLabel();
        LabelPassword = new javax.swing.JLabel();
        TextFieldUsuario = new javax.swing.JTextField();
        PasswordFieldPassword = new javax.swing.JPasswordField();
        ButtonAgregarUsuario = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        ButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agrega un nuevo usuario");

        LabelUsuario.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        LabelUsuario.setText("Ingrese un nombre de usuario:");

        LabelPassword.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        LabelPassword.setText("Ingresa una contraseña: ");

        ButtonAgregarUsuario.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonAgregarUsuario.setText("AGREGAR");
        ButtonAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgregarUsuarioActionPerformed(evt);
            }
        });

        ButtonLimpiar.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonLimpiar.setText("LIMPIAR");
        ButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimpiarActionPerformed(evt);
            }
        });

        ButtonSalir.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonSalir.setText("SALIR");
        ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelUsuario)
                            .addComponent(LabelPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(PasswordFieldPassword))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ButtonAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(ButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(ButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelUsuario)
                    .addComponent(TextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPassword))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAgregarUsuario)
                    .addComponent(ButtonLimpiar)
                    .addComponent(ButtonSalir))
                .addGap(0, 113, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        String usuario, contraseña;
   

        usuario = TextFieldUsuario.getText();
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese nombre de usuario", "Validación", JOptionPane.WARNING_MESSAGE);
            TextFieldUsuario.requestFocus();
            return;
        }

        contraseña= PasswordFieldPassword.getText();
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese contraseña", "Validación", JOptionPane.WARNING_MESSAGE);
            PasswordFieldPassword.requestFocus();
            return;
        }

        Usuario usuario1= new Usuario(usuario, contraseña);

        Controlador con = new Controlador();

        if (con.buscarUsuario(usuario1.getUser()).getPassword() == null) {
            if (con.agregarUsuario(usuario1)) {
                JOptionPane.showMessageDialog(this, "Se agregó usuario " + usuario1.getUser(), "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se agregó usuario" + usuario1.getUser(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario " + usuario1.getUser() + " ya existe", "Información", JOptionPane.WARNING_MESSAGE);
        }
                                             
    }                                                    
   
    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
            TextFieldUsuario.setText("");
            PasswordFieldPassword.setText("");
             
            
            
         
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
       Principal prin = new Principal();
       prin.setVisible(true);       
        this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAgregarUsuario;
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPasswordField PasswordFieldPassword;
    private javax.swing.JTextField TextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}

