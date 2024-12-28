// Azhar Aulia Priatna[1402024013]
import java.util.Arrays;//import Class Arrays yang ada di package util yang berada di package java
import java.util.Scanner;//import Class Scanner
public class ArtefakMatriks_1402024013{
    public static void main(String[] input){
        Scanner sc = new Scanner(System.in);//Membuat variable dengan tipe data Scanner yang diberi nama sc, dan nilainya merupakan sebuah input dari user
        String name = input[0];//variable untuk menyimpan data dari nama si sang penjelajah, menggunakan tipe data String agar data yang dihasilkan merupakan sekumpulan Character
        String simbol1, simbol2, simbol3, simbol4, simbol5, simbol6, simbol7, simbol8, simbol9;  //inisialisasi variable yang menggunakan tipe data String, agar nilai dari variable tersebut dapat diisi dengan menthod dari Scanner yaitu next() 
        System.out.println("======================================================================================================================================================");
        System.out.println("                                                            Legenda Artefak Matriks ASCII                                                            ");
        System.out.println("                                                     Dibuat oleh: Azhar Aulia Priatna/1402024013                                                     ");
        System.out.println("======================================================================================================================================================");
        System.out.println("Selamat datang di Petualangan di Dunia ASCII, " + name + " Si Sang Penjelajah!\n");
        System.out.println("Kamu kini terperangkap dalam dunia tersembunyi di balik layar digital.");
        System.out.println("Dunia ini dijaga oleh Artefak Matriks ASCII, sebuah artefak kuno yang diyakini memiliki kekuatan untuk meretas dimensi waktu dan ruang.");
        System.out.println("Hanya mereka yang dapat menguasai teka-teki matriks ini yang bisa kembali ke realitas. Jalanmu masih panjang, " + name + " Buktikanlah bahwa kamu layak!");
        System.out.println("======================================================================================================================================================");
        System.out.println("Masukan 9 simbol kuno yang tersembunyi ke dalam Artefak Matriks berordo 3x3:");
        System.out.print("Masukan simbol ke-1: ");
        simbol1 = sc.next();//alasan penggunaan method next(), karena pada program ini inputnya bukan sebuah kalimat, melainkan hanya char saja
        System.out.print("Masukan simbol ke-2: ");
        simbol2 = sc.next();
        System.out.print("Masukan simbol ke-3: ");
        simbol3 = sc.next();
        System.out.print("Masukan simbol ke-4: ");
        simbol4 = sc.next();
        System.out.print("Masukan simbol ke-5: ");
        simbol5 = sc.next();
        System.out.print("Masukan simbol ke-6: ");
        simbol6 = sc.next();
        System.out.print("Masukan simbol ke-7: ");
        simbol7 = sc.next();
        System.out.print("Masukan simbol ke-8: ");
        simbol8 = sc.next();
        System.out.print("Masukan simbol ke-9: ");
        simbol9 = sc.next();
        // Matrix Char
        char[][] arrSimbolChar = { //Array of Array of Char, menggunakan tipe data char, agar nilainya berupa 1 simbol yang nantinya bisa diubah menjadi bilangan bulat
            {simbol1.charAt(0), simbol2.charAt(0), simbol3.charAt(0)},
            {simbol4.charAt(0), simbol5.charAt(0), simbol6.charAt(0)}, //karena data yang diinput oleh pengguna awalnya merupakan tipe data String, disini saya mengubah tipe datanya dari String agar menjadi tipe data Char menggunakan method charAt() 
            {simbol7.charAt(0), simbol8.charAt(0), simbol9.charAt(0)}
            };
        // Matrix dari char ke int
        int[][] arrSimbolInt = {//Array of Array of int, menggunakan tipe data int, agar nilai yang dihasilkan berupa bilangan bulat, dan juga karena int merupakan tipe standar untuk bilangan bulat
            {(int)arrSimbolChar[0][0], (int)arrSimbolChar[0][1], (int)arrSimbolChar[0][2]},
            {(int)arrSimbolChar[1][0], (int)arrSimbolChar[1][1], (int)arrSimbolChar[1][2]}, //konversi dari tipe data char agar menjadi tipe data int 
            {(int)arrSimbolChar[2][0], (int)arrSimbolChar[2][1], (int)arrSimbolChar[2][2]}
            };
        // Matrix Minor
        int[][] arrMatrixMinor = { //mencari dan menyimpan matrix minor yang nilainya diambil dari inputan pengguna yang nilainya berasal dari variable arrSimbolInt
            {(arrSimbolInt[1][1] * arrSimbolInt[2][2]) - (arrSimbolInt[1][2] * arrSimbolInt[2][1]), (arrSimbolInt[1][0] * arrSimbolInt[2][2]) - (arrSimbolInt[1][2] * arrSimbolInt[2][0]), (arrSimbolInt[1][0] * arrSimbolInt[2][1]) - (arrSimbolInt[1][1] * arrSimbolInt[2][0])},//m11, m12, m13
            {(arrSimbolInt[0][1] * arrSimbolInt[2][2]) - (arrSimbolInt[0][2] * arrSimbolInt[2][1]), (arrSimbolInt[0][0] * arrSimbolInt[2][2]) - (arrSimbolInt[0][2] * arrSimbolInt[2][0]), (arrSimbolInt[0][0] * arrSimbolInt[2][1]) - (arrSimbolInt[0][1] * arrSimbolInt[2][0])},//m21, m22, m23
            {(arrSimbolInt[0][1] * arrSimbolInt[1][2]) - (arrSimbolInt[0][2] * arrSimbolInt[1][1]), (arrSimbolInt[0][0] * arrSimbolInt[1][2]) - (arrSimbolInt[0][2] * arrSimbolInt[1][0]), (arrSimbolInt[0][0] * arrSimbolInt[1][1]) - (arrSimbolInt[0][1] * arrSimbolInt[1][0])}//m31, m32, m33
        };
        System.out.println("======================================================================================================================================================");
        System.out.println("Artefak Matriks berordo 3x3 Berhasil Diaktifkan:");
        System.out.println(Arrays.toString(arrSimbolChar[0]));
        System.out.println(Arrays.toString(arrSimbolChar[1]));  //memanggil nilai dari Array of Array of Char, menggunakan method dari Class Arrays yaitu Arrays.toString()
        System.out.println(Arrays.toString(arrSimbolChar[2]));      //agar nilai dari data Array of Array of char yang dipanggil menjadi String
        System.out.println("======================================================================================================================================================");
        System.out.println("Simbol-simbol kuno ini kini telah terungkap dalam angka ASCII yang mewakili kekuatan tersembunyi:");
        System.out.println(Arrays.toString(arrSimbolInt[0]));
        System.out.println(Arrays.toString(arrSimbolInt[1]));   //memanggil nilai dari Array of Array of int, menggunakan method dari Class Arrays yaitu Arrays.toString()
        System.out.println(Arrays.toString(arrSimbolInt[2]));           //agar nilai dari data Array of Array of int yang dipanggil menjadi String
        System.out.println("======================================================================================================================================================");
        System.out.println("Matriks kini tertransdormasi menjadi Matriks Minor berordo 3x3 yang akan membantu " + name + " mengungkap rahasia metriks tersembunyi:");
        System.out.println(Arrays.toString(arrMatrixMinor[0]));
        System.out.println(Arrays.toString(arrMatrixMinor[1])); //memanggil nilai dari Array of Array of int, menggunakan method dari Class Arrays yaitu Arrays.toString()
        System.out.println(Arrays.toString(arrMatrixMinor[2]));             //agar nilai dari data Array of Array of int yang dipanggil menjadi String
        System.out.println("======================================================================================================================================================");
        String[][] arrChalange = {//Deklarasi Array of Array of String, alasan penggunaan tipe data String, agar nilainya sesuai dengan kebutuhan, yaitu beberapa tantangan yang akan dipilih oleh si sang petualang
            {"Matriks Adjoin", "Matriks Kofaktor", "Matriks Rotasi 90 Derajat", "Matriks Flip Horizontal"}, //Element pertama, index [0][0] sampai index [0][3]
            {"Membuka jalur tersembunyi dari dimensi lain", "Menemukan elemen tersembunyi dari dimensi gelap", "Memutar ruang waktu untuk menemukan kebenaran", "Mencerminkan dirimu di dunia yang berlawanan"}//Element kedua, index [1][0] sampai index [1][3]
            }; 
        System.out.println("Tantangan dari Artefak untuk " + name + " Sang Penjelajah:");
        System.out.println("1. " + arrChalange[0][0] + " - " + arrChalange[1][0]);
        System.out.println("2. " + arrChalange[0][1] + " - " + arrChalange[1][1]);
        System.out.println("3. " + arrChalange[0][2] + " - " + arrChalange[1][2]);  
        System.out.println("4. " + arrChalange[0][3] + " - " + arrChalange[1][3]);
        System.out.print("Pilih tantangan yang akan kamu hadapi: ");
        int chooseChalange = sc.nextInt() - 1; //alasaan penggunaan tipe data int pada variable ini, yaitu agar nilai yang akan diinput oleh pengguna nanti, akan berupa bilangan bulat
                                                //variable ini juga akan penting nantinya untuk dijadikan sebuah index yaitu memanggil suatu data yang sesuai dengan pilihan pengguna
                                                    // lalu - 1 agar inputan dari pengguna tidak melebihi index yang sudah dibuat
        System.out.println("======================================================================================================================================================");
        //tipe data int pada bagian ini, fungsinya untuk menyimpan sebuah data yang bernilai bilangan bulat, kenapa harus int? karena int merupakan tipe data Standar untuk bilangan bulat dan ukuranya juga cukup besar untuk menyimpan data Matriks
        //-- List Tantangan --
        int[][][] arrListChalange = { //Deklarasi Array 3 dimensi, yang digunakan untuk mencari dan menyimpan berbagai jenis Matriks
            //Index [0][0][0] sampai [0][2][2]
            {{arrMatrixMinor[0][0], arrMatrixMinor[1][0], arrMatrixMinor[2][0]},
            {arrMatrixMinor[0][1], arrMatrixMinor[1][1], arrMatrixMinor[2][1]},     //Adjoin
            {arrMatrixMinor[0][2], arrMatrixMinor[1][2], arrMatrixMinor[2][2]}},
            //Index [1][0][0] sampai [1][2][2]
            {{arrMatrixMinor[0][0], -arrMatrixMinor[0][1], arrMatrixMinor[0][2]},
            {-arrMatrixMinor[1][0], arrMatrixMinor[1][1], -arrMatrixMinor[1][2]},   //Kofaktor
            {arrMatrixMinor[2][0], -arrMatrixMinor[2][1], arrMatrixMinor[2][2]}},
            //Index [2][0][0] sampai [2][2][2]
            {{arrMatrixMinor[2][0], arrMatrixMinor[1][0], arrMatrixMinor[0][0]},
            {arrMatrixMinor[2][1], arrMatrixMinor[1][1], arrMatrixMinor[0][1]},     //rotasi 90 derajat
            {arrMatrixMinor[2][2], arrMatrixMinor[1][2], arrMatrixMinor[0][2]}},
            //Index [3][0][0] sampai [3][2][2]
            {{arrMatrixMinor[2][0], arrMatrixMinor[2][1], arrMatrixMinor[2][2]},
            {arrMatrixMinor[1][0], arrMatrixMinor[1][1], arrMatrixMinor[1][2]},     //flip horizontal
            {arrMatrixMinor[0][0], arrMatrixMinor[0][1], arrMatrixMinor[0][2]}}
        };
        //Deklarasi Array of int, yang digunakan untuk mencari dan menyimpan hasil determinan dari masing-masing Matriks
        int matriksDeterminan =  arrListChalange[chooseChalange][0][0] * (arrListChalange[chooseChalange][1][1] * arrListChalange[chooseChalange][2][2] - arrListChalange[chooseChalange][1][2] * arrListChalange[chooseChalange][2][1])
                                    - arrListChalange[chooseChalange][0][1] * (arrListChalange[chooseChalange][1][0] * arrListChalange[chooseChalange][2][2] - arrListChalange[chooseChalange][1][2] * arrListChalange[chooseChalange][2][0])   
                                    + arrListChalange[chooseChalange][0][2] * (arrListChalange[chooseChalange][1][0] * arrListChalange[chooseChalange][2][1] - arrListChalange[chooseChalange][1][1] * arrListChalange[chooseChalange][2][0]);
        System.out.println(name + " telah memilih Tantangan " + arrChalange[0][chooseChalange] + " yang akan " + arrChalange[1][chooseChalange] + "...");
        System.out.println("\nBersiaplah! Penjaga Matrix mulai mengawasi gerakanmu...");
        System.out.println(Arrays.toString(arrListChalange[chooseChalange][0]));    //memanggil Matriks sesuai dengan tantangan yang sudah dipilih pengguna 
        System.out.println(Arrays.toString(arrListChalange[chooseChalange][1]));        //menggunakan method dari Class Arrays yaitu toString()
        System.out.println(Arrays.toString(arrListChalange[chooseChalange][2]));            //agar mengembalikan nilai dari variable Array 3 dimensi dari index yang sudah dipilih menjadi String
        System.out.println("\nTantangan Berhasil!!!");
        System.out.println("\n" + name + " telah menemukan " + arrChalange[0][chooseChalange] + " yang membantunya " + arrChalange[1][chooseChalange] + "!");
        System.out.println("Kekuatan artefak mulai terungkap di hadapanmu, " + name + "...");
        System.out.println("======================================================================================================================================================");
        System.out.println("Penjaga Matriks memberikan teka-teki akhir:");
        System.out.println("\nBerapa Determinan dari " + arrChalange[0][chooseChalange] + " yang telah kamu pilih?");
        System.out.println("\nHasil Determinan Artefak " + arrChalange[0][chooseChalange] + ": " + matriksDeterminan);
        System.out.println("\nDengan penemuan ini " + name + " melangkah lebih dekat menuju kebebasan!");
        System.out.println("Tapi jangan lengah... Masih banyak teka-teki yang menunggu di balik dunia Matriks ASCII ini.");
        System.out.println("======================================================================================================================================================");
        System.out.println("Program Berakhir. Bersiaplah untuk petualangan berikutnya, " + name + " SI Sang penjelajah...");
    }
}