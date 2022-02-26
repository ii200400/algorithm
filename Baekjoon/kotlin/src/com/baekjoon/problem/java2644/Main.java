// 문제 링크 : https://www.acmicpc.net/problem/2644
// 제출 공유 링크 : http://boj.kr/70616841a85a425eb8cdbd2dabe812a3

// 서로소 집합으로 풀 수 있나? 싶었는데 아닌 것 같다.
// bfs로 풀겠다.

package com.baekjoon.problem.java2644;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 사람 수
        int p1 = sc.nextInt(), p2 = sc.nextInt();   // 촌수를 찾고자하는 두 사람
        ArrayList<Integer>[] adjList = new ArrayList[n+1];  // 인접 리스트 (입력이 1부터 주어지므로 +1)

        // 인접 리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = sc.nextInt(); i>0; i--){
            int from = sc.nextInt();
            int to = sc.nextInt();

            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 큐 초기화
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(adjList[p1]);
        adjList[p1] = null;

        // bfs 시작
        int depth = 0; // 촌수 계산
        boolean flag = false;   // 촌수 확인 여부
        work: while (!q.isEmpty()){
            depth++;

            int size = q.size();
            for (int i = 0; i<size; i++){
                ArrayList<Integer> adj = q.poll();

                // 1촌들을 둘러보면서
                for (int person: adj){
                    // 찾는 사람이 나타났다면
                    if (person == p2) {
                        // 촌수 확인 여부 true 후, work 반복문 탈출
                        flag = true;
                        break work;
                    }

                    // 방문하지 않은 사람이 있다면
                    if (adjList[person] != null){
                        // 큐에 넣고 인접리스트를 null로 바꿔준다.
                        q.add(adjList[person]);
                        adjList[person] = null;
                    }
                }
            }
        }

        // 촌수 출력
        System.out.println(flag? depth : -1);
    }
}
