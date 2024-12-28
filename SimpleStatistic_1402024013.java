/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */
import java.util.*;//mengimport seluruh liblary yang ada pada package util.
public class SimpleStatistic_1402024013{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);//var scanner agar user bisa menginput data
        Scanner userInput2 = new Scanner(System.in);
        boolean validInput = false;//var boolean untuk menyimpan data ekspresi
        String yN = "";//var String yang isinya kosong, yang nantinya akan diubah sesuai dengan inputan user


        System.out.println("================================================================================");
        System.out.println("--------------------------------Simple Statistic--------------------------------");
        System.out.println("------------------------Azhar Aulia Priatna/1402024013--------------------------");
        System.out.println("================================================================================");
        do{
            int maxValue = 0, minValue = 0, totalOdd = 0, totalEven = 0, sumNum = 0; //var int untuk menghasilkan bilangan bulat yang berkapasitas tingggi
            double avg = 0 , total = 0;//var double untuk menghasilkan bilangan rill yang lebih presisi
            do { 
                System.out.print("Masukan jumlah bilangan: ");
                if(userInput.hasNextInt()){//hasNextInt() metode untuk membaca apabila user menginput selain bertipe data int, maka akan menghasilkan nilai false, dan sebaliknya
                    sumNum = userInput.nextInt();//menyimpan data yang akan di input user
                    if(sumNum >= 0){
                        validInput = true;//jika ekspresinya benar maka variable input nilainya akan diubah dari false menjadi true
                    }else if(sumNum < 0){
                        System.out.println("\nTolong masukan angka positif");
                    }
                }else{
                    System.out.println("\nTolong masukan input angka");
                    userInput.next();//metode next() fungsinya agar data sebelumnya terhapus/ternext
                }
            } while (!validInput);//selama nilai dari validInput !false, maka program di dalam scope akan di ulang
                int[] arrValue = new int[sumNum]; //menginisialisasi array of int yang memiliki element sebanyak yang user mau
                for(int i = 0 ; i < sumNum ; i++){//selama i masih kurang dari panjang array, maka program akan diulang
                validInput = false;
                do { 
                    System.out.print("Masukan bilangan ke-" + (i+1)+ ": ");
                    if(userInput2.hasNextInt()){
                        arrValue[i] = userInput2.nextInt();
                        validInput = true;
                        }else{
                        System.out.println("\nTolong masukan input angka");
                        userInput2.next();
                    }
                }while (!validInput);
            }
            System.out.println("================================================================================");
            maxValue = arrValue[0];//menyimpan element pertama dari arrValue ke dalam varibale
            minValue = arrValue[0];
            for(int y : arrValue){
                total += y;
                if(y > maxValue)//mencaei nilai maks
                    maxValue = y;
                if(y < minValue)//mencari nilai min
                    minValue = y;
                if(y % 2 ==0)//mencari total ganjil
                    totalOdd += 1;
                if(y % 2 != 0)//mencari total genap
                    totalEven += 1;  
            }
            avg = total/sumNum;//rumus mencari rata rata
            System.out.println("Hasil: ");
            System.out.println("Nilai Maksimum: " + maxValue);
            System.out.println("Nilai Minimum: " + minValue);
            System.out.println("Rata-rata: " + avg);
            System.out.println("Total Bilangan Genap: " + totalOdd);
            System.out.println("Total Bilangan Ganjil: " + totalEven);
            System.out.println("================================================================================");
            do { 
                validInput = false;
                System.out.print("Apakah ingin mengulang program?(ya/tidak): ");
                yN = new Scanner(System.in).next();//menyimpan masukan pengguna kedalam variable
                if(yN.equalsIgnoreCase("ya")){
                    validInput = true;
                }else if(yN.equalsIgnoreCase("tidak")){
                    System.out.println("Program selesai. Terima kasih!");
                    break;//jika user menginput "tidak" maka program akan selesai, dengan cara menggunakan break
                }else{
                    System.out.println("Program yang tersedia hanya ya/tidak.");
                }
            } while (!validInput);
        }while(validInput);
    }
}