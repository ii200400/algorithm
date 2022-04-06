// 문제 링크 : https://www.acmicpc.net/problem/17471
// 제출 공유 링크 : http://boj.kr/1083e36873e9450087eb0ce81ad49257
// 백준 게리맨더링

// 게리맨더링이 뭘까..? 검색으로 알게된 내용은 다음과 같다.
// 게리맨더링(gerrymandering)이란 특정 후보자나 특정 정당에 유리하도록 선거구를 획정하는 것을 말한다.
// 지시기 느렀다!

// 이걸.. 어떻게 풀어야 하나.. 고민하다가 구역이 최대 10개 밖에 없는 것을 늦게 봤다.
// 부분 집합으로 두 선거구로 나누고 한 선거구에서 dfs, 다른 선거구에서 dfs해서
// 탐색되는 선거구 총 합이 구역수와 같으면 정답이 될 수 있는 경우로 판단하고 적절하게 저장하면 될 것 같다.

// 아니.. 시간초과날줄 알고 쫄아있었는데 84ms 라니요; 내 긴장감 돌려줘요!

package com.baekjoon.problem.java17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;   // 구역의 수
    static int answer;  // 정답 변수
    static boolean[] election1; // 두 선거구중 1번이면 true 2번이면 false
    static int[][] adjList; // 인접리스트
    static int[] peopleNum; // 각 구역의 사람 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 구역의 수
        peopleNum = new int[n+1]; // 각 구역의 사람 수, 편의상 크기 +1
        adjList = new int[n+1][]; // 배열로 구현하긴 했는데 인접리스트 맞다.

        // 각 구역의 사람 수 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++){
            peopleNum[i] = Integer.parseInt(st.nextToken());
        }
        
        // 인접 리스트 초기화
        for (int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            adjList[i] = new int[num];
            for (int j = 0; j < num; j++) {
                adjList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 부분집합으로 두 선거구로 나누기
        election1 = new boolean[n+1]; // idx 구역이 두 선거구중 1번이면 true 2번이면 false, 편의상 크기 +1
        answer = Integer.MAX_VALUE;
        
        // 구역하나는 정하고 시작한다. (0구역구는 없고 1은 항상 false로 하면 2로 시작해야한다.)
        // 구역을 (1,2,3) (4,5,6)으로 나누나 (4,5,6) (1,2,3)으로 나누나 인구 차이는 같기 때문
        subseq(2);

        // 두 선거구의 인구 차이의 최솟값을 출력
        System.out.println(answer == Integer.MAX_VALUE? -1:answer);
    }

    // 첫번째는 무조건 2번 구역만 n개가 되도록 만들었는데 그것을 처리하는 flag 변수
    static boolean flag = true;
    
    // 부분수열을 만드는 함수
    static void subseq(int cnt){
        if (cnt == n+1){
            if (flag) {
                flag = false;
                return;
            }

            // 두 선거구를 나누는 방법이 가능한 방법이라면
            if (isValid()){
                int point1 = 0;
                int point2 = 0;
                for (int i = 1; i<=n; i++){
                    if (election1[i])
                        point1 += peopleNum[i];
                    else
                        point2 += peopleNum[i];
                }

//                System.out.println(Arrays.toString(election1));
//                System.out.println(point1);
//                System.out.println(point2);
                // 두 지역구의 차이를 확인하고 정답을 적절하게 저장한다.
                answer = Math.min(answer, Math.abs(point1-point2));
            }
            return;
        }

        // 현재 지역을 선거구 2로 진행해보고
        election1[cnt] = false;
        subseq(cnt+1);
        // 선거구 1로도 설정하고 진행해본다.
        election1[cnt] = true;
        subseq(cnt+1);
    }

    // 두 선거구를 나누는 방법이 가능한지 판별하는 함수
    static boolean isValid(){
        areaCnt = 1;

        // 첫번째 지역은 무조건 선거구2이다.
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, false, visited);

        // 선거구 1인 지역이 탐색되면 dfs를 진행한다.
        for (int i = 2; i<=n; i++){
            if (election1[i]) {
                visited[i] = true;
                areaCnt++;
                dfs(i, true, visited);
                break;
            }
        }

        return areaCnt == n;
    }

    static int areaCnt; // 두 선거구별로 하나씩 지역을 선별해 dfs를 진행했을 때 탐색한 지역 수
    // 선거구 한 곳에서 dfs를 사용했을 때
    static void dfs(int area, boolean isElection1, boolean[] visited){
        int len = adjList[area].length;
        for (int i = 0; i<len; i++){
            int near = adjList[area][i]; // 인접한 지역
            
            // 이미 방문했거나 같은 지역구가 아니면 패스
            if (visited[near] || election1[near] != isElection1)
                continue;
            
            visited[near] = true;
            dfs(near, isElection1, visited);
            areaCnt++;
        }
    }
}
