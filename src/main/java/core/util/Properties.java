package core.util;

import java.util.HashMap;
import java.util.Map;

public class Properties {

    private static final ThreadLocal<Map<String, Object>> threadLocalMap =
            new ThreadLocal<Map<String, Object>>() {
                @Override
                protected Map<String, Object> initialValue() {
                    return new HashMap<>();
                }
            };

    public static void main(String[] args) {
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                // Get the thread-local map
                Map<String, Object> map = threadLocalMap.get();

                // Add some data to the map
                map.put("key1", "value1");
                map.put("key2", "value2");

                // Do some work
                System.out.println("Task 1 working...");

                // Remove the data from the map
                map.remove("key1");
                map.remove("key2");
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                // Get the thread-local map
                Map<String, Object> map = threadLocalMap.get();

                // Add some data to the map
                map.put("key3", "value3");
                map.put("key4", "value4");

                // Do some work
                System.out.println("Task 2 working...");

                // Remove the data from the map
                map.remove("key3");
                map.remove("key4");
            }
        };

        // Create two threads and run the tasks in parallel
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            // Wait for the threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
