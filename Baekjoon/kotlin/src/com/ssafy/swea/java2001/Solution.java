// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq

package com.ssafy.swea.java2001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mapSize = Integer.parseInt(st.nextToken()), netSize = Integer.parseInt(st.nextToken());
            int[][] map = new int[mapSize][mapSize];
            for(int i = 0; i<mapSize; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<mapSize; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//			System.out.printf(Arrays.deepToString(map));

            // 각 위치마다
            int max = 0;
            for(int i = 0; i<mapSize-netSize+1; i++) {
                for(int j = 0; j<mapSize-netSize+1; j++) {

                    // 파리채 범위 내의 수를 더한다.
                    int sum = 0;
                    for(int k = 0; k<netSize; k++) {
                        for(int l = 0; l<netSize; l++) {
                            sum += map[i+k][j+l];
                        }
                    }

                    // 범위 내의 수가 지금까지 탐색한 수 보다 크면 저장한다.
                    max = Math.max(max, sum);
                }
            }

            // 최대한 많은 파리를 죽이는 수 출력
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}
