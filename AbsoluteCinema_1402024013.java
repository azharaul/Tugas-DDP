/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */
import java.util.Scanner;
public class AbsoluteCinema_1402024013{
    public static void main(String[] args){
        byte menu = 0;
        String[] arrFilm =  {"5 cm", "Your Name", "Twenty Five Twenty One", "La La Land"};
        int[] arrAvailableSit = {50, 50, 50, 50};
        printTheMainTitle("Azhar Aulia Priatna", "1402024013");
        Scanner userInput = new Scanner(System.in);
        String username, password;
        System.out.println("\n=== Login ===");
        System.out.print("Masukan username: ");
        String InputUsername = userInput.next();
        System.out.print("Masukan password: ");
        String inputPassword = userInput.next();
        if(InputUsername.equals("admin") && inputPassword.equals("admin")){
            String[] arrAdminMenu = {"Lihat Daftar Film", "Tambah Film", "Edit Film", "Hapus Film"};
            do { 
                printTheAdminMenu(arrAdminMenu);
                menu = userInput.nextByte();
                if(menu == 1){
                    printTheFilmList(arrFilm, arrAvailableSit);
                }else if(menu == 2){
                    System.out.print("Masukan nama film baru: ");
                    String newFilm = new Scanner(System.in).nextLine();
                    String[] arrFilmTemp = arrFilm;
                    int[] arrAvailableSitTemp = arrAvailableSit;
                    arrFilm = new String[arrFilm.length + 1];
                    arrAvailableSit = new int[arrAvailableSit.length + 1];
                    for(int i = 0 ; i < arrFilmTemp.length ; i++){
                        arrFilm[i] = arrFilmTemp[i];
                        arrAvailableSit[i] = arrAvailableSitTemp[i];
                    }
                    for(int i = 0 ; i < arrFilm.length ; i++){
                        if(arrFilm[i] == null){
                            arrFilm[i] = newFilm;
                            arrAvailableSit[i] = 50;
                        }
                    }
                    System.out.println("Film " + newFilm + " berhasil ditambahkan.");
                }
            } while (menu == 1 || menu == 2);
        }
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
    public static void printTheFilmList(String[] arrFilm, int[] arrAvailableSit){
        System.out.println("\n=== Daftar Film ===");
            for(int i = 0 ; i < arrFilm.length ; i++){
                String filmName = arrFilm[i];
                int availableSit = arrAvailableSit[i];
                int no = i+1;
                System.out.println(no + ". " + filmName + " (Kursi tersedia: " + availableSit + ")");
                
            }
    }
}