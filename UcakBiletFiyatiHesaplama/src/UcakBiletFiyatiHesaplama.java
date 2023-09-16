import java.util.Scanner;
public class UcakBiletFiyatiHesaplama {
    public static void main(String[] args) {

        // degiskenleri belirleyelim.

        int ucusMesafesi, yolcuYasi, ucusTipi;
        double ucusFiyati=0, kmFiyat=0.10, cocukIndirim=0.50, gencIndirim=0.10, yasliIndirim=0.30, ucusTipiIndirimi=0.20;
        boolean yönTercihi =false;


        Scanner inp= new Scanner(System.in);

        System.out.print("Uçuş Mesafesini Giriniz (km): ");
        ucusMesafesi=inp.nextInt();

        System.out.print("Yaşınızı Giriniz: ");
        yolcuYasi=inp.nextInt();

        System.out.print("Uçuş Yön Tercihinizi Belirtiniz (Tek Yön : 1 & Çift Yön: 2): ");
        ucusTipi=inp.nextInt();


                 // koşulları belirleyelim.

        if(ucusTipi!=1 && ucusTipi!=2){
            yönTercihi=true;
        }
        else{
            ucusFiyati=(ucusTipi==2)? ucusMesafesi*kmFiyat-((ucusMesafesi*kmFiyat)*ucusTipiIndirimi):ucusMesafesi*kmFiyat;

            if(yolcuYasi>=1 && yolcuYasi<=12){

                ucusFiyati=ucusFiyati-(ucusFiyati*cocukIndirim);
            }
            else if(yolcuYasi<=24){

                ucusFiyati=ucusFiyati-(ucusFiyati*gencIndirim);
            }
            else if(yolcuYasi>=65){

                ucusFiyati=ucusFiyati-(ucusFiyati*yasliIndirim);
            }
            else{
                ucusFiyati=ucusFiyati;
            }
        }
        if(yönTercihi){  //yön tercihinin hatalı girildiği koşulda uyarı ekranı veriyoruz.
            System.out.println("Uçuş Yön Seçiminiz Hatalı! Belirtilen Şekilde Tekrardan Tercih Yapınız. ");
        }
        else{
            System.out.println("Bilet Fiyatınız: "+ucusFiyati+" TL");
        }
    }
}