/**
 * NAMA: AZHAR AULIA PRIATNA
 * NPM: 1402024013
 */
import java.util.*;//mengimport seluruh liblary yang ada di package util/java
public class EasyCashier_1402024013{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);//membuat objek Scanner baru yang disimpan di userInput
        boolean back = false;//var untuk menentukan pengulangan program 
        String[] arrFood = {"Nasi Putih", "Sate Padang", "Ayam Bakar Rendang", "Soto Padang", "Nasi Kapau", "Dendeng Balado"};//arr of string untuk menyimpan daftar nama makanan
        int[] arrPrice = {12000, 44000, 31000, 27000, 45000, 31000};//arr of int untuk menyimpan daftar harga makanan
        //seluruh pesanan yang diinginkan user akan masuk ke arrOrder
        String[] arrOrder = new String[arrFood.length];
        int[] arrOrderPrice = new int[arrOrder.length];
        int[] arrOrderAmount = new int[arrOrder.length];//untuk menyimpan jumlah pesanan sesuai
        int[] arrTotalPrice = new int[arrOrder.length];//digunakan meyimpan hasil perkalian dari harga menu pesanan dikali jumlah pesanan
        byte orderAmountTemp = 0;//temporary untuk jumlah pesanan, alasan penggunaan byte karena user hanya dapat memesan maksimal 100 pesanan saja
        int total = 0 ;//menyimpan bilangan bulat dari total harga 

        System.out.println("===================================================================================================");
        System.out.println("--------------------------------------Program EasyCaashier-----------------------------------------");
        System.out.println("--------------------------------Azhar Aulia Priatna/1402024013-------------------------------------");
        System.out.println("===================================================================================================");
        do { //melakukan perulangan minimal 1x walaupun kondisinya false
            System.out.print("1. Lihat Daftar Menu\n2. Tambah Menu\n3. Tambah Pesanan\n4. Lihat Keranjang\n5. Bayar\n6. Keluar\nPilih sistem menu: ");
            byte chooseSystem = userInput.nextByte();//meyimpan masukan pengguna
//lihat daftar menu
            if(chooseSystem == 1){

                System.out.println("======================================== Lihat Daftar Menu ========================================");
                System.out.println("No.\tNama Makanan\t\t\t\t\t\t\t\tHarga");
                for(int i = 0 ; i < arrFood.length ; i++){//memanggil list makanan yang tersedia
                    int no = i+1;
                    System.out.println(no + "\t" + arrFood[i] + "\t\t\t\t\t\t\t\t" + arrPrice[i]);
                }
//tambah menu
            }else if(chooseSystem == 2){
               
                System.out.println("======================================== Tambah Menu ========================================");
                System.out.print("Masukan nama menu: ");
                String menuName = new Scanner(System.in).nextLine();
                System.out.print("Masukan harga: ");
                int menuPrice = userInput.nextInt();
                if(menuPrice > 0){//jika masukan harga nya nol, maka tambah menu akan gagal
                    String[] foodTemp = arrFood;//menyimpan daftar makanan
                    int[] priceTemp = arrPrice;
                    arrFood = new String[arrFood.length + 1];//resize ukuran array agar dapat menampung daftar makanan baru
                    arrPrice = new int[arrPrice.length + 1];
                    for(int i = 0 ; i < foodTemp.length ; i++){
                        arrFood[i] = foodTemp[i];//mengisi daftar makanan yang lama ke array yang sudah di resize
                        arrPrice[i] = priceTemp[i];
                    }
                    for(int i = 0 ; i < arrFood.length ; i++){
                        if(arrFood[i] == null){//jika element dari arrFood ada yang null, maka element tersebut akan diisi dengan nama menu dan harga yang diinginkan user 
                            arrFood[i] = menuName;
                            arrPrice[i] = menuPrice;
                            break;//untuk stop perulangan
                        }
                    }
                    System.out.println("\n\nMenu berhasi di tambahkan!");
                }else{
                    System.out.println("\n\nMenu gagal ditambahkan");
                }
// tambah pesanan  
            }else if(chooseSystem == 3){
                System.out.println("======================================== Tambah Pesanan ========================================");
                System.out.println("No.\tNama Makanan\t\t\t\t\t\t\t\tHarga");
                for(int i = 0 ; i < arrFood.length ; i++){//memanggil list makanan yang tersedia
                    int no = i+1;
                    System.out.println(no + "\t" + arrFood[i] + "\t\t\t\t\t\t\t\t" + arrPrice[i]);
                }
                System.out.print("Pilih nomor menu: ");
                byte chooseMenu = userInput.nextByte();
                if(chooseMenu <= arrFood.length){
                    System.out.print("Masukan jumlah pesanan: ");
                    byte inputOrderAmount = userInput.nextByte();
                    if(inputOrderAmount > 0){
                        orderAmountTemp += inputOrderAmount;
                        //cek apakah pesanan sudah mencapat maks
                        boolean isMaks = true;
                        if(orderAmountTemp <= 100){//belum mencapai maks
                            isMaks = false;
                        }
                        if(isMaks){
                            System.out.println("Anda telah mencapai batas maksimal pesanan.");
                            break;
                        }else{
                            System.out.println("Pesanan berhasil ditambahkan!");
                        }
                        for(int i = 0 ; i < arrOrder.length ; i++){
                            if(arrOrder[i] == null){//jika element arOrder ada yang null
                                arrOrder[i] = arrFood[chooseMenu-1];//akan diberi nilai sesuai dengan pilihan user
                                arrOrderAmount[i] = inputOrderAmount;
                                arrOrderPrice[i] = arrPrice[chooseMenu-1];
                                break;
                            }
                        }
                    }else{
                        System.out.println("Jumlah pesanan harus lebih dari nol!");
                    }
                }else{
                    System.out.println("Menu tidak tersedia!");
                }        
//lihat keranjang
            }else if(chooseSystem == 4){
                System.out.println("======================================== Lihat Keranjang ========================================");
                if(arrOrder[0] != null){//jika keranjangnya tidak kosong 
                    if(arrTotalPrice[0] == 0){
                        for(int i = 0 ; i < arrOrder.length ; i++){
                            arrTotalPrice[i] = (arrOrderPrice[i] *  arrOrderAmount[i]);//menghitung total 1 menu makanan sesuai dengan jumlah yang dipesan
                            total += arrTotalPrice[i];//menghitung total harga
                            if(arrOrder[i] != null)
                                System.out.println(arrOrder[i] + "\t\tx" + arrOrderAmount[i] + " = " + (arrOrderPrice[i] * arrOrderAmount[i]));
                        }
                    }
                    System.out.println("Total harga semua pesanan: " + total);
                    total = 0;
                    for(int i = 0 ; i < arrTotalPrice.length ; i++){
                        arrTotalPrice[i] = 0;//karena fungsi arrtotal price yang ada di system no 4 hanya untuk tampilan saja, maka arrTotalPrice diubah menjadi 0 lagi
                    }
                }else{
                    System.out.println("Keranjang kosong!");
                }
//bayar
            }else if(chooseSystem == 5){
                if(arrTotalPrice[0] == 0){
                    for(int i = 0 ; i < arrOrder.length ; i++){
                        arrTotalPrice[i] = (arrOrderPrice[i] *  arrOrderAmount[i]);
                        total += arrTotalPrice[i];
                    }
                }
                System.out.println("======================================== Bayar ========================================");
                // cek keranjang apakah ada yang perlu dibayar
                if(arrOrder[0] != null){
                    System.out.println("Total yang harus dibayar: " + total);
                    System.out.print("Masukan jumlah uang: ");
                    int money = userInput.nextInt();
                    // cek apakah uang yang dimasukan lebih besar dari biaya 
                    if(money >= total){
                        money -= total;
                        System.out.println("Pembayaran berhasil! Kembalian : " + money);
                        for(int i = 0 ; i < arrOrder.length ; i++){
                            arrOrder[i] = null;
                            arrOrderAmount[i] = 0;//mengosongkan seluruh keranjang karena pembayaran sudah lunas
                            arrOrderPrice[i] = 0;
                            arrTotalPrice[i] = 0;
                        }
                        total = 0;
                        System.out.println("Keranjang telah dikosongkan.");
                    }else{
                        System.out.println("Maaf uang anda kurang.");
                    }
                }else{
                    System.out.println("Keranjang kosong! Tidak ada yang perlu dibayar.");
                }
            }else if(chooseSystem == 6){
                System.out.println("======================================== Keluar ========================================");
                System.out.println("Terima kasih telah menggunakan program ini!");
                break;//menghentikan program
            }else{
                System.out.println("Invalid!");
            }
            
        System.out.println("===================================================================================================");
        System.out.print("Ingin kembali ke menu awal(Y/T) ? ");
        char yn = userInput.next().charAt(0);
        System.out.println("===================================================================================================");
        switch(yn){
            case 'y' : case 'Y' : back = true ; break;
            case 't' : case 'T' : back = false ; System.out.println("Program berhenti! Terima Kasih telah menggunakan program ini!") ; break;
            default : System.out.println("Maaf, input yang anda masukan salah!");  back = false ;break;
        }
                
        } while (back);
    }
}