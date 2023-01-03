package deadlockstore;

import java.util.*;

public class Notebook implements Repository{
    static Scanner scan=new Scanner(System.in);
    static Map<Integer,NotebookPojo> noteMap=new HashMap<>();
    static int count=-1000;


    @Override
    public void urunEkle() {
        /*
        1:APPLE
        2:ASUS
        3:CASPER
        4:HP
        5:HUAWEI
        6:LENOVO
        7:MONSTER
        8:SAMSUNG
         */
        NotebookPojo nP=new NotebookPojo();
        System.out.println("Telefon icin urun ekleme bölümündesiniz");
        System.out.println("lutfen bilgileri giriniz:");
        System.out.print("urunun markasini seciniz");
        System.out.println("Marka Listesi ve MarkaKodu: ");
        markaListele();
        String urunMark = scan.nextLine();
        urunSecimi(urunMark, nP);

        System.out.print("depolama alanı seciniz\n" +
                "256 gb icin 1'e basınız\n" +
                "512 GB icin 2'ye basınız\n" +
                "1 TR icin 3'e basınız: ");
        int num = scan.nextInt();
        depolamaAlani(num, nP);

        System.out.print("ekran boyutu seciniz\n" +
                "14 inc icin 1'e basınız\n" +
                "16 inc icin 2'ye basınız: ");
        int num1 = scan.nextInt();
        ekranBoyutu(num1, nP);

        System.out.println("RAM icin secim yapınız\n" +
                "8 GB icin 1'e basınız\n" +
                "16 GB icin 2'e basınız\n" +
                "32 GB icin 3'e basınız\n");
        int num3 = scan.nextInt();
        ramSecim(num3, nP);

        System.out.println("lutfen Renk secimi yapınız\n" +
                "Siyah icin 1'e\n" +
                "Mavi icin 2'ye\n" +
                "Kirmizi icin 3'e basınız");
        int num4 = scan.nextInt();
        scan.nextLine();
        renkSecimi(num4, nP);

        NotebookPojo npj=new NotebookPojo(nP.getUrunAdi(),nP.getBirimFiyat(), nP.getMarkaInfo(), nP.getRamNo(), nP.getDepolInfo(), nP.getEkranB(), nP.getRenkN() );
        npj.setUrunId(count);
        noteMap.put( npj.getUrunId(),npj);
        count--;


    }
    @Override
    public void urunSil() {
        Set<Integer> mapKeys=new HashSet<>();
        mapKeys.addAll(noteMap.keySet());
        for (Integer w:mapKeys) {
            System.out.println(w+":"+noteMap.get(w).getUrunAdi());
        }
        try {
            while(true) {
                System.out.println("silmek istediginiz urunun kodunu giriniz");
                System.out.println("cikis yapmak icin a basiniz:");
                String count= scan.nextLine();
                if (count.equalsIgnoreCase("a")) {
                    break;
                } else {
                    if (!noteMap.containsKey(Integer.parseInt(count))) {
                        System.out.println("böyle bir id numarası yoktur tekrar deneyiniz");
                        urunSil();
                    } else {
                        noteMap.remove(Integer.parseInt(count));
                        System.out.println("ürün basarıyla silindi");
                    }
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
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |Renk    |");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (NotebookPojo w : noteMap.values()) {
            System.out.printf("%-5s %-31S %-11s %-12s %-12s %-11.1f %-11s %-11S %n", w.getUrunId(), w.getUrunAdi(), w.getBirimFiyat(), w.getMarkaInfo(),w.getDepolInfo(),
                    w.getEkranB(),w.getRamNo(),w.getRenkN());
        }

    }

    private void renkSecimi(int num4, NotebookPojo nP) {
        do {
            if (num4 > 3 || num4 < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num4 = scan.nextInt();
            } else {
                break;
            }
        } while (true);
        switch (num4) {
            case 1:
                nP.setRenkN("SIYAH");
                System.out.println("Siyah rengi sectiniz");
                break;
            case 2:
                nP.setRenkN("MAVI");
                System.out.println("Mavi rengi sectiniz");
                break;
            case 3:
                nP.setRenkN("KIRMIZI");
                System.out.println("Kırmızı rengi sectiniz");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");

                break;
        }
    }

    private void ramSecim(int num1, NotebookPojo nP) {
        do {
            if (num1 > 3 || num1 < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num1 = scan.nextInt();
            } else {
                break;
            }
        } while (true);
        switch (num1) {
            case 1:
                nP.setRamNo(8);
                System.out.println("Ram 8 GB olarak secildi");
                System.out.println("fiyat "+nP.getBirimFiyat()+" ₺");
                break;
            case 2:
                nP.setRamNo(16);
                System.out.println("Ram 16 GB olarak secildi");
                nP.setBirimFiyat(nP.getBirimFiyat()+1500);
                System.out.println("fiyat "+nP.getBirimFiyat()+" ₺");
                break;
            case 3:
                nP.setRamNo(32);
                System.out.println("Ram 32 GB olarak secildi");
                nP.setBirimFiyat(nP.getBirimFiyat()+1500);
                System.out.println("fiyat "+nP.getBirimFiyat()+" ₺");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                break;
        }
    }

    private void ekranBoyutu(int num1, NotebookPojo nP) {
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
                nP.setEkranB(14);
                System.out.println("ekran boyutu 6.1 inc olarak secildi");
                System.out.println("fiyat "+nP.getBirimFiyat()+" ₺");
                break;
            case 2:
                nP.setEkranB(16);
                System.out.println("ekran boyutu 6.4 inc olarak secildi");
                nP.setBirimFiyat(nP.getBirimFiyat()+1500);
                System.out.println("fiyat "+nP.getBirimFiyat()+" ₺");
                break;
            default:
                System.out.println("yanlis secim yaptınız tekrar deneyiniz ");
                ekranBoyutu(num1, nP);
                break;
        }
    }

    private void depolamaAlani(int num, NotebookPojo nP) {
        do {
            if (num > 3 || num < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextInt();
            } else {
                break;
            }
        }while (true);
            switch (num) {
                case 1:
                    nP.setDepolInfo(256);
                    System.out.println("256 gb depolama alanı sectiniz. Fiyat: " + nP.getBirimFiyat());
                    break;
                case 2:
                    nP.setDepolInfo(512);
                    nP.setBirimFiyat(nP.getBirimFiyat() + 500);
                    System.out.println("512 gb depolama alanı sectiniz. Fiyat: " + nP.getBirimFiyat());
                    break;
                case 3:
                    nP.setDepolInfo(1000);
                    nP.setBirimFiyat(nP.getBirimFiyat() + 1500);
                    System.out.println("1 Tr depolama alanı sectiniz. Fiyat: " + nP.getBirimFiyat());
                    break;
                default:
                    System.out.println("yanlis secim yaptınız tekrar deneyiniz");
                    break;
            }

    }


    private void urunSecimi(String num, NotebookPojo nP) {
        do {
            if (Integer.parseInt(num) > 8 || Integer.parseInt(num) < 1) {
                System.out.println("girdiginiz aralıkta herhangi bir secim yapamazsınız tekrar deneyiniz");
                num = scan.nextLine();
            } else {
                break;
            }
        } while (true);
        switch (num){
            case "1":
                num=String.valueOf(Markalar.APPLE);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.APPLE+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
            case "2":
                num=String.valueOf(Markalar.ASUS);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.ASUS+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
            case "3":
                num=String.valueOf(Markalar.CASPER);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.CASPER+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
            case "4":
                num=String.valueOf(Markalar.HP);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.HP+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
            case "5":
                num=String.valueOf(Markalar.HUAWEI);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.HUAWEI+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
            case "6":
                num=String.valueOf(Markalar.LENOVO);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.LENOVO+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
            case "7":
                num=String.valueOf(Markalar.MONSTER);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.MONSTER+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
            case "8":
                num=String.valueOf(Markalar.SAMSUNG);
                nP.setUrunAdi(num);
                nP.setBirimFiyat(2000);
                System.out.println("marka olarak "+Markalar.SAMSUNG+"\n"+" sectiniz baslangic ücreti: "+nP.getBirimFiyat()+" ₺");
                break;
        }
        classSecimi(nP,num);
    }

    private void classSecimi(NotebookPojo nP, String num) {
        nP.setMarkaInfo(num);
        List<String>markList=new ArrayList<>(Arrays.asList("APPLE Macbook pro 13","APPLE Macbook pro 14","APPLE Macbook Air","ASUS VivoBook Pro","ASUS Tuf Gamin","CASPER Excalibur","CASPER Nirvana",
                "LENOVO IdeaPad 3","LENOVO V15","MONSTER Abra","MONSTER Huma","HUAWEI mateBook 14","HUAWEI mateBook 15","SAMSUNG Galaxy Book2","SAMSUNG QVO","HP Victus 16","HP Victus Gaming"));
        List<String>marklist1=new ArrayList<>();
        int counter=1;
        for (String w:markList) {
            if (w.contains(num)){
                marklist1.add(w);
            }
        }
        for (String w:marklist1) {
            System.out.println(counter+":"+w);
            counter++;

        }
        System.out.println("lutfen seciminizi yapınız");
        int c= scan.nextInt();
       do {
           if (c>marklist1.size()){
               System.out.println("bu numarada bir urun yoktur tekrar deneyiniz");
               c= scan.nextInt();
           }else {
               break;
           }
       }while (true);
        nP.setUrunAdi(marklist1.get(c-1));
    }

    public void markaListele() {
    List<Markalar> markList=new ArrayList<>();
    markList.addAll(Arrays.asList(Markalar.values()));
    Collections.sort(markList,(o1,o2)->o1.toString().compareTo(o2.toString()));
    int count =1;
        for (Markalar w:markList) {
            if (w.equals(Markalar.XIAOMI)) {
                continue;
            }
            System.out.println(count+":"+w);
            count++;
        }
    }

}
