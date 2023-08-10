
package hesapTurleri;
import bankauygulamasi.Bank;
import java.text.ParseException;

public abstract class Account implements GetterSetter{
    
    Bank banka; // aciliş tarihini ve id almak için kullandık. 
    private int balance=0;
    private int id;
    private char hesapTuru ;
    private String hesapAcmaGunu;
    private String IslemTarihi;
    private SonBesIslem sonBesIslem = new SonBesIslem();
    
    //****** Constractors ***************************************
    public Account(Bank banka,int balance) throws ParseException{//parameterized Constractor
        this.banka = banka;
        hesapAcmaGunu= banka.getDate();// bankanın o anki tarihini alır.
        this.balance = balance;
        id = ++(banka.idCounter);
        sonBesIslem.ekle(Integer.toString(balance));
    }
    public Account(Bank banka) throws ParseException{//default constractor
        this.banka = banka;
        hesapAcmaGunu= banka.getDate();// bankanın o anki tarihini alır.
        id = ++(banka.idCounter);
    }
    //***********************************************************
    //**********  get set  **************************************
    @Override
    public void deposit(int amount){
        if(amount>=0){
        balance += amount;
        System.out.println(id+" nolu hesaba "+ amount +"TL yatırılmıştır.");
        sonBesIslem.eklevecikar(amount);
        }else{
            System.out.println("negatif sayı yatırılmaz. işlem gerçekleşmemiştir.");
        }
    }
    @Override
    public void withdarw(int amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println(id+" nolu hesaba "+ amount +"TL çekilmiştir.");
            
            sonBesIslem.eklevecikar(-amount);
        }else{
            System.out.println("Hesapta yeterince para yok!");
        }
    }
    @Override
    public int getBalance(){
        return balance;
    }
    @Override
    public int getID(){
        return id;
    }
    @Override
    public void getSonBesIslem(){
        sonBesIslem.yazdir();
    }
    @Override
    public String getHesapAcmaGunu(){
        return hesapAcmaGunu;
    }
    @Override
    public String getIslemTarihi(){
        return IslemTarihi;
    }
    @Override
    public void setIslemTarihi(String tarih){
        this.IslemTarihi = tarih;
    }
    @Override
    public void setHesapTuru(char hesapTuru){
        this.hesapTuru = hesapTuru;
    }
    @Override
    public char getHesapTuru(){
        return hesapTuru;
    }
    @Override
    public void setHesapAcmaTarihi(String tarih){
        this.hesapAcmaGunu = tarih;
        this.IslemTarihi = tarih;
    }
    
    //***********************************************************
    
    public abstract int benefit(String strTarih);//gg.AA.yyyy 
}
 

