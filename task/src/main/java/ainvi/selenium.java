package ainvi;

public class selenium extends automation {
    int x;

    public void method2() {
        System.out.println("Method2: Child Class");
    }

    public selenium() {
        System.out.println("Default parametrized: child is selenium class");
    }

    public selenium(int a) {

        System.out.println("One parametrized: child is selenium class");
    }

    public selenium(int a, int b) {
        super(1);
        System.out.println("Two parametrized: child is selenium class");
    }

    public static void main(String[] args) {
        selenium obj = new selenium();
        obj.method1();
        obj.method2();
        obj.a = 123;
        obj.x = 345;
        System.out.println(" " + obj.a + " " + obj.x);
    }
    //THis is single level inheritence
}
