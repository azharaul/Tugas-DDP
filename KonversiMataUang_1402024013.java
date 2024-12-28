/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */ 
import java.util.Scanner;//import kelas Scanner yang ada di folder util yang berada di folder java
public class KonversiMataUang_1402024013{
    public static void main(String[] args){
        float[] arrKurs = new float[4];//untuk menyimpan nilai kurs yang bernilai bilangan rill.
        float inputvalueF, result = 0;//alasan penggunaan tipe data float, untuk mencegah tejadinya rounding error, kenapa tidak int? karena hasil konversi nanti harus berupa bilangan rill.
        int konversion, inputValue;//inputvalue digunakan untuk menyimpan data dari inputan user
        //konversion digunakan untuk menyimpan nilai dari rumus yang awalnya bertipe data float lalu di casting menjadi integer di dalam variable ini.
        byte chooseCurrencies;//variable yg digunakan untuk menyimpan data dari input user, alasan menggunakan byte karena nanti user hanya akan memilih nilai dari 1 sampai 4 saja.
        char yesNo;//variable untuk patokan untuk mengulang program, kenapa menggunakan char? karena nilai yang akan diminta hanya berupa 1 karakter saja yaitu (y/n).
        boolean reset = false;//boolean untuk patoka mengulang program juga, jika user memilih 'y', maka nilai dari boolean ini akan menjadi true dan jika 'n' maka nilainya akan tetap false.
        do{//do while loop, agar mencetak minimal 1 kali sebuah program walaupun kondisinya false
            System.out.print("==================================================" +
                            "\n========[Azhar Aulia Priatna]/[1402024013]========" +
                            "\n================Konversi Mata Uang================" + 
                            "\n==================================================\n");
            System.out.print("Masukan jumlah uang dalam Rupiah: ");
            inputValue = new Scanner(System.in).nextInt();
            inputvalueF = inputValue;
            System.out.print("Pilih mata uang tujuan:" +
                            "\n1. USD (Dolar Amerika)" +
                            "\n2. EUR (Euro)" +
                            "\n3. JPY (Yen Jepang)" +
                            "\n4. GBP (Pound Inggris)" +
                            "\nMasukan pilihan anda: ");
            chooseCurrencies = new Scanner(System.in).nextByte();
            System.out.println("==================================================");
            switch(inputValue / 1000001){//jika input yang diberikan user kurang dari sama dengan 1jt, maka nilainya akan jadi 0 dan masuk ke case 0. Sebaliknya, jika nilai user lebih dari 1jt maka nilainya akan lebih dari 0 dan masuk ke default
                default://lebih dari 1 juta
                    arrKurs[0] = 14750;
                    arrKurs[1] = 15750;
                    arrKurs[2] = 118;
                    arrKurs[3] = 17750;
                    break;
                case 0://kurang dari 1juta
                    arrKurs[0] = 15000;
                    arrKurs[1] = 16000;
                    arrKurs[2] = 120; 
                    arrKurs[3] = 18000;
                    break;
            }
            switch(chooseCurrencies){
                default: System.out.println("Pilihan Tidak Valid!"); break;//kondisi jika user memilih pilihan yang tidak tersedia
                case 1 : case 2 : case 3 : case 4 :
                result = (inputvalueF / arrKurs[chooseCurrencies - 1]) * 100; 
                konversion = (int)result;
                result = konversion / 100.0f;
            }
            switch(chooseCurrencies){
                case 1 ://amerika
                    System.out.println("Hasil konversi: " + (result) + " USD");
                break;
                case 2 ://eruo
                    System.out.println("Hasil konversi: " + (result) + " EUR");
                break;
                case 3 ://yen
                    System.out.println("Hasil konversi: " + (result)  + " JPY");
                break;
                case 4 ://GPB
                    System.out.println("Hasil konversi: " + (result) + " GPB");
                break;
            }
            System.out.println("==================================================");
            do {
                System.out.print("Apakah anda ingin mengulang program ini dari awal?(y/n): ");
                yesNo = new Scanner (System.in).next().charAt(0);
                switch(yesNo){
                    case 'y' : case 'Y' : reset = true; break;
                    case 'n' : case 'N' : reset = false; break;
                    default:
                    yesNo = '!';
                    System.out.println("Berikan input yang Valid!"); break;
                }
            }while(yesNo == '!');//apabila user menginput data yang tidak valid, maka variable yesNo nilai nya akan berubah menjadi '!', dan apabila nilai dari variable yesNo berubah menjadi '!', maka pertanyaan untuk mengulang program akan diulang.
        }while(reset);
    }
}