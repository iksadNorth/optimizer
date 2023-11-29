package me.iksad.optimizer.utils;

import org.junit.jupiter.api.function.Executable;

public class StressTestUtil {
    public static long recordTimeLap(Executable functionForTest) throws Throwable {
        long before = System.currentTimeMillis();
        functionForTest.execute();
        long after = System.currentTimeMillis();

        return after - before;
    }

    public static long multipleCall(int numberOfCall, Executable functionForTest) throws Throwable {
        return recordTimeLap(() -> {
            for(int i=0; i<numberOfCall; i++) {
                functionForTest.execute();
            }
        });
    }
}
