/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exe3;
 import java.util.Scanner;
public class NumbersTable {
    static final String dash = "|";
    static final String space = " ";
    static final String stroke = "-";
    static final String taskPrintHeading = "HEADING";
    static final String taskPrintValues = "VALUES";
    static final String formatDetailsLengthDash = "2";
    static final String formatValueDefault = "4";
    static final String formatDetailsDefault = "4";
    static final String yes ="y";
    static final String no ="n";
    static final String percentage ="%";
    static final String stringDenote ="s";
    static final String consoleValueEnter ="Enter MAX Range for the Numbers Table : ";
    static final String consoleError = "Cannot print table on console. Table too LARGE";
    static final String consoleRepeatText = "Do you wish to continue ? (y/n) : ";
    static final String consoleRepeatError = "Incorrect value. Enter y for yes and n for no";

    static String keepContinuing = yes;
    static String formatValueLength = formatValueDefault;
    static String formatDetailsLength = formatDetailsDefault;
    static String formatValues = ""; // format for values in the table
    static String formatDetail = ""; // format for the vertical column
    static String formatDetailDash = ""; // format for the vertical column Dash

    //  %s means that it will add a String to the output.
    //  4 is the number of spaces to locate the string
    //  - indicates it should be left aligned.

    public static void main(String[] args) {
        printNumbersTableForRange();
    }

    public static void repeat(){ // repeat program if yes
        System.out.print(consoleRepeatText);
        Scanner scanner = new Scanner(System.in);
        keepContinuing = scanner.next();
        switch (keepContinuing) {
            case yes:
                printNumbersTableForRange();
                break;
            case no:
                System.out.println();
                break;
            default:
                System.out.println(consoleRepeatError);
                repeat();
        }
    }

    public static void printNumbersTableForRange(){  // print numbers table for range provided by input
        System.out.print(consoleValueEnter);
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        if(range> 1000){
            System.out.println(consoleError); // console Error display
        }else {
            printNumbersTable(range); // print numbers table for any range
        }
        System.out.println();
        setValuesTODefault(); // set values of formatValueLength and formatDetailsLength to default

        repeat(); // repeat program once again till type no to print diagram
    }

    public static void printNumbersTable(int range){ // print Numbers table for any range
        int rangeLength;
        String [] valuesList = new String[range];
        String formatPattern = "";

        if(range >=10){
            if(range>=100){
                if(range>=1000){
                    formatValueLength = String.valueOf(Integer.valueOf(formatValueLength)+5);
                    formatDetailsLength = String.valueOf(5);
                }else {
                    formatValueLength = String.valueOf(Integer.valueOf(formatValueLength)+3);
                    formatDetailsLength = String.valueOf(4);
                }
            }else {
                formatValueLength = String.valueOf(Integer.valueOf(formatValueLength)+1);
            }
        }
        rangeLength = Integer.valueOf(formatDetailsLengthDash)+Integer.valueOf(formatDetailsLength)+(Integer.valueOf(formatValueLength)*range);
        formatValues = percentage + formatValueLength + stringDenote; // format for values in the table
        formatDetail = percentage + formatDetailsLength + stringDenote; // format for the vertical column
        formatDetailDash = percentage + formatDetailsLengthDash + stringDenote; // format for the vertical column Dash

        drawNumberLine(range,formatPattern,valuesList,taskPrintHeading,0); // horizontal column
        drawSlashLine(rangeLength); // draw slash according to the range
        for(int i = 1; i <= range; i++){  // print vertical column and values
            drawNumberLine(range,formatPattern,valuesList,taskPrintValues,i); // draw the values below the slash
        }
    }

    public static void setValuesTODefault(){ // set values to default
        formatValueLength = formatValueDefault;
        formatDetailsLength = formatDetailsDefault;
    }

    public static void drawNumberLine(int range, String formatPattern, String[] valuesList, String task, int multiplyBy){
    // draw the lines horizontally like "   1 |    1    2    3    4    5    6    7    8    9   10"
        switch (task){
            case taskPrintHeading:
                System.out.print(String.format(formatDetail + formatDetailDash,space,space)); // print first space part of heading
                break;
            case taskPrintValues:
                System.out.print(String.format(formatDetail + formatDetailDash,String.valueOf(multiplyBy),dash));
                // print first part of vertical heading till dash
                break;
            default:
                System.out.println();
        }
        for(int i = 0; i < range; i++){
            formatPattern = formatPattern + formatValues; // create the format string
            switch (task){
                case taskPrintHeading:
                    valuesList[i] = String.valueOf(i+1); // print horizontal heading
                    break;
                case taskPrintValues:
                    valuesList[i] = String.valueOf(multiplyBy*(i+1)); // print the values inside table
                    break;
                default:
                    System.out.println();
            }

        }
        System.out.println(String.format(formatPattern,valuesList)); // format does formatting the string with spaces and print

    }

    public static void drawSlashLine(int rangeLength){ // print strokes
        for(int i = 0; i < rangeLength; i++){
            System.out.print(stroke);
        }
        System.out.println();
    }
}

    

