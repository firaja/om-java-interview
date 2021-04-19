package com.openmind.interviews;

/**
 * Find the position of a given element in a given array
 *
 * @author David Bertoldi
 */
public interface FindElement
{

    /**
     * Implement me in linear or logarithmic time.
     * @param array
     * @param element to find
     * @return the position
     */
    int find(int[] array, int element);





    class LinearSolution implements FindElement
    {

        @Override
        public int find(int[] array, int element)
        {
            int index = -1;
            for(int i: array)
            {
                index += 1;
                if(i == element)
                {
                    return index;
                }
            }
            return -1;
        }
    }

    /**
     * Binary search (iterative).
     */
    class LogarithmicSolution implements FindElement
    {

        @Override
        public int find(int[] array, int element)
        {
            int left = 0;
            int right = array.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;

                if (array[middle] == element)
                {
                    return middle;
                }
                if (array[middle] < element)
                {
                    left = middle + 1;
                }
                else
                {
                    right = middle - 1;
                }
            }
            return -1;
        }
    }


}
