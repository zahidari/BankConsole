
package hesapTurleri;

import bankauygulamasi.Bank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OzelVadeliHesap extends Account{
    
    int vadeYuzdesi = 12;
    
    public OzelVadeliHesap(Bank banka, int balance) throws ParseException {
        super(banka, balance);
        setHesapTuru('O');
        setHesapAcmaTarihi(banka.getDate());
    }
    
    @Override
     public int benefit(String strTarih){//tarih:  gg.aa.yyyy
        
        //basit bir tarih formatına çevirdik.
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
       
        try{
            //parse yöntemi,tarihi üretmek için metni
            //bir dizeden ayrıştırmak için kullanılır
            Date d1 = sdf.parse(getIslemTarihi());
            Date d2 = sdf.parse(strTarih);
            
            //milisaniye cinsindendir.
            long aralarindaki_fark =
                    d2.getTime()- d1.getTime();
            //milisaniye ->gün
            long aralarindaki_gun_farki =
                    (aralarindaki_fark
                    / (1000*60*60*24) );
           
            
            // yüzde-> eğer 365 günse %20 = 1.2 olur ve
            //balance 1.2 ile çarpılır.
            double yh = (vadeYuzdesi*((double)aralarindaki_gun_farki/365)+100)/100;
            setIslemTarihi(strTarih);
            return (int)((getBalance()*yh)-getBalance()); 
            
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;// hatalı dönüş.
    }
}
