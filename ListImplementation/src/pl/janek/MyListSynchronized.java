package pl.janek;

import java.util.LinkedList;
// naraz sprawdzala cointains tylko jedna klasa
//
public class MyListSynchronized extends LinkedList<Integer> {

    @Override
    public synchronized boolean add(Integer integer) {
        if (contains(integer)){
            System.out.println(Thread.currentThread().getName() + " wartosc juz istnieje!");
            return false;
        }
        if (super.add(integer)){
            //System.out.println("Udalo sie poprawnie dodac!");
            return true;
        }
        else {
            System.out.println("nie udalo sie dodac do listy!");
            return false;
        }
    }

    @Override
    public synchronized boolean contains(Object o) {
        return super.contains(o);
    }
}
