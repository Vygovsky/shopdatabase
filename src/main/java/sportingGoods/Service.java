package sportingGoods;

import sportingGoods.Item.Category;
import sportingGoods.Item.Item;

import java.util.*;

public class Service {
    private static double totalPrice = 0;
    private Calendar calendar = Calendar.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private List<Item> itemsInventory = new ArrayList<>();
    private List<Item> itemsClothes = new ArrayList<>();
    private List<Item> itemsFootwear = new ArrayList<>();
    private List<Item> itemsCap = new ArrayList<>();
    private Map<Category, List<Item>> itemsMapInventory = new HashMap<>();
    private Map<Category, List<Item>> itemsMapClothes = new HashMap<>();
    private Map<Category, List<Item>> itemsMapFootwear = new HashMap<>();
    private Map<Category, List<Item>> itemsMapCap = new HashMap<>();
    private Map<Long, Integer> integerBucketMap = new HashMap<>();

    public Service() {
        itemsInventory.add(new Item(1, "Ball", 25));
        itemsInventory.add(new Item(2, "MiniBall", 45));
        itemsClothes.add(new Item(3, "T-shirt", 105));
        itemsFootwear.add(new Item(4, "Cup", 98));
        itemsCap.add(new Item(5, "Cross", 150));

        itemsMapInventory.put(Category.INVENTORY, itemsInventory);
        itemsMapClothes.put(Category.CLOTHES, itemsClothes);
        itemsMapFootwear.put(Category.FOOTWEAR, itemsFootwear);
        itemsMapCap.put(Category.CAP, itemsCap);
    }


    private Map<Category, List<Item>> itemToCategoryInventory() {
        Map<Category, List<Item>> newListOfCategory = new HashMap<>();
        for (Map.Entry<Category, List<Item>> entry : itemsMapInventory.entrySet()) {
            entry.getValue().forEach(System.out::println);
            newListOfCategory.put(entry.getKey(), entry.getValue());
        }
        return newListOfCategory;
    }

    private Map<Category, List<Item>> itemToCategoryClothes() {
        Map<Category, List<Item>> newListOfCategory = new HashMap<>();
        for (Map.Entry<Category, List<Item>> entry : itemsMapClothes.entrySet()) {
            newListOfCategory.put(entry.getKey(), entry.getValue());
            entry.getValue().forEach(System.out::println);
        }

        return newListOfCategory;
    }

    private Map<Category, List<Item>> itemToCategoryFootwear() {
        Map<Category, List<Item>> newListOfCategory = new HashMap<>();
        for (Map.Entry<Category, List<Item>> entry : itemsMapFootwear.entrySet()) {
            entry.getValue().forEach(System.out::println);
            newListOfCategory.put(entry.getKey(), entry.getValue());
        }
        return newListOfCategory;
    }

    private Map<Category, List<Item>> itemToCategoryCap() {
        Map<Category, List<Item>> newListOfCategory = new HashMap<>();
        for (Map.Entry<Category, List<Item>> entry : itemsMapCap.entrySet()) {
            entry.getValue().forEach(System.out::println);
            newListOfCategory.put(entry.getKey(), entry.getValue());
        }
        return newListOfCategory;
    }


 /*   private List<Item> itemToCategory(String numbСategory) {
        List<Item> newListOfCategory = new ArrayList<>();
        final int startEnumsNumber = 1;
        for (Item item : items) {
            if (item.getCategory().ordinal() + startEnumsNumber == Integer.parseInt(numbСategory))
                System.out.println(item + ", " + "[" + Category.values().length + "] ");
            newListOfCategory.add(item);
        }
        return newListOfCategory;
    }*/


    private void printCategory() {
        int i = 0;
        for (Category categoryOne : Category.values()) {
            System.out.println(++i + " " + categoryOne);
        }
    }

    public void choiceOfCategory() {
        printCategory();
        String choiceCategory = scanner.nextLine();
        // itemToCategory(choiceCategory);
        while (true) {
            switch (Integer.parseInt(choiceCategory)) {
                case 1:
                    System.out.println("Категория одежда");
                    itemToCategoryClothes();
                    addProductInBucketAndTotalSum();
                    break;
                case 2:
                    System.out.println("Категория инветрарь");
                    itemToCategoryInventory();
                    addProductInBucketAndTotalSum();
                    break;
                case 3:
                    System.out.println("Категория обувь");
                    itemToCategoryFootwear();
                    addProductInBucketAndTotalSum();
                    break;
                case 4:
                    System.out.println("Категория кепки/шапки");
                    itemToCategoryCap();
                    addProductInBucketAndTotalSum();
                    break;
                default:
                    System.out.println("Неправильно выбрана категория.\nЕсли желаете покинуть магазин напишите\nYes");
                    exitFromShop();
            }
        }
    }
 /*   public void startMenuShop() {
        while (true){
            choiceOfCategory();
        }
    }*/

    private Map<Category, List<Item>> addProductInBucketAndTotalSum() {
        Map<Category, List<Item>> newMapProduct = new HashMap<>();
        System.out.print("Товар добавляется в корзину по Id:\nВыбиите товар:");
        int addIdProduct = scanner.nextInt();
        System.out.print("Количество товара: ");
        int count = scanner.nextInt();


            // forErchAndAddItem(newMapProduct, addIdProduct, count);
            ///   printBucket(newMapProduct, totalPrice);
            //   return newMapProduct;
            return newMapProduct;
    }

/*    private void forErchAndAddItem(Map<Category, List<Item>> newMapProduct, int addIdProduct, int count) {
        for (int i = 0; i < newMapProduct.size(); i++) {
            if (newMapProduct.containsValue(addIdProduct)) {
                newMapProduct.put(newMapProduct.values(), count);
                totalPrice += items.get(i).getPrice() * count;
                remove(items.get(i));
            }
        }
    }*/

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

    private void remove() {

    }

    public void cleanBucket() {
        integerBucketMap.clear();
    }


}

