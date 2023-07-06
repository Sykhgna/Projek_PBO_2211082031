/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syekhgina.model;

/**
 *
 * @author HP
 */
public class Peminjaman {
     private Anggota agt;
    private Buku bk;
    private String tglpinjam;
    private String tglkembali;
    
    public Peminjaman(){
    
    }

    public Peminjaman( Anggota a, Buku b, String tglpinjam, String tglkembali) {
        this.agt = agt;
        this.bk = bk;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
    }

    public Anggota getAnggota() {
        return agt;
    }
    
    public void setAnggota(Anggota anggota) {
        this.agt = agt;
    }

    public Buku getBuku() {
        return bk;
    }
    
    public void setBuku(Buku buku) {
        this.bk = bk;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }
    
    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }
    
    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }  
}
