package Controller;

import java.util.List;
import Model.AnggotaPramuka;
import Model.Siswa;
import Model.Pembina;
import Model.Kwarran;
import Model.GugusDepan;
import Model.InfoPramuka;
import dao.GudepDAO;
import dao.KwarranDAO;
import dao.AnggotaDAO;


public class PramukaController {
    private final GudepDAO gudepDAO = new GudepDAO();
    private final KwarranDAO kwarranDAO = new KwarranDAO();
    private final AnggotaDAO anggotaDAO = new AnggotaDAO();
    
    public PramukaController() {
   
    }
    
    public List<GugusDepan> getGugusDepanList() {
        return gudepDAO.lihatGudep();}
    public List<Kwarran> getKwarranList() {
        return kwarranDAO.lihatKwarran();}
    public List<AnggotaPramuka> getAnggotaList() {
        return anggotaDAO.lihatAnggota();}

    // Gugus Depan
    public void tambahGudep(int kodeGugusDepan, String namaGugusDepan, String pangkalan) {
        GugusDepan gudep = new GugusDepan(kodeGugusDepan, namaGugusDepan, pangkalan);
        gudepDAO.tambahGudep(gudep);
    }

    public boolean updateGudep(int kodeLama, int kodeBaru, String namaBaru, String pangkalanBaru) {
        return gudepDAO.update(kodeBaru, namaBaru, pangkalanBaru, kodeLama);
    }

    public boolean hapusGudep(int kodeGugusDepan) {
        try {
            gudepDAO.deleteGudep(kodeGugusDepan);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    // Kwartir Ranting
    public void tambahKwarran(int idKwarran, String namaKwarran) {
        Kwarran kwarran = new Kwarran(idKwarran, namaKwarran);
        kwarranDAO.tambahKwarran(kwarran);
    }

    public boolean updateKwarran(int idKwarran, String namaKwarranBaru) {
        return kwarranDAO.update(idKwarran, namaKwarranBaru, idKwarran);
    }

    public boolean hapusKwarran(int idKwarran) {
        try {
            kwarranDAO.hapusKwarran(idKwarran);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }

    // Anggota Pramuka
    public void tambahSiswa(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String tingkatPramuka) {
        Siswa siswa = new Siswa(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, tingkatPramuka);
        anggotaDAO.tambahSiswa(siswa);
    }

    public void tambahPembina(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String hakBina) {
        Pembina pembina = new Pembina(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, hakBina);
        anggotaDAO.tambahPembina(pembina);
    }

    public boolean updateAnggota(int idAnggota, String namaAnggotaBaru, String jenisKelaminBaru, int kodeGugusDepanBaru, int idKwarranBaru, String atributKhususBaru) {
        List<AnggotaPramuka> listAnggota = anggotaDAO.lihatAnggota();
        for (AnggotaPramuka anggota : listAnggota) {
            if (anggota.getIdAnggota() == idAnggota) {
                if (anggota instanceof Siswa) {
                    Siswa siswaBaru = new Siswa(idAnggota, namaAnggotaBaru, jenisKelaminBaru, kodeGugusDepanBaru, idKwarranBaru, atributKhususBaru);
                    anggotaDAO.updateSiswa(siswaBaru);
                } else if (anggota instanceof Pembina) {
                    Pembina pembinaBaru = new Pembina(idAnggota, namaAnggotaBaru, jenisKelaminBaru, kodeGugusDepanBaru, idKwarranBaru, atributKhususBaru);
                    anggotaDAO.updatePembina(pembinaBaru);
                }
                return true;
            }
        }
        return false;
    }

    public boolean hapusAnggota(int idAnggota) {
        try {
            anggotaDAO.hapusAnggota(idAnggota);
            return true;
        } catch (Exception exc) {
            return false;
        }
    }
}