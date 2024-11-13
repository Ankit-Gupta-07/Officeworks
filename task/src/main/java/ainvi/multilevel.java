package ainvi;

public class multilevel extends selenium {
    int z;
    public void method3(){
        System.out.println("Method 3: Extending selenium class");
    }
    public multilevel(){
        System.out.println("Default parametrized: child is Multilevel class");
    }
    public multilevel(int a){
        super(1,2);
        System.out.println("One parametrized: child is Multilevelclass");
    }
    public multilevel(int a, int b){
        System.out.println("Two parametrized: child is Multilevel class");
    }

    public static void main(String[] args) {
        multilevel obj1=new multilevel(1);
//        obj1.method3();
//        obj1.method2();
//        obj1.method1();
        //user called method 1 and method 2 even when multilevel is extending selenium class only.
    }
}
