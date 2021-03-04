package com.algs.leetcode;

import java.util.HashMap;
import java.util.LinkedList;


public class LRUCache {
    class Node{
        public int key, val;
        public Node next, prev;

        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList{
        private Node head, tail;
        private int size;

        public DoubleList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x){
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst(){
            if(head == tail) return null;

            Node first = head.next;
            remove(first);

            return first;
        }

        public int size(){
            return size;
        }
    }

    private DoubleList cache;
    private HashMap<Integer, Node> map;
    private int sz;

    public LRUCache(int capacity) {
        sz = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
        return x.val;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node x = map.get(key);
            cache.remove(x);

            x.val = value;
            cache.addLast(x);

            map.put(key, x);
        }else{
            if(cache.size() >= sz){
                map.remove(cache.removeFirst());
            }

            Node x = new Node(key, value);
           cache.addLast(x);
            map.put(key, x);
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(2,6);
        lru.get(1);
        lru.put(1,5);
        lru.put(1,2);
        lru.get(1);

        System.out.println(lru.get(2));
    }
}
