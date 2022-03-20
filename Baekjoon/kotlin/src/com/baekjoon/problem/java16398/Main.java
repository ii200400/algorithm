// 문제 링크 : https://www.acmicpc.net/problem/16398
// 제출 공유 링크 : http://boj.kr/0a6143d86d0c415db6079385bcaf8543

// 프림.. 알고리즘 써서 빨리 끝내려고 하는데.. 시간초과가 안나나..?

// 아하 안나는 구나.

package com.baekjoon.problem.java16398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] disjoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 행성 수
        // 가중치(세번째 값) 기준으로 정렬하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        disjoint = new int[n];  // 서로소 집합

        // 초기화
        StringTokenizer st;
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            disjoint[i] = i;    // 서로소 집합 초기화

            // 우선순위 큐 초기화 (i->j나 j->i나 같으니 하나만 넣어준다.)
            int j;
            for (j = 0; j<i+1; j++){
                st.nextToken();
            }
            for (; j<n; j++){
                pq.add(new int[]{i, j, Integer.parseInt(st.nextToken())});
            }
        }

        long cost = 0;  // 행성 연결 총 비용
        int cnt = 0;    // 행성 연결 회수
        while(cnt != n-1){  // n-1번 연결하면 모든 행성을 연결하는 것이므로
            // 가장 가중치가 낮은 플로우를
            int[] flow = pq.poll();
            
            // 서로소 집합을 활용하여 설치하는 것이 좋은지 확인하고 설치를 하던가 말던가 한다.
            if (union(flow[0], flow[1])){
                cost += flow[2];
                cnt++;
            }
        }

        // 총 비용 출력
        System.out.println(cost);
    }

    // 두 서로소 집합을 합친다.
    // 이미 같은 집합이면 false를 아니면 두 집합을 합치고 true를 반환한다.
    static boolean union(int a, int b){
        if (findRoot(a) == findRoot(b)){
            return false;
        }

        disjoint[findRoot(b)] = findRoot(a);
        return true;
    }

    // 서로소 집합의 root를 찾는다. (comp.. 어쩌구 적용)
    static int findRoot(int num){
        if (disjoint[num] == num){
            return num;
        }

        return disjoint[num] = findRoot(disjoint[num]);
    }
}
