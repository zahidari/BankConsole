
package hesapTurleri;

import bankauygulamasi.Bank;
import java.text.ParseException;


public class CariHesap extends Account{
    
    
    
    public CariHesap(Bank banka, int balance) throws ParseException {
        super(banka, balance);
        setHesapTuru('C');
        setHesapAcmaTarihi(banka.getDate());
    }
    
    

    @Override
    public int benefit(String strTarih) {
        return 0;
    }
    
}
