// 문제 링크 : https://www.acmicpc.net/problem/10158
// 제출 공유 링크 : http://boj.kr/b6682ddd0ab24013b819f161195ed73a

// 아.. 진짜 시뮬레이션 처럼 풀다가 0.15초라는 것을 잊었다..
// 그냥 식 만들면 되는데에에 아이고난!!! 난 바보인가 보다아아!

package com.baekjoon.problem.java10158;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 격자 크기
        int width = sc.nextInt(), height = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt(); // 개미 위치
        int t = sc.nextInt();   // 이동 시간

        // 음.. 너비에 따른 x 계산, 높이에 따른 y계산
        // 이것은.. 그래프가 아래와 같은 식을 그려서 저렇게 표현한거라 더 설명이 불가능하다, 그래프 사진이라도 올리지 않는한..
        int temp = t % (width*2);
//        x = x+temp > width? Math.abs(width - (x+temp - width)) : x+temp;
        x = x+temp > width? Math.abs(2 * width - (x+temp)) : x+temp;    // 아.. 이렇게 쓰면 되는걸 하핳!
        temp = t % (height*2);
//        y = y+temp > height? Math.abs(height - (y+temp - height)) : y+temp;
        y = y+temp > height? Math.abs(2 * height - (y+temp)) : y+temp;

        // 개미의 위치 출력
        System.out.println(x + " " + y);
    }
}
