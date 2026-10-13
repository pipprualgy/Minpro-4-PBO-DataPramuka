package Model;

public class Siswa extends AnggotaPramuka implements InfoPramuka{
    private String tingkatPramuka;
    
    public Siswa(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String tingkatPramuka) {
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.tingkatPramuka = tingkatPramuka;
    }

    public String getTingkatPramuka() {
        return tingkatPramuka;
    }
    
    
    
    public void setTingkatPramuka(String tingkatPramuka) {
        this.tingkatPramuka = tingkatPramuka;
    }
    
    
    
    @Override
    public void tampilkanData(){
        System.out.println("=== Data Pramuka Siswa ===");
        System.out.println("ID Anggota Pramuka: " + idAnggota);
        System.out.println("Nama Anggota Pramuka: " + namaAnggota);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Gugus Depan: " + kodeGugusDepan);
        System.out.println("Asal Kwarran: " + idKwarran);
        System.out.println("Tingkat Pramuka Siswa: " + tingkatPramuka);
    }
    @Override
    public void dataAnggota(){
        System.out.println("Siswa " + namaAnggota + " adalah anggota pramuka tingkat " + tingkatPramuka);
    }
}
