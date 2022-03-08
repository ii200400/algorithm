// 문제 링크 : https://www.acmicpc.net/problem/15903
// 제출 공유 링크 : http://boj.kr/d3fc77fc35c94105a8a58396d4994ed3

// 가장 작은 점수를 만들기 위해서는 가장 작은 두 수를 더하는 것이 좋고,
// 모든 수의 대소 비교가 아니라 가장 작은 두 수만 찾으면 되기 때문에 우선순위 큐로 풀라고 대놓고 쓰인 문제;;
// 본인은 추가로 변수를 하나 더 써서 수를 합체할 때마다 카드의 숫자를 더 할 예정이다.

// 오버플로우 또 생각 안해줬다 ^ㅠ^...
// 알아도 가끔 까먹는게 화난다..

package com.baekjoon.problem.java15903;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 카드의 개수
        int m = sc.nextInt();   // 카드 합체 회수
        Long cardsSum = 0l;       // 카드의 총 합
        PriorityQueue<Long> pq = new PriorityQueue<>();  // 카드 합체 시 사용할 큐
        
        // 카드 초기화
        for (int i = 0; i<n; i++){
            Long num = sc.nextLong();
            pq.add(num);
            cardsSum += num;
        }

        // m번 만큼 카드 합체
        for (int i = 0; i<m; i++){
            Long sum = pq.poll()+pq.poll();
            cardsSum += sum;    // 합체 후 나온 수를 더하면 카드 합체 후의 카드의 총 합이다.
            pq.add(sum);
            pq.add(sum);
        }

        // m번 합체 후 카드의 총 합
        System.out.println(cardsSum);
    }
}
