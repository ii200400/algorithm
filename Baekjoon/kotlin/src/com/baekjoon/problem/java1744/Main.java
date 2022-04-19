// 문제 링크 : https://www.acmicpc.net/problem/1744
// 제출 공유 링크 : http://boj.kr/4bb40524880b48cb8ce3b6388d8b48ed
// 백준 수 묶기

// 처음에는 수열의 순서를 보장해서 묶는 줄 알아서 머리 빠지는 줄..
// 음수끼리 곱하면 양수가 되고 0이랑 음수랑 곱하면 일단 마이너스가 아니니까.. 해당 부분을 확인해서 풀면 될 것 같다.

package com.baekjoon.problem.java1744;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수열의 크기
        PriorityQueue<Integer> pqPlus = new PriorityQueue<>(Comparator.comparingInt(o -> -o));  // 우선순위 큐 (음수와 0)
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>();  // 우선순위 큐 (양수)
        int sum = 0;

        // 우선순위 큐들 초기화
        for (int i = 0; i<n; i++){
            int num = sc.nextInt();
            if (num == 1){
                sum++;
            }else if (num > 1){
                pqPlus.offer(num);
            }else{
                pqMinus.offer(num);
            }
        }

        // 양수 우선순위 큐에 있는 값 2개씩 곱해서 더하기
        while (pqPlus.size() >= 2){
            sum += pqPlus.poll() * pqPlus.poll();
        }
        // 남는 양수가 있다면 더하기
        if (pqPlus.size() == 1){
            sum += pqPlus.poll();
        }

        // 음수 우선순위 큐에 있는 값 2개씩 곱해서 더하기
        while (pqMinus.size() >= 2){
            sum += pqMinus.poll() * pqMinus.poll();
        }
        // 남는 음수가 있다면 더하기
        if (pqMinus.size() == 1){
            sum += pqMinus.poll();
        }

        // 총합 출력
        System.out.println(sum);
    }
}
