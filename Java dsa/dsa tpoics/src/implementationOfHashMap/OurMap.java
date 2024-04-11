package implementationOfHashMap;

import java.util.*;

public class OurMap<K, V>{
    private List<NewMap<K,V>> bucket;
    private int capacity;
    private final int Initial_capacity = 5;
    private int size;

    private class NewMap<K,V>{
        K key;
        V value;
        NewMap<K,V> next;
        public NewMap(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public OurMap(){
        bucket = new ArrayList<>();
        capacity = Initial_capacity;
        for(int i=0; i<capacity; i++){
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key){
        int hashcode = key.hashCode();
        return hashcode % capacity;
    }
    public V get(K key){
        int idx = getBucketIndex(key);
        NewMap<K,V> head = bucket.get(idx);
        while(head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    public void put(K key,V value){
        int idx = getBucketIndex(key);
        NewMap<K,V> head = bucket.get(idx);
        if(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucket.get(idx);
        NewMap<K,V> newEntry = new NewMap<K,V>(key,value);
        newEntry.next = head;
        bucket.set(idx,newEntry);

        //Load factor:
        double loadFactor = (double) (1.0 * size) / capacity;
        System.out.println("Inserted Key : " +key);
        System.out.println("Load Factor: " +loadFactor);

        if(loadFactor > 0.7){
            System.out.println("RehashingBuckets");
            rehash();
        }
    }
    public void rehash(){
        List<NewMap<K,V>> temp = bucket;
        capacity *= 2;
        for(int i=0; i<capacity; i++){
            bucket.add(null);
        }

        for(int i=0; i<temp.size(); i++){
            NewMap<K,V> head = bucket.get(i);
            while(head != null){
                put(head.key,head.value);
                head = head.next;
            }
        }
    }
    public void remove(K key){
        int idx = getBucketIndex(key);
        NewMap<K,V> head = bucket.get(idx);
        NewMap<K,V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                if(prev == null){
                    bucket.set(idx,head.next);
                }else{
                    prev.next = head.next;
                }
                head.next = null;
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }

    }
}
