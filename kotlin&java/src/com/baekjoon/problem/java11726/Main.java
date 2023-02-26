// 문제 링크 : https://www.acmicpc.net/problem/11726
// 제출 공유 링크 : http://boj.kr/1d87074133c241868ed75dcbef5c1b7d
// 백준 2×n 타일링

// 뭐지.. 이 피보나치 수열같은 느낌은?
// 피보나치 수열같은 느낌이 아니라 피보나치 수열과 같다. 하핳;

// 대충 만들어서 출력하려고 보니.. long으로도 오버 플로우가 나는 것 같아서 dp에 10007로 나눈 나머지를 저장했다.
// 기억상 피보나치 수열은 나머지 연산의 순서 상관 없이 같은 결과가 나오는 것으로 기억하고 있다.
// 예를 들어 30번째 피보나치 수가 1346269이고 31번째가 2178309, 32번째가 3524578 일 때
// (1346269+2178309)%10007 = 3524578%10007 이기도 하지만
// (1346269%10007)+(2178309%10007) = 3524578%10007 인 것을 의미한다.

// 예전에.. 비슷한 상황의 문제가 있던 것 같다..

package com.baekjoon.problem.java11726;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];

        // dp 초기화
        dp[0] = 1;
        dp[1] = 1;
        // 계산 시작
        for (int i = 2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]); // %10007
        }

        // 마지막 수 출력
        System.out.println(dp[n]);
    }
}
