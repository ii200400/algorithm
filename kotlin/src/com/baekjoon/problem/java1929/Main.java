// 문제 링크 : https://www.acmicpc.net/problem/1929
// 제출 공유 링크 : http://boj.kr/28c6a13774a046d4bf13dca065f5088d

// 에라토스테네스의 체? 였나? 활용하여 구현

package com.baekjoon.problem.java1929;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 초기화
        int m = sc.nextInt(), n = sc.nextInt();
        boolean[] sieve = new boolean[n+1];
        Arrays.fill(sieve, true);
        sieve[1] = false; // 1은 소수가 아니다.
        
        // 체로 거르기 시작
        for (int i = 2; i<n+1; i++){
            if (sieve[i]){
                for(int cut = 2*i; cut<n+1; cut += i){
                    sieve[cut] = false;
                }
            }
        }

        // 체로 걸러지지 않은 소수 출력
        for (int i = m; i<n+1; i++){
            if (sieve[i])
                System.out.println(i);
        }
    }
}
