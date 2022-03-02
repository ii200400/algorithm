// 문제 링크 : https://www.acmicpc.net/problem/9372
// 제출 공유 링크 : http://boj.kr/0857f090012d4a75837832c52ceef4da

// 아무리봐도 bfs이긴한데.. 방문탐색이 없어야 하는 bfs같다..?
// 아.. 비행기 회수가 아니라 종류이구나;;
// 연결 그래프이고.. 모든 국가를 방문하고.. 모든 간선의 비행기 종류가 다 다르다면.. 그냥;; n-1개의 종류 아닌가..???

// ..????????????? 맞네? 이왜맞..??

package com.baekjoon.problem.java9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase<t; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int i = 0; i<m; i++){
                br.readLine();
            }

            // 설명은.. 위를 보자;;
            System.out.println(n-1);
        }
    }
}
