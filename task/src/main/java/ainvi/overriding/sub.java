package ainvi.overriding;

public class sub extends arith {
    public void sum(int a,int b){
        int c=a-b;
        System.out.println("class: Sub ||SUbstraction first class :"+c);
    }


    public static void main(String[] args) {
        sub obj=new sub();
        obj.sum(10,2);
    }

}
