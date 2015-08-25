package com.work;


import java.util.Iterator;

public class RangeContainer implements IRangeContainer {

    private MapDBDAO mapDBDAO;

    public RangeContainer(Long[] data, int containerId) {
        mapDBDAO = new MapDBDAO();
        mapDBDAO.createDB(data, containerId);
    }

    @Override
    public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {
        Iterator<Short> iterator = mapDBDAO.getIdsInRange(fromValue, toValue, fromInclusive, toInclusive);
        Ids ids = new IdsAdapter(iterator);
        return ids;
    }
}
