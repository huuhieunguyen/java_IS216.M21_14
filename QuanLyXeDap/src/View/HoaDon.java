
package View;

import javax.swing.JOptionPane;
import java.sql.* ;
import ConnectDB.ConnectionUtils;
import Process.Hoa_Don;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Nguyen Huu Hieu
 */
public class HoaDon extends javax.swing.JFrame {
    DefaultTableModel tblModel;
    
    /**
     * Creates new form HoaDon
     */
    public HoaDon() {
        initComponents();
        
        //Load du lieu (items) tu List Hoa_Don trong Package Process vao combobox
        showComBoBoxData();
        
        // Khoi tao bang Hoa Don
        initTable_HD();
        
        // Load du lieu tu table HoaDon trong csdl len jTable
        loadHoaDon();
        
        // Dieu chinh do rong cot trong bang HD
        HeaderAdjust();
        
        // Load MaHD len combobox de tra cuu CTHD
        initComboBox_HD();
    }
    
    // Load du lieu (items) tu List Hoa_Don trong Package Process vao combobox
    private void showComBoBoxData(){
        List<String> data = Hoa_Don.getData();
        for (String str : data) {
            cbxLoaiThongTin.addItem(str);
        }
    }
    
    // Khoi tao bang Hoa Don
    private void initTable_HD(){
        tblModel = new DefaultTableModel();
        String tieuDe[] = {"MAHD", "NGHD", "MAKH", "MANV", "MAKM", "TRIGIA"};
        tblModel.setColumnIdentifiers(tieuDe);
    }
    
    // Load du lieu tu table HoaDon trong csdl len jTable
    private void loadHoaDon(){
        try(Connection con = ConnectionUtils.getMyConnection()){
           String queryHD = "select * from HOADON";
           PreparedStatement ps = con.prepareStatement(queryHD);
           ResultSet rs = ps.executeQuery();
           
           Locale locale = new Locale("en", "EN");
           NumberFormat en = NumberFormat.getInstance(locale);
           // Xoa toan bo dong du lieu trong table
           tblModel.setRowCount(0);
           while(rs.next()){
               String[] row = new String[]{
                 rs.getString("MAHD"),
                 rs.getString("NGHD"),
                 rs.getString("MAKH"), 
                 rs.getString("MANV"),
                 rs.getString("MAKM"),
                 en.format(rs.getLong("TRIGIA"))
               };
               tblModel.addRow(row);
           }
           
           // Cap nhat du lieu duoc hien thi trong table
           tblModel.fireTableDataChanged();
           
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
        
        // Gan tblModel vao jTable tblHoaDon
        tblHoaDon.setModel(tblModel);
        setVisible(true);
        tblHoaDon.setDefaultEditor(Object.class, null);
    }
    
    // Dieu chinh do rong cot trong bang
    public void HeaderAdjust() {
        //Set do rong cua bang
        tblHoaDon.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);

        tblHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setViewportView(tblHoaDon);

        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setMinWidth(50);
            tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(50);
            tblHoaDon.getColumnModel().getColumn(1).setMinWidth(150);
            tblHoaDon.getColumnModel().getColumn(1).setMaxWidth(150);
            tblHoaDon.getColumnModel().getColumn(2).setMinWidth(80);
            tblHoaDon.getColumnModel().getColumn(2).setMaxWidth(80);
            tblHoaDon.getColumnModel().getColumn(3).setMinWidth(100);
            tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(100);
            tblHoaDon.getColumnModel().getColumn(4).setMinWidth(120);
            tblHoaDon.getColumnModel().getColumn(4).setMaxWidth(120);
        }
        //Set tieu de
        JTableHeader THeader = tblHoaDon.getTableHeader();
        THeader.setFont(new Font("Segoe UI", Font.BOLD, 12));
        ((DefaultTableCellRenderer) THeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    // Load MaHD len combobox de tra cuu CTHD
    private void initComboBox_HD(){
        try(Connection con = ConnectionUtils.getMyConnection()){
            String query = "select MAHD from HOADON";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            cbxHoaDon.removeAllItems();
            while(rs.next()){
                cbxHoaDon.addItem(rs.getString("MAHD"));
            }
            con.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHoaDon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnTraCuu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTuKhoa = new javax.swing.JTextField();
        cbxLoaiThongTin = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        cbxHoaDon = new javax.swing.JComboBox<>();
        PanelCTHD = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCuaHang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNV_LapHD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JFormattedTextField();
        txtNgayHD = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtKhachHang = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTongGiam = new javax.swing.JFormattedTextField();
        txtTong = new javax.swing.JFormattedTextField();
        txtTongTra = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelHoaDon.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" HÓA ĐƠN");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblHoaDon);

        jButton1.setBackground(new java.awt.Color(153, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Add.png"))); // NOI18N
        jButton1.setText("TẠO HÓA ĐƠN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnTraCuu.setBackground(new java.awt.Color(204, 255, 255));
        btnTraCuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTraCuu.setForeground(new java.awt.Color(0, 102, 255));
        btnTraCuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Tra cuu (right).png"))); // NOI18N
        btnTraCuu.setText("TRA CỨU");
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("LOẠI THÔNG TIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TỪ KHÓA");

        txtTuKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuKhoaActionPerformed(evt);
            }
        });

        cbxLoaiThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiThongTinActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Search.png"))); // NOI18N
        btnTimKiem.setBorder(null);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHoaDonLayout = new javax.swing.GroupLayout(PanelHoaDon);
        PanelHoaDon.setLayout(PanelHoaDonLayout);
        PanelHoaDonLayout.setHorizontalGroup(
            PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoaDonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoaDonLayout.createSequentialGroup()
                                .addComponent(cbxHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTraCuu)
                                .addGap(117, 117, 117)
                                .addComponent(jButton1)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHoaDonLayout.createSequentialGroup()
                                .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTuKhoa)
                                    .addComponent(cbxLoaiThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(239, 239, 239))))
                    .addGroup(PanelHoaDonLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        PanelHoaDonLayout.setVerticalGroup(
            PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHoaDonLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelHoaDonLayout.createSequentialGroup()
                        .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxLoaiThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTuKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(PanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnTraCuu)
                    .addComponent(cbxHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CHI TIẾT HÓA ĐƠN");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("CỬA HÀNG");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("MÃ HÓA ĐƠN");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("NHÂN VIÊN LẬP HÓA ĐƠN");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("NGÀY HD");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ĐƠN GIÁ");

        txtDonGia.setText("jFormattedTextField1");

        txtNgayHD.setText("jFormattedTextField2");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("KHÁCH HÀNG");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("SĐT");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

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
        jScrollPane3.setViewportView(jTable1);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("TỔNG");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("TỔNG TIỀN GIẢM GIÁ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("TỔNG TIỀN PHẢI TRẢ");

        txtTongGiam.setText("jFormattedTextField3");

        txtTong.setText("jFormattedTextField4");

        txtTongTra.setText("jFormattedTextField5");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout PanelCTHDLayout = new javax.swing.GroupLayout(PanelCTHD);
        PanelCTHD.setLayout(PanelCTHDLayout);
        PanelCTHDLayout.setHorizontalGroup(
            PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCTHDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(200, 200, 200))
            .addGroup(PanelCTHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(PanelCTHDLayout.createSequentialGroup()
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCTHDLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addGap(27, 27, 27)
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCTHDLayout.createSequentialGroup()
                                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNV_LapHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(txtNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(62, 62, 62)
                                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addComponent(txtCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelCTHDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCTHDLayout.setVerticalGroup(
            PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCTHDLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCTHDLayout.createSequentialGroup()
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNV_LapHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelCTHDLayout.createSequentialGroup()
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTongGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTongTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuActionPerformed
        // TODO add your handling code here:
        String maHD = cbxHoaDon.getSelectedItem().toString();
        
        CTHD form = new CTHD(maHD);
        form.setVisible(true);
    }//GEN-LAST:event_btnTraCuuActionPerformed

    private void cbxLoaiThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLoaiThongTinActionPerformed
        // TODO add your handling code here:
        int index = cbxLoaiThongTin.getSelectedIndex();
        if(index > 0){
            String selectedValue = Hoa_Don.getData().get(index);
            System.out.println("Lay gia tri thong qua chi so cua List Hoa_Don trong cbb: "
            + selectedValue);
        }
    }//GEN-LAST:event_cbxLoaiThongTinActionPerformed

    private void txtTuKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTuKhoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        try(Connection con = ConnectionUtils.getMyConnection()){
            String sql = "select * from HOADON WHERE MAHD like ?"
                    + " or MAKH LIKE ? or MANV like ? or MAKM like ?";
//                    + "or NGHD like ? or TRIGIA = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            String dkTimKiem = "%";
//            if(txtTuKhoa.getText().equals("")){
                dkTimKiem += txtTuKhoa.getText() + "%";
//            }
            
            for(int i=1; i<=4; i++){
                ps.setString(i, dkTimKiem);

            }

            ResultSet rs = ps.executeQuery();
            tblModel.setRowCount(0);
            while(rs.next()){
                tblModel.addRow(new Object[] {
                    rs.getString("MAHD"),
                    rs.getString("NGHD"),
                    rs.getString("MAKH"), 
                    rs.getString("MANV"),
                    rs.getString("TRIGIA"),
                    rs.getString("MAKM")
                });
            }
            tblModel.fireTableDataChanged();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
        tblHoaDon.setModel(tblModel);
        setVisible(true);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCTHD;
    private javax.swing.JPanel PanelHoaDon;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTraCuu;
    private javax.swing.JComboBox<String> cbxHoaDon;
    private javax.swing.JComboBox<String> cbxLoaiThongTin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtCuaHang;
    private javax.swing.JFormattedTextField txtDonGia;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNV_LapHD;
    private javax.swing.JFormattedTextField txtNgayHD;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JFormattedTextField txtTong;
    private javax.swing.JFormattedTextField txtTongGiam;
    private javax.swing.JFormattedTextField txtTongTra;
    private javax.swing.JTextField txtTuKhoa;
    // End of variables declaration//GEN-END:variables
}
