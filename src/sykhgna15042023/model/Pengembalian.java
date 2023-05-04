/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sykhgna15042023.model;

/**
 *
 * @author HP
 */
public class Pengembalian {
    private String tgldikembalikan;
    private int terlambat;
    private double denda;
    private 
    
    public Pengembalian(){
    }
    
    public Pengembalian(Peminjaman peminjaman, Buku buku, String tglpinjam, String tglkembali){
        this.peminjaman = anggota;
        this.buku = buku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
    }
    
    public Anggota getAnggota(){
        return anggota;
    }
    public Buku getBuku(){
        return buku;
    }
    public String gettglPinjam(){
        return tglpinjam;
    }
 
    public String gettglKembali(){
        return tglkembali;
    }
    ////////////////////////////////////////
    
    public void setAnggota(Anggota anggota){
        this.anggota = anggota;
    }
    public void setBuku(Buku buku){
        this.buku = buku;
    }
    public void settglPinjam(String tglpinjam){
        this.tglpinjam = tglpinjam;
    }
    public void settglKembali(String tglkembali){
        this.tglkembali = tglkembali;
    }   
}
