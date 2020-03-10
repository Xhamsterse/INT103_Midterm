/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastmoveV0_7_8;

import java.util.Objects;
import java.util.Iterator;
/**
 *
 * @author Saraf
 */
public class GenericBag<T> implements Bag<T> {
    private T[] items;
    private int count;
    private int maxItem;

    public GenericBag(int maxItem) {
        this.maxItem = maxItem;
        this.items=(T[]) (new Objects[maxItem]);
    }
    
    @Override
    public boolean add(T t) {
        Objects.requireNonNull(t);
        if (this.count == this.items.length) {
            return false;
        }
        this.items[this.count++] = t;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor=0;
            @Override
            public boolean hasNext() {
                return cursor==GenericBag.this.count;
            }

            @Override
            public T next() {
                return GenericBag.this.items[cursor++];
            }
                
        };
    }


}
