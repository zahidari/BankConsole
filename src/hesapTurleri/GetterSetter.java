
package hesapTurleri;


public interface GetterSetter {
    
    public int getBalance();
    public int getID();
    public String getHesapAcmaGunu();
    public char getHesapTuru();
    public void getSonBesIslem();
    public String getIslemTarihi();
    public void setIslemTarihi(String tarih);
    public void setHesapTuru(char hesapTuru);
    public void setHesapAcmaTarihi(String tarih);
    
    
    public void deposit(int amount);
    public void withdarw(int amount);
}
