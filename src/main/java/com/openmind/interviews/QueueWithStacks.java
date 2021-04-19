package com.openmind.interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Build a queue using stacks only.
 *
 * @author David Bertoldi
 */
public class QueueWithStacks
{

    public static void main(String... args)
    {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        assert queue.first() == 1;
        queue.dequeue();
        assert queue.first() == 2;
        assert queue.last() == 4;
        queue.dequeue();
        assert queue.first() == 3;
    }

    /**
     * Starting from a basic stack...
     */
    public static class Stack<T>
    {
        private final List<T> internalStack = new ArrayList<>();

        public void push(T element)
        {
            internalStack.add(element);
        }

        public T pop()
        {
            if(isEmpty())
            {
                return null;
            }
            return internalStack.remove(size() - 1);
        }

        public boolean isEmpty()
        {
            return internalStack.isEmpty();
        }

        public int size()
        {
            return internalStack.size();
        }

        public T top()
        {
            return internalStack.get(size() - 1);
        }
    }

    /**
     * ... you can build a queue with two stacks.
     */
    public static class Queue<T>
    {
        private final Stack<T> mainStack = new Stack<>();
        private final Stack<T> secondaryStack = new Stack<>();

        /**
         * Everything can work as a normal stack here.
         */
        public void enqueue(T element)
        {
            mainStack.push(element);
        }

        /**
         * The magic happens here.
         * Every time an element is dequeued, switch all elements from the main stack
         * to the secondary one except for 1 element, pop that element and refill back
         * the main stack.
         */
        public T dequeue()
        {
            switchStacksUntil(mainStack, secondaryStack, 1);
            T element = mainStack.pop();
            switchStacksUntil(secondaryStack, mainStack, 0);
            return element;
        }

        private void switchStacksUntil(Stack<T> q1, Stack<T> q2, int size)
        {
            if (!q1.isEmpty())
            {
                while (q1.size() != size)
                {
                    q2.push(q1.pop());
                }
            }
        }

        public boolean isEmpty()
        {
            return mainStack.isEmpty();
        }

        public int size()
        {
            return mainStack.size();
        }

        /**
         * It's always the last element of the main stack.
         * Again, switch all elements from the main stack
         * to the secondary one except for 1 element, save that element,
         * refill back the main stack and return the saved element.
         */
        public T first()
        {
            switchStacksUntil(mainStack, secondaryStack, 1);
            T element = mainStack.top();
            switchStacksUntil(secondaryStack, mainStack, 0);
            return element;
        }

        /**
         * It's always the first element of the main stack.
         */
        public T last()
        {
            return mainStack.top();
        }

    }


}
