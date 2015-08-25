package com.work;

interface IRangeContainer {
    Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive);
}
