/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_A_.model;

/**
 *
 * @author HP
 */
public class Pelanggan {
    private String kodePelanggan;
    private String NamaPelanggan;
    private String JenisPelanggan;

    
    
    public Pelanggan(){
        
    }
    
    public Pelanggan(String kodePelanggan, String NamaPelanggan, String JenisPelanggan){
        this.kodePelanggan = kodePelanggan;
        this.NamaPelanggan = NamaPelanggan;
        this.JenisPelanggan = JenisPelanggan;
        
    }
    
     public String getkodePelanggan(){
        return kodePelanggan;      
    }
    public void setkode (String kodePelanggan ){
        this.kodePelanggan = kodePelanggan;
    }
    
    public String getNamaPelanggan(){
        return NamaPelanggan; 
    }
    public void setNama(String NamaPelanggan){
        this.NamaPelanggan = NamaPelanggan ;
    }
    
    public String getJenis(){
        return JenisPelanggan;
    }
    
    public void setJenis(String JenisPelanggan){
        this.JenisPelanggan = JenisPelanggan ;
    }
} 
   
    
   
    
