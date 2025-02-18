package thread.collection.simple.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> copySet = new CopyOnWriteArraySet<>();
        copySet.add(1);
        copySet.add(2);
        copySet.add(3);
        copySet.add(4);
        copySet.add(5);
        copySet.add(6);
        copySet.add(7);
        copySet.add(8);
        copySet.add(9);
        System.out.println("copySet = " + copySet);

        ConcurrentSkipListSet<Object> skipSet = new ConcurrentSkipListSet<>();
        skipSet.add(1);
        skipSet.add(4);
        skipSet.add(6);
        skipSet.add(2);
        skipSet.add(5);
        skipSet.add(3);
        System.out.println("skipSet = " + skipSet);
    }
}
