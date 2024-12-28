// Nama Lengkap = Azhar Aulia Priatna
// NPM = 1402024013

public class SensusPenduduk_1402024013{
    public static void main(String[] args){

// TIPE DATA INTEGER
    // ALASAN MEMILIH TIPE DATA INTEGER KARENA TIPE DATA INI MERUPAKAN TIPE STANDAR UNTUK BILANGAN BULAT
    int jumlahKelahiran = Integer.parseInt(args[0]);
    int jumlahKematian = Integer.parseInt(args[1]);
    int jumlahImigrasi = Integer.parseInt(args[2]);
    int jumlahEmigrasi = Integer.parseInt(args[3]);

 // TIPE DATA DOUBLE
    // ALASAN MEMILIH TIPE DATA DOUBLE KARENA TIPE DATA INI MERUPAKAN TIPE STANDAR UNTUK BILANGAN RILL
    // ALASAN KEDUA AGAR MENGHASILKAN DATA YANG LEBIH PRESISI
    double jumlahAwalPenduduk = 30000;
    double jumlahPertumbuhanPenduduk = (jumlahKelahiran-jumlahKematian) + (jumlahImigrasi-jumlahEmigrasi);
    double jumlahTotalPenduduk = 30000 + jumlahPertumbuhanPenduduk;
    double persentasePertumbuhanPenduduk = jumlahPertumbuhanPenduduk / jumlahAwalPenduduk * 100;
  
System.out.println("==================================================");
System.out.println("          Program Sensus Penduduk Kota A          ");
System.out.println("  Dibuat oleh [Azhar Aulia Priatna]/[1402024013]  ");
System.out.println("==================================================");
System.out.println("Jumlah Kelahiran Bayi    : " + jumlahKelahiran + " jiwa.");
System.out.println("Jumlah Kematian Penduduk : " + jumlahKematian + " jiwa.");
System.out.println("Jumlah Imigran           : " + jumlahImigrasi + " jiwa.");
System.out.println("Jumlah Emigran           : " + jumlahEmigrasi + " jiwa.");
System.out.println("--------------------------------------------------------------------------");
System.out.println("Pertumbuhan Penduduk     : (" + jumlahKelahiran + " - " + jumlahKematian + ") + (" + jumlahImigrasi + " - " + jumlahEmigrasi + ") = " + jumlahPertumbuhanPenduduk);
System.out.println("Persentase Pertumbuhanya : " + jumlahPertumbuhanPenduduk + " / " + jumlahAwalPenduduk + " * 100 = " + persentasePertumbuhanPenduduk + "%");
System.out.println("Total Penduduk           : " + jumlahAwalPenduduk + " + " + jumlahPertumbuhanPenduduk + " = " + jumlahTotalPenduduk + " jiwa.");
System.out.println("--------------------------------------------------------------------------");
System.out.println("Jadi, Jumlah pertumbuhan penduduk kota A dalam setahun mencapai " + jumlahPertumbuhanPenduduk + " jiwa,");
System.out.println("dengan persentase pertumbuhanya berkisar " + persentasePertumbuhanPenduduk + "%.");
System.out.println("Dan total penduduk kota A tahun 2024 adalah " + jumlahTotalPenduduk + " jiwa.");

    }

}