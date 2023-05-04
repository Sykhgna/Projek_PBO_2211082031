/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sykhgna15042023.model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class BukuDaoImpl implements BukuDao {
     List<Buku> data = new ArrayList<>();
    
    public BukuDaoImpl(){
        data.add(new Buku("2152023","Bumi","Tereliye","Andalas","2017"));
        data.add(new Buku("2142023","Bulan","Tereliye","Andalas","2018"));
        data.add(new Buku("2132023","Bintang","Tereliye","Andalas","2019"));
        data.add(new Buku("2122023","Matahari","Tereliye","Andalas","2019"));
    }
    
    public void save(Buku buku){
        data.add(buku);
    }
    
    public void update(int index, Buku buku){
        data.set(index, buku);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Buku getBuku(int index){
        return data.get(index);
    }
    
    public List<Buku> getAll(){
        return data;
    }
}
