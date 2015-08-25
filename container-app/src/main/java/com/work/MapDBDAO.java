package com.work;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import java.util.Iterator;
import java.util.concurrent.ConcurrentNavigableMap;

public class MapDBDAO {

    private DB db;
    private ConcurrentNavigableMap<Long, Short> map;

    public void createDB(Long[] data, int containerId) {
        db = DBMaker
                .newMemoryDirectDB()
                .cacheSize(32000)
                .transactionDisable()
                .closeOnJvmShutdown()
                .make();

        map = db.getTreeMap("container" + containerId);

        for (Short i = 0; i < data.length; i++) {
            map.put(data[i], i);
        }
    }

    public Iterator<Short> getIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive)
    {
        return map.subMap(fromValue, fromInclusive,toValue,toInclusive).values().stream().sorted().iterator();
    }

}
