/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sykhgna150423.controller;
import sykhgna.view.FormBuku;
import sykhgna.model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class BukuController {
    private FormBuku formBuku;
    private BukuDao bukuDao;
    private Buku buku;
    
    public BukuController(FormBuku formBuku){
        this.formBuku = formBuku;
        bukuDao = new BukuDaoImpl();
    }
    
    public void bersihForm(){
        formBuku.getTxtkodeBuku().setText("");
        formBuku.getTxtjudulBuku().setText("");
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtPenerbit().setText("");
        formBuku.getTxttahunTerbit().setText("");
    }
    
    public void saveBuku(){
        buku = new Buku();
        buku.setkodeBuku(formBuku.getTxtkodeBuku().getText());
        buku.setjudulBuku(formBuku.getTxtjudulBuku().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.settahunTerbit(formBuku.getTxttahunTerbit().getText());
        bukuDao.save(buku);
        javax.swing.JOptionPane.showMessageDialog(formBuku, "Entri OK");
    }
    
    public void getBuku(){
        int index = formBuku.getTblBuku().getSelectedRow();
        buku = bukuDao.getBuku(index);
        if(buku != null){
            formBuku.getTxtkodeBuku().setText(buku.getkodeBuku());
            formBuku.getTxtjudulBuku().setText(buku.getjudulBuku());
            formBuku.getTxtPengarang().setText(buku.getPengarang());
            formBuku.getTxtPenerbit().setText(buku.getPenerbit());
            formBuku.getTxttahunTerbit().setText(buku.gettahunTerbit());
        }
    }
    
    public void updateBuku(){
        int index = formBuku.getTblBuku().getSelectedRow();
        buku.setkodeBuku(formBuku.getTxtkodeBuku().getText());
        buku.setjudulBuku(formBuku.getTxtjudulBuku().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.settahunTerbit(formBuku.getTxttahunTerbit().getText());
        bukuDao.update(index,buku);
        javax.swing.JOptionPane.showMessageDialog(formBuku, "Update OK");
    }
    
    public void deleteBuku(){
        int index = formBuku.getTblBuku().getSelectedRow();
        bukuDao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formBuku, "Delete OK");
    }
    
    public void tampilData(){
        DefaultTableModel tabelModel = 
                (DefaultTableModel) formBuku.getTblBuku().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Buku> list = bukuDao.getAll();
        for(Buku buku : list){
            Object[] data = {
                buku.getkodeBuku(),
                buku.getjudulBuku(),
                buku.getPengarang(),
                buku.getPenerbit(),
                buku.gettahunTerbit()
            };
            tabelModel.addRow(data);
        }
    }
}
