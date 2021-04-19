package com.openmind.interviews;

import java.util.ArrayList;
import java.util.List;


/**
 * Build a stack with an additional feature: get the minimum element.
 *
 * @param <T> any comparable
 * @author David Bertoldi
 */
public class MinStack<T extends Comparable<?>>
{

    public static void main(String[] args)
    {
        MinStackSolution<Double> stack = new MinStackSolution<>();
        stack.push(1.23);
        stack.push(4.56);
        stack.push(7.53);
        assert stack.minimum() == 1.23;
        stack.pop();
        assert stack.minimum() == 1.23;
        stack.push(-99.0);
        assert stack.minimum() == -99.0;
        stack.pop();
        assert stack.minimum() == 1.23;

    }

    private final List<T> internalList;

    public MinStack()
    {
        this.internalList = new ArrayList<>();
    }

    public void push(T value)
    {
        internalList.add(value);
    }

    public T pop()
    {
        if(!internalList.isEmpty())
        {
            return internalList.remove(internalList.size() - 1);
        }
        throw new IndexOutOfBoundsException("Cannot remove elements from an empty stack");
    }

    public T top()
    {
        if(!internalList.isEmpty())
        {
            return internalList.get(internalList.size() - 1);
        }
        throw new IndexOutOfBoundsException("Cannot read the top of an empty stack");
    }

    /**
     * Implement me in O(n).
     * Then implement me in O(1) (NB: you have to refactor your previous work)
     *
     * @return the min element of the stack.
     */
    public T minimum()
    {
        throw new UnsupportedOperationException("Minimum operation not yet implemented");
    }



    /**
     * Solution implementing {@link #minimum()} in O(1).
     */
    static class MinStackSolution<T extends Comparable<T>>
    {

        private final List<T> internalList;

        private final List<T> minimum;

        public MinStackSolution()
        {
            internalList = new ArrayList<>();
            minimum = new ArrayList<>();
        }

        public void push(T value)
        {
            if(internalList.isEmpty())
            {
                minimum.add(value);
            }
            else
            {
                T currentMin = minimum.get(minimum.size() -1);
                minimum.add(currentMin.compareTo(value) < 0 ? currentMin : value);
            }
            internalList.add(value);

        }

        public T pop()
        {
            if(!internalList.isEmpty())
            {
                minimum.remove(minimum.size() - 1);
                return internalList.remove(internalList.size() - 1);
            }
            throw new IndexOutOfBoundsException("Cannot remove elements from an empty stack");
        }

        public T top()
        {
            if(!internalList.isEmpty())
            {
                return internalList.get(internalList.size() - 1);
            }
            throw new IndexOutOfBoundsException("Cannot read top from an empty stack");
        }

        public T minimum()
        {
            if(!minimum.isEmpty())
            {
                return minimum.get(minimum.size() - 1);
            }
            throw new IndexOutOfBoundsException("Cannot read minimum from an empty stack");
        }



    }







}
