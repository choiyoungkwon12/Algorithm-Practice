package org.example.hackerrank;

import java.util.Stack;

public class Queue {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        save(stack1, 1);
        save(stack1, 12);
        save(stack1, 3);
        save(stack1, 5);
        System.out.println(stack1);
        int pop = pop(stack1, stack2);
        System.out.println(pop);

    }

    private static void save(Stack<Integer> stack, int value) {
        stack.push(value);
    }
    private static int pop(Stack<Integer> saveStack, Stack<Integer> popStack) {
        if(!popStack.isEmpty()){
            return popStack.pop();
        }
        int size = saveStack.size();
        for (int i = 0; i < size; i++) {
            popStack.push(saveStack.pop());
        }
        return popStack.pop();
    }
}
