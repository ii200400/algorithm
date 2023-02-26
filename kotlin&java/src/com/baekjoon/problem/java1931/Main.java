// 문제 링크 : https://www.acmicpc.net/problem/1931
// 제출 공유 링크 : http://boj.kr/9c5e70cc7094473c86c4f4915c96c32a

// 그.. 액티비젼.. 어쩌구 알고리즘 사용
// DP인줄 알았는데 탐욕법이었다니..;

// 알고보니 내가 사용한 방식은 DP가 맞고, 이것은 다른 알고리즘이다.
// 내가 사용했던 방법은 배열을 꼭 사용해야 하는데 해당 방법은 하지 않아도 되서 더 좋다.

package com.baekjoon.problem.java1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 총 회의 수
        int[][] meetings = new int[n][2];   // 회의 배열
        StringTokenizer st;
        // 회의 배열 초기화
        for (int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료 시간, 시작 시간 순으로 정렬을 진행한다.
        Arrays.sort(meetings, (o1, o2) -> (o1[1] - o2[1] != 0)? (o1[1] - o2[1]) : (o1[0]-o2[0]));

        int cnt = 0; // 진행된 회의 수
        int endTime = 0; // 현재까지 진행된 회의 중 가장 마지막에 끝난 회의 시간
        for (int[] meeting : meetings){
            // 회의 종료 시간 전에 회의를 시작할 수는 없으므로
            if (endTime > meeting[0]) continue;

            // 회의를 시작할 수 있는 상황이면
            // 진행된 회의 수를 +1 하고
            cnt++;
            // 회의가 끝난 시간을 저장한다.
            endTime = meeting[1];
        }

        // 결과적으로 회의가 몇 개나 진행되었는지 출력한다.
        System.out.println(cnt);
    }
}
