/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author Susana
 */
public class RevisarStock extends javax.swing.JFrame {

    /**
     * Creates new form RevisarStock
     */
    public RevisarStock() {
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

        LabelStock = new javax.swing.JLabel();
        ButtonBuscarStock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBStock = new javax.swing.JTable();
        ButtonSalir = new javax.swing.JButton();
        TextFieldBuscarProductos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Revisa el stock de los productos");

        LabelStock.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        LabelStock.setText("Filtrar por id: ");

        ButtonBuscarStock.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonBuscarStock.setText("VER PRODUCTOS");
        ButtonBuscarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarStockActionPerformed(evt);
            }
        });

        TBStock.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        TBStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre producto", "Stock"
            }
        ));
        jScrollPane1.setViewportView(TBStock);

        ButtonSalir.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        ButtonSalir.setText("SALIR");
        ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalirActionPerformed(evt);
            }
        });

        TextFieldBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldBuscarProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextFieldBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ButtonBuscarStock)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonSalir)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelStock)
                    .addComponent(TextFieldBuscarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonBuscarStock))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ButtonSalir)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
      this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed

    private void ButtonBuscarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarStockActionPerformed
         int id_producto;
        String nombre_producto, tipo_producto, material, color;
        int precio;
        int stock;


        Controlador con = new Controlador();
        DefaultTableModel modelo = (DefaultTableModel) TBStock.getModel();

        try {
            id_producto = Integer.parseInt(TextFieldBuscarProductos.getText());
        } catch (Exception e) {
            id_producto = 0;
        }

        modelo.setRowCount(0);

        if (id_producto == 0) { // listsr todos
            List<Producto> lista = con.MostrarTodosProductos();

            for (Producto tmp : lista) {
                nombre_producto = tmp.getNombre_producto();             
                stock = tmp.getStock();
                

                modelo.addRow(new Object[]{nombre_producto, stock});
            }

        } else { //consulta por id
            Producto producto = con.buscarPorId(id_producto);
            nombre_producto = producto.getNombre_producto();
            tipo_producto = producto.getTipo_producto();
            material = producto.getMaterial();
            color = producto.getColor();
            precio = producto.getPrecio();
            stock = producto.getStock();


            modelo.addRow(new Object[]{nombre_producto, stock});

        }
    }//GEN-LAST:event_ButtonBuscarStockActionPerformed

    private void TextFieldBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldBuscarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldBuscarProductosActionPerformed

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
            java.util.logging.Logger.getLogger(RevisarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RevisarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RevisarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RevisarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevisarStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscarStock;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JLabel LabelStock;
    private javax.swing.JTable TBStock;
    private javax.swing.JTextField TextFieldBuscarProductos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}