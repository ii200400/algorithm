// 문제 링크 : https://www.acmicpc.net/problem/2839
// 제출 공유 링크 : http://boj.kr/61850bf4397d45aab04501cb5a24ea99

// 봉지 5짜리를 사용하는 경우를 늘리는 것이 가장 우선되므로 우선 봉지 5를 기준으로 나누고 진행한다.

package com.baekjoon.problem.java2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = -1;
        int bag5 = n / 5;
        int left5 = n % 5;

        // 방법 1
        // 5*3 = 15 이므로 (여기의 n = 설탕 무게/5)
        // 봉투 5짜리를 n개 쓰는 경우는 n-3개 쓰는 경우보다,
        // n-1개 쓰는 경우는 n-4개 쓰는 경우보다,
        // n-2개 쓰는 경우는 n-5개 쓰는 경우보다
        // 무조건 더 적게 쓴다!
        // 때문에 3가지의 경우만 고려해주면 되므로 if문을 3개 만들어 진행하였다.
//        if ((n - 5 * bag5) % 3 == 0) {
//            answer = bag5 + (n - 5 * bag5) / 3;
//        } else if (bag5 >= 1 && (n - 5 * (bag5 - 1)) % 3 == 0) {
//            answer = bag5 - 1 + (n - 5 * (bag5 - 1)) / 3;
//        } else if (bag5 >= 2 && (n - 5 * (bag5 - 2)) % 3 == 0) {
//            answer = bag5 - 2 + (n - 5 * (bag5 - 2)) / 3;
//        }

        // 방법 2
        // 위에서 만든 방법을 잘 생각해보면 5의 나머지마다 3가지 연산 중 하나에 들어가 계산을 진행하는 것을 볼 수 있다.
        // 즉, 5의 몫이 아니라 나머지에 따라서 작업을 나누는 방법도 있다!
        // 여기서는 4와 7은 예외처리를 진행하였다.
        // 방법 1처럼 if문에 변수를 사용하여 예외처리를 하는 방법을 사용해도 무관하다.
//        if (n == 4 || n == 7){
//            System.out.println(-1);
//            return;
//        }
//
//        if (left5 == 0) {
//            answer = bag5;
//        } else if (left5 == 1) {
//            answer = bag5 + 1;
//        } else if (left5 == 2) {
//            answer = bag5 + 2;
//        } else if (left5 == 3){
//            answer = bag5 + 1;
//        }else { // left5 == 4
//            answer = bag5 + 2;
//        }

        // 방법 3
        // 방법 2에서 배열을 활용하는 방법이다.
        // 단순히 코드가 더 짧아지고 if문이 사라진다는 장점이, 메모리를 더 먹는다는 단점이 있다.
        // 12kB를 더 사용하였고 슬프게도 속도는 같았다...

        int[] arr = new int[] {0, 1, 2, 1, 2};

        if (n == 4 || n == 7){
            System.out.println(-1);
        }else{
            System.out.println(bag5+arr[left5]);
        }
    }
}
