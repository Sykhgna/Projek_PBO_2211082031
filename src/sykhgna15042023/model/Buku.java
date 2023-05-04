/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sykhgna15042023.model;

/**
 *
 * @author HP
 */
public class Buku {
    private String kodebuku;
    private String judulbuku;
    private String pengarang;
    private String penerbit;
    private String tahunterbit;
    
    public Buku(){
    }
    
    public Buku(String kodebuku, String judulbuku, String pengarang, String penerbit, String tahunterbit){
        this.kodebuku = kodebuku;
        this.judulbuku = judulbuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunterbit = tahunterbit;
    }
    
    public String getkodeBuku(){
        return kodebuku;
    }
    public void setkodeBuku(String kodebuku){
        this.kodebuku = kodebuku;
    }
    ////////////////////////////////////
    
    public String getjudulBuku(){
        return judulbuku;
    }
    public void setjudulBuku(String judulbuku){
        this.judulbuku = judulbuku;
    }
    ////////////////////////////////////
    
    public String getPengarang(){
        return pengarang;
    }
    public void setPengarang(String pengarang){
        this.pengarang = pengarang;
    }
    ////////////////////////////////////
    
    public String getPenerbit(){
        return penerbit;
    }
    public void setPenerbit(String penerbit){
        this.penerbit = penerbit;
    }
    ////////////////////////////////////
    
    public String gettahunTerbit(){
        return tahunterbit;
    }
    public void settahunTerbit(String tahunterbit){
        this.tahunterbit = tahunterbit;
    }
    ////////////////////////////////////

}
