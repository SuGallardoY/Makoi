/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Producto;

/**
 *
 * @author Susana
 */
public class BorrarCliente extends javax.swing.JFrame {

    /**
     * Creates new form BuscarCliente
     */
    public BorrarCliente() {
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

        jLabel1 = new javax.swing.JLabel();
        LabelBuscarCliente = new javax.swing.JLabel();
        TextFieldRutCliente = new javax.swing.JTextField();
        ButtonBuscarCliente = new javax.swing.JButton();
        ButtonBorrarCliente = new javax.swing.JButton();
        ButtonCancelar = new javax.swing.JButton();
        LabelClienteEncontrado = new javax.swing.JLabel();
        TextFieldClienteEncontrado = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elimina un cliente");

        LabelBuscarCliente.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        LabelBuscarCliente.setText("Ingrese RUT de cliente: ");

        ButtonBuscarCliente.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonBuscarCliente.setText("BUSCAR");
        ButtonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarClienteActionPerformed(evt);
            }
        });

        ButtonBorrarCliente.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonBorrarCliente.setText("BORRAR CLENTE");
        ButtonBorrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBorrarClienteActionPerformed(evt);
            }
        });

        ButtonCancelar.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonCancelar.setText("CANCELAR");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        LabelClienteEncontrado.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        LabelClienteEncontrado.setText("Cliente encontrado: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelClienteEncontrado)
                            .addComponent(LabelBuscarCliente))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldRutCliente)
                            .addComponent(TextFieldClienteEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBuscarCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(ButtonBorrarCliente)
                        .addGap(104, 104, 104)
                        .addComponent(ButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBuscarCliente)
                    .addComponent(TextFieldRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBuscarCliente))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelClienteEncontrado)
                    .addComponent(TextFieldClienteEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonBorrarCliente)
                    .addComponent(ButtonCancelar))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonCancelarActionPerformed

    private void ButtonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarClienteActionPerformed
       int rut_cliente  = Integer.valueOf(TextFieldRutCliente.getText()) ;
        Controlador con = new Controlador();
        Cliente cliente = con.buscarPorRut(rut_cliente);
        if(cliente.getRut_cliente()!= 0){
           TextFieldClienteEncontrado.setText(String.valueOf(cliente.getRut_cliente()));
        }else{
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }//GEN-LAST:event_ButtonBuscarClienteActionPerformed

    private void ButtonBorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBorrarClienteActionPerformed
          int rut_cliente = Integer.parseInt(TextFieldRutCliente.getText());
        Controlador con = new Controlador();
        boolean eliminado = con.eliminarCliente(rut_cliente);
        
        if(eliminado){
            JOptionPane.showMessageDialog(null, "El cliente  ha sido eliminado");
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado un cliente para eliminar");}
    }//GEN-LAST:event_ButtonBorrarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(BorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBorrarCliente;
    private javax.swing.JButton ButtonBuscarCliente;
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JLabel LabelBuscarCliente;
    private javax.swing.JLabel LabelClienteEncontrado;
    private javax.swing.JTextField TextFieldClienteEncontrado;
    private javax.swing.JTextField TextFieldRutCliente;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
