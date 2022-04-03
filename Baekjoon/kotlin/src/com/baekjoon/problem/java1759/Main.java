// 문제 링크 : https://www.acmicpc.net/problem/1759
// 제출 공유 링크 : http://boj.kr/ebbdb948adc24321befa25d6b0e180cc
// 백준 암호 만들기

// 5년전에 푼 경험이 있지만 전혀 기억나지 않는 문제..
// 정렬하고 조합으로 선택해서 모음 개수 세면 될 것 같다.

package com.baekjoon.problem.java1759;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int l, c;
    static char[] chars, selected;
    static HashSet<Character> vowels;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();   // 선택할 문자 수
        c = sc.nextInt();   // 문자 종류 수
        chars = new char[c];    // 문자 배열

        // 문자 배열 초기화
        for (int i = 0; i<c; i++){
            chars[i] = sc.next().charAt(0);
        }
        Arrays.sort(chars); // 사전순으로 출력하기 위해 정렬
        vowels = new HashSet<>();   // 모음들, 그냥 배열쓰고 isContain해도 되는데 기분삼아 쓴 해시셋
        // 해시셋 초기화
        for (char ch: new char[]{'a','e', 'i', 'o', 'u'}){
            vowels.add(ch);
        }

        // 선택된 문자들
        selected = new char[l];
        dfs(0, 0, 0);
    }

    // 조합 (선택한 수의 개수, 조합을 이어나갈 인덱스, 모음 개수)
    static void dfs(int cnt, int idx, int v){
        // 문자를 l개 선택했다면
        if (cnt == l){
            // 모음과 자음 수가 조건을 충족하는지 확인하고
            if (v > 0 && l-v > 1){
                // 조건에 충족되면 출ㄺ한다.
                for (int i = 0; i<l; i++){
                    System.out.print(selected[i]);
                }
                System.out.println();
            }
            return;
        }

        // 문자 선택!
        for (int i = idx; i<c; i++){
            selected[cnt] = chars[i];

            if (vowels.contains(chars[i])){ // 선택한 문자가 모음일 경우
                dfs(cnt+1, i+1, v+1);
            }else{  // 선택한 문자가 자음일 경우
                dfs(cnt+1, i+1, v);
            }
        }
    }
}
