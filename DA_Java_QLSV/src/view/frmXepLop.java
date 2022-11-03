/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KetQua;
import model.LopHP;
import model.LopSH;
import model.SinhVien;

/**
 *
 * @author PC
 */
public class frmXepLop extends javax.swing.JFrame {
    List<LopHP> listLopHP ;
    List<KetQua> listKetQua;
    List<SinhVien> listSinhVien;
      List<LopSH> listLopSH;
    /**
     * Creates new form frmXepLop
     */
    String ID_LHP = new String();
private void HienThi(){
        try{
            listLopHP = controller.LopHPController.listLopHPID();
            DefaultComboBoxModel model1 = new DefaultComboBoxModel();
            
            for (LopHP lopHP : listLopHP) {
                model1.addElement(lopHP.getTenLopHP());
            }
            cmbLopHP.setModel(model1);

        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmXepLop.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
private void refresh(){
 try {
            String className = cmbLopHP.getSelectedItem().toString();
        
            //ArrayList<KetQua> listKetQua = controller.KetQuaController.getKetQuaByClassName(className);
            String ID_LopHP = new String();
            for (LopHP lopHP : listLopHP) {
                if (lopHP.getTenLopHP().equalsIgnoreCase(className)) { 
                        ID_LopHP = lopHP.getID_LopHP();
                        ID_LHP = ID_LopHP;
                        break;
                }
            }
            Vector tieuDe = new Vector();
 //           tieuDe.add("Lớp Sinh Hoạt");
            tieuDe.add("Mã Sinh Viên");
            tieuDe.add("Tên Sinh Viên");
             tieuDe.add("Mã Sinh Hoạt");
              tieuDe.add("Lớp Sinh Hoạt");
            
            List<SinhVien> listSinhVien= controller.SinhVienController.listSinhVienID();
             List<LopSH> listLopSH= controller.LopSHController.listLopSHID();
            Vector duLieu1 = new Vector();
            List<KetQua> listKetQua1 = controller.KetQuaController.listChuaXepLopHP(ID_LopHP);
            if(listKetQua1!=null){
                for(KetQua ketQua: listKetQua1){
                    Vector tam1 = new Vector();
                    
                    tam1.add(ketQua.getID_SV());
                    for (SinhVien sinhvien : listSinhVien){
                    if (sinhvien.getID_SV().equalsIgnoreCase(ketQua.getID_SV())) {
                        tam1.add(sinhvien.getTenSV());
                        break;           
                    }    
                    }
                    String IDLSH = new String();
                  IDLSH = controller.KetQuaController.IDLopSH(ketQua.getID_SV());
                  tam1.add(IDLSH);
                   for (LopSH lopSH : listLopSH) {
                    if(lopSH.getID_LopSH().equalsIgnoreCase(IDLSH)){
                        tam1.add(lopSH.getTenLopSH());
                        break;
                    }
                }
                    duLieu1.add(tam1);

                }
               DefaultTableModel model1 = new DefaultTableModel(duLieu1,tieuDe );
            jTable1.setModel(model1); 
            }
            Vector duLieu2 = new Vector();
             List<KetQua> listKetQua2 = controller.KetQuaController.listDaXepLopHP(ID_LopHP);
            if(listKetQua2!=null){
                for(KetQua ketQua: listKetQua2){
                    Vector tam2 = new Vector();
                    tam2.add(ketQua.getID_SV());
                    for (SinhVien sinhvien : listSinhVien){
                    if (sinhvien.getID_SV().equalsIgnoreCase(ketQua.getID_SV())) {
                        tam2.add(sinhvien.getTenSV());
                        break;           
                    }    
                    }
                    
                  String IDLSH = new String();
                  IDLSH = controller.KetQuaController.IDLopSH(ketQua.getID_SV());
                  tam2.add(IDLSH);
                   for (LopSH lopSH : listLopSH) {
                    if(lopSH.getID_LopSH().equalsIgnoreCase(IDLSH)){
                        tam2.add(lopSH.getTenLopSH());
                        break;
                    }
                }
                duLieu2.add(tam2);
                }
               DefaultTableModel model2 = new DefaultTableModel(duLieu2,tieuDe );
            jTable2.setModel(model2); 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
    
    public frmXepLop() {
        initComponents();
        HienThi();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btn_NhapLop = new javax.swing.JButton();
        btn_Go = new javax.swing.JButton();
        cmbLopHP = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xếp lớp");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        btn_NhapLop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_NhapLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Green_Arrow_Right.svg.png"))); // NOI18N
        btn_NhapLop.setText("Nhập Lớp");
        btn_NhapLop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_NhapLop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_NhapLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhapLopActionPerformed(evt);
            }
        });

        btn_Go.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Go.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Red_Arrow_Left.png"))); // NOI18N
        btn_Go.setText("Gỡ");
        btn_Go.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Go.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GoActionPerformed(evt);
            }
        });

        cmbLopHP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLopHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLopHPActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/huyTT.png"))); // NOI18N
        jLabel1.setText("DS Sinh Viên Chưa Nhận Lớp");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/XN.png"))); // NOI18N
        jLabel2.setText("DS Sinh Viên Đã Nhận Lớp");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Chọn Lớp Xếp");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("XẾP LỚP HỌC PHẦN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(jLabel4)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLopHP, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(218, 218, 218))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_NhapLop)
                            .addComponent(btn_Go, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(255, 255, 255))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbLopHP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_NhapLop)
                                .addGap(47, 47, 47)
                                .addComponent(btn_Go)
                                .addGap(168, 168, 168))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 220, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NhapLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhapLopActionPerformed
        // TODO add your handling code here:
         try {  
        int selectedRow = jTable1.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Chưa chọn sinh viên để nhập", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
             KetQua ketQua = new KetQua();
             ketQua.setID_LOPHP(ID_LHP);
             System.out.println("ID "+ketQua.getID_LOPHP());
             ketQua.setID_SV(jTable1.getValueAt(selectedRow, 0).toString());
             System.out.println("ID "+ketQua.getID_SV());
             
            int thongBao = controller.KetQuaController.addKetQua(ketQua);
        
            if(thongBao>0){
                 JOptionPane.showMessageDialog(null, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                refresh();
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);            
            }
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmXepLop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmXepLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_NhapLopActionPerformed

    private void btn_GoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GoActionPerformed
        try {
            int selectedRow = jTable2.getSelectedRow();
            
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Chưa chọn sinh viên cần gở", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            KetQua ketQua = new KetQua();
            ketQua.setID_LOPHP(ID_LHP);
             System.out.println("ID "+ketQua.getID_LOPHP());
             ketQua.setID_SV(jTable2.getValueAt(selectedRow, 0).toString());
             System.out.println("ID "+ketQua.getID_SV());
            
            int xoa = controller.KetQuaController.deleteKetQua(ketQua);
            if(xoa>0){
                 JOptionPane.showMessageDialog(null, "Gỡ sinh viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                refresh();
            } else {
                JOptionPane.showMessageDialog(null, "Gỡ sinh viên không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);            
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmXepLop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_GoActionPerformed

    private void cmbLopHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLopHPActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_cmbLopHPActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmXepLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmXepLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmXepLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmXepLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmXepLop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Go;
    private javax.swing.JButton btn_NhapLop;
    private javax.swing.JComboBox<String> cmbLopHP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
