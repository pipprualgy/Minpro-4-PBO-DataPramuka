package Model;



public class Kwarran {
   private final int idKwarran;
   private String namaKwarran;
   
   public Kwarran(int idKwarran, String namaKwarran) {
       this.idKwarran = idKwarran;
       this.namaKwarran = namaKwarran;
   }

    public int getIdKwarran() {
        return idKwarran;
    }

    public String getNamaKwarran() {
        return namaKwarran;
    }
    

    public void setNamaKwarran(String namaKwarran) {
        this.namaKwarran = namaKwarran;
    }
   
   public void tampilkanData() {
       System.out.println("ID Kwarran: " + idKwarran);
       System.out.println("Nama Kwarran: " + namaKwarran);
   }
}
