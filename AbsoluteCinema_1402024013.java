/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */
import java.util.Scanner;
public class AbsoluteCinema_1402024013 {
    public static void main(String[] args) {
        //alasan penggunaan tipe data byte karena nilainya hanya akan berada dibawah 5
        byte menu = 0, guestCount = 0;//var byte menu digunakan untuk menyimpan data menu yang dipilih user, guestCount untuk menghitung total guest yang sudah terdaftar
        boolean isLogout = false;//var untuk mengecek apakah user memilih logout atau tidak, jika ya maka nilainya berubah menjadi true
        String newFilm;//var untuk menyimpan data film yang baru ditambahkan
        // Array of String yang masing masing diberi 5 element, agar jika sudah lebih dari 5 data tidak akan bisa ditambah
        String[] arrGuest = new String[5];//digunakan untuk menyimpan data guest yang sudah terdaftar
        String[] arrFilm = new String[5];//digunakan untuk meyimpan data film
        //film yang akan muncul secara default
        arrFilm[0] = "5 cm";
        arrFilm[1] = "Your Name";
        arrFilm[2] = "Twenty Five Twenty One";
        arrFilm[3] = "La La Land";
        int[] arrAvailableSit = new int[5];//digunakan untuk meyimpan data kursi tersedia untuk masing-masing film
        arrAvailableSit[0] = 50;
        arrAvailableSit[1] = 50;
        arrAvailableSit[2] = 50;
        arrAvailableSit[3] = 50;
        boolean[][] arrSitNumber = new boolean[100][50];//digunakan untuk menyimpan data kursi yang sudah dipesan, jika ada kursi yang sudah dipesan, maka nilainya akan menjadi true di index tertentu, tergantung dengan film yang dipilih
        Scanner userInput = new Scanner(System.in);//var untuk membuat program dapat menerima inputan dari user
        
        printTheMainTitle("Azhar Aulia Priatna", "1402024013");//method untuk print judul
        do {
            //pengecekan berapa banyak film yang ada di dalam arrFilm
            int manyFilm = 0;
                        for(int i = 0 ; i < arrFilm.length ; i++){
                            if(arrFilm[i] != null){
                                manyFilm++;
                            }
                        }

            System.out.println("\n=== Login ===");
            System.out.print("Masukan username: ");
            String InputUsername = userInput.next();
            if (InputUsername.equals("admin")) {//jika username admin maka akan diminta untuk masukan password
                System.out.print("Masukan password: ");
                String inputPassword = userInput.next();
                if (inputPassword.equals("admin")) {
                    System.out.println("Selamat datang kembali, " + InputUsername + "!");
                    String[] arrAdminMenu = {"Lihat Daftar Film", "Tambah Film", "Edit Film", "Hapus Film"};
                    do {
                        //pengecekan untuk menghitung banyaknya film
                        manyFilm = 0;
                        for(int i = 0 ; i < arrFilm.length ; i++){
                            if(arrFilm[i] != null){
                                manyFilm++;
                            }
                        }
                        printTheAdminMenu(arrAdminMenu);//method untuk memanggil menu admin
                        menu = userInput.nextByte();//var yang nilainya berdasarkan inputan dari user
                        
                        //daftar menu
                        if (menu == 1) {
                            printTheFilmList(arrFilm, arrAvailableSit);//method untuk memanggil list film yang tersedia
                        
                        //tambah film
                        } else if (menu == 2) {
                            //cek apakah slot film full atau tidak
                            boolean isFull = true;
                            for (int i = 0; i < arrFilm.length; i++) {
                                if (arrFilm[i] == null) {
                                    isFull = false;//jika tidak maka var isFull nilainya diubah menjadi false
                                    break;
                                }
                            }
                            if(isFull){
                                System.out.println("Maksimal film telah tercapai. Tidak bisa menambahkan film baru.");
                            }else{
                                System.out.print("Masukan nama film baru: ");
                                newFilm = new Scanner(System.in).nextLine();
                                //memasukan nama film baru ke array yang datanya null, dan memberikan data kursi tersedia yang defaultnya 50
                                for (int i = 0; i < arrFilm.length; i++) {
                                    if (arrFilm[i] == null) {
                                        arrFilm[i] = newFilm;
                                        arrAvailableSit[i] = 50;
                                    }
                                }
                                System.out.println("Film " + newFilm + " berhasil ditambahkan.");
                            }
                            isLogout = false;

                        //edit film
                        } else if (menu == 3) {
                            printTheFilmList(arrFilm, arrAvailableSit);
                            System.out.print("Pilih nomor film yang ingin diedit: ");
                            byte filmNumber = userInput.nextByte();
                            if(filmNumber >= 0 && filmNumber <= manyFilm){
                                System.out.print("Masukan nama baru untuk film: ");
                                newFilm = new Scanner(System.in).nextLine();
                                arrFilm[filmNumber - 1] = newFilm;//memberikan nama film baru pada arrFilm
                                System.out.println("Film berhasil diperbarui.");
                                isLogout = false;
                            }else{
                                System.out.println("Nomor film tidak valid.");
                                isLogout = true;
                            }

                            //hapus film
                        } else if (menu == 4) {
                            printTheFilmList(arrFilm, arrAvailableSit);
                            System.out.print("Pilih nomor film yang ingin dihapus: ");
                            byte filmNumber = userInput.nextByte();
                            if(filmNumber >= 0 && filmNumber <= manyFilm){
                                boolean success = true;
                                if (filmNumber - 1 >= arrFilm.length) {
                                    success = false;
                                } else if (arrFilm[filmNumber - 1] == null) {
                                    success = false;
                                } else {
                                    for (int i = (filmNumber - 1); i < arrFilm.length; i++) {
                                        if (i == (arrFilm.length - 1)) {
                                            //menghapus data film
                                            arrFilm[i] = null;
                                            arrAvailableSit[i] = 0;
                                        } else {
                                            //memundurkan element agar data film yang tadinya dihapus tidak terhitung
                                            arrFilm[i] = arrFilm[i + 1];
                                            arrAvailableSit[i] = arrAvailableSit[i + 1];
                                        }
                                    }
                                }
                                if (!success) {
                                    System.out.println("Film gagal dihapus.");
                                } else {
                                    System.out.println("Film berhasil dihapus.");
                                }
                                isLogout = false;
                            }else{
                                System.out.println("Nomor film tidak valid.");
                            }
                        } else if (menu == 0) {
                            isLogout = true;
                            System.out.println("Anda telah logout.");
                        }
                    } while (menu == 1 || menu == 2 || menu == 3 || menu == 4);
                } else {
                    System.out.println("Password salah.");
                    isLogout = true;
                }

            } else {
                //cek apakah username sudah terdaftar
                boolean isUserExists = false;
                for (int i = 0; i < guestCount; i++) {
                    if (arrGuest[i].equals(InputUsername)) {
                        isUserExists = true;
                    }
                }

                if (isUserExists) {
                    System.out.println("Selamat datang kembali, " + InputUsername + "!");
                    String[] arrGuestmenu = {"Lihat Daftar Film", "Pesan Kursi"};
                    do {
                        printTheGuestmenu(arrGuestmenu);
                        menu = userInput.nextByte();
                        if (menu == 1) {
                            printTheFilmList(arrFilm, arrAvailableSit);
                        } else if (menu == 2) {
                            printTheFilmList(arrFilm, arrAvailableSit);
                            System.out.print("Pilih nomor film: ");
                            byte filmNumber = userInput.nextByte();
                            if(filmNumber >= 0 && filmNumber <= manyFilm){
                                System.out.println("Kursi tersedia: ");
                                printTheAvailabelSit(arrSitNumber, filmNumber);
                                boolean isBooked = false;
                                while (!isBooked) {//selama isBooked nya false maka akan code yang ada di scope akan diulang
                                    System.out.print("Pilih nomor kursi: ");
                                    int sitNumber = userInput.nextInt();
                                    if (sitNumber < 1 || sitNumber > 50) {
                                        System.out.println("Nomor kursi tidak valid. Silakan pilih kursi antara 1 dan 50.");
                                    } else if (arrSitNumber[filmNumber][sitNumber - 1]) {
                                        System.out.println("Kursi sudah dipesan, silakan pilih kursi lain.");
                                    } else {
                                        arrSitNumber[filmNumber][sitNumber - 1] = true;//memberikan nilai pada arrSitNumber menjadi true karena sudah dipesan
                                        System.out.println("Kursi nomor " + sitNumber + " berhasil dipesan.");
                                        isBooked = true;//agar perulangan berhenti
                                    }
                                }
                            }else{
                                System.out.println("Nomor film tidak valid.");
                            }
                        } else if (menu == 0) {
                            isLogout = true;
                            System.out.println("Anda telah logout.");
                        }
                    } while (menu == 1 || menu == 2);
                } else {
                    if (guestCount < 4) {
                        arrGuest[guestCount] = InputUsername;//mengisi data akun yang sudah terdaftar
                        guestCount++;//jika masih kurang dari 4 maka var ini akan bertambah nilainya
                        System.out.println(InputUsername + " berhasil didaftarkan.");
                        System.out.println("Selamat datang, " + InputUsername + "!");
                        String[] arrGuestmenu = {"Lihat Daftar Film", "Pesan Kursi"};
                        do {
                            printTheGuestmenu(arrGuestmenu);
                            menu = userInput.nextByte();
                            if (menu == 1) {
                                printTheFilmList(arrFilm, arrAvailableSit);
                            } else if (menu == 2) {
                                printTheFilmList(arrFilm, arrAvailableSit);
                                System.out.print("Pilih nomor film: ");
                                byte filmNumber = userInput.nextByte();
                                if(filmNumber >= 0 && filmNumber <= manyFilm){
                                    System.out.println("Kursi tersedia: ");
                                    printTheAvailabelSit(arrSitNumber, filmNumber);
                                    boolean isBooked = false;
                                    while (!isBooked) {
                                        System.out.print("Pilih nomor kursi: ");
                                        int sitNumber = userInput.nextInt();
                                        if (sitNumber < 1 || sitNumber > 50) {
                                            System.out.println("Nomor kursi tidak valid. Silakan pilih kursi antara 1 dan 50.");
                                        } else if (arrSitNumber[filmNumber][sitNumber - 1]) {
                                            System.out.println("Kursi sudah dipesan, silakan pilih kursi lain.");
                                        } else {
                                            arrAvailableSit[filmNumber-1]-=1;
                                            arrSitNumber[filmNumber][sitNumber - 1] = true;
                                            System.out.println("Kursi nomor " + sitNumber + " berhasil dipesan.");
                                            isBooked = true;
                                        }
                                    }
                                }else{
                                    System.out.println("Nomor film tidak valid.");
                                }
                            } else if (menu == 0) {
                                isLogout = true;//jika memilih menu 0 maka var isLogout menjadi true dan program akan terulang dari meminta username
                                System.out.println("Anda telah logout.");
                            }
                        } while (menu == 1 || menu == 2);
                    } else {
                        System.out.println("Maksimal pengguna telah tercapai. Tidak bisa menambahkan pengguna baru.");
                    }
                }
            }
        } while (isLogout);
    }
    
    public static void printTheMainTitle(String name, String npm) {
        System.out.println("=====================================================");
        System.out.println("---------------Program Absolute Cinema---------------");
        System.out.println("-------------" + name + "/" + npm + "----------");
        System.out.println("=====================================================");
    }
    public static void printTheAdminMenu(String[] arrAdminMenu) {
        System.out.println("\n=== Menu Admin ===");
        for (int i = 0; i < arrAdminMenu.length; i++) {
            String adminMenu = arrAdminMenu[i];
            int no = i + 1;
            System.out.println(no + ". " + adminMenu);
        }
        System.out.print("0. Logout\nPilih menu: ");
    }
    public static void printTheGuestmenu(String[] arrGuestMenu) {
        System.out.println("\n=== Menu Guest ===");
        for (int i = 0; i < arrGuestMenu.length; i++) {
            String guestMenu = arrGuestMenu[i];
            int no = i + 1;
            System.out.println(no + ". " + guestMenu);
        }
        System.out.print("0. Logout\nPilih menu: ");
    }
    public static void printTheFilmList(String[] arrFilm, int[] arrAvailableSit) {
        System.out.println("\n=== Daftar Film ===");
        for (int i = 0; i < arrFilm.length; i++) {
            String filmName = arrFilm[i];
            int availableSit = arrAvailableSit[i];
            int no = i + 1;
            if (arrFilm[i] != null && availableSit != 0) {
                System.out.println(no + ". " + filmName + " (Kursi tersedia: " + availableSit + ")");
            }
        }
    }
    public static void printTheAvailabelSit(boolean[][] arrSitNumber, byte filmNumber){
        for (int i = 1; i <= 50; i++) {
                if (!arrSitNumber[filmNumber][i - 1]) {
                    System.out.print(i < 10 ? "0" + i + " " : i + " ");
                } else {
                    System.out.print("XX ");
                }
                if (i % 10 == 0) {
                    System.out.println();
                }
            }
    }
}
