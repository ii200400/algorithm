// 문제 링크 : https://www.acmicpc.net/problem/12851
// 제출 공유 링크 : http://boj.kr/d7978bb8c4a1490e82ebedaf2a9d6e4c
// 교수님이 추천해주신 기초문제 풀이 중 숨바꼭질 시리즈 풀이 중

// 문제가.. dp같..았는데 또 bfs이다.
// 어.. 메모이제이션에 bfs같은 탐색..? 아 몰랑;;

package com.baekjoon.problem.java12851;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수빈 위치
        int m = sc.nextInt();   // 동생 위치
        // [0~100000][m에서 해당 인덱스로 가는데 거리, 경우의 수]
        int[][] ways = new int[100001][2];   // 가장 빠른 시간으로 각 위치까지의 경우의 수

        // int 배열이 0으로 초기화 되는데 이것을 사용하여 방문배열에 사용할 것이라 임의로 0보다 큰 값으로 초기화
        ways[n] = new int[]{1, 1};  // 현 위치 초기화

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        // bfs시작
        int depth = 1;
        while (!q.isEmpty() && ways[m][0] == 0) {   // 동생 위치로 가는 경우의 수가 있다면 탈출
            int size = q.size();
            depth++;

            // 레벨 탐색
            for (int i = 0; i<size; i++) {
                int current = q.poll();

                // 현 위치에서 갈 수 있는 다른 위치를 탐색한다.
                for (int search: new int[]{current+1, current-1, current*2}){
                    // 탐색 위치가 범위를 벗어나면 생략한다.
                    if (search < 0 || search > 100000)
                        continue;

                    // 방문 경험이 없거나 depth가 같다면
                    // 현 위치의 경우의 수만큼 탐색 위치의 경우의 수에 더해준다.
                    if(ways[search][0] == 0){
                        // 방문 경험이 없는 경우에는 큐에 탐색 위치를 추가하고 시간 기록(방문 채크)를 한다.
                        ways[search][0] = depth;
                        ways[search][1] += ways[current][1];
                        q.add(search);
                    }else if(ways[search][0] == depth) {
                        // 방문 경험이 있는데 깊이가 같은 경우에는 경우의 수를 더해준다.
                        ways[search][1] += ways[current][1];
                    }
                }
            }
        }

        // 동생 위치로 가는 최소 시간과 모든 경우의 수 출력
        System.out.println(ways[m][0]-1);
        System.out.println(ways[m][1]);
    }
}
