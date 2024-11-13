package ainvi;

import java.util.Scanner;

public class armstrong {
    public static void main(String[] args) {
        int digit = 0;
        int sum = 0;
        System.out.println("Enter a number");
        Scanner obj = new Scanner(System.in);
        int entered = obj.nextInt();
        int temp = entered;
        int comp = temp;
        for (int i = entered; i > 0; i = i / 10) {
            entered = entered % 10;
            digit++;
        }
        while (temp > 0) {
            sum = sum + (int) Math.pow(temp % 10, digit);
            temp = temp / 10;
        }
        System.out.println("Digits: " + digit);
        System.out.println("Sum: " + sum);
        if (sum == comp) {
            System.out.println(comp + " is Armstrong number");
        } else {
            System.out.println(comp + " is not a Armstrong number");
        }
    }
}
