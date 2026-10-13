package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.GugusDepan;
import config.Koneksi;


public class GudepDAO {
    
    private final Connection conn;
    
    public GudepDAO() {
        this.conn = Koneksi.getConnection();
    }
    
    
    //  CREATE
    
    public void tambahGudep (GugusDepan gudep) {
        String sql = "INSERT INTO gugus_depan(kode_gudep, nama_gudep, pangkalan) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, gudep.getKodeGugusDepan());
            ps.setString(2, gudep.getNamaGugusDepan());
            ps.setString(3, gudep.getPangkalan());
            
            ps.executeUpdate();
            System.out.println("Gugus Depan Berhasil Ditambahkan");
        } catch (SQLException exc) {
            System.out.println("Gagal Menambah Data Gugus Depan - " + exc.getMessage());
        }
    }
    
    //  READ
    
        public List<GugusDepan> lihatGudep() {
        List<GugusDepan> daftarGudep = new ArrayList<>();
        String sql = "SELECT * FROM gugus_depan";
        
        try(PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
        while (rs.next()) {
            int kode = rs.getInt("kode_gudep");
            String nama = rs.getString("nama_gudep");
            String pangkalan = rs.getString("pangkalan");
            
            GugusDepan gudep = new GugusDepan(kode, nama, pangkalan);
            daftarGudep.add(gudep);
            }
        }catch (SQLException exc) {
            System.out.println("Gagal Menampilkan Data Gugus Depan - " + exc.getMessage());
        }
        return daftarGudep;
    }
        
    //  Update
    
    public boolean update(int kodeBaru, String namaBaru, String pangkalanBaru, int kodeLama) {
        String sql = "UPDATE gugus_depan SET kode_gudep = ?, nama_gudep = ?, pangkalan = ? WHERE kode_gudep = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, kodeBaru);
            ps.setString(2, namaBaru);
            ps.setString(3, pangkalanBaru);
            ps.setInt(4, kodeLama);
            return ps.executeUpdate() > 0;
        } catch (SQLException exc) {
            System.out.println("Gagal Mengupdate Data Gugus Depan - " + exc.getMessage());
            return false;
        }
    }
    
    //  Delete
    
    public void deleteGudep(int idDeleteGudep) {
        String sql = "DELETE FROM gugus_depan WHERE kode_gudep = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idDeleteGudep);
                
                int baris = ps.executeUpdate();
                if (baris > 0) {
                    System.out.println("Data Gugus Depan berhasil dihapus");
                } else {
                    System.out.println("Kode Gugus Depan Tidak Ditemukan.");
                }
            } catch (SQLException exc) {
                System.out.println("Gagal Menghapus Data Gugus Depan" + exc.getMessage());
            }
    }

}
