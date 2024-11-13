
import java.util.Scanner;

public class solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        int x = s.length();
        int strlen = x - k + 1;
        int temp = 0;
        int temp2 = k;
        String[] arr = new String[strlen];
        for (int i = 0; i < strlen - 1; i++) {
            arr[i] = s.substring(temp, temp2);
            temp++;
            temp2++;
        }
        String tmp = "";
        for (int c = 0; c < strlen - 1; c++) {
            for (int d = c + 1; d < strlen - 1; d++) {
                tmp = arr[c];
                arr[c] = arr[d];
                arr[d] = tmp;
            }
        }
        smallest = arr[0];
        largest = arr[strlen];
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
