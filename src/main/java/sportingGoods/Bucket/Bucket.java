package sportingGoods.Bucket;

import sportingGoods.Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bucket {
    private long id;
    private int count;
    private List<Item> itemsBucket;

    public Bucket(long id, int count, List<Item> itemsBucket) {
        this.id = id;
        this.count = count;
        this.itemsBucket = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Item> getItemsBucket() {
        return itemsBucket;
    }

    public void setItemsBucket(List<Item> itemsBucket) {
        this.itemsBucket = itemsBucket;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bucket)) return false;
        Bucket bucket = (Bucket) o;
        return id == bucket.id &&
                count == bucket.count &&
                Objects.equals(itemsBucket, bucket.itemsBucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count, itemsBucket);
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", count=" + count +
                ", itemsBucket=" + itemsBucket +
                '}';
    }

}