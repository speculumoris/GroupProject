package deadlockstore;

import com.sun.jdi.Value;

import java.util.*;

public class MobilePhone implements Repository {
    int count = 1000;
    static Scanner scan = new Scanner(System.in);
    static Map<Integer, MobilePhonePojo> mobilePhoneMap = new HashMap<>();

    @Override
    public void urunEkle() {
        try {//genel bir problem olmaması icin olusturuldu
            MobilePhonePojo mP = new MobilePhonePojo();
            System.out.println("Telefon icin urun ekleme bölümündesiniz");
            System.out.println("lutfen bilgileri giriniz:");
            System.out.print("urunun markasini seciniz");
            System.out.println("Marka Listesi ve MarkaKodu: ");
            try {//Urun silindikten sonra next methoduyla alakalı bir problem olsutugundan yapıldı
                markaListele();
                String urunMark = scan.nextLine();
                urunSecimi(urunMark, mP);

            } catch (Exception e) {
                System.err.println("urun seciminde veya Enum'da bir problem olabilir");
                System.out.print("urunun markasini seciniz");
                String urunMark = scan.nextLine();
                urunSecimi(urunMark, mP);

            }


            System.out.print("depolama alanı seciniz\n" +
                    "128 gb icin 1'e basınız\n" +
                    "64 GB icin 2'ye basınız: ");
            int num = scan.nextInt();
            depolamaAlanı(num, mP);

            System.out.print("ekran boyutu seciniz\n" +
                    "6.1 inc icin 1'e basınız\n" +
                    "6.4 inc icin 2'ye basınız: ");
            int num1 = scan.nextInt();
            ekranBoyutu(num1, mP);

            System.out.println("Kamera mps secim yapınız\n" +
                    "30 Megapiksel icin 1'e basınız\n" +
                    "35 Megapiksel icin 2'e basınız\n" +
                    "40 Megapiksel icin 3'e basınız\n" +
                    "45 Megapiksel icin 4'e basınız: ");
            int num2 = scan.nextInt();
            kameraSecimi(num2, mP);

            System.out.println("RAM icin secim yapınız\n" +
                    "4 GB icin 1'e basınız\n" +
                    "8 GB icin 2'e basınız\n" +
                    "16 GB icin 3'e basınız\n");
            int num3 = scan.nextInt();
            ramSecim(num3, mP);

            System.out.println("lutfen Renk secimi yapınız\n" +
                    "Siyah icin 1'e\n" +
                    "Mavi icin 2'ye\n" +
                    "Kirmizi icin 3'e basınız");
            int num4 = scan.nextInt();
            scan.nextLine();
            renkSecimi(num4, mP);

            MobilePhonePojo mpOptions = new MobilePhonePojo(mP.getBirimFiyat(), mP.getMarkaInfo(), mP.getUrunAdi(), mP.getHafizaInfo(),
                    mP.getEkranBoyutu(), mP.getKameraMps(), mP.getPilGucu(), mP.getRam(), mP.getRenk());
            mpOptions.setId(count);
            count++;

            mobilePhoneMap.put(mpOptions.getId(), mpOptions);

            System.out.println("Urun basarıyla eklendi");
        } catch (Exception e) {
            System.out.println("hatali giris yapılı veya rakam dışında giriş yapıldı");
            System.out.println("işlemler tekrarlanacak");
            urunEkle();
        }


    }


    @Override
    public void urunSil() {
        Set<Integer> mapKeys = new HashSet<>();
        mapKeys.addAll(mobilePhoneMap.keySet());
        for (Integer w : mapKeys) {
            System.out.println(w + ":" + mobilePhoneMap.get(w).getUrunAdi());
        }

        try {
            System.out.println("silmek istediginiz urunun kodunu giriniz");
            System.out.println("cikis yapmak icin a'ya basiniz:");
            String count = scan.nextLine();
            while (true) {
                if (count.equalsIgnoreCase("a")) {
                    break;
                }else{
                    System.out.println("yanlis giris yaptiniz tekrar deneyiniz");
                }

                if (!mobilePhoneMap.containsKey(Integer.parseInt(count))) {
                    System.out.println("böyle bir id numarası yoktur tekrar deneyiniz");
                    count = scan.nextLine();
                } else {
                    mobilePhoneMap.remove(Integer.parseInt(count));
                    System.out.println("urun silindi");
                }


            }
        } catch (NumberFormatException e) {
            System.err.println("sayi girilmesi gerkiyor rakam dısında karakter girilemez");
            System.out.println("hatalı giris yaptınız tekrar deneyiniz");
            urunSil();
        }
    }

    @Override
    public void urunListele() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhonePojo w : mobilePhoneMap.values()) {
            System.out.printf("%-5s %-31S %-11s %-12s %-12.2s %-11.1f %-11.1f %-11s %-11s %-11S %n", w.getId(), (w.getUrunAdi()), w.getBirimFiyat(), w.getMarkaInfo(),
                    w.getHafizaInfo(), w.getEkranBoyutu(),
                    w.getKameraMps(), w.getPilGucu(), w.getRam(), w.getRenk());
        }
    }

    public void urunSecimi(String str, MobilePhonePojo mP) {
        do {
            if (Integer.parseInt(str) > 7 || Integer.parseInt(str) < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                str = scan.nextLine();
            } else {
                break;
            }
        } while (true);

        switch (str) {
            case "1":
                str = String.valueOf(Markalar.APPLE);
                System.out.println("Marka seciminiz: " + Markalar.APPLE);
                mP.setBirimFiyat(2000);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case "6":
                str = String.valueOf(Markalar.SAMSUNG);
                System.out.println("Marka seciminiz: " + Markalar.SAMSUNG);
                mP.setBirimFiyat(2000);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case "5":
                str = String.valueOf(Markalar.LENOVO);
                System.out.println("Marka seciminiz: " + Markalar.LENOVO);
                mP.setBirimFiyat(1300);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case "4":
                str = String.valueOf(Markalar.HUAWEI);
                System.out.println("Marka seciminiz: " + Markalar.HUAWEI);
                mP.setBirimFiyat(1600);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case "3":
                str = String.valueOf(Markalar.CASPER);
                System.out.println("Marka seciminiz: " + Markalar.CASPER);
                mP.setBirimFiyat(1000);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case "7":
                str = String.valueOf(Markalar.XIAOMI);
                System.out.println("Marka seciminiz: " + Markalar.XIAOMI);
                mP.setBirimFiyat(1600);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case "2":
                str = String.valueOf(Markalar.ASUS);
                System.out.println("Marka seciminiz: " + Markalar.ASUS);
                mP.setBirimFiyat(1000);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
        }
        classSecim(str, mP);
    }

    private void classSecim(String str, MobilePhonePojo mP) {
        mP.setMarkaInfo(Markalar.valueOf(str));
        //apple1(str,mP);
        List<String> markList = new ArrayList<>(Arrays.asList("APPLE Iphone 12", "APPLE Iphone 13", "APPLE Iphone 14", "ASUS ZenFone 5z", "ASUS Zenfone 4", "CASPER Via X20", "CASPER Vıa A4",
                "LENOVO P2", "LENOVO motoZ", "XIAOMI 12T Pro", "XIAOMI 11T Pro", "HUAWEI mate 50 Pro", "HUAWEI P50 Pro", "SAMSUNG S20", "SAMSUNG ZFold"));
        List<String> marklist1 = new ArrayList<>();
        int counter = 1;
        for (String w : markList) {
            if (w.contains(str)) {
                marklist1.add(w);
            }
        }
        for (String w : marklist1) {
            System.out.println(counter + ":" + w);
            counter++;

        }
        System.out.println("lutfen seciminizi yapınız");
        int c = scan.nextInt();
        do {
            if (c > marklist1.size() || c<0) {
                System.out.println("bu numarada bir urun yoktur tekrar deneyiniz");
                c = scan.nextInt();
            } else {
                break;
            }
        } while (true);
        mP.setUrunAdi(marklist1.get(c - 1));

    }

    /*private void apple1(String str, MobilePhonePojo mP) {
        System.out.print("Sectiginiz markanın urununu seciniz ");
        if (str.equals("APPLE")) {
            System.out.println("telefonlardan birini seciniz:\n" +
                    "Iphone 14 icin 1'e\n" +
                    "Iphone 13 icin 2'ye\n" +
                    "Iphone 12 icin 3'e");
            int num = scan.nextInt();
            do {
                if (num > 3 || num < 1) {
                    System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                    str = scan.nextLine();
                } else {
                    break;
                }
            } while (true);
            switch (num) {
                case 1:
                    mP.setUrunAdi("Iphone 14");
                    mP.setBirimFiyat(mP.getBirimFiyat()+2000);
                    System.out.println("fiyat "+mP.getBirimFiyat()+" ₺");
                    break;
                case 2:
                    mP.setUrunAdi("Iphone 13");
                    mP.setBirimFiyat(mP.getBirimFiyat()+1000);
                    System.out.println("fiyat "+mP.getBirimFiyat()+" ₺");
                    break;
                case 3:
                    mP.setUrunAdi("Iphone 12");
                    mP.setBirimFiyat(mP.getBirimFiyat()+500);
                    System.out.println("fiyat "+mP.getBirimFiyat()+" ₺");
                    break;
                default:
                    System.out.println("yanlis girdiniz tekrar deneyiniz");
                    break;
            }
        }

     */


    private void depolamaAlanı(int num, MobilePhonePojo mP) {
        do {
            if (num > 2 || num < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextInt();
            } else {
                break;
            }
        } while (true);
        switch (num) {
            case 1:
                mP.setHafizaInfo(128);
                mP.setBirimFiyat(mP.getBirimFiyat() + 500);
                System.out.println("Depolama alanı 128 GB olarak sectiniz");
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");

                break;
            case 2:
                mP.setHafizaInfo(64);
                System.out.println("Depolama alanı 64 GB olarak sectiniz");
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");

                break;
        }
    }

    private void ekranBoyutu(int num1, MobilePhonePojo mP) {
        do {
            if (num1 > 2 || num1 < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num1 = scan.nextInt();
            } else {
                break;
            }
        } while (true);
        switch (num1) {
            case 1:
                mP.setEkranBoyutu(6.1);
                System.out.println("ekran boyutu 6.1 inc olarak secildi");
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case 2:
                mP.setEkranBoyutu(6.4);
                System.out.println("ekran boyutu 6.4 inc olarak secildi");
                mP.setBirimFiyat(mP.getBirimFiyat() + 500);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                ekranBoyutu(num1, mP);
                break;
        }
    }

    private void kameraSecimi(int num2, MobilePhonePojo mP) {
        do {
            if (num2 > 4 || num2 < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num2 = scan.nextInt();
            } else {
                break;
            }
        } while (true);

        switch (num2) {
            case 1:
                mP.setKameraMps(30);
                System.out.println("30 megapikselli kamera secildi");
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case 2:
                mP.setKameraMps(35);
                System.out.println("35 megapikselli kamera secildi");
                mP.setBirimFiyat(mP.getBirimFiyat() + 500);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case 3:
                mP.setKameraMps(40);
                System.out.println("40 megapikselli kamera secildi");
                mP.setBirimFiyat(mP.getBirimFiyat() + 1000);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case 4:
                mP.setKameraMps(45);
                System.out.println("45 megapikselli kamera secildi");
                mP.setBirimFiyat(mP.getBirimFiyat() + 1500);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");

                break;
        }
    }

    private void ramSecim(int num, MobilePhonePojo mP) {
        do {
            if (num > 3 || num < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextInt();
            } else {
                break;
            }
        } while (true);
        switch (num) {
            case 1:
                mP.setRam(4);
                System.out.println("Ram 4 GB olarak secildi");
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case 2:
                mP.setRam(8);
                System.out.println("Ram 8 GB olarak secildi");
                mP.setBirimFiyat(mP.getBirimFiyat() + 500);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            case 3:
                mP.setRam(16);
                System.out.println("Ram 16 GB olarak secildi");
                mP.setBirimFiyat(mP.getBirimFiyat() + 1500);
                System.out.println("fiyat " + mP.getBirimFiyat() + " ₺");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                break;
        }

    }

    private void renkSecimi(int num, MobilePhonePojo mP) {
        do {
            if (num > 3 || num < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextInt();
            } else {
                break;
            }
        } while (true);
        switch (num) {
            case 1:
                mP.setRenk("SIYAH");
                System.out.println("Siyah rengi sectiniz");
                break;
            case 2:
                mP.setRenk("MAVI");
                System.out.println("Mavi rengi sectiniz");
                break;
            case 3:
                mP.setRenk("KIRMIZI");
                System.out.println("Kırmızı rengi sectiniz");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");

                break;
        }
    }

    private void markaListele() {
        List<Markalar> markList = new ArrayList<>();

        markList.addAll(Arrays.asList(Markalar.values()));

        Collections.sort(markList, (o1, o2) -> o1.toString().compareTo(o2.toString()));

        int count = 1;
        for (Markalar w : markList) {
            if (w.equals(Markalar.HP) || w.equals(Markalar.MONSTER)) {
                continue;
            }

            System.out.println(count + ":" + w);
            count++;
        }

    }

}
