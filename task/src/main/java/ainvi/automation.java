package ainvi;

public class automation {
    int a;

    public void method1() {
        System.out.println("method 1: Parent class");
    }

    public automation() {
        System.out.println("Default parametrized: Parent is Automation class");
    }

    public automation(int a) {

        System.out.println("One parametrized: Parent is Automation class");
    }

    public automation(int a, int b) {
        System.out.println("Two parametrized: Parent is Automation class");
    }
}
