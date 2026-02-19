import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

public class tes {
    // Banner pembuka, silakan manfaatkan variabel ini untuk menampilkan banner di awal dan di akhir program
    private static final String BANNER = "";
    private static final String STUDENT_NAME = "";
    private static final String STUDENT_ID = "";


    // Penanda atribut, silakan manfaatkan variabel ini untuk menandai atribut di dalam data
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static int questId = 1;
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static int travelerId = 1;
    private static final char LEVEL_IDENTIFIER = '$';

    private static final int MAX_EXP = 1_310_720_000;

    // Scanner untuk input, silakan manfaatkan variabel ini untuk mengambil input dari user
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // TODO: Tampilkan banner
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        // TODO: Seeding data quest dan pengembara
        int questCount = 0;
        int travelerCount = 0;
        boolean invalidInput = true;

        // TODO: Input banyak quest dan pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            String questCountInput = input.nextLine();
            // TODO: Validasi input jumlah quest
            if(questCountInput.matches("^[0-9]+$")){
                questCount = Integer.parseInt(questCountInput);
                if(questCount > 0){
                    invalidInput = false;
                }
            }else{
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
            System.out.println();
        }
        
        // TODO: Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // TODO: Validasi input jumlah pengembara
            if(travelerCountInput.matches("^[0-9]+$")){
                travelerCount = Integer.parseInt(travelerCountInput);
                if(travelerCount > 0){
                    invalidInput = false;
                }
            }else{
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
            System.out.println();
        }
        System.out.println();

        String questData = "";
        String travelerData = "";
        System.out.println("Mulai memasukkan data quest.");
        // TODO: Input data quest sebanyak quest yang diminta
        for (int i = 0; i < questCount; i++) {
            System.out.println("Quest " + (i+1));
            String nameQuest;
            String deskQuest;
            long rewardQuest;
            long expQuest;
            boolean invalidQuest = true;
            String diffQuest = "\u2605\u2605\u2605";
            String status = "tersedia \ud83d\udfe2";
            
            while (invalidQuest) {
                System.out.println("Masukkan nama quest: ");
                String nameInp = input.nextLine();
                System.out.println("Masukkan deskripsi Quest: ");
                String deskInp = input.nextLine();
                System.out.println("Masukkan reward quest berupa bilangan bulat non-negatif: ");
                String rewardInp = input.nextLine();
                System.out.println("Masukkan bonus exp quest berupa bilangan bulat non-negatif: ");
                String expInp = input.nextLine();
                System.out.println("Masukkan tingkat kesulitan quest (opsi : mudah, menengah, sulit)");
                String diffInp = input.nextLine();
    
                // TODO: Validasi semua input Quest
                if(nameInp.matches("^[a-zA-Z0-9\\s]+$") && deskInp.matches("^[a-zA-Z0-9\\s]+$")){
                    nameQuest = nameInp;
                    deskQuest = deskInp;
                    if(expInp.matches("^[0-9]+$$") && rewardInp.matches("^[0-9]+$$")){
                        rewardQuest = Integer.parseInt(rewardInp);
                        expQuest = Integer.parseInt(expInp);
                        if(rewardQuest > 0 && expQuest > 0 ){
                            switch (diffInp.toLowerCase()) {
                                case "mudah":
                                    questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest +  EXP_IDENTIFIER + expQuest + DIFFICULTY_IDENTIFIER + diffQuest.substring(0,1) + STATUS_IDENTIFIER + status + "\n";
                                    invalidQuest = false;
                                    break;
    
                                case "menengah":
                                    questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest +  EXP_IDENTIFIER + expQuest + DIFFICULTY_IDENTIFIER + diffQuest.substring(0,2) + STATUS_IDENTIFIER + status + "\n";
                                    invalidQuest = false;
                                    break;
    
                                case "sulit":
                                    questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest +  EXP_IDENTIFIER + expQuest + DIFFICULTY_IDENTIFIER + diffQuest.substring(0) + STATUS_IDENTIFIER + status + "\n";
                                    invalidQuest = false;
                                    break;
    
                                default:
                                    System.out.println("Input tingkat kesulitan salah! Harap masukkan data yang benar.");
                                    break;
                            }
                        }else{
                            System.out.println("Input exp/reward tidak valid! Harap masukkan data yang benar.");
                        }
                    }else{
                        System.out.println("Input exp/reward tidak valid! Harap masukkan data yang benar.");
                    }
                }else {
                    System.out.println("Input nama/deskripsi tidak valid! Harap masukkan data yang benar.");
                }
            }
            System.out.println();
        }

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            System.out.println("Pengembara " + (i+1));
            String nameTraveler;
            int levelTraveler;
            int exp;
            boolean invalidTravel = true;
            String status = "kosong \u2705";
            
            while (invalidTravel) {
                System.out.println("Masukkan nama Pengembara: ");
                String nameInp = input.nextLine();
                System.out.println("Masukkan level pengembara berupa bilangan bulat [1,20]: ");
                String levelInp = input.nextLine();
    
                // TODO: Validasi input pengembara
                if(nameInp.matches("^[a-zA-Z0-9\\s]+$")){
                    nameTraveler = nameInp;
                    if(levelInp.matches("^[0-9]+$")){
                        levelTraveler = Integer.parseInt(levelInp);
                        if (levelTraveler == 1){
                            exp = 0;
                            travelerData += "P" + (travelerId++) + NAME_IDENTIFIER + nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp + STATUS_IDENTIFIER + status + "\n";
                            invalidTravel = false;
                            break;
                        }else if(levelTraveler > 1 && levelTraveler <= 20){
                            exp =(int) (5000 * Math.pow(2, levelTraveler- 2));
                            travelerData += "P" + (travelerId++) + NAME_IDENTIFIER + nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp + STATUS_IDENTIFIER + status + "\n";
                            invalidTravel = false;
                            break;
                        }
                    }else{
                        System.out.println("Input level tidak valid! Harap masukkan data dengan benar.");
                    }
                }else{
                    System.out.println("Input nama tidak valid! Harap masukkan data dengan benar.");
                }
                
            }
            }
        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        boolean running = true;
        // TODO: Loop menu utama
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar quest");
            System.out.println("2. Lihat daftar pengembara");
            System.out.println("3. Tambah quest");
            System.out.println("4. Tambah pengembara");
            System.out.println("5. Menjalankan quest");
            System.out.println("6. Menyelesaikan quest");
            System.out.println("7. Filter daftar quest");
            System.out.println("8. Filter daftar pengembara");
            System.out.println("9.Tampilkan daftar quest terurut");
            System.out.println("10.Tampilkan daftar pengembara terurut");
            System.out.println("11. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println();;
                    // TODO: Tampilkan daftar quest
                    Scanner kumpulanDataQuest = new Scanner(questData);
                    while(kumpulanDataQuest.hasNext()){
                        String baris = kumpulanDataQuest.nextLine();

                        // TODO: Parsing kolom secara manual
                        int p1 = baris.indexOf(NAME_IDENTIFIER);
                        int p2 = baris.indexOf(DESC_IDENTIFIER);
                        int p3 = baris.indexOf(REWARD_IDENTIFIER);
                        int p4 = baris.indexOf(EXP_IDENTIFIER);
                        int p5 = baris.indexOf(DIFFICULTY_IDENTIFIER);
                        int p6 = baris.indexOf(STATUS_IDENTIFIER);

                        // TODO: Ambil per kategori
                        String id = baris.substring(0, p1);
                        String nama = baris.substring(p1+1, p2);
                        String desk = baris.substring(p2+1, p3);
                        String reward = baris.substring(p3+1, p4);
                        String exp = baris.substring(p4+1, p5);
                        String difficult = baris.substring(p5+1, p6);
                        String status = baris.substring(p6+1);

                        System.out.println("ID Quest: " + id);
                        System.out.println("Nama Quest: " + nama);
                        System.out.println("Deskripsi Quest: " + desk);
                        System.out.println("Reward Quest: " + reward + " poin");
                        System.out.println("Bonus exp Quest: " + exp + " poin exp");
                        System.out.println("Tingkat kesulitan quest: " + difficult);
                        System.out.println("Status Quest: " + status);
                        System.out.println();
                    }
                    break;
                case "2":
                    System.out.println();
                    // TODO: Tampilkan daftar pengembara
                    Scanner kumpulanDataTravel = new Scanner(travelerData);
                    while(kumpulanDataTravel.hasNext()){
                        String baris = kumpulanDataTravel.nextLine();

                        // TODO: Parsing kolom secara manual
                        int p1 = baris.indexOf(NAME_IDENTIFIER);
                        int p2 = baris.indexOf(LEVEL_IDENTIFIER);
                        int p3 = baris.indexOf(EXP_IDENTIFIER);
                        int p4 = baris.indexOf(STATUS_IDENTIFIER);

                        // TODO: Ambil per kategori
                        String id = baris.substring(0, p1);
                        String nama = baris.substring(p1+1, p2);
                        String level = baris.substring(p2+1, p3);
                        String exp = baris.substring(p3+1, p4);
                        String status = baris.substring(p4+1);

                        System.out.println("ID Pengembara: " + id);
                        System.out.println("Nama Pengembara: " + nama);
                        System.out.println("Level Pengembara: " + level);
                        System.out.println("Exp Pengembara: " + exp + " poin exp");
                        System.out.println("Status Pengembara: " + status);
                        System.out.println();
                    }
                    break;
                case "3":
                    // TODO: Tambah quest
                    invalidInput = true;
                    
                    while(invalidInput){
                        String nameQuest;
                        String deskQuest;
                        int rewardQuest;
                        int expQuest;
                        String diffQuest = "\u2605\u2605\u2605";
                        String status = "tersedia \ud83d\udfe2";
                        String kembali = "back";

                        System.out.println("Quest " + (questId));
                        System.out.println("Masukkan nama Quest (ketik back untuk kembali ke main menu): ");
                        String nameInp = input.nextLine();
                        if(nameInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.println("Masukkan deskripsi Quest (ketik back untuk kembali ke main menu): ");
                        String deskInp = input.nextLine();
                        if(deskInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.println("Masukkan reward quest berupa bilangan bulat non-negatif (ketik back untuk kembali ke main menu): ");
                        String rewardInp = input.nextLine();
                        if(rewardInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.println("Masukkan bonus exp quest berupa bilangan bulat non-negatif (ketik back untuk kembali ke main menu): ");
                        String expInp = input.nextLine();
                        if(expInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.println("Masukkan tingkat kesulitan quest (opsi : mudah, menengah, sulit) (ketik back untuk kembali ke main menu):");
                        String diffInp = input.nextLine();
                        if(diffInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        // TODO: Validasi input Quest
                        if(nameInp.matches("^[a-zA-Z0-9\\s]+$") && deskInp.matches("^[a-zA-Z0-9\\s]+$")){
                                nameQuest = nameInp;
                                deskQuest = deskInp;
                                if(expInp.matches("^[0-9]+$$") && rewardInp.matches("^[0-9]+$$")){
                                    rewardQuest = Integer.parseInt(rewardInp);
                                    expQuest = Integer.parseInt(expInp);
                                    if(rewardQuest > 0 && expQuest > 0 ){
                                        switch (diffInp) {
                                            case "mudah":
                                                questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest + EXP_IDENTIFIER + expQuest + DIFFICULTY_IDENTIFIER + diffQuest.substring(0,1) + STATUS_IDENTIFIER + status + "\n";
                                                invalidInput = false;
                                                break;
    
                                            case "menengah":
                                                questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest + EXP_IDENTIFIER+ expQuest + DIFFICULTY_IDENTIFIER +diffQuest.substring(0,2) + STATUS_IDENTIFIER + status + "\n";
                                                invalidInput = false;
                                                break;
    
                                            case "sulit":
                                                questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest + EXP_IDENTIFIER + expQuest + DIFFICULTY_IDENTIFIER + diffQuest.substring(0,3) + STATUS_IDENTIFIER + status + "\n";
                                                invalidInput = false;
                                                break;
    
                                            default:
                                                System.out.println("Input tingkat kesulitan salah! Harap masukkan data yang benar.");
                                                break;
                                        }
                                    }else{
                                        System.out.println("Input exp/reward tidak valid! Harap masukkan data yang benar.");
                                    }
                                }else{
                                    System.out.println("Input exp/reward tidak valid! Harap masukkan data yang benar.");
                                }
                            }else {
                                System.out.println("Input nama/deskripsi tidak valid! Harap masukkan data yang benar.");
                            }
                    }
                        System.out.println(); 
                    break;
                case "4":
                    // TODO: Tambah pengembara
                    invalidInput = true;
                    while(invalidInput){
                        String nameTraveler;
                        int levelTraveler;
                        int exp;
                        String kembali = "back";
                        String status = "kosong \u2705";
                        System.out.println("Pengembara " + (travelerId));
                        System.out.println("Masukkan nama Pengembara (ketik back untuk kembali ke main menu): ");
                        String nameInp = input.nextLine();
                        if(nameInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.println("Masukkan level pengembara berupa bilangan bulat [1,20] (ketik back untuk kembali ke main menu): ");
                        String levelInp = input.nextLine();
                        if(levelInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
    
                        // TODO: Validasi input pengembara
                        if(nameInp.matches("^[a-zA-Z0-9\\s]+$")){
                            nameTraveler = nameInp;
                            if(levelInp.matches("^[0-9]+$")){
                                levelTraveler = Integer.parseInt(levelInp);
                                if (levelTraveler == 1){
                                    exp = 0;
                                    travelerData += "P" + (travelerId++) + NAME_IDENTIFIER + nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp + STATUS_IDENTIFIER + status + "\n";
                                    invalidInput = false;
                                    break;
                                }else if(levelTraveler > 1 && levelTraveler <= 20){
                                    exp =(int) (5000 * Math.pow(2, levelTraveler- 2));
                                    travelerData += "P" + (travelerId++) + NAME_IDENTIFIER+ nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp + STATUS_IDENTIFIER + status + "\n";
                                    invalidInput = false;
                                    break;
                                }else{
                                    System.out.println("Input level tidak valid! Harap masukkan data dengan benar.");
                                }
                            }
                        }else{
                            System.out.println("Input nama tidak valid! Harap masukkan data dengan benar.");
                        }
                    }
                    break;
                case "5":
                    // TODO: Menjalankan quest
                    invalidInput = true;
                    while(invalidInput){
                        String kembali = "back";
                        String syaratQuest = "tersedia \ud83d\udfe2";
                        String syaratTravel = "kosong \u2705";

                        kumpulanDataQuest = new Scanner(questData);
                        kumpulanDataTravel = new Scanner(travelerData);
                        System.out.println("Masukkan ID Quest yang ingin di ambil (ketik back untuk kembali ke main menu): ");
                        String idInp = input.nextLine();
                        if (idInp.equals(kembali)){
                            invalidInput = false;
                            break;
                        }

                        System.out.println("Masukkan ID Pengembara yang akan mengambil Quest (ketik back untuk kembali ke main menu): ");
                        String idTravel = input.nextLine();
                        if (idTravel.equals(kembali)){
                            invalidInput = false;
                            break;
                        }

                        // TODO: Cek apakah pengembara kosong
                        boolean travelValid = false;
                        int levelTravel = 0;
                        while(kumpulanDataTravel.hasNext()){
                            String barisTravel = kumpulanDataTravel.nextLine();

                            // TODO : Parsing kolom secara manual
                            int kategori1 = barisTravel.indexOf(NAME_IDENTIFIER);
                            int kategori2 = barisTravel.indexOf(LEVEL_IDENTIFIER);
                            int kategoriAkhir = barisTravel.lastIndexOf(STATUS_IDENTIFIER);

                            // TODO: Ambil kategori yang di butuhkan
                            String id = barisTravel.substring(0, kategori1);
                            String levelString = barisTravel.substring(kategori2+1, barisTravel.indexOf(EXP_IDENTIFIER));
                            String statusSekarangTravel = barisTravel.substring(kategoriAkhir+1);

                            if(id.equals(idTravel) && statusSekarangTravel.equalsIgnoreCase(syaratTravel)){
                                levelTravel = Integer.parseInt(levelString);
                                travelValid = true;
                                break;
                            }

                        }
                        if(!travelValid){
                        System.out.println("Pengembara tidak ditemukan atau sedang menjalankan quest lain!");
                        continue;
                        }

                        // TODO: Cek apakah quest tersedia
                        boolean questFound = false;
                        String questBaru = "";
                        if(idInp.matches("^[a-zA-Z0-9\\s]+$")){
                            while(kumpulanDataQuest.hasNext()){
                            String barisQuest = kumpulanDataQuest.nextLine();
                            
                                
                            // TODO: Parsing kolom secara manual
                            int kategori1 = barisQuest.indexOf(NAME_IDENTIFIER);
                            int kategori2 = barisQuest.indexOf(DIFFICULTY_IDENTIFIER);
                            int kategoriAkhir= barisQuest.lastIndexOf(STATUS_IDENTIFIER);
    
                            // TODO: Ambil per kategori
                            String id = barisQuest.substring(0, kategori1);
                            String difficulty = barisQuest.substring(kategori2+1, kategoriAkhir);
                            String statusSekarang = barisQuest.substring(kategoriAkhir+1);

                            if(idInp.equals(id) && statusSekarang.equals(syaratQuest)){
                                boolean levelCukup = false;
                                if(difficulty.equals("\u2605")){
                                    levelCukup = true;
                                } else if(difficulty.equals("\u2605\u2605") && levelTravel >= 6){
                                    levelCukup = true;
                                        
                                } else if (difficulty.equals("\u2605\u2605\u2605") && levelTravel >= 16){
                                    levelCukup = true;
                                }
                                if (levelCukup){
                                    String stringBaru = "diambil-" + idTravel + "\u231b";
                                    String barisBaru = barisQuest.substring(0, kategoriAkhir + 1) + stringBaru + "\n";
                                    questBaru += barisBaru;
                                    questFound = true;
                                }else{
                                    System.out.println("Maaf level kamu rendah! Cari lawan yang sepadan.");
                                    }
                            }else{
                                questBaru += barisQuest + "\n";
                            }
                        }
                        
                        if(questFound){
                            questData = questBaru;
                            String updateTravelData = "";
                            String updateStatus = "dalam Quest \u274c";
                            Scanner updateTravel = new Scanner(travelerData);
                            while (updateTravel.hasNext()) {
                                String barisUpdate = updateTravel.nextLine();
                                int kategoriStatus = barisUpdate.indexOf(STATUS_IDENTIFIER);
                                if(barisUpdate.startsWith(idTravel)){
                                    updateTravelData += barisUpdate.substring(0, kategoriStatus + 1) + updateStatus + "\n";
                                }else{
                                    updateTravelData += barisUpdate + "\n";
                                }
                                
                            }
                            travelerData = updateTravelData;
                            System.out.println("Quest " + idInp + " berhasil diambil!");
                            invalidInput = false;
                            updateTravel.close();
                        }else{
                            System.out.println("Quest tidak ditemukan atau sudah diambil/selesai.");
                        }
                        }else{
                            System.out.println("Input tidak valid! silahkan masukkan data dengan benar.");
                        }
                        

                    }
                    break;
                case "6":
                    // TODO: Menyelesaikan quest
                    boolean invalidDone = true;
                    while (invalidDone){
                        String kembali = "back";
                        String syaratQuest = "diambil";
                        String syaratTravel = "dalam Quest \u274c";                    

                        System.out.println("Masukkan ID Quest yang ingin di selesaikan (ketik back untuk kembali ke main menu): ");
                        String idQuest = input.nextLine();
                        if(idQuest.equals(kembali)){
                            invalidDone = false;
                            break;
                        }

                        
                        // TODO: Cek apakah pengembara dalam quest
                        kumpulanDataTravel = new Scanner(travelerData);
                        boolean travelValid = false;
                        String idTravel = "";
                        int levelLama = 0;
                        int expLama = 0;

                        while(kumpulanDataTravel.hasNext()){
                            String barisTravel = kumpulanDataTravel.nextLine();

                            // TODO : Parsing kolom secara manual
                            int kategori1 = barisTravel.indexOf(NAME_IDENTIFIER);
                            int kategori2 = barisTravel.indexOf(LEVEL_IDENTIFIER);
                            int kategori3 = barisTravel.indexOf(EXP_IDENTIFIER);
                            int kategoriAkhir = barisTravel.lastIndexOf(STATUS_IDENTIFIER);

                            // TODO: Ambil kategori yang di butuhkan
                            String id = barisTravel.substring(0, kategori1);
                            String statusSekarang = barisTravel.substring(kategoriAkhir+1);
                            if(statusSekarang.equalsIgnoreCase(syaratTravel)){
                                travelValid = true;
                                idTravel = id;
                                levelLama = Integer.parseInt(barisTravel.substring(kategori2+1, kategori3));
                                expLama = Integer.parseInt(barisTravel.substring(kategori3+1, kategoriAkhir));
                                break;
                            }
                        }

                        if(!travelValid){
                        System.out.println("Pengembara tidak ditemukan atau sedang menjalankan quest lain!");
                        continue;
                        }
                        
                        // TODO : Cek apakah quest di ambil
                        kumpulanDataQuest = new Scanner(questData);
                        boolean questFound = false;
                        String questBaru = "";
                        int expHadiah = 0;

                        if(idQuest.matches("^[a-zA-Z0-9\\s]+$")){
                            while (kumpulanDataQuest.hasNext()) {
                                String barisQuest = kumpulanDataQuest.nextLine();

                                // TODO : Parsial manual per kategori
                                int kategori1 = barisQuest.indexOf(NAME_IDENTIFIER);
                                int kategori2 = barisQuest.indexOf(EXP_IDENTIFIER);
                                int kategori3 = barisQuest.indexOf(DIFFICULTY_IDENTIFIER);
                                int kategoriAkhir = barisQuest.indexOf(STATUS_IDENTIFIER);

                                // TODO: Ambil kategori yang di butuhkan
                                String id = barisQuest.substring(0,kategori1);
                                String statusSekarang = barisQuest.substring(kategoriAkhir+1);
                               
                                // TODO : Cek apakah ID Quest cocok dan mengandung idTravel
                                if(idQuest.equals(id) && statusSekarang.contains(syaratQuest + "-"+ idTravel)){
                                    questFound = true;
                                    expHadiah = Integer.parseInt(barisQuest.substring(kategori2+1, kategori3));

                                    String stringBaru = barisQuest.substring(0, kategoriAkhir+1) + "selesai \ud83c\udfc6" + "\n";
                                    questBaru += stringBaru;
                                }else{
                                    questBaru += barisQuest + "\n";
                                }    
                            }

                            if(questFound){
                            questData = questBaru;
                            int expTotal = expLama + expHadiah;
                            int levelBaru = levelLama;
                            
                            long syaratExp = (long) (5000 * Math.pow(2, levelLama-1));
                            
                            if (levelLama < 20 && expTotal >= syaratExp) {
                                levelBaru = levelLama + 1;
                                System.out.println("CONGRATULATIONS! " + idTravel + " naik ke Level " + levelBaru + "!");
                            }
                            
                            String updateTravelData = "";
                            String updateStatus = "Kosong \u2705";
                            Scanner updateTravel = new Scanner(travelerData);
                            while (updateTravel.hasNext()) {
                                String barisUpdate = updateTravel.nextLine();
                                if(barisUpdate.startsWith(idTravel + NAME_IDENTIFIER)){
                                    int lvlTravel = barisUpdate.indexOf(LEVEL_IDENTIFIER);
                                    int nameTravel = barisUpdate.indexOf(NAME_IDENTIFIER);

                                    updateTravelData += barisUpdate.substring(0, nameTravel+1) + barisUpdate.substring(nameTravel+1, lvlTravel) +LEVEL_IDENTIFIER + levelBaru + EXP_IDENTIFIER + expTotal + STATUS_IDENTIFIER + updateStatus + "\n";
                                }else{
                                    updateTravelData += barisUpdate + "\n";
                                } 
                            }   
                            travelerData = updateTravelData;
                            System.out.println("Quest " + idQuest + " berhasil diselesaikan!");
                            invalidDone = false;
                            updateTravel.close();

                        }else{
                            System.out.println("Quest tidak ditemukan atau belum diambil/selesai.");
                        }
                        }
                    }
                    break;
                case "7":
                    // TODO: Filter daftar quest
                    boolean inputFilter = false;
                    while (!inputFilter){
                        String filter = "tersedia, diambil, selesai";
                        String tingkatKesulitan = "mudal, menengah, sulit";
                        String kembali = "back";

                        System.out.println("Filter daftar quest: ");
                        System.out.println("1. Filter berdasarkan status.");
                        System.out.println("2. Filter berdasarkan tingkat kesulitan.");
                        System.out.println("back. Kembali ke main menu.");
                        System.out.println("Masukkan tipe filter.");
                        String pilihan = input.nextLine();

                        switch (pilihan.toLowerCase()) {
                            case "1":
                                System.out.println("Masukkan status quest yang ingin di filter (tersedia, diambil, selesai), ketik back untuk kembali ke main menu: ");
                                String filterStatus = input.nextLine();
                                if(filterStatus.toLowerCase().equals(kembali)){
                                    inputFilter = true;
                                    break;
                                }
                                if(filterStatus.toLowerCase().equals("tersedia") || filterStatus.toLowerCase().equals("diambil") || filterStatus.toLowerCase().equals("selesai")){
                                    String questFilter = "";
                                    kumpulanDataQuest = new Scanner(questData);
                                    while (kumpulanDataQuest.hasNext()) {
                                        String cekFilter = kumpulanDataQuest.nextLine();
                                        if(cekFilter.substring(cekFilter.indexOf(STATUS_IDENTIFIER)).contains(filterStatus)){
                                            questFilter += cekFilter +"\n";
                                        }
                                    }

                                    if(questFilter.isEmpty()){
                                        System.out.println("Quest dengan status " + filterStatus + " tidak ada, coba cari status lain.");
                                        System.out.println();
                                    }else{
                                        Scanner kumpulanFilter = new Scanner(questFilter);
                                        while(kumpulanFilter.hasNext()){
                                            String tampilkan = kumpulanFilter.nextLine();

                                             // TODO: Parsing kolom secara manual
                                            int p1 = tampilkan.indexOf(NAME_IDENTIFIER);
                                            int p2 = tampilkan.indexOf(DESC_IDENTIFIER);
                                            int p3 = tampilkan.indexOf(REWARD_IDENTIFIER);
                                            int p4 = tampilkan.indexOf(EXP_IDENTIFIER);
                                            int p5 = tampilkan.indexOf(DIFFICULTY_IDENTIFIER);
                                            int p6 = tampilkan.indexOf(STATUS_IDENTIFIER);

                                            // TODO: Ambil per kategori
                                            String id = tampilkan.substring(0, p1);
                                            String nama = tampilkan.substring(p1+1, p2);
                                            String desk = tampilkan.substring(p2+1, p3);
                                            String reward = tampilkan.substring(p3+1, p4);
                                            String exp = tampilkan.substring(p4+1, p5);
                                            String difficult = tampilkan.substring(p5+1, p6);
                                            String status = tampilkan.substring(p6+1);

                                            System.out.println();
                                            System.out.println("ID Quest: " + id);
                                            System.out.println("Nama Quest: " + nama);
                                            System.out.println("Deskripsi Quest: " + desk);
                                            System.out.println("Reward Quest: " + reward + " poin");
                                            System.out.println("Bonus exp Quest: " + exp + " poin exp");
                                            System.out.println("Tingkat kesulitan quest: " + difficult);
                                            System.out.println("Status Quest: " + status);
                                            System.out.println();
                                        }

                                        kumpulanFilter.close();
                                    }
                                }else{
                                    System.out.println(filterStatus + " Bukan status quest! Harap masukkan sesuai dengan status yang ada.");
                                }
                                break;
                            case "2":
                                System.out.println("Masukkan quest yang di filter (mudah, menengah, sulit), ketik back untuk kembali ke main menu: ");
                                String filterDiff = input.nextLine();
                                
                                if(filterDiff.toLowerCase().equals(kembali)){
                                    inputFilter = true;
                                    break;
                                }
                                
                                String targetStars = "";
                                if (filterDiff.equals("mudah")) {
                                    targetStars = "\u2605";
                                } else if (filterDiff.equals("menengah")) {
                                    targetStars = "\u2605\u2605";
                                } else if (filterDiff.equals("sulit")) {
                                    targetStars = "\u2605\u2605\u2605";
                                }
                                if (!targetStars.isEmpty()) {

                                String questFilterDiff = "";
                                kumpulanDataQuest = new Scanner(questData);

                                // TODO : Mencari baris yang mengandung bintang tersebut di kolom tingkat kesulitan
                                while (kumpulanDataQuest.hasNext()) {
                                    String cekLine = kumpulanDataQuest.nextLine();
                                    int startDiff = cekLine.indexOf(DIFFICULTY_IDENTIFIER);
                                    int endDiff = cekLine.indexOf(STATUS_IDENTIFIER);

                                    // TODO : Ambil bagian string tingkat kesulitan saja
                                    String diffValue = cekLine.substring(startDiff + 1, endDiff);

                                    if (diffValue.equals(targetStars)) {
                                        questFilterDiff += cekLine + "\n";
                                    }
                                }

                                if (questFilterDiff.isEmpty()) {
                                    System.out.println("Quest dengan tingkat kesulitan " + filterDiff + " (" + targetStars + ") tidak ditemukan.");
                                    System.out.println();
                                } else {
                                    // Tampilkan hasil filter
                                    Scanner tampilkanFilter = new Scanner(questFilterDiff);
                                    while (tampilkanFilter.hasNext()) {
                                        String baris = tampilkanFilter.nextLine();

                                        // Parsing manual seperti pada case 1
                                        int p1 = baris.indexOf(NAME_IDENTIFIER);
                                        int p2 = baris.indexOf(DESC_IDENTIFIER);
                                        int p3 = baris.indexOf(REWARD_IDENTIFIER);
                                        int p4 = baris.indexOf(EXP_IDENTIFIER);
                                        int p5 = baris.indexOf(DIFFICULTY_IDENTIFIER);
                                        int p6 = baris.indexOf(STATUS_IDENTIFIER);

                                        String id = baris.substring(0, p1);
                                        String nama = baris.substring(p1 + 1, p2);
                                        String desk = baris.substring(p2 + 1, p3);
                                        String reward = baris.substring(p3 + 1, p4);
                                        String exp = baris.substring(p4 + 1, p5);
                                        String difficult = baris.substring(p5 + 1, p6);
                                        String status = baris.substring(p6 + 1);

                                        System.out.println();
                                        System.out.println("ID Quest: " + id);
                                        System.out.println("Nama Quest: " + nama);
                                        System.out.println("Deskripsi Quest: " + desk);
                                        System.out.println("Reward Quest: " + reward + " poin");
                                        System.out.println("Bonus exp Quest: " + exp + " poin exp");
                                        System.out.println("Tingkat kesulitan quest: " + difficult);
                                        System.out.println("Status Quest: " + status);
                                        System.out.println();
                                    }
                                    tampilkanFilter.close();
                                }
                            } else {
                                System.out.println("Input tidak valid! Harap masukkan: mudah, menengah, atau sulit.");
                            }
                            break;

                            case "back":
                                System.out.println();
                                inputFilter = true;
                                break;
                            default:
                                System.out.println(pilihan + " tidak termasuk ke dalam pilihan!");
                                break;
                        }
                    }
                    break;
                case "8":
                    // TODO: Filter daftar pengembara
                    inputFilter = false;
                    while(!inputFilter){
                        
                    }
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                    // TODO: Tampilkan daftar pengembara terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "11":
                    // TODO: Keluar
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}