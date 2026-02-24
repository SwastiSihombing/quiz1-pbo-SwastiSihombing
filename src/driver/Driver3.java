import java.util.*;
public class Driver3 {

    static class Laundry {

        int id;
        String nama;
        String asrama;
        String jenisPakaian;
        String ciri;
        int jumlah;
        boolean luntur;
        String pesan;
        String status;
        boolean acc;

        Laundry(int id, String nama, String asrama,
                String jenisPakaian, String ciri,
                int jumlah, boolean luntur, String pesan){

            this.id = id;
            this.nama = nama;
            this.asrama = asrama;
            this.jenisPakaian = jenisPakaian;
            this.ciri = ciri;
            this.jumlah = jumlah;
            this.luntur = luntur;
            this.pesan = pesan;
            this.status = "Diterima";
            this.acc = false;
        }

        void display(){
            System.out.println("ID: " + id);
            System.out.println("Nama: " + nama);
            System.out.println("Asrama: " + asrama);
            System.out.println("Jenis: " + jenisPakaian);
            System.out.println("Ciri: " + ciri);
            System.out.println("Jumlah: " + jumlah);
            System.out.println("Luntur: " + (luntur ? "YA" : "TIDAK"));
            System.out.println("Pesan: " + pesan);
            System.out.println("Status: " + status);
            System.out.println("ACC: " + (acc ? "Sudah" : "Belum"));
            System.out.println("----------------------------");
        }
    }

    static class Feedback {

        int idLaundry;
        String keluhan;

        Feedback(int idLaundry, String keluhan){
            this.idLaundry = idLaundry;
            this.keluhan = keluhan;
        }

        void display(){
            System.out.println("ID Laundry: " + idLaundry);
            System.out.println("Feedback: " + keluhan);
            System.out.println("-----------------------");
        }
    }

    static ArrayList<Laundry> listLaundry = new ArrayList<>();
    static ArrayList<Feedback> listFeedback = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    static void tambahLaundry(){

        System.out.print("ID: ");
        int id = input.nextInt(); input.nextLine();

        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Asrama: ");
        String asrama = input.nextLine();

        System.out.print("Jenis Pakaian: ");
        String jenis = input.nextLine();

        System.out.print("Ciri-ciri: ");
        String ciri = input.nextLine();

        System.out.print("Jumlah: ");
        int jumlah = input.nextInt();

        System.out.print("Apakah Luntur? (true/false): ");
        boolean luntur = input.nextBoolean(); input.nextLine();

        System.out.print("Pesan: ");
        String pesan = input.nextLine();

        Laundry l = new Laundry(id,nama,asrama,jenis,ciri,jumlah,luntur,pesan);
        listLaundry.add(l);

        if(luntur){
            System.out.println("!! PERINGATAN: HARUS DICUCI TERPISAH !!");
        }
    }

    static void lihatLaundry(){
        for(Laundry l : listLaundry){
            l.display();
        }
    }

    static void accLaundry(){
        System.out.print("Masukkan ID Laundry: ");
        int id = input.nextInt();

        for(Laundry l : listLaundry){
            if(l.id == id){
                l.acc = true;
                l.status = "Selesai";
                System.out.println("Laundry diterima mahasiswa!");
                bukaFeedback(id);
            }
        }
    }

    static void bukaFeedback(int id){
        input.nextLine();
        System.out.println("Forum Feedback Terbuka!");
        System.out.print("Masukkan Keluhan: ");
        String keluhan = input.nextLine();

        Feedback f = new Feedback(id,keluhan);
        listFeedback.add(f);
    }

    static void lihatFeedback(){
        for(Feedback f : listFeedback){
            f.display();
        }
    }

    public static void main(String[] args){

        int pilih;

        do{
            System.out.println("\n=== SISTEM LAUNDRY DEL ===");
            System.out.println("1. Input Laundry (Teknisi)");
            System.out.println("2. Lihat Laundry");
            System.out.println("3. ACC Laundry (Mahasiswa)");
            System.out.println("4. Lihat Feedback");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = input.nextInt();

            switch(pilih){
                case 1: tambahLaundry(); break;
                case 2: lihatLaundry(); break;
                case 3: accLaundry(); break;
                case 4: lihatFeedback(); break;
            }

        }while(pilih != 0);
    }
}

