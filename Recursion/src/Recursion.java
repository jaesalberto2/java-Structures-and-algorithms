public class Recursion {
    public static  void method3(){
        System.out.println("method3");

    }
    public static void method2(){
        method3();
        System.out.println("method2");

    }
    public static void method1(){
        method2();
        System.out.println("method1");

    }
    public static void main(String[] args) {
    method1();
    }

}
