class Moblil{

    String brand;
    int price;
    String name;

    public void show(){
        System.out.println(brand+": " + price + ":" + name);

    }


}

public class Abtraction {
    public static void main(String[] args) {

        Moblil odj1 = new  Moblil();
        odj1.brand = "Apple";
        odj1.price = 19999;
        odj1.name ="SmartPhone";

        Moblil odj2 = new  Moblil();
        odj2.brand = "Samsung";
        odj2.price = 10000;
        odj2.name = "SmartPhone";

        odj1.show();
        odj2.show();

    }
}