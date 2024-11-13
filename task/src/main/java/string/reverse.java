package string;

import javax.sound.midi.Soundbank;
import java.util.*;

public class reverse {
    public static void main(String[] args) {
        System.out.println("Enter the word you want to string.reverse");
        Scanner obj = new Scanner(System.in);
        String original = obj.nextLine();
        int numb = original.length();
        System.out.println("Total Characters are: " + numb);
        String rev = "";
        for (int i = numb - 1; i >= 0; i--) {
            rev = rev + original.charAt(i);
        }
        System.out.println("Reversed input usinf for loop is : "+rev);
        System.out.println("Enter stringbuffer: ");
        String s="";
        StringBuffer sb=new StringBuffer();
        Scanner obj2=new Scanner(System.in);
        s=obj2.nextLine();
        sb=sb.append(s);
        System.out.println("String buffer rev : "+sb.reverse());


    }

}

