package deadlockstore;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        System.out.println("Marka Listesi ve MarkaKodu:\n" +
                "    APPLE(1000),\n" +
                "    SAMSUNG(1001),\n" +
                "    LENOVO(1002),\n" +
                "    HUAWEI(1003),\n" +
                "    CASPER(1004),\n" +
                "    ASUS(1005),\n" +
                "    HP(1006),\n" +
                "    XIAOMI(1007),\n" +
                "    MONSTER(1008);");


        String urunMark = scan.nextLine();
        urunSecimi(urunMark,mP);

        System.out.print("urun adını giriniz: ");
        mP.setUrunAdi(scan.nextLine());

        System.out.print("depolama alanı seciniz\n" +
                "128 gb icin 1'e basınız\n" +
                "64 GB icin 2'ye basınız: ");
        int num = scan.nextInt();
        depolamaAlanı(num,mP);

        System.out.print("ekran boyutu seciniz\n" +
                "6.1 inc icin 1'e basınız\n" +
                "6.4 inc icin 2'ye basınız: ");
        int num1= scan.nextInt();
        ekranBoyutu(num1,mP);

        System.out.println("Kamera mps secim yapınız\n" +
                "30 Megapiksel icin 1'e basınız\n" +
                "35 Megapiksel icin 2'e basınız\n" +
                "40 Megapiksel icin 3'e basınız\n" +
                "45 Megapiksel icin 4'e basınız: ");
        int num2= scan.nextInt();
        kameraSecimi(num2,mP);

        System.out.println("RAM icin secim yapınız\n" +
                "4 GB icin 1'e basınız\n" +
                "8 GB icin 2'e basınız\n" +
                "16 GB icin 3'e basınız\n");
        int num3= scan.nextInt();
        ramSecim(num3,mP);

        System.out.println("lutfen Renk secimi yapınız\n" +
                "Siyah icin 1'e\n" +
                "Mavi icin 2'ye\n" +
                "Kirmizi icin 3'e basınız");
        int num4= scan.nextInt();scan.nextLine();
        renkSecimi(num4,mP);
        mP.setId(count);
        MobilePhonePojo mpOptions=new MobilePhonePojo(mP.getBirimFiyat(), mP.getMarkaInfo(), mP.getUrunAdi(), mP.getHafizaInfo(),
                                                         mP.getEkranBoyutu(), mP.getKameraMps(), mP.getPilGucu(), mP.getRam(), mP.getRenk());

        mobilePhoneMap.put(count,mpOptions);
        count++;
        System.out.println("Urun basarıyla eklendi\n" +
                "urun bilgileri:"+mobilePhoneMap.toString());

    }
    @Override
    public void urunSil() {

    }

    @Override
    public void urunListele() {
        MobilePhonePojo mP=new MobilePhonePojo();
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s,%-32S,%-12s,%-12s,%-12s,%-12f,%-12f,%-12s,%-12s,%n", mP.getId(), mP.getUrunAdi(),mP.getBirimFiyat(),mP.getMarkaInfo(),
                mP.getHafizaInfo(), mP.getEkranBoyutu(),
                mP.getKameraMps(), mP.getPilGucu(), mP.getRam(), mP.getRenk());

    }
    public void urunSecimi(String str,MobilePhonePojo mP){
        if (str.equalsIgnoreCase("Apple")){
            str=String.valueOf(Markalar.APPLE);
            System.out.println("Marka seciminiz: "+Markalar.APPLE);
        } else if (str.equalsIgnoreCase("Samsung")){
            str=String.valueOf(Markalar.SAMSUNG);
            System.out.println("Marka seciminiz: "+Markalar.SAMSUNG);
        }else if (str.equalsIgnoreCase("Lenovo")){
            str=String.valueOf(Markalar.LENOVO);
            System.out.println("Marka seciminiz: "+Markalar.LENOVO);
        }else if (str.equalsIgnoreCase("Huawei")){
            str=String.valueOf(Markalar.HUAWEI);
            System.out.println("Marka seciminiz: "+Markalar.HUAWEI);
        }else if (str.equalsIgnoreCase("Casper")){
            str=String.valueOf(Markalar.CASPER);
            System.out.println("Marka seciminiz: "+Markalar.CASPER);
        }else if (str.equalsIgnoreCase("Xiaomi")){
            str=String.valueOf(Markalar.XIAOMI);
            System.out.println("Marka seciminiz: "+Markalar.XIAOMI);
        }else if (str.equalsIgnoreCase("Monster")){
            str=String.valueOf(Markalar.MONSTER);
            System.out.println("Marka seciminiz: "+Markalar.MONSTER);
        }else if (str.equalsIgnoreCase("Hp")){
            str=String.valueOf(Markalar.HP);
            System.out.println("Marka seciminiz: "+Markalar.HP);
        }else if (str.equalsIgnoreCase("Asus")){
            str=String.valueOf(Markalar.ASUS);
            System.out.println("Marka seciminiz: "+Markalar.ASUS);
        }else {
            System.out.println("Girdiginiz marka listemizde yoktur.\n" +
                    "lutfen gecerli bir marka giriniz");
        }
        classSecim(str,mP);
    }

    private void classSecim(String str,MobilePhonePojo mP) {
        mP.setMarkaInfo(Markalar.valueOf(str));

    }

    private void depolamaAlanı(int num,MobilePhonePojo mP){
        switch (num){
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
                break;
        }
    }
    private void ekranBoyutu(int num1,MobilePhonePojo mP) {
        switch (num1){
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
                break;
        }
    }
    private void kameraSecimi(int num2,MobilePhonePojo mP) {

        switch (num2){
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
                break;
        }
    }
    private void ramSecim(int num3,MobilePhonePojo mP) {
        switch (num3){
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
                break;
        }

    }
    private void renkSecimi(int num4, MobilePhonePojo mP) {
        switch (num4){
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
        }
    }

}
