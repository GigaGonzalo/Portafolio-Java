import java.util.Scanner;
import java.util.Arrays;

public class StringAnalyzer{

    static String text;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        char[] char_text;
        int opc;

        do{

            System.out.println("Welcome to String Analyzer");
            System.out.println("--------------------------");
            System.out.println("1. Statistics of a text");
            System.out.println("2. Check Palindrome");
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
                    count_space(char_text);
                    System.out.print("Press Enter to return to the main menu");
                    scan.nextLine();
                    break;
                case 2:
                    System.out.println("Enter the word");
                    text = scan.nextLine();
                    char_text = convert_char(text);
                    System.out.println("Your word analized is " + text);
                    isPalindrome(char_text);
                    System.out.print("Press Enter to return to the main menu");
                    scan.nextLine();
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

    public static void count_space(char[] c_text){

        int n_space = 0;

        for(char char_t : c_text){

            if(char_t == ' ') {

                n_space++;

            }

        }

        System.out.println("Spaces counted = " + n_space);
    }

    public static void isPalindrome(char[] c_text){
        int count = 0;
        if((c_text.length % 2) == 0){

            for(int i = 0 ; i < (c_text.length/2) ; i++ ){

                if(c_text[i] == c_text[(c_text.length-1)-i]){
                    
                    count++;

                }

            }
            if(count == c_text.length/2){

                System.out.println("Yea! It is a PALINDROME");

            }
            else {
                System.out.println("It isn't a PALINDROME");
            }
        }
        else{
            int n = (c_text.length) - 1;
            for(int i = 0 ; i < (n/2) ; i++ ){

                if(c_text[i] == c_text[(c_text.length-1)-i]){

                    count++;

                }

            }
            if(count == n/2){

                System.out.println("Yea! It is a PALINDROME");

            }
            else {
                System.out.println("It isn't a PALINDROME");
            }
        }
    }




}
