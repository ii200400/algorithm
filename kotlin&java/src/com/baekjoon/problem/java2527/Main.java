// 문제 링크 : https://www.acmicpc.net/problem/2527
// 제출 공유 링크 : http://boj.kr/ad3f2620d6c4480e899f6d5503e3236e

// 음.. 가로와 세로로 나눠서
// 한 직사각형의 가로가 다른 직사각형의 가로 사이에 있거나
// 한 직사각형의 세로가 다른 직사각형의 세로 사이에 있는 경우 등등을
// if 문으로 열심히 판단해서 출력하면 될 것 같은 그런 노가다 문제..?

// 생각보다 덜 노가다였다. 1.5배는 더 if문을 쓸 줄 알았는데 의외로 쉽게 풀렸다.

package com.baekjoon.problem.java2527;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 4개의 테스트 케이스
        for (int i = 0; i<4; i++) {

            // 사각형 입력 받기
            int[] rect1 = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            int[] rect2 = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

            // 서로 만나지 않는 경우
            // 한 직사각형의 위가 다른 직사각형의 아래보다 작거나
            // 한 직사각형의 아래가 다른 직사각형의 위보다 크거나..
            // 가로 선도 위와 같이 따져준다.
            if (rect1[0] > rect2[2] || rect1[2] < rect2[0] ||
                    rect1[1] > rect2[3] || rect1[3] < rect2[1]) {
                System.out.println('d');

                // 한 점으로 닿는 경우
                // 한 직사각형의 왼쪽/오른쪽이 다른 직사각형의 오른쪽/왼쪽에 닿으면서
                // 한 직사각형의 위/아래가 다른 직사각형의 아래/위에 동시에 닿는 경우
                // 안쪽에서 만나면 겹치는것이 되기 때문에 꼭 바깥에서 닿아야 한다.
            }else if ((rect1[2] == rect2[0] || rect1[0] == rect2[2]) &&
                    (rect1[1] == rect2[3] || rect1[3] == rect2[1])){
                System.out.println('c');

                // 한 변으로 닿는 경우
                // 위의 조건에서 &&만 ||로 바꾸면 된다.
                // 위에서 점으로 만나는 조건이 빠졌으니 아래와 같은 조건으로 된다.
            }else if (rect1[0] == rect2[2] || rect1[2] == rect2[0] ||
                    rect1[1] == rect2[3] || rect1[3] == rect2[1]){
                System.out.println('b');
            }else{ // 그 외는 겹치는 경우
                System.out.println('a');
            }
        }
    }
}
