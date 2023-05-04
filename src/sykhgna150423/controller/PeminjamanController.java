/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sykhgna150423.controller;
import sykhgna.view.FormPeminjaman;
import sykhgna.model.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class PeminjamanController {
    private FormPeminjaman formPeminjaman;
    private PeminjamanDao peminjamanDao;
    private Peminjaman peminjaman;
    
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        this.formPeminjaman = formPeminjaman;
        peminjamanDao = new PeminjamanDaoImpl();
        anggotaDao = new AnggotaDaoImpl();
        bukuDao = new BukuDaoImpl();
    }
          
    public void bersihForm(){
        formPeminjaman.getCboAnggota().setSelectedIndex("");
        formPeminjaman.getCboBuku().setSelectedIndex("");
        formPeminjaman.getTxttglPinjam().setText("");
        formPeminjaman.getTxttglKembali().setText("");
    }
    
    public void isiCombo(){
        List<Anggota> listAnggota = anggotaDao.getAll();
        List<Buku> listBuku = bukuDao.getAll();
        formPeminjaman.getCboAnggota().removeAllItems();
        formPeminjaman.getCboBuku().removeAllItems();
    
        //list anggota
        for(Anggota anggota : listAnggota){
            formPeminjaman.getCboAnggota().addItem(anggota.getNobp());
        }

        for(Buku buku : listBuku){
            formPeminjaman.getCboBuku().addItem(buku.getkodeBuku());
        }
    }
    
    public void savePeminjaman(){
        peminjaman = new Peminjaman();
        peminjaman .setAnggota(anggotaDao.getAnggota(formPeminjaman.getCboAnggota().getSelectedIndex()));
        peminjaman.setBuku(bukuDao.getBuku(formPeminjaman.getCboBuku().getSelectedIndex()));
        peminjaman.settglPinjam(formPeminjaman.getTxttglPinjam().getText());
        peminjaman.settglKembali(formPeminjaman.getTxttglKembali().getText());
        peminjamanDao.save(peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman, "Entri OK");
    }
    
    public void getPeminjaman(){
        int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman = peminjamanDao.getPeminjaman(index);
        if(peminjaman != null){
            formPeminjaman.getCboAnggota().setSelectedItem(peminjaman.getAnggota().getNobp());
            formPeminjaman.getCboBuku().setSelectedItem(peminjaman.getBuku().getkodeBuku());
            formPeminjaman.getTxttglPinjam().setText(peminjaman.gettglPinjam());
            formPeminjaman.getTxttglKembali().setText(peminjaman.gettglKembali());
        }
    }
    
    public void updatePeminjaman(){
        int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjaman.getAnggota(formPeminjaman.getCboAnggota().getSelectedIndex());
        peminjaman.setkodeBuku(formPeminjaman.getCboBuku().getSelectedIndex());
        peminjaman.settglPinjam(formPeminjaman.getTxttglPinjam().getText());
        peminjaman.settglKembali(formPeminjaman.getTxttglKembali().getText());
        peminjamanDao.update(index,peminjaman);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman, "Update OK");
    }
    
    public void deletePeminjaman(){
        int index = formPeminjaman.getTblPeminjaman().getSelectedRow();
        peminjamanDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formPeminjaman, "Delete OK");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel = 
                (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Peminjaman> list = peminjamanDao.getAll();
        for(Peminjaman peminjaman : list){
            Object[] data = {
                peminjaman.getAnggota(),
                peminjaman.getBuku(),
                peminjaman.gettglPinjam(),
                peminjaman.gettglKembali()
            };
            tabelModel.addRow(data);
        }
    }
}
