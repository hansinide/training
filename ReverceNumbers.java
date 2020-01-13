
package Exe1;

public class ReverceNumbers {
    public static void main(String [] args){
    
        if (args.length>0){
            String input =args[0];
             
            byte[] inputByteArr = input.getBytes();
            byte[] out = new byte[inputByteArr.length];
            
            for(int i=0; i<inputByteArr.length; i++){
                out[i] = inputByteArr[inputByteArr.length-i-1]; 
            }
            System.out.print(new String(out));
        
        }
    }
}
