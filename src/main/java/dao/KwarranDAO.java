package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Kwarran;
import config.Koneksi;

public class KwarranDAO {
    private final Connection conn;
    
    public KwarranDAO() {
        this.conn = Koneksi.getConnection();
    }
    
    
    //  CREATE
    public void tambahKwarran(Kwarran kwarran) {
        String sql = "INSERT INTO Kwarran (id_kwarran, nama_kwarran) VALUES (?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, kwarran.getIdKwarran());
            ps.setString(2, kwarran.getNamaKwarran());
            
            ps.executeUpdate();
            System.out.println("Kwartir Ranting Berhasil Ditambahkan");
        } catch(SQLException exc) {
            System.out.println("Gagal Menambah Data Kwartir Ranting - " + exc.getMessage());
        }
    }
    
    //  READ
    public List<Kwarran> lihatKwarran() {
        List<Kwarran> daftarKwarran = new ArrayList<>();
        String sql = "SELECT * FROM kwarran";
        
        try(PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
        while (rs.next()) {
            int id = rs.getInt("id_kwarran");
            String nama = rs.getString("nama_kwarran");
            
            Kwarran kwarran = new Kwarran(id, nama);
            daftarKwarran.add(kwarran);
            }
        }catch (SQLException exc) {
            System.out.println("Gagal Mengambil Data Kwartir Ranting - " + exc.getMessage());
        }
        return daftarKwarran;
    }
    
    //  UPDATE
    public boolean update(int idKwarranUpdate, String namaKwarranUpdate, int idTerkait) {
        String sql = "UPDATE kwarran SET id_kwarran = ?, nama_kwarran = ? WHERE id_kwarran = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idKwarranUpdate);
            ps.setString(2, namaKwarranUpdate);
            ps.setInt(3, idTerkait);
            return ps.executeUpdate() > 0;
        } catch (SQLException exc) {
            return false;
        }
    }
    
    //  DELETE
        public void hapusKwarran(int idKwarran) {
            String sql = "DELETE FROM kwarran WHERE id_kwarran = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idKwarran);
                
                int baris = ps.executeUpdate();
                if (baris > 0) {
                    System.out.println("Data Kwartir Ranting berhasil dihapus!");
                } else {
                    System.out.println("ID Kwartir tidak ditemukan.");
                }
            } catch (SQLException exc) {
                System.out.println("Gagal Menghapus Data Kwartir" + exc.getMessage());
            }
        }
}
