// 문제 링크 : https://www.acmicpc.net/problem/9205
// 제출 공유 링크 : http://boj.kr/0287b2a1b1d44be9a6c0100dcbc310c4
// 백준 맥주 마시면서 걸어가기

// 아니.. 50미터에  1병? 사람인가?
// 음.. 각.. 정점별로 거리를 구하고, 갈 수 있는 위치로 방문체크를 하면서.. dfs로 진행해도 되..나?
// 아.. 편의점 나간 직후에 맥주 마신다는 지문을 늦게봐서 계산식들이.. 쥬륵..

// 아.. 저번에 파이프? 빵집? 문제랑 같이 방문처리에 백트래킹을 하면 안되는 문제였다;;
// 그때는 그림이 있어서 이해가 빨랐는데 이번에는 글만 있다보니 생각을 못한것 같다. 이뤈..
// 백트래킹을 하지 않는 이유는 한번 지나간 편의점을 통해서 페스티벌에 도달하지 못했다면
// 당연히 다음번에도 해당 편의점을 통해서 페스티벌에 못 도달하기 때문, 미로에서 막힌 길 다시 안가는 것과 같다.

package com.baekjoon.problem.java9205;

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] locations;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for (int t = 0; t<testcase; t++){
            n = sc.nextInt();   // 편의점 개수
            locations = new int[n+2][2]; // 집, 편의점, 페스티벌 위치들 (집은 0, 페스티벌은 n+1, 나머지는 편의점 위치이다.)
            visited = new boolean[n+2]; // 방문배열
            visited[0] = true;

            // 위치 배열 초기화
            for (int i = 0; i<n+2; i++){
                locations[i] = new int[]{sc.nextInt(), sc.nextInt()};
            }

            if(dfs(0)){
                // 페스티벌에 맥주를 마시며 도달이 가능한 경우
                System.out.println("happy");
            }else{
                // 불가능한 경우
                System.out.println("sad");
            }
        }
    }

    static boolean dfs(int num){
        int r = locations[num][0];  // 현 가로 위치
        int c = locations[num][1];  // 현 세로 위치

        // 편의점과 페스티벌 장소를 보는데
        for (int i = 1; i<n+2; i++){
            // 거리를 보니
            int distance = Math.abs(r-locations[i][0])+Math.abs(c-locations[i][1]);

            // 이미 지나온 곳이거나 마시면서 도달할 수 없는 곳이라면 생략
            if (visited[i] || distance > 1000)
                continue;

            // 페스티벌 장소로 갈 수 있다면 true 반환
            if (i == n+1){
                return true;
            }

            // 편의점을 갈 수 있다면 방문처리하고 dfs 진행
            visited[i] = true;
            if(dfs(i)) return true;
        }

        return false;
    }
}
