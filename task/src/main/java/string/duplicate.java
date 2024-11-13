package string;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.*;

public class duplicate {
    public static void main(String[] args) {
        System.out.println("Enter a string");
        Scanner obj = new Scanner(System.in);
        String str = obj.nextLine();
        char[] arr = str.toCharArray();
        int l1 = arr.length;
        for (int k = 0; k < l1; k++) {
            if (arr[k] == 32) {
                arr = ArrayUtils.remove(arr, k);
                l1--;
            }
        }

        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = len; j > i; j--) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr = ArrayUtils.remove(arr, j);
                    len--;
                }
            }
            if (count != 1) {
                System.out.println(arr[i] + " found duplicate:" + count+" times");
            }
        }
    }
}

