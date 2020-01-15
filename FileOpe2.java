package Exe5;
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
public class FileOpe2 {
    // Reading data from a file using FileReader 
public static void main(String[] args) throws IOException 
	{ 
		int ch; 
            // check if File exists or not 
		FileReader fr=null; 
		try
		{ 
			fr = new FileReader("text"); 
		} 
		catch (FileNotFoundException fe) 
		{ 
			System.out.println("File not found"); 
		} 

		// read from FileReader till the end of file 
		while ((ch=fr.read())!=-1) 
			System.out.print((char)ch); 

		// close the file 
		fr.close(); 
	} 
} 

    

