/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */
import java.util.Scanner;
public class AbsoluteCinema_1402024013{
    public static void main(String[] args){
        System.out.println("=====================================================");
        System.out.println("---------------Program Absolute Cinema---------------");
        System.out.println("-------------Azhar Aulia Priatna/1402024013----------");
        System.out.println("=====================================================");
        viewLogin();
        viewMenuAdmin();
    }

    public static void viewLogin(){
        Scanner userInput = new Scanner(System.in);
        String username, password;
        System.out.println("=== Login ===");
        System.out.print("Masukan username: ");
        username = userInput.next();
        System.out.print("Masukan password: ");
        password = userInput.next();
    }
    public static void viewMenuAdmin(){
        String[] arrMenuList = {"Lihat Daftar Film", "Tambah Film", "Edit Film", "Hapus Film"};
        for(String menuList : arrMenuList){
            int i = 1;
            System.out.println(i + menuList);
            i++;
        }
    }

}