/**
 * Nama: Azhar Aulia Priatna
 * NPM: 1402024013
 */

import java.util.*;//mengimport seluruh liblary yang ada di package java/util
public class AA_1402024013 {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);//scanner untuk menerima inputan dari user
        String[] arrCharName = {"Speedwagon", "Gojo ", "Bulma", "Choso", "Gon  ", "Guts ", "Araragi", "Sasuke", "Tengen", "Artoria", "Homura", "Usopp", "Dazai", "Asuna", "Tatsumaki"};//kumpulan nama character, dibaca sesuai index
        String[] arrCharEvolve = {"(Founder)", "(Six Eyes)", "(Mother)", "(Big Bro)", "(Adult)", "(Berserk)", "(KING)", "(Eternal)", "(Flashiness Master)", "(Avalon le Fae)", "(Magical Girl)", "(God)", "(No Longer Human)", "(Flash)", "(Tornado)"};//kumpulan nama evolusi character, dibaca sesuai index
        boolean[] arrTypeDamage = {false, true, false, true, true, true, true, true, true, true, true, true, true, true, true};//cek apakah character sesuai index bertipe damage? jika iya maka true, dibaca sesuai index
        boolean[] arrTypeFarm = {true, false, true, false, false, false, false, false, false, false, false, false, false, false, false};//cek apakah character sesuai index bertipe farm? jika iya maka true, dibaca sesuai index
        double[] arrBaseDamage = {0, 300.0, 0, 1500.0, 5000.0, 2500.0, 7000.0, 2000.0, 3000.0, 2300.0, 3200.0, 2000.0, 4500.0, 2200.0, 1900.0};//kumpulan damage character, dibaca sesuai index
        double[] arrBaseFarm = {250, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//kumpulan yen production character, dibaca sesuai index
        String[] arrCharPrice = {"¥500", "¥1800", "¥800", "¥1200", "¥2000", "¥1600", "¥20000", "¥1200", "¥1500", "¥1100", "¥1400", "¥1000", "¥1800", "¥1450", "¥1000"};//kumpulan harga character
        boolean[] arrSelectedChar = new boolean[15];//untuk mengecek jika character terpilih di party maka indexnya akan diberi nilai true
        int[] arrPlaceLimit = {3, 3, 1, 4, 1, 3, 1, 4, 3, 4, 3, 5, 2, 3, 5};//kumpulan place limit character, dibaca sesuai index

        //deklarasi array, nantinya akan diisi oleh character terpilih di party
        String[] arrParty =  new String[6];
        String[] arrPartyEvolve = new String[6];
        boolean[] arrPartyDmg = new boolean[6];
        boolean[] arrPartyFarm = new boolean[6];
        double[] arrPartyBaseDmg = new double[6];
        double[] arrPartyBaseFarm = new double[6];
        int[] arrPartyPlaceLimit = new int[6];
        double[] arrPartyDmgBuff =  new double[6];
        double[] arrPartyFarmBuff =  new double[6];

        boolean[] arrCharEvolved = {false, false, false, false, false, false};//array of boolean untuk mengecek apakah character tersebut sudah di evolve atau belum, jika sudah maka nilainya akan diubah menjadi true
        boolean[] arrCharTraited = {false, false, false, false, false, false};//array of boolean untuk mengecek apakah character tersebut sudah di trait atau belum, jika sudah maka nilainya akan diubah menjadi true
        double[] arrTraitsDmgBuff = {3, 0.4, 0.5, 0};//kumpulan trait buff untuk character bertipe damage
        String[] arrTraits = {"Unique", "Golden", "Devine", "Celestial"};//kumpulan nama traits
        String[] arrTraitsSuccses = {"Unique unit gain 300% damage boost BUT limit the unit placement to 1", "Golden unit gain 40% damage boost for non-farm units, gain extra 15% Yen gain for farm units", "Devine unit gain 50% damage boost", "Celestial unit hace their placement limit double"};//kumpulan kata-kata jika trait nya sukses
        byte slot, selectActivity, selectChar, selectTraits;//tipe data byte, yang nantinya akan diisi sesuai dengan input user
        String yN;//tipe data string yang nantinya akan bernilai sesuai dengan inputan user
        boolean restart = false;//tipe data boolean untuk mengulang program, nantinya user ingin mengulang program, maka nilainya akan berubah menjadi true
        System.out.println("=================================================================================================");
        System.out.println("Program AA Tower Defense");
        System.out.println("Dibuat oleh: Azhar Aulia Priatna/1402024013");
        System.out.println("Playable: No");
        System.out.println("=================================================================================================");
        System.out.println("Character List:");
        for(int i = 0 ; i < arrCharName.length ; i++){//for untuk memanggil seluruh list dari nama, harga, place limit dari character
            System.out.println((i+1) + ". " + arrCharName[i] + "\t\t" + arrCharPrice[i] + "\t\t" + arrPlaceLimit[i] + " Placement Limit");
        }
        System.out.println("Assemble a party: ");
        for(int i = 0; i < arrParty.length; i++){//for untuk mengulang program selama i masih kurang dari panjang arrParty
            System.out.print("Slot " + (i+1) + ": ");
            slot = userInput.nextByte();
            slot -= 1;
          
            if(arrSelectedChar[slot]){//jika jika salah satu index dari arrSelectedChar sudah bernilai true 
                System.out.println(arrCharName[slot] + " is already in party, please pick another character");
                i--;
            }else{//jika kondisi diatas tidak terpenuhi
                arrSelectedChar[slot] = true;//salah satu index sesuai dengan inputan user dari arrSelectedChar akan diubah menjadi true,
                //pemindahan array yang awalnya sebanyak 15 element menjadi 6 element karena sudah masuk party
                arrParty[i] = arrCharName[slot];
                arrPartyEvolve[i] = arrCharEvolve[slot];
                arrPartyDmg[i] = arrTypeDamage[slot];
                arrPartyFarm[i] = arrTypeFarm[slot];
                arrPartyBaseDmg[i] = arrBaseDamage[slot];
                arrPartyDmgBuff[i] = arrBaseDamage[slot];
                arrPartyBaseFarm[i] = arrBaseFarm[slot];
                arrPartyPlaceLimit[i] = arrPlaceLimit[slot];
                System.out.println(arrParty[i] + " picked");
            }
        }
        System.out.println("=================================================================================================");
        do { //melakukan pengulangan minimal 1 kali apabila kondisi tidak terpenuhi
            System.out.println("Paty List:");
            for(int i = 0 ; i < arrParty.length ; i++){//memanggil seluruh element dari character yang sudah dimasukan ke party
                System.out.print((i+1) + "." + arrParty[i] + ", ");
            }
            System.out.println("\nActivities");
            System.out.println("1. Play\n2. Traits\n3. Evolve Unit");
            System.out.print("Select Activities: ");
            selectActivity = userInput.nextByte();
            

            

            switch (selectActivity) {//struktur switch untuk meminta kondisi
                
                case 2 ://jika user memilih activity kedua
                    System.out.println("=================================================================================================");
                    System.out.println("Wich character are you putting traits on?");
                    for(int i = 0 ; i < arrParty.length ; i++){//for untuk memanggil seluruh element array yang ada di arrParty
                        System.out.println((i+1) + ". " + arrParty[i]);
                    }
                    System.out.print("Select a character: ");
                    selectChar = userInput.nextByte();
                    selectChar--;

                    if(!arrCharTraited[selectChar]){//cek apakah character yang dipilih sudah pernah di trait apa belum
                        
                        System.out.println("=================================================================================================");
                        
                        System.out.println("Traits list:");
                        for(int i = 0 ; i < arrTraits.length ; i++){
                            System.out.println((i+1) + ". " + arrTraits[i]);//memanggil seluruh element arrtraits
                        }
                        System.out.print("Select a trait: ");
                        selectTraits = userInput.nextByte();
                        selectTraits -= 1;

                    
                        System.out.println("You are putting " + arrTraits[selectTraits] + " on " + arrParty[selectChar]);
                        System.out.print("Are you sure?(Y/N)");
                        yN = userInput.next();
                        if(yN.equalsIgnoreCase("y")){
                            arrCharTraited[selectChar] = true;//jika salah satu character di trait, maka salah satu index dari  arrCharTraited menjadi true agar tidak bisa di trait lagi
                            arrParty[selectChar] = arrTraits[selectTraits] + " " + arrParty[selectChar];
                                System.out.println("Your " + arrParty[selectChar].substring(arrParty[selectChar].indexOf(" ")) + " has become " + arrParty[selectChar]);
                                System.out.println(arrTraitsSuccses[selectTraits]);
                            if(arrPartyDmg[selectChar] && selectTraits == 1){//jika use memilih trait golden dan characternya bertipe damage
                                System.out.println(arrParty[selectChar] + " is not a farm unit, " + arrParty[selectChar] + " will gain 40% damage boost");
                                System.out.println("Your " + arrParty[selectChar] + " damage has increased from " + arrPartyBaseDmg[selectChar] + " -> " + ((arrPartyDmgBuff[selectChar]  * arrTraitsDmgBuff[selectTraits]) + arrPartyBaseDmg[selectChar]));
                                arrPartyBaseDmg[selectChar] = (arrPartyDmgBuff[selectChar]  * arrTraitsDmgBuff[selectTraits]) + arrPartyBaseDmg[selectChar]; 
                            }else if(arrPartyFarm[selectChar] && selectTraits == 1){//jika use memilih trait golden dan characternya bertipe farm
                                System.out.println(arrParty[selectChar] + " is a farm unit, " + arrParty[selectChar] + " will gain 15% Yen Production");
                                arrPartyFarmBuff[selectChar] = (arrPartyBaseFarm[selectChar]  * 0.15) + arrPartyBaseFarm[selectChar];
                                System.out.println("Your " + arrParty[selectChar] + " Yen Production has increased from " + (int)arrPartyBaseFarm[selectChar] + " -> " + (int)arrPartyFarmBuff[selectChar]);
                                arrPartyBaseFarm[selectChar] = arrPartyFarmBuff[selectChar]; //menyimpan nilai yen production yang sudah di buff
                            }else if(selectTraits == 0){//jika user memilih unique
                                System.out.println("Your " + arrParty[selectChar] + " damage has increased from " + arrPartyBaseDmg[selectChar] + " -> " + ((arrPartyDmgBuff[selectChar]  * arrTraitsDmgBuff[selectTraits]) + arrPartyBaseDmg[selectChar]));
                                arrPartyBaseDmg[selectChar] = (arrPartyDmgBuff[selectChar]  * arrTraitsDmgBuff[selectTraits]) + arrPartyBaseDmg[selectChar]; 
                                arrPartyPlaceLimit[selectChar] = 1;
                            }else if(selectTraits == 2){//jika user memilih devine
                                System.out.println("Your " + arrParty[selectChar] + " damage has increased from " + arrPartyBaseDmg[selectChar] + " -> " + ((arrPartyDmgBuff[selectChar]  * arrTraitsDmgBuff[selectTraits]) + arrPartyBaseDmg[selectChar]));
                                arrPartyBaseDmg[selectChar] = (arrPartyDmgBuff[selectChar]  * arrTraitsDmgBuff[selectTraits]) + arrPartyBaseDmg[selectChar];
                            }else if(selectTraits == 3){//jika user celestial
                                System.out.println(arrParty[selectChar] + " placement limit has doubled from " + arrPartyPlaceLimit[selectChar] + " -> " + (arrPartyPlaceLimit[selectChar]*2));
                                arrPartyPlaceLimit[selectChar] *= 2;
                            }
                        }
                    }else{//jika kondisi idak terpenuhi
                        System.out.println("Character Already Traited");
                    }
                    break;
                //jika evolve
                case 3 ://jika user memilih activity ketiga
                    System.out.println("=================================================================================================");
                    System.out.println("Wich character are you evolving?");
                    for(int i = 0 ; i < arrParty.length ; i++){
                        System.out.println((i+1) + ". " + arrParty[i]);
                    }
                    System.out.print("Select a character: ");
                    selectChar = userInput.nextByte();
                    selectChar--;//dikurang 1 agar sesuai dengan index
                
                    if(!arrCharEvolved[selectChar]){
                        System.out.println("=================================================================================================");
                        System.out.println("Character " + arrParty[selectChar] + " will evolve to " + arrParty[selectChar] + arrPartyEvolve[selectChar] );
                        System.out.print("Are you sure?(Y/N)");
                        yN = userInput.next();
                        if(yN.equalsIgnoreCase("y")){
                                arrCharEvolved[selectChar] = true;//nilai boolean diubah menjadi true, agar character yang sudah di evolve tidak dapat di evolve lagi
                                arrParty[selectChar] += arrPartyEvolve[selectChar];
                                System.out.println(arrParty[selectChar] + " damage has increased from " +  arrPartyBaseDmg[selectChar] + " -> " + ((arrPartyDmgBuff[selectChar]  * (50.0 / 100)) + arrPartyBaseDmg[selectChar]));
                                arrPartyBaseDmg[selectChar] = (arrPartyDmgBuff[selectChar]  * (50.0 / 100)) + arrPartyBaseDmg[selectChar];//menyimpan damage yang sudah di buff
                        }else if(yN.equalsIgnoreCase("n")){
                            System.out.println("Evolution cancelled");
                        }
                    }else{
                        System.out.println("Character Already Evolved");
                    }
                break;
                    
                default:
                System.out.println("Invalid Activity");
                break;
            }




            
            System.out.println("=================================================================================================");
            for(;;){//ninfinite loop, akan berhenti ketika di break
                System.out.println("Stop The Program? ");
                yN = userInput.next();
                if(yN.equalsIgnoreCase("y")){
                    restart = false;
                    System.out.println("Stopping Program");
                    break;
                }else if(yN.equalsIgnoreCase("n")){
                    restart = true;
                    break;//break untuk keluar dari infinite loop
                }else{
                    System.out.println("invalid");
                }
            }
            System.out.println("=================================================================================================");

        } while (restart);
    }
}




