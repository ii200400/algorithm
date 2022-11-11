// 문제 링크 : https://www.acmicpc.net/problem/11399
// 제출 공유 링크(stream) : http://boj.kr/daa8d85869d74d73adaf49b9e1fd2bdf
// 제출 공유 링크(Arrays) : http://boj.kr/0e2d3a31fd204fc9871fdd7543cadac5

// 예전에 풀기도 했지만.. 문제를 읽으면 바로 정렬해야한다는 것이 느껴진다.
// 1.8버전에도 사용 가능한 stream을 사용해보았는데 많이 느리다.

package com.baekjoon.problem.java11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 사람 수

        // 1. stream 이용하는 방법
//        int[] arr = Arrays.stream(sc.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .mapToInt(i -> i).sorted().toArray();

        // 2. Array 이용하는 방법
        int[] arr = new int[n]; // 인출 시간
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // 빠르게 뽑는 사람이 먼저 뽑을수록 총 대기 시간이 줄어들기 때문에 오름차순 정렬
        Arrays.sort(arr);

        // 총 대기시간을 연산하고
//        int sum = 0;
//        for (int i = 0; i<n; i++){
//            sum += arr[i] * (n-i);
//        }

        // 이렇게 더해도 된다.
        int sum = 0, temp = 0;
        for (int i = 0; i<n; i++){
            temp += arr[i];
            sum += temp;
        }

        // 출력한다.
        System.out.println(sum);
    }
}
