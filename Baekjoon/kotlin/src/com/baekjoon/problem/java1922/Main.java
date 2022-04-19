// 문제 링크 : https://www.acmicpc.net/problem/1922
// 제출 공유 링크 : http://boj.kr/3c316c43f3cd4f2f81f198db31d47359
// 백준 네트워크 연결

// 누가봐도 최소 스패닝 트리;;
// 저번에 프림을 활용했으니 이번에는 크루스칼을 사용하겠다.

package com.baekjoon.problem.java1922;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] disjoint;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 컴퓨터의 수
        int m = sc.nextInt();   // 연결할 수 있는 선의 수
        disjoint = new int[n+1]; // 서로소 집합
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));    // 우선순위 큐

        // 서로소 집합 초기화
        for (int i = 1; i<=n; i++){
            disjoint[i] = i;
        }

        // 큐 초기화
        for (int i = 0; i<m; i++){
            pq.offer(new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        int cnt = 0;    // 선택한 간선 수
        int sum = 0;    // 총 비용
        while(cnt != n-1){
            int[] current = pq.poll();
            
            // 두 집합이 같은 집합이라면 간선 수 +1
            if (union(current[0], current[1])){
                cnt++;
                sum += current[2];
            }
        }

        // 총 비용 출력
        System.out.println(sum);
    }

    /**
     * 두 원소가 같은 집합에 있다면 false, 그렇지 않다면 집합을 합치고 true 반환
     * @param a 집합의 원소 1
     * @param b 집합의 원소 2
     */
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB){
            return false;
        }

        disjoint[rootB] = rootA;
        return true;
    }

    /**
     * 서로소 집합의 루트를 찾는 함수
     * @param num 루트를 찾고자 하는 숫자
     */
    static int find(int num){
        if (disjoint[num] == num){
            return num;
        }

        return disjoint[num] = find(disjoint[num]);
    }
}
