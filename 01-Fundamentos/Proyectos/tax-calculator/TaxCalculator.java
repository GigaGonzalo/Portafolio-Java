import java.util.Scanner;

public class TaxCalculator {

    public static String[][] type_transaction = {{"Bronze", "0" , "10", "0"}, {"Silver", "5", "10", "3"}, {"Golden", "10", "0", "4"}, {"Black", "12", "0", "7"}};

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int opc;

        do{

            System.out.println("Tax Calculator");
            System.out.println("------------------------");
            System.out.println("1. Process a transaction: ");
            System.out.println("0. Exit");
            System.out.println("Choose a option:");

            opc = scn.nextInt();





        }
        while(opc != 0);
    }



}
