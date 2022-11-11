package com.wanted.showmethecode20220702.javaTestA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long g = 1;  // 1~n까지 약수의 총합의 합
        for (int i = 2; i<=n; i++){
            long f = 1 + i;  // 약수의 총합
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                f += sqrt;
                sqrt--;
            }
            for (int j = 2; j<=sqrt; j++){
                if (i%j == 0)
                    f += j + (i/j);
            }

            g += f;
        }

        System.out.println(g);
    }
}
