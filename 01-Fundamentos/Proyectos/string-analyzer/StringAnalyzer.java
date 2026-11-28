import java.util.Scanner;
import java.util.Arrays;



public class StringAnalyzer{

    static String text;
    static boolean is_palindrome;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        char[] char_text;
        int opc;

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
                    char_text = convert_char(text);
                    System.out.println("Your text analized is " + text);
                    count_vowel(char_text);
                    count_consonant(char_text);

                    break;

                case 0:
                    System.out.print("Exiting...............");
                    break;
                default:
                    System.out.println("Invalid option!");
            }



        }
        while(opc != 0);
    }

    public static char[] convert_char(String text){
        char [] char_t;
        text = text.toLowerCase();
        char_t = text.toCharArray();

        return char_t;

    }

    public static void count_vowel(char[] c_text){

        char[] _vowel = {'a', 'e', 'i', 'o', 'u'};
        int n_vowel = 0;

        for(char char_t : c_text){
            for(char c_vowel : _vowel){

                if (char_t == c_vowel){
                    n_vowel++;
                }
            }

        }
        System.out.println("Vowel counted = " + n_vowel);

    }

    public static void count_consonant(char[] c_text){
        char[] _consonant = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
        int n_consonant = 0;

        for(char char_t : c_text){
            for(char c_vowel : _consonant){

                if (char_t == c_vowel){
                    n_consonant++;
                }
            }

        }

        System.out.println("Consonants counted = " + n_consonant);
    }


}
