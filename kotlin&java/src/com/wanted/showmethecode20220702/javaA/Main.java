
// 어쩜 이리 냅색문제처럼 생겼나..
// 체력이.. 0이면 주거야하지 않나..? 체력이 0이어도 된다는 듯이 설명한다.

package com.wanted.showmethecode20220702.javaA;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 몬스터 수
        int k = sc.nextInt();   // 초기 체력
        int[] atk = new int[n+1];   // 각 마을의 몬스터들의 공격력
        int[] p = new int[n+1]; // 각 마을의 주민 수
        
        // 몬스터의 공격력과 마을 주민 수 초기화
        for (int i = 1; i<=n; i++){
            atk[i] = sc.nextInt();
        }
        for (int i = 1; i<=n; i++){
            p[i] = sc.nextInt();
        }

        // 잃은 체력 별 최대 주민 해방 수 (인덱스 100이면 체력이 0이라는 의미)
        int[] dp = new int[k+1];

        // 냅색 알고리즘
        for (int i = 1; i<=n; i++){
            int loseHp = atk[i];
            int saveP = p[i];

            for (int j = k; j>=loseHp; j--){
                dp[j] = Math.max(dp[j], dp[j-loseHp] + saveP);
            }

//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[k]);
    }
}
