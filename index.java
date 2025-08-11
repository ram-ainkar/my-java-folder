
class Mobile {

    String brand;
    int price;
    static String name;

    public void show() {
        System.out.println(brand + ":" + price + " : " + name);
    }

    public static void show1(Mobile obj) {
        System.out.println(Obj.brand + " : " + Obj.price + " : " + obj.name);
    }

}

public class index {

    public static void main(String[] args) {

        Mobile odj1 = new Mobile();
        odj1.brand = "Apple";
        odj1.price = 10000;
        odj1.name = "smartphone";

        Mobile.name = "phone";
        odj1.show();

        Mobile.show1();

    }
}
