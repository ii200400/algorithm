// 문제 링크 : https://www.acmicpc.net/problem/1644
// 제출 공유 링크 : http://boj.kr/e42cbaa0eb714933bfd57308e924c03b
// 백준 소수의 연속합

// 확실한 완탐 문제이다
// 에라토스테네스?의 체로 소수를 구하고
// 투포인터를 활용하여 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구한다.

package com.baekjoon.problem.java1644;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 자연수
        boolean[] isPrime = new boolean[n+1];   // 해당 인덱스가 소수인지 여부 배열 (n도 소수일 수 있으므로 크기 +1)
        ArrayList<Integer> primes = new ArrayList<>();  // 소수 리스트 (소수만! 있다.)

        // 소수 배열 초기화
        Arrays.fill(isPrime, true);
        for (int i = 2; i<=n; i++){
            // 이미 소수가 아님이 증명된 숫자는 패스한다.
            if (!isPrime[i])
                continue;

            // 소수인 수를 만나면 리스트에 저장하고 소수가 아닌 수를 확인한다.
            primes.add(i);
            for (int j = i*2; j<=n; j+=i){
                isPrime[j] = false;
            }
        }
//        System.out.println(Arrays.toString(isPrime));

        // 투 포인터를 활용하여 연속된 소수의 합으로 만들 수 있는지 확인한다.
        int sum = 0;    // start<= .. < end 인덱스의 모든 소수들의 총합
        int start = 0, end = 0; // 포인터들 (인덱스 저장 변수들)
        int limit = primes.size();  // 리스트 크기
        int answer = 0; // 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수
        while(true){
            if (sum == n){  // 자연수를 연속된 소수의 합으로 나타낼 수 있다면
                answer++;
                // 이미 더 사용할 수 있는 숫자가 없다면 반복문 탈출
                if (end == limit){
                    break;
                }
                sum += primes.get(end++) - primes.get(start++);
            }else if (sum < n){ // 연속된 소수의 합이 작다면
                // 이미 더 사용할 수 있는 숫자가 없다면 반복문 탈출
                if (end == limit){
                    break;
                }
                // 총합을 크게하기 위해 end 포인터만 증가
                sum += primes.get(end++);
            }else{  // 연속된 소수의 합이 크다면
                // 총합을 작게하기 위해 start 포인터만 증가
                sum -= primes.get(start++);
            }
        }

        // 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수 출력
        System.out.println(answer);
    }
}
