// 문제 링크 : https://www.acmicpc.net/problem/2110
// 제출 공유 링크 : http://boj.kr/790f6fcffd7c4ff2b25895428fdba2e8

// 공유기 위치 범위가 엄청 넓다, 조합쓰면 또 무조건 시간초과이고.. 이것도 이분탐색 문제같다.

package com.baekjoon.problem.java2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 두 공유기 사이의 최대 거리를 이분탐색으로 탐색한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);  // 집의 개수
        int c = Integer.parseInt(temp[1]);  // 공유기 개수
        long[] houseArray = new long[n];  // 집 위치 배열

        // 집 위치 배열 초기화
        long end = 0;    // 불가능한 공유기 사이 최대 거리 (가장 큰 집 좌표로 초기화)
        for (int i = 0; i<n; i++){
            houseArray[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, houseArray[i]);
        }

        // 정렬을 해야 인접한 집끼리 탐색이 가능하므로
        Arrays.sort(houseArray);

        // 이분탐색 시작
        long start = 1; // 가능한 공유기 사이 최대 거리
        while(start+1 != end){
            long mid = (start+end)/2; // 중간값 탐색
            long routerPos = houseArray[0];  // 최근에 설치한 공유기 위치 (서로 가장 멀리 설치하려면 첫번째는 무조건 설치한다.)
            int routerNum = c-1;    // 설치 가능한 공유기 수

            // mid 만큼의 거리가 있다면 공유기를 배치해본다.
            for (int i = 1; i<n && routerNum > 0; i++){
                // 공유기 설치가 가능하다면 설치한다.
                if (houseArray[i] - routerPos >= mid){
                    routerPos = houseArray[i];
                    routerNum--;
                }
            }
            
            // 모든 공유기를 설치했다면
            if (routerNum == 0){
                // start에 mid를 저장하고
                start = mid;
            }else{
                // 그렇지 않으면 end에 저장한다.
                end = mid;
            }
        }

        System.out.println(start);
    }
}
