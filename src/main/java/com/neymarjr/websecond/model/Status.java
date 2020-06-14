package com.neymarjr.websecond.model;

import org.springframework.stereotype.Component;

/*
 *created 24/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
public class Status<K , V, T> {
    private K key;
    private V value;
    private T type;
    public Status(K key, V value, T type){
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public T getType() {
        return type;
    }
}
