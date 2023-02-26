// 문제 링크 : https://www.acmicpc.net/problem/17071
// 제출 공유 링크 : http://boj.kr/2aac018bab234a4a96119f4cadb9b7ce
// 참고 : https://wellbell.tistory.com/68

// 으음.. 이것은 어떻게 풀지 조금 감이 잘 오지 않는다.
// 방문채크가 없는 bfs로 해야할 것 같은데.. 맞나.? 시간제한은 또 왜 0.25..?

// 아.. 해시로 안되서 다른 블로그글을 찾아봤다.
// 내용은 특정 위치에 짝수 방문인지 홀수 방문인지를 따로 저장하여 동생과 만나는지 확인한다는 것
// 현 위치에서 +1 -1하면 2턴을 소비해서 원래자리로 돌아올 수 있는 특징을 활용한 것, 처음에는 잘못 이해해서 조금 해맷닼ㅋㅋ
// 글이랑 같은 생각하고 있었는데 이해못해서 이왜?? 하고 있는 모양이라니^ㅠ^

package com.baekjoon.problem.java17071;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수빈 위치
        int m = sc.nextInt();   // 동생 위치
        // [각 위치마다][짝수 방문 여부, 홀수 방문 여부]
        boolean[][] visited = new boolean[500001][2]; // 짝수/홀수 시간별 방문 여부 배열

        // 방문 배열 초기화
        visited[n] = new boolean[]{true, false};  // 현 위치 초기화

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        // bfs시작
        int depth = 0;
        while (m <= 500000) {   // 동생 위치로 가는 경우의 수가 있다면 탈출

            // 만약 수빈이 갈 수 있는 위치와 시간에 동생이 도달했다면 depth 출력
            if (visited[m][depth%2]){
                System.out.println(depth);
                return;
            }

            // 시간을 흐르게 만들고 동생을 먼저 움직인다.
            depth++;
            m += depth;

            // 레벨 탐색
            int flag = depth%2; // 짝수를 확인할지 홀수를 확인할지 결정
            int qSize = q.size();
            for (int i = 0; i<qSize; i++) {
                int current = q.poll();

                // 다음 시간에 갈 수 잇는 곳을 탐색하는데
                for (int search: new int[]{current+1, current-1, current*2}) {
                    // 탐색 위치가 범위를 벗어나거나 이미 방문했다면 생략하고
                    if (search < 0 || search > 500000 || visited[search][flag])
                        continue;

                    // 그렇지 않으면 방문처리를 하고 큐에 넣는다.
                    visited[search][flag] = true;
                    q.add(search);
                }
            }
        }

        // 만나지 못하는 경우
        System.out.println(-1);
    }
}
