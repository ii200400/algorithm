// 문제 링크 : https://www.acmicpc.net/problem/1697
// 제출 공유 링크 : http://boj.kr/6664323e44344577a14b88692369c4a0
// 백준 숨바꼭질

// 예전에 푼 경험이 있는 것 같은데..?
// 범위를 벗어나는 경우라면 예외처리를 해주어야 하는데 안해주어서 인덱스 범위 에러가 좀 떳다..

package com.baekjoon.problem.java1697;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 수빈 위치
        int k = sc.nextInt();   // 동생 위치
        if (n == k){    // 둘이 같은 위치에 있는 경우
            System.out.println(0);
            return;
        }

        // 입력 범위가 0~100000 이어도 더 큰 범위에서 -1씩해서 도달하는 경우도 있기 때문에 적당히 100000보다 큰수를 넣었다.
        boolean[] visited = new boolean[140000];

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;

        int time = 0;   // 동생을 찾는데 걸린 시간
        search: while(true){
            time++;
            int size = q.size();

            for (int i = 0; i<size; i++) {
                int loc = q.poll();

                // 현 위치에서 +1, -1, *2 위치를 탐색한다.
                for (int j : new int[]{1, -1, loc}) {
                    int goTo = loc + j;   // 다음으로 갈 위치
                    // 동생이 있는 곳에 도착했다면 탈출
                    if (goTo == k) {
                        break search;
                    }

                    // 탐색 범위를 벗어나거나 이미 방문했었다면 생략
                    if (goTo >= 140000 || goTo <= 0 || visited[goTo])
                        continue;

                    // 방문 처리하고 계속 진행
                    visited[goTo] = true;
                    q.offer(goTo);
                }
            }
        }

        // 동생을 찾을 때 까지 걸린 시간 출력
       System.out.println(time);
    }
}
