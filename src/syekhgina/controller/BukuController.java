/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syekhgina.controller;
import syekhgina.model.*;
import syekhgina.dao.*;
import syekhgina.db.*;
import syekhgina.view.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class BukuController {
    FormBuku view;
    Buku buku;
    BukuDao dao;
    Connection connection;
    
    public BukuController(FormBuku view) {
        try {
            this.view = view;
            connection = DbHelper.getConnection();
            dao = new BukuDaoImpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cls(){
        view.getTxtkode().setText("");
        view.getTxtjudul().setText("");
        view.getTxtpengarang().setText("");
        view.getTxtpenerbit().setText("");
    }
    
    public void tampil(){
        try {
             DefaultTableModel tabelModel = (DefaultTableModel) view.getTblbuku().getModel();
             tabelModel.setRowCount(0);
             List<Buku> list = dao.getAll();
             for(Buku a : list){
                 Object[]row = {
                     a.getKodebuku(),
                     a.getJudulbuku(),
                     a.getPengarang(),
                     a.getPenerbit()
                 };
                 tabelModel.addRow(row);
             }
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void insert(){
        try {
            buku = new Buku();
            buku.setKodebuku(view.getTxtkode().getText());
            buku.setJudulbuku(view.getTxtjudul().getText());
            buku.setPengarang(view.getTxtpengarang().getText());
            buku.setPenerbit(view.getTxtpenerbit().getText());
            dao.insert(buku);
            JOptionPane.showMessageDialog(view, "tambah data ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void delete(){
        try {
            dao.delete(buku);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void tabelKlik(){
        try {
            String kodebuku = view.getTblbuku().getValueAt(view.getTblbuku().getSelectedRow(),0).toString();
            buku = dao.getBuku(kodebuku);
            view.getTxtkode().setText(buku.getKodebuku());
            view.getTxtjudul().setText(buku.getJudulbuku());
            view.getTxtpengarang().setText(buku.getPengarang());
            view.getTxtpenerbit().setText(buku.getPenerbit());
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public void update(){
        try {
            buku.setKodebuku(view.getTxtkode().getText());
            buku.setJudulbuku(view.getTxtjudul().getText());
            buku.setPengarang(view.getTxtpengarang().getText());
            buku.setPenerbit(view.getTxtpenerbit().getText());
            dao.update(buku);
            JOptionPane.showMessageDialog(view,"update data ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
