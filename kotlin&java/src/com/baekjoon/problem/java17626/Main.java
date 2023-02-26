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

        // 재귀 함수 사용 (방법 1)
//        dfs(n, 0);
//        System.out.println(min);

        // dp(방법2)
        // 본인은 해당 방법이 있는지 몰랐으나 다른 스터디 조원들의 풀이를 보고 알게 되었다.
        // 각 숫자마다 필요한 가장 작은 수를 배열에 기록해 나가는 방식이고
        // 배열의 인덱스 0 은 0으로 설정해둔다.

        // 현재 숫자 >= n^2 을 만족하는 모든 (현재 숫자-n^2) 인덱스를 배열에서 탐색하면서
        // 가장 작은 수를 고르고 +1을 하면 된다.

        // 예를 들어 숫자 4가 있다면 배열의 (4-1^2) = 3 인덱스와 (4-2^2) = 0 인덱스를 비교해서
        // 더 작은 값에 +1을 하고 인덱스 4에 저장한다.
        // +1을 하는 이유는 해당 배열의 조합에서 n^2 를 추가해서 해당하는 숫자조합을 만들 수 있기 때문이다.
        // 위의 예시를 그대로 보자면 숫자 4는 3의 조합에서 1^2 을 더해서 만들 수도 있고 0의 조합에서 2^2를 더해서 만들 수도 있는 것이다.

        int[] arr = new int[n+1];   // 숫자들의 제곱근 최소 조합 배열

        // 각 숫자들의 최소 조합 찾기
        for (int i = 1; i<n+1; i++){

            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++){
                min = Math.min(min, arr[i-j*j]);
                arr[i] = min+1;
            }
        }

        // 숫자 n의 최소 조합 출력
        System.out.println(arr[n]);
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
