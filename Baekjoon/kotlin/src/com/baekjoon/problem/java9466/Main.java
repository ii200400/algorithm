// 문제 링크 : https://www.acmicpc.net/problem/9466
// 제출 공유 링크 : http://boj.kr/6cec583eaa5e4dc3991778ffac5a4d90
// 백준 텀 프로젝트

// 서로소 집합으로 원래 숫자로 돌아오는 사이클이 생기는지 확인하는 알고리즘을 만들면 될 것 같다.
// .. 어.. 예전에 위처럼 만든적이 있어서 위와 같이 만드려고 한 것인데
// 그것은 사이클이 하나였을 때인 것 같다,
// 사이클이 여러 개가 있으면 판단하기 힘들다고 생각해서 위상정렬로 사이클을 판단하겠다.

// 음! 위상정렬로 만드니 잘 해결되었다!
// 시간복잡도는.. O(V+E)... 보다 작은 것 같다. 사이클이 많을 수록 탐색하지 않는 노드와 간선이 증가하지 때문

package com.baekjoon.problem.java9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] disjoint, inDegree;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        // 테스트 케이스 마다 반복
        for (int testCase = 1; testCase<=t; testCase++){
            int n = Integer.parseInt(br.readLine());    // 학생 수
            disjoint = new int[n+1];    // 각 학생별로 선택한 다른 학생
            inDegree = new int[n+1];  // 진입 차수
            cnt = 0;    // 사이클에 `없는` 학생 수

            // 서로소 집합 초기화
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++){
                int num = Integer.parseInt(st.nextToken());
                disjoint[i] = num;
                inDegree[num]++;
            }

            // 큐 초기화
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i<=n; i++){
                // 진입차수가 0인 것만 넣어준다.
                if(inDegree[i] == 0){
                    q.add(i);
                    cnt++;
                }
            }

//            System.out.println(Arrays.toString(inDegree));

            // 위상정렬 진행
            while (!q.isEmpty()){
                int current = q.poll();
                
                // 현재 학생이 같이 하길 원하는 학생의 진입 차수가 0이면 큐에 추가
                if (--inDegree[disjoint[current]] == 0) {
                    q.add(disjoint[current]);
                    cnt++;
                }
            }

            // 사이클이 일어나지 않는 학생 출력
            System.out.println(cnt);
        }
    }
}
