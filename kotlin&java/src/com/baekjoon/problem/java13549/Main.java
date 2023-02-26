// 문제 링크 : https://www.acmicpc.net/problem/13549
// 제출 공유 링크 : http://boj.kr/7ef0b811224341659321b6a10d0d4d37
// 교수님이 추천해주신 기초문제 풀이 중 숨바꼭질 시리즈 풀이 중

// 이야.. 시리즈 문제 기깔나게 잘 변형한다.
// 이런문제들 개인적으로 좋아한다. 하지만 n과 m은 좀.. 아니었다..

package com.baekjoon.problem.java13549;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수빈 위치
        int m = sc.nextInt();   // 동생 위치
        boolean[] visited = new boolean[100001];    // 방문 배열

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        int addNum = n; // 큐에 추가할 숫자
        q.add(addNum);
        visited[addNum] = true;

        // 순간이동할 수 있는 위치도 큐에 추가해준다.
        if (addNum != 0){   // 0은 아무리 곱해도 0이므로 제외
            while ((addNum *= 2) <= 100000){
                q.add(addNum);
                visited[addNum] = true;
            }
        }

        // bfs시작
        int depth = 0;
        while (!q.isEmpty() && !visited[m]) {
            int size = q.size();
            depth++;

            // 레벨 탐색
            for (int i = 0; i<size; i++) {
                int current = q.poll();

                // 현 위치에서 갈 수 있는 다른 위치를 탐색한다.
                for (int search : new int[]{current + 1, current - 1}) {
                    // 탐색 위치가 범위를 벗어났거나 이미 방문을 했다면 생략한다.
                    if (search < 0 || search > 100000 || visited[search])
                        continue;

                    // 큐에 탐색 위치를 추가하고 시간 기록(방문 채크)를 한다.
                    q.add(search);
                    visited[search] = true;

                    // 순간이동할 수 있는 위치도 큐에 추가해준다.
                    if (search != 0) {   // 0은 아무리 곱해도 0이므로 제외
                        // 배열의 범위를 넘지 않을 때까지 2배를 곱하면서
                        while ((search *= 2) <= 100000) {
                            // 방문하지 않은 곳이라면 방문기록하고, 큐에 넣는다.
                            if (visited[search])
                                continue;
                            visited[search] = true;
                            q.add(search);
                        }
                    }
                }
            }
        }

        // 동생 위치로 가는 최소 시간 출력
        System.out.println(depth);
    }
}
