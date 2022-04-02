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

        l = sc.nextInt();
        c = sc.nextInt();
        chars = new char[c];

        for (int i = 0; i<c; i++){
            chars[i] = sc.next().charAt(0);
        }
        Arrays.sort(chars);
        vowels = new HashSet<>();
        for (char ch: new char[]{'a','e', 'i', 'o', 'u'}){
            vowels.add(ch);
        }

        selected = new char[l];
        dfs(0, 0, 0);
    }

    // 조합 (선택한 수의 개수, 조합을 이어나갈 인덱스, 모음 개수)
    static void dfs(int cnt, int idx, int v){
        if (cnt == l){
            if (v > 0 && l-v > 1){
                for (int i = 0; i<l; i++){
                    System.out.print(selected[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = idx; i<c; i++){
            selected[cnt] = chars[i];

            if (vowels.contains(chars[i])){
                dfs(cnt+1, i+1, v+1);
            }else{
                dfs(cnt+1, i+1, v);
            }
        }
    }
}
