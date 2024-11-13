package ainvi;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        String rev=new String();
        System.out.println("Check whether palindrome or not. \n Enter any char or number");
        Scanner obj=new Scanner(System.in);
        String a=obj.nextLine();
        int b=a.length();
        for(int i=b-1;i>=0;i--)
        {
            rev=rev+a.charAt(i);
        }
        System.out.println(rev);
        if(rev.equals(a))
        {
            System.out.println(a+" Is a Palindrome");
        }
        else {
            System.out.println("Not a Palindrome");}
        }

    }
