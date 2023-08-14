package com.yucfeng;

import java.util.Queue;
import java.util.Stack;

public class Solution<E> {

    private final Stack<E> stack1 = new Stack<>();
    private final Stack<E> stack2 = new Stack<>();

    public boolean add(E e) {
         stack1.push(e);
         return true;
    }

    public E poll() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        E e = stack2.isEmpty()?null: stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return e;
    }

}
