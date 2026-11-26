import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;
import java.util.Currency;

public class currency_converter{

    static String[] name_currency = {"Dollar (USD)", "Canadian Dollar (CAD)", "Euro (EUR)", "Yen (JPY)", "Yuan (CNY)", "Pesos (MXN)"};
    static Locale[] loc = {Locale.US,Locale.CANADA, new Locale("es","ES"), Locale.JAPAN, Locale.CHINA, new Locale("es", "MX")};
    /*Value currency from dollar value*/
    static double[] value_currency = {1, 1.42f, 0.91f, 159.13f, 6.66f, 19.63};
    static int opc;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Currency Converter");
            System.out.println("Select currency for conversion:");
            for (int i = 0; i < name_currency.length; i++) {
                System.out.println((i + 1) + ". " + name_currency[i]);
            };
            System.out.println("0. Exit");
            System.out.print("Select option : ");

            opc = sc.nextInt();

            switch(opc){
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :

                    break;
                case 7 :

                    break;
                default :

                    break;
            };
        }
        while(opc != 0);
        sc.close();
    };

};


