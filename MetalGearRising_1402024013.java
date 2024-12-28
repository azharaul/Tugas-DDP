/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */
import java.util.*;
public class MetalGearRising_1402024013{
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);//Scanner agar program dapat membaca masukan dari user
        String character, userCodename, opponent, charClass, yesNo;//deklarasi tipe data String, digunakan untuk menyimpan data nama karakter, nama musuh, dan juga opsi
        byte userClass, userOpponent;//tipe data byte digunakan untuk menyimpan inputan dari user yang merupakan sebuah pilihan, alasan penggunaan tipe data byte yaitu agar lebih hemat dan pilihanya juga tidak akan melibihi batas tipe data byte
        int userHp, userAttack = 0, charHit, enemyHit; //tipe data int digunakan untuk menyimpan data bilangan bulat yang cukup besar,
        String[] arrClass = {"1. Cyborg Ninja", "2. Samurai Swordsman", "3. Tech Specialist", "4. Stealth Operative", "5. Gundam Pilot!"};//Array of String untuk menyimpan data nama Class
        String[] arrEnemy = {"1. Jetstream Sam", "2. Sundowner", "3. Senator Armstrong",};//Array of String untuk menyimpan data nama musuh
        int[] arrEnemyHp = {1200, 700, 800};//Array of Int digunakan untuk menyimpan data Stats darah dari musuh
        int[] arrEnemyAtk = {80, 60, 110,};//Array of Int digunakan untuk menyimpan data Stats atk dari musuh
        System.out.println("============================================================");
        System.out.println("--------------------Programming MGR Battle------------------");
        System.out.println("----------------Azhar Aulia Priatna/1402024013--------------");
        System.out.println("============================================================");
        System.out.print("Welcome Operative!\nEnter Codename: ");
        userCodename = userInput.next();
        for(;;){//infinite loop, jika tidak di break maka program akan diulang
            System.out.println("Choose your class");
            for(String classs: arrClass){//for each untuk memanggil array
                System.out.println(classs);
            }
            System.out.print("Option: ");
            userClass = userInput.nextByte();
            if(userClass >= 1 && userClass <= 4){
                userClass -= 1;
                charClass = arrClass[userClass].substring(arrClass[userClass].indexOf(" ") + 1);
                character = userCodename + " the " + charClass;
                System.out.println("\nSetup your " + charClass);
                do{//do while loop, akan diulang selama user menginput hp > 500 dan atk > 100
                    System.out.print(character + " HP = ");
                    userHp = userInput.nextInt();
                    if(userHp <= 500){
                            System.out.print(character + " Attack = ");
                            userAttack = userInput.nextInt();
                            if(userAttack <= 100){
                                System.out.println("------------------------------------------------------");
                                for(;;){
                                    System.out.println("Enemy Info");
                                    for(String enemy : arrEnemy){
                                        System.out.println(enemy);
                                    }
                                    System.out.print("Choose your opponent: ");
                                    userOpponent = userInput.nextByte();
                                    if(userOpponent >= 1 && userOpponent <= 3){
                                        switch(userClass){
                                            case 0 : userAttack *= 2; break;//cyborgninja atk x2
                                            case 1 : userHp *= 2; break;//samurai hp x2
                                            case 2 : userHp *= 2; userAttack *= 2; break;//tech specialist hp x2 & atk x2
                                            case 3 : userHp /= 4; userAttack *= 4; break;//stealh operative hp/4 & atk *2
                                        }
                                        userOpponent -= 1;
                                        opponent = arrEnemy[userOpponent].substring(arrEnemy[userOpponent].indexOf(" ") + 1);
                                        System.out.println(character + " vs " + opponent);
                                        System.out.println("------------------------------------------------------");
                                        System.out.println("Battle Statistic\n");
                                        System.out.println(charClass + " HP : " + userHp);
                                        System.out.println(charClass + " Attack : " + userAttack);
                                        System.out.println("\nHP " + opponent + " : " + arrEnemyHp[userOpponent]);
                                        System.out.println("Attack " + opponent + " : " + arrEnemyAtk[userOpponent]);
                                        System.out.println("------------------------------------------------------");
                                        charHit = arrEnemyHp[userOpponent] / userAttack;
                                        enemyHit = userHp / arrEnemyAtk[userOpponent];
                                        if(arrEnemyHp[userOpponent] % userAttack != 0 )charHit++;//jika sisa darah lawan belum 0 maka hit ditambah 1
                                        if(userHp % arrEnemyAtk[userOpponent] != 0)enemyHit++;
                                        System.out.println(character + " need " + charHit + " hit to defeat " + opponent);
                                        System.out.println( "and " + opponent + " need " + enemyHit + " hit to defeat your " + charClass);
                                        userAttack = 0;//karena charakter sudah mati, hp dan atk nya menjadi 0
                                        userHp = 0;
                                        break;//agar infinite loop dapat berhenti
                                    }else{
                                        System.out.print("You choose unvaliable enemy in the system Please try again!\n");
                                    }
                                }
                            }else{
                                System.out.println(charClass + " can't have that many attack Please try again!\n");
                            }     
                    }else{
                        System.out.println(charClass + " can't have that many hp Please try again!\n");
                    }
                }while(userHp > 500 || userAttack > 100);
                break;
            }else if(userClass == 5){
                userClass -= 1;
                charClass = arrClass[userClass].substring(arrClass[userClass].indexOf(" ") + 1);
                character = userCodename + " the " + charClass;
                System.out.println("\nSetup your " + charClass);
                do { 
                System.out.print(character + " HP = ");
                userHp = userInput.nextInt();
                if(userHp <= 500){
                    System.out.print(character + " Attack = ");                  
                    userAttack = userInput.nextInt();
                    if(userAttack <= 100){
                        System.out.println("\nEnemy Info:");
                        String gundamPilotEnemy = "Char Aznable";//musuh khusus apabila user memilih class gundam pilot
                        int hpAznable = 4000, atkAznable = 2200;
                        System.out.println("|"+ gundamPilotEnemy+"|");
                        for(;;){
                        System.out.print("Are you sure want to fight " + gundamPilotEnemy + "?(y/n): ");
                        yesNo = userInput.next();
                        if(yesNo.equalsIgnoreCase("y")){
                            System.out.println("------------------------------------------------------");
                            System.out.println(character + " vs " + gundamPilotEnemy);
                            System.out.println("------------------------------------------------------");
                            System.out.println("Battle Statistic\n");
                            userHp *= 9;
                            userAttack *= 25;
                            System.out.println(charClass + " HP : " + userHp);
                            System.out.println(charClass + " Attack : " + userAttack);
                            System.out.println("\nHP " + gundamPilotEnemy + " : " + hpAznable);
                            System.out.println("Attack " + gundamPilotEnemy + " : " + atkAznable);
                            System.out.println("------------------------------------------------------");
                            charHit = hpAznable / userAttack;
                            enemyHit = userHp / atkAznable;       
                            if(userAttack * charHit < hpAznable)charHit++;
                            if(atkAznable * enemyHit < userHp)enemyHit++;
                            System.out.println(character + " need " + charHit + " hit to defeat " + gundamPilotEnemy);
                            System.out.println( "and " + gundamPilotEnemy + " need " + enemyHit + " hit to defeat your " + charClass);
                            userHp = 0;
                            userAttack = 0;
                            break;
                        }else if(yesNo.equalsIgnoreCase("n")){
                            System.out.println("You run away in fear...");
                            break;
                        }else{
                            System.out.println("Your input is invalid!");
                        }
                    }
                    }else{
                        System.out.println(charClass + " can't have that many attack Please try again!\n");  
                    }
                }else{
                    System.out.println(charClass + " can't have that many hp Please try again!\n");  
                }
            }while(userHp > 500 || userAttack > 100);
            break;
            }else{
                System.out.print("There is no class in the system Please try again!\n");
            }
        }
    }
}