import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;
import java.util.Currency;

public class currency_converter{

    static String[] name_currency = {"Dollar (USD)", "Canadian Dollar (CAD)", "Euro (EUR)", "Yen (JPY)", "Yuan (CNY)", "Mexican Peso (MXN)"};
    static Locale[] loc = {Locale.US,Locale.CANADA, new Locale("es","ES"), Locale.JAPAN, Locale.CHINA, new Locale("es", "MX")};
    /*Exchange rates realtive to USD*/
    static double[] value_currency = {1, 1.42f, 0.91f, 159.13f, 6.66f, 19.63};
    static int opc;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Currency Converter");
            System.out.println("Select a currency to convert from:");
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
                    System.out.println("You selected " + name_currency[opc-1] + ". enter the amount: ");
                    double amnt = sc.nextDouble();
                    sc.nextLine();

                    System.out.println(name_currency[opc-1] + " = " + amnt);

                    for(int i= 0; i < value_currency.length; i++){
                        if(i == opc-1){
                            continue;
                        }
                        else{
                            double mt = ((amnt/value_currency[opc-1])*value_currency[i]);
                            formatAmount(mt, loc[i], i);
                        }
                    }
                    System.out.println("Press Enter to return to the menu");
                    sc.nextLine();
                    break;
                case 0 :
                    break;
                default :
                    System.out.println("Incorrect Option!");
                    break;
            };
        }
        while(opc != 0);
        sc.close();
    };

    public static void formatAmount(double amn, Locale lct, int pos){
        NumberFormat frmt = NumberFormat.getCurrencyInstance(lct);

        System.out.println(frmt.format(amn) + " " + name_currency[pos]);
    };

};


