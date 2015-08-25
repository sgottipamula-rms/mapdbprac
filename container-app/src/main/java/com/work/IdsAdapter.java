package com.work;

import java.util.Iterator;

/**
 * Simple class to make the short iterator Ids compliant
 */
public class IdsAdapter implements Ids {

    Iterator<Short> iteratorOfData;

    public IdsAdapter(Iterator<Short> iteratorOfData)
    {
        this.iteratorOfData = iteratorOfData;
    }

    @Override
    public short nextId() {
        if(iteratorOfData.hasNext())
        {
            return iteratorOfData.next();
        }
        else
        {
            return END_OF_IDS;
        }
    }
}
