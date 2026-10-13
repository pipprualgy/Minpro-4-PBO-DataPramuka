package Model;

public class Pembina extends AnggotaPramuka implements InfoPramuka{
    private String hakBina;
    
    public Pembina(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String hakBina){
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.hakBina = hakBina;
    }

    public String getHakBina() {
        return hakBina;
    }
    
    
    public void setHakBina(String hakBina){
        this.hakBina = hakBina;
    }
    
    @Override
    public void tampilkanData(){
        System.out.println("=== Data Pembina Pramuka ===");
        System.out.println("ID Anggota Pramuka: " + idAnggota);
        System.out.println("Nama Anggota Pramuka: " + namaAnggota);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Gugus Depan: " + kodeGugusDepan);
        System.out.println("Asal Kwarran: " + idKwarran);
        System.out.println("Sertifikat Hak Bina: " + hakBina);
    }
    
    @Override
    public void dataAnggota(){
        System.out.println("Pembina " + namaAnggota + " Memiliki Sertifikasi Hak Bina " + hakBina + " pada Nomor Gugus Depan " + kodeGugusDepan);
    }
}
