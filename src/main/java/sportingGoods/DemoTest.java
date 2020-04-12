package sportingGoods;

public class DemoTest {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в спортивный интернет-магазин! \nВыберите категорию товара");
        Service service = new Service();
           service.printCategory();

        /*int type0 = 0;

        String value = String.valueOf(type0);
        if (value instanceof String) {
            System.out.println("String");
        }
*/
    }
}
