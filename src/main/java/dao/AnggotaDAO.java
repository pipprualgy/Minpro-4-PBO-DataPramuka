package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.AnggotaPramuka;
import Model.Siswa;
import Model.Pembina;
import config.Koneksi;

public class AnggotaDAO {
    
    private final Connection conn;
    
    public AnggotaDAO() {
        this.conn = Koneksi.getConnection();
    }
    //  CREATE
    public void tambahSiswa(Siswa siswa) {
        String sql = "INSERT INTO anggota_pramuka (id_anggota, nama_anggota, jenis_kelamin, kode_gudep, id_kwarran, tingkat_pramuka) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, siswa.getIdAnggota());
            ps.setString(2, siswa.getNamaAnggota());
            ps.setString(3, siswa.getJenisKelamin());
            ps.setInt(3, siswa.getKodeGugusDepan());
            ps.setInt(3, siswa.getIdKwarran());
            ps.setString(3, siswa.getTingkatPramuka());
            ps.executeUpdate();
            System.out.println("Data Siswa Berhasil Ditambahkan");
        } catch (SQLException exc) {
            System.out.println("Gagal Menambah Data Siswa - " + exc.getMessage());
        }
    }
    
    public void tambahPembina(Pembina pembina) {
                String sql = "INSERT INTO anggota_pramuka (id_anggota, nama_anggota, jenis_kelamin, kode_gudep, id_kwarran, hak_bina) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pembina.getIdAnggota());
            ps.setString(2, pembina.getNamaAnggota());
            ps.setString(3, pembina.getJenisKelamin());
            ps.setInt(3, pembina.getKodeGugusDepan());
            ps.setInt(3, pembina.getIdKwarran());
            ps.setString(3, pembina.getHakBina());
            ps.executeUpdate();
            System.out.println("Data Pembina Berhasil Ditambahkan");
        } catch (SQLException exc) {
            System.out.println("Gagal Menambah Data Pembina - " + exc.getMessage());
        }
    }
    
    //  READ
    
    public List<AnggotaPramuka> lihatAnggota() {
    List<AnggotaPramuka> listAnggota = new ArrayList<>();
    String sql = "SELECT * FROM anggota_pramuka";
    
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
         
        while (rs.next()) {
            int idAnggota = rs.getInt("id_anggota");
            String namaAnggota = rs.getString("nama_anggota");
            String jenisKelamin = rs.getString("jenis_kelamin");
            int idKwarran = rs.getInt("id_kwarran");
            int kodeGudep = rs.getInt("kode_gudep");
            String tingkatPramuka = rs.getString("tingkat_pramuka");
            String hakBina = rs.getString("hak_bina");
            if (tingkatPramuka != null) {
                Siswa siswa = new Siswa(idAnggota, namaAnggota, jenisKelamin, idKwarran, kodeGudep, tingkatPramuka);
                listAnggota.add(siswa);
                
            } else if (hakBina != null) {
                Pembina pembina = new Pembina(idAnggota, namaAnggota, jenisKelamin, idKwarran, kodeGudep, hakBina);
                listAnggota.add(pembina);
            }
        }
    } catch (SQLException exc) {
        System.out.println("Gagal Menampilkan Data Anggota - " + exc.getMessage());
    }
    return listAnggota;
}
    
    //  UPDATE
    
    public void updateSiswa(Siswa siswa) {
        String sql = "UPDATE anggota_pramuka SET nama_anggota = ?, jenis_kelamin = ?, kode_gudep = ?, id_kwarran = ?, tingkat_pramuka = ?, hak_bina = NULL WHERE id_anggota = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, siswa.getNamaAnggota());
            ps.setString(2, siswa.getJenisKelamin());
            ps.setInt(3, siswa.getKodeGugusDepan());
            ps.setInt(4, siswa.getIdKwarran());
            ps.setString(5, siswa.getTingkatPramuka());
            ps.setInt(6, siswa.getIdAnggota());
            
            int baris = ps.executeUpdate();
            if (baris > 0) {
                System.out.println("Data Siswa Berhasil Diubah");
            } else {
                System.out.println("ID Anggota Siswa tidak ditemukan.");
            }
        } catch (SQLException exc) {
            System.out.println("Gagal Mengubah Data Siswa - " + exc.getMessage());
        }
    }

    public void updatePembina(Pembina pembina) {
        String sql = "UPDATE anggota_pramuka SET nama_anggota = ?, jenis_kelamin = ?, kode_gudep = ?, id_kwarran = ?, tingkat_pramuka = NULL, hak_bina = ? WHERE id_anggota = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pembina.getNamaAnggota());
            ps.setString(2, pembina.getJenisKelamin());
            ps.setInt(3, pembina.getKodeGugusDepan());
            ps.setInt(4, pembina.getIdKwarran());
            ps.setString(5, pembina.getHakBina());
            ps.setInt(6, pembina.getIdAnggota());
            
            int baris = ps.executeUpdate();
            if (baris > 0) {
                System.out.println("Data Pembina Berhasil Diubah");
            } else {
                System.out.println("ID Anggota Pembina tidak ditemukan.");
            }
        } catch (SQLException exc) {
            System.out.println("Gagal Mengubah Data Pembina - " + exc.getMessage());
        }
    }
    
    //  DELETE
    
    public void hapusAnggota(int idAnggota) {
        String sql = "DELETE FROM anggota_pramuka WHERE id_anggota = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAnggota);
            
            int baris = ps.executeUpdate();
            if (baris > 0) {
                System.out.println("Data Anggota Pramuka Berhasil Dihapus");
            } else {
                System.out.println("ID Anggota tidak ditemukan.");
            }
        } catch (SQLException exc) {
            System.out.println("Gagal Menghapus Data Anggota - " + exc.getMessage());
        }
    }
}
