// 문제 링크 : https://www.acmicpc.net/problem/1654
// 제출 공유 링크(스트림 사용) : http://boj.kr/78e94eedec2d4638911a0bc145014a75
// 제출 공유 링크 : http://boj.kr/b1d9ab141e16457088df79299d634fa6

// 문제 읽자마자 이진탐색 생각나서 바로 이진탐색 구현을 시작한다.
// 그런데 구현한지 엄청 오래 지났는데 만들 수 있을지 잘 모르겠다..

// 이분탐색이 아니라 문제를 잘 안읽어서 오버플로우 확인이 더 늦었다;;

package com.baekjoon.problem.java1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 자바에서는 동시 초기화 방법이 없나? 검색해도 안 나오는 것을 보아 없다..
        // 입력
        String[] temp = br.readLine().split(" ");
        int k = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);

        // 케이블 입력
        long[] cables = new long[k]; // 39번째 줄 때문에 long
        for (int i = 0; i<k; i++){
            cables[i] = Integer.parseInt(br.readLine());
        }

        // 이분탐색 초기화
        long bottom = 1; // 해당 길이 이하로 잘랐을 때 n개 이상
        long top = Arrays.stream(cables).max().getAsLong()+1L; // 해당 길이 이상으로 잘랐을 때 n개 미만 (Int 범위 넘음)
        while(bottom+1 != top){
            // 중간값을 구하고 이 길이로 잘랐을 때
            long mid = (bottom+top)/ 2L;
            // 구할 수 있는 랜선의 갯수를 구한다.
//            long cableNum = 0;
//            for (int cable : cables) {
//                cableNum += cable/mid;
//            }
            long cableNum = Arrays.stream(cables).map( num ->  num/mid).sum();

//            System.out.println(mid+" "+cableNum);

            if (cableNum >= n)
                // n개 이상의 랜선을 구할 수 있는 길이라면 bottom에
                bottom = mid;
            else
                // 그렇지 않다면 top에 저장한다.
                top = mid;
        }

        // 마지막에 가지고 있는 bottom 값이 가장 긴 랜선 길이이다.
        System.out.println(bottom);
    }
}
