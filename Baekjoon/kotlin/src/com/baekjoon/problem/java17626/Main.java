// 문제 링크 : https://www.acmicpc.net/problem/17626
// 제출 공유 링크 : http://boj.kr/194075f6cb534fc8832398c23bb44ef9

// 처음에는 그냥 탐욕법처럼 풀었는데 역시 아닌가 보다
// 그럼 조합처럼 해결해봐야겠다.

package com.baekjoon.problem.java17626;

import java.util.Scanner;

public class Main {

    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 입력된 숫자
        min = 4;    // 제곱수들의 최소 갯수

        // 틀린 풀이
//        // n이 0이 되기 전까지 반복하는데
//        while(n != 0){
//            // n보다 작은 최대의 제곱수를 n에서 빼기만하면 된다.
//            int sqrt = (int) Math.sqrt(n);
//            n -= sqrt*sqrt;
//            min++;
//        }

        // 재귀 함수 사용
        dfs(n, 0);

        System.out.println(min);
    }

    // 수를 받으면 해당 수의 가능한 제곱근 조합의 수를 세는 재귀 함수
    static boolean dfs(int num, int cnt){
        // 조건에 맞는다면
        if (num == 0) {
            // 기록을 갱신해주고 적절하게 반환한다.
            min = Math.min(min, cnt);
            return min == 1;    // 조합이 1이라면 다른 연산 없이 바로 모든 재귀를 떠나면 된다.
        }
        
        // 문제 조건에 제곱근 조합이 4개를 초과 하지 않는다고 했으므로
        // 생각해보니 cnt >= min이 더 좋은 것 같다.
        if (cnt == 4)
            return false;

        // 받은 수의 제곱근부터 받은 수/4의 제곱근까지
        int sqrt = (int) Math.sqrt(num);
        int limit = (int) Math.sqrt(num/4);

        // 제곱근 조합에 들어갈 수 있다. 
        // num/4 보다 작은 제곱근은 수가 너무 작아서 조합이 못해도 4개를 초과하게 된.. 다고 생각한다.(뇌피셜)
        for (int i = sqrt; i>limit; i--){
            // 해당 숫자를 선택하고 계속 진행한다.
            if (dfs(num-i*i, cnt+1))
                return true;
        }

        return false;
    }
}
