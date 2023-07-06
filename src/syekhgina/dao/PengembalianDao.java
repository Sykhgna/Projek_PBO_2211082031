/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package syekhgina.dao;

import syekhgina.model.Pengembalian;
import java.util.List;
/**
 *
 * @author HP
 */
public interface PengembalianDao {
    void insert(Pengembalian p) throws Exception;
    void update(Pengembalian p) throws Exception;
    void delete(Pengembalian p) throws Exception;
    Pengembalian getPengembalian(String kodeanggota, String kodebuku, String tglpinjam) throws Exception;
    List<Pengembalian>getAll() throws Exception;
}
