/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sykhgna15042023.model;
import java.util.List;
/**
 *
 * @author HP
 */
public interface BukuDao {
    void save(Buku buku);
    void update(int index, Buku buku);
    void delete(int index);
    Buku getBuku(int index);
    List<Buku> getAll();
}
