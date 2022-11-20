package views;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import models.KhuyenMai;
import services.IKhuyenMaiService;
import services.impl.KhuyenMaiService;
import swing.Table;
import utilities.Helper;

/**
 *
 * @author VU NGUYEN HUONG
 */
public class FrmKhuyenMai extends java.awt.Dialog {

    /**
     * Creates new form FrmKM
     */
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private IKhuyenMaiService iKhuyenMaiService = new KhuyenMaiService();
    private Helper helper = new Helper();
    public KhuyenMai khuyenMai;

    public FrmKhuyenMai(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadData(iKhuyenMaiService.getAll());
        Table.apply(jScrollPane1, Table.TableType.DEFAULT);
        date_NgayBatDau.setDate(new Date());
        date_NgayKetThuc.setDate(new Date());
    }

    private void loadData(List<KhuyenMai> list) {
        defaultTableModel = (DefaultTableModel) tb_danhSach.getModel();
        defaultTableModel.setRowCount(0);
        for (KhuyenMai km : list) {
            defaultTableModel.addRow(new Object[]{
                km.getMa(),
                km.getTen(),
                km.getPhantramgiam() + "%",
                km.getSoLuong(),
                helper.formatDate(km.getNgayBatDau()),
                helper.formatDate(km.getNgayKetThuc())
            });
        }
        lbl_Total.setText("Total: " + list.size());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_Ma = new swing.TextField();
        txt_TenKM = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        txt_Search = new swing.TextField();
        tableScrollButton1 = new swing.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_danhSach = new javax.swing.JTable();
        txt_PhanTramGiam = new swing.TextField();
        date_NgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date_NgayKetThuc = new com.toedter.calendar.JDateChooser();
        btn_Them = new swing.Button();
        btn_CapNhat = new swing.Button();
        btn_ChonKhuyenMai = new swing.Button();
        btn_Xoa = new swing.Button();
        sp_SoLuong = new swing.Spinner();
        imageAvatar1 = new swing.ImageAvatar();
        lbl_Total = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_Ma.setToolTipText("");
        txt_Ma.setLabelText("Mã :");

        txt_TenKM.setToolTipText("");
        txt_TenKM.setLabelText("Tên khuyến mãi :");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("KHUYẾN MÃI");

        txt_Search.setToolTipText("");
        txt_Search.setLabelText("Search");
        txt_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_SearchCaretUpdate(evt);
            }
        });

        tb_danhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Phần trăm giảm", "Số lượng", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        tb_danhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_danhSachMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_danhSach);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        txt_PhanTramGiam.setToolTipText("");
        txt_PhanTramGiam.setLabelText(" Phần trăm giảm :");

        date_NgayBatDau.setDateFormatString("dd-MM-yyyy");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ngày bắt đầu :");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Ngày kết thúc :");

        date_NgayKetThuc.setDateFormatString("dd-MM-yyyy");

        btn_Them.setBackground(new java.awt.Color(102, 102, 102));
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_CapNhat.setBackground(new java.awt.Color(102, 102, 102));
        btn_CapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_CapNhat.setText("Cập Nhật");
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });

        btn_ChonKhuyenMai.setBackground(new java.awt.Color(0, 137, 187));
        btn_ChonKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btn_ChonKhuyenMai.setText("Chọn khuyến mại");
        btn_ChonKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonKhuyenMaiActionPerformed(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(102, 102, 102));
        btn_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        sp_SoLuong.setLabelText("Số lượng :");

        imageAvatar1.setGradientColor1(new java.awt.Color(255, 255, 255));
        imageAvatar1.setGradientColor2(new java.awt.Color(255, 255, 255));

        lbl_Total.setForeground(new java.awt.Color(255, 0, 0));
        lbl_Total.setText("Total: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_Total))
                                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_CapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addGap(24, 24, 24))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(btn_ChonKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_NgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_NgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_PhanTramGiam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sp_SoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_TenKM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_Ma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(508, 508, 508)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_Total)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_PhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ChonKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    private KhuyenMai getForm() {
        String result = "MWCSTORES" + txt_Ma.getText().toUpperCase();
        KhuyenMai km = new KhuyenMai();
        km.setMa(txt_Ma.getText().toUpperCase());
        km.setTen(txt_TenKM.getText());
        km.setSoLuong((int) sp_SoLuong.getValue());
        km.setPhantramgiam(Float.parseFloat(txt_PhanTramGiam.getText()));
        km.setNgayBatDau(date_NgayBatDau.getDate());
        km.setNgayKetThuc(date_NgayKetThuc.getDate());
        km.setHinhAnh(txt_Ma.getText().toUpperCase() + ".png");
        try {
            String filePath = "images/voucher/" + txt_Ma.getText().toUpperCase() + ".png";
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(result.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 500, 500, hintMap);

            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
            System.out.println("Qr code has been generated at the location " + filePath);

        } catch (Exception e) {
            System.out.println(e);
        }
        return km;
    }

    public void clearForm() {
        txt_Ma.setText("");
        txt_TenKM.setText("");
        txt_PhanTramGiam.setText("");
        sp_SoLuong.setValue(0);
        imageAvatar1.setImage(null);
    }

    private boolean check() {
        if (helper.checkNull(txt_Ma, "Mã") || helper.checkNull(txt_TenKM, "Tên khuyến mãi") || helper.checkNull(txt_PhanTramGiam, "Phần trăm giảm")) {
            return false;
        }
        try {
            float f = Float.parseFloat(txt_PhanTramGiam.getText().trim());
        } catch (NumberFormatException e) {
            helper.error(this, "Phần trăm giảm không chứa chữ !");
            return false;
        }
        return true;
    }
    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        if (check()) {
            if (iKhuyenMaiService.getObj(txt_Ma.getText()) == null) {
                iKhuyenMaiService.save(getForm());
                loadData(iKhuyenMaiService.getAll());
                clearForm();
                helper.alert(this, "Thêm thành công!");
            } else {
                helper.error(this, "Đã có mã này rồi không thể thêm !!");
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        // TODO add your handling code here:
        int row = tb_danhSach.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần sửa!");
        } else {
            KhuyenMai km = iKhuyenMaiService.getObj(tb_danhSach.getValueAt(row, 0).toString());
            km.setMa(txt_Ma.getText().toUpperCase());
            km.setTen(txt_TenKM.getText());
            km.setPhantramgiam(Float.parseFloat(txt_PhanTramGiam.getText()));
            km.setSoLuong((int) sp_SoLuong.getValue());
            km.setNgayBatDau(date_NgayBatDau.getDate());
            km.setNgayKetThuc(date_NgayKetThuc.getDate());
            iKhuyenMaiService.save(km);
            loadData(iKhuyenMaiService.getAll());
            clearForm();
            helper.alert(this, "Sửa thành công");
        }
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void btn_ChonKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonKhuyenMaiActionPerformed
        // TODO add your handling code here:
        int row = tb_danhSach.getSelectedRow();
        int soLuong = Integer.parseInt(tb_danhSach.getValueAt(row, 3).toString());
        if (row == -1) {
            helper.error(this, "Vui lòng chọn khuyến mại!");
        } else if (soLuong == 0) {
            helper.error(this, "Đã hết mã khuyến mại!");
            return;
        } else {
            KhuyenMai km = iKhuyenMaiService.getObj((String) tb_danhSach.getValueAt(row, 0));
            helper.alert(this, "Thêm thành công!");
            this.dispose();
        }
    }//GEN-LAST:event_btn_ChonKhuyenMaiActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        int row = tb_danhSach.getSelectedRow();
        if (row == -1) {
            helper.error(this, "Vui lòng chọn dòng cần xóa!");
        } else {
            String result = txt_Ma.getText().replace("MWCSTORES", "").trim();
            String fileName = "images/voucher/" + result + ".png";
            File file = new File(fileName);
            if (file.delete()) {
                System.out.println("Tệp bị xóa!");
            } else {
                System.out.println("Xin lỗi, không thể xóa tập tin.");
                return;
            }
            KhuyenMai km = iKhuyenMaiService.getObj(tb_danhSach.getValueAt(row, 0).toString());
            iKhuyenMaiService.delete(km);
            loadData(iKhuyenMaiService.getAll());
            clearForm();
            helper.alert(this, "Xóa thành công");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void txt_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_SearchCaretUpdate
        // TODO add your handling code here:
        loadData(iKhuyenMaiService.findByName(txt_Search.getText()));
    }//GEN-LAST:event_txt_SearchCaretUpdate

    private void tb_danhSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_danhSachMousePressed
        // TODO add your handling code here:
        int row = tb_danhSach.getSelectedRow();
        KhuyenMai km = iKhuyenMaiService.getObj(tb_danhSach.getValueAt(row, 0).toString());
        khuyenMai = km;
        txt_Ma.setText(km.getMa());
        txt_TenKM.setText(km.getTen());
        txt_PhanTramGiam.setText(String.valueOf(km.getPhantramgiam()));
        sp_SoLuong.setValue(km.getSoLuong());
        date_NgayBatDau.setDate(km.getNgayBatDau());
        date_NgayKetThuc.setDate(km.getNgayKetThuc());
        imageAvatar1.setImage(new ImageIcon("images/voucher/" + km.getHinhAnh()));
    }//GEN-LAST:event_tb_danhSachMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmKhuyenMai dialog = new FrmKhuyenMai(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btn_CapNhat;
    private swing.Button btn_ChonKhuyenMai;
    private swing.Button btn_Them;
    private swing.Button btn_Xoa;
    private com.toedter.calendar.JDateChooser date_NgayBatDau;
    private com.toedter.calendar.JDateChooser date_NgayKetThuc;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Total;
    private swing.Spinner sp_SoLuong;
    private swing.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tb_danhSach;
    private swing.TextField txt_Ma;
    private swing.TextField txt_PhanTramGiam;
    private swing.TextField txt_Search;
    private swing.TextField txt_TenKM;
    // End of variables declaration//GEN-END:variables
}
