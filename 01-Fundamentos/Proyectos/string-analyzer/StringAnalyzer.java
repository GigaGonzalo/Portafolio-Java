import java.util.Scanner;



public class StringAnalyzer{

    static char[] char_text;
    static String text;
    static int n_vowel, n_consonants, n_space, opc;
    static boolean is_palindrome;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        do{

            System.out.println("Welcome to String Analyzer");
            System.out.println("--------------------------");
            System.out.println("1. Statistics of a text");
            System.out.println("0. Exit");
            System.out.println("Choose an option");

            opc = scan.nextInt();
            scan.nextLine();

            switch(opc){

                case 1:
                    System.out.println("Enter the text to convert");
                    text = scan.nextLine();
                    scan.nextLine();
                    System.out.println("Your text analized is " + text);
                    
                case 0:
                    System.out.print("Exiting...............");
                    break;
                default:
                    System.out.println("Invalid option!");
            }



        }
        while(opc != 0);
    }

    public void convert_Tochar(String text){

        char_text = text.toCharArray();

    }

    public void count_vowel(){

    }



}
