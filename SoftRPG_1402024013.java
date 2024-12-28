//Nama: Azhar Aulia Priatna
//NPM: 1402024013
// ===============================================================================
// Import Scanner dan Arrays
import java.util.Arrays;
import java.util.Scanner;
// ===============================================================================
public class SoftRPG_1402024013{
    public static void main(String[] arguments){
// Membuat Scanner
Scanner input = new Scanner(System.in);
// ===============================================================================
// output
        System.out.println("====================================================");
        System.out.println("--------------Program Naypos Adventure--------------");
        System.out.println("-----------Azhar Aulia Priatna/1402024013-----------");
        System.out.println("====================================================");
// ===============================================================================
    // Array of Weapon
     //Menggunakan tipe data Array of String agar nilai dari sebuah Array dapat diisi dengan nama senjata beserta persentase buff nya
    String[][] arrWeapon = new String[2][5];//layer pertama 2 element, dan layer kedua 5 element
    //Layer pertama
    arrWeapon[0][0] = "All-D-Staff";
    arrWeapon[0][1] = "Eren-Dagger";
    arrWeapon[0][2] = "Faiz-Sword";     //List nama senjata
    arrWeapon[0][3] = "Soft-Whip";
    arrWeapon[0][4] = "Yarsi-Spear";
   //Layer kedua
    arrWeapon[1][0] = "0.20";
    arrWeapon[1][1] = "0.25";
    arrWeapon[1][2] = "0.45";           //List buff senjata yang nantinya akan di Casting ke tipe data double
    arrWeapon[1][3] = "0.15";
    arrWeapon[1][4] = "0.35";
// ================================================================================
// output weapon list
        System.out.println("List Senjata-senjata Character:"+
        "\n1.\t" + arrWeapon[0][0] +
        "\n2.\t" + arrWeapon[0][1] +
        "\n3.\t" + arrWeapon[0][2] +
        "\n4.\t" + arrWeapon[0][3] +
        "\n5.\t" + arrWeapon[0][4]);
        System.out.print("Pilih Senjata Character: ");
        byte weapon = input.nextByte();//dikarenakan list hanya sampai 5 saja, maka tipe data byte digunakan agar menghasilkan bilangan bulat yang lebih hemat 
// ===============================================================================
    // Array of armor
     //Menggunakan tipe data Array of String agar nilai dari sebuah Array dapat diisi dengan nama armor beserta persentase buff nya
    String[][] arrArmor = new String[2][5];//layer pertama berisi 2 element, dan layer kedua berisi 5 element
    //layer pertama
    arrArmor[0][0] = "Plot-Armor";
    arrArmor[0][1] = "Diamond-Armor";
    arrArmor[0][2] = "Dark-Armor";      //List nama armor
    arrArmor[0][3] = "Light-Armor";
    arrArmor[0][4] = "Hawaii-Leather";
    //Layer kedua
    arrArmor[1][0] = "1.00";
    arrArmor[1][1] = "0.40";
    arrArmor[1][2] = "0.35";    //List buff armor, yang nantinya akan di casting ke tipe data double
    arrArmor[1][3] = "0.10";
    arrArmor[1][4] = "0.02";
// ===============================================================================
// output armor list
        System.out.println("----------------------------------------------------");
        System.out.println("List Armor-armor Character:" +
        "\n1.\t" + arrArmor[0][0] +
        "\n2.\t" + arrArmor[0][1] +
        "\n3.\t" + arrArmor[0][2] +
        "\n4.\t" + arrArmor[0][3] +
        "\n5.\t" + arrArmor[0][4]);
        System.out.print("Pilih Armor Character: ");
        byte armor = input.nextByte();//dikarenakan list hanya sampai 5 saja, maka tipe data byte digunakan agar menghasilkan bilangan bulat yang lebih hemat 
// ===============================================================================
   // Array of Spell list
   //Menggunakan tipe data Array of String agar nilai dari sebuah Array dapat diisi dengan nama Spell
    String[] arrSpells = new String [5];//membuat atau deklarasi sebuah Array sebanyak 5 element
    arrSpells[0] = "Gudang Ramuan";
    arrSpells[1] = "Kutukan PenitiSuper";
    arrSpells[2] = "Lompatan Morelong";
    arrSpells[3] = "Panggilan Unta";
    arrSpells[4] = "Nice Light";
// ===============================================================================
// output spell list
        System.out.println("----------------------------------------------------");
        System.out.println("List Spell Character:" +
        "\n1.\t" + arrSpells[0] +
        "\n2.\t" + arrSpells[1] +
        "\n3.\t" + arrSpells[2] +
        "\n4.\t" + arrSpells[3] +
        "\n5.\t" + arrSpells[4]);
        //tipe data byte digunakan karena ukuranya lebih hemat
        System.out.print("Pilih Spell Slot Pertama: ");
                byte firstSpell = input.nextByte();
        System.out.print("Pilih Spell Slot Kedua: ");
                byte secondSpell = input.nextByte();
        System.out.print("Pilih Spell Slot Ketiga: ");
                byte thirdSpell = input.nextByte();
// ===============================================================================
   //Array of spell yang dipilih 
   //Semua index array yang dipanggil akan di kurangi 1 agar menghasilkan pilihan yang sesuai dengan keinginan pengguna
    String[] arrSpell = new String[3];
    arrSpell[0] = arrSpells[firstSpell - 1]; // array[input - 1]
    arrSpell[1] = arrSpells[secondSpell - 1];
    arrSpell[2] = arrSpells[thirdSpell - 1];
    String chosenSpell = Arrays.toString(arrSpell); //alasan penggunaan tipe data String pada variable ini, agar Method dari Class Arrays yaitu toString() dapat digunakan
// ===============================================================================
// output profil
        System.out.println("----------------------------------------------------");
        System.out.println("Nama Character\t\t: Naypos" +
        "\nWeapon Character\t: " + arrWeapon[0][weapon - 1] + //memanggil element pertama dari layer pertama, dan memanggil element pilihan pegguna yang ada pada layer kedua
        "\nArmor Character\t\t: " + arrArmor[0][armor - 1] +       
        "\nSpell Character\t\t: " + chosenSpell);
// ===============================================================================
// Variable stat character
  // menggunakan tipe data double, alasanya agar menghasilkan nilai yang lebih presisi
        double weaponStats = Double.parseDouble(arrWeapon[1][weapon - 1]); //Parsing dari tipe data String menjadi double, agar nilainya menjadi numeric dan bisa digunakan untuk operasi matematika                                                
        double armorStats = Double.parseDouble(arrArmor[1][armor - 1]); //Parsing dari tipe data String menjadi double, agar nilainya menjadi numeric dan bisa digunakan untuk operasi matematika
        double[][] arrStatsChar = new double[2][3]; //deklarasi Array Multidimensi
        arrStatsChar[0][0] = 100.0;//base health
        arrStatsChar[0][1] = 50.0;// base power
        arrStatsChar[0][2] = 50.0;// base agility
        arrStatsChar[1][0] = arrStatsChar[0][0] + (armorStats * arrStatsChar[0][0]);// health buff
        arrStatsChar[1][1] = arrStatsChar[0][1] + (weaponStats * arrStatsChar[0][1]) * 2;//power buff
        arrStatsChar[1][2] = arrStatsChar[0][2] * ((weaponStats + armorStats) + 1.00);// agility buff

// ===============================================================================
// output stat character
        System.out.println("----------------------------------------------------");
        System.out.println("Base Stat Character:"+
        "\n\nHealth\t\t\t: " + arrStatsChar[0][0] +
        "\nPower\t\t\t: " + arrStatsChar[0][1] +
        "\nAgility\t\t\t: " + arrStatsChar[0][2] +
        "\n\nStat Character Dengan Equipment:" +
        "\n\nHealt Dengan " + arrArmor[0][armor - 1] + "\t:\t" + arrStatsChar[1][0] +
        "\nPower Dengan " + arrWeapon[0][weapon - 1]+ "\t:\t" +   arrStatsChar[1][1] +
        "\nAgility Dengan Equipmen\t:\t" + arrStatsChar[1][2]);
        System.out.println("----------------------------------------------------");
    }
}