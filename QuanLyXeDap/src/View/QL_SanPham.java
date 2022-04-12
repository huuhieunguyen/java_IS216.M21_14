package View;

import ConnectDB.ConnectionUtils;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Tran Ngoc My Phuong
 */
public class QL_SanPham extends javax.swing.JFrame {

    private String masp;
    DefaultTableModel tbn = new DefaultTableModel();

    /**
     * Creates new form QL_NhanVien
     */
    public QL_SanPham() {
        initComponents();
        loadData();
        HeaderAdjust();
    }

    //Phuong
    public void HeaderAdjust() {
        //Set do rong cua bang
        TableSP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);

        TableSP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setViewportView(TableSP);

        if (TableSP.getColumnModel().getColumnCount() > 0) {
            TableSP.getColumnModel().getColumn(0).setMinWidth(50);
            TableSP.getColumnModel().getColumn(0).setMaxWidth(50);
            TableSP.getColumnModel().getColumn(1).setMinWidth(300);
            TableSP.getColumnModel().getColumn(1).setMaxWidth(300);
            TableSP.getColumnModel().getColumn(2).setMinWidth(87);
            TableSP.getColumnModel().getColumn(2).setMaxWidth(87);
            TableSP.getColumnModel().getColumn(3).setMinWidth(90);
            TableSP.getColumnModel().getColumn(3).setMaxWidth(90);
            TableSP.getColumnModel().getColumn(4).setMinWidth(70);
            TableSP.getColumnModel().getColumn(4).setMaxWidth(70);
        }
        //Set tieu de
        JTableHeader THeader = TableSP.getTableHeader();
        THeader.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) THeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    //Phuong
    public void loadData() {
        //Set ten bang
        String[] columnNames = {"Mã SP", "Tên sản phẩm", "Đơn vị tính", "Nước sản xuất", "Đơn giá", "Tổng số lượng"};
        tbn = new DefaultTableModel(columnNames, 0);
        //Tao ket noi voi SQL
        try ( Connection con = ConnectionUtils.getMyConnection()) {
            int number;
            Vector row, column;
            column = new Vector();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from SANPHAM ORDER BY MASP");
            ResultSetMetaData metadata = rs.getMetaData();
            // tra ve so cot
            number = metadata.getColumnCount();

            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= number; i++) {
                    // lay ra tieu de cua cac cot
                    row.addElement(rs.getObject(i));
                }
                tbn.addRow(row);
                TableSP.setModel(tbn);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        //Khong cho user edit
        TableSP.setDefaultEditor(Object.class, null);
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
        TableSP = new javax.swing.JTable();
        btnChon = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TỪ KHÓA");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("LOẠI THÔNG TIN");

        TableSP.setModel(new javax.swing.table.DefaultTableModel(
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
        TableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSP);

        btnChon.setBackground(new java.awt.Color(153, 153, 153));
        btnChon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChon.setForeground(new java.awt.Color(204, 255, 204));
        btnChon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Selection.png"))); // NOI18N
        btnChon.setText("CHỌN");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Add.png"))); // NOI18N
        jButton3.setText("THÊM");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Search.png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTuKhoa)
                    .addComponent(cbxLoaiThongTin, 0, 168, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(btnChon)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
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
                        .addGap(4, 4, 4)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        try ( java.sql.Connection con = ConnectionUtils.getMyConnection()) {
            String sql = null;
            switch (cbxLoaiThongTin.getSelectedIndex()) {
                case 0:
                    sql = "select * from SANPHAM WHERE UPPER(MASP) like '%";
                    break;
                case 1:
                    sql = "select * from SANPHAM WHERE UPPER(TENSP) like '%";
                    break;
                case 2:
                    sql = "select * from SANPHAM WHERE UPPER(NUOCSX) like '%";
                    break;
                default:
                    break;
            }
            sql += txtTuKhoa.getText().toUpperCase() + "%'";
            System.out.print(sql);
            Statement stat = con.createStatement();

            ResultSet rs = stat.executeQuery(sql);
            tbn.setRowCount(0);
            while (rs.next()) {
                tbn.addRow(new Object[]{
                    rs.getString("MASP"),
                    rs.getString("TENSP"),
                    rs.getString("DVT"),
                    rs.getString("NUOCSX"),
                    rs.getString("DONGIA"),
                    rs.getString("TONGSL"),});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
        TableSP.setModel(tbn);
        setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void TableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSPMouseClicked
        // TODO add your handling code here:
        masp = TableSP.getValueAt(TableSP.getSelectedRow(), 0) + "";
    }//GEN-LAST:event_TableSPMouseClicked

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        if (masp != null) {
            TT_SanPham sp = new TT_SanPham(masp);
            this.setVisible(false);
            sp.setVisible(true);
        }
    }//GEN-LAST:event_btnChonActionPerformed


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
            java.util.logging.Logger.getLogger(QL_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_SanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableSP;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbxLoaiThongTin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}