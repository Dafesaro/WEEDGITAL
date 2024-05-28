/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.weedgital;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel
 */
public class INVENTARIO extends javax.swing.JFrame {

    DefaultTableModel modelo;
    conexion co=new conexion();
    Connection conet;
    Statement st;
    ResultSet rs;
    int idc;
    int idc2;
    PRINCIPAL principal;
    
    public INVENTARIO() {
        initComponents();
        consultar();
        principal = new PRINCIPAL();
        principal.setVisible(true);
        
    }
    
    public JasperPrint reporteinventario() {
    conet=co.getConnection();
    InputStream inputStream= getClass().getResourceAsStream("/Reportes/weedigital.jasper");
    if (inputStream==null){
        System.out.println("No se encontró el reporte");
        return null;
    }
    try{
       JasperReport jr = (JasperReport)JRLoader.loadObject(inputStream);
       JasperPrint jp = JasperFillManager.fillReport(jr,null,conet);
       if(jp.getPages().isEmpty()){
           System.out.println("el reporte no tiene datos");
           return null;
       }
       return jp;
    }catch(JRException ex){
        System.out.println("Error al generar el reporte"+ex);
        ex.printStackTrace();
    } finally {
        try{
            inputStream.close();
        }catch (Exception ex){
            System.out.println("Error alc errar input"+ex);
            ex.printStackTrace();
        }
    }
    return null;
    
    
} 
    
            
            
            
    public void limpiar(){
    for (int i=0;i<=jinventario.getRowCount();i++)
    {
    modelo.removeRow(i);
    i=i-1;
     } 
    }
    
    public void Agregar(){
       
        String Nombre = nameprod.getText();
        String Descripcion = descripprod.getText();
        String Precio = precioprod.getText();
        String Cantidad = cantiprod.getText() ;
        
        
        
        try{
            String sql="insert into productos(Nombre,Descripción,Precio,Cantidad)"
                    + "values('"+Nombre+"','"+Descripcion+"','"+Precio+"','"+Cantidad+"')";
            conet=co.getConnection();
            st=conet.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"se ha ingresado el nuevo producto");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al ingresar producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
       consultar();
        reset();
    }
    public void consultar(){
   String sql= "select * from productos";
   try{
   conet=co.getConnection();
   st=conet.createStatement();
   rs=st.executeQuery(sql);
   Object[] producto=new Object[4];
   modelo = (DefaultTableModel) jinventario.getModel();
   modelo.setRowCount(0);
   
   
   while(rs.next()){
         
         
         producto [0]=rs.getString("Nombre");
         producto [1]=rs.getString("Descripción");
         producto [2]=rs.getString("precio");
         producto [3]=rs.getString("cantidad");
         modelo.addRow(producto);
   }
   jinventario.setModel(modelo);
   
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error al consultar productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
   }
   
  }
    
    public void actualizar(){
        String Nombre = nameprod.getText();
        String Descripcion = descripprod.getText();
        String Precio = precioprod.getText();
        String Cantidad = cantiprod.getText() ;
   
   try{
   String sql="update productos set nombre='"+Nombre+"',descripción='"+Descripcion+"',precio='"+Precio+"',cantidad='"+Cantidad+"' where nombre='"+jinventario.getValueAt(jinventario.getSelectedRow(),0)+"';";
      conet=co.getConnection();
      st=conet.createStatement();
      st.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"Se ha actualizado el registro");
   limpiar();
   
   }catch(Exception e){
   }
   consultar();
    nameprod.setText("");
        descripprod.setText("");
        precioprod.setText("");
        cantiprod.setText("");
   }
    
    public void eliminar(){
   int fila =jinventario.getSelectedRow();
   try{
     if(fila<0){
     
     JOptionPane.showMessageDialog(null,"Seleccione una fila");
     
     }else{
     
     String sql="delete from productos where nombre='"+jinventario.getValueAt(jinventario.getSelectedRow(),0)+"';";
     conet=co.getConnection();
      st=conet.createStatement();
      st.executeUpdate(sql);
      JOptionPane.showMessageDialog(null,"Se ha eliminado el registro");
      limpiar();
     }
  }catch(Exception e){
   }
   consultar();
     reset();   
   }
    /**
     * Creates new form INVENTARIO
     */
    
    
    

    
    public void reset(){
   
   nameprod.setText("");
        descripprod.setText("");
        precioprod.setText("");
        cantiprod.setText("");
   }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jinventario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        precioprod = new javax.swing.JTextField();
        nameprod = new javax.swing.JTextField();
        descripprod = new javax.swing.JTextField();
        cantiprod = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel2.setText("WEEDGITAL");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("INVENTARIO");

        jinventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jinventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jinventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jinventario);

        jButton1.setText("AÑADIR PRODUCTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ELIMINAR PRODUCTO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("EDITAR PRODUCTO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Descripcion");

        jLabel5.setText("precio");

        jLabel6.setText("Cantidad");

        precioprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioprodActionPerformed(evt);
            }
        });

        nameprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameprodActionPerformed(evt);
            }
        });

        descripprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripprodActionPerformed(evt);
            }
        });

        cantiprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantiprodActionPerformed(evt);
            }
        });

        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnimprimir)
                        .addGap(76, 76, 76))))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton2)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precioprod, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(nameprod)
                    .addComponent(descripprod, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(cantiprod, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(btnimprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(nameprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(descripprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cantiprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Agregar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
eliminar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
actualizar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void precioprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioprodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioprodActionPerformed

    private void nameprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameprodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameprodActionPerformed

    private void descripprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripprodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripprodActionPerformed

    private void cantiprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantiprodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantiprodActionPerformed

    private void jinventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jinventarioMouseClicked
          
        int fila =jinventario.getSelectedRow();//obteniendo el indice o linea seleccionada
        if(fila==-1){
        JOptionPane.showMessageDialog(null,"seleccione una fila");
       }else{
        String nombre=(String) jinventario.getValueAt(fila,0);
        String descripcion=(String) jinventario.getValueAt(fila,1);
        idc=Integer.parseInt((String)jinventario.getValueAt(fila,2).toString());
        idc2=Integer.parseInt((String)jinventario.getValueAt(fila,3).toString());
        
       nameprod.setText(nombre);
        descripprod.setText(descripcion);
        precioprod.setText(""+idc);
        cantiprod.setText(""+idc2);
        
     
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jinventarioMouseClicked

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        JasperPrint jp = reporteinventario();
        JasperViewer.viewReport(jp);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnimprimirActionPerformed

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
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INVENTARIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JTextField cantiprod;
    private javax.swing.JTextField descripprod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jinventario;
    private javax.swing.JTextField nameprod;
    private javax.swing.JTextField precioprod;
    // End of variables declaration//GEN-END:variables
}
