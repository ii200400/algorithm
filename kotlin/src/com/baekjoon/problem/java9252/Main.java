// 문제 링크 : https://www.acmicpc.net/problem/9252
// 제출 공유 링크 : http://boj.kr/efe7927d5aa043ed8bab157dce77e779
// 백준 LCS 2

// 방법은 하두 많이 봐서 기억나는데.. 왜 저 방법이 맞는지 모르겠다..
// 중간에 가로와 세로의 위치를 바꿨는데, 다-씌는 그러지 말아야겠다;;

package com.baekjoon.problem.java9252;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.next();  // 첫번째 문자열
        String s2 = sc.next();  // 두번째 문자열
        // 왼쪽과 가장 윗줄을 0으로 하여 예외처리를 하기위해서 크기를 +1
        int[][] lcs = new int[s2.length()+1][s1.length()+1];    // lcs 배열
        
        // lcs 진행
        for (int i = 0; i<s2.length(); i++){
            for (int j = 0; j<s1.length(); j++){
                // 문자가 같은 경우
                if (s2.charAt(i) == s1.charAt(j))
                    lcs[i+1][j+1] = lcs[i][j]+1;
                else    // 그렇지 않은 경우
                    lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
            }
        }

        int r = s2.length(), c = s1.length();
        System.out.println(lcs[r][c]);  // lcs 길이 출력
        
        // lcs 출력
        r--;
        c--;
        // 문자를 역순으로 탐색해나가서 reverse 함수를 사용하기 위해 SB사용
        StringBuilder sb = new StringBuilder();
        while(r > -1 && c > -1){
            // 같은 문자를 찾으면 해당 문자를 저장
            if (s2.charAt(r) == s1.charAt(c)){
                sb.append(s1.charAt(c));
                r--;
                c--;
            }else if (lcs[r+1][c] == lcs[r][c]){
                // 그렇지 않다면 숫자에 따라 r혹은 c를 -1 한다.
                r--;
            }else{
                c--;
            }
        }

        // LCS 문자 출력
        System.out.println(sb.reverse());
    }
}
