package factory.method.demo1;

public class Client {
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new ChineseFactoryMethod();
        Translate translate = factoryMethod.factoryMethod();
        System.out.println(translate.sayText("666"));
    }
}
