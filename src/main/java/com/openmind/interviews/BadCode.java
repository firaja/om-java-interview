package com.openmind.interviews;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * This class contains bad practices and errors.
 * Fix it as best you can.
 *
 * @author David Bertoldi
 */
public class BadCode
{


    int operate1(Date time)
    {
        Integer i = new Integer(0);
        try
        {
            i = time.getMinutes();
        }
        catch(NullPointerException npe)
        {
            System.out.println("cannot resolve date");
            return -1;
        }

        return i;
    }


    /*------------------------------------------------------------------*/


    public void removeIt(List<String> listOfStrings)
    {
        for(int i = 0; i < listOfStrings.size(); i++)
        {
            if(mustBeDeleted(listOfStrings.get(i)))
            {
                listOfStrings.remove(i);
            }
        }
    }

    private boolean mustBeDeleted(String s)
    {
        return "3".equals(s);
    }


    /*------------------------------------------------------------------*/

    class BadCodeSolution
    {
        /**
         * Remove boxings, weird try-catch, renaming and updated API
         */
        public int getMinute(ZonedDateTime time)
        {
            if(time == null)
            {
                throw new IllegalArgumentException("Time cannot be null");
            }
            return time.getMinute();
        }

        /**
         * Usage of iterators when required
         */
        public void removeIt(List<String> listOfStrings)
        {
            Iterator<String> iter = listOfStrings.iterator();
            while(iter.hasNext())    // or Collection.removeIf
            {
                String s = iter.next();

                if(mustBeDeleted(s))
                {
                    iter.remove();
                }
            }
        }

        private boolean mustBeDeleted(String s)
        {
            return "3".equals(s);
        }


    }


}
