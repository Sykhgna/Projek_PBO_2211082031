/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syekhgina.dao;

import syekhgina.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class PengembalianDaoImpl implements PengembalianDao {
       private Connection con;
   
    public PengembalianDaoImpl(Connection con){
        this.con = con;
    }
    
    public void insert (Pengembalian p) throws Exception{
       String sql = "insert into Peminjaman values(?,?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,p.getKodeAnggota());
        ps.setString(2,p.getKodebuku());
        ps.setString(3,p.getTglpinjam());
        ps.setString(4,p.getDikembalikan());
        ps.setInt(5,p.getTerlambat());
        ps.setDouble(6,p.getDenda());
       ps.executeUpdate();
       ps.close();
    }
    public void update (Pengembalian p) throws Exception{
        String sql = "UPDATE pengembalian set Tgldikembalikan=?, terlambat=?, denda=? "
                    +"WHERE kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(4,p.getKodeAnggota());
        ps.setString(5,p.getKodebuku());
        ps.setString(6,p.getTglpinjam());
        ps.setString(1,p.getDikembalikan());
        ps.setInt(2,p.getTerlambat());
        ps.setDouble(3,p.getDenda());
        ps.executeUpdate();
    }    
    public void delete(Pengembalian p) throws Exception{
            
        String sql = "DELETE FROM pengembalian WHERE kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,p.getKodeAnggota());
        ps.setString(2,p.getKodebuku());
        ps.setString(3,p.getTglpinjam());
        ps.executeUpdate();
    }
    public Pengembalian getPengembalian(String kodeanggota, String kodebuku, String tglpinjam) throws Exception{
        String sql = "select * from peminjaman WHERE kodeanggota=? and kodebuku=? and tglpinjam=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Pengembalian p = null;
        if(rs.next()){
            p = new Pengembalian();
            PeminjamanDao peminjamanDao = new PeminjamanDaoImpl(con);
            Peminjaman peminjaman = peminjamanDao.getPeminjaman( rs.getString(1), 
                    rs.getString(2), rs.getString(3));
            
        }
        return p;
    } 
    

   public List<Pengembalian> getAll()throws SQLException {
        String sql = "SELECT * FROM pengembalian";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Pengembalian p; 
        List <Pengembalian> list = new ArrayList<>();
        while(rs.next()){
            p = new Pengembalian();
            PeminjamanDao peminjamanDao = new PeminjamanDaoImpl(con);
            
            list.add(p);
        }
        return list;
    }

    @Override
    public int selisihtgl(String tgl1, String tgl2) throws Exception {
        int selisih = 0;
        String sql = "SELECT DATEDIFF(?,?) as selisih";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tgl1);
        ps.setString(2, tgl2);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            selisih = rs.getInt(1);
        }
        return selisih;
    }
    
}
