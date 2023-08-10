
package veriIsleme;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * banka verileri buradan çağrılır ve burada saklanır.
 * @author zagu
 */
public class VeriIsleme{
    
    private String filePath_IC = "/veriler/idCash.txt"; // hesap id ve para
    String filepath_IC_Komple ="C:/Users/zagu/Documents/NetBeansProjects/bankaUygulamasi/src/veriler/idCash.txt";
    
    // 
    public String getBalance(String strID){
        try {
            InputStream is = getClass().getResourceAsStream(filePath_IC);// import txt file
            BufferedReader br = new BufferedReader(new InputStreamReader(is));// read the context in the file.
            
            String satir;// satir satir oku
            String cash="";
            String id_ici ="";
            
            while((satir = br.readLine()) != null){// ilk ve sonraki satırları sırayla okur.
                
                for(int i = 0; i <6; i++){
                    id_ici +=  satir.charAt(i);
                }
                for(int i = 7; i <satir.length(); i++){
                    cash += satir.charAt(i);
                }
                
                if(id_ici.equals(strID) ){
                    break;
                }
                cash = "";
                id_ici = "";
            }
            if(id_ici.equals(strID)){
                br.close();//memory save
                return cash;
            }
            br.close();//memory save
            return "-1";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("veri işleme/ sorgula(); hatası");
            return "-1";
        }
    }
    //caliısıyor
    public void yeniIDveVeriEkle(String id,String veri){
        boolean flag =false;
    try{    
        InputStream is = getClass().getResourceAsStream(filePath_IC);// import txt file
        BufferedReader br = new BufferedReader(new InputStreamReader(is));// read the context in the file.
        
        String satir = "";
        String id_ici ="";
        
        while((satir =br.readLine()) != null){
            for(int i = 0; i<6;i++){
                id_ici += satir.charAt(i);
            }
            if(id.equals(id_ici)){
                flag = true;
                break;
            }  
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    if(flag == false){
        Path p = Paths.get(filepath_IC_Komple);
        String s = System.lineSeparator() + id+" "+veri;
        
        try {
            Files.write(p, s.getBytes(), StandardOpenOption.APPEND);
            System.out.println(id+" nolu hesap numarası açılmıştır ve "+veri+ "TL eklenmiştir.");
        } catch (IOException e) {
            System.err.println(e);
            
        }
    }else{
        System.out.println(id+" nolu hesap numarası mevcuttur. Yeni hesap açılmadı");
        flag = false;
    }
}
    // değiştirirken hem id hemde cash i aralarında bir boşlukla yaz.
    public void modifiyeEt(/*String filePath,*/ String oldString, String newString){   
    
        File fileToBeModified = new File(filePath_IC);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
            
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    public void printTumIDveCash(){
         try {
            InputStream is = getClass().getResourceAsStream(filePath_IC);// import txt file
            BufferedReader br = new BufferedReader(new InputStreamReader(is));// read the context in the file.
            
             System.out.println("*********************************");
             System.out.println("  ID   Cash\n");
            String satir;// satir satir oku
            while((satir = br.readLine()) != null){
                System.out.println(satir);
            }
            br.close();
         }catch(Exception e){e.printStackTrace();}
            System.out.println("*********************************");
    }
    
}
