/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syekhgina.controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import syekhgina.db.DbHelper;
import syekhgina.dao.*;
import syekhgina.model.*;
import syekhgina.view.FormPengembalian;


/**
 *
 * @author HP
 */
public class PengembalianController {
    private Pengembalian pengembalian;
    private PengembalianDao pengembalianDao;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    private PeminjamanDao peminjamanDao;
    private Connection connection;
    private FormPengembalian form;
    
    public PengembalianController(FormPengembalian formpengembalian){
        try {
            connection = DbHelper.getConnection();
            this.form = formpengembalian;
            pengembalianDao = new PengembalianDaoImpl(connection);
            anggotaDao = new AnggotaDaoImpl(connection);
            bukuDao = new BukuDaoImpl(connection);
            peminjamanDao = new PeminjamanDaoImpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void Clear(){
            form.getTxtTanggalPinjam().setText("");
            form.getTxtDenda().setText("");
            form.getTxtTanggalDikembalikan().setText("");
            form.getTxtTerlambat().setText("");
            form.getCboKodeAnggota().setSelectedItem(0);
            form.getCboKodeBuku().setSelectedItem(0);
        }  
        public void IsiCombo(){
        try {
            form.getCboKodeAnggota().removeAllItems();
            for(Anggota anggota : anggotaDao.getAll()){
                form.getCboKodeAnggota().addItem(anggota.getKodeanggota());
            }
            form.getCboKodeBuku().removeAllItems();
            for(Buku buku : bukuDao.getAll()){
                form.getCboKodeBuku().addItem(buku.getKodebuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        public void TampilData(){
        try {
            DefaultTableModel tableModel =(DefaultTableModel) form.getTblPengembalian().getModel();
            tableModel.setRowCount(0);
            List<Pengembalian> list = pengembalianDao.getAll();
            for(Pengembalian pengembalian: list){
                Anggota anggota= anggotaDao.getAnggota(pengembalian.getKodeAnggota());
                Buku buku = bukuDao.getBuku(pengembalian.getKodebuku());
                Object[] row = {
                    anggota.getKodeanggota(),
                    anggota.getNamaanggota(),
                    buku.getKodebuku(),
                    buku.getJudulbuku(),
                    pengembalian.getDikembalikan(),
                    pengembalian.getTglpinjam()
                        
                        
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public void get(){
        try {
            String kodeA = form.getTblPengembalian().getValueAt(form.getTblPengembalian().getSelectedRow(), 0).toString();
            String kodeB = form.getTblPengembalian().getValueAt(form.getTblPengembalian().getSelectedRow(), 1).toString();
            String tglP = form.getTblPengembalian().getValueAt(form.getTblPengembalian().getSelectedRow(), 2).toString();
            pengembalian = pengembalianDao.getPengembalian(kodeA, kodeB, tglP);
            form.getTxtTanggalPinjam().setText(pengembalian.getTglpinjam());
            form.getTxtDenda().setText(""+ pengembalian.getDenda());
            form.getTxtTanggalDikembalikan().setText(pengembalian.getTglkembali());
            form.getTxtTerlambat().setText(""+pengembalian.getTerlambat());
            form.getCboKodeAnggota().setSelectedItem(0);
            form.getCboKodeBuku().setSelectedItem(0);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(form, "Get row error\n"+e);
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, e);
        }
        }
    
    public void insert(){
        try {
            pengembalian = new Pengembalian();
            pengembalian.setKodeAnggota(form.getCboKodeAnggota().getSelectedItem().toString());
            pengembalian.setKodebuku(form.getCboKodeBuku().getSelectedItem().toString());
            pengembalian.setTglpinjam(form.getTxtTanggalPinjam().getText());
            pengembalian.setDikembalikan(form.getTxtTanggalDikembalikan().getText());
            pengembalian.setTglkembali(form.getTxtTanggalDikembalikan().getText());
            pengembalian.setTerlambat(pengembalianDao.selisihtgl(form.getTxtTanggalDikembalikan().getText(), form.getTxtTanggalDikembalikan().getText()));
            pengembalianDao.insert(pengembalian);
            JOptionPane.showMessageDialog(form, "Insert Ok!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Insert error \n"+ex.getMessage());
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            pengembalian.setKodeAnggota(form.getCboKodeAnggota().getSelectedItem().toString());
            pengembalian.setKodebuku(form.getCboKodeBuku().getSelectedItem().toString());
            pengembalian.setTglpinjam(form.getTxtTanggalPinjam().getText());
            pengembalian.setDikembalikan(form.getTxtTanggalDikembalikan().getText());
            pengembalian.setTglkembali(form.getTxtTanggalDikembalikan().getText());
            pengembalian.setTerlambat(pengembalianDao.selisihtgl(form.getTxtTanggalDikembalikan().getText(), form.getTxtTanggalDikembalikan().getText()));
            pengembalianDao.insert(pengembalian);
            JOptionPane.showMessageDialog(form, "Update Ok!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage());
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            pengembalianDao.delete(pengembalian);
            JOptionPane.showMessageDialog(form, "Delete OK!");
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
 