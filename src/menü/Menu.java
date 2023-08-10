package menü;

import bankauygulamasi.Bank;
import java.text.ParseException;
import java.util.Scanner;


public class Menu {
    Scanner scan = new Scanner(System.in);
    Bank banka;

    public Menu(Bank banka) {
        this.banka = banka;
    }
    
    
    
    public void start() throws ParseException{
        karsilamaEkrani();
    }
    
    private void karsilamaEkrani() throws ParseException{
        
        System.out.println("*****  Ciftlik Bank'a Hoşgeldiniz  *****");
        System.out.println("Hangi işlemi yapmak istersiniz?");
        
        secim();
    }
    private void secim() throws ParseException{
        System.out.println("****************************************************");//12 tane
        
        
        secimBasliklari();
        System.out.println("---------------------------------------------------------");
        
        
        boolean flag = false;
        int secim;
        while(flag != true){
            secim = scan.nextInt();
            switch (secim){
                case 1:
                    System.out.println("kaç TL yüklensin ?");
                    {int miktar = scan.nextInt();
                    banka.createCariHesap(miktar);}
                    
                    secimBasliklari();
                    break;
                case 2: 
                    System.out.println("kaç TL yüklensin ? (1000TL altında yükleme yapılamaz.)");
                    {int miktar = scan.nextInt();
                    banka.createKisaHesap(miktar);}
                    
                    secimBasliklari();
                    break;
                case 3: 
                    System.out.println("kaç TL yüklensin ? (1500 TL altında yükleme yapılamaz.)");
                    {int miktar = scan.nextInt();
                    banka.createUzunHesap(miktar);}
                    
                    secimBasliklari();
                    break;
                case 4: 
                    System.out.println("kaç TL yüklensin ? (En az 1TL yatırılabilir.)");
                    {
                        int miktar = scan.nextInt();
                        banka.createOzelHesap(miktar);
                    }
                    
                    secimBasliklari();
                    break;
                case 5: 
                    banka.showIDs();
                    System.out.println("Hangi hesaba para yatırmak istersiniz? \nLütfen hesap numarasını giriniz.");
                    {   
                        int ID = scan.nextInt();
                        System.out.println("Kaç TL yatırmak istersiniz?");
                        int cash = scan.nextInt();
                        banka.increase(ID, cash);
                    }
                    
                    secimBasliklari();
                    break;
                case 6: 
                    banka.showIDs();
                    System.out.println("Hangi hesaptan para çekmek istersiniz? \nLütfen hesap numarasını giriniz.");
                    {   
                        int ID = scan.nextInt();
                        int index =accsIndexBul(ID);
                        System.out.println("Hesapta "+banka.accs[index].getBalance()+"TL vardir.");
                        System.out.println("Kaç TL çekmek istersiniz?");
                        int cash = scan.nextInt();
                        banka.decrease(ID, cash);
                        System.out.println("Kalan bakiye: "+banka.accs[index].getBalance());
                    }
                    
                    secimBasliklari();
                    break;
                case 7:
                    banka.showAccount();
                    secimBasliklari();
                    break;
                case 8: 
                    banka.showIDs();
                    secimBasliklari();
                    break;
                case 9:
                    banka.showIDs();
                    System.out.println("işlem yapmak istediğiniz hesap numarasını giriniz:");
                    {   
                        int hesapNo = scan.nextInt();
                        int i = accsIndexBul(hesapNo);
                        if(i == -1){
                            System.out.println("boyle bir hesap yoktur. işlem iptal edilmiştir.");
                            
                            secimBasliklari();
                            break;
                        }
                        
                        
                        System.out.println("");
                        hesapNoIleIslemYap(hesapNo);
                    }
                    
                    secimBasliklari();
                    break;
                case 10: 
                    System.out.println("Banka işlem Tarihi: "+banka.getDate());
                    
                    secimBasliklari();
                    break;
                case 11: 
                    System.out.println("Banka işlem tarihini değiştirmek üzeresiniz!");
                    System.out.println("Bankanın işlem tarihi:"+banka.getDate());
                    {
                        try{
                        System.out.print("gün:");
                        int gun = scan.nextInt();
                        if(gun>31 || gun <1){
                            System.out.println("hatalı giriş yaptınız. gun 1-31 arası girilebilir.");
                            secimBasliklari();
                            break;
                        }
                        System.out.print("ay:");
                        int ay = scan.nextInt();
                        if(ay>12 || ay <1){
                            System.out.println("hatalı giriş yaptınız. ay 1-12 arası girilebilir.");
                            secimBasliklari();
                            break;
                        }
                        System.out.print("yıl:");
                        int yil = scan.nextInt();
                        if(yil<0){
                            System.out.println("hatalı giriş yaptınız. yil 0 dan başlar.");
                            secimBasliklari();
                            break;
                        }
                        banka.set_gun_ay_yil(gun, ay, yil);
                        System.out.println(gun+"."+ay+"."+yil+" olarak tarih değiştirilmiştir.");
                        }catch(Exception e){
                            System.out.println("set gun ay yıl olumsuz. tekrar dene. işlem gerçekleşmemiştir.");
                            secimBasliklari();
                        }
                    }
                    secimBasliklari();
                    break;
                case 12:
                    System.out.println("Bu günün Tarihi: "+banka.getDateNow());
                    
                    secimBasliklari();
                    break;
                case 13: 
                    System.out.println("Özel hesaplar arası çekiliş başlıyor.");
                    banka.sortition();
                    
                    secimBasliklari();
                    break;
                case 14:
                    System.out.println("Banka işlem tarihi:"+banka.getDate());
                    System.out.println("işlem yapmadan önce sistem tarihini değiştirmek ister misin ? \nevet: (e) hayr: (h) ");
                    {
                        String str = scan.next();
                        if(str.equals("e")){
                        System.out.print("gün:");
                        int gun = scan.nextInt();
                        if(gun>31 || gun <1){
                            System.out.println("hatalı giriş yaptınız. gun 1-31 arası girilebilir.");
                            secimBasliklari();
                            break;
                        }
                        System.out.print("ay:");
                        int ay = scan.nextInt();
                        if(ay>12 || ay <1){
                            System.out.println("hatalı giriş yaptınız. ay 1-12 arası girilebilir.");
                            secimBasliklari();
                            break;
                        }
                        System.out.print("yıl:");
                        int yil = scan.nextInt();
                        if(yil<0){
                            System.out.println("hatalı giriş yaptınız. yil 0 dan başlar.");
                            secimBasliklari();
                            break;
                        }
                            banka.set_gun_ay_yil(gun, ay, yil);
                            System.out.println(gun+"."+ay+"."+yil+" olarak tarih değiştirilmiştir.");
                            faizleriHesaplaraYatir();
                        }
                        else if(str.equals("h")){
                            faizleriHesaplaraYatir();
                            
                        }else{
                            System.out.println("yanliş seçim yaptınız. işlem gerçekleşmemiştir.");
                        }
                    }
                    secimBasliklari();
                    break;
                case 15:
                    System.out.println("System kapatılıyor.");
                    flag = true;
                    
                    break;
                default:
                    System.out.println("Sacede 1-14 arası seçim kabul edilir. Tekrar seç:");
                    secimBasliklari();
                    break;
            }
            System.out.println("---------------------------------------------------------");
        }
        
        System.out.println("****************************************************");
    }
    
    private void secimBasliklari(){
        System.out.println("---------------------------------------------------------");
        System.out.println(" 1: Cari  hesap oluşturmak");
        System.out.println(" 2: Kısa vadeli hesap oluşturmak");
        System.out.println(" 3: Uzun vadeli hesap oluşturmak");
        System.out.println(" 4: Özel vadeli hesap oluşturmak");
        System.out.println(" 5: Hesap numarası ile para yatırmak");
        System.out.println(" 6: Hesap numarası ile para çekmek");
        System.out.println(" 7: Tüm hesapları son beş işlem ile birlikte görüntülemek");
        System.out.println(" 8: Tüm hesap numaralarını görmek");
        System.out.println(" 9: Secilen hesap numarasına göre işlemler yapmak");
        System.out.println("10: Banka işlem tarihini görmek");
        System.out.println("11: Banka'nın işlem tarihini değiştirmek");
        System.out.println("12: Bu günün tarihini görmek");
        System.out.println("13: Özel hesaplar arası çekiliş yapmak");
        System.out.println("14: faizleri hesaplara yatırmak");
        System.out.println("15: Sistemi kapatmak");
        System.out.println("\n için gerekli sayiyi girniz.");
        
    }
    private void hesapNoIleIslemYap(int hesapNo){
        
        IDileSecimBasliklari();
        
        
        
        boolean flag2 = false;
        String secim;
        int index = accsIndexBul(hesapNo);
        
        while(flag2 != true){
            
            secim = scan.next();
            
            if(secim.equals("1")){
                System.out.println("hesapta: "+banka.accs[index].getBalance()+"TL mevcuttur.");
                IDileSecimBasliklari();
            }
            else if(secim.equals("2")){
                System.out.println("Mevcut bakiye: "+banka.accs[index].getBalance());
                    System.out.println("Kaç tl çekmek istersiniz?");
                    {
                        int cash = scan.nextInt();
                        banka.accs[index].withdarw(cash);
                    }
                    IDileSecimBasliklari();
            }
            else if(secim.equals("3")){
                System.out.println("Kaç tl yatırmak istersiniz?");
                    {
                        int cash = scan.nextInt();
                        banka.accs[index].deposit(cash);
                    }
                    IDileSecimBasliklari();
                
            }else if(secim.equals("4")){
                System.out.print("Hesap açışıl tarihi: "+banka.accs[index].getHesapAcmaGunu()+"\n");
                    IDileSecimBasliklari();
            }else if(secim.equals("5")){
                System.out.println("Hesap Türü:");
                    if(banka.accs[index].getHesapTuru()=='C'){
                        System.out.println("Cari Hesaptır.");
                    }else if(banka.accs[index].getHesapTuru()=='O'){
                        System.out.println("Özel hesaptır.");
                    }else if(banka.accs[index].getHesapTuru()=='K'){
                        System.out.println("Kısa Vadeli hesaptır.");
                    }else if(banka.accs[index].getHesapTuru()=='U'){
                        System.out.println("Uzun Vadeli hesaptır.");
                    }
                   
                    IDileSecimBasliklari();
            }else if(secim.equals("6")){
                System.out.println("Hesaba ait son beş işlem:");
                    banka.accs[index].getSonBesIslem();
                    
                    IDileSecimBasliklari();
            }else if(secim.equals("7")){
                flag2 = true;
                    break;
            }else{
                System.out.println("sadece 1-7 arası seçim yapınız.");
            }
             
        }
        
    }
    private int accsIndexBul(int ID){
        for(int i = 0; i < banka.hesapCounter; i++){
            if(ID == banka.accs[i].getID()){
                return i;
            }
        }
        return -1;
    }
    private void IDileSecimBasliklari(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Hangi işlemleri yapmak istersiniz ?\n");
        System.out.println("1. Hesapta kaç para var? ");
        System.out.println("2. Hesaptan para çekmek,");
        System.out.println("3. Hesaba para yatırmak,");
        System.out.println("4. Hesap açılış tarihini öğrenmek,");
        System.out.println("5. Hesap türünü öğrenmek,");
        System.out.println("6. Hesaba ait son beş işlem nedir ?");
        System.out.println("7. Bir üst menüye dönmek,");
        System.out.println("\n için seçim yapınız:");
        System.out.println("---------------------------------------------------------");
    }
    private void faizleriHesaplaraYatir() {
        System.out.println("faizler hesaba yatırılıyor.");
        for(int i =0; i < banka.hesapCounter; i++){
            System.out.println(banka.accs[i].getID()+" nolu hesaptaki para: "+banka.accs[i].getBalance());
            banka.accs[i].deposit(banka.accs[i].benefit(banka.getDate()));
        }
        
    }
}
