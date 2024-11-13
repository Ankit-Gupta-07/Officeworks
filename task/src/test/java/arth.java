public class arth {
    public int sum(int a, int b) {
        int c = a + b;
        System.out.println("Sum is : " + c);
        return c;
    }

    public int sub(int dd, int ee) {
        int d = dd - ee;
        System.out.println("SUbstract is : " + d);
        return d;
    }

    public int mul(int ff, int gg) {
        int e;
        e = ff*gg;
        System.out.println("Mul is: " + e);
        return e;

    }

    public static void main(String[] args) {
        arth obj = new arth();
        int sum1=obj.sum (10,2);
        int sub1=obj.sub(10,2);
        int mul1=obj.mul(sum1,sub1);
        int sum2=obj.sum (10,2);
        int sub2=obj.sub(10,2);
        int mul2=obj.mul(sum2,sub2);
        obj.mul(mul1,mul2);


    }
}
