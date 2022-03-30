// 문제 링크 : https://www.acmicpc.net/problem/14889
// 제출 공유 링크 : http://boj.kr/a45036577f944f1b84ea6649ae0fbacd

// 이전에.. swea에서 교수님이 비슷한 문제를 주신 경험이 있어서 쉽게 풀었다.
// 그 문제는 요리사가 음식을 만들 때 재료조합 어쩌구.. 라고 했는데 방법이 완벽하게 같다.
// 그래서 이번에는 조금 더 문제를 깔끔하게 구현하는 방법으로 풀었다.
// 기본적으로 완전탐색-부분집합 방식의 알고리즘으로 구현하였다.
// 각 팀의 사람을 저장해서 능력치를 합산해야했기 때문.

// 기본적으로는 O(2^n)이지만.. 가지치기한 부분이 꽤 커서 시간은 0.240ms가 걸렸다.

package com.baekjoon.problem.java14889;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, answer;
    static int[][] abilities;
    static int[] team1, team2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 모인 사람의 수
        abilities = new int[n][n];  // 추가 능력치
        
        // 능력치 초기화
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                abilities[i][j] = sc.nextInt();
            }
        }

        // 두 팀의 차이 값을 구하는 것이기 때문에 첫번째 사람은 팀1에 고정하고 시작해도 된다.
        // 예를 들어 1,2,3,4 사람이 있을 때,
        // 팀(1,2) vs 팀(3,4)의 능력치 차이는 팀(3,4) vs 팀(1,2) 과 같기 때문.
        team1 = new int[n/2];
        team2 = new int[n/2];
        team1[0] = 0;
        answer = Integer.MAX_VALUE;
        dfs(1, 0, 1);

        // 정답 출력
        System.out.println(answer);
    }

    // 팀을 나누는 함수
    // 팀1의 현재 팀원 수, 팀2의 현재 팀원 수, 현재 팀을 고르는 사람
    static void dfs(int cnt1, int cnt2, int idx){
        // 한쪽 팀의 팀원이 모두 정해지면 남은 사람들은 다른 쪽의 팀이 된다.
        if (cnt1 == n/2){
            for (int i = idx; i<n; i++){
                team2[cnt2++] = i;
            }
            abilityDiff();
            return;

        }else if (cnt2 == n/2){
            for (int i = idx; i<n; i++){
                team1[cnt1++] = i;
            }
            abilityDiff();
            return;
        }

        // 팀1에 넣어보고
        team1[cnt1] = idx;
        dfs(cnt1+1, cnt2, idx+1);

        // 이번에는 팀2에 넣어본다.
        team2[cnt2] = idx;
        dfs(cnt1, cnt2+1, idx+1);
    }

    // 팀1과 2의 능력치 차이를 구하고 answer에 적절히 저장한다.
    static void abilityDiff(){
        int sum1 = 0, sum2 = 0;

        int limit = n/2;
        // 각 팀의 두 사람에 대한 추가능력치를
        for (int i = 0; i<limit-1; i++){
               for (int j = i+1; j<limit; j++){
                   // 모-두 더해준다.
                   sum1 += abilities[team1[i]][team1[j]] + abilities[team1[j]][team1[i]];
                   sum2 += abilities[team2[i]][team2[j]] + abilities[team2[j]][team2[i]];
               }
        }

        // 두 팀의 추가 능력치 값의 차이가 이전보다 작으면 저장한다.
        int diff = Math.abs(sum1-sum2);
        if (answer > diff) {
            answer = diff;
//            System.out.println(Arrays.toString(team1));
//            System.out.println(Arrays.toString(team2));
//            System.out.println(diff);
        }
    }
}
