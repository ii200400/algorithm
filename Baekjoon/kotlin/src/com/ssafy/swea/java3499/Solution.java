// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW

package com.ssafy.swea.java3499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 수마다 반복
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 초기화
            br.readLine(); // 카드 수 생략
            String[] cards = "asdf".split(" "); // 카드 배열
            int secondCardSetIdx = (cards.length+1)/2; // 두번째 카드 세트의 시작 인덱스

            // 출력
            wr.write("#" + test_case + " ");

            // 셔플한 것 처럼 출력 (실재로 셔플은 안함)
            for (int i = 0; i<cards.length/2; i++)
                wr.write(cards[i] + " " + cards[secondCardSetIdx+i] + " ");

            // 홀수인 경우 먼저 놓는 쪽에 한 장이 더 들어가게 해야 하므로
            if (cards.length%2 == 1)
                wr.write(cards[cards.length/2]);

            wr.newLine();
        }

        wr.flush();
        wr.close();
        br.close();
    }
}

