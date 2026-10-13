# Mini Project 4 PBO Data Pramuka

## Deskripsi Singkat Program

Program berbasis konsol (CLI) ini dirancang untuk mengelola data keorganisasian Pramuka secara terstruktur, persisten, dan terpusat. Sistem ini mencakup pengelolaan data Gugus Depan, Kwartir Ranting (Kwarran), serta Anggota Pramuka (yang terbagi menjadi golongan Siswa dan Pembina) dengan menerapkan sistem manajemen CRUD (Create, Read, Update, Delete) yang terhubung langsung ke database MySQL menggunakan JDBC (Java Database Connectivity) dan arsitektur Data Access Object (DAO).

## Struktur Package

Struktur proyek ini dibagi ke dalam beberapa package utama untuk menerapkan pemisahan tanggung jawab/peran (separation of concerns) secara profesional:
1. com.mycompany.minprodatapramuka: Berisi kelas utama MinproDataPramuka.java sebagai titik awal eksekusi program (entry point).   
2. config: Berisi kelas Koneksi.java untuk pengelolaan koneksi database JDBC serta TesKoneksi.java untuk pengujian konektivitas.   
3. Model: Mewakili lapisan data dan objek bisnis yang mencakup kelas abstrak AnggotaPramuka.java, kelas turunan Siswa.java dan Pembina.java, entitas pendukung GugusDepan.java dan Kwarran.java, serta interface InfoPramuka.java.   
4. View: Berisi kelas PramukaView.java yang menangani antarmuka pengguna berbasis konsol (CLI) dan navigasi menu.   
5. Controller: Berisi kelas PramukaController.java sebagai jembatan logika bisnis antara View dan lapisan DAO.   
6. dao: Berisi kelas AnggotaDAO.java, GudepDAO.java, dan KwarranDAO.java yang mengimplementasikan operasi database relasional secara terstruktur.

```

com.mycompany.minprodatapramuka
│
├── MinproDataPramuka.java         ← Entry point (method main)
│
├── config                         ← CONFIG: manajemen koneksi database
│   ├── Koneksi.java               ← Konfigurasi JDBC MySQL
│   └── TesKoneksi.java            ← Utility uji koneksi
│
├── Model                          ← MODEL: struktur data & objek bisnis
│   ├── AnggotaPramuka.java        ← Abstract class (superclass anggota pramuka)
│   ├── Siswa.java                 ← Subclass AnggotaPramuka & implement InfoPramuka
│   ├── Pembina.java               ← Subclass AnggotaPramuka & implement InfoPramuka
│   ├── InfoPramuka.java           ← Interface kontrak informasi tambahan
│   ├── GugusDepan.java            ← Entitas data Gugus Depan
│   └── Kwarran.java               ← Entitas data Kwartir Ranting
│
├── View                           ← VIEW: tampilan & pembacaan input
│   └── PramukaView.java           ← Antarmuka konsol & navigasi menu CLI
│
├── Controller                     ← CONTROLLER: alur & logika bisnis
│   └── PramukaController.java     ← Pengatur alur data ke DAO
│
└── dao                            ← DAO: lapisan akses data database
    ├── AnggotaDAO.java            ← Operasi database tabel anggota
    ├── GudepDAO.java              ← Operasi database tabel gugus depan
    └── KwarranDAO.java            ← Operasi database tabel kwarran
```

## Alur Program

Alur eksekusi program dimulai dari kelas utama MinproDataPramuka yang bertindak sebagai titik masuk (entry point), di mana metode main menginisialisasi objek PramukaController dan PramukaView lalu memanggil metode mulai(). Di dalam metode mulai(), program menampilkan menu utama berbasis konsol yang mencakup pilihan pengelolaan Gugus Depan, Kwartir Ranting, Anggota Pramuka, serta opsi keluar program.

Setiap kali pengguna memilih menu, program menggunakan perulangan dengan validasi input Scanner untuk memastikan masukan data valid. Ketika pengguna mengakses menu CRUD, permintaan akan diteruskan dari View ke Controller, lalu ke kelas DAO masing-masing (KwarranDAO, GudepDAO, atau AnggotaDAO) untuk dieksekusi ke database MySQL melalui JDBC Prepared Statements. Khusus pada menu Anggota Pramuka, program mendukung tabel polimorfik dengan kolom dinamis (NULL handling untuk tingkat_pramuka dan hak_bina), sehingga entitas Siswa dan Pembina dapat dikelola secara fleksibel dalam satu tabel terpusat.

## Penerapan Encapsulation & Inheritance
### Encapsulation
Encapsulation adalah pembungkusan data dan metode ke dalam satu unit serta pembatasan akses langsung menggunakan modifier hak akses.

```java

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

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }
```

### Inheritance

Inheritance adalah mekanisme pewarisan atribut dan metode dari superclass ke subclass.

#### Superclass (AnggotaPramuka.java)

```java

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
}

```

#### Subclass (Siswa.java)

```java

public class Siswa extends AnggotaPramuka implements InfoPramuka{
    private String tingkatPramuka;

    public Siswa(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String tingkatPramuka) {
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.tingkatPramuka = tingkatPramuka;
    }
}

```

#### Subclass (Pembina.java)
```java

public class Pembina extends AnggotaPramuka implements InfoPramuka{
    private String hakBina;

    public Pembina(int idAnggota, String namaAnggota, String jenisKelamin, int kodeGugusDepan, int idKwarran, String hakBina){
        super(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran);
        this.hakBina = hakBina;
    }
}

```

## Penerapan Polymorphism & Abstraction
Abstraksi terlihat pada kelas AnggotaPramuka.java yang dideklarasikan sebagai kelas abstrak beserta metode abstrak tampilkanData(), yang memaksa setiap kelas turunannya untuk mengimplementasikan detail spesifik. Polimorfisme diterapkan melalui overloading dan overriding.

### Polymorphism
#### Overloading

```java

public abstract class AnggotaPramuka{
    // ...
    public abstract void tampilkanData();

    public void tampilkanData(String idNama){
        System.out.println(namaAnggota + " (" + idAnggota + ")" );
        tampilkanData();
    }
}

```

#### Overriding

```java

public class Siswa extends AnggotaPramuka implements InfoPramuka{
    private String tingkatPramuka;
    
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

```

### Abstraction
Abstraksi menyembunyikan detail implementasi kompleks menggunakan kelas abstrak dan metode tanpa tubuh (body):

```java

public abstract class AnggotaPramuka{

    // Metode abstrak yang memaksa subclass untuk mengisinya
    public abstract void tampilkanData();  
}

```

## Penerapan Interface
Konsep Interface diterapkan melalui pembuatan antarmuka InfoPramuka.java di dalam package Model yang mendefinisikan metode abstrak dataAnggota(). Antarmuka ini diimplementasikan oleh kelas Siswa.java dan Pembina.java

```java

package Model;

public interface InfoPramuka {
    void dataAnggota();
}

```

## Penerapan JDBC dan DAO
Penerapan koneksi database dan pola arsitektur akses data pada project DataPramuka diimplementasikan melalui komponen-komponen berikut:


### Manajemen Koneksi (Koneksi.java & TesKoneksi.java)
Kelas Koneksi berfungsi sebagai pusat pengelola koneksi JDBC ke database MySQL (db_pramuka) menggunakan DriverManager.getConnection() dengan konfigurasi URL, user root, dan password kosong, serta dilengkapi fungsi pengecekan apakah koneksi masih terbuka atau bernilai null. Sementara itu, kelas TesKoneksi digunakan sebagai utilitas untuk menguji secara langsung apakah koneksi ke database berhasil terjalin.


### Arsitektur DAO (Data Access Object)
Logika akses database dipisahkan secara bersih dari Controller dan View melalui kelas-kelas DAO terpisah, yaitu AnggotaDAO, GudepDAO, dan KwarranDAO. Setiap kelas DAO menginisialisasi objek koneksi dari Koneksi.getConnection() untuk melakukan operasi CRUD.


### Keamanan Query Menggunakan PreparedStatement
Seluruh operasi manipulasi data (seperti INSERT, UPDATE, dan DELETE) di dalam kelas DAO memanfaatkan PreparedStatement untuk mengisi parameter kueri secara aman guna mencegah celah keamanan SQL Injection.


### Polimorfisme Tabel Database di AnggotaDAO
Kelas AnggotaDAO membaca seluruh data dari tabel anggota_pramuka dan melakukan penanganan nilai NULL (null-handling) pada kolom tingkat_pramuka dan hak_bina. Jika kolom tingkat_pramuka terisi, data dipetakan sebagai objek Siswa, sedangkan jika kolom hak_bina terisi, data dipetakan sebagai objek Pembina secara dinamis.




















