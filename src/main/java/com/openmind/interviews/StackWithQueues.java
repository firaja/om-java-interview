package com.openmind.interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Build a stack using queues only.
 *
 * @author David Bertoldi
 */
public class StackWithQueues
{

    public static void main(String... args)
    {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.pop();
        assert stack.top() == 3;
        stack.pop();
        assert stack.top() == 2;
    }

    /**
     * Starting from a basic queue...
     */
    public static class Queue<T>
    {
        private final List<T> internalQueue = new ArrayList<>();

        public T dequeue()
        {
            return internalQueue.remove(0);
        }

        public void enqueue(T element)
        {
            internalQueue.add(element);
        }

        public boolean isEmpty()
        {
            return internalQueue.isEmpty();
        }

        public int size()
        {
            return internalQueue.size();
        }

        public T first()
        {
            if(isEmpty())
            {
                return null;
            }
            return internalQueue.get(0);
        }

        public T last()
        {
            if(isEmpty())
            {
                return null;
            }
            return internalQueue.get(size() - 1);
        }
    }

    /**
     * ... you can build a stack with two queues.
     */
    public static class Stack<T>
    {
        private final Queue<T> mainQueue = new Queue<>();
        private final Queue<T> secondaryQueue = new Queue<>();

        /**
         * Everything can work as a normal queue here.
         */
        public void push(T element)
        {
            mainQueue.enqueue(element);
        }

        /**
         * The magic happens here.
         * Every time an element is popped, switch all elements from the main queue
         * to the secondary one except for 1 element, dequeue that element and refill back
         * the main queue.
         */
        public T pop()
        {
            switchQueuesUntil(mainQueue, secondaryQueue, 1);
            T element = mainQueue.dequeue();
            switchQueuesUntil(secondaryQueue, mainQueue, 0);
            return element;
        }

        private void switchQueuesUntil(Queue<T> q1, Queue<T> q2, int size)
        {
            if (!q1.isEmpty())
            {
                while (q1.size() != size)
                {
                    q2.enqueue(q1.dequeue());
                }
            }
        }

        /**
         * It's always the last element of the main queue.
         */
        public T top()
        {
            return mainQueue.last();
        }
    }


}
