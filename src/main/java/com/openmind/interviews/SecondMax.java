package com.openmind.interviews;

/**
 * Find the second maximum number from a given array
 *
 * @author David Bertoldi
 */
public interface SecondMax
{

    /**
     * Implement me.
     *
     * @param array
     * @return
     */
    int find(int[] array);


    class SecondMaxSolution implements SecondMax
    {
        @Override
        public int find(int[] array)
        {
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;

            for (int number : array)
            {
                if (number > max)
                {
                    secondMax = max;
                    max = number;
                }
                else if (number > secondMax)
                {
                    secondMax = number;
                }
            }
            return secondMax;
        }
    }


}
