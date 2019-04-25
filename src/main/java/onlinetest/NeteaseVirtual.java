package onlinetest;

import java.util.Arrays;
import java.util.Scanner;

public class NeteaseVirtual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(NeteaseVirtual.getAns(a, N));
    }

    private static int getAns(int[] a, int N) {
        int cnt = 0;
        Arrays.sort(a);
        int aSum = a[0];
        int bSum = 0;
        for (int i = 1; i < N; i++) {
            bSum += a[i];
        }
        for (int i = 1; i < N; i++) {
            aSum += a[i];
            bSum -= a[i];
            if ((aSum > bSum && aSum - a[i] < bSum + a[i])
                    || (bSum > aSum && i + 1 < N && bSum - a[i + 1] < aSum + a[i + 1])) {
                cnt++;
            }
        }
        return cnt;
    }
}
