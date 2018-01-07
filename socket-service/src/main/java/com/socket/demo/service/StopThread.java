package com.socket.demo.service;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shang Yinjie on 2018/1/7.
 */
public class StopThread {

    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested()) {
                    i++;
                }

                System.out.println(i);
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        requestStop();
    }
}
