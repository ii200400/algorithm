// 문제 링크 : https://www.acmicpc.net/problem/3040
// 제출 공유 링크(DFS) : http://boj.kr/42ae5d91c56c4e8798cdba9bcb0e77e3
// 제출 공유 링크(이중 for문) : http://boj.kr/2b1a152ba8be4cbbaf563f2b5a5c26f6

// 어.. 부분 집합에 isSelected 배열을 활용하고 dfs 함수가 boolean을 반환하도록 만들어서
// 원하는 조건이 되면 모든 재귀함수를 빠져나와서 isSelected에서 True인 숫자들을 출력하였다.

// 생각해보니 2개만 빼도 되네..?
// 의외로 속도는 크게 차이가 없다. 테스트 케이스 수가 많이 작은 듯 하다.

package com.baekjoon.problem.java3040;

import java.util.Scanner;

public class Main {
    
    static boolean[] isSelected = new boolean[9]; // 모자 선택 여부 배열
    static int[] hats = new int[9]; // 모자의 숫자 배열

    public static void main(String[] args) {
        // 초기화
        Scanner sc = new Scanner(System.in);
        
        int sum = 0; // 숫자의 총합 (이중 for문에서만 사용)
        // 숫자 배열 초기화
        for (int i = 0; i<9; i++){
            hats[i] = sc.nextInt();
            sum += hats[i];
        }

        // dfs 사용
//        dfs(0, 0, 0);
//
//        for (int i = 0; i<9; i++){
//            if(isSelected[i])
//                System.out.println(hats[i]);
//        }

        // 이중 for문 사용
        int sumTemp, i = 0, j = 0;
        // 2개의 모자를 선택한다.
        search: for (i = 0; i<8; i++){
            // 여기서 1개를 선택하고
            sumTemp = sum - hats[i];

            for (j = i+1; j<9; j++){
                // 여기서 1개를 더 선택하는데
                // 선택한 2개의 모자를 뺀 총합이 100이면
                if (sumTemp - hats[j] == 100)
                    // 탐색을 종료한다.
                    break search;
            }
        }

        // 뺀 2개의 모자를 제외하고 출력한다.
        for (int k = 0; k<9; k++){
            if (k == i || k == j)
                continue;
            System.out.println(hats[k]);
        }
    }

    // 7개의 모자를 선택하는 dfs
    static boolean dfs(int cnt, int idx, int sum){
        // 선택한 7모자의 숫자의
        if (cnt == 7){
            // 총합이 100이면 return true 아니면 return false
            // 여기서 true가 발생하면 구조상 모든 재귀함수를 탈출한다.
            return sum == 100;
        }

        // 모자는 9개를 넘기지 않는다.
        if (idx == 9)
            return false;

        // 모자를 선택하고 진행해보고
        isSelected[idx] = true;
        if(dfs(cnt+1, idx+1, sum+hats[idx])){
            return true;
        }

        // 모자를 선택하지 않고 진행해본다.
        isSelected[idx] = false;
        if(dfs(cnt, idx+1, sum)){
            return true;
        }

        return false;
    }
}
