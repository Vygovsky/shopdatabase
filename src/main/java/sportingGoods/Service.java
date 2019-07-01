package sportingGoods;

import sportingGoods.Item.Category;
import sportingGoods.Item.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private static double totalPrice = 0;
    private Calendar calendar = Calendar.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private List<Item> items = new ArrayList<>();
    private Map<Long, Integer> integerBucketMap = new HashMap<>();

    public Service() {
        items.add(new Item(1, "Ball", 25, Category.INVENTORY));
        items.add(new Item(2, "MiniBall", 45, Category.INVENTORY));
        items.add(new Item(3, "T-shirt", 105, Category.CLOTHES));
        items.add(new Item(4, "Cup", 98, Category.CAP));
        items.add(new Item(5, "Cross", 150, Category.FOOTWEAR));
    }

    private List<Item> itemToCategory(String numberCategory) {
        List<Item> newListOfCategory = new ArrayList<>();
            final int startEnumsNumber = 1;
            for (Item item : items) {
                if (item.getCategory().ordinal() + startEnumsNumber == Integer.parseInt(numberCategory))
                    System.out.println(item + ", " + "[" + Category.values().length + "] ");
                newListOfCategory.add(item);
            }
            return newListOfCategory;
        }

    public void printCategory() {
        int i = 0;
        for (Category categoryOne : Category.values()) {
            System.out.println(++i + " " + categoryOne);
        }
    }

    public void choiceOfCategory() {
      //  printCategory();
        String choiceCategory = scanner.nextLine();
        switch (Integer.parseInt(choiceCategory)) {

            case 1:
                System.out.println("Категория одежда");
                exitMenuFromClothes();
                itemToCategory(choiceCategory);
                addProductInBucketAndTotalSum();
                exitMenuFromClothes();
                break;
            case 2:
                System.out.println("Категория инветрарь");
                exitMenuFromInventory();
                itemToCategory(choiceCategory);
                addProductInBucketAndTotalSum();
                exitMenuFromInventory();
                break;
            case 3:
                System.out.println("Категория обувь");
                itemToCategory(choiceCategory);
                addProductInBucketAndTotalSum();
                break;
            case 4:
                System.out.println("Категория кепки/шапки");
                itemToCategory(choiceCategory);
                addProductInBucketAndTotalSum();
                break;
            default:
                System.out.println("Неправильно выбрана категория.\nЕсли желаете покинуть магазин напишите\nYes");
                exitFromShop();
        }

    }

    private void exitMenuFromClothes() {
        List<Item> testItems = checkItemsInCategory(Category.CLOTHES);
        exitMenu(testItems);
    }

    private void exitMenuFromInventory() {
        List<Item> testItems = checkItemsInCategory(Category.INVENTORY);
        exitMenu(testItems);
    }

    private void exitMenu(List<Item> testItems) {
        if (testItems.size() == 0) {
            System.out.println("Категория товаров пуста!!!");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                System.exit(0);
            } else {
                choiceOfCategory();
            }

        }

    }

 /*   public void startMenuShop() {
        while (true){
            choiceOfCategory();
        }
    }*/

    private List<Item> checkItemsInCategory(Category category) {
        return items.stream()
                .filter(item -> item.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    private Map<Item, Integer> addProductInBucketAndTotalSum() {
        Map<Item, Integer> newMapProduct = new HashMap<>();
        System.out.print("Товар добавляется в корзину по Id:\nВыбиите товар:");
        int addIdProduct = scanner.nextInt();
        System.out.print("Количество товара: ");
        int count = scanner.nextInt();
        forErchAndAddItem(newMapProduct, addIdProduct, count);
        printBucket(newMapProduct, totalPrice);
        return newMapProduct;
    }

    private void forErchAndAddItem(Map<Item, Integer> newMapProduct, int addIdProduct, int count) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == addIdProduct) {
                newMapProduct.put(items.get(i), count);
                totalPrice += items.get(i).getPrice() * count;
                remove(items.get(i));
            }
        }
    }

    private void printBucket(Map<Item, Integer> newMapProduct, double total) {
        System.out.println("В Вашу корзину добавлено:");
        System.out.println(newMapProduct.keySet() + "," + newMapProduct.values());
        System.out.println("Общая цена == " + total + " ---->>>>> Дата : " + calendar.getTime());
        System.out.println("==========================================");
    }

    private void exitFromShop() {
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.exit(0);
        } else {
            choiceOfCategory();
        }
    }

    private void remove(Item item) {
        items.remove(item);
    }

    public void cleanBucket() {
        integerBucketMap.clear();
    }


}

