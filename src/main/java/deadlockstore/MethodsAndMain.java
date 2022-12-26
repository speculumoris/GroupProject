package deadlockstore;

import java.util.*;

public class MethodsAndMain {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        anaEkran();


    }

    public static void anaEkran() {
        boolean flag = true;
        do {
            System.out.println("Ürün Yönetim Paneli !\n" +
                    "1 - Notebook İşlemleri\n" +
                    "2 - Cep Telefonu İşlemleri\n" +
                    "3 - Marka Listele\n" +
                    "4 - Çıkış Yap");

            int num1 = scan.nextInt();
            if (num1 == 1) {
                System.out.println("1'i sectiniz. Notebook islemleri sayfasına yönlendiriliyorsunuz");
                notebookIslemleriEkrani();
            } else if (num1 == 2) {
                System.out.println("2'yi sectiniz. Cep Telefonu islemleri sayfasına yönlendiriliyorsunuz");
                mobilePhoneIslemleriEkrani();

            } else if (num1 == 3) {
                System.out.println("3'ü sectiniz. Markalar listeleniyor..");
                markaListele();
                System.out.println("**********");
                anaEkran();

            } else if (num1 == 4) {
                cikis(num1);
                flag = false;

            } else {
                System.out.println("hatali giris yaptiniz canim");
            }
        } while (flag);
    }

    private static void cikis(int num1) {
        boolean flag = true;
        do {
            if (num1 == 4) {
                flag = false;
            }
            System.out.println("cikisiniz yapildi.");
        } while (flag);
    }


    private static void markaListele() {

        List<Markalar> markList = new ArrayList<>(Arrays.asList(Markalar.values()));

        Collections.sort(markList, (o1, o2) -> o1.toString().compareTo(o2.toString()));

        int count = 1;
        for (Markalar w : markList) {
            System.out.println(count + ":" + w);
            count++;
        }
    }

    private static void mobilePhoneIslemleriEkrani() {
        MobilePhone mobilePhone = new MobilePhone();
        do {
            System.out.println("\nyapmak istediginiz işlemi seçiniz\n" +
                    "Urun eklemek icin 1'i\n" +
                    "Urun silmek icin 2'yi\n" +
                    "Urunleri listelemek icin 3'ü\n" +
                    "ana ekrana dönmek icin 4'ü" +
                    " Tuşlayınız");

            int num = scan.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Urun ekleme kısmına yönlendiriliyorsunuz..");
                    mobilePhone.urunEkle();
                    break;
                case 2:
                    System.out.println("ürün silme kısmına yönlendiriliyorsunuz..");
                    mobilePhone.urunSil();
                    break;
                case 3:
                    System.out.println("Urunler listeleniyor..");
                    mobilePhone.urunListele();
                    break;
                case 4:
                    System.out.println("Ana ekrana yönlendiriliyorsunuz");
                    anaEkran();
                    break;
                default:
                    System.out.println("yanlis giris yaptınız tekrar deneyiniz");
                    mobilePhoneIslemleriEkrani();
                    break;
            }
        } while (true);
    }

    private static void notebookIslemleriEkrani() {
        Notebook nb = new Notebook();
        boolean flag = true;

        do {
            System.out.println("\nyapmak istediginiz işlemi seçiniz\n" +
                    "Urun eklemek icin 1'i\n" +
                    "Urun silmek icin 2'yi\n" +
                    "Urunleri listelemek icin 3'ü\n" +
                    "ana ekrana dönmek icin 4'ü" +
                    " Tuşlayınız");

            int num = scan.nextInt();
            if (num == 1) {

                System.out.println("Urun ekleme kısmına yönlendiriliyorsunuz..");
                nb.urunEkle();
            } else if (num == 2) {
                System.out.println("ürün silme kısmına yönlendiriliyorsunuz..");
                nb.urunSil();
            } else if (num == 3) {
                System.out.println("Urunler listeleniyor..");
                nb.urunListele();
            } else if (num == 4) {

                System.out.println("Ana ekrana yönlendiriliyorsunuz");
                anaEkran();
                flag = false;
            } else {
                System.out.println("yanlis giris yaptınız tekrar deneyiniz");
                notebookIslemleriEkrani();
            }
        } while (flag);
    }

}
