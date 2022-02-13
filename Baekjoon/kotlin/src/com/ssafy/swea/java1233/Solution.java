// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD

// 그냥 리프노드와 그렇지 않은 노드를 구분하고 
// 리프노드라면 숫자를, 아니면 연산자를 가지는지 확인하는 알고리즘

package com.ssafy.swea.java1233;

import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10; // 테스트 케이스는 10개로 고정

        // 테스트 케이스 수 만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            boolean flag = true; // 사칙연산 유효 여부

            // 입력을 받으면서 작업 진행
            int i = 0;
            for (; i < n; i++) {
                String[] input = sc.nextLine().split(" ");

                if (input.length > 2) { // input의 갯수가 2개 이상이면 자식이 있다는 의미

                    // 하나의 숫자.. 라고 했으니 한자리 숫자만 들어온다고 생각하고 있다.
                    // 노드에 담긴 내용이 숫자이면 탈락, 자식이 1개여도 탈락한다. (사칙연산 모두 피연산자가 2개 필요하므로)
                    if (Character.isDigit(input[1].charAt(0)) || input.length == 3) {
                        flag = false;
                        break;
                    }

                }else{ // 리프노드라면
                    // 꼭 숫자를 가지고 있어야 하는데 그렇지 않다면 탈락
                    if (!Character.isDigit(input[1].charAt(0))){
                        flag = false;
                        break;
                    }
                }
            }

            // 원래는 위의 for문에 if문을 작성해서 간단히 만들지만
            // 조금 더 귀찮고 메모리 신경쓰는 쪽으로 작성해보았다.
            // break문으로 인해서 남은 입력들을 처리하는 역할을 가진다.
            // 없으면 다음 테스트 케이스에서 이전 케이스의 입력값을 가져와서 아주 난리가 난다.
            for (i++; i < n; i++) {
                sc.nextLine();
            }

            // flag 여부에 따라 출력
            System.out.printf("#%d %d\n", test_case, flag ? 1 : 0);
        }
    }
}

