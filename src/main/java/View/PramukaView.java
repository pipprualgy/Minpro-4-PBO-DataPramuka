package View;

import Controller.PramukaController;
import Model.AnggotaPramuka;
import Model.Siswa;
import Model.Pembina;
import Model.InfoPramuka;
import java.util.Scanner;

public class PramukaView {
    private final Scanner input = new Scanner(System.in);
    private final PramukaController controller;
    
    public PramukaView(PramukaController controller) {
        this.controller = controller; 
    }
    
    public void mulai(){
        int pilihan = 0;
        do{
            System.out.println("=== MENU KEANGGOTAAN PRAMUKA ===");
            System.out.println("1. Gugus Depan");
            System.out.println("2. Kwartir Ranting");
            System.out.println("3. Anggota Pramuka");
            System.out.println("4. Keluar Program");
            System.out.print("Masukkan Pilihan Menu (1-4): ");
            
            if (input.hasNextInt()){
                pilihan = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("[PERINGATAN] Input harus berupa angka!");
                input.nextLine();
                continue;
            }
            
            switch (pilihan) {
                case 1: menuGudep(); break;
                case 2: menuKwarran(); break;
                case 3: menuAnggota(); break;
                case 4: System.out.println("Program Selesai. Terima kasih."); break;
                default: System.out.println("[PERINGATAN] Pilihan menu tidak valid!");
            }
        } while (pilihan != 4);
    }
    
    private void menuGudep(){
        int pilihanGudep = 0;
        do {
            System.out.println("=== MANAJEMEN GUGUS DEPAN ===");
            System.out.println("1. Tambah Gugus Depan");
            System.out.println("2. Lihat Gugus Depan");
            System.out.println("3. Update Gugus Depan");
            System.out.println("4. Hapus Gugus Depan");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih Menu Gugus Depan: ");
            
            if (input.hasNextInt()) {
                pilihanGudep = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Input harus berupa angka");
                input.nextLine();
                continue;
            }
            
            switch (pilihanGudep) {
                case 1:
                    int kodeGugusDepan = 0;
                    while (true) {
                        System.out.print("Masukkan Kode Gugus Depan: ");
                        if (input.hasNextInt()) {
                            kodeGugusDepan = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("Kode harus berupa angka");
                            input.nextLine();
                        }
                    }
                    System.out.print("Masukkan Nama Gugus Depan: ");
                    String namaGugusDepan = input.nextLine();
                    System.out.print("Masukkan Pangkalan: ");
                    String pangkalan = input.nextLine();
                    
                    controller.tambahGudep(kodeGugusDepan, namaGugusDepan, pangkalan);
                    System.out.println("Data Gugus Depan Berhasil Ditambahkan");
                    break;
                    
                case 2:
                    if (controller.getGugusDepanList().isEmpty()) {
                        System.out.println("Belum ada data Gugus Depan");
                    } else {
                        for (int i = 0; i < controller.getGugusDepanList().size(); i++) {
                            System.out.println("\nData ke-" + (i + 1));
                            controller.getGugusDepanList().get(i).tampilkanData();
                        }
                    }
                    break;
                    
                case 3:
                    if (controller.getGugusDepanList().isEmpty()) {
                        System.out.println("Belum ada data Gugus Depan");
                        break;
                    }
                    int kodeLama = 0;
                    while (true) {
                        System.out.print("Masukkan Kode Gugus Depan yang Akan Diubah: ");
                        if (input.hasNextInt()) {
                            kodeLama = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("Kode harus berupa angka");
                            input.nextLine();
                        }
                    }
                    
                    int kodeBaru = 0;
                    while (true) {
                        System.out.print("Masukkan Kode Gugus Depan Baru: ");
                        if (input.hasNextInt()) {
                            kodeBaru = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("Kode harus berupa angka");
                            input.nextLine();
                        }
                    }
                    
                    System.out.print("Masukkan Nama Gugus Depan Baru: ");
                    String namaGugusDepanBaru = input.nextLine();
                    System.out.print("Masukkan Pangkalan Baru: ");
                    String pangkalanBaru = input.nextLine();
                    
                    boolean statusUpdateGudep = controller.updateGudep(kodeLama, kodeBaru, namaGugusDepanBaru, pangkalanBaru);
                    if (statusUpdateGudep) {
                        System.out.println("Data Gugus Depan Berhasil Diubah");
                    } else {
                        System.out.println("Kode Gugus Depan tidak ditemukan");
                    }
                    break;
                    
                case 4:
                    if (controller.getGugusDepanList().isEmpty()) {
                        System.out.println("Belum ada data Gugus Depan");
                        break;
                    }
                    int kodeTargetHapus = 0;
                    while (true) {
                        System.out.print("Masukkan Kode Gugus Depan yang Akan Dihapus: ");
                        if (input.hasNextInt()) {
                            kodeTargetHapus = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("Kode harus berupa angka");
                            input.nextLine();
                        }
                    }
                    
                    boolean statusHapusGudep = controller.hapusGudep(kodeTargetHapus);
                    if (statusHapusGudep) {
                        System.out.println("Data Gugus Depan Berhasil Dihapus");
                    } else {
                        System.out.println("Kode Gugus Depan tidak ditemukan");
                    }
                    break;
                    
                case 5:
                    System.out.println("Kembali ke Menu Utama");
                    break;
                    
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        } while (pilihanGudep != 5);
    }
    
    private void menuKwarran(){
        int pilihanKwarran = 0;
        do {
            System.out.println("=== MANAJEMEN KWARTIR RANTING ===");
            System.out.println("1. Tambah Kwartir Ranting");
            System.out.println("2. Lihat Kwartir Ranting");
            System.out.println("3. Update Kwartir Ranting");
            System.out.println("4. Hapus Kwartir Ranting");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih Menu Kwartir Ranting: ");
            
            if (input.hasNextInt()) {
                pilihanKwarran = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Input harus berupa angka");
                input.nextLine();
                continue;
            }
            
            switch (pilihanKwarran) {
                case 1:
                    int idKwarran = 0;
                    while (true) {
                        System.out.print("Masukkan ID Kwartir Ranting: ");
                        if (input.hasNextInt()) {
                            idKwarran = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("ID harus berupa angka");
                            input.nextLine();
                        }
                    }
                    System.out.print("Masukkan Nama Kwartir Ranting: ");
                    String namaKwarran = input.nextLine();
                    
                    controller.tambahKwarran(idKwarran, namaKwarran);
                    System.out.println("Data Kwartir Ranting Berhasil Ditambahkan");
                    break;
                    
                case 2:
                    if (controller.getKwarranList().isEmpty()) {
                        System.out.println("Belum ada data Kwartir Ranting.");
                    } else {
                        for (int i = 0; i < controller.getKwarranList().size(); i++) {
                            System.out.println("\nData ke-" + (i + 1));
                            controller.getKwarranList().get(i).tampilkanData();
                        }
                    }
                    break;
                    
                case 3:
                    if (controller.getKwarranList().isEmpty()) {
                        System.out.println("Belum ada data Kwartir Ranting untuk di-update.");
                        break;
                    }
                    int idTargetUpdateKwarran = 0;
                    while (true) {
                        System.out.print("Masukkan ID Kwartir Ranting yang Akan Diubah: ");
                        if (input.hasNextInt()) {
                            idTargetUpdateKwarran = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("ID harus berupa angka");
                            input.nextLine();
                        }
                    }
                    
                    System.out.print("Masukkan Nama Kwartir Ranting Baru: ");
                    String namaKwarranBaru = input.nextLine();
                    
                    boolean statusUpdateKwarran = controller.updateKwarran(idTargetUpdateKwarran, namaKwarranBaru);
                    if (statusUpdateKwarran) {
                        System.out.println("Data Kwartir Ranting Berhasil Diubah");
                    } else {
                        System.out.println("ID Kwartir Ranting tidak ditemukan");
                    }
                    break;
                    
                case 4:
                    if (controller.getKwarranList().isEmpty()) {
                        System.out.println("Belum ada data Kwartir Ranting untuk dihapus.");
                        break;
                    }
                    int idTargetHapusKwarran = 0;
                    while (true) {
                        System.out.print("Masukkan ID Kwartir Ranting yang Akan Dihapus: ");
                        if (input.hasNextInt()) {
                            idTargetHapusKwarran = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("ID harus berupa angka!");
                            input.nextLine();
                        }
                    }
                    
                    boolean statusHapusKwarran = controller.hapusKwarran(idTargetHapusKwarran);
                    if (statusHapusKwarran) {
                        System.out.println("Data Kwartir Ranting Berhasil Dihapus");
                    } else {
                        System.out.println("ID Kwartir Ranting tidak ditemukan");
                    }
                    break;
                    
                case 5:
                    System.out.println("Kembali ke Menu Utama");
                    break;
                    
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        } while (pilihanKwarran != 5);
    }
    
    private void menuAnggota(){
        int pilihanAnggota = 0;
        do {
            System.out.println("=== MANAJEMEN ANGGOTA PRAMUKA ===");
            System.out.println("1. Tambah Anggota Pramuka");
            System.out.println("2. Lihat Anggota Pramuka");
            System.out.println("3. Update Anggota Pramuka");
            System.out.println("4. Hapus Anggota Pramuka");
            System.out.println("5. Kembali");
            System.out.print("Pilih Menu Anggota (1-5): ");
            
            if (input.hasNextInt()) {
                pilihanAnggota = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("[PERINGATAN] Input harus berupa angka!");
                input.nextLine();
                continue;
            }
            
            switch (pilihanAnggota) {
                case 1:
                    int jenisAnggota = 0;
                    while (true) {
                        System.out.println("Pilih Golongan Anggota:");
                        System.out.println("1. Siswa");
                        System.out.println("2. Pembina");
                        System.out.print("Masukkan Pilihan (1-2): ");
                        if (input.hasNextInt()) {
                            jenisAnggota = input.nextInt();
                            input.nextLine();
                            if (jenisAnggota == 1 || jenisAnggota == 2) {
                                break;
                            } else {
                                System.out.println("lihan hanya 1 atau 2!");
                            }
                        } else {
                            System.out.println("Input harus berupa angka!");
                            input.nextLine();
                        }
                    }
                    
                    int idAnggota = 0;
                    while (true) {
                        System.out.print("Masukkan ID Anggota (Angka): ");
                        if (input.hasNextInt()) {
                            idAnggota = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("[PERINGATAN] ID Anggota harus berupa angka!");
                            input.nextLine();
                        }
                    }
                    
                    System.out.print("Masukkan Nama Anggota: ");
                    String namaAnggota = input.nextLine();
                    System.out.print("Masukkan Jenis Kelamin: ");
                    String jenisKelamin = input.nextLine();
                    
                    int kodeGugusDepan = 0;
                    while (true) {
                        System.out.print("Masukkan Kode Gugus Depan (Angka): ");
                        if (input.hasNextInt()) {
                            kodeGugusDepan = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("[PERINGATAN] Kode Gugus Depan harus berupa angka!");
                            input.nextLine();
                        }
                    }
                    
                    int idKwarran = 0;
                    while (true) {
                        System.out.print("Masukkan ID Kwartir Ranting (Angka): ");
                        if (input.hasNextInt()) {
                            idKwarran = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("[PERINGATAN] ID Kwartir Ranting harus berupa angka!");
                            input.nextLine();
                        }
                    }
                    
                    if (jenisAnggota == 1) {
                        System.out.print("Masukkan Tingkat Pramuka Siswa: ");
                        String tingkatPramuka = input.nextLine();
                        controller.tambahSiswa(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, tingkatPramuka);
                    } else {
                        System.out.print("Masukkan Sertifikat Hak Bina Pembina: ");
                        String hakBina = input.nextLine();
                        controller.tambahPembina(idAnggota, namaAnggota, jenisKelamin, kodeGugusDepan, idKwarran, hakBina);
                    }
                    System.out.println("Anggota Pramuka Berhasil Ditambahkan");
                    break;
                    
                case 2:
                    if (controller.getAnggotaList().isEmpty()) {
                        System.out.println("Belum ada data Anggota Pramuka");
                    } else {
                        for (int i = 0; i < controller.getAnggotaList().size(); i++) {
                            System.out.println("\nData ke-" + (i + 1));
                            AnggotaPramuka anggotaPramukaObjek = controller.getAnggotaList().get(i);
                            anggotaPramukaObjek.tampilkanData();
                            ((InfoPramuka) anggotaPramukaObjek).dataAnggota();
                            System.out.println("----------------------------------------");
                        }
                        
                    }
                    break;
                    
                case 3:
                    if (controller.getAnggotaList().isEmpty()) {
                        System.out.println("Belum ada data Anggota Pramuka untuk di-update.");
                        break;
                    }
                    int idTargetUpdateAnggota = 0;
                    while (true) {
                        System.out.print("Masukkan ID Anggota yang Akan Diubah: ");
                        if (input.hasNextInt()) {
                            idTargetUpdateAnggota = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("[PERINGATAN] ID harus berupa angka!");
                            input.nextLine();
                        }
                    }
                    
                    AnggotaPramuka targetAnggota = null;
                    for (AnggotaPramuka anggotaPramuka: controller.getAnggotaList()) {
                        if (anggotaPramuka.getIdAnggota() == idTargetUpdateAnggota) {
                            targetAnggota = anggotaPramuka;
                            break;
                        }
                    }
                    
                    if (targetAnggota == null) {
                        System.out.println("ID Anggota tidak ditemukan");
                        break;
                    }
                    
                    System.out.print("Masukkan Nama Anggota Baru: ");
                    String namaAnggotaBaru = input.nextLine();
                    System.out.print("Masukkan Jenis Kelamin Baru: ");
                    String jenisKelaminBaru = input.nextLine();
                    
                    int kodeGugusDepanBaru = 0;
                    while (true) {
                        System.out.print("Masukkan Kode Gugus Depan Baru (Angka): ");
                        if (input.hasNextInt()) {
                            kodeGugusDepanBaru = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("Kode Gugus Depan harus berupa angka");
                            input.nextLine();
                        }
                    }
                    
                    int idKwarranBaru = 0;
                    while (true) {
                        System.out.print("Masukkan ID Kwartir Ranting Baru: ");
                        if (input.hasNextInt()) {
                            idKwarranBaru = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("ID Kwartir Ranting harus berupa angka");
                            input.nextLine();
                        }
                    }
                    
                    String atributKhususBaru = "";
                    if (targetAnggota instanceof Siswa) {
                        System.out.print("Masukkan Tingkat Pramuka Siswa Baru: ");
                        atributKhususBaru = input.nextLine();
                    } else if (targetAnggota instanceof Pembina) {
                        System.out.print("Masukkan Sertifikat Hak Bina: ");
                        atributKhususBaru = input.nextLine();
                    }
                    
                    controller.updateAnggota(idTargetUpdateAnggota, namaAnggotaBaru, jenisKelaminBaru, kodeGugusDepanBaru, idKwarranBaru, atributKhususBaru);
                    System.out.println("Data Anggota Pramuka Berhasil Diubah");
                    break;
                    
                case 4:
                    if (controller.getAnggotaList().isEmpty()) {
                        System.out.println("Belum ada data Anggota Pramuka untuk dihapus");
                        break;
                    }
                    int idTargetHapusAnggota = 0;
                    while (true) {
                        System.out.print("Masukkan ID Anggota yang Akan Dihapus: ");
                        if (input.hasNextInt()) {
                            idTargetHapusAnggota = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("ID harus berupa angka");
                            input.nextLine();
                        }
                    }
                    
                    boolean statusHapusAnggota = controller.hapusAnggota(idTargetHapusAnggota);
                    if (statusHapusAnggota) {
                        System.out.println("Data Anggota Pramuka Berhasil Dihapus");
                    } else {
                        System.out.println("ID Anggota tidak ditemukan");
                    }
                    break;
                    
                case 5:
                    System.out.println("Kembali ke Menu Utama");
                    break;
                    
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        } while (pilihanAnggota != 5);
    }
}