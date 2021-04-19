package com.openmind.interviews;

import java.util.Arrays;


/**
 * Find the distance of the closest pair of numbers from a given array.
 * N.B distance(n, m) := |n-m|
 *
 * @author David Bertoldi
 */
public interface FindClosest
{

    static void main(String[] args)
    {
        int[] array1 = {3, 9, 50, 15, 99, 7, 98, 65};
        assert new FindClosestSolution().find(array1) == 1;

        int[] array2 = {1, 7, 12, 44};
        assert new FindClosestSolution().find(array2) == 5;
    }

    /**
     * Implement me.
     * N.B. would be easier if the array was sorted?
     * @param array given array.
     * @return the
     */
    int find(int[] array);

    /**
     * Sort the array first, then compare each element with the previous one.
     */
    class FindClosestSolution implements FindClosest
    {
        @Override
        public int find(int[] array)
        {
            if(array.length <= 1)
            {
                throw new IllegalArgumentException("Invalid array");
            }
            Arrays.sort(array); // side-effects are acceptable

            int closest = Integer.MAX_VALUE;
            for(int i = 1; i < array.length; i++)
            {
                if(array[i]-array[i-1] < closest)
                {
                    closest = array[i]-array[i-1];
                }
            }
            return closest;
        }
    }

}
