// 문제 링크 : https://www.acmicpc.net/problem/1967
// 제출 공유 링크 : http://boj.kr/4eb3391432d1412b976a49c27a088440
// 백준 트리의 지름

// 학교 강의에서 들었던 내용과 완전히 같다.
// MST인 그래프에서 가장 거리가 먼 두 노드는 무엇인가? 라는 내용이었는데 여기에 적용해도 될 것 같다.
// 기억상.. 노드 하나 잡고 해당 노드에서 가장 먼 노드까지 거리 + 앞에서 선택한 노드에서 또다시 가장 먼 노드까지 거리
// 음.. 그러면.. 뭐였지.. 다익스트라였나? 2번 사용하면 된다.

// 지문이 좀 햇갈리게 적혀있는데 부모 노드가 작은 순서대로 입력이 주어진다는 것이지
// 부모노드가 자식노드보다 무조건 작은 수라는 내용이 없다. 고려해서 코딩해야겠다.

// 시간복잡도는.. O(V)이다. 간선이 2(V-1)개여서 그렇다. (양방향 그래프)

package com.baekjoon.problem.java1967;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<int[]>[] adjList;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 노드의 수
        adjList = new ArrayList[n+1];    // 인접리스트

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        // 트리의 간선 수는 노드의 수 - 1
        for (int i = 0; i<n-1; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            
            adjList[from].add(new int[] {to, weight});
            adjList[to].add(new int[] {from, weight});
        }

        // 다익스트라 2번을 사용하여 가장 거리가 먼 두 노드를 구한다.
        int[] result1 = dijkstra(1);    // 1은 그냥 임의의 노드 번호
        int[] result2 = dijkstra(result1[0]);

        // 두 노드 사이의 거리 출력
        System.out.println(result2[1]);
    }

    // 생각해보니까.. 트리는 특정 노드까지의 경로가 항상 하나여서
    // 우선순위 큐를 사용할 필요가.. 없다..?
    // 특정 노드를 주면 [해당 노드에서 가장 먼 노드, 그 거리]를 반환해준다.
    static int[] dijkstra(int num){
        boolean[] visited = new boolean[n+1]; // 각 노드 방문 배열
        visited[num] = true;    // 방문 여부
        int[] farNode = new int[] {num, 0};   // 함수의 반환값
        
        // 우선순위 큐가 필요없어서 대신 큐를 사용
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {num, 0});  // 큐 초기화

        // 큐에 값이 없을 때 까지 반복
        while (!q.isEmpty()){
            int[] current = q.poll();
            int idx = current[0];
            int weight = current[1];

            // 노드와 연결된 다른 모든 노드를 탐색
            for (int[] link: adjList[idx]){
                int nNode = link[0];
                int nWeight = link[1];
                
                // 방문한 경험이 있다면 패스
                if (visited[nNode])
                    continue;

                // 방문 체크를 하고 큐에 추가한다.
                visited[nNode] = true;
                int[] data = new int[] {nNode, weight+nWeight};
                q.add(data);

                // 현재 방문한 곳의 거리가 가장 멀다면 반환값에 저장
                if (data[1] > farNode[1]){
                    farNode = data;
                }
            }
        }

        // 가장 거리가 먼 노드 정보 반환
        return farNode;
    }
}
