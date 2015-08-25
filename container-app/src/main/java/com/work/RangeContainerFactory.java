package com.work;


import com.google.common.primitives.Longs;

public class RangeContainerFactory implements IRangeContainerFactory {

    @Override
    public IRangeContainer createContainer(long[] data) {
        //TODO: boxing hit so better expose an interface that works of Long[] and also takes in a containerId for now its hardcoded to 101.
        return new RangeContainer(Longs.asList(data).toArray(new Long[data.length]),101);
    }
}
