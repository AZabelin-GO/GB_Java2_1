package com.geekbrains.java2.homework5;

import java.util.Arrays;

public class Main {
    private static final int ARRAY_SIZE = 10000000;

    private static void initAndCalculateArrayInOneThread() {
        System.out.println("Starting method initAndCalculateArrayInOneThread...");

        float[] array = new float[ARRAY_SIZE];

        Arrays.fill(array, 1.0f);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Array filled and calculated for " + ((endTime - startTime) / 1000.0) + " second(s) using ONE thread");
        System.out.println();
    }

    private static void initAndCalculateArrayInTwoThreads() {
        System.out.println("Starting method initAndCalculateArrayInTwoThreads...");

        float[] arrayResult = new float[ARRAY_SIZE];
        float[] arrayOne = new float[ARRAY_SIZE / 2];
        float[] arrayTwo = new float[ARRAY_SIZE / 2];

        Arrays.fill(arrayResult, 1.0f);

        long startTime = System.currentTimeMillis();

        System.arraycopy(arrayResult, 0, arrayOne, 0, ARRAY_SIZE / 2);
        System.arraycopy(arrayResult, ARRAY_SIZE / 2, arrayTwo, 0, ARRAY_SIZE / 2);

        Thread threadOne = new Thread(() -> {
            System.out.println("Starting threadOne...");
            for (int i = 0; i < ARRAY_SIZE / 2; i++) {
                arrayOne[i] = (float)(arrayOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("threadOne finished");
        });

        Thread threadTwo = new Thread(() -> {
            System.out.println("Starting threadTwo...");
            for (int i = 0; i < ARRAY_SIZE / 2; i++) {
                arrayTwo[i] = (float)(arrayTwo[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("threadTwo finished");
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrayOne, 0, arrayResult, 0, ARRAY_SIZE / 2);
        System.arraycopy(arrayTwo, 0, arrayResult, ARRAY_SIZE / 2, ARRAY_SIZE / 2);

        long endTime = System.currentTimeMillis();

        System.out.println("Array filled and calculated for " + ((endTime - startTime) / 1000.0) + " second(s) using TWO threads");
    }

    public static void main(String[] args) {
        initAndCalculateArrayInOneThread();
        initAndCalculateArrayInTwoThreads();
    }
}
