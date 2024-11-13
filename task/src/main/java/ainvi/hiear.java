package ainvi;

public class hiear extends selenium {
    int u;
    public void method4(){
        System.out.println("Method 4: Calling class Selenium");
    }
    public hiear(){
        System.out.println("Default parametrized: Parent is Automation class");
    }
    public hiear(int a){
        System.out.println("One parametrized: Parent is Automation class");
    }
    public hiear(int a, int b){
        System.out.println("Two parametrized: Parent is Automation class");
    }

    public static void main(String[] args) {
        hiear obj=new hiear();
        obj.method2();
        System.out.println(obj.x=1222222);

    }
}
