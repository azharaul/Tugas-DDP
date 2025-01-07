/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */
import java.util.Scanner;
public class AbsoluteCinema_1402024013{
    public static void temp(){
        byte menu = 0;
        boolean isLogout = false;
        String newFilm;
        String[] arrFilm =  {"5 cm", "Your Name", "Twenty Five Twenty One", "La La Land"};
        String[] arrGuest = new String[5];
        String[][] arrSitNumber = {
            {"01","02","03","04","05","06","07","08","09","10"},
            {"11","12","13","14","15","16","17","18","19","20"},
            {"21","22","23","24","25","26","27","28","29","30"},
            {"31","32","33","34","35","36","37","38","39","40"},
            {"41","42","43","44","45","46","47","48","49","50"},
        };
        int[] arrAvailableSit = {50, 50, 50, 50};
        printTheMainTitle("Azhar Aulia Priatna", "1402024013");
        Scanner userInput = new Scanner(System.in);
        // String username, password;
        do { 
            System.out.println("\n=== Login ===");
            System.out.print("Masukan username: ");
            String InputUsername = userInput.next();
            if(InputUsername.equals("admin")){
                System.out.print("Masukan password: ");
                String inputPassword = userInput.next();
                if(inputPassword.equals("admin")){
                    String[] arrAdminMenu = {"Lihat Daftar Film", "Tambah Film", "Edit Film", "Hapus Film"};
                do { 
                    printTheAdminMenu(arrAdminMenu);
                    menu = userInput.nextByte();

                    //daftar menu
                    if(menu == 1){
                        printTheFilmList(arrFilm, arrAvailableSit);
                        }else if(menu == 2){
                            System.out.print("Masukan nama film baru: ");
                            newFilm = new Scanner(System.in).nextLine();

                            //cek apakah indexnya penuh
                            boolean isFull = true;
                            for(int i = 0 ; i < arrFilm.length ; i++){
                                if(arrFilm[i] == null){
                                    isFull = false;
                                    break;
                                }
                            }

                            //jika penuh maka ukuran arraynya di resize
                            if(isFull){
                                String[] arrFilmTemp = arrFilm;
                                int[] arrAvailableSitTemp = arrAvailableSit;
                                arrFilm = new String[arrFilm.length + 1];
                                arrAvailableSit = new int[arrAvailableSit.length + 1];
                                for(int i = 0 ; i < arrFilmTemp.length ; i++){
                                    arrFilm[i] = arrFilmTemp[i];
                                    arrAvailableSit[i] = arrAvailableSitTemp[i];
                                }
                            }

                            //tambahkan ke posisi yang data array nya null
                            for(int i = 0 ; i < arrFilm.length ; i++){
                                if(arrFilm[i] == null){
                                    arrFilm[i] = newFilm;
                                    arrAvailableSit[i] = 50;
                                }
                            }
                            System.out.println("Film " + newFilm + " berhasil ditambahkan.");
                            isLogout = false;

                        //tambah film
                        }else if(menu == 3){
                            printTheFilmList(arrFilm, arrAvailableSit);
                            System.out.print("Pilih nomor yang ingin diedit: ");
                            byte number = userInput.nextByte();
                            System.out.print("Masukan nama baru untuk film: ");
                            newFilm = new Scanner(System.in).nextLine();
                            arrFilm[number - 1] = newFilm;
                            System.out.println("Film berhasil diperbarui.");
                            isLogout = false;

                        //hapus film
                        }else if(menu == 4){
                            printTheFilmList(arrFilm, arrAvailableSit);
                            System.out.print("Pilih nomor film yang ingin dihapus: ");
                            byte number = userInput.nextByte();
                            boolean success = true;
                            if(number - 1 >= arrFilm.length){
                                success = false;
                            }else if(arrFilm[number-1] == null){
                                success = false;
                            }else{

                                for(int i = (number - 1) ; i < arrFilm.length ; i++){
                                    if(i == (arrFilm.length - 1)){
                                        arrFilm[i] = null;
                                        arrAvailableSit[i] = 0;
                                    }else{
                                        arrFilm[i] = arrFilm[i + 1];
                                        arrAvailableSit[i] = arrAvailableSit[i + 1];
                                    }
                                }

                            }
                            
                            if(!success){
                                System.out.println("Film gagal dihapus.");
                            }else{
                                System.out.println("Film berhasil dihapus.");
                            }
                            isLogout = false;
                        }else if(menu == 0){
                            isLogout = true;
                            System.out.println("Anda telah logout.");
                        }
                    } while (menu == 1 || menu == 2 || menu == 3 || menu == 4);
                }else{
                    System.out.println("Password salah.");
                    isLogout = true;
                }
                
            // }else if(InputUsername.equals("admin") && (!inputPassword.equals("admin"))){
            }else{
                //cek apakah slot guestnya sudah penuh
                boolean isFull = true;
                for(int i = 0 ; i < arrGuest.length ; i++){
                    if(arrGuest[i] == null){
                        isFull = false;
                        break;
                    }
                }
                //tambahkan ke posisi yang data array nya null
                for(int i = 0 ; i < arrGuest.length ; i++){
                    if(arrGuest[i] == null){
                        arrGuest[i] = InputUsername;
                        break;
                    }
                }
                // boolean isValid = false;
                // for(int i = 0 ; i < arrGuest.length ; i++){
                //     if(InputUsername.equals(arrGuest[i])){
                //         isValid = true;
                //         break;
                //     }else If(!isFull){

                //     }
                // }
                if(!isFull){
                    String[] arrGuestmenu = {"Lihat Daftar Film", "Pesan Kursi"};
                    do { 
                        printTheGuestmenu(arrGuestmenu);
                        menu = userInput.nextByte();
                        if(menu == 1){
                            printTheFilmList(arrFilm, arrAvailableSit);
                        }else if(menu == 2){
                            printTheFilmList(arrFilm, arrAvailableSit);
                            System.out.print("Pilih nomor film: ");
                            byte filmNumber = userInput.nextByte();
                            
                            printTheSitView(arrSitNumber);
                            System.out.print("Pilih nomor kursi: ");
                            byte sitNumber = userInput.nextByte();
                        }else if(menu == 0){
                            isLogout = true;
                            System.out.println("Anda telah logout.");
                        }
                    } while (menu == 1 || menu == 2);
                }else{
                    System.out.println("slot sudah penuh.");
                }
            }
        } while (isLogout);
    }

    
    public static void main(String[] args){
        temp();
    }




    public static void printTheMainTitle(String name, String npm){
        System.out.println("=====================================================");
        System.out.println("---------------Program Absolute Cinema---------------");
        System.out.println("-------------" + name + "/" + npm + "----------");
        System.out.println("=====================================================");
    }
    public static void printTheAdminMenu(String[] arrAdminMenu){
        System.out.println("\n=== Menu Admin ===");
        for(int i = 0 ; i < arrAdminMenu.length ; i++){
            String adminMenu = arrAdminMenu[i];
            int no = i+1;
            System.out.println(no + ". " + adminMenu);
        }
        System.out.print("0. Logout\nPilih menu: ");
    }
    public static void printTheGuestmenu(String[] arrGuestMenu){
        System.out.println("\n=== Menu Guest ===");
        for(int i = 0 ; i < arrGuestMenu.length ; i++){
            String guestMenu = arrGuestMenu[i];
            int no = i+1;
            System.out.println(no + ". " + guestMenu); 
        }
        System.out.print("0. Logout\nPilih menu: ");
    }
    public static void printTheFilmList(String[] arrFilm, int[] arrAvailableSit){
        System.out.println("\n=== Daftar Film ===");
            for(int i = 0 ; i < arrFilm.length ; i++){
                String filmName = arrFilm[i];
                int availableSit = arrAvailableSit[i];
                int no = i+1;
                if(arrFilm[i] != null && availableSit != 0){
                    System.out.println(no + ". " + filmName + " (Kursi tersedia: " + availableSit + ")");
                }
            }
    }
    public static void printTheSitView(String[][] arrSitNumber){
        System.out.println("Kursi tersedia: ");
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                System.out.print(arrSitNumber[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}