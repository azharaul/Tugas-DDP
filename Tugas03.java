/**
 Tugas03 Class 
 
 Program ini  mencetak teks yang berisi salam, nama, 
 dan ukuran memory yang dimiliki perangkat eksekusi.
 */
public class Tugas03{
	/**
	 Metode yang dipanggil pertama kali ketika kode 
	 program ini dieksekusi.
	 @param args argumen saat eksekusi
	 */
	public static void main(String[] args){
		// teks untuk dicetak
		String text = "Assalamu'alaikum,\n" +
			"nama saya, Azhar Aulia Priatna dan " +
			"perangkatku memiliki memory sebesar " + 
			Runtime.getRuntime().totalMemory() + 
			" byte.";
		// cetak teks ke layar konsol
		System.out.print(text);  
	}
}