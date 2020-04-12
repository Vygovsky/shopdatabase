package sportingGoods;

import sportingGoods.Bucket.Bucket;
import sportingGoods.Item.Category;
import sportingGoods.Item.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private static double totalPrice = 0;
    private static int countBucket = 0;
    private Calendar calendar = Calendar.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private List<Item> items = new ArrayList<>();
    private List<Item> newListOfCategory = new ArrayList<>();
    private Bucket bucket = new Bucket();

    public Service() {
        items.add(new Item(1, "Ball", 25, 3, Category.INVENTORY));
        items.add(new Item(2, "MiniBall", 45, 6, Category.INVENTORY));
        items.add(new Item(3, "T-shirt", 105, 7, Category.CLOTHES));
        items.add(new Item(4, "Cup", 98, 1, Category.CAP));
        items.add(new Item(5, "Cross", 150, 12, Category.FOOTWEAR));
        items.add(new Item(6, "Ked", 180, 18, Category.FOOTWEAR));
    }


    private List<Item> itemToCategory(String numberCategory) {
        final int startEnumsNumber = 1;
        for (Item item : items) {
            if (item.getCategory().ordinal() + startEnumsNumber == Integer.parseInt(numberCategory)) {
                System.out.println(item + ", " + "[" + Category.values().length + "] ");
                newListOfCategory.add(item);
            }
        }
        return newListOfCategory;
    }

    public void printCategory() {
        int i = 0;
        for (Category categoryOne : Category.values()) {
            System.out.println(++i + " " + categoryOne);
        }
        String choiceCategory = scanner.nextLine();
        choiceOfCategory(choiceCategory);
    }


    public void choiceOfCategory(String choiceCategory) {
        while (true) {
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
                    exitMenuFromFootWear();
                    itemToCategory(choiceCategory);
                    addProductInBucketAndTotalSum();
                    exitMenuFromFootWear();
                    break;
                case 4:
                    System.out.println("Категория кепки/шапки");
                    exitMenuFromCup();
                    itemToCategory(choiceCategory);
                    addProductInBucketAndTotalSum();
                    exitMenuFromCup();
                    break;
                default:
                    System.out.println("Неправильно выбрана категория.\nЕсли желаете покинуть магазин напишите\nYes");
                    exitFromShop();
            }
        }
    }


    private void exitMenu(List<Item> testItems) {
        if (testItems.size() == 0) {
            System.out.println("Категория товаров пуста нажми 1-4 вернутся в основное меню!!! Выити из магазина нажми \"y\"!");

            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.exit(0);
            } else {
                printCategory();
            }
        }
    }


    private List<Item> checkItemsInCategory(Category category) {
        return items.stream()
                .filter(item -> item.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    private Bucket addProductInBucketAndTotalSum() {
        Item tempItem = new Item();
        System.out.print("Товар добавляется в корзину по Id:\nВыбиите товар:");
        int addIdProduct = scanner.nextInt();
        int count = 0;
        if (addIdProduct != 0) {
            System.out.print("Количество товара: ");
            count = scanner.nextInt();
            for (Item item : newListOfCategory) {
                if (item.getId() == addIdProduct) {
                    tempItem.setId(item.getId());
                    tempItem.setName(item.getName());
                    tempItem.setPrice(item.getPrice());
                    tempItem.setCount(item.getCount());
                    tempItem.setCategory(item.getCategory());
                }
            }
          /*  for (int i = 0; i <newListOfCategory.size() ; i++) {
                if(newListOfCategory.get(i).getId()==tempItem.getId()){

                   newListOfCategory.set(i, tempItem );
                }
            }*/

            for (Item item : newListOfCategory)
                if (item.getId() == tempItem.getId()) {

                newListOfCategory.set((int) item.getId(), tempItem);

                }

            System.out.println("======");
            newListOfCategory.forEach(System.out::println);
            System.out.println("======");
            bucket.setId(++countBucket);
            bucket.setItemsBucket(tempItem);
            bucket.setCount(count);
            totalPrice += tempItem.getPrice() * count;

        }
        printBucket(bucket, totalPrice, count);
        return bucket;
    }

    private long getRandomI() {
        Random num = new Random();
        return (long) num.nextDouble() * 10;
    }

    private void printBucket(Bucket bucket, double total, int count) {
        System.out.println("В Вашу корзину добавлено:");
        System.out.println("//" + bucket.getItemsBucket().getName() +
                ", //Цена: " + bucket.getItemsBucket().getPrice() +
                " //Количество: " + count + " шт.");
        System.out.println("Общая цена == " + total + " ---->>>>> Дата : " + calendar.getTime());
        System.out.println("==========================================");
    }

    private void exitFromShop() {
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.exit(0);
        } else {
            choiceOfCategory(choice);
        }
    }

    private void remove(List<Item> items, Bucket bucket) {

    }


    private void exitMenuFromClothes() {
        List<Item> testItems = checkItemsInCategory(Category.CLOTHES);
        exitMenu(testItems);
    }

    private void exitMenuFromInventory() {
        List<Item> testItems = checkItemsInCategory(Category.INVENTORY);
        exitMenu(testItems);
    }

    private void exitMenuFromCup() {
        List<Item> testItems = checkItemsInCategory(Category.CAP);
        exitMenu(testItems);
    }

    private void exitMenuFromFootWear() {
        List<Item> testItems = checkItemsInCategory(Category.FOOTWEAR);
        exitMenu(testItems);
    }
}

