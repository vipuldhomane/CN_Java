package Module3.Hashmaps.BuildHashmap;

import java.security.Key;
import java.util.ArrayList;

import javax.management.ValueExp;

public class Map<K, V> {
    ArrayList<MapNode<K, V>> buckets;
    int count;
    int numOfBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numOfBuckets = 20;
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(null);
        }
    }

    public int getBucketIndex(K key) {
        int hc = key.hashCode();
        int index = hc % numOfBuckets;
        return index;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        // if key present in the ll then update the value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // it means we have not found the key so well insert a new one
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        double loadFactor = (1.0 * count) / numOfBuckets;
        if (loadFactor > 0.7) {
            rehash();
        }
    }

    private void rehash() {
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i < 2 * numOfBuckets; i++) {
            buckets.add(null);
        }
        count = 0;
        numOfBuckets = numOfBuckets * 2;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            K Key = head.key;
            V Value = head.value;
            insert(Key, Value);
            head = head.next;
        }
    }

    public int size() {
        return count;

    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        // if key present in the ll then return the value
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = buckets.get(bucketIndex);
        // if key present in the ll then return the value
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
