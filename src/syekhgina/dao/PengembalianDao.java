/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package syekhgina.dao;

import java.sql.SQLException;
import syekhgina.model.Pengembalian;
import java.util.List;
/**
 *
 * @author HP
 */
public interface PengembalianDao {
   void insert(Pengembalian pengembalian) throws Exception;
    void update(Pengembalian pengembalian) throws Exception;
    void delete(Pengembalian pengembalian) throws Exception;
    Pengembalian getPengembalian(String kodeAnggota, String Kodebuku, String Tglpinjam)throws Exception;
    List<Pengembalian> getAll()throws SQLException;
    int selisihtgl(String tgl1, String tgl2) throws Exception;
    List<Pengembalian> cari(String kode, String cari) throws Exception;
}
