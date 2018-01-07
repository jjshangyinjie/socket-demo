package com.socket.demo.service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Shang Yinjie on 2018/1/7.
 */
public class AtomicStopThread {
    private static AtomicBoolean stopRequested = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested.get()) {
                    i++;
                }

                System.out.println(i);
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        stopRequested.compareAndSet(false, true);
    }
}
