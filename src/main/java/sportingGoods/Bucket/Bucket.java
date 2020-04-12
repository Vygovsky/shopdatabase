package sportingGoods.Bucket;

import sportingGoods.Item.Item;

import java.util.ArrayList;
import java.util.List;


public class Bucket {
    private long id;
    private Item itemsBucket;
    private int count;


    public Bucket(long id, Item itemsBucket, int count) {
        this.id = id;
        this.itemsBucket = itemsBucket;
        this.count = count;
    }

    public Bucket() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Item getItemsBucket() {
        return itemsBucket;
    }

    public void setItemsBucket(Item itemsBucket) {
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

        if (id != bucket.id) return false;
        if (count != bucket.count) return false;
        return itemsBucket.equals(bucket.itemsBucket);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + itemsBucket.hashCode();
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", itemsBucket=" + itemsBucket +
                ", count=" + count +
                '}';
    }
}