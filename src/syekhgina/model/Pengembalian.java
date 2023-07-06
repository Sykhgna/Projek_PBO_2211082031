/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syekhgina.model;

/**
 *
 * @author HP
 */
public class Pengembalian {
    private Peminjaman p;
    private String tgldikembalikan;
    private String terlambat;
    private String denda;
    
    public Pengembalian(){

    }

    public Pengembalian(Peminjaman p, String tgldikembalikan, String terlambat, String denda) {
        this.p = p;
        this.tgldikembalikan = tgldikembalikan;
        this.terlambat = terlambat;
        this.denda = denda;
    }

    public Peminjaman getP() {
        return p;
    }

    public String getTgldikembalikan() {
        return tgldikembalikan;
    }

    public String getTerlambat() {
        return terlambat;
    }

    public String getDenda() {
        return denda;
    }

    public void setP(Peminjaman p) {
        this.p = p;
    }

    public void setTgldikembalikan(String tgldikembalikan) {
        this.tgldikembalikan = tgldikembalikan;
    }

    public void setTerlambat(String terlambat) {
        this.terlambat = terlambat;
    }

    public void setDenda(String denda) {
        this.denda = denda;
    }
}
