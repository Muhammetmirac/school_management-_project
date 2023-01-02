import java.util.Scanner;

public class School {
   static final String okulAdi="TechPro School";
   static final String adres = "USA";

   private School(){

   }

    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        okulAnasayfa();

    }


    public static void okulAnasayfa() {
        System.out.println("<<<<<<<<<<<<" + okulAdi + ">>>>>>>>>>>>" + "\n       Anasayfasına Hoşgeldiniz");
        System.out.println("Yapılacak işlemi seçiniz" + "\n 1. Öğrenci İşlemleri" + "\n 2. Öğretmen İşlemleri" + "\n 3. Çıkış ");
        int secim = scan.nextInt();

        do {


            switch (secim) {
                case 1:
                    System.out.println("1 - Öğrenci İşlemleri");
                    break;
                case 2:
                    System.out.println("2 - Öğretmen İşlemleri");
                case 3:
                    break;
                default:
                    System.out.println("Hatalı giriiş yaptınız lütfen geçerli bir giriş yapınız");
            }
        }while (true);
    }


}
