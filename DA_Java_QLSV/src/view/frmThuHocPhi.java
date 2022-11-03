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
import model.LopHP;
import model.LopSH;
import model.NhanVien;
import model.SinhVien;
import model.ThuHocPhi;

/**
 *
 * @author Dell
 */
public class frmThuHocPhi extends javax.swing.JFrame {

 //   List<NhanVien> listNhanVien = null;
    List<NhanVien> listThuNgan = null;
private void Run_ThuHocPhi(){
     try {
          Label_KetQuaTimKiem.setText(null);
            Vector tieuDe = new Vector();
            tieuDe.add("ID_LOPHP");
            tieuDe.add("TenLopHP");
            tieuDe.add("ID_SV");
            tieuDe.add("TenSV");
            tieuDe.add("HocPhi");
            tieuDe.add("ThanhToan");
            
            Vector duLieu = new Vector();
            List<ThuHocPhi> listThuHocPhi = controller.ThuHocPhiController.listThuHocPhi();
            List<LopHP> listLopHP = controller.LopHPController.listLopHPID();
            List<SinhVien> listSinhVien = controller.SinhVienController.listSinhVienID();
              
            if (listThuHocPhi != null){
            for (ThuHocPhi thuhocphi : listThuHocPhi) {
                
                Vector tam = new Vector();
                
                
                tam.add(thuhocphi.getID_LOPHP());
                for (LopHP lopHP : listLopHP) {
                        if (lopHP.getID_LopHP().equalsIgnoreCase(thuhocphi.getID_LOPHP())) {
                            tam.add(lopHP.getTenLopHP());
                            break;
                        }
                    }
                
                tam.add(thuhocphi.getID_SV());
                for (SinhVien sinhvien : listSinhVien){
                    if (sinhvien.getID_SV().equalsIgnoreCase(thuhocphi.getID_SV())) {
                        tam.add(sinhvien.getTenSV());
                        break;
                        
                    }
                
                }
                
              
              for(LopHP lophp : listLopHP){
                  if (lophp.getID_LopHP().equalsIgnoreCase(thuhocphi.getID_LOPHP())){
                     tam.add(lophp.getHocPhi());
                      break;
                     
                   }
              }
              
                if (thuhocphi.getThanhToan()) {
                        tam.add("Đã thanh toán");
                    } else {
                        tam.add("Chưa thanh toán");
                    }
                //tam.add(thuhocphi.getThanhToan());
                
                duLieu.add(tam);
            }
            }
            DefaultTableModel model = new DefaultTableModel(duLieu, tieuDe);
            tableThuHocPhi.setModel(model);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmThuHocPhi.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public frmThuHocPhi() {
        initComponents();
        Run_ThuHocPhi();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialog_SearchSV = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txt_SearchSV = new javax.swing.JTextField();
        btn_SearchSV_Dialog = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThuHocPhi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Label_KetQuaTimKiem = new javax.swing.JLabel();
        btn_SearchSV = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        btn_Refresh = new javax.swing.JButton();

        Dialog_SearchSV.setTitle("Tìm kiếm");

        jLabel2.setText("ID Sinh viên");

        btn_SearchSV_Dialog.setText("Tìm sinh viên");
        btn_SearchSV_Dialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchSV_DialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Dialog_SearchSVLayout = new javax.swing.GroupLayout(Dialog_SearchSV.getContentPane());
        Dialog_SearchSV.getContentPane().setLayout(Dialog_SearchSVLayout);
        Dialog_SearchSVLayout.setHorizontalGroup(
            Dialog_SearchSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dialog_SearchSVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Dialog_SearchSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_SearchSV_Dialog)
                    .addComponent(txt_SearchSV, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Dialog_SearchSVLayout.setVerticalGroup(
            Dialog_SearchSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dialog_SearchSVLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(Dialog_SearchSVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_SearchSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_SearchSV_Dialog)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tình trạng nộp học phí");

        tableThuHocPhi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableThuHocPhi);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("TÌNH TRẠNG NỘP HỌC PHÍ");

        Label_KetQuaTimKiem.setText("jLabel6");

        btn_SearchSV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_SearchSV.setForeground(new java.awt.Color(0, 0, 204));
        btn_SearchSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btn_SearchSV.setText("Tìm Kiếm");
        btn_SearchSV.setFocusable(false);
        btn_SearchSV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_SearchSV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_SearchSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchSVActionPerformed(evt);
            }
        });

        btn_Thoat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(0, 0, 255));
        btn_Thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close.png"))); // NOI18N
        btn_Thoat.setText("Thoát");
        btn_Thoat.setFocusable(false);
        btn_Thoat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Thoat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });

        btn_Refresh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Refresh.setForeground(new java.awt.Color(0, 0, 255));
        btn_Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LamTuoi.png"))); // NOI18N
        btn_Refresh.setText("Làm Tươi");
        btn_Refresh.setFocusable(false);
        btn_Refresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_Refresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_SearchSV)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Refresh)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(246, 246, 246)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_Thoat)))
                                .addGap(0, 362, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(Label_KetQuaTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_SearchSV, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_KetQuaTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        Run_ThuHocPhi();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void btn_SearchSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchSVActionPerformed
        // TODO add your handling code here:
            txt_SearchSV.setText("");
            Dialog_SearchSV.setSize(350,120);
            Dialog_SearchSV.setLocationRelativeTo(null);
            Dialog_SearchSV.setVisible(true);
    }//GEN-LAST:event_btn_SearchSVActionPerformed

    private void btn_SearchSV_DialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchSV_DialogActionPerformed
        // TODO add your handling code here:
        try {
            Vector tieuDe = new Vector();
            tieuDe.add("ID_LOPHP");
            tieuDe.add("TenLopHP");
            tieuDe.add("ID_SV");
            tieuDe.add("TenSV");
            tieuDe.add("HocPhi");
            tieuDe.add("ThanhToan");
            
            Vector duLieu = new Vector();
            
            String IDSV = new String();
            IDSV= txt_SearchSV.getText();
            Label_KetQuaTimKiem.setText("Kết quả tìm kiếm tên sinh viên theo từ khóa: "+IDSV+". Nhấn làm tươi để xem tất cả sinh viên");
            
            List<ThuHocPhi> listThuHocPhi = controller.ThuHocPhiController.TimKiemSVID(IDSV);
            List<LopHP> listLopHP = controller.LopHPController.listLopHPID();
            List<SinhVien> listSinhVien = controller.SinhVienController.listSinhVienID();
              
            if (listThuHocPhi != null){
            for (ThuHocPhi thuhocphi : listThuHocPhi) {
                
                Vector tam = new Vector();
                
              tam.add(thuhocphi.getID_LOPHP());
                for (LopHP lopHP : listLopHP) {
                        if (lopHP.getID_LopHP().equalsIgnoreCase(thuhocphi.getID_LOPHP())) {
                            tam.add(lopHP.getTenLopHP());
                            break;
                        }
                    }
                
                tam.add(thuhocphi.getID_SV());
                for (SinhVien sinhvien : listSinhVien){
                    if (sinhvien.getID_SV().equalsIgnoreCase(thuhocphi.getID_SV())) {
                        tam.add(sinhvien.getTenSV());
                        break;
                        
                    }
                
                }
                
              
              for(LopHP lophp : listLopHP){
                  if (lophp.getID_LopHP().equalsIgnoreCase(thuhocphi.getID_LOPHP())){
                     tam.add(lophp.getHocPhi());
                      break;
                     
                   }
              }
              
                
                 if (thuhocphi.getThanhToan()) {
                        tam.add("Đã thanh toán");
                    } else {
                        tam.add("Chưa thanh toán");
                    }
                
                duLieu.add(tam);
            }
            }
            
            DefaultTableModel model = new DefaultTableModel(duLieu, tieuDe);
            tableThuHocPhi.setModel(model);
            Dialog_SearchSV.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmThuHocPhi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_SearchSV_DialogActionPerformed

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
            java.util.logging.Logger.getLogger(ThuHocPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuHocPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuHocPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuHocPhi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmThuHocPhi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Dialog_SearchSV;
    private javax.swing.JLabel Label_KetQuaTimKiem;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_SearchSV;
    private javax.swing.JButton btn_SearchSV_Dialog;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableThuHocPhi;
    private javax.swing.JTextField txt_SearchSV;
    // End of variables declaration//GEN-END:variables
}
