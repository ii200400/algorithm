// 문제 링크 : https://www.acmicpc.net/problem/13023
// 제출 공유 링크 : http://boj.kr/f858dd85a0214e2090f2de09875f77e8

// 처음에는 무슨 의미인지 지문을 이해 못했었는데,
// 단순히 dfs를 실행하면서 깊이가 5인 경우가 있는지 물어보는 것이었다.
// 그래서 인접 리스트를 사용해서 사람 관계를 표현하고 dfs로 깊이가 5가 되는지 살펴보았다.

// 그런데 이게 왜 골드?

package com.baekjoon.problem.java13023;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<Integer>[] friends;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 사람 수
        int m = sc.nextInt();   // 친구 관계 수
        friends = new ArrayList[n]; // 사람 i의 친구 리스트 (인접리스트)
        visited = new boolean[n];   // 사람 i의 방문 여부 배열

        // 각 사람들의 친구관계 초기화
        for (int i = 0; i<n; i++){
            friends[i] = new ArrayList<>();
        }
        for (int i = 0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            friends[from].add(to);
            friends[to].add(from);
        }

        // 각 사람들을 시작점으로 
        for (int i = 0; i<n; i++) {
            visited[i] = true;  // 방문 배열을 조작하고
            
            // 친구의 친구의.. 가 5번 반복되는지(깊이가 5인지) 확인한다.
            if (dfs(1, i)) {
                // 위의 관계가 존재한다면 1을 출력하고 끝
                System.out.println(1);
                return;
            }
            visited[i] = false; // 백트래킹
        }

        // 없다면 0을 출력하고 끝
        System.out.println(0);
    }

    /** 말 그대로 dfs, 깊이가 5인 관계가 있다면 true를 반환하는 특징이 있다.
     cnt : 깊이
     personNo : 사람 인덱스
     */
    static boolean dfs(int cnt, int personNo){
        int size = friends[personNo].size();    // 매개변수로 들어온 사람의 친구 수

        // 각 친구들을 살펴보는데
        for (int i = 0; i<size; i++){
            // 한 친구가
            int friend = friends[personNo].get(i);
            // 이미 방문했던 사람이라면 패스
            if (visited[friend])
                continue;

            // 그렇지 않다면 방문 기록을 하고
            visited[friend] = true;

            if (cnt == 4){  // 만일 깊이 5가 되었다면 true를 반환하고
                return true;
            }else { // 아니라면 작업을 이어나간다.
                if (dfs(cnt + 1, friend))
                    return true;
            }

            // 백트래킹
            visited[friend] = false;
        }

        // 더이상 친구 없..
        return false;
    }
}
