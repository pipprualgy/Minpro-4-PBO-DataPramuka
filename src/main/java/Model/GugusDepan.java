package Model;

public class GugusDepan {
    private final int kodeGugusDepan;
    private String namaGugusDepan;
    private String pangkalan;
    
    public GugusDepan(int kodeGugusDepan, String namaGugusDepan, String Pangkalan) {
        this.kodeGugusDepan = kodeGugusDepan;
        this.namaGugusDepan = namaGugusDepan;
        this.pangkalan = Pangkalan;
    }

    public int getKodeGugusDepan() {
          return kodeGugusDepan;
        }

    public String getNamaGugusDepan() {
        return namaGugusDepan;
    }

    public String getPangkalan() {
        return pangkalan;
    }    
    

    public void setNamaGugusDepan(String namaGugusDepan) {
        this.namaGugusDepan = namaGugusDepan;
    }

    public void setPangkalan(String pangkalan) {
        this.pangkalan = pangkalan;
    }
    
    public void tampilkanData(){
        System.out.println("Kode Gugus Depan: " + kodeGugusDepan);
        System.out.println("Nama Gugus Depan: " + namaGugusDepan);
        System.out.println("Pangkalan: " + pangkalan);
    }
}
   