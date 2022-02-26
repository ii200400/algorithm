// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm

// 스택 문제인줄 알았는데.. 안 써도 된다.
// 입력값을 탐색하면서 작업을 진행해도 되는 문제라서 그렇게 했다.
// 문제 자체는 읽은 경험이 있는 것 같다. 풀었는지는 모르겠지만

// 추가 설명을 붙이자면
// 괄호를 두 개씩 읽었을 때만 이게 레이저인지 막대기인지 알 수 있다.
// 하나만 읽을 때는 알 수 없다.

package com.ssafy.swea.java5432;

import java.util.Scanner;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            char[] inputs = sc.nextLine().toCharArray();    // 입력값
            char c = '('; // 이전 괄호를 저장하는 변수, 첫번째 문자는 무조건 '('
            int ironBarCnt = 0, ironBarSum = 0; // 현재 잘릴 수도 있는 철막대기 수, 철 막대기 조각 총합

            // 입력값을 확인하면서 작업을 진행한다.
            for (int i = 1; i<inputs.length; i++) {
                // 이전 괄호와 현재 괄호를 비교하여 적절한 작업을 수행한다.
                if (c == '('){
                    if (inputs[i] ==')'){ // 레이저로 철 막대기 자르기!
                        // 현재 막대기 수 만큼 조각 증가
                        ironBarSum += ironBarCnt;

                    }else{ // 철 막대기 추가
                        ironBarCnt++;
                        ironBarSum++;
                    }

                }else if (inputs[i] ==')'){ // 잘릴 철 막대기 하나 감소
                    ironBarCnt--;
                }

                // 괄호 정보 갱신
                c = inputs[i];
            }

			System.out.printf("#%d %d\n", test_case, ironBarSum);
        }
    }
}

