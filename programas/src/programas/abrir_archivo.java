
package programas;

import java.io.*;
import javax.swing.JOptionPane;

public class abrir_archivo {
    
    public String leertxt(String direccion)
    {
     
        String texto = "";
        try
        {
           BufferedReader bf = new BufferedReader(new FileReader(direccion)); 
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null)
            {
              temp = temp + bfRead;
              
            }
            texto = temp;
        }catch(Exception e)
        {
            
           JOptionPane.showMessageDialog(null,"EL DOCUMENTO NO SE PUDO ABRIR"+e);     
        }
        return(texto);
    }
    
    
    
    
    
    
    
    
}
