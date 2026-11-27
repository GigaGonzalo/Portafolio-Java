import java.util.Scanner;

public class TaxCalculator {

    public static double[][] type_transaction = {{0, 0.1, 0}, {0.05, 0.1, 0.03}, {0.1, 0, 0.04}, {0.12, 0, 0.06}};
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){

        int opc;

        do{

            System.out.println("Tax Calculator");
            System.out.println("------------------------");
            System.out.println("1. Process a transaction: ");
            System.out.println("0. Exit");
            System.out.println("Choose a option:");

            opc = scn.nextInt();
            scn.nextLine();

            switch (opc){
                case 1:
                    System.out.print("Amount = ");
                    double mnt = scn.nextDouble();

                    calculeTax(mnt);
                    break;
                case 2:
                    System.out.println("Exit..............");
                    scn.close();
                    break;
                case 0:
                    break;

                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
        while(opc != 0);
    }

    public static void calculeTax(double amnt){

        int t_transaction = typeTransction(amnt);
        double discount, ship_charge, points, total_amount;

        System.out.println(t_transaction);

        switch(t_transaction){

            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println((type_transaction[t_transaction-1][1]));
                ship_charge = amnt * (type_transaction[t_transaction-1][1]);
                total_amount = amnt + ship_charge;
                discount = amnt * (type_transaction[t_transaction-1][0]);
                total_amount -= discount;
                points = amnt * (type_transaction[t_transaction-1][2]);
                System.out.println("Total = " + total_amount);
                System.out.println("------------------------");
                System.out.println("Discount " + (type_transaction[t_transaction-1][0]*100) +  "% = " + discount);
                System.out.println("Shipping charge = " + (type_transaction[t_transaction-1][1]*100) +"% = " +ship_charge);
                System.out.println("Loyalty Points " + (type_transaction[t_transaction-1][2]*100) + "% = " + points);

                System.out.println("Press Enter to go to main menu");
                scn.nextLine();
                break;

            default:
                System.out.println("Invalid Option!");
                break;

        }


    }

    public static int typeTransction(double amount){
        int type;
        if(amount <= 999){
            type = 1;
        } else if (amount <= 1999) {
            type = 2;
        } else if (amount <= 2499) {
            type = 3;
        } else{
            type = 4;
        }
        return type;
    }

}
