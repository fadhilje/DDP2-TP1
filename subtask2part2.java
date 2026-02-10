import java.util.Scanner;

public class subtask2part2 {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int questCount = 0;
        int travelerCount = 0 ;
        boolean invalidInput = true;

        // TODO: Input banyak quest dan pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: ");
            // TODO: Validasi input jumlah quest
            String questCountInput = input.nextLine();
            try {
                questCount = Integer.parseInt(questCountInput);
                if (questCount > 0){
                    invalidInput = false;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                }
            } catch (NumberFormatException e){
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }

        }
        
        // TODO: Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.println("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // TODO: Validasi input jumlah pengembara
            try {
                travelerCount = Integer.parseInt(travelerCountInput);
                if (travelerCount >= 0){
                    invalidInput = false;
                } else{
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");    
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
        System.out.println();
        }
        
        String questData = "";
        String travelerData = "";
        System.out.println("Mulai memasukkan data quest.");
        // TODO: Input data quest sebanyak quest yang diminta
        for (int i = 0; i < questCount; i++) {
            System.out.println("Quest ke-" + (i+1));
            boolean invalidQuest = true;
            String namaQuest;
            String deskQuest;
            int rewardQuest;
            int expQuest;
            String difficultQuest;
            
            while (invalidQuest){
                // Nama Quest 
                System.out.println("Masukkan nama quest:");
                namaQuest = input.nextLine();
                
                // Deskripsi Quest
                System.out.println("Masukkan deskripsi quest:");
                deskQuest = input.nextLine();

                // Reward Quest
                System.out.println("Masukkan reward quest berupa bilangan bulat non-negatif:");
                String rewardInput = input.nextLine();

                // EXP Quest
                System.out.println("Masukkan exp quest berupa bilangan bulat non-negatif:");
                String expInput = input.nextLine();

                // Difficult Quest
                System.out.println("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit):");
                difficultQuest = input.nextLine();

                // Validasi Input Data Quest
                // Validasi input nama
                if (namaQuest.matches("^[a-zA-Z0-9\\s]+$")){
                    // Validasi input deskripsi
                    if (deskQuest.matches("^[a-zA-Z0-9\\s]+$")){
                        // konvert input reward
                        try {
                            rewardQuest = Integer.parseInt(rewardInput);
                            // validasi input reward
                            if (rewardQuest > 0){
                                // konvert input EXP
                                try{
                                    expQuest = Integer.parseInt(expInput);
                                    // validasi input EXP
                                    if (expQuest > 0){
                                        if (difficultQuest.matches("^[a-zA-Z\\s]+$")){
                                            switch (difficultQuest.toLowerCase()) {
                                                case "mudah":
                                                    System.out.println("Quest berhasil di tambahkan.");
                                                    invalidQuest = false;
                                                    questData += "Q" + (i+1) + "," + namaQuest + "," + deskQuest + "," + rewardQuest + "," + expQuest + "," + "\u2605" + "," + "Tersedia \ud93d\n";
                                                    break;
                                                case "menengah":
                                                    System.out.println("Quest berhasil di tambahkan.");
                                                    invalidQuest = false;
                                                    questData += "Q" + (i+1) + "," + namaQuest + "," + deskQuest + "," + rewardQuest + "," + expQuest + "," + "\u2605\u2605" + "," + "Tersedia \ud93d\n";
                                                    break;
                                                case "sulit":
                                                    System.out.println("Quest berhasil di tambahkan.");
                                                    invalidQuest = false;
                                                    questData += "Q" + (i+1) + "," + namaQuest + "," + deskQuest + "," + rewardQuest + "," + expQuest + "," + "\u2605\u2605\u2605" + "," + "Tersedia \ud93d\n";
                                                    break;
                                                default:
                                                    System.out.println("Input Difficult tidak valid. Harap masukkan data berdasarkan opsi.");
                                                    invalidQuest = true;
                                                    break;
                                            }
                                            System.out.println();
                                            invalidQuest = false;
                                        } else {
                                            System.out.println("Input Difficult tidak valid. Harap masukkan data berdasarkan opsi.");
                                        }
                                    }else{
                                        System.out.println("Input Exp tidak valid. Harap masukkan data dengan benar");
                                    }
                                } catch (NumberFormatException e){
                                        System.out.println("Input Exp tidak valid. Harap masukkan data dengan benar");
                                }
                            } else {
                                System.out.println("Input Reward tidak valid. Harap masukkan data dengan benar");
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Input Reward tidak valid. Harap masukkan data dengan benar");
                        }
                    } else {
                        System.out.println("Input deskripsi tidak valid. Harap masukkan data dengan");
                    }
                } else {
                    System.out.println("Input nama tidak valid. Harap masukkan data dengan benar");
                }
            }
            

        }
        System.out.println();

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        boolean invalidTravel = true;
        for (int i = 0; i < travelerCount; i++) {
            String nameTravel;
            String levelTravel;
            System.out.println("Pengembara ke-" + (i+1));

            while(invalidTravel){
                System.out.println("Masukkan nama pengembara: ");
                nameTravel = input.nextLine();
                System.out.println("Masukkan level pengembara berupa bilangan bulat [1,20]: ");
                levelTravel =input.nextLine();

                if (nameTravel.matches("^[a-zA-Z0-9\\s]+$")){
                    switch (Integer.parseInt(levelTravel)) {
                        case 1:
                            System.out.println("Pengembara berhasil ditambahkan.");
                            System.out.println("Data berhasil di masukkan");
                            travelerData += "P" + (i+1) + "," + nameTravel + "," + levelTravel + "," + 0 + "," + "Kosong \u2705\n";
                            invalidTravel = false;
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                            System.out.println("Pengembara berhasil ditambahkan.");
                            System.out.println("Data berhasil di masukkan");
                            travelerData += "P" + (i+1) + "," + nameTravel + "," + levelTravel + "," + (5000*2^(Integer.parseInt(levelTravel)-2)) + "," +"Kosong \u2705\n";
                            invalidTravel = false;
                            break;
                        default:
                            System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                            invalidTravel = true;
                            break;
                    }
                }else{
                    System.out.println("Input Nama tidak valid cukup masukkan nama dan angka!");
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
                    // TODO: Tampilkan daftar quest
                    String[] barisQuest= questData.split("\n");
                    for (String baris : barisQuest){
                        String[] kolom = baris.split(",");
                        if (kolom.length >= 7){
                            String id = kolom[0];
                            String nama = kolom[1];
                            String deskripsi = kolom[2];
                            String reward = kolom[3];
                            String exp = kolom[4];
                            String difficult = kolom[5];
                            String status = kolom[6];

                            System.out.println("ID Quest: " + id);
                            System.out.println("Nama Quest: " + nama);
                            System.out.println("Deskripsi Quest: " + deskripsi);
                            System.out.println("Reward Quest: " + reward);
                            System.out.println("Bonus Exp Quest: " + exp );
                            System.out.println("Tingkat kesulitan Quest: " + difficult);
                            System.out.println("Status Quest " + status);


                        }
                    }
                    break;
                case "2":
                    // TODO: Tampilkan daftar pengembara
                    String[] barisTraveler = travelerData.split("\n");
                    for (String baris : barisTraveler){
                        String[] kolom = baris.split(",");
                        if (kolom.length >= 5){
                            String id = kolom[0];
                            String nama = kolom[1];
                            String level = kolom[2];
                            String exp = kolom[3];
                            String status = kolom[4];

                            System.out.println("ID Pengembara: " + id);
                            System.out.println("Nama Pengembara: " + nama);
                            System.out.println("Level Pengembara: " + level);
                            System.out.println("Exp Pengembara: " + exp);
                            System.out.println("Status Pengembara: " + status);
                        
                        }
                    }
                    break;
                case "3":
                    // TODO: Tambah quest
                    boolean validInput = true;
                    while (validInput) {
                        
                        barisQuest = questData.split("\n");
                        System.out.println("Quest" + (barisQuest.length + 1));
                        System.out.println("Masukkan nama Quest (Masukkan back atau Back untuk kembali ke main menu): ");
                        String namaQuest = input.nextLine();
                        System.out.println();
                        switch (namaQuest) {
                            case "back":
                            case "BACK":
                            case "Back":
                                validInput = false;
                                break;
                            default:
                                if (namaQuest.matches("^[a-zA-Z0-9\\s]+$")){
                                    System.out.println("Masukkan deskripsi Quest (Masukkan back untuk kembali ke main menu): ");
                                    String deskQuest = input.nextLine();
                                    switch (deskQuest) {
                                        case "back":
                                        case "BACK":
                                        case "Back":
                                            validInput = false;
                                            break;
                                        default:
                                            if (deskQuest.matches("^[a-zA-Z0-9\\s]+$")){
                                                System.out.println("Masukkan Reward Quest (Masukkan back untuk kembali ke main menu): ");
                                                String rewardInput = input.nextLine();
                                                switch (rewardInput) {
                                                    case "back":
                                                    case "BACK":
                                                    case "Back":
                                                        validInput = false;
                                                        break;
                                                    default:
                                                        try {int rewardQuest = Integer.parseInt(rewardInput);
                                                            System.out.println("Masukkan Exp Quest (Masukkan back untuk kembali ke main menu): ");
                                                            String expInput = input.nextLine();
                                                            switch (expInput) {
                                                                case "back":
                                                                case "BACK":
                                                                case "Back":
                                                                    validInput = false;
                                                                    break;
                                                                default:
                                                                    try { int expQuest = Integer.parseInt(expInput);
                                                                    } catch (Exception e) {
                                                                        // TODO: handle exception
                                                                        int expQuest = Integer.parseInt(expInput);
                                                                        System.out.println("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit) (Masukkan back untuk kembali ke main menu): ");
                                                                        String diffInput = input.nextLine();
                                                                        switch (diffInput) {
                                                                            case "back":
                                                                            case "BACK":
                                                                            case "Back":
                                                                                validInput = false;
                                                                                break;
                                                                            default:
                                                                                if(diffInput.matches("^[a-zA-Z0-9\\s]+$")){
                                                                                    String diffQuest = diffInput.toLowerCase();
                                                                                    switch (diffQuest) {
                                                                                        case "mudah":
                                                                                            questData += "Q" + (questData.length()+1) + "," + namaQuest + "," + deskQuest + "," + rewardQuest + "," + expQuest + "," + "\u2605" + "," + "Tersedia \ud93d\n";
                                                                                            break;
                                                                                        case "menengah":
                                                                                            questData += "Q" + (questData.length()+1) + "," + namaQuest + "," + deskQuest + "," + rewardQuest + "," + expQuest + "," + "\u2605\u2605" + "," + "Tersedia \ud93d\n";
                                                                                            break;
                                                                                        case "sulit":
                                                                                            questData += "Q" + (questData.length()+1) + "," + namaQuest + "," + deskQuest + "," + rewardQuest + "," + expQuest + "," + "\u2605\u2605\u2605" + "," + "Tersedia \ud93d\n";
                                                                                            break;
                                                                                        default:
                                                                                            System.out.println("Input tingakat kesulitan tidak valid! Masukkan input berdasarkan opsi.");
                                                                                            break;
                                                                                    }
                                                                                }
                                                                                break;
                                                                        }
                                                                    }
                                                                    break;
                                                            }
                                                        } catch (Exception e) {
                                                            // TODO: handle exception
                                                            System.out.println("Input Reward tidak valid! Masukkan bilangan bulat non-negatif.");
                                                        }
                                                        break;
                                                }
                                            }else{
                                                System.out.println("Input Reward tidak valid!");
                                            }
                                            break;
                                    }
                                }else{
                                    System.out.println("Input nama tidak valid! Masukkan data dengan benar.");
                                }
                                break;
                        }
    
                        break;
                    }
                    break;
                case "4":
                    // TODO: Tambah pengembara
                    String nameTravel;
                    int levelTravel;
                    while(invalidInput){
                        System.out.println("Masukkan nama pengembara (Masukkan back untuk kembali ke main menu: ");
                        String nameInput = input.nextLine();
                        System.out.println("Masukkan level pengembara berupa bilangan bulat [1,20] (Masukkan back untuk kembali ke main menu): ");
                        String levelInput = input.nextLine();

                        switch (nameInput) {
                            case "back":
                            case "BACK":
                            case "Back":
                                invalidInput = false;
                                break;
                            default:
                                if(nameInput.matches("^[a-zA-Z0-9\\s]+$")){
                                    nameTravel = nameInput;
                                    try {levelTravel =Integer.parseInt(levelInput);
                                        switch (levelTravel) {
                                            case 1:
                                                travelerData += "P" + (travelerData.length()+1) + "," + nameTravel + "," + levelTravel + "," + (5000*2^(levelTravel-2)) + "," +"Kosong \u2705\n";
                                                invalidInput = false;
                                                break;
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                            case 8:
                                            case 9:
                                            case 10:
                                            case 11:
                                            case 12:
                                            case 13:
                                            case 14:
                                            case 15:
                                            case 16:
                                            case 17:
                                            case 18:
                                            case 19:
                                            case 20:
                                            travelerData += "P" + (travelerData.length()+1) + "," + nameTravel + "," + levelTravel + "," + (5000*2^(levelTravel-2)) + "," +"Kosong \u2705\n";
                                                break;
                                            default:
                                                System.out.println("Input level tidak valid! Masukkan input level dengan benar.");
                                                break;
                                        }

                                        
                                    } catch (Exception e) {
                                        // TODO: handle exception
                                        System.out.println("Input level tidak valid! Masukkan input level dengan benar.");
                                    }
                                }else{
                                    System.out.println("Input nama tidak valid! Masukkan nama pengembara dengan benar.");
                                }
                                break;
                        }
                    }
                    break;
                case "5":
                    // TODO: Menjalankan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "6":
                    // TODO: Menyelesaikan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "7":
                    // TODO: Filter daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "8":
                    // TODO: Filter daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                case "11":
                    // TODO: Keluar
                //     running = false;
                //     System.out.println("Terima kasih telah menggunakan BurhanQuest!");
                //     System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
                //     System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");
                //     System.out.println(BANNER);
                System.out.println("Untuk output ini ada di file subtask1 dan file full TP");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
                    
            }
        }
    }
}
