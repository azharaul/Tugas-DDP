public class VoidRealm_1402024013{
//   Nama : Azhar Aulia Priatna
//   NPM  : 1402024013
  
    public static void main(String[] args){
        // saya membuat variable bernama "name" menggunakan tipe data string yang bernilai argumen[0] dan seluruh argumen[0] tersebut, saya membuatnya menjadi huruf kapital 
        String name = args[0].toUpperCase() ;
        // saya membuat variable bernama "weapon" menggunakan tipe data string yang bernilai argumen[1] dan seluruh argumen[1] tersebut, saya membuatnya menjadi huruf kecil 
        String weapon = args[1].toLowerCase();
        // saya membuat variable bernama "age" menggunakan tipe data string yang bernilai argumen[2], lalu argumen[2] tersebut saya bagi 365(total hari dari 1 tahun)
        int age = Integer.parseInt(args[2]) / 365;
        // saya membuat variable bernama "era" menggunakan tipe data string yang bernilai argumen[3])
        int era = Integer.parseInt(args[3]);

        // saya membuat variable bernama "firstCode" menggunakan tipe data string yang nilainya dari variable "name", tapi hanya mulai dari index ke 0 dan stop di index ke 1 
        String firstCode = name.substring(0, 1);
        // saya membuat/menginisialisasi variable bernama "secondCode" menggunakan tipe data integer yang nilainya panjang dari variable "name" yang dibagi 2 lalu saya casting menjadi tipe data (int) 
        int secondCode = (int)name.length() / 2;  
        // lalu saya ubah kembali variable "secondCode", saya ubah nilainya agar menghasilkan kode Char dari hasil yang sudah di inisialisasikan sebelumnya
        secondCode = name.charAt(secondCode);
        // saya membuat variable bernama "lastCode" menggunakan tipe data String yang nilainya huruf terakhir yang diambil dari panjang variable "name"
        String lastCode = name.substring(name.length() - 1);

        // saya membuat variable "codeName" menggunakan tipe data int agar bisa menjumlahkan variable "age" dengan variable "secondCode"
        int codeName = age + secondCode;
        // saya membuat variable "uniqueWeapon" menggunakan tipe data string yang saya beri nilai substring dari index[0] dan stop di index[2] pada variable "weapon" agart menghasilkan 2 karakter pertama saja
        // lalu saya ambil 2 karakter pertama dari args[3] yang dikali 8, lalu saya casting menjadi tipe data Char 
        String uniqueWeapon = weapon.substring(0, 2) + (char) (Integer.parseInt(args[3].substring(0, 2)) * 8);
        // lalu saya ubah kembali variable "uniqueWeapon", saya ubah nilainya agar nilainya menjadi huruf kapital semua
        uniqueWeapon = uniqueWeapon.toUpperCase();


        System.out.println("------------------------------------------------");
        System.out.println("                Program VoidRealm               ");
        System.out.println("   Dibuat oleh Azhar Aulia Priatna/1402024013   ");
        System.out.println("------------------------------------------------");
        System.out.println("Name            : " + name);
        System.out.println("Weapon          : " + weapon);
        System.out.println("Age             : " + age + " Years Old");
        System.out.println("Era             : " + era + " BC");
        System.out.println("------------------------------------------------");
        System.out.println("First Code      : " + firstCode);
        System.out.println("Second Code     : " + secondCode);
        System.out.println("Third Code      : " + lastCode);
        System.out.println("------------------------------------------------");
        System.out.println("Code Name       : " + codeName + (char) secondCode + firstCode + lastCode);
        System.out.println("Unique Weapon   : " + uniqueWeapon);
        System.out.println("------------------------------------------------");
        System.out.println(args[0] + " berada di dunia void setelah memasuki portal misterius, ia mempunyai " + weapon.toUpperCase() + " & " + uniqueWeapon);
        System.out.println("dan berumur " + age +  " tahun, nama panggilan code name dia adalah " + codeName + (char) secondCode + firstCode + lastCode +  ".");
    }
}