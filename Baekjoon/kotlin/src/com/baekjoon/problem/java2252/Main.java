// 문제 링크 : https://www.acmicpc.net/problem/2252
// 제출 공유 링크 : http://boj.kr/2605c6f9981a4c81be3e4bd4a4089378
// 백준 줄 세우기

// 어휴.. 교수님이 풀어주기 직전에 풀었다;;
// n이 3만이 아니라 3천인줄 알고 그냥 인접행렬로 풀었다가 메모리 초과 뜨고 인접 리스트로 바꾸었다.. 하핳;
// 위상정렬이라는.. 사실은 그래프 탐색에 조건이 들어간 것이면서 정렬인 것 같이 이름이 붙여진 알고리즘이다.

// 본인의 경우 방문배열과 진입차수을 활용해서 초기에 dfs를 시작할 정점을 골랐는데
// 교수님의 경우 큐를 활용하셔서 큐를 사용한 방법도 해보려고 한다.

// 보니 dfs보다는 큐를 사용한 bfs가 빠르고(재귀호출 때문인듯하다) 둘 모두 위상정렬에 쓰일 수 있다는 것을 알 수 있었다.
// method1은 dfs에 방문체크 배열 활용
// method2는 dfs에 큐 사용
// method3은 bfs 사용

package com.baekjoon.problem.java2252;

import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] adjList;
    static int[] inDegree;
    static boolean[] canVisite;

    public static void main(String[] args) {
//        method1();
//        method2();
        method3();
    }

    static void method1(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 사람 수
        int m = sc.nextInt();   // 키를 비교한 회수
        adjList = new ArrayList[n+1]; // 인접리스트
        inDegree = new int[n+1];    // 해당 사람보다 큰 사람의 수
        canVisite = new boolean[n+1];   // 방문 가능 여부
        Arrays.fill(canVisite, true);

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }

        // inDegree 초기화
        for (int i = 0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            adjList[from].add(to);
            inDegree[to]++;
            canVisite[to] = false;
        }

        // 정점별로 dfs를 진행해본다.
        for (int i = 1; i<=n; i++){
            // 방문이 불가능하거나 진입차수(inDegree)가 1이상이라면 생략
            if (!canVisite[i] || inDegree[i] >= 1)
                continue;

            dfs(i);
        }
    }

    static void dfs(int num){
        // 해당 사람에 해당하는 숫자를 출력한다.
        System.out.print(num + " ");
        for (int i = 0; i<adjList[num].size(); i++){
            // 키가 더 큰 사람의 진입차수를 - 뺀 값이 0일 때 dfs 이어서 진행
            if (--inDegree[adjList[num].get(i)] == 0)
                dfs(adjList[num].get(i));
        }
    }

    static void method2(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 사람 수
        int m = sc.nextInt();   // 키를 비교한 회수
        adjList = new ArrayList[n+1]; // 인접리스트
        inDegree = new int[n+1];    // 해당 사람보다 큰 사람의 수

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }

        // inDegree 초기화
        for (int i = 0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            adjList[from].add(to);
            inDegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();   // 차수가 0인 사람들
        for (int i = 1; i<=n; i++){
            if (inDegree[i] == 0) q.add(i);
        }

        // 정점별로 dfs를 진행해본다.
        for (int num: q){
            // 방문이 불가능하거나 진입차수(inDegree)가 1이상이라면 생략
            if (inDegree[num] >= 1)
                continue;

            dfs(num);
        }
    }

    // 교수님이 작성하신 것
    // 사이클이 있다면 출력하지 않고 없다면 그대로 방문 순서를 출력하는 코드도 있다.
    static void method3(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        //인접리스트
        ArrayList<Integer>[] list = new ArrayList[ N+1 ];
        for(int i = 0; i <=N ; i++) {
            list[i] = new ArrayList<>();
        }

        //위상정렬
        //1. 진입차수를 관리할 1차원 배열이 필요하다(정점의 개수만큼)
        int[] inD = new int[N+1]; //초기값 0
        //입력
        int x, y;
        for(int i = 0; i < M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            list[x].add(y);
//        2. 입력받은면수 진입차수 배열에 진입차수를 누적한다.    
            inD[y]++;
        }

//        3. 큐에 진입차수가 0인 것을 모두 삽입니다.
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++) {
            if(inD[i] == 0) {
                q.offer(i);
            }
        }
//        큐 사이즈가 0이면 위상정렬불가
        if(q.size() == 0) {
            return;
        }

//        4. 큐사이즈가 빌때까지 자신과 연결된 정점의 진입차수를 1씩 감소한다.
//              감소된 진입차수가 0인 정점은 큐에 삽입한다.

        ArrayList<Integer> res = new ArrayList<>(); // 방문 순서
        Integer cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            //자신의 할 일 구현
            res.add(cur);
//            자신과 연결된 정점의 진입차수를 1씩 감소한다.
            for(int i = 0; i < list[cur].size(); i++) {
                int idx = list[cur].get(i);
                inD[idx]--;
//                 감소된 진입차수가 0인 정점은 큐에 삽입한다.
                if(inD[idx] == 0) {
                    q.offer(idx);
                }
            }

        }

//        사이클 존재여부판단
        if(res.size() != N) {
            return;
        }

        for(int idx : res) {
            System.out.print(idx + " ");
        }
        System.out.println();
    }
}
