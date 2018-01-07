package com.socket.demo.service;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Shang Yinjie on 2018/1/7.
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    // The number of add operation
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<Integer> instrumentedHashSet1 = new InstrumentedHashSet<Integer>();
        instrumentedHashSet1.add(1);
        instrumentedHashSet1.add(2);
        instrumentedHashSet1.add(3);

        InstrumentedHashSet<Integer> instrumentedHashSet2 = new InstrumentedHashSet<Integer>();
        instrumentedHashSet2.addAll(instrumentedHashSet1);

        int addCount = instrumentedHashSet2.getAddCount();
        System.out.print(addCount);
    }
}
