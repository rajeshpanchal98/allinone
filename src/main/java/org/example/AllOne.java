package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AllOne {

    Map<String, Integer> frequencyOfString;
    Map<Integer, Dll> nodePointer;
    Dll head, tail;

    AllOne() {
        frequencyOfString = new HashMap<>();
        nodePointer = new HashMap<>();
        head = null;
        tail = null;
    }

    public Optional<String> getMax() {
        return tail == null ? Optional.empty() : tail.strings.stream().findAny();
    }

    public Optional<String> getMin() {
        return head == null ? Optional.empty() : head.strings.stream().findAny();
    }

    void increment(String key) {
        if (frequencyOfString.containsKey(key)) {
            Integer freq = frequencyOfString.get(key);
            Dll node = nodePointer.get(freq);

            Dll nextNode = node.next;


            if (nextNode == null || !nodePointer.containsKey(freq + 1)) {
                Dll temp = new Dll(freq + 1);
                temp.strings.add(key);

                temp.next = node.next;
                temp.prev = node;
                node.next = temp;
                if (nextNode != null) nextNode.prev = temp;

                if (nextNode == null) tail = temp;

                nodePointer.put(freq + 1, temp);

            } else {
                nextNode.strings.add(key);
            }
            remove(node, key);
            frequencyOfString.put(key, freq + 1);



        } else {
            if (head == null || head.no > 1) {
                Dll temp = new Dll(1);
                temp.next = head;
                temp.strings.add(key);
                if(head!=null)
                    head.prev=temp;
                head = temp;
                nodePointer.put(1, temp);
            } else {
                head.strings.add(key);
            }

            if (tail == null) tail = head;
            frequencyOfString.put(key, 1);
        }
        print();

    }

    void remove(Dll node, String key) {
        node.strings.remove(key);
        if (node.strings.isEmpty()) {
            if (node == head) {
                head = node.next;
                if(head!=null)
                    head.prev=null;
            }

            else if (node == tail) {
                tail = tail.prev;
                if(tail!=null)
                    tail.next=null;
            }
            else {
                Dll prev = node.prev;
                prev.next = node.next;
                if (node.next != null) node.next.prev = prev;
            }

            if (head == null || tail == null) head = tail = null;
            nodePointer.remove(frequencyOfString.get(key));

        }

        print();
    }

    void decrement(String key) {
        if (frequencyOfString.containsKey(key)) {
            Integer freq = frequencyOfString.get(key);
            Dll node = nodePointer.get(freq);

            Dll prevNode = node.prev;


            if (freq == 1) {
                frequencyOfString.remove(key);
                remove(node, key);
                return;
            }
            if (prevNode == null || !nodePointer.containsKey(freq - 1)) {
                Dll temp = new Dll(freq - 1);
                temp.strings.add(key);

                temp.next = node;
                temp.prev = prevNode;
                node.prev = temp;
                if (prevNode != null) prevNode.next = temp;

                if (prevNode == null) head = temp;

                nodePointer.put(freq - 1, temp);

            } else {
                prevNode.strings.add(key);
            }
            remove(node, key);
            frequencyOfString.put(key, freq - 1);



        }
         print();
    }


    void print() {
        Dll temp = head;
        while (temp != null) {
            System.out.println(temp.no);
            System.out.println(temp.strings.toString());
            temp = temp.next;
        }
    }
}