// 문제 링크 : https://www.acmicpc.net/problem/2798
// 제출 공유 링크 : http://boj.kr/c35d1dc92c564dfbae9be314a1aefa5d
// 범위가 작아 두 방법 모두 속도와 메모리가 비슷함

// 단순히.. 조합 문제 아닌가..?

// 재귀함수로 조합을 만들면 오히려 시간초과가 나는데..
// 그렇게.. 느린가..? 내가 잘못짰나?

// 아.. return을 써주는 것을 잊어서.. 시간초과 났었다..

package com.baekjoon.problem.java2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, max;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 카드 수
        m = Integer.parseInt(st.nextToken());   // 블랙잭 숫자
        max = 0;    // n개의 카드로 만들 수 있는 m보다 작은 최대값
        cards = new int[n]; // 카드 배열
        // 카드 배열 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 조합 시작 (방법 1)
        dfs(0, 0, 0);

        // 삼중 for문으로 3개의 카드를 선택하는 조합 구현 (방법 2)
//        int sum;
//        for (int i = 0; i<n-2; i++){
//            sum = cards[i];
//            for (int j = i+1; j<n-1; j++){
//                int tempSum = sum+cards[j];
//                for (int k = j+1; k<n; k++){
//                    // 모두 고른 값이 m보다 작으면서
//                    if (tempSum + cards[k] <= m){
//                        max = Math.max(max, tempSum + cards[k]);
//
//                        if (max == m){
//                            System.out.println(m);
//                            return;
//                        }
//                    }
//                }
//            }
//        }

        // n개의 카드로 만들 수 있는 m보다 작은 최대값 출력
        System.out.println(max);
    }

    // 가능한 여러 조합들의 합을 살펴보는 함수이다.
    static boolean dfs(int cnt, int idx, int sum){
        // 3개를 모두 고르면
        if(cnt == 3){
            // 총합을 적절히 저장하는데
            max = Math.max(max, sum);
            // 그 값이 m이라면 재귀 함수를 모두 탈출하고 아니면 다른 조합을 살펴본다.
            return max == m;
        }

        // 다음 수를 선택한다.
        for (int i = idx; i<n; i++){
            // 카드가 블랙잭 수를 넘기지 않으면 조합을 찾아나가고
            if(sum+cards[i] <= m && dfs(cnt+1, i+1, sum+cards[i]))
                // 총합이 m 이 되는 조합을 찾으면 재귀를 탈출한다.
                return true;
        }

        // 돌아가서 다른 조합을 찾아본다.
        return false;
    }
}
