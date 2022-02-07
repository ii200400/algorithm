// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB

package com.ssafy.swea.java2805;

import java.util.Scanner;

// 재귀함수로 풀라는 줄 알고 오해했다..

public class Solution {
    static int limit = 0;
    static int solution(int[][] map, int r, int c, int count) {
        int sum = (map[r][c] != -1)? map[r][c] : 0;
        map[r][c] = -1; // 농작물을 수확했다는 표현 (더 이상 수확할 필요가 없음!)

        if (count == limit) { // 더이상 멀어질 수 없다면 반환
            return sum;
        }

        sum += solution(map, r+1, c, count+1);
        sum += solution(map, r-1, c, count+1);
        sum += solution(map, r, c+1, count+1);
        sum += solution(map, r, c-1, count+1);
        return sum;
    }

    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int size = sc.nextInt();

            // 농작물 입력
            int[][] map = new int[size][size];
            for(int r = 0; r<size; r++) {
                String s = sc.next();
                for (int c = 0; c<size; c++) {
                    map[r][c] = s.charAt(c) - '0';
                }
            }

//			===================================================
//			재귀로 만들었지만 너무 느리다. 진짜 재귀 문제가 맞는지도 잘 모르겠다.
//
//			// 중앙에서 최대로 멀어질 수 있는 거리
//			limit = (size)/2;
//			int result = solution(map, limit, limit, 0);
//
//			System.out.printf("#%d %d\n", test_case, result);
//			===================================================

//			역시 별찍기가 짱이다!

            int sum = 0;
            int half = size/2;
            for(int i = 0; i<size; i++) {
                int j;
                int go = Math.max(half-i, i-half);
                for(j = 0; j<go; j++) {}// go번 수확 생략

                go = Math.min(2*i+1, 2*(size-i)-1);
                for(int k = 0; k<go; k++, j++) { // go번 수확!
                    sum += map[i][j];
                }
            }

            System.out.printf("#%d %d\n", test_case, sum);
        }
    }
}

