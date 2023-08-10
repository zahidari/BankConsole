
package hesapTurleri;


public class SonBesIslem {
    
    
    private final int ARRAY_MAX = 5;
    private String veri[] = new String[ARRAY_MAX];// max 5 adet
    private int KB; // kuyruk başı
    private int KS; // kuyruk sonu
    private int ES; // eleman sayısı
    
    public SonBesIslem(){
        KS = -1;
        KB = -1;
        ES = 0;
    }
    public boolean ekle(String eklenecekSayi){
        if(ES >= ARRAY_MAX){
            return false;
        }
        if(KB==-1){
            KB++;
        }
        if(KS==ARRAY_MAX-1){
            KS = 0;
        }else{
            KS++;
        }
        
        veri[KS] = eklenecekSayi;
        ES++;
        return true;
    }
    public boolean cikar(){
        if(ES ==0){
            return false;
        }
        //hucre = veri[KB];
        
        if(KB==ARRAY_MAX-1){
            KB = 0;
        }
        else{
            KB++;
        }
        ES--;
        if(ES == 0){
            KS = KB= -1;
        }
        return true;
    }
    public int getES(){
        if(ES >=0){
            return ES;
        }
        else{
            return -1;
        }
    }
    public void yazdir(){
       if(KS >=0){
           System.out.println("Son işlemleri:");
           if(KS >= KB){
               for(int i = KB; i<= KS; i++){
                   System.out.println(veri[i]);
               }         
           }else{
               for(int i = KB;i<ARRAY_MAX; i++){
                   System.out.println(veri[i]);
               }
               for(int i = 0; i<=KS; i++){
                   System.out.println(veri[i]);
               }
           }
       }else{
           System.out.println("Henüz işlem yapılmamıştır");
       }
    }
    public void eklevecikar(int eklenecekSayi){
        if(ES<5){
        ekle(Integer.toString(eklenecekSayi));
        }else{
            cikar();
            ekle(Integer.toString(eklenecekSayi));
        }
    }
    
}
