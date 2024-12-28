// Nama = Azhar Aulia Priatna
// NPM = 1402024013

public class GanjilGenap_1402024013{
    public static void main(String[] value) {
    // variable yang diberi nilai value 0 sampai 2, semuanya diberi tipe data String agar nilai yang diberikan sesuai dengan input yang diinginkan
        String nameValue = value[0];
        String vehiclePlatValue = value[1].toUpperCase(); //toUpperCase digunakan agar semua huruf dari value[1] menjadi kapital
        String dateValue = value[2];

    // variable denda
        int penalty = 50000 * vehiclePlatValue.length(); //tipe data int digunakan agar menghasilkan data numeric bilangan bulat

     // variable untuk memisahkan angka dari kalimat pada plat kendaraan
        int vehiclePlatSpace1 = value[1].indexOf(' ');//tipe data int digunakan agar menghasilkan nilai yang dapat dijumlah
        int vehiclePlatSpace2 = value[1].indexOf(' ', vehiclePlatSpace1 + 1);

        //deklarasi variable agar menghasilkan nomor plat kendaraan
        String platNumber; //tipe data String digunakan karena saya ingin menggunakan substring agar dapat memanggil kata tengah yang berada diantara dua spasi, yaitu nomor plat kendaraan itu sendiri
        if (vehiclePlatSpace1 != -1 && vehiclePlatSpace2 != -1) {
            platNumber = vehiclePlatValue.substring(vehiclePlatSpace1 + 1, vehiclePlatSpace2); //mengambil string mulai dari karakter spasi pertama, sampai spasi kedua 
        } else {
            platNumber = "";
        }
        // mengambil angka terakhir dari plat;
            //tipe data char digunakan agar variable bernilai 1 karakter 
        char lastPlatNumber = platNumber.charAt(platNumber.length()-1);//dengan menggunakan charAt lalu diisi dengan panjang dari nomor plat kendaraan yang dikurangi satu, kode tersebut dapat memanggil Karakter terakhir dari sebuah kata 

    // variable untuk memisahkan angka dari kalimat pada tanggal
        int dateNumber = Integer.parseInt(value[2].substring(0, value[2].indexOf(" ")));//tipe data int digunakan agar variable tersebut dapat digunakan untuk melakukan operasi matematika

    // variable untuk mencari tanggal genap, dengan cara tanggal di modulo 2, jika tanggal tersebut genap maka hasil nya pasti 0, jika tanggal tersebut ganjil maka hasilnya pasti 1 
        boolean evenDate = dateNumber % 2 == 0;//tipe data boolean digunakan agar nilainya bisa menjadi pembanding untuk ternary operator
        String evenOddDate;//deklarasi, yang nantinya akan diberi nilai tergantung kondisi
        if (evenDate) { //jika tanggal yang di input merupakan tanggal genap maka akan;
            evenOddDate = "Genap";//jika benar/true
        }else {
            evenOddDate = "Ganjil";//jika false
        }
        
     // variable untuk mencari plat genap
        boolean evenPlat = lastPlatNumber % 2 == 0; //sama seperti variable evenDate bedanya ini plat bukan tanggal
        String evenOddPlat;//deklarasi, yang nantinya akan diberi nilai tergantung kondisi
        if (evenPlat){
            evenOddPlat = "Genap";
        }else evenOddPlat = "Ganjil";
        // mencari kebenaran apakah plat nomor yang diinput merupakan plat genap
        String truthPlat;
        boolean yesOrNoPlatOdd = evenOddDate.equals(evenOddPlat);//untuk membandingkan nilai antara variable evenOddDate dengan evenOddPlat, jika nilainya sama, maka akan menghasilkan kebenaran true
        if(yesOrNoPlatOdd){
           truthPlat = "Ya";
        }else  truthPlat = "Tidak";

        // variable untuk menentukan kena tilang atau tidak
        boolean ticketed = evenDate != evenPlat; //jika hasil dari evenDate tidak sama dengan evenPlat maka akan menjadi true

        // Array untuk menyimpan data tilang atau tidak
        String[] ticketResult = new String[2]; //deklarasi Array of String yang berisi 2 element
            //nilai dari element pertama Array/ index[0]
        if (ticketed){
            ticketResult[0] = "kena tilang";
        }else ticketResult[0] = "tidak kena tilang";

        // Prediksi besok tanggal ganjil atau genap
        boolean tomorrowEvenPrediction = (dateNumber + 1) % 2 == 0;// angka dari Tanggal + 1 akan menghasilkan tanggal besok
        String tomorrowPrediction;
        if(tomorrowEvenPrediction){//jika ((dateNumber + 1) % 2 == 0) bernilai true maka 
            tomorrowPrediction = "Genap";
        }else tomorrowPrediction = "Ganjil";
        // prediksi besok kena tilang atau tidak
        if (tomorrowEvenPrediction) {
            // nilai dari element kedua Array / index[1]
            ticketResult[1] = "tidak akan kena tilang";
        }else ticketResult[1] = "akan kena tilang";
    
    // Output
        System.out.print("============================================================" +
                        "\n=                       Ganjil Genap                       =" +
                        "\n=        Dibuat Oleh Azhar Aulia Priatna/1402024013        =" +
                        "\n============================================================" + 
                        "\n     Halo, Selamat Datang di program Tilang Elektronik     " + 
                        "\n          Silahkan Cek Data Kendaraan dibawah ini          " +
                        "\n============================================================" +
                        "\nNama\t\t\t: " + nameValue +
                        "\nPlat Kendaraan\t\t: " + vehiclePlatValue +
                        "\nTanggal\t\t\t: " + dateValue + 
                        "\nJenis Pelanggaran\t: " + "Melanggar aturan Ganjil Genap" +
                        "\nDenda\t\t\t: " + "Rp. " + penalty +
                        "\n============================================================" +
                        "\nAnda kena tilang pada tanggal " + dateValue +
                        "\ntanggal tersebut merupakan tanggal " + evenOddDate +
                        "\nAngka terakhir plat anda adalah " + lastPlatNumber +
                        "\nApakah Plat anda merupakan plat " + evenOddDate + "?\t\t\t: " + truthPlat + ", plat anda merupakan plat " + evenOddPlat +
                        "\n============================================================" +
                        "\nApakah kendaraan anda kena tilang\t\t\t: " + "Kendaraan anda " + ticketResult[0] +
                        "\nJika anda menggunakan kendaraan pada tanggal " + tomorrowPrediction +
                        "\napakah kendaraan anda kena tilang besoknya ?\t\t: " + "Kendaraan anda " + ticketResult[1]);
                        
    }
}