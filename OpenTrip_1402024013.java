/**
 *Nama: Azhar Aulia Priatna
 *NPM: 1402024013
 */
import java.util.*;//Mengimport seluruh Liblary yang ada pada package util yang berada di package java

public class OpenTrip_1402024013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//tipe data Scanner, digunakan agar program bisa mendapatkan input dari user
        String inputName, inputYesNo, chooseLoad, registCode;//tipe data String digunakan data yang dihasilkan dapat berisi sebuah kumpulan data, angka, dan berbagai karakter 
        byte inputAge, chooseTrekkingType, chooseMountain, chooseTrekkingTime;//tipe data byte digunakan untuk mengisi data yang nilainya tidak lebih dari 100
        int totalCost;//tipe data int digunakan agar data yang akan diisi, dapat menghasilkan bilangan bulat yang lebih presisi
        byte index = 0;//tipe data byte yang sudah diinisialisai, digunakan untuk dijadikan sebuah index dan nantinya akan berubah sesuai dengan kondisi tertentu
        String[] arrTrekkingType = {//Array of String untuk menyimpan jenis - jenis pendakian
            "Tektok", "Camping"
        };
        String[][] arrMountainList = {//Array of String untuk menyimpan nama - nama gunung
            {"Kawah Ratu", "Pulosari", "Prau", "Andong"},//tektok
            {"Semeru", "Rinjani", "Kerinci", "Latimojong"}//camping
        };
        String[] arrTrekkingTime = {//Array of String untuk menyimpan data Estimasi Waktu Pendakian
            "2 hari 1 malam",
            "3 hari 2 malam",
            "4 hari 3 malam"
        };
        String[] arrLoadCarried = {//Array of String untuk menyimpan list Beban yang akan dibawa oleh User
            "60L",                 //alasan penggunaan tipe data String pada variable ini, agar lebih mudah jika ingin digunakan untuk perbandingan struktur if
            "30L",
            "15L"
        };
        int[] arrTrekkingCost = {//Array of int untuk menyimpan data biaya pendakian
            300000,//tektok      //alasan penggunaan tipe data int pada variable ini, yaitu mengikuti arahan yang di minta di ppt yaitu sebuah nilai bilangan bulat 
            700000//camping
        };
        int[] arrPorterRentCost = {//Array of int untuk menyimpan data biaya sewa porter
            500000,                //alasan penggunaan tipe data int pada variable ini, yaitu mengikuti arahan yang di minta di ppt yaitu sebuah nilai bilangan bulat 
            300000,
            150000
        };
        System.out.println("|----------------------------------------------------------------------------------------------------|"
                        + "\n|--------------------------------------Selamat datang diprogram--------------------------------------|"
                        + "\n|-------------------------------------Open Trip Summit Indonesia-------------------------------------|"
                        + "\n|-----------------------------------Azhar Aulia Priatna/14020240130----------------------------------|"
                        + "\n|----------------------------------------------------------------------------------------------------|");
        System.out.println("Selamat datang diprogram Open Trip Summit Seluruh Indonesia!\nTertarik Ikut Pendakian? Silahkan daftarkan diri anda sekarang!");
        System.out.print("Masukan Nama: ");
        inputName = new Scanner(System.in).nextLine();
        System.out.print("Masukan Umur: ");
        inputAge = sc.nextByte();
        if (inputAge > 17) {
            System.out.print("Pilihan Jenis Pendakian:"
                    + "\n1.\t" + arrTrekkingType[0]
                    + "\n2.\t" + arrTrekkingType[1]
                    + "\n~Pilih: ");
            chooseTrekkingType = sc.nextByte();
            if (chooseTrekkingType == 1 || chooseTrekkingType == 2) {
                System.out.print("Pilihan Gunung:"
                        + "\n1.\tGunung " + arrMountainList[chooseTrekkingType - 1][0]
                        + "\n2.\tGunung " + arrMountainList[chooseTrekkingType - 1][1]
                        + "\n3.\tGunung " + arrMountainList[chooseTrekkingType - 1][2]
                        + "\n4.\tGunung " + arrMountainList[chooseTrekkingType - 1][3]
                        + "\n~Pilih: ");
                chooseMountain = sc.nextByte();
                if (chooseTrekkingType == 2) {//jika camping
                    if (chooseMountain >= 1 && chooseMountain <= 4) {
                        System.out.print("Pilih Estimasi Waktu Pendakian:"
                                + "\n1\t" + arrTrekkingTime[0]
                                + "\n2.\t" + arrTrekkingTime[1]
                                + "\n3.\t" + arrTrekkingTime[2]
                                + "\n~Pilih: ");
                        chooseTrekkingTime = sc.nextByte();
                        if (chooseMountain == 1 && chooseTrekkingTime == 3) {//jika user memilih gunung semeru dan memilih pendakian yang diluar batas 
                            System.out.print("Maaf Pilihan Estimasi Pendakian di Gunung Semeru melebihi Batas\nWaktu Maksimal yang diizinkan. Silahkan ulangi pendaftaran dari awal!");
                        } else {
                            if (chooseTrekkingTime >= 1 && chooseTrekkingTime <= 3) {
                                System.out.print("Apakah anda membutuhkan porter: Ya atau Tidak? ");
                                inputYesNo = new Scanner(System.in).next();
                                if (inputYesNo.equalsIgnoreCase("ya")) {
                                    System.out.print("Masukan beban tas yang dibawa: ");
                                    chooseLoad = new Scanner(System.in).next();
                                    if (chooseLoad.equalsIgnoreCase(arrLoadCarried[0])) {
                                        index = 0;
                                    } else if (chooseLoad.equalsIgnoreCase(arrLoadCarried[1])) {
                                        index = 1;
                                    } else if (chooseLoad.equalsIgnoreCase(arrLoadCarried[2])) {
                                        index = 2;
                                    }
                                    registCode = Integer.toString(chooseTrekkingType) + Integer.toString(chooseMountain) + Integer.toString(chooseTrekkingTime) + inputName.substring(0, 1).toUpperCase() + inputName.substring(inputName.length() - 1).toUpperCase() + Integer.toString(inputAge);
                                    String[] arrInformation = {inputName, Integer.toString(inputAge), arrTrekkingType[chooseTrekkingType - 1], registCode};
                                    if (chooseLoad.equals(arrLoadCarried[0]) || chooseLoad.equals(arrLoadCarried[1]) || chooseLoad.equals(arrLoadCarried[2])) {
                                        totalCost = arrTrekkingCost[chooseTrekkingType - 1] + arrPorterRentCost[index];
                                        System.out.println("Anda dikenakan biaya sewa Jasa Porter: Rp." + arrPorterRentCost[index]);
                                        System.out.println("------------------------------------------------");
                                        System.out.println("Kode Daftar anda: " + registCode);
                                        System.out.println("Informasi tentang anda: " + Arrays.toString(arrInformation));
                                        System.out.println("Biaya pendakian: Rp." + arrTrekkingCost[chooseTrekkingType - 1]);
                                        System.out.println("Total Biaya: Rp." + totalCost);
                                        System.out.print("Terimakasih telah mendaftarkan diri di Open Trip Summit!");
                                    } else {
                                        System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
                                    }
                                } else if (inputYesNo.equalsIgnoreCase("tidak")) {
                                    registCode = Integer.toString(chooseTrekkingType) + Integer.toString(chooseMountain) + Integer.toString(chooseTrekkingTime) + inputName.substring(0, 1).toUpperCase() + inputName.substring(inputName.length() - 1).toUpperCase() + Integer.toString(inputAge);
                                    String[] arrInformation = {inputName, Integer.toString(inputAge), arrTrekkingType[chooseTrekkingType - 1], registCode};
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Kode Daftar anda: " + registCode);
                                    System.out.println("Informasi tentang anda: " + Arrays.toString(arrInformation));
                                    System.out.println("Biaya pendakian: Rp." + arrTrekkingCost[chooseTrekkingType - 1]);
                                    System.out.println("Total Biaya: Rp." + arrTrekkingCost[chooseTrekkingType - 1]);
                                    System.out.print("Terimakasih telah mendaftarkan diri di Open Trip Summit!");
                                } else {
                                    System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
                                }
                            } else {
                                System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
                            }
                        }
                    } else {
                        System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
                    }
                } else {//jika tektok
                    if (chooseMountain >= 1 && chooseMountain <= 4) {
                        System.out.print("Apakah anda membutuhkan porter: Ya atau Tidak? ");
                        inputYesNo = new Scanner(System.in).next();
                        if (inputYesNo.equalsIgnoreCase("ya")) {
                            System.out.print("Masukan beban tas yang dibawa: ");
                            chooseLoad = new Scanner(System.in).next();
                            if (chooseLoad.equalsIgnoreCase(arrLoadCarried[0])) {
                                index = 0;
                            } else if (chooseLoad.equalsIgnoreCase(arrLoadCarried[1])) {
                                index = 1;
                            } else if (chooseLoad.equalsIgnoreCase(arrLoadCarried[2])) {
                                index = 2;
                            }
                            registCode = Integer.toString(chooseTrekkingType) + Integer.toString(chooseMountain) + inputName.substring(0, 1).toUpperCase() + inputName.substring(inputName.length() - 1).toUpperCase() + Integer.toString(inputAge);
                            String[] arrInformation = {inputName, Integer.toString(inputAge), arrTrekkingType[chooseTrekkingType - 1], registCode};
                            totalCost = arrTrekkingCost[chooseTrekkingType - 1] + arrPorterRentCost[index];
                            if (chooseLoad.equals(arrLoadCarried[0]) || chooseLoad.equals(arrLoadCarried[1]) || chooseLoad.equals(arrLoadCarried[2])) {
                                System.out.println("Anda dikenakan biaya sewa Jasa Porter: Rp." + arrPorterRentCost[index]);
                                System.out.println("------------------------------------------------");
                                System.out.println("Kode Daftar anda: " + registCode);
                                System.out.println("Informasi tentang anda: " + Arrays.toString(arrInformation));
                                System.out.println("Biaya pendakian: Rp." + arrTrekkingCost[chooseTrekkingType - 1]);
                                System.out.println("Total Biaya: Rp." + totalCost);
                                System.out.print("Terimakasih telah mendaftarkan diri di Open Trip Summit!");
                            } else {
                                System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
                            }
                        } else if (inputYesNo.equalsIgnoreCase("tidak")) {
                            registCode = Integer.toString(chooseTrekkingType) + Integer.toString(chooseMountain) + inputName.substring(0, 1).toUpperCase() + inputName.substring(inputName.length() - 1).toUpperCase() + Integer.toString(inputAge);
                            String[] arrInformation = {inputName, Integer.toString(inputAge), arrTrekkingType[chooseTrekkingType - 1], registCode};
                            System.out.println("------------------------------------------------");
                            System.out.println("Kode Daftar anda: " + registCode);
                            System.out.println("Informasi tentang anda: " + Arrays.toString(arrInformation));
                            System.out.println("Biaya pendakian: Rp." + arrTrekkingCost[chooseTrekkingType - 1]);
                            System.out.println("Total Biaya: Rp." + arrTrekkingCost[chooseTrekkingType - 1]);
                            System.out.print("Terimakasih telah mendaftarkan diri di Open Trip Summit!");
                        } else {
                            System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
                        }
                    } else {
                        System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
                    }
                }
            } else {
                System.out.print("Maaf Pilihan yang anda masukkan tidak tersedia. Silahkan ulangi pendaftaran dari awal!");
            }
        } else {
            System.out.print("Mohon Maaf Umur anda masih kurang untuk mendaftarkan diri, Silahkan keluar dari Program!");
        }
    }
}