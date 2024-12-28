/*
 * Nama : Azhar Aulia Priatna
 * NPM : 1402024013
 */
import java.util.*;//Mengimport seluruh liblary yang ada pada package util yg berada di package java
public class EdenTreatySimulation_1402024013{
    public static void main(String[] args) {

        String[] arrAcademy = {//menginisialisasi Array of String, fungsinya untuk menyimpan nama Academy
            "Gehena",
            "Trinity"
        };

        String[][] arrChar = {//menginisialisasi Array of Array of String, fungsinya untuk menyimpan nama Character
            //Gehena
            {"Amau Ako", "Sorasaki Hina"},
            //Trinity
            {"Misono Mika", "Kirifuji Nagisa"}
        };

        int[][] arrStats = {//menginisialisasi Array of Array of int, fungsinya untuk menyimpan data Stats Character
            //Gehena
            {220, 45,//HP & ATK Amau Ako
            133, 99},//HP & ATK Sorasaki Hina
            //Trinity
            {167, 105,//HP & ATK Misono Mika
            148, 69},//HP & ATK Kirifuji Nagisa
        };

        String[][] arrUniqueEquipment = {//menginisialisasi Array of Array of int, fungsinya untuk menyimpan data Stats Character
            //Gehena
            {"Hot Shot",//Amau Ako
            "Destroyer"},//Sorasaki Hina
            //Trinity
            {"Quis ut Deus",//Misono Mika
            "Roya Blend"}//Kirifuji Nagisa
        };

        String[][] arrExSkill = {//menginisialisasi Array of Array of String, fungsinya untuk menyimpan data nama EX Skill untuk masing-masing Chararcter
            //Gehenna
            {"Share Reconnaissance Data",//Amau Ako
            "Ishboshet"},//Sorasaki Hina
            //Trinity
            {"Kyrie Eleison",//Misono Mika
            "Time On Target"}//Kirifuji Nagisa
        };
        
        double[][] arrAtkPasifUniqueEquipment = {//menginisialisasi Array of Array of double, fungsinya untuk menyimpan data Attack pasif dari unique equipment dari masing masing character
            //Gehenna
            {arrStats[0][1] + arrStats[0][1] * 0.50,//Hot Shot Amau Ako
            arrStats[0][3] + arrStats[0][3] * 0.50},//destroyer Sorasaki Hina
            //Trinity
            {arrStats[1][1] + arrStats[1][1] * 0.50,//Quis ut Deus Misono Mika
            arrStats[1][3] + arrStats[1][3] * 0.50}//Roya Blend Kirifuji Nagisa
        };

        double[][] arrAtkExSkillAbility = {//menginisialisasi Array of Array of double, fungsinya untuk menyimpan data buff Attack jika user memilih menggunakan EX Skill Ability 
            //Gehenna
            {arrStats[0][0] + arrStats[0][0] * 0.50,//Share Reconnaissance Data Amau Ako
            arrStats[0][3] + arrStats[0][3] * 2.55},//Ishboshet Sorasaki Hina
            //Trinity
            {arrStats[1][1] + arrStats[1][1] * 1.65,//Kyrie Eleison Misono Mika
            arrStats[1][3] + arrStats[1][3] * 1.80}//Time On Target Kirifuji Nagisa
        };

        String[][] arrExSkillAbility = {//menginisialisasi Array of Array of String, fungsinya untuk menyimpan nama dari EX Skill Ability
            //Gehenna
            {"Ako Menimbulkan Mystic DMG setara dengan 50% HP Maks Ako ke satu boss.",
            "Hina Menimbulkan 255% ATK sebagai DMG tipe Explosion ke semua boss."},
            //Trinity
            {"Mika menghantarkan Penetration DMG 165% ATK Mika ke semua boss.",
            "Nagisa menghantarkan Explosion DMG setara dengan 180% ATK Nagisa ke semua boss."}
        };
       
        String[][] arrAtkTypeChar = {//menginisialisasi Array of Array of String, fungsinya untuk menyimpan nama dari Attack Type
        //Tipe Damage Masing-masing Character
            //Gehenna
            {"Mystic",//Amau Ako
            "Eksplosion"},//Sorasaki Hina
            //Trinity
            {"Eksplosion",//Misono Mika
            "Eksplosion"},//Kirifuji Nagisa

        //Indikator Kelemahan Boss
            {"Eksplosion", "Mystic"},//Kaiten FX MK.0
            {"Eksplosion", "Penetration"},//Binah
            {"Penetration", "Mystic"}//Perorodzilla
        };
        
        String[] arrArmorType ={//menginisialisasi Array of String, fungsinya untuk menyimpan nama- nama dari Armor Type
            "Light Armor",//Kaiten FX MK.0
            "Heavy Armor",//Binah
            "Special Armor"//Perorodzilla
        };

        String[] arrBoss = {//menginisialisasi Array of String, fungsinya untuk menyimpan nama - nam boss
            "Kaiten FX MK.0",
            "Binah",
            "Perorodzilla"
        };

        byte chooseTeam, chooseBoss;//fungsinya untuk menyimpan data scanner / inputan dari user, alasan penggunaan byte karena pemilihan tidak akan lebih dari 100 dan harus bilangan bulat
        int chooseHpBoss, chooseHpKaiten, chooseHpBinah, chooseHpPerorodzilla;//fungsinya untuk menyimpan data scanner / inputan dari user, alasan penggunaan int karena pemilihan disini akan lebih dari 1000 dan harus bilangan bulat
        double bossHpRemaining, kaitenHpRemaining, binahHpRemaining, perorodzillaHpremaining;//untuk menyimpan sisa darah dari masing masing boss, alasan penggunaan double, agar sisa darah boss menjadi lebih presisi
        String chooseChar;//fungisnya untuk menyimpan data scanner / inputan dari user, alasan penggunaan String agar scanner dapat membaca String
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println("----------Selamat datang di Simulasi Raid Blue Archive----------");
        System.out.println("----------Dibuat oleh [Azhar Aulia Priatna/1402024013]----------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Roster yang tersedia: ");
        System.out.println("1. " + arrAcademy[0]);
        System.out.println("2. " + arrAcademy[1]);
        System.out.print("Pilih team: ");
        chooseTeam = new Scanner(System.in).nextByte();
        chooseTeam -= 1;
        System.out.println("-----------------------------------------------------------------");

        if(chooseTeam == 0 || chooseTeam == 1){//Kondisi jika User Memilih Team 1 atau Team 2
            System.out.println("Character yang tersedia:");
            System.out.println(Arrays.toString(arrChar[chooseTeam]));
            System.out.print("Pilih Character: ");
            chooseChar = new Scanner(System.in).nextLine();
            
            if(chooseChar.equalsIgnoreCase(arrChar[0][0])){//Kondisi jika User memilih Amau Ako || Mystic
                System.out.println("Academy dari Character yang anda pilih: " + arrAcademy[0] + " - " + arrChar[0][0]);
                System.out.println("Attack Type Character: " + arrAtkTypeChar[0][0]);
                System.out.println("EX Skill Character: " + arrExSkill[0][0]);
                System.out.println("UniqueEquipment Character: " + arrUniqueEquipment[0][0]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Character dan EX Skill:");
                System.out.println("1. Nama Character: " + arrChar[0][0]);
                System.out.println("2. EX Skill: " + arrExSkill[0][0] + " -> " + arrExSkillAbility[0][0]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Cek pasif Unique Equipment:");
                System.out.println(arrUniqueEquipment[0][0] + " -> " + arrAtkPasifUniqueEquipment[0][0] + " damage / shot");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Boss: ");
                System.out.println(arrBoss[0] + " memiliki armor bertipe " + arrArmorType[0] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[2]));
                System.out.println(arrBoss[1] + " memiliki armor bertipe " + arrArmorType[1] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[3]));
                System.out.println(arrBoss[2] + " memiliki armor bertipe " + arrArmorType[2] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[4]));
                System.out.println("-----------------------------------------------------------------");
                System.out.print("Apakah anda ingin mencoba EX Skill? (y/n): ");
                String yesNo = new Scanner(System.in).next();

                if(yesNo.equalsIgnoreCase("y")){//Kondisi jika User memilih YES
                    System.out.println("1. " + arrBoss[0]);
                    System.out.println("2. " + arrBoss[1]);
                    System.out.println("3. " + arrBoss[2]);
                    System.out.print("Pilih Boss untuk diserang: ");
                    chooseBoss = new Scanner(System.in).nextByte();
                    chooseBoss -= 1;
                    System.out.println("-----------------------------------------------------------------");

                    if(chooseBoss == 0){//Kondisi jika User memilihih Kaiten FX MK 0
                        /*
                         * Light Armor :
                         * Eksplosion = Weak
                         * Penetration = Resist
                         * Mystic = Normal
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                                System.out.println("Anda telah menggunakan EX Skill " + arrExSkill[0][0]);
                                System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + arrAtkExSkillAbility[0][0]);
                                bossHpRemaining = chooseHpBoss - arrAtkExSkillAbility[0][0];
                                System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 1){//Kondisi jika User memilih Binah
                        /*
                         * Heavy Armor :
                         * Eksplosion = Normal
                         * Penetration = Weak
                         * Mystic = Resist
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();
                        
                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan EX Skill " + arrExSkill[0][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkExSkillAbility[0][0] - arrAtkExSkillAbility[0][0] * 0.30)  + " karena DMG RES");
                            bossHpRemaining = chooseHpBoss - (arrAtkExSkillAbility[0][0] - arrAtkExSkillAbility[0][0] * 0.30);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 2){//Kondisi jika User memilih Perorodzilla
                        /*
                         * Special Armor :
                         * Eksplosion = Resist
                         * Penetration = Normal
                         * Mystic = Weak
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan EX Skill " + arrExSkill[0][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkExSkillAbility[0][0] * 2)   + " karena Armor Boss Weak");
                            bossHpRemaining = chooseHpBoss - (arrAtkExSkillAbility[0][0] * 2);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else{//Kondisi jika User memilih Opsi Boss yang tidak ada
                        System.out.println("Opsi Boss tidak tersedia!");
                    }

                }else if(yesNo.equalsIgnoreCase("n")){//Kondisi jika User memilih NO
                    System.out.println("1. " + arrBoss[0]);
                    System.out.println("2. " + arrBoss[1]);
                    System.out.println("3. " + arrBoss[2]);
                    System.out.print("Pilih Boss untuk diserang: ");
                    chooseBoss = new Scanner(System.in).nextByte();
                    chooseBoss -= 1;
                    System.out.println("-----------------------------------------------------------------");
                    
                    if(chooseBoss == 0){//Kondisi jika User memilihih Kaiten FX MK 0
                        /*
                         * Light Armor :
                         * Eksplosion = Weak
                         * Penetration = Resist
                         * Mystic = Normal
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                                System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[0][0]);
                                System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + arrAtkPasifUniqueEquipment[0][0]);
                                bossHpRemaining = chooseHpBoss - arrAtkPasifUniqueEquipment[0][0];
                                System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 1){//Kondisi jika User memilih Binah
                        /*
                         * Heavy Armor :
                         * Eksplosion = Normal
                         * Penetration = Weak
                         * Mystic = Resist
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[0][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[0][0] - arrAtkPasifUniqueEquipment[0][0] * 0.30)  + " karena DMG RES");
                            bossHpRemaining = chooseHpBoss - (arrAtkPasifUniqueEquipment[0][0] - arrAtkPasifUniqueEquipment[0][0] * 0.30);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 2){//Kondisi jika User memilih Perorodzilla
                        /*
                         * Special Armor :
                         * Eksplosion = Resist
                         * Penetration = Normal
                         * Mystic = Weak
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        int chooseHealthPoint = new Scanner(System.in).nextInt();

                        if(chooseHealthPoint >= 750 && chooseHealthPoint <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[0][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[0][0] * 2)   + " karena Armor Boss Weak");
                            bossHpRemaining = chooseHealthPoint - (arrAtkPasifUniqueEquipment[0][0] * 2);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }
                        
                    }else{//Kondisi jika User memilih Opsi Boss yang tidak ada
                        System.out.println("Opsi Boss tidak tersedia!");
                    }

                }else{//Kondisi jika User memilih char selain (y/n)
                    System.out.println("Berikan input yang valid!");
                }
                
            }else if(chooseChar.equalsIgnoreCase(arrChar[0][1])){//Kondisi jika User memilih Sorasaki Hina || Eksplosion
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Academy dari Character yang anda pilih: " + arrAcademy[0] + " - " + arrChar[0][1]);
                System.out.println("Attack Type Character: " + arrAtkTypeChar[0][1]);
                System.out.println("EX Skill Character: " + arrExSkill[0][1]);
                System.out.println("UniqueEquipment Character: " + arrUniqueEquipment[0][1]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Character dan EX Skill:");
                System.out.println("1. Nama Character: " + arrChar[0][1]);
                System.out.println("2. EX Skill: " + arrExSkill[0][1] + " -> " + arrExSkillAbility[0][1]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Cek pasif Unique Equipment:");
                System.out.println(arrUniqueEquipment[0][1] + " -> " + arrAtkPasifUniqueEquipment[0][1] + " damage / shot");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Boss: ");
                System.out.println(arrBoss[0] + " memiliki armor bertipe " + arrArmorType[0]+ " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[2]));
                System.out.println(arrBoss[1] + " memiliki armor bertipe " + arrArmorType[1]+ " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[3]));
                System.out.println(arrBoss[2] + " memiliki armor bertipe " + arrArmorType[2]+ " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[4]));
                System.out.println("-----------------------------------------------------------------");
                System.out.print("Apakah anda ingin mencoba EX Skill? (y/n): ");
                String yesNo = new Scanner(System.in).next();
                
                if(yesNo.equalsIgnoreCase("y")){//Kondisi jika User Menginput 'Y'
                    System.out.print("Masukan HealtPoint " + arrBoss[0] + " (750 - 1500): ");
                    chooseHpKaiten = new Scanner(System.in).nextInt();

                    if(chooseHpKaiten >= 750 && chooseHpKaiten <= 1500){//Kondisi jika User memilih HP Kaiten lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                        System.out.print("Masukan HealtPoint " + arrBoss[1] + " (750 - 1500): ");
                        chooseHpBinah = new Scanner(System.in).nextInt();

                        if(chooseHpBinah >= 750 && chooseHpBinah <= 1500){//Kondisi jika User memilih HP Binah lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.print("Masukan HealtPoint " + arrBoss[2] + " (750 - 1500): ");
                            chooseHpPerorodzilla = new Scanner(System.in).nextInt();

                            if(chooseHpPerorodzilla >= 750 && chooseHpPerorodzilla <= 1500){//Kondisi jika User memilih HP Perorodzilla lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                                System.out.println("-----------------------------------------------------------------");
                                System.out.println("Anda telah menggunakan EX Skill " + arrExSkill[0][1]);
                                System.out.println(arrBoss[0] + " terkena serangan sebesar " + (arrAtkExSkillAbility[0][1] * 2)  + " karena Armor Boss Weak");
                                System.out.println(arrBoss[1] + " terkena serangan sebesar " + arrAtkExSkillAbility[0][1]);
                                System.out.println(arrBoss[2] + " terkena serangan sebesar " + (arrAtkExSkillAbility[0][1] - arrAtkExSkillAbility[0][1] * 0.3) + " karena DMG RES");
                                System.out.println("-----------------------------------------------------------------");
                                kaitenHpRemaining = chooseHpKaiten - (arrAtkExSkillAbility[0][1] * 2);
                                System.out.println("Healthpoint " + arrBoss[0] + " tersisa " + kaitenHpRemaining);
                                binahHpRemaining = chooseHpBinah - arrAtkExSkillAbility[0][1];
                                System.out.println("Healthpoint " + arrBoss[1] + " tersisa " + binahHpRemaining);
                                perorodzillaHpremaining = chooseHpPerorodzilla - (arrAtkExSkillAbility[0][1] - arrAtkExSkillAbility[0][1] * 0.3);
                                System.out.println("Healthpoint " + arrBoss[2] + " tersisa " + perorodzillaHpremaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");

                            }else{
                                System.out.println("HP harus sesuai range input");
                            }
                        }else{
                            System.out.println("HP harus sesuai range input");//Ketiga else disini merupakan kondisi jika User memilih HP yang tidak memenuhi syarat pemilihan HP
                        }
                    }else{
                        System.out.println("HP harus sesuai range input");
                    }

                }else if(yesNo.equalsIgnoreCase("n")){//Kondisi jika User memilih NO
                    System.out.println("1. " + arrBoss[0]);
                    System.out.println("2. " + arrBoss[1]);
                    System.out.println("3. " + arrBoss[2]);
                    System.out.print("Pilih Boss untuk diserang: ");
                    chooseBoss = new Scanner(System.in).nextByte();
                    chooseBoss -= 1;
                    System.out.println("-----------------------------------------------------------------");
                    
                    if(chooseBoss == 0){//Kondisi jika User memilihih Kaiten FX MK 0
                        /*
                         * Light Armor :
                         * Eksplosion = Weak
                         * Penetration = Resist
                         * Mystic = Normal
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                                System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[0][1]);
                                System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[0][1] * 2)   + " karena Armor Boss Weak");
                                bossHpRemaining = chooseHpBoss - (arrAtkPasifUniqueEquipment[0][1] * 2);
                                System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 1){//Kondisi jika User memilih Binah
                        /*
                         * Heavy Armor :
                         * Eksplosion = Normal
                         * Penetration = Weak
                         * Mystic = Resist
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[0][1]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + arrAtkPasifUniqueEquipment[0][1]);
                            bossHpRemaining = chooseHpBoss - arrAtkPasifUniqueEquipment[0][1];
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 2){//Kondisi jika User memilih Perorodzilla
                        /*
                         * Special Armor :
                         * Eksplosion = Resist
                         * Penetration = Normal
                         * Mystic = Weak
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[0][1]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[0][1] - arrAtkPasifUniqueEquipment[0][1] * 0.30)  + " karena DMG RES");
                            bossHpRemaining = chooseHpBoss - (arrAtkPasifUniqueEquipment[0][1] - arrAtkPasifUniqueEquipment[0][1] * 0.30);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else{//Kondisi jika User memilih Opsi Boss yang tidak ada
                        System.out.println("Opsi Boss tidak tersedia!");
                    }

                }else{//Kondisi jika User memilih char selain "Y"/"y" dan "N"/"n" 
                    System.out.println("Berikan input yang valid!");
                }
            
            }else if(chooseChar.equalsIgnoreCase(arrChar[1][0])){//Kondisi jika User memilih Misono Mika || Penetration
                System.out.println("Academy dari Character yang anda pilih: " + arrAcademy[1] + " - " + arrChar[1][0]);
                System.out.println("Attack Type Character: " + arrAtkTypeChar[1][0]);
                System.out.println("EX Skill Character: " + arrExSkill[1][0]);
                System.out.println("UniqueEquipment Character: " + arrUniqueEquipment[1][0]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Character dan EX Skill:");
                System.out.println("1. Nama Character: " + arrChar[1][0]);
                System.out.println("2. EX Skill: " + arrExSkill[1][0] + " -> " + arrExSkillAbility[1][0]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Cek pasif Unique Equipment:");
                System.out.println(arrUniqueEquipment[1][0] + " -> " + arrAtkPasifUniqueEquipment[1][0] + " damage / shot");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Boss: ");
                System.out.println(arrBoss[0] + " memiliki armor bertipe " + arrArmorType[0] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[2]));
                System.out.println(arrBoss[1] + " memiliki armor bertipe " + arrArmorType[1] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[3]));
                System.out.println(arrBoss[2] + " memiliki armor bertipe " + arrArmorType[2] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[4]));
                System.out.println("-----------------------------------------------------------------");
                System.out.print("Apakah anda ingin mencoba EX Skill? (y/n): ");
                String yesNo = new Scanner(System.in).next();

                if(yesNo.equalsIgnoreCase("y")){//Kondisi jika User menginput "y"/"Y"
                    System.out.println("1. " + arrBoss[0]);
                    System.out.println("2. " + arrBoss[1]);
                    System.out.println("3. " + arrBoss[2]);
                    System.out.print("Pilih Boss untuk diserang: ");
                    chooseBoss = new Scanner(System.in).nextByte();
                    chooseBoss -= 1;
                    System.out.println("-----------------------------------------------------------------");
                    
                    if(chooseBoss == 0){//Kondisi jika User memilihih Kaiten FX MK 0
                        /*
                         * Light Armor :
                         * Eksplosion = Weak
                         * Penetration = Resist
                         * Mystic = Normal
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                                System.out.println("Anda telah menggunakan menggunakan EX Skill " + arrExSkill[1][0]);
                                System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkExSkillAbility[1][0] - arrAtkExSkillAbility[1][0] * 0.30)  + " karena DMG RES");
                                bossHpRemaining = chooseHpBoss - (arrAtkExSkillAbility[1][0] - arrAtkExSkillAbility[1][0] * 0.30);
                                System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 1){//Kondisi jika User memilih Binah
                        /*
                         * Heavy Armor :
                         * Eksplosion = Normal
                         * Penetration = Weak
                         * Mystic = Resist
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan menggunakan EX Skill " + arrExSkill[1][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkExSkillAbility[1][0] * 2)   + " karena Armor Boss Weak");
                            bossHpRemaining = chooseHpBoss - (arrAtkExSkillAbility[1][0] * 2);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 2){//Kondisi jika User memilih Perorodzilla
                        /*
                         * Special Armor :
                         * Eksplosion = Resist
                         * Penetration = Normal
                         * Mystic = Weak
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){//Kondisi jika User memilih HP lebih dari sama dengan 750 dan kurang dari sama dengan 1500
                            System.out.println("Anda telah menggunakan menggunakan EX Skill " + arrExSkill[1][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + arrAtkExSkillAbility[1][0]);
                            bossHpRemaining = chooseHpBoss - arrAtkExSkillAbility[1][0];
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                        }else{//Jika User memilih HP yang tidak memenuhi kondisi
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else{//Kondisi jika User memilih opsi Boss yang tidak ada
                        System.out.println("Opsi Boss tidak tersedia!");
                    }
                }else if(yesNo.equalsIgnoreCase("n")){
                    System.out.println("1. " + arrBoss[0]);
                    System.out.println("2. " + arrBoss[1]);
                    System.out.println("3. " + arrBoss[2]);
                    System.out.print("Pilih Boss untuk diserang: ");
                    chooseBoss = new Scanner(System.in).nextByte();
                    chooseBoss -= 1;
                    System.out.println("-----------------------------------------------------------------");
                    
                    if(chooseBoss == 0){//Kondisi jika User memilihih Kaiten FX MK 0
                        /*
                         * Light Armor :
                         * Eksplosion = Weak
                         * Penetration = Resist
                         * Mystic = Normal
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){
                                System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[1][0]);
                                System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[1][0] - arrAtkPasifUniqueEquipment[1][0] * 0.30)  + " karena DMG RES");
                                bossHpRemaining = chooseHpBoss - (arrAtkPasifUniqueEquipment[1][0] - arrAtkPasifUniqueEquipment[1][0] * 0.30);
                                System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                            
                        }else{
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 1){//Kondisi jika User memilih Binah
                        /*
                         * Heavy Armor :
                         * Eksplosion = Normal
                         * Penetration = Weak
                         * Mystic = Resist
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[1][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[1][0] * 2) + " karena Armor Boss Weak");
                            bossHpRemaining = chooseHpBoss - (arrAtkPasifUniqueEquipment[1][0] * 2);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");

                        }else{
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 2){//Kondisi jika User memilih Perorodzilla
                        /*
                         * Special Armor :
                         * Eksplosion = Resist
                         * Penetration = Normal
                         * Mystic = Weak
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[1][0]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + arrAtkPasifUniqueEquipment[1][0]);
                            bossHpRemaining = chooseHpBoss - arrAtkPasifUniqueEquipment[1][0];
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");

                        }else{
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else{
                        System.out.println("Opsi Boss tidak tersedia!");
                    }

                }else{
                    System.out.println("Berikan input yang valid!");
                }
            
            }else if(chooseChar.equalsIgnoreCase(arrChar[1][1])){//Kondisi jika User memilih Kirifuji Nagisa || Eksplosion
                System.out.println("Academy dari Character yang anda pilih: " + arrAcademy[1] + " - " + arrChar[1][1]);
                System.out.println("Attack Type Character: " + arrAtkTypeChar[1][1]);
                System.out.println("EX Skill Character: " + arrExSkill[1][1]);
                System.out.println("UniqueEquipment Character: " + arrUniqueEquipment[1][1]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Character dan EX Skill:");
                System.out.println("1. Nama Character: " + arrChar[1][1]);
                   System.out.println("2. EX Skill: " + arrExSkill[1][1] + " -> " + arrExSkillAbility[1][1]);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Cek pasif Unique Equipment:");
                System.out.println(arrUniqueEquipment[1][1] + " -> " + arrAtkPasifUniqueEquipment[1][1] + " damage / shot");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Check status Boss: ");
                System.out.println(arrBoss[0] + " memiliki armor bertipe " + arrArmorType[0] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[2]));
                System.out.println(arrBoss[1] + " memiliki armor bertipe " + arrArmorType[1] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[3]));
                System.out.println(arrBoss[2] + " memiliki armor bertipe " + arrArmorType[2] + " yang rentan terhadap tipe Attack -> " + Arrays.toString(arrAtkTypeChar[4]));
                System.out.println("-----------------------------------------------------------------");
                System.out.print("Apakah anda ingin mencoba EX Skill? (y/n): ");
                String yesNo = new Scanner(System.in).next();

                if(yesNo.equalsIgnoreCase("y")){
                    System.out.print("Masukan HealtPoint " + arrBoss[0] + " (750 - 1500): ");
                    chooseHpKaiten = new Scanner(System.in).nextInt();

                    if(chooseHpKaiten >= 750 && chooseHpKaiten <= 1500){
                        System.out.print("Masukan HealtPoint " + arrBoss[1] + " (750 - 1500): ");
                        chooseHpBinah = new Scanner(System.in).nextInt();

                        if(chooseHpBinah >= 750 && chooseHpBinah <= 1500){
                            System.out.print("Masukan HealtPoint " + arrBoss[2] + " (750 - 1500): ");
                            chooseHpPerorodzilla = new Scanner(System.in).nextInt();

                            if(chooseHpPerorodzilla >= 750 && chooseHpPerorodzilla <= 1500){
                                System.out.println("-----------------------------------------------------------------");
                                System.out.println("Anda telah menggunakan EX Skill " + arrExSkill[1][1]);
                                System.out.println(arrBoss[0] + " terkena serangan sebesar " + (arrAtkExSkillAbility[1][1] * 2)  + " karena Armor Boss Weak");
                                System.out.println(arrBoss[1] + " terkena serangan sebesar " + arrAtkExSkillAbility[1][1]);
                                System.out.println(arrBoss[2] + " terkena serangan sebesar " + (arrAtkExSkillAbility[1][1] - arrAtkExSkillAbility[1][1] * 0.3) + "karena DMG RES");
                                System.out.println("-----------------------------------------------------------------");
                                kaitenHpRemaining = chooseHpKaiten - (arrAtkExSkillAbility[1][1] * 2);
                                System.out.println("Healthpoint " + arrBoss[0] + " tersisa " + kaitenHpRemaining);
                                binahHpRemaining = chooseHpBinah - arrAtkExSkillAbility[1][1];
                                System.out.println("Healthpoint " + arrBoss[1] + " tersisa " + binahHpRemaining);
                                perorodzillaHpremaining = chooseHpPerorodzilla - (arrAtkExSkillAbility[1][1] - arrAtkExSkillAbility[1][1] * 0.3);
                                System.out.println("Healthpoint " + arrBoss[2] + " tersisa " + perorodzillaHpremaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                            }else{
                                System.out.println("HP harus sesuai range input");
                            }

                        }else{
                            System.out.println("HP harus sesuai range input");
                        }

                    }else{
                        System.out.println("HP harus sesuai range input");
                    }

                }else if(yesNo.equalsIgnoreCase("n")){
                    System.out.println("1. " + arrBoss[0]);
                    System.out.println("2. " + arrBoss[1]);
                    System.out.println("3. " + arrBoss[2]);
                    System.out.print("Pilih Boss untuk diserang: ");
                    chooseBoss = new Scanner(System.in).nextByte();
                    chooseBoss -= 1;
                    System.out.println("-----------------------------------------------------------------");

                    if(chooseBoss == 0){//Kondisi jika User memilihih Kaiten FX MK 0
                        /*
                         * Light Armor :
                         * Eksplosion = Weak
                         * Penetration = Resist
                         * Mystic = Normal
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        int chooseHealthPoint = new Scanner(System.in).nextInt();

                        if(chooseHealthPoint >= 750 && chooseHealthPoint <= 1500){
                                System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[1][1]);
                                System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[1][1] * 2) + " karena Armor Boss Weak");
                                bossHpRemaining = chooseHealthPoint - (arrAtkPasifUniqueEquipment[1][1] * 2);
                                System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                                System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");
                            
                        }else{
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 1){//Kondisi jika User memilih Binah
                        /*
                         * Heavy Armor :
                         * Eksplosion = Normal
                         * Penetration = Weak
                         * Mystic = Resist
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[1][1]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + arrAtkPasifUniqueEquipment[1][1]);
                            bossHpRemaining = chooseHpBoss - arrAtkPasifUniqueEquipment[1][1];
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");

                        }else{
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else if(chooseBoss == 2){//Kondisi jika User memilih Perorodzilla
                        /*
                         * Special Armor :
                         * Eksplosion = Resist
                         * Penetration = Normal
                         * Mystic = Weak
                         */
                        System.out.print("Masukkan Healthpoint " + arrBoss[chooseBoss] + "(750 - 1500): ");
                        chooseHpBoss = new Scanner(System.in).nextInt();

                        if(chooseHpBoss >= 750 && chooseHpBoss <= 1500){
                            System.out.println("Anda telah menggunakan Unique Equipment " + arrUniqueEquipment[1][1]);
                            System.out.println(arrBoss[chooseBoss] + " terkena serangan sebesar " + (arrAtkPasifUniqueEquipment[1][1] - arrAtkPasifUniqueEquipment[1][1] * 0.30)  + " karena DMG RES");
                            bossHpRemaining = chooseHpBoss - (arrAtkPasifUniqueEquipment[1][1] - arrAtkPasifUniqueEquipment[1][1] * 0.30);
                            System.out.println("Healthpoint " + arrBoss[chooseBoss] + " tersisa " + bossHpRemaining);
                            System.out.println("Terima Kasih sudah menyelesaikan Daily Raid Hari ini!");

                        }else{
                            System.out.println("HP harus sesuai range input!");
                        }

                    }else{
                        System.out.println("Opsi Boss tidak tersedia!");
                    }

                }else{
                    System.out.println("Berikan input yang valid!");
                }
                
            }else{
                System.out.println("Maaf Character Yang Anda Pilih Tidak Tersedia");
            }
            
        }else{
            System.out.println("Maaf Roster Yang Anda Pilih Tidak Tersedia!");
        }    
        System.out.println("-----------------------------------------------------------------");
    }   
}
