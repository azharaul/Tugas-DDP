import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        byte menu = 0;
        int guestCount = 0;
        boolean isLogout = false;
        String newFilm;
        String[] arrGuest = new String[5];
        String[] arrFilm = new String[5];
        arrFilm[0] = "5 cm";
        arrFilm[1] = "Your Name";
        arrFilm[2] = "Twenty Five Twenty One";
        arrFilm[3] = "La La Land";
        int[] arrAvailableSit = new int[5];
        arrAvailableSit[0] = 50;
        arrAvailableSit[1] = 50;
        arrAvailableSit[2] = 50;
        arrAvailableSit[3] = 50;
        boolean[][] arrSitNumber = new boolean[100][50];
        printTheMainTitle("Azhar Aulia Priatna", "1402024013");
        Scanner userInput = new Scanner(System.in);
        
        do {
            System.out.println("\n=== Login ===");
            System.out.print("Masukan username: ");
            String inputUsername = userInput.next();
            
            if (inputUsername.equals("admin")) {
                System.out.print("Masukan password: ");
                String inputPassword = userInput.next();
                if (inputPassword.equals("admin")) {
                    System.out.println("Selamat datang kembali, " + inputUsername + "!");
                    handleAdminMenu(arrFilm, arrAvailableSit, arrSitNumber, userInput);
                } else {
                    System.out.println("Password salah.");
                }
            } else {
                checkUserExists(arrGuest, inputUsername, guestCount);
                if (isGuestRegistered(arrGuest, inputUsername, guestCount)) {
                    System.out.println("Selamat datang kembali, " + inputUsername + "!");
                    handleGuestMenu(arrFilm, arrAvailableSit, arrSitNumber, userInput);
                } else {
                    if (guestCount < arrGuest.length) {
                        arrGuest[guestCount] = inputUsername;
                        guestCount++;
                        System.out.println(inputUsername + " berhasil didaftarkan.");
                        System.out.println("Selamat datang, " + inputUsername + "!");
                        handleGuestMenu(arrFilm, arrAvailableSit, arrSitNumber, userInput);
                    } else {
                        System.out.println("Maksimal pengguna telah tercapai. Tidak bisa menambahkan pengguna baru.");
                    }
                }
            }
        } while (!isLogout);
    }

    public static void checkUserExists(String[] arrGuest, String username, int guestCount) {
        boolean userExists = false;
        for (int i = 0; i < guestCount; i++) {
            if (arrGuest[i].equals(username)) {
                userExists = true;
                break;
            }
        }
        if (userExists) {
            System.out.println("Pengguna " + username + " sudah terdaftar.");
        } else {
            System.out.println("Pengguna " + username + " belum terdaftar.");
        }
    }

    // public static boolean isGuestRegistered(String[] arrGuest, String username, int guestCount) {
    //     for (int i = 0; i < guestCount; i++) {
    //         if (arrGuest[i].equals(username)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public static void handleAdminMenu(String[] arrFilm, int[] arrAvailableSit, boolean[][] arrSitNumber, Scanner userInput) {
        String[] arrAdminMenu = {"Lihat Daftar Film", "Tambah Film", "Edit Film", "Hapus Film"};
        byte menu;
        do {
            printTheAdminMenu(arrAdminMenu);
            menu = userInput.nextByte();
            switch (menu) {
                case 1 -> printTheFilmList(arrFilm, arrAvailableSit);
                case 2 -> addNewFilm(arrFilm, arrAvailableSit, userInput);
                case 3 -> editFilm(arrFilm, arrAvailableSit, userInput);
                case 4 -> deleteFilm(arrFilm, arrAvailableSit, userInput);
                case 0 -> System.out.println("Anda telah logout.");
                default -> System.out.println("Menu tidak valid.");
            }
        } while (menu != 0);
    }

    public static void handleGuestMenu(String[] arrFilm, int[] arrAvailableSit, boolean[][] arrSitNumber, Scanner userInput) {
        String[] arrGuestMenu = {"Lihat Daftar Film", "Pesan Kursi"};
        byte menu;
        do {
            printTheGuestMenu(arrGuestMenu);
            menu = userInput.nextByte();
            switch (menu) {
                case 1 -> printTheFilmList(arrFilm, arrAvailableSit);
                case 2 -> bookSeat(arrFilm, arrAvailableSit, arrSitNumber, userInput);
                case 0 -> System.out.println("Anda telah logout.");
                default -> System.out.println("Menu tidak valid.");
            }
        } while (menu != 0);
    }

    public static void addNewFilm(String[] arrFilm, int[] arrAvailableSit, Scanner userInput) {
        boolean isFull = true;
        for (String film : arrFilm) {
            if (film == null) {
                isFull = false;
                break;
            }
        }
        if (isFull) {
            System.out.println("Maksimal film telah tercapai. Tidak bisa menambahkan film baru.");
        } else {
            System.out.print("Masukan nama film baru: ");
            String newFilm = new Scanner(System.in).nextLine();
            for (int i = 0; i < arrFilm.length; i++) {
                if (arrFilm[i] == null) {
                    arrFilm[i] = newFilm;
                    arrAvailableSit[i] = 50;
                    break;
                }
            }
            System.out.println("Film " + newFilm + " berhasil ditambahkan.");
        }
    }

    public static void editFilm(String[] arrFilm, int[] arrAvailableSit, Scanner userInput) {
        printTheFilmList(arrFilm, arrAvailableSit);
        System.out.print("Pilih nomor yang ingin diedit: ");
        byte number = userInput.nextByte();
        if (number >= 1 && number <= arrFilm.length && arrFilm[number - 1] != null) {
            System.out.print("Masukan nama baru untuk film: ");
            String newFilm = new Scanner(System.in).nextLine();
            arrFilm[number - 1] = newFilm;
            System.out.println("Film berhasil diperbarui.");
        } else {
            System.out.println("Nomor film tidak valid.");
        }
    }

    public static void deleteFilm(String[] arrFilm, int[] arrAvailableSit, Scanner userInput) {
        printTheFilmList(arrFilm, arrAvailableSit);
        System.out.print("Pilih nomor film yang ingin dihapus: ");
        byte number = userInput.nextByte();
        if (number >= 1 && number <= arrFilm.length && arrFilm[number - 1] != null) {
            for (int i = number - 1; i < arrFilm.length - 1; i++) {
                arrFilm[i] = arrFilm[i + 1];
                arrAvailableSit[i] = arrAvailableSit[i + 1];
            }
            arrFilm[arrFilm.length - 1] = null;
            arrAvailableSit[arrAvailableSit.length - 1] = 0;
            System.out.println("Film berhasil dihapus.");
        } else {
            System.out.println("Nomor film tidak valid.");
        }
    }

    public static void bookSeat(String[] arrFilm, int[] arrAvailableSit, boolean[][] arrSitNumber, Scanner userInput) {
        printTheFilmList(arrFilm, arrAvailableSit);
        System.out.print("Pilih nomor film: ");
        byte filmNumber = userInput.nextByte();
        if (filmNumber >= 1 && filmNumber <= arrFilm.length && arrFilm[filmNumber - 1] != null) {
            System.out.println("Kursi tersedia: ");
            printTheAvailableSit(arrSitNumber, filmNumber);
            boolean isBooked = false;
            while (!isBooked) {
                System.out.print("Pilih nomor kursi: ");
                int sitNumber = userInput.nextInt();
                if (sitNumber < 1 || sitNumber > 50) {
                    System.out.println("Nomor kursi tidak valid. Silakan pilih kursi antara 1 dan 50.");
                } else if (arrSitNumber[filmNumber][sitNumber - 1]) {
                    System.out.println("Kursi sudah dipesan, silakan pilih kursi lain.");
                } else {
                    arrAvailableSit[filmNumber - 1]--;
                    arrSitNumber[filmNumber][sitNumber - 1] = true;
                    System.out.println("Kursi nomor " + sitNumber + " berhasil dipesan.");
                    isBooked = true;
                }
            }
        } else {
            System.out.println("Nomor film tidak valid.");
        }
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
            System.out.println((i + 1) + ". " + arrAdminMenu[i]);
        }
        System.out.print("0. Logout\nPilih menu: ");
    }

    public static void printTheGuestMenu(String[] arrGuestMenu) {
        System.out.println("\n=== Menu Guest ===");
        for (int i = 0; i < arrGuestMenu.length; i++) {
            System.out.println((i + 1) + ". " + arrGuestMenu[i]);
        }
        System.out.print("0. Logout\nPilih menu: ");
    }

    public static void printTheFilmList(String[] arrFilm, int[] arrAvailableSit) {
        System.out.println("\n=== Daftar Film ===");
        for (int i = 0; i < arrFilm.length; i++) {
            if (arrFilm[i] != null) {
                System.out.println((i + 1) + ". " + arrFilm[i] + " (Kursi tersedia: " + arrAvailableSit[i] + ")");
            }
        }
    }

    public static void printTheAvailableSit(boolean[][] arrSitNumber, byte filmNumber) {
        for (int i = 1; i <= 50; i++) {
            if (!arrSitNumber[filmNumber][i - 1]) {
                System.out.print((i < 10 ? "0" + i : i) + " ");
            } else {
                System.out.print("XX ");
            }
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
