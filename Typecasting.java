


//typecasting  = upcasting 

class A{
    public void show(){
        System.out.println("show in A");
    }
}
class B extends A{
    public void show1(){
        System.out.println("show in B");

    }
}

public class Typecasting {
    public static void main(String[] args) {
        A obj =new B();
        obj.show();

        B obj1 = (B)obj;
        obj1.show1();
    }
}
