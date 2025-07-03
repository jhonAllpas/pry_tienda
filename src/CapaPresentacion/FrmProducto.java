/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion;

import CapaDatos.M_Producto;
import CapaLogica.Conexion;
import CapaLogica.N_Producto;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Jhon Allpas
 */
public class FrmProducto extends javax.swing.JFrame {
private Conexion SQL = new Conexion();
private Connection cn=SQL.conectar();
int contador=0;
private String accion="guardar";

    public FrmProducto() {
        initComponents();
        mostrar("");
        inhabilitar();
        cargar_categoria();
        txtidcategoria.setVisible(false);
        ocultar_columnas();
        
    }

void mostrar(String buscar){
    try{
        DefaultTableModel modelo;
        N_Producto func = new N_Producto();
        modelo=func.mostrar(buscar);
        tablalistado.setModel(modelo);
        
    } catch (Exception e){
        JOptionPane.showConfirmDialog(rootPane, e);
    }
}

private void cargar_categoria(){
    String sql="sp_listar_categoria";
    try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cbocategoria.addItem(rs.getString("descripcion"));
                
            }
            contador++;
        }catch (SQLException ex){
           Logger.getLogger(FrmProducto.class.getName()).log(Level.SEVERE,null,ex);
        }
            
    }

public void inhabilitar(){
    txtidproducto.setEnabled(false);
    txtserie.setEnabled(false);
    txtproducto.setEnabled(false);
    txtpreciocompra.setEnabled(false);
    txtprecioventa.setEnabled(false);
    dcfecha_ingreso.setEnabled(false);
    dcfecha_vencimiento.setEnabled(false);
    cbocategoria.setEnabled(false);
    txtidcategoria.setEnabled(false);
    txtbuscar.setEnabled(false);
    
    btnbuscar.setEnabled(false);
    btnguardar.setEnabled(false);
    btneliminar.setEnabled(false);
    
    btnnuevo.setEnabled(true);
    btnsalir.setEnabled(true);
    
}

public void habilitar(){
    txtidproducto.setEnabled(true);
    txtserie.setEnabled(true);
    txtproducto.setEnabled(true);
    txtpreciocompra.setEnabled(true);
    txtprecioventa.setEnabled(true);
    dcfecha_ingreso.setEnabled(true);
    dcfecha_vencimiento.setEnabled(true);
    cbocategoria.setEnabled(true);
    txtidcategoria.setEnabled(true);
    txtbuscar.setEnabled(true);
    
    btnbuscar.setEnabled(true);
    btnguardar.setEnabled(true);
    btneliminar.setEnabled(true);
    
 }

public void limpiar(){
    txtidproducto.setText("");
    txtserie.setText("");
    txtproducto.setText("");
    txtpreciocompra.setText("");
    txtprecioventa.setText("");
    cbocategoria.setSelectedIndex(0);
}

void ocultar_columnas(){
    tablalistado.getColumnModel().getColumn(8).setMaxWidth(0);
    tablalistado.getColumnModel().getColumn(8).setMinWidth(0);
    tablalistado.getColumnModel().getColumn(8).setPreferredWidth(0);
}
 
void generarid(){
    N_Producto func = new N_Producto();
    DecimalFormat formato = new DecimalFormat("0000");
    txtidproducto.setText(formato.format(func.generarIdProducto()));
    
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidproducto = new javax.swing.JTextField();
        txtserie = new javax.swing.JTextField();
        txtproducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpreciocompra = new javax.swing.JTextField();
        txtprecioventa = new javax.swing.JTextField();
        txtidcategoria = new javax.swing.JTextField();
        cbocategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dcfecha_ingreso = new com.toedter.calendar.JDateChooser();
        dcfecha_vencimiento = new com.toedter.calendar.JDateChooser();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Producto"));

        jLabel1.setText("Código:");

        jLabel2.setText("Serie:");

        jLabel3.setText("Producto:");

        txtidproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidproductoActionPerformed(evt);
            }
        });

        jLabel4.setText("Precio Compra:");

        jLabel5.setText("Precio Venta:");

        jLabel6.setText("Categoria:");

        cbocategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocategoriaActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha Ingreso:");

        jLabel8.setText("Fecha Vencimiento:");

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcfecha_ingreso, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(dcfecha_vencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtidcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btneliminar))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addComponent(dcfecha_ingreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnnuevo))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(dcfecha_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnguardar)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtidcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel9.setText("Buscar por Nombre:");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnbuscar)
                        .addGap(43, 43, 43)
                        .addComponent(btnsalir)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(btnsalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidproductoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void cbocategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocategoriaActionPerformed
       try{
           Statement st = cn.createStatement();
           if (contador >=0){
               String sql="select * from categoria where descripcion='"+ cbocategoria.getSelectedItem()+"'";
               ResultSet rs=st.executeQuery(sql);
               rs.next();
               this.txtidcategoria.setText(String.valueOf(rs.getInt("idcategoria")));
           }
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_cbocategoriaActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        accion="guardar";
        btnguardar.setText("Guardar");
        habilitar();
        limpiar();
        generarid();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
     M_Producto dts=new M_Producto();
     N_Producto func=new N_Producto(); 
     
     if(!txtidproducto.getText().equals("")&& !txtserie.getText().equals("")){
         int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Deseas eliminar el producto","Confirmar",2);
         if (confirmacion==0){
             dts.setIdproducto(txtidproducto.getText());
             func.eliminar(dts);
             mostrar("");
             inhabilitar();
         }
     }else {
           JOptionPane.showConfirmDialog(rootPane, "Debe seleccionar un producto","Producto",JOptionPane.WARNING_MESSAGE);
     }
     
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
       dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
       btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion="editar";
        int fila=tablalistado.rowAtPoint(evt.getPoint());
        
        txtidproducto.setText(tablalistado.getValueAt(fila,0).toString());
        txtserie.setText(tablalistado.getValueAt(fila,1).toString());
        txtproducto.setText(tablalistado.getValueAt(fila,2).toString());
        dcfecha_ingreso.setDate(java.sql.Date.valueOf(tablalistado.getValueAt(fila, 3).toString()));
        dcfecha_vencimiento.setDate(java.sql.Date.valueOf(tablalistado.getValueAt(fila, 4).toString()));
        txtpreciocompra.setText(tablalistado.getValueAt(fila,5).toString());
        txtprecioventa.setText(tablalistado.getValueAt(fila,6).toString());
        txtidcategoria.setText(tablalistado.getValueAt(fila,7).toString());
        cbocategoria.setSelectedItem(tablalistado.getValueAt(fila, 8).toString());

    }//GEN-LAST:event_tablalistadoMouseClicked
   
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
       if(txtidproducto.getText().length()==0){
           JOptionPane.showConfirmDialog(rootPane,"Ingrese Producto");
           txtproducto.requestFocus();
           return;
       }
       if(txtprecioventa.getText().length()==0){
           JOptionPane.showConfirmDialog(rootPane,"Ingrese precio venta");
           txtprecioventa.requestFocus();
           return;
       }
       if(txtpreciocompra.getText().length()==0){
           JOptionPane.showConfirmDialog(rootPane,"Ingrese precio compra");
           txtpreciocompra.requestFocus();
           return;
       }
        M_Producto dts=new M_Producto();
        N_Producto func=new N_Producto();
        
        dts.setIdproducto(txtidproducto.getText());
        dts.setSerie(txtserie.getText());
        dts.setSerie(txtserie.getText());
        dts.setP_venta(Double.parseDouble(txtprecioventa.getText()));
        dts.setP_compra(Double.parseDouble(txtpreciocompra.getText()));
        
        Calendar cal;
//        int d,m,a;
        
        cal=dcfecha_ingreso.getCalendar();
//        d=cal.get(Calendar.DAY_OF_MONTH);
//        m=cal.get(Calendar.MONTH);
//        a=cal.get(Calendar.YEAR);
        dts.setF_ingreso(new Date(cal.getTimeInMillis()));
        cal = dcfecha_vencimiento.getCalendar();
        dts.setF_vencimiento(new Date(cal.getTimeInMillis()));
        dts.setIdcategoria(Integer.parseInt(txtidcategoria.getText()));
        
        if (accion.equals("guardar")){
            if (func.insertar(dts)){
                JOptionPane.showMessageDialog(rootPane, "Cliente Registrado");
                mostrar("");
                limpiar();
                inhabilitar();
                
            }
        }else if (accion.equals("editar")){
            if (func.editar(dts)){
                JOptionPane.showMessageDialog(rootPane, "Cliente editado con exito");
                mostrar("");
                limpiar();
                inhabilitar();
            }
        
        }
    }//GEN-LAST:event_btnguardarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbocategoria;
    private com.toedter.calendar.JDateChooser dcfecha_ingreso;
    private com.toedter.calendar.JDateChooser dcfecha_vencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtidcategoria;
    private javax.swing.JTextField txtidproducto;
    private javax.swing.JTextField txtpreciocompra;
    private javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtproducto;
    private javax.swing.JTextField txtserie;
    // End of variables declaration//GEN-END:variables
}
