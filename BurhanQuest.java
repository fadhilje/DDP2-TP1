import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

public class BurhanQuest {
    // Banner pembuka, silakan manfaatkan variabel ini untuk menampilkan banner di awal dan di akhir program
    private static final String BANNER = ".-. .-')             _  .-')  ('-. .-.  ('-.        .-') _ \r\n" + //
                "\\  ( OO )           ( \\( -O )( OO )  / ( OO ).-.   ( OO ) )\r\n" + //
                " ;-----.\\ ,--. ,--.  ,------.,--. ,--. / . --. ,--./ ,--,' \r\n" + //
                " | .-.  | |  | |  |  |   /`. |  | |  | | \\-.  \\|   \\ |  |\\ \r\n" + //
                " | '-' /_)|  | | .-')|  /  | |   .|  .-'-'  |  |    \\|  | )\r\n" + //
                " | .-. `. |  |_|( OO |  |_.' |       |\\| |_.'  |  .     |/ \r\n" + //
                " | |  \\  ||  | | `-' |  .  '.|  .-.  | |  .-.  |  |\\    |  \r\n" + //
                " | '--'  ('  '-'(_.-'|  |\\  \\|  | |  | |  | |  |  | \\   |  \r\n" + //
                " `------'  `-----'   `--' '--`--' `--' `--' `--`--'  `--'  \r\n" + //
                "     .-')                  ('-.   .-')   .-') _  ,---,---. \r\n" + //
                "   .(  OO)               _(  OO) ( OO ).(  OO) ) |   |   | \r\n" + //
                "  (_)---\\_)  ,--. ,--.  (,------(_)---\\_/     '._|   |   | \r\n" + //
                "  '  .-.  '  |  | |  |   |  .---/    _ ||'--...__|   |   | \r\n" + //
                " ,|  | |  |  |  | | .-') |  |   \\  :` `.'--.  .--|   |   | \r\n" + //
                "(_|  | |  |  |  |_|( OO (|  '--. '..`''.)  |  |  |  .|  .' \r\n" + //
                "  |  | |  |  |  | | `-' /|  .--'.-._)   \\  |  |  `--'`--'  \r\n" + //
                "  '  '-'  '-('  '-'(_.-' |  `---\\       /  |  |  .--..--.  \r\n" + //
                "   `-----'--' `-----'    `------'`-----'   `--'  '--''--'  ";
    private static final String STUDENT_NAME = "Nurfadhil Kurniawan";
    private static final String STUDENT_ID = "2506540765";


    // Penanda atribut, silakan manfaatkan variabel ini untuk menandai atribut di dalam data
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // penanda atribut untuk subtask 6, yakni Poin untuk gatcha bagi traveler
    private static final char GP_IDENTIFIER = '&'; 

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
        System.out.println();

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
                if(questCount >= 0){
                    invalidInput = false;
                }
            }else{
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                System.out.println();
            }
        }
        
        // TODO: Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // TODO: Validasi input jumlah pengembara
            if(travelerCountInput.matches("^[0-9]+$")){
                travelerCount = Integer.parseInt(travelerCountInput);
                if(travelerCount >= 0){
                    invalidInput = false;
                }
            }else{
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                System.out.println();
            }
        }
        System.out.println();

        String questData = "";
        String travelerData = "";
        if(questCount == 0){
            System.out.println("Request data quest 0! Tahapan ini kita lewati.");
        }else{
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
                System.out.print("Masukkan nama quest: ");
                String nameInp = input.nextLine();
                System.out.print("Masukkan deskripsi Quest: ");
                String deskInp = input.nextLine();
                System.out.print("Masukkan reward quest berupa bilangan bulat non-negatif: ");
                String rewardInp = input.nextLine();
                System.out.print("Masukkan bonus exp quest berupa bilangan bulat non-negatif: ");
                String expInp = input.nextLine();
                System.out.print("Masukkan tingkat kesulitan quest (opsi : mudah, menengah, sulit): ");
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
    }
        if(travelerCount == 0){
            System.out.println("Request data pengembara 0! Tahapan ini kita lewati.");
        }else{
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
                System.out.print("Masukkan nama Pengembara: ");
                String nameInp = input.nextLine();
                System.out.print("Masukkan level pengembara berupa bilangan bulat [1,20]: ");
                String levelInp = input.nextLine();
                
                // TODO: Validasi input pengembara
                if(nameInp.matches("^[a-zA-Z0-9\\s]+$")){
                    nameTraveler = nameInp;
                    if(levelInp.matches("^[0-9]+$")){
                        levelTraveler = Integer.parseInt(levelInp);
                        if (levelTraveler == 1){
                            exp = 0;
                            travelerData += "P" + (travelerId++) + NAME_IDENTIFIER + nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp + GP_IDENTIFIER + 0 + STATUS_IDENTIFIER + status + "\n";
                            invalidTravel = false;
                            break;
                        }else if(levelTraveler > 1 && levelTraveler <= 20){
                            exp =(int) (5000 * Math.pow(2, levelTraveler- 2));
                            travelerData += "P" + (travelerId++) + NAME_IDENTIFIER + nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp + GP_IDENTIFIER + 0 +STATUS_IDENTIFIER + status + "\n";
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
            System.out.println("9. Tampilkan daftar quest terurut");
            System.out.println("10. Tampilkan daftar pengembara terurut");
            System.out.println("11. Gatcha Reward."); // Pilihan untuk subtask 6
            System.out.println("12. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    if(questCount==0){
                        System.out.println("Tidak ada data quest! Silahkan tambah quest terlebih dahulu.");
                        System.out.println();
                    }
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
                    if(questCount==0){
                        System.out.println("Tidak ada data pengembara! Silahkan tambah pengembara terlebih dahulu.");
                        System.out.println();
                    }
                    // TODO: Tampilkan daftar pengembara
                    Scanner kumpulanDataTravel = new Scanner(travelerData);
                    while(kumpulanDataTravel.hasNext()){
                        String baris = kumpulanDataTravel.nextLine();

                        // TODO: Parsing kolom secara manual
                        int p1 = baris.indexOf(NAME_IDENTIFIER);
                        int p2 = baris.indexOf(LEVEL_IDENTIFIER);
                        int p3 = baris.indexOf(EXP_IDENTIFIER);
                        int p4 = baris.indexOf(GP_IDENTIFIER); // Atribut tambahan
                        int p5 = baris.indexOf(STATUS_IDENTIFIER);

                        // TODO: Ambil per kategori
                        String id = baris.substring(0, p1);
                        String nama = baris.substring(p1+1, p2);
                        String level = baris.substring(p2+1, p3);
                        String exp = baris.substring(p3+1, p4);
                        String gp = baris.substring(p4+1,p5); // Atribut tambahan
                        String status = baris.substring(p5+1);

                        System.out.println("ID Pengembara: " + id);
                        System.out.println("Nama Pengembara: " + nama);
                        System.out.println("Level Pengembara: " + level);
                        System.out.println("Exp Pengembara: " + exp + " poin exp");
                        System.out.println("Gp Pengembara: " + gp); //Atribut tambahan
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
                        System.out.print("Masukkan nama Quest (ketik back untuk kembali ke main menu): ");
                        String nameInp = input.nextLine();
                        if(nameInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.print("Masukkan deskripsi Quest (ketik back untuk kembali ke main menu): ");
                        String deskInp = input.nextLine();
                        if(deskInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.print("Masukkan reward quest berupa bilangan bulat non-negatif (ketik back untuk kembali ke main menu): ");
                        String rewardInp = input.nextLine();
                        if(rewardInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.print("Masukkan bonus exp quest berupa bilangan bulat non-negatif (ketik back untuk kembali ke main menu): ");
                        String expInp = input.nextLine();
                        if(expInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.print("Masukkan tingkat kesulitan quest (opsi : mudah, menengah, sulit) (ketik back untuk kembali ke main menu):");
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
                                                questCount += 1;
                                                System.out.println("Data quest berhasil di tambahkan!");
                                                break;

                                            case "menengah":
                                                questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest + EXP_IDENTIFIER+ expQuest + DIFFICULTY_IDENTIFIER +diffQuest.substring(0,2) + STATUS_IDENTIFIER + status + "\n";
                                                questCount += 1;
                                                System.out.println("Data quest berhasil di tambahkan!");
                                                break;
    
                                            case "sulit":
                                                questData += "Q" +  (questId++) + NAME_IDENTIFIER + nameQuest + DESC_IDENTIFIER + deskQuest + REWARD_IDENTIFIER + rewardQuest + EXP_IDENTIFIER + expQuest + DIFFICULTY_IDENTIFIER + diffQuest.substring(0,3) + STATUS_IDENTIFIER + status + "\n";
                                                questCount += 1;
                                                System.out.println("Data quest berhasil di tambahkan!");
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
                        System.out.println();
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
                        System.out.print("Masukkan nama Pengembara (ketik back untuk kembali ke main menu): ");
                        String nameInp = input.nextLine();
                        if(nameInp.toLowerCase().equals(kembali)){
                            invalidInput = false;
                            break;
                        }
                        System.out.print("Masukkan level pengembara berupa bilangan bulat [1,20] (ketik back untuk kembali ke main menu): ");
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
                                    travelerData += "P" + (travelerId++) + NAME_IDENTIFIER + nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp + GP_IDENTIFIER + 0 + STATUS_IDENTIFIER + status + "\n";
                                    travelerCount += 1;
                                    System.out.println("Data pengembara berhasil ditambahkan!");
                                }else if(levelTraveler > 1 && levelTraveler <= 20){
                                    exp =(int) (5000 * Math.pow(2, levelTraveler- 2));
                                    travelerData += "P" + (travelerId++) + NAME_IDENTIFIER+ nameTraveler + LEVEL_IDENTIFIER + levelTraveler + EXP_IDENTIFIER + exp +GP_IDENTIFIER + 0 + STATUS_IDENTIFIER + status + "\n";
                                    travelerCount += 1;
                                    System.out.println("Data pengembara berhasil ditambahkan!");
                                }else{
                                    System.out.println("Input level tidak valid! Harap masukkan data dengan benar.");
                                }
                            }
                        }else{
                            System.out.println("Input nama tidak valid! Harap masukkan data dengan benar.");
                        }
                    System.out.println();
                    }
                    System.out.println();
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
                        System.out.print("Masukkan ID Quest yang ingin di ambil (ketik back untuk kembali ke main menu): ");
                        String idInp = input.nextLine();
                        if (idInp.equals(kembali)){
                            invalidInput = false;
                            break;
                        }

                        System.out.print("Masukkan ID Pengembara yang akan mengambil Quest (ketik back untuk kembali ke main menu): ");
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
                            System.out.println();
                            updateTravel.close();
                        }else{
                            System.out.println("Quest tidak ditemukan atau sudah diambil/selesai.");
                        }
                        }else{
                            System.out.println("Input tidak valid! silahkan masukkan data dengan benar.");
                        }
                    }
                    System.out.println();
                    break;
                case "6":
                    // TODO: Menyelesaikan quest
                    boolean invalidDone = true;
                    while (invalidDone){
                        String kembali = "back";
                        String syaratQuest = "diambil";
                        String syaratTravel = "dalam Quest \u274c";                    

                        System.out.print("Masukkan ID Quest yang ingin di selesaikan (ketik back untuk kembali ke main menu): ");
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
                        int gpLama = 0;

                        while(kumpulanDataTravel.hasNext()){
                            String barisTravel = kumpulanDataTravel.nextLine();

                            // TODO : Parsing kolom secara manual
                            int kategori1 = barisTravel.indexOf(NAME_IDENTIFIER);
                            int kategori2 = barisTravel.indexOf(LEVEL_IDENTIFIER);
                            int kategori3 = barisTravel.indexOf(EXP_IDENTIFIER);
                            int kategori4 = barisTravel.indexOf(GP_IDENTIFIER);
                            int kategoriAkhir = barisTravel.lastIndexOf(STATUS_IDENTIFIER);

                            // TODO: Ambil kategori yang di butuhkan
                            String id = barisTravel.substring(0, kategori1);
                            String statusSekarang = barisTravel.substring(kategoriAkhir+1);
                            if(statusSekarang.equalsIgnoreCase(syaratTravel)){
                                travelValid = true;
                                idTravel = id;
                                levelLama = Integer.parseInt(barisTravel.substring(kategori2+1, kategori3));
                                expLama = Integer.parseInt(barisTravel.substring(kategori3+1, kategori4));
                                gpLama = Integer.parseInt(barisTravel.substring(kategori4+1, kategoriAkhir));
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

                            // TODO: Update data quest dan data pengembara
                            if(questFound){
                            questData = questBaru;
                            int expTotal = expLama + expHadiah;
                            int levelBaru = levelLama;
                            int gpBaru = gpLama + 10; //Atribut sub task 6
                            
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

                                    updateTravelData += barisUpdate.substring(0, nameTravel+1) + barisUpdate.substring(nameTravel+1, lvlTravel) +LEVEL_IDENTIFIER + levelBaru + EXP_IDENTIFIER + expTotal + GP_IDENTIFIER + gpBaru+ STATUS_IDENTIFIER + updateStatus + "\n";
                                }else{
                                    updateTravelData += barisUpdate + "\n";
                                } 
                            }   
                            travelerData = updateTravelData;
                            System.out.println("Quest " + idQuest + " berhasil diselesaikan!");
                            System.out.println("Bonus: +10 Gacha Points didapatkan!"); //Pesan tambahan sub task 6
                            invalidDone = false;
                            updateTravel.close();

                        }else{
                            System.out.println("Quest tidak ditemukan atau belum diambil/selesai.");
                        }
                        }
                    System.out.println();
                    }
                    break;
                case "7":
                    // TODO: Filter daftar quest
                    boolean inputFilter = false;
                    while (!inputFilter){
                        String kembali = "back";

                        System.out.println("Filter daftar quest: ");
                        System.out.println("1. Filter berdasarkan status.");
                        System.out.println("2. Filter berdasarkan tingkat kesulitan.");
                        System.out.println("99. Kembali ke main menu.");
                        System.out.print("Masukkan tipe filter: ");
                        String pilihan = input.nextLine();

                        switch (pilihan.toLowerCase()) {
                            case "1":
                                System.out.print("Masukkan status quest yang ingin di filter (tersedia, diambil, selesai), ketik back untuk kembali ke main menu: ");
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
                                            String baris = kumpulanFilter.nextLine();

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
                                System.out.print("Masukkan quest yang di filter (mudah, menengah, sulit), ketik back untuk kembali ke main menu: ");
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
                                    // TODO: Tampilkan hasil filter
                                    Scanner kumpulanFilter = new Scanner(questFilterDiff);
                                    while (kumpulanFilter.hasNext()) {
                                        String baris = kumpulanFilter.nextLine();

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
                                    kumpulanFilter.close();
                                }
                            } else {
                                System.out.println("Input tidak valid! Harap masukkan: mudah, menengah, atau sulit.");
                            }
                            break;

                            case "99":
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
                        System.out.println("Filter daftar Pengembara: ");
                        System.out.println("1. Filter berdasarkan status.");
                        System.out.println("2. Filter berdasarkan rentang level.");
                        System.out.println("99. untuk kembali ke main menu.");
                        System.out.print("Masukkan tipe filter: ");
                        String pilihan = input.nextLine();

                        switch (pilihan.toLowerCase()) {
                            case "1":
                                System.out.print("Masukkan status pengembara yang ingin di filter (kosong/dalam quest), ketik back untuk kembali ke main menu: ");
                                String filterStatus = input.nextLine();
                                if(filterStatus.toLowerCase().equals("back")){
                                    inputFilter = true;
                                    break;
                                }

                                if(filterStatus.toLowerCase().equals("kosong") || filterStatus.toLowerCase().equalsIgnoreCase("dalam quest")){
                                    String travelFilter = "";
                                    kumpulanDataTravel = new Scanner(travelerData);
                                    while (kumpulanDataTravel.hasNext()) {
                                        String baris = kumpulanDataTravel.nextLine();
                                        if(baris.substring(baris.indexOf(STATUS_IDENTIFIER)).toLowerCase().contains(filterStatus.toLowerCase())){
                                            travelFilter += baris + "\n";
                                        }
                                    }

                                    if(travelFilter.isEmpty()){
                                        System.out.println("Travel dengan status " + filterStatus + " tidak ada, coba cari status yang lain.");
                                        System.out.println();
                                    }else{
                                        Scanner kumpulanFilter = new Scanner(travelFilter);
                                        while(kumpulanFilter.hasNext()){
                                            String baris = kumpulanFilter.nextLine();

                                            // Parsing manual seperti pada case 2
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
                                        kumpulanFilter.close();
                                    }
                                }else{
                                    System.out.println("Input tidak valid! Harap masukkan: kosong atau dalam quest.");
                                }
                                break;
                            case "2":
                                int bawah = 0;
                                int atas = 0;
                                System.out.println("Masukkan rentang level (inklusif) yang ingin di filter, ketik back untuk kembali ke main menu.");
                                System.out.print("Masukkan batas bawah: ");
                                String batasBawah = input.nextLine();
                                if(batasBawah.matches("^[a-zA-Z\\s]+$")){
                                    if(batasBawah.toLowerCase().equals("back")){
                                        inputFilter = true;
                                        break;
                                    }else{
                                        System.out.println("Input tidak valid! Silahkan masukkan rentang level atau ketik back untuk kembali ke main menu.");
                                    }
                                }
                                bawah = Integer.parseInt(batasBawah);

                                System.out.print("Masukkan batas atas: ");
                                String batasAtas = input.nextLine();
                                if(batasAtas.matches("^[a-zA-Z\\s]+$")){
                                    if(batasAtas.toLowerCase().equals("back")){
                                        inputFilter = true;
                                        break;
                                    }else{
                                        System.out.println("Input tidak valid! Silahkan masukkan rentang level atau ketik back untuk kembali ke main menu.");
                                    }
                                }
                                atas = Integer.parseInt(batasAtas);

                                if(bawah <= atas){
                                    String filterTravel = "";
                                    kumpulanDataTravel = new Scanner(travelerData);
                                    while(kumpulanDataTravel.hasNext()){
                                        String baris = kumpulanDataTravel.nextLine();

                                        // TODO: Parsial level
                                        int level = Integer.parseInt(baris.substring(baris.indexOf(LEVEL_IDENTIFIER)+1, baris.indexOf(EXP_IDENTIFIER)));
                                        if(level >= bawah && level <= atas){
                                            filterTravel += baris +"\n";
                                        }
                                    }

                                    if(filterTravel.isEmpty()){
                                        System.out.println("Tidak ada pengembara dengan rentang level " + bawah + " sampai level " + atas);
                                    }else{
                                        Scanner tampilkanFilter = new Scanner(filterTravel);
                                        while(tampilkanFilter.hasNext()){
                                            String baris = tampilkanFilter.nextLine();

                                            // TODO : Parsial manual seperti case 2
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
                                        tampilkanFilter.close();
                                    }
                                }else{
                                    System.out.println("Rentang level tidak valid! Batas bawah harus lebih kecil atau sama dengan batas atas.");
                                }
                                break;
                            case "99":
                                System.out.println();
                                inputFilter = true;
                                break;
                            default:
                                System.out.println(pilihan + "tidak termasuk ke dalam pilihan!");
                                break;
                        }
                    }
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    boolean inputUrut = false;
                    while (!inputUrut) {
                        String orderan;
                        System.out.println("Urutkan daftar Quest:");
                        System.out.println("1. Berdasarkan tingkat kesulitan.");
                        System.out.println("2. Berdasarkan reward.");
                        System.out.println("99. kembali ke main menu.");
                        System.out.print("Masukkan input: ");
                        String pilihan = input.nextLine();

                        switch (pilihan.toLowerCase()) {
                            case "1":
                                boolean inputOrder = false;
                                while(!inputOrder){

                                    System.out.print("Masukkan orderan urutan (asc/desc), ketik kembali untuk kembali: ");
                                    orderan = input.nextLine();
                                if(orderan.toLowerCase().equals("back")){
                                    inputOrder = true;
                                    break;
                                }

                                
                                if(orderan.toLowerCase().equals("asc") || orderan.toLowerCase().equals("desc")){
                                    kumpulanDataQuest = new Scanner(questData);
                                    String bintang1 = "";
                                    String bintang2 = "";
                                    String bintang3 = "";
                                    while (kumpulanDataQuest.hasNext()) {
                                        String baris = kumpulanDataQuest.nextLine();

                                        String diff = baris.substring(baris.indexOf(DIFFICULTY_IDENTIFIER)+1, baris.indexOf(STATUS_IDENTIFIER));

                                        if(diff.contains("\u2605\u2605\u2605")){
                                            bintang3 += baris +"\n";
                                        }else if(diff.contains("\u2605\u2605")){
                                            bintang2 += baris + "\n";
                                        }else if(diff.contains("\u2605")){
                                            bintang1 += baris + "\n";
                                        }
                                    }

                                    String urutan = "";
                                    if(orderan.toLowerCase().equals("asc")){
                                        urutan = bintang1 + bintang2 + bintang3;
                                    }else{
                                        urutan = bintang3 + bintang2 + bintang1;
                                    }

                                    Scanner hashilUrutan = new Scanner(urutan);
                                    while (hashilUrutan.hasNext()) {
                                        String baris = hashilUrutan.nextLine();

                                        // TODO: Parsing manual seperti case 1
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
                                    hashilUrutan.close();

                                }else{
                                    System.out.println("Urutan tidak valid! Harap masukkan urutan dengan benar.");
                                }
                            }
                                break;
                            case "2":
                                inputOrder = false;
                                while(!inputOrder){

                                    System.out.print("Masukkan orderan urutan (asc/desc), ketik back untuk kembali: ");
                                    orderan = input.nextLine().toLowerCase().trim();
                                    
                                if (orderan.equals("back")) {
                                    inputUrut = true;
                                    break;
                                }

                                if (orderan.equals("asc") || orderan.equals("desc")) {
                                    String tempdata = questData; 
                                    System.out.println("Daftar quest terurut berdasarkan Reward EXP:");

                                    // Kita gunakan jumlahQuest (pastikan kamu punya variabel hitung jumlah baris quest)
                                    for (int i = 0; i < questCount; i++) {
                                        Scanner pencariData = new Scanner(tempdata);
                                        
                                        // operator ternary (jika conditional benar, maka targetEXP = MAX_VALUE. jika salah, Maka targetEXP = MIN_VALUE      )
                                        int targetExp = orderan.equals("asc") ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                                        String questTerpilih = "";

                                        while (pencariData.hasNextLine()) {
                                            String baris = pencariData.nextLine();
                                            if (baris.isEmpty()) continue;

                                            // Ambil EXP Reward
                                            int expSekarang = Integer.parseInt(baris.substring(
                                                baris.indexOf(EXP_IDENTIFIER) + 1, 
                                                baris.indexOf(DIFFICULTY_IDENTIFIER)
                                            ));

                                            // Logika pencarian angka terkecil/terbesar
                                            if (orderan.equals("asc")) {
                                                if (expSekarang < targetExp) {
                                                    targetExp = expSekarang;
                                                    questTerpilih = baris;
                                                }
                                            } else {
                                                if (expSekarang > targetExp) {
                                                    targetExp = expSekarang;
                                                    questTerpilih = baris;
                                                }
                                            }
                                        }
                                        pencariData.close();
                                        
                                        // Jika ketemu datanya dalam satu putaran scan
                                        if (!questTerpilih.isEmpty()) {
                                            // Hapus data yang sudah terpilih dari tempdata agar loop berikutnya cari sisanya
                                            tempdata = tempdata.replaceFirst(java.util.regex.Pattern.quote(questTerpilih), "");

                                            // Parsing untuk menampilkan hasil
                                            String qID = questTerpilih.substring(0, questTerpilih.indexOf(NAME_IDENTIFIER));
                                            String qNama = questTerpilih.substring(questTerpilih.indexOf(NAME_IDENTIFIER) + 1, questTerpilih.indexOf(DESC_IDENTIFIER));
                                            String qDesc = questTerpilih.substring(questTerpilih.indexOf(DESC_IDENTIFIER) +1, questTerpilih.indexOf(REWARD_IDENTIFIER));
                                            String qReward = questTerpilih.substring(questTerpilih.indexOf(REWARD_IDENTIFIER) +1, questTerpilih.indexOf(EXP_IDENTIFIER));
                                            String qExp = questTerpilih.substring(questTerpilih.indexOf(EXP_IDENTIFIER) + 1, questTerpilih.indexOf(DIFFICULTY_IDENTIFIER));
                                            String qDiff = questTerpilih.substring(questTerpilih.indexOf(DIFFICULTY_IDENTIFIER) + 1, questTerpilih.indexOf(STATUS_IDENTIFIER));
                                            String qStatus = questTerpilih.substring(questTerpilih.indexOf(STATUS_IDENTIFIER)+1);

                                            System.out.printf("ID Quest: %s\n", qID);
                                            System.out.printf("Nama Quest: %s\n", qNama);
                                            System.out.printf("Deskripsi Quest: %s\n", qDesc);
                                            System.out.printf("Reward Quest: %s Koin\n", qReward);
                                            System.out.printf("Bonus Exp Quest: %s Poin exp\n", qExp);
                                            System.out.printf("Tingkat Kesulitan: %s\n", qDiff);
                                            System.out.printf("Status Quest: %s\n", qStatus);
                                            System.out.println();
                                        }
                                    }
                                } else {
                                    System.out.println("Urutan tidak valid! Harap masukkan urutan dengan benar.");
                                }
                            }
                                break;
                                case "99":
                                    inputUrut = true;
                                    break;
                                    default:
                                    System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                                    break;
                                }
                            }
                    break;
                    case "10":
                        // TODO: Tampilkan daftar pengembara terurut
                    inputUrut = false;
                    while(!inputUrut){
                        System.out.println();
                        System.out.println("Urutkan daftar pengembar");
                        System.out.println("1. Berdasarkan nama.");
                        System.out.println("2. Berdasarkan level.");
                        System.out.println("99. Kembali ke main menu.");
                        System.out.print("Masukkan input: ");
                        String pilihan = input.nextLine();

                        switch (pilihan.toLowerCase()) {
                            case "1":
                            boolean inputOrder = false; 
                            while(!inputOrder){
                                System.out.print("Masukkan order urutan (asc/desc), ketik back untuk kembali: ");
                                String order = input.nextLine();
                                
                                if(order.toLowerCase().equals("back")){
                                    inputOrder = true;
                                    break;
                                }

                                if(order.toLowerCase().equals("asc") || order.toLowerCase().equals("desc")){
                                    //TODO:  Membuat copy data agar data asli tidak hilang saat proses 'delete' manual via replace
                                    String travelerDataCopy = travelerData;
                                    System.out.println("Daftar pengembara terurut berdasarkan Nama:");

                                    // TODO: Loop sebanyak jumlah pengembara yang ada
                                    for (int i = 0; i < travelerCount; i++) {
                                        Scanner travScanner = new Scanner(travelerDataCopy);
                                        String pengembaraTerpilih = "";
                                        String namaTerpilih = "";

                                        while (travScanner.hasNextLine()) {
                                            String baris = travScanner.nextLine();
                                            if (baris.isEmpty()) continue;

                                            // TODO: Ambil nama pengembara (di antara NAME_IDENTIFIER dan LEVEL_IDENTIFIER)
                                            String namaSekarang = baris.substring(baris.indexOf(NAME_IDENTIFIER) + 1, baris.indexOf(LEVEL_IDENTIFIER));

                                            if (pengembaraTerpilih.isEmpty()) {
                                                pengembaraTerpilih = baris;
                                                namaTerpilih = namaSekarang;
                                            } else {
                                                // TODO: compareToIgnoreCase membandingkan huruf demi huruf secara alphabetis
                                                int hasilCek = namaSekarang.compareToIgnoreCase(namaTerpilih);
                                                
                                                if (order.equalsIgnoreCase("asc")) {
                                                    if (hasilCek < 0) {
                                                        namaTerpilih = namaSekarang;
                                                        pengembaraTerpilih = baris;
                                                    }
                                                } else {
                                                    if (hasilCek > 0) {
                                                        namaTerpilih = namaSekarang;
                                                        pengembaraTerpilih = baris;
                                                    }
                                                }
                                            }
                                        }
                                        travScanner.close();

                                        if (!pengembaraTerpilih.isEmpty()) {
                                            // TODO: Hapus baris yang sudah terpilih dari data copy
                                            travelerDataCopy = travelerDataCopy.replaceFirst(java.util.regex.Pattern.quote(pengembaraTerpilih), "");

                                            // TODO: Parsing dan Cetak Data (Struktur tetap sama dengan kode kamu)
                                            String travID = pengembaraTerpilih.substring(0, pengembaraTerpilih.indexOf(NAME_IDENTIFIER));
                                            String travLevel = pengembaraTerpilih.substring(pengembaraTerpilih.indexOf(LEVEL_IDENTIFIER) + 1, pengembaraTerpilih.indexOf(EXP_IDENTIFIER));
                                            String travEXP = pengembaraTerpilih.substring(pengembaraTerpilih.indexOf(EXP_IDENTIFIER) + 1, pengembaraTerpilih.indexOf(STATUS_IDENTIFIER));
                                            String travStatus = pengembaraTerpilih.substring(pengembaraTerpilih.indexOf(STATUS_IDENTIFIER) + 1);

                                            System.out.println();
                                            System.out.printf("ID Pengembara: %s\n", travID);
                                            System.out.printf("Nama Pengembara: %s\n", namaTerpilih); 
                                            System.out.printf("Level Pengembara: %s\n", travLevel);
                                            System.out.printf("EXP Pengembara: %s poin exp\n", travEXP);
                                            System.out.printf("Status Pengembara: %s ", travStatus);
                                            System.out.println();
                                        }
                                    } 
                                } else {
                                    System.out.println("Urutan tidak valid!");
                                }
                            }
                            break;
                            case "2":
                                inputOrder = false;
                                while (!inputOrder) {
                                    System.out.print("Masukkan order urutan (asc/desc), ketik back untuk kembali: ");
                                    String order = input.nextLine().toLowerCase().trim();

                                    if (order.equals("back")) {
                                        inputOrder = true;
                                        break;
                                    }

                                    if (order.equals("asc") || order.equals("desc")) {
                                        String travelerDataCopy = travelerData;
                                        String hasilAkhir = "";
                                        String urutanKecil = ""; 
                                        String urutanBesar = ""; 

                                        System.out.println("Daftar pengembara terurut:");

                                        for (int i = 0; i < travelerCount; i++) {
                                            Scanner travScanner = new Scanner(travelerDataCopy);
                                            
                                            int levelLimit = order.equals("asc") ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                                            String pengembaraDipilih = "";

                                            while (travScanner.hasNextLine()) {
                                                String checkPengembara = travScanner.nextLine();
                                                if (checkPengembara.isEmpty()) continue;

                                                int levelPengembara = Integer.parseInt(checkPengembara.substring(checkPengembara.indexOf(LEVEL_IDENTIFIER) + 1, checkPengembara.indexOf(EXP_IDENTIFIER)));

                                                if (order.equals("asc")) {
                                                    if (levelPengembara < levelLimit) {
                                                        levelLimit = levelPengembara;
                                                        pengembaraDipilih = checkPengembara;
                                                    }
                                                } else {
                                                    if (levelPengembara > levelLimit) {
                                                        levelLimit = levelPengembara;
                                                        pengembaraDipilih = checkPengembara;
                                                    }
                                                }
                                            }
                                            travScanner.close();

                                            if (!pengembaraDipilih.isEmpty()) {
                                                //TODO:  Hapus data yang sudah terpilih dari copy agar tidak terhitung dua kali
                                                travelerDataCopy = travelerDataCopy.replaceFirst(java.util.regex.Pattern.quote(pengembaraDipilih), "");
                                                
                                                if (order.equals("asc")) {
                                                    urutanKecil += pengembaraDipilih + "\n";
                                                } else {
                                                    urutanBesar += pengembaraDipilih + "\n";
                                                }
                                            }
                                        }
                                        hasilAkhir = order.equals("asc") ? urutanKecil : urutanBesar;

                                        // Bagian Output: Parsing String hasilAkhir
                                        Scanner scannerHasil = new Scanner(hasilAkhir);
                                        while (scannerHasil.hasNextLine()) {
                                            String baris = scannerHasil.nextLine();
                                            if (baris.isEmpty()) continue;

                                            String id = baris.substring(0, baris.indexOf(NAME_IDENTIFIER));
                                            String nama = baris.substring(baris.indexOf(NAME_IDENTIFIER) + 1, baris.indexOf(LEVEL_IDENTIFIER));
                                            String level = baris.substring(baris.indexOf(LEVEL_IDENTIFIER) + 1, baris.indexOf(EXP_IDENTIFIER));
                                            String exp = baris.substring(baris.indexOf(EXP_IDENTIFIER) + 1, baris.indexOf(STATUS_IDENTIFIER));
                                            String status = baris.substring(baris.indexOf(STATUS_IDENTIFIER) + 1);

                                            System.out.println("ID Pengembara: " + id);
                                            System.out.println("Nama Pengembara: " + nama);
                                            System.out.println("Level Pengembara: " + level);
                                            System.out.println("Exp Pengembara: " + exp + " poin exp");
                                            System.out.println("Status Pengembara: " + status);
                                            System.out.println();
                                        }
                                        scannerHasil.close();

                                    } else {
                                        System.out.println("Urutan tidak valid! harap masukkan urutan dengan benar.");
                                    }
                                }
                                break;
                            case "99":
                                inputUrut = true;
                                break;
                            default:
                                System.out.println("Input tidak valid! Silahkan masukkan sesuai dengan pilihan di atas.");
                                break;
                        }
                    }
                    break;
                case"11":
                    // TODO: Fitur Gatcha(sub task 6)
                    System.out.println("=== MENU GACHA REWARD ===");
                    System.out.print("Masukkan ID Pengembara: ");
                    String gachaID = input.nextLine();
                    
                    if(travelerData.contains(gachaID + NAME_IDENTIFIER)){
                        // Parsing GP manual
                        int idxGP = travelerData.indexOf(GP_IDENTIFIER, travelerData.indexOf(gachaID)) + 1;
                        int idxST = travelerData.indexOf(STATUS_IDENTIFIER, idxGP);
                        int currentGP = Integer.parseInt(travelerData.substring(idxGP, idxST));

                        System.out.println("Poin Gacha (GP) anda: " + currentGP);
                        if(currentGP >= 20){
                            System.out.print("Gunakan 20 GP untuk Gacha? (y/n): ");
                            if(input.nextLine().equalsIgnoreCase("y")){
                                int finalGP = currentGP - 20;
                                // Update String secara manual
                                travelerData = travelerData.replace(GP_IDENTIFIER + "" + currentGP + STATUS_IDENTIFIER, GP_IDENTIFIER + "" + finalGP + STATUS_IDENTIFIER);
                                
                                double roll = Math.random();
                                if(roll < 0.1) System.out.println("JACKPOT! Mendapatkan Senjata Legendaris! \ud83d\udde1\ufe0f");
                                else if(roll < 0.4) System.out.println("RARE! Mendapatkan Jubah Pelindung! \ud83d\udee1\ufe0f");
                                else System.out.println("COMMON! Mendapatkan Ramuan Kecil. \ud83e\uddea");
                            }
                        } else {
                            System.out.println("GP tidak cukup (Minimal 20 GP). Selesaikan quest untuk dapat GP!");
                        }
                    } else {
                        System.out.println("ID Pengembara tidak ditemukan.");
                    }
                    break;
                case "12":
                    // TODO: Keluar
                    System.out.println("Terima kasih telah menggunakan BurhanQuest!!");
                    System.out.println("Dibuat oleh: " + STUDENT_NAME + "-" + STUDENT_ID );
                    System.out.println(BANNER);
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }
}