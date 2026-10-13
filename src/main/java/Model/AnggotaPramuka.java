package Model;

public abstract class AnggotaPramuka{
    protected int idAnggota;
    protected String namaAnggota;
    protected String jenisKelamin;
    protected int kodeGugusDepan;
    protected int idKwarran;
    
    public AnggotaPramuka(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran) {
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
        this.jenisKelamin = jenisKelamin;
        this.kodeGugusDepan = kodeGugusDepan;
        this.idKwarran = idKwarran;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public int getKodeGugusDepan() {
        return kodeGugusDepan;
    }

    public int getIdKwarran() {
        return idKwarran;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setKodeGugusDepan(int kodeGugusDepan) {
        this.kodeGugusDepan = kodeGugusDepan;
    }

    public void setIdKwarran(int idKwarran) {
        this.idKwarran = idKwarran;
    }
    
    
    public abstract void tampilkanData(); 
//    {
//        System.out.println("ID Anggota Pramuka: " + idAnggota);
//        System.out.println("Nama Anggota Pramuka: " + namaAnggota);
//        System.out.println("Jenis Kelamin: " + jenisKelamin);
//        System.out.println("Gugus Depan: " + kodeGugusDepan);
//        System.out.println("Asal Kwarran: " + idKwarran);
//    }
    
    public void tampilkanData(String idNama){
            System.out.println(namaAnggota + " (" + idAnggota + ")" );
            tampilkanData();
    }
}
