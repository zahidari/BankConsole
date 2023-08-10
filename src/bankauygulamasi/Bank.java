
package bankauygulamasi;
import hesapTurleri.Account;
import menü.Menu;
import hesapTurleri.KisaVadeliHesap;
import hesapTurleri.CariHesap;
import hesapTurleri.OzelVadeliHesap;
import hesapTurleri.UzunVadeliHesap;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




public class Bank {
    
    private String bankaTarihi = "14.02.2022";
    public Account[] accs;
    Menu menu;
    public static int idCounter = 102000;//banka no: 1020. sonraki iki basamak hesap no'dur.
    public static int hesapCounter= 0;
    public int index; // işlem yapılacak hesabın indexini belirleriz.
    
    
    public Bank() throws ParseException{
        accs= new Account[100];
        menu = new Menu(this);
        
    }
    
    // tüm hesap ID lerini gösterir.
    public void showAccount(){
        System.out.println("************************");
        for(int i = 0; i< hesapCounter; i++){
            System.out.println(accs[i].getID()+" nolu hesabın");
            System.out.println("Bakiye: "+accs[i].getBalance()+"TL");
            accs[i].getSonBesIslem();
            
            System.out.println("-----------------------");
        }
        System.out.println("************************");
    }
    public void showIDs(){
        System.out.println("************************");
        for(int i = 0; i< hesapCounter; i++){
            System.out.println(accs[i].getID());
        }
        System.out.println("************************");
    }
    // Create hesaplar
    public void createKisaHesap(int miktar) throws ParseException{
        if(miktar>=1000){
        accs[hesapCounter++] = new KisaVadeliHesap(this, miktar); 
            System.out.println(accs[hesapCounter-1].getID()+" nolu kısa vadeli hesap acılmıştır ve "+miktar+"TL eklenmistir.");
        }else{
            System.out.println("1000 TL altında kısa vadeli hesap açılamaz.");
        }
        
    }
    public void createUzunHesap(int miktar) throws ParseException{
        if(miktar>=1500){
            accs[hesapCounter++] = new UzunVadeliHesap(this, miktar);
            System.out.println(accs[hesapCounter-1].getID()+" nolu uzun vadeli hesap acılmıştır ve "+miktar+"TL eklenmistir.");
        }else{
                System.out.println("1500 TL altında uzun vadeli hesap açılamaz.");
            }
    }
    public void createOzelHesap(int miktar) throws ParseException{
        if(miktar>0){
        accs[hesapCounter++] = new OzelVadeliHesap(this, miktar);
        System.out.println(accs[hesapCounter-1].getID()+" nolu özel vadeli hesap acılmıştır ve "+miktar+"TL eklenmistir.");
        }else{
            System.out.println("en az 1 TL şartı vardır. Hesap açılmamıştır.");
        }
    }
    public void createCariHesap( int miktar) throws ParseException{
        
            accs[hesapCounter++] = new CariHesap(this, miktar);    
            System.out.print(accs[hesapCounter-1].getID()+" nolu cari hesap acılmıştır");
            if(miktar != 0 ){
                System.out.println(" ve "+ miktar+"TL eklenmiştir.");
            }else{
                System.out.println(".");
            }
    }
    
    // hesaba yukleme yap veya çek
    public void increase(int ID, int cash){
        boolean flag = false;
        for(int i = 0; i< hesapCounter; i++){
            if(ID == accs[i].getID()){
                accs[i].deposit(cash);
                flag = true;
                break;
            }
        }
        if(flag == false){
            System.out.println(ID+" nolu hesap yoktur. işlem başarısız.");
        }
    }
    public void decrease(int ID, int cash){
        boolean flag = false;
        for(int i = 0; i< hesapCounter; i++){
            if(ID == accs[i].getID()){
                accs[i].withdarw(cash);
                flag = true;
                break;
            }
        }
        if(flag == false){
            System.out.println(ID+" nolu hesap yoktur. işlem başarısız.");
        }
    }
    
    // Tarih ayarları
    public String getDateNow(){
    String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    return date;
    }
    public String getDate(){
        return bankaTarihi;
    }
    public void set_gun_ay_yil(int gun,int ay,int yil){
        
        bankaTarihi = LocalDate.of(yil, ay, gun).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    
    // kura çek
    public void sortition(){
        
        int k =0;  
        int total_coin=0;
        for(int i =0 ; i< hesapCounter; i++){
            if(accs[i].getHesapTuru()== 'O'){
                int cekilisHakki = accs[i].getBalance()/2000;
                total_coin += cekilisHakki;
            }
        }
        int[] hesapNolar = new int[total_coin];
        
        for(int i =0 ; i< hesapCounter; i++){
            int cekilisHakki=0;
            if(accs[i].getHesapTuru()== 'O'){
                 cekilisHakki = accs[i].getBalance()/2000;
                
            }
            
            while(cekilisHakki != 0){
                hesapNolar[k] = accs[i].getID();
                cekilisHakki--;
                k++;
            }
            
        }
        for(int i = 0; i<total_coin; i++){
            System.out.println(i+". hesap: "+hesapNolar[i]);
        }
        System.out.println("rasgele sayımız 0 ile "+(total_coin-1)+" arası çeiliyor..");
        int rasgele=(int)(Math.random()*total_coin);
        System.out.println("rasgele sayımız: "+rasgele);
        System.out.println(hesapNolar[rasgele]+" nolu hesap çekilişten 10binTL kazanmıştır.");
        increase(hesapNolar[rasgele], 10000);
        
        
    }
 
    
    
    
}
