package sportingGoods.Item;

public enum Category {

    CLOTHES(1), INVENTORY(2), FOOTWEAR(3), CAP(4);

    private int serialNumber;

    Category(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
