package deadlockstore;

import java.util.Scanner;

public class MethodsAndMain {
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
       anaEkran();


    }
    public static void anaEkran(){
        System.out.println("Ürün Yönetim Paneli !\n" +
                "1 - Notebook İşlemleri\n" +
                "2 - Cep Telefonu İşlemleri\n" +
                "3 - Marka Listele\n" +
                "0 - Çıkış Yap");
        int num1=scan.nextInt();
        switch (num1){
            case 1:
                System.out.println("1'i secitiniz. Notebook islemleri sayfasına yönlendiriliyorsunuz");
                notebookIslemleriEkrani();
                anaEkran();
                break;
            case 2:
                System.out.println("2'yi secitiniz. Cep Telefonu islemleri sayfasına yönlendiriliyorsunuz");
                mobilePhoneIslemleriEkrani();
                break;
            case 3:
                System.out.println("3'ü sectiniz. Markalar listeleniyor..");
                markaListele();
            case 0:
                System.out.println("çıkışınız yapılıyor..");
                cikis();
                break;
            default:
                System.out.println("hatali giris yaptiniz canim");
                break;
        }

    }

    private static void cikis() {
    }

    private static void markaListele() {
    }

    private static void mobilePhoneIslemleriEkrani() {
        MobilePhone mobilePhone=new MobilePhone();
       do {
           System.out.println("yapmak istediginiz işlemi seçiniz\n" +
                   "Urun eklemek icin 1'i\n" +
                   "Urun silmek icin 2'yi\n" +
                   "Urunleri listelemek icin 3'ü\n" +
                   "ana ekrana dönmek icin 4'ü" +
                   " Tuşlayınız");

           int num1 = scan.nextInt();
           switch (num1) {
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
       }while (true);
    }

    private static void notebookIslemleriEkrani() {
    }

}
