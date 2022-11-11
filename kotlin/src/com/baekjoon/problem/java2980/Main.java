// 문제 링크 : https://www.acmicpc.net/problem/2980
// 제출 공유 링크 : http://boj.kr/4b1e3d36de4f4c2598e10bdc6a991823
// 백준 도로와 신호등

// 그냥.. 길가고, 멈추는 수식만 고려해서 더해주면 될 것 같다.

package com.baekjoon.problem.java2980;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 신호등의 개수
        int l = sc.nextInt();   // 도로 길이
        int[][] lights = new int[n][3]; // 신호등 정보

        for (int i = 0; i<n; i++){
            lights[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }
        
        int dis = 0;     // 이동 거리
        int time = 0;    // 걸린 시간
        for (int i = 0; i<n; i++){
            // 다음 신호등까지 이동
            time += lights[i][0] - dis;
            dis = lights[i][0];

            // 초록불이 될때까지 대기
            int mod = time % (lights[i][1]+lights[i][2]);
            if (mod < lights[i][1])
                time += lights[i][1] - mod;
        }

        // 걸린 시간에 남은 이동거리를 더해서 출력
        System.out.println(time+(l-dis));
    }
}
