// package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Topic: Hashing
 * Problem: Custom HashMap Implementation
 * 
 * Description: 
 * Implement a custom HashMap from scratch using an array of LinkedLists (Separate Chaining).
 * 
 * Intuition:
 * A HashMap uses an array (buckets) where each element is a LinkedList of Nodes.
 * To insert a key-value pair, we hash the key to find the bucket index. If the key already exists 
 * in that bucket's LinkedList, we update the value. Otherwise, we add a new Node to the LinkedList.
 * To maintain O(1) average time complexity, we perform rehashing (doubling the array size) 
 * when the load factor (total nodes / total buckets) exceeds a threshold (e.g., 2.0).
 * 
 * Complexity: O(1) Time on average for put, get, remove. O(N) Space.
 */
public class CustomHashMapImplementation<K, V> {

    static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n;   // Total number of nodes
    private int N;   // Number of buckets
    private LinkedList<Node<K, V>>[] buckets; // Array of LinkedLists

    @SuppressWarnings("unchecked")
    public CustomHashMapImplementation() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    // Hash Function
    private int hashFunction(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % N;
    }

    // Search key in LinkedList of a specific bucket
    private int searchInLL(K key, int bi) {
        LinkedList<Node<K, V>> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            Node<K, V> node = ll.get(i);
            if (node.key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    // Put operation
    public void put(K key, V value) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            // Key exists → update value
            Node<K, V> node = buckets[bi].get(di);
            node.value = value;
        } else {
            // Add new node
            buckets[bi].add(new Node<>(key, value));
            n++;
        }

        double lambda = (double) n / N;
        if (lambda > 2.0) {
            rehash();
        }
    }

    // Rehashing
    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;

        N = N * 2;
        buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        n = 0;
        for (int i = 0; i < oldBuckets.length; i++) {
            LinkedList<Node<K, V>> ll = oldBuckets[i];
            for (Node<K, V> node : ll) {
                put(node.key, node.value);
            }
        }
    }

    // Contains Key
    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);
        return di != -1;
    }

    // Remove
    public V remove(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node<K, V> node = buckets[bi].remove(di);
            n--;
            return node.value;
        } else {
            return null;
        }
    }

    // Get
    public V get(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            Node<K, V> node = buckets[bi].get(di);
            return node.value;
        } else {
            return null;
        }
    }

    // KeySet
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node<K, V>> ll = buckets[i];
            for (Node<K, V> node : ll) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public static void main(String[] args) {
        CustomHashMapImplementation<String, Integer> hm = new CustomHashMapImplementation<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        System.out.println("Keys in map:");
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("Population of India: " + hm.get("India"));
        System.out.println("Removed India, Population was: " + hm.remove("India"));
        System.out.println("Population of India after removal: " + hm.get("India"));
    }
}
