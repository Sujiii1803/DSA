package Queue.Leetcode;

import java.util.*;

class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max heap based on remaining frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[1] - a[1]
        );

        // Add each unique task
        for (char ch : map.keySet()) {
            pq.offer(new int[]{ch, map.get(ch)});
        }

        // Queue: {task, remainingFrequency, availableTime}
        Queue<int[]> q = new ArrayDeque<>();

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            // Move all tasks whose cooldown is over
            while (!q.isEmpty() && q.peek()[2] == time) {

                int[] task = q.poll();

                pq.offer(new int[]{
                        task[0],
                        task[1]
                });
            }

            // Execute the task with highest frequency
            if (!pq.isEmpty()) {

                int[] current = pq.poll();

                current[1]--;

                // If task still has remaining occurrences,
                // put it into cooldown
                if (current[1] > 0) {

                    q.offer(new int[]{
                            current[0],
                            current[1],
                            time + n + 1
                    });
                }
            }

            time++;
        }

        return time;
    }
}

public class TaskScheduleMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int size = sc.nextInt();

        char[] tasks = new char[size];

        System.out.println("Enter the tasks:");

        for (int i = 0; i < size; i++) {
            tasks[i] = sc.next().charAt(0);
        }

        System.out.print("Enter cooldown time n: ");
        int n = sc.nextInt();

        TaskScheduler obj = new TaskScheduler();

        int result = obj.leastInterval(tasks, n);

        System.out.println("Minimum intervals required: " + result);

        sc.close();
    }
}