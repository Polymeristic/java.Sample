package pack;

import java.util.Scanner;


class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Integer[][] nums = new Integer[50][2];

        for(;;) {
            System.out.print("Enter a number (q to quit) : ");
            String inp = s.nextLine();

            if (inp.equals("q")) break;

            int number = Integer.parseInt(inp);

            int i = getCounterIndex(nums, number);

            if (i == -1) {
                i = getLastIndex(nums);
                nums[i][0] = number;
                nums[i][1] = 0;
            }

            nums[i][1] ++;
        }

        System.out.format("%-4s %s\n", "N", "Count");

        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i][0] == null) break;

                if (nums[i][0] > nums[i - 1][0]) {
                    Integer[] tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;

                    sorted = false;
                }
            }
        }

        for (Integer[] r : nums) {
            if (r[0] == null) break;
            System.out.format("%-4s %s\n", r[0], r[1]);
        }
    }

    public static int getLastIndex(Integer[][] counter) {
        for (int i = 0; i < counter.length; i++)
            if (counter[i][0] == null) return i;

        return -1;
    }

    public static int getCounterIndex(Integer[][] counter, Integer value) {
        for (int i = 0; i < counter.length; i++) {
            if (counter[i][0] == null) return -1;
            if (counter[i][0].equals(value)) return i;
        }

        return -1;
    }
}
