package com.jyeh.appletree;

@FunctionalInterface
public interface Visitor<T> {
    void visit(T t);
}
