package Exe5;
import java.io.FileWriter; 
import java.io.IOException; 
public class FileOpe1 {
    public static void main(String[] args) throws IOException 
    { 
        // Accept a string  
        String str = "File Handling in Java using "+ 
                " FileWriter and FileReader";
        // attach a file to FileWriter  
        FileWriter fw=new FileWriter("output.txt"); 
        // read character wise from string and write  
        // into FileWriter  
        for (int h = 0; h < str.length(); h++) 
            fw.write(str.charAt(h)); 
  
        System.out.println("successful"); 
        //close the file  
        fw.close(); 
    } 
}
