package com.work;


import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class BenchmarkMapDBDAO extends AbstractBenchmark{

    MapDBDAO mapDBDAO;

    private MapDBDAO getDAO() {
        int MAX_SIZE = 32000;
        Long[] inputData = new Long[MAX_SIZE];
        for (short i = 0; i < MAX_SIZE; i++) {
            inputData[i] = i * 10L;
        }

        MapDBDAO dbDao = new MapDBDAO();
        dbDao.createDB(inputData, new Random().nextInt());
        return dbDao;
    }

    @Before
    public void beforeTest() {
        mapDBDAO=getDAO();
    }

    @BenchmarkOptions(callgc = false, benchmarkRounds = 20, warmupRounds = 0)
    @Test
    public void benchmarkCreateDB() throws Exception {
        getDAO();
    }

    @BenchmarkOptions(callgc = false, benchmarkRounds = 20, warmupRounds = 0)
    @Test
    public void benchmarkGetRangeValues() {
        int MAX_VALUE = 32000 * 10;
        int fromValue = new Random().nextInt(MAX_VALUE + 1);
        int toValue = fromValue + new Random().nextInt((MAX_VALUE - fromValue) + 1);
        mapDBDAO.getIdsInRange(fromValue, toValue, true, true);
    }
}