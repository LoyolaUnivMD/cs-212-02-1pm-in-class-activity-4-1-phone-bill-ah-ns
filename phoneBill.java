import java.util.Scanner;
import java.text.DecimalFormat;

class HelloWorld {
    public static void main(String[] args) {
        int dataProvided = 0;
        float cost, extraRate = 0;
        boolean coupon = false;

        Scanner input = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.00");

        System.out.println("This program will determine how much your monthly phone bill will cost.");

        System.out.println("Enter your desired package [Green/Blue/Purple]: ");
        String pkg = input.next().toLowerCase().strip();

        while (!pkg.equals("green") && !pkg.equals("blue") && !pkg.equals("purple")){
            System.out.println("Invalid. Enter a valid package [Green/Blue/Purple]: ");
            pkg = input.next().toLowerCase().strip();
        }


        if (pkg.equals("green")){
            System.out.println("Do you have a coupon for this package? [Yes/No] ");
            String hasCoupon = input.next().toLowerCase().strip();
            if (hasCoupon.equals("yes")) {
                coupon = true;
            }

            cost = 49.99F;
            dataProvided = 2;
            extraRate = 15;
        } else if(pkg.equals("blue")) {
            cost = 70F;
            dataProvided = 4;
            extraRate = 10;
        } else {
            cost = 99.95F;
        }

        System.out.println("Enter the gigabytes of data you used this month: ");
        float dataUsed = input.nextFloat();
        while (dataUsed < 0) {
            System.out.println("Enter a positive value for gigabytes of data used: ");
            dataUsed = input.nextFloat();
        }

        if ((pkg.equals("green") || pkg.equals("blue")) && (dataUsed > dataProvided)) {
            double dataOver = dataUsed - dataProvided;
            cost += (extraRate * dataOver);
        }
        if (coupon && (cost > 75)) {
            cost -= 20;
        }

        System.out.println("Your final monthly bill is $" + formatter.format(cost) + " after using " + formatter.format(dataUsed) + "GB!");
    }
}