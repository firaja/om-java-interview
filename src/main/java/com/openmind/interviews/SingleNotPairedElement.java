package com.openmind.interviews;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given a collection of positive integers, every element appears twice except for one.
 * Write a function that returns the single not paired element.
 *
 * @author David Bertoldi
 */
public interface SingleNotPairedElement
{

    public static void main(String[] args)
    {
        List<Integer> collection1 = Arrays.asList(7, 2, 2, 3, 7);
        assert new NaiveSolution().find(collection1) == 3;
        assert new EfficientSolution().find(collection1) == 3;

        List<Integer> collection2 = Arrays.asList(1,1,1);
        assert new NaiveSolution().find(collection2) == 1;
        assert new EfficientSolution().find(collection2) == 1;
    }


    /**
     * Implement me.
     * Then try to implement me with time-complexity O(n) and space-complexity O(1).
     */
    int find(Collection<Integer> collection);

    /**
     * Use a map to count pairs.
     * Then for each entry of the map, find the pair with an odd counter.
     */
    class NaiveSolution implements SingleNotPairedElement
    {

        @Override
        public int find(Collection<Integer> collection)
        {
            Map<Integer, Integer> findings = new HashMap<>();
            for (int i : collection)
            {
                if (findings.containsKey(i))
                {
                    findings.put(i, findings.get(i) + 1);
                }
                else
                {
                    findings.put(i, 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : findings.entrySet())
            {
                if (entry.getValue() %2 != 0)
                {
                    return entry.getKey();
                }
            }
            throw new IllegalArgumentException("All integers are paired");
        }
    }

    /**
     * Use XOR: every two equal elements the information is zeroed.
     */
    class EfficientSolution implements SingleNotPairedElement
    {

        @Override
        public int find(Collection<Integer> collection)
        {
            int xor = 0;
            for (int i : collection)
            {
                xor ^= i;
            }
            if (xor != 0)
            {
                return xor;
            }
            else
            {
                throw new IllegalArgumentException("All integers are paired");
            }
        }
    }

}
