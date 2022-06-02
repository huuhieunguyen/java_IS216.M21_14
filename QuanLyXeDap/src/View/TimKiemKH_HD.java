
package View;

import javax.swing.JOptionPane;
import java.sql.* ;
import ConnectDB.ConnectionUtils;
import Process.KhachHang;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Nguyen Huu Hieu
 */
public class TimKiemKH_HD extends javax.swing.JFrame {
        private String maKH;
    DefaultTableModel tblModel;
    
    public TimKiemKH_HD() {
        initComponents();
        showComBoBoxData();
        initTable();
        
        
        loadKhachHang();
        
        HeaderAdjust();
    }
    
    // Load du lieu (items) tu List Khach Hang trong package Process vao combobox
    private void showComBoBoxData(){
        List<String> data = KhachHang.getDataKH();
        for (String str : data) {
            cbxLoaiThongTin.addItem(str);
        }
    }
    
    // Khoi tao bang KhachHang
    private void initTable(){
        tblModel = new DefaultTableModel();
        String tieuDe[] = {"MAKH", "HỌ TÊN", "NGÀY SINH", "GIỚI TÍNH", 
                                                              "ĐỊA CHỈ", "SĐT"};
        tblModel.setColumnIdentifiers(tieuDe);
    }
    
    // Dieu chinh do rong cot trong bang
    public void HeaderAdjust() {
        //Set do rong cua bang
        tblKhachHang.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);

        tblKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setViewportView(tblKhachHang);

        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setMinWidth(50);
            tblKhachHang.getColumnModel().getColumn(0).setMaxWidth(50);
            tblKhachHang.getColumnModel().getColumn(1).setMinWidth(150);
            tblKhachHang.getColumnModel().getColumn(1).setMaxWidth(150);
            tblKhachHang.getColumnModel().getColumn(2).setMinWidth(150);
            tblKhachHang.getColumnModel().getColumn(2).setMaxWidth(150);
            tblKhachHang.getColumnModel().getColumn(3).setMinWidth(80);
            tblKhachHang.getColumnModel().getColumn(3).setMaxWidth(80);
            tblKhachHang.getColumnModel().getColumn(4).setMinWidth(200);
            tblKhachHang.getColumnModel().getColumn(4).setMaxWidth(200);
        }
        //Set tieu de
        JTableHeader THeader = tblKhachHang.getTableHeader();
        THeader.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) THeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    // Load du lieu tu table KhachHang trong csdl len jTable
    private void loadKhachHang(){
        try(Connection con = ConnectionUtils.getMyConnection()){
           String queryKH = "select * from KHACHHANG";
           PreparedStatement ps = con.prepareStatement(queryKH);
           ResultSet rs = ps.executeQuery();
           
           // Xoa toan bo dong du lieu trong table
           tblModel.setRowCount(0);
           while(rs.next()){
               String[] row = new String[]{
                 rs.getString("MAKH"),
                 rs.getString("HOTEN"),
                 rs.getString("NGSINH"),
                 rs.getString("GIOITINH"),
                 rs.getString("DIACHI"),
                 rs.getString("SDT")
               };
               tblModel.addRow(row);
           }
           
           // Cap nhat du lieu duoc hien thi trong table
           tblModel.fireTableDataChanged();
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
        
        // Gan tblModel vao jTable tblKhachHang
        tblKhachHang.setModel(tblModel);
        setVisible(true);
    }
    
    public String getMaKH(){
        return this.maKH;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTuKhoa = new javax.swing.JTextField();
        cbxLoaiThongTin = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnChonKH = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH KHÁCH HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TỪ KHÓA");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("LOẠI THÔNG TIN");

        cbxLoaiThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiThongTinActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        btnChonKH.setBackground(new java.awt.Color(153, 153, 153));
        btnChonKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChonKH.setForeground(new java.awt.Color(204, 255, 204));
        btnChonKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Selection.png"))); // NOI18N
        btnChonKH.setText("CHỌN");
        btnChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKHActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Backward (black).png"))); // NOI18N
        jButton1.setText("QUAY LẠI ");
        jButton1.setMaximumSize(new java.awt.Dimension(131, 38));
        jButton1.setMinimumSize(new java.awt.Dimension(131, 38));
        jButton1.setPreferredSize(new java.awt.Dimension(131, 38));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Search.png"))); // NOI18N
        btnTimKiem.setBorder(null);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTuKhoa)
                            .addComponent(cbxLoaiThongTin, 0, 168, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195)
                        .addComponent(btnChonKH)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxLoaiThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        try(Connection con = ConnectionUtils.getMyConnection()){
            String sql = "select * from KHACHHANG WHERE MAKH like ?"
                    + "or HOTEN like ? or SDT like ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            String dkTimKiem = "%";
//            if(txtTuKhoa.getText().equals("")){
                dkTimKiem += txtTuKhoa.getText() + "%";
//            }
            
            for(int i=1; i<=3; i++){
                ps.setString(i, dkTimKiem);
            }
            
            ResultSet rs = ps.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()){
                tblModel.addRow(new Object[] {
                    rs.getString("MAKH"),
                    rs.getString("HOTEN"),
                    rs.getString("NGSINH"),
                    rs.getString("GIOITINH"),
                    rs.getString("DIACHI"),
                    rs.getString("SDT"),
                });
            }
            tblModel.fireTableDataChanged();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
        tblKhachHang.setModel(tblModel);
        setVisible(true);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbxLoaiThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLoaiThongTinActionPerformed
        // TODO add your handling code here:
        int index = cbxLoaiThongTin.getSelectedIndex();
        if(index > 0){
            String selectedValue = KhachHang.getDataKH().get(index);
            System.out.println("Lay gia tri thong qua chi so cua List KhachHang trong cbb: "
            + selectedValue);
        }
    }//GEN-LAST:event_cbxLoaiThongTinActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        maKH = tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0) + "";
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKHActionPerformed
//        // TODO add your handling code here:
//        if(maKH != null) {
//            TaoHoaDon taoHD = new TaoHoaDon(maKH);

            
            this.setVisible(false);
//        }
    }//GEN-LAST:event_btnChonKHActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TimKiemKH_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TimKiemKH_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TimKiemKH_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TimKiemKH_HD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TimKiemKH_HD().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbxLoaiThongTin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}
