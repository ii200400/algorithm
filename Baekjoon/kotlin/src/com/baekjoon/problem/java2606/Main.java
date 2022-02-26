// 문제 링크 : https://www.acmicpc.net/problem/2606
// 제출 공유 링크 : http://boj.kr/4587252d2d944d508c01cd6c10201edb

// 평소에 인접행렬을 이용하기도 했고 해당문제는 대놓고 인접리스트를 사용하는 것이 좋다는 느낌이라서
// 인접리스트를 활용하여 해결하려고 한다.

// 그냥 무난하게 통과하였다.

package com.baekjoon.problem.java2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computerNum = sc.nextInt(); // 컴퓨터의 수
        int linkNum = sc.nextInt();     // 간선의 수

        // 컴퓨터 수 만큼 링크드 리스트 배열을 만든다.
        // 입력이 1~computerNum 으로 들어오기 때문에 편의를 위해서 인덱스 0은 생략한다.
        LinkedList<Integer>[] adjList = new LinkedList[computerNum+1];   // 인접리스트
        // 인접 리스트 초기화
        for (int i = 1; i<=computerNum; i++){
            adjList[i] = new LinkedList<>();
        }
        for (int i = 0; i<linkNum; i++){
            int com1 = sc.nextInt();
            int com2 = sc.nextInt();

            // 무향 그래프이기 때문에 양쪽에 모두 넣어준다.
            adjList[com1].add(com2);
            adjList[com2].add(com1);
        }
        
        // bfs를 활용하여 바이러스에 걸리는 컴퓨터를 확인한다.
        // 음.. 뭔가 이중 링크드 리스트가 되어버렸다.. 의도한 것은 아닌디..
        Queue<LinkedList<Integer>> queue = new LinkedList<>();

        // 1번 컴퓨터가 바이러스에 걸리기 때문에 큐에 넣고
        queue.add(adjList[1]);
        // 인접리스트에서 해당 컴퓨터의 정보를 지운다.
        adjList[1] = null;

        // 큐를 사용해서 바이러스에 걸리는 컴퓨터를 탐색한다.
        int answer = 0;
        while(!queue.isEmpty()){
            LinkedList<Integer> computerLinks = queue.poll();
            for (int computer: computerLinks){
                // 이미 바이러스에 걸린 컴퓨터인 것을 알고 있다면 생략
                if (adjList[computer] == null)
                    continue;

                // 바이러스에 걸린 컴퓨터를 확인하면
                // 큐에 해당 컴퓨터의 링크 정보를 넣어주고
                queue.add(adjList[computer]);
                // 인접리스트에서 해당 컴퓨터의 정보를 지운다.
                adjList[computer] = null;

                // 카운트를 한번하고 다른 컴퓨터를 찾아간다.
                answer++;
            }
        }

        // 1번 컴퓨터로 인해서 바이러스에 걸리는 컴퓨터의 수 출력
        System.out.println(answer);
    }
}
