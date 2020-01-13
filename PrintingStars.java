package Exe3;
 
import java.util.Scanner;
public class PrintingStars {
  
    static final String star = "*";
    static final String space = " ";
    static final String typeUp = "UP";
    static final String typeDown = "DOWN";
    static final String yes ="y";
    static final String no ="n";
    static final String consoleInformationText ="Size Ranges from : 1 - 100. ";
    static final String consoleValueEnter ="Enter a Range to print Rhombus : ";
    static final String consoleError = "Select Valid Size Range between 1 - 100.";
    static final String consoleRepeatText = "Do you wish to continue ? (y/n) : ";
    static final String consoleRepeatError = "Incorrect value. Enter y for yes and n for no";

    static int maxRhombusLength = 0;
    static String keepContinuing = yes;

    public static void main(String[] args) {
        printRhombus();
    }

    public static void repeat(){ // repeat program if yes
        System.out.print(consoleRepeatText);
        Scanner scanner = new Scanner(System.in);
        keepContinuing = scanner.next();
        switch (keepContinuing) {
            case yes:
                printRhombus();
                break;
            case no:
                System.out.println();
                break;
            default:
                System.out.println(consoleRepeatError);
                repeat();
        }
    }

    public  static void printRhombus(){ // print rhombus
        System.out.println(consoleInformationText); // print information
        System.out.print(consoleValueEnter);
        Scanner scanner = new Scanner(System.in);
        int rhombusSize = scanner.nextInt();
        if(rhombusSize >100){
            System.out.println(consoleError); // console Error display
        }else {
            for (int i = 0; i < rhombusSize; i++){
                printLine(i,rhombusSize,typeUp); // print space and star in a single line
            }
            for (int i = rhombusSize -1; i > 0; i--){
                printLine(i,rhombusSize,typeDown); // print space and star in a single line
            }
        }
        repeat(); // repeat program once again till type no to print diagram
    }

    public  static  void  printLine(int i, int rhombusSize, String type){ // print space and star in a single line
        if(i < 1 ){
            maxRhombusLength = 1;
        }else {
            if(type.equals(typeUp)){
                maxRhombusLength = maxRhombusLength + 2;
            }else {
                maxRhombusLength = maxRhombusLength - 2;
            }
        }
        if(type.equals(typeUp)){
            printSpaces(rhombusSize - (i+1));
        }else {
            printSpaces(rhombusSize - i);
        }
        for(int j = 0; j < maxRhombusLength; j++){
            System.out.print(star);
        }
        System.out.println();
    }

    public  static  void  printSpaces(int value){  // print spaces
        for(int i =0; i<value; i++){
            System.out.print(space);
        }
    }
}

