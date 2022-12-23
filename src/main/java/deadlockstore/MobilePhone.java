package deadlockstore;

import com.sun.jdi.Value;

import java.util.*;

public class MobilePhone implements Repository {

    static Scanner scan = new Scanner(System.in);
    static int count = 1;
    static Map<Integer, MobilePhonePojo> mobilePhoneMap = new HashMap<>();


    @Override
    public void urunEkle() {
        MobilePhonePojo mP = new MobilePhonePojo();
        System.out.println("urun ekleme bölümündesiniz");
        System.out.println("lutfen bilgileri giriniz:");
        System.out.print("urunun markasini seciniz");
        System.out.println("Marka Listesi ve MarkaKodu: ");
        markaListele();
        String urunMark = scan.nextLine();
        urunSecimi(urunMark, mP);

        System.out.print("urun adını giriniz: ");
        mP.setUrunAdi(scan.nextLine());

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



        mP.setId(count);
        count++;
        MobilePhonePojo mpOptions = new MobilePhonePojo(mP.getBirimFiyat(), mP.getMarkaInfo(), mP.getUrunAdi(), mP.getHafizaInfo(),
                mP.getEkranBoyutu(), mP.getKameraMps(), mP.getPilGucu(), mP.getRam(), mP.getRenk());

        mobilePhoneMap.put(mP.getId(), mpOptions);

        System.out.println("Urun basarıyla eklendi\n" +
                "urun bilgileri:" + mobilePhoneMap.toString());
        fiyatHesabı(mobilePhoneMap);

    }

    public void fiyatHesabı(Map<Integer, MobilePhonePojo> mobilePhoneMap) {

        List<MobilePhonePojo> mpList = new ArrayList<>(mobilePhoneMap.values());
        System.out.println(mpList);
        Iterator<MobilePhonePojo>mpIt=mpList.iterator();

        while(mpIt.hasNext()){
            MobilePhonePojo mp=mpIt.next();

        for (MobilePhonePojo w: mpList) {
            if (w.getHafizaInfo() == 64) {
                double a = w.getHafizaInfo();
                a = w.getHafizaInfo() - a;
                if (a >= 5) {
                    w.setBirimFiyat(w.getBirimFiyat() + 500);
                }
            }
            if (w.getEkranBoyutu() > 6.1) {
                double a = w.getEkranBoyutu();
                a = w.getEkranBoyutu() - a;
                if (a >= 5) {
                    w.setBirimFiyat(w.getBirimFiyat() + 500);
                }
            }
            if (w.getKameraMps() > 35) {
                double a = w.getKameraMps();
                a = w.getKameraMps() - a;
                if (a >= 5) {
                    w.setBirimFiyat(w.getBirimFiyat() + 500);
                }
            }
            if (w.getRam() > 4) {
                double a = w.getRam();
                a = w.getRam() - a;
                if (a >= 4) {
                    w.setBirimFiyat(w.getBirimFiyat() + 500);
                }
            }
        }
        }
    }


    @Override
    public void urunSil() {
        System.out.println("silmek istediginiz urunun kodunu giriniz");
        int codeName = scan.nextInt();
        for (MobilePhonePojo w : mobilePhoneMap.values()) {
            mobilePhoneMap.remove(codeName);
            if (!mobilePhoneMap.containsKey(codeName)) {
                System.out.println("böyle bir id numarası yoktur tekrar deneyiniz");
                urunSil();
            }
        }
    }

    @Override
    public void urunListele() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhonePojo w : mobilePhoneMap.values()) {
            System.out.printf("%-5s %-31S %-11s %-12s %-12.2s %-11.1f %-11.1f %-11s %-11s %-11S %n", w.getId(), (w.getMarkaInfo() + " " + w.getUrunAdi()), w.getBirimFiyat(), w.getMarkaInfo(),
                    w.getHafizaInfo(), w.getEkranBoyutu(),
                    w.getKameraMps(), w.getPilGucu(), w.getRam(), w.getRenk());
        }


    }

    public void urunSecimi(String str, MobilePhonePojo mP) {
        do {
            if (Integer.parseInt(str) > 7 || Integer.parseInt(str) < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                str = scan.nextLine();
            }else {
                break;
            }
        } while (true);

        switch (str) {
            case "1":
                str = String.valueOf(Markalar.APPLE);
                System.out.println("Marka seciminiz: " + Markalar.APPLE);
                break;
            case "6":
                str = String.valueOf(Markalar.SAMSUNG);
                System.out.println("Marka seciminiz: " + Markalar.SAMSUNG);
                break;
            case "5":
                str = String.valueOf(Markalar.LENOVO);
                System.out.println("Marka seciminiz: " + Markalar.LENOVO);
                break;
            case "4":
                str = String.valueOf(Markalar.HUAWEI);
                System.out.println("Marka seciminiz: " + Markalar.HUAWEI);
                break;
            case "3":
                str = String.valueOf(Markalar.CASPER);
                System.out.println("Marka seciminiz: " + Markalar.CASPER);
                break;
            case "7":
                str = String.valueOf(Markalar.XIAOMI);
                System.out.println("Marka seciminiz: " + Markalar.XIAOMI);
                break;
            case "2":
                str = String.valueOf(Markalar.ASUS);
                System.out.println("Marka seciminiz: " + Markalar.ASUS);
                break;
        }
        classSecim(str, mP);
    }

    private void classSecim(String str, MobilePhonePojo mP) {
        mP.setMarkaInfo(Markalar.valueOf(str));
    }

    private void depolamaAlanı(int num, MobilePhonePojo mP) {
        do {
            if (num > 2 || num< 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextInt();
            }else {
                break;
            }
        } while (true);
        switch (num) {
            case 1:
                mP.setHafizaInfo(128);
                System.out.println("Depolama alanı 128 GB olarak sectiniz");
                break;
            case 2:
                mP.setHafizaInfo(64);
                System.out.println("Depolama alanı 64 GB olarak sectiniz");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                depolamaAlanı(num, mP);
                break;
        }
    }

    private void ekranBoyutu(int num1, MobilePhonePojo mP) {
        do {
            if (num1 > 2 || num1< 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num1 = scan.nextInt();
            }else {
                break;
            }
        } while (true);
        switch (num1) {
            case 1:
                mP.setEkranBoyutu(6.1);
                System.out.println("ekran boyutu 6.1 inc olarak secildi");
                break;
            case 2:
                mP.setEkranBoyutu(6.4);
                System.out.println("ekran boyutu 6.4 inc olarak secildi");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                ekranBoyutu(num1, mP);
                break;
        }
    }

    private void kameraSecimi(int num2, MobilePhonePojo mP) {
        do {
            if (num2 > 4 || num2< 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num2 = scan.nextInt();
            }else {
                break;
            }
        } while (true);

        switch (num2) {
            case 1:
                mP.setKameraMps(30);
                System.out.println("30 megapikselli kamera secildi");
                break;
            case 2:
                mP.setKameraMps(35);
                System.out.println("35 megapikselli kamera secildi");
                break;
            case 3:
                mP.setKameraMps(40);
                System.out.println("40 megapikselli kamera secildi");
                break;
            case 4:
                mP.setKameraMps(45);
                System.out.println("45 megapikselli kamera secildi");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                kameraSecimi(num2, mP);
                break;
        }
    }

    private void ramSecim(int num, MobilePhonePojo mP) {
        do {
            if (num > 3 || num< 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextInt();
            }else {
                break;
            }
        } while (true);
        switch (num) {
            case 1:
                mP.setRam(4);
                System.out.println("Ram 4 GB olarak secildi");
                break;
            case 2:
                mP.setRam(8);
                System.out.println("Ram 8 GB olarak secildi");
                break;
            case 3:
                mP.setRam(16);
                System.out.println("Ram 16 GB olarak secildi");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                ramSecim(num, mP);
                break;
        }

    }

    private void renkSecimi(int num, MobilePhonePojo mP) {
        do {
            if (num > 3 || num< 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextInt();
            }else {
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
