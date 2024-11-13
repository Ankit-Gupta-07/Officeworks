package string;

import java.util.*;

public class splitreverese {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner obj = new Scanner(System.in);
        String str = obj.nextLine();
        String[] arrstr = str.split(" ");
        int len = arrstr.length;

        for (int i = 0; i < len; i++) {
            int arrlen = arrstr[i].length();
            String temp = new String();
            for (int j = arrlen - 1; j >= 0; j--) {
                temp = temp + arrstr[i].charAt(j);
            }
            System.out.print(temp);
            System.out.print(" ");
        }
    }
}
