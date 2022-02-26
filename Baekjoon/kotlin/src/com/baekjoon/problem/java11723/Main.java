// 문제 링크 : https://www.acmicpc.net/problem/11723
// 제출 공유 링크 : http://boj.kr/cdb1567dd484488fba707a6bd407343e

// 문제를 보았을 때는 해시가 생각났는데.. 비트마스킹을 연습하시라고 하셨으니..
// 둘 다 해본다.

package com.baekjoon.problem.java11723;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1~20 자리가 모두 1인 이진수(111111111111111111110)이면 10진수로 2097150
        int bit = 0; // 공집합으로 시작 (문제상 인덱스0은 사용하지 않는다)

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = Integer.parseInt(br.readLine()); i>0; i--){
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "add":
                    bit = bit | 1<<Integer.parseInt(st.nextToken());
                    break;
                case "remove":
                    bit = bit & ~(1<<Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if ((bit & 1<<Integer.parseInt(st.nextToken())) != 0){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    bit = bit ^ 1<<Integer.parseInt(st.nextToken());
                    break;
                case "all":
                    // XOR 이나 OR을 자기자신의 반전을 사용해도 가능하다.
//                    bit = bit ^ ~bit;
//                    bit = bit | ~bit;
                    bit = -1; // 전체 비트가 1인 숫자는 -1이다.
                    break;
                case "empty":
                    // XOR을 자기자신에 써도 가능하다.
//                    bit = bit ^ bit;
                    bit = 0;

                    break;
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
