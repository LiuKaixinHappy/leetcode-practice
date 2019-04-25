package onlinetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Netease2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Netease2.getAns(a, k));
    }

    private static int getAns(int[] arr, int n) {
        Arrays.sort(arr);
        int times = 1;
        while(true) {
            int max = arr[n - 1] * times;
            int sum = (max - 1) % arr[n - 1];
            boolean not = false;
            for (int i = n - 2; i >= 0; i--) {
                if (max % arr[i] != 0) {
                    sum = 0;
                    times++;
                    not = true;
                    break;
                }
                sum += (max - 1) % arr[i];
            }
            if (!not) {
                return sum;
            }
        }
    }
}
