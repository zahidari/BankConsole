package bankauygulamasi;
import java.text.ParseException;


public abstract class Main {
    public static void main(String[] args) throws ParseException {
        
        
        Bank banka = new Bank();
        
        // burası örnek olsun diye. sistem icinde de yapılabilir.
        // denemek için tekrar tekrar işlem yapmamak için buraya yazdım.
        banka.createCariHesap(2500);
        banka.createKisaHesap(2500);
        banka.createOzelHesap(2500);
        banka.createUzunHesap(2500);
        banka.createOzelHesap(2500);
        banka.createOzelHesap(2500);
        banka.createOzelHesap(2500);
        banka.createOzelHesap(2500);
        banka.createOzelHesap(23500);
        banka.createOzelHesap(2500);
        banka.createOzelHesap(5500);
        banka.createOzelHesap(7500);
        
        banka.menu.start();
       
        
        
        
        
        
    }
}
