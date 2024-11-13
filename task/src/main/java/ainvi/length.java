package ainvi;

import java.util.Scanner;

public class length {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner obj=new Scanner(System.in);
        String a=obj.nextLine();
        int len=a.length();
        System.out.println("Length of string"+len);
        String ex="";
        for(int i=len-1;i>=0;i--)
        {
            ex=ex+a.charAt(i);
        }
        System.out.println("rev "+ex);

    }
}
