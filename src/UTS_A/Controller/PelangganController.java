/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_A.Controller;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import UTS_A.model.List      ;
import UTS_A.view.List ;
/**
 *
 * @author HP
 */
public class PelangganController {
    private FormPelanggan formPelanggan;
    private Pelanggan pelanggan;
    private PelangganDao pelangganDao;
    
    public PelangganController(FormPelanggan formPelanggan){
        this.formPelanggan = formPelanggan;
        pelangganDao = new PelangganDaoImpl();
    }
    
     public void bersihForm(){
        formPelanggan.getTxtKodePelanggan().setText("");
        formPelanggan.getTxtNama().setText("");
        formPelanggan.getTxtJenisPelanggan().setText("");
    }
   
    public void savePelanggan(){
        pelanggan = new Pelanggan();
        pelanggan.setKodePelanggan(formPelanggan.getTxtKodePelanggan().getText());
        pelanggan.setNamaPelanggan(formPelanggan.getTxtNamaPelanggan().getText());
        pelanggan.setJenisPelanggan(formPelanggan.getJenisPelanggan().getText());
        pelanggan.setMeterbulanlalu(formPelanggan.getTxtMeterbulanlalu().getText());
        pelangganDao.save(pelanggan);
        JOptionPane.showMessageDialog(formPelanggan, "Insert ok ");
    }
    
    public void updatePelanggan(){
        int index = formPelanggan.getTblPelanggan().getSelectedRow();
        pelanggan.setKodePelanggan(formPelanggan.getTxtKodePelanggan().getText());
        pelanggan.setNamaPelanggan(formPelanggan.getTxtNamaPelanggan().getText());
        pelanggan.setJenisPelanggan(formPelanggan.getTxtJenisPelanggan().getText());
        pelangganDao.save(pelanggan);
        JOptionPane.showMessageDialog(formPelanggan, "Insert ok ");
    }
    
    public void delete(){
        int index = formPelanggan.getTblPelanggan().getSelectedRow();
        pelangganDao.delete(index);
         JOptionPane.showMessageDialog(formPelanggan, "Delete ok ");
    }
    
    public void getPelanggan(){
        int index = formPelanggan.getTblPelanggan().getSelectedRow();
        pelanggan = pelangganDao.getPelanggan(index);
        if(pelanggan != null ){
            formPelanggan.getTxtKodePelanggan().setText(pelanggan.getKodePelanggan());
            formPelanggan.getTxtNamaPelanggan().setText(pelanggan.getNama());
            formPelanggan.getTxtJenisPelanggan().setText(pelanggan.getMeterbulanini());
        }
    }
    
    public void tampil(){
        DefaultTableModel tabelModel =
                (DefaultTableModel) formPelanggan.getTblPelanggan().getModel();
        tabelModel.setRowCount(0);
        List<Pelanggan> list = pelangganDao.getAllPelanggan();
        for (Pelanggan pelanggan1 : list){
            Object row[]= {
                pelanggan1.getKodePelanggan(),
                pelanggan1.getNamaPelanggan(),
                pelanggan1.getJenisPelanggan(),
                
            };
            tabelModel.addRow(row);
        }
    }
}
