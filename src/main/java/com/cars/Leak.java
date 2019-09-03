package com.cars;

import java.util.LinkedList;
import java.util.List;

public class Leak {
    public static List<byte[]> leakyCollection = new LinkedList<>();
    
    public static void addToCollection(int number, int size) {
        for (int i = 0; i < number; i++) {
            leakyCollection.add(new byte[size]);
        }
    }
    
    public static long getSize() {
        long size = 0L;
        for(byte[] bytes : leakyCollection) {
            size += bytes.length;
        }
        
        return size;
    }
    
    public static void drainCollection() {
        leakyCollection = new LinkedList<>();
    }
}
