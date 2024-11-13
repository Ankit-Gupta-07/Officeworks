import java.util.*;

public class flagquest {
    public static void main(String[] args) {
        System.out.println("Enter the number of color you want to enter");
        Scanner obj1 = new Scanner(System.in);
        int a = obj1.nextInt();
        System.out.println("Enter those " + a + " colors ");
        Scanner obj2 = new Scanner(System.in);
        String[] c = new String[a];
        for (int i = 0; i < a; i++) {
            c[i] = obj2.nextLine().trim().toLowerCase();
        }
        String[] india = new String[]{"saffron", "white", "green", "blue"};
        String[] bangladesh = {"red", "green"};
        String[] pakistan = {"white", "green"};
        String[] belgium = {"yellow", "black", "red"};
        String[][] country = {india, bangladesh, pakistan, belgium};
        int Ind=0,Pak=0,Ban=0,Bel=0;
        for (int k = 0; k < c.length; k++) {
            for (int i = 0; i < country.length; i++) {// 0 India, 1 Bangladesh, 2 Pak, 3 Belgium
                for (int j = 0; j < country[i].length; j++) {
                    if (country[i][j].equals(c[k]) && k == 0) {
                        if(i==0){Ind++;}
                        if(i==1){Ban++;}
                        if(i==2){Pak++;}
                        if(i==3){Bel++;}
                    }
                    if (country[i][j].equals(c[k]) && k == 1) {
                        if(i==0){Ind++;}
                        if(i==1){Ban++;}
                        if(i==2){Pak++;}
                        if(i==3){Bel++;}
                    }
                    if (country[i][j].equals(c[k]) && k == 2 ) {
                        if(i==0){Ind++;}
                        if(i==1){Ban++;}
                        if(i==2){Pak++;}
                        if(i==3){Bel++;}
                    }
                    if (country[i][j].equals(c[k]) && k == 3 ) {
                        if(i==0){Ind++;}
                        if(i==1){Ban++;}
                        if(i==2){Pak++;}
                        if(i==3){Bel++;}
                    }
                }
            }
        }
        if(Ind==a){System.out.println("India is having all entered colors");}
        if(Pak==a){System.out.println("Pakistan is having all entered colors");}
        if(Ban==a){System.out.println("Bangladesh is having all entered colors");}
        if(Bel==a){System.out.println("Belgium is having all entered colors");}
        if(Ind!=a && Ban!=a && Pak!=a && Bel!=a){
            System.out.println("No Matching colors found");}
    }
}
