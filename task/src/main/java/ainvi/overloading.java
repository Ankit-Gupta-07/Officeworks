package ainvi;

public class overloading {
    // Method name should be same
    //Method return type/output can be same or different
    // Method input datatypes should be different or parameters should not be equal
    public int overabc(int a, int b){
        int c=a+b;
        System.out.println("Sum first class :"+c);
        return c;
    }
    public void overabc(int a, int b, int c){
        int d=a+b+c;
        System.out.println("Sum second class :"+d);
    }

    public static void main(String[] args) {
        overloading obj=new overloading();
        obj.overabc(1,2);
        System.out.println(" two input given");
        obj.overabc(1,2,3);
        System.out.println("three input given");
    }
}
