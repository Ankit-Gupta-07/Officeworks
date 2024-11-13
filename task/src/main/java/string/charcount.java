package string;
import java.util.Scanner;
public class charcount {
    public static void main(String[] args) {
        System.out.println("Enter string");
        Scanner obj = new Scanner(System.in);
        String str = obj.nextLine();

        System.out.println("Enter the character you want to find the occurence(s) in given string");
        Scanner obj2 = new Scanner(System.in);

        char val = obj2.next().charAt(0);
        long start=System.nanoTime();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp==val) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No match found");
        } else {
            System.out.println("Character " + val+" appeared "+count+" times");
        }
        long stop=System.nanoTime();
        System.out.println(" Time taken in executing program: "+(stop-start)+" nano time");
    }
}
