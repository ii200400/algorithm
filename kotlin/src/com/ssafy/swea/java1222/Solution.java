// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14mbSaAEwCFAYD

// 그냥 풀면 다 버리고 모든 홀수 위치의 문자를 숫자로 변환해서 더해버렸을 텐데
// 이런 학생 막으려고 시리즈로 준비해 주셔서 얌전히 스택으로 후위표기식으로 만들어서 진행..
// 하려고 했는데 구현하면서 큐가 더 사용하기 좋아서 큐로 바꾸었다.

package com.ssafy.swea.java1222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T = 10; // 테스트 케이스 10개로 고정

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 후위 표현식을 저장할 큐
            Queue<Character> postfixStack = new LinkedList<>();
            char op = '+';  // 아직 연산자가 + 밖에 없으므로..

            // 입력 받기
            sc.nextLine();
            String line = sc.nextLine();
            int numCnt = 2; // 스택에 연속적으로 쌓을 숫자의 갯수 (여기서는 잘 못쓰이지만 괄호가 있다면 증가한다.)

            // 후위 표현식을 한 칸씩 읽어나간다.
            for (int i = 0; i<line.length(); i++){
                char c = line.charAt(i);
                if (c == '+'){  // 아직 연산자가 + 밖에 없으므로 바로 생략
                    continue;
                }

                // 숫자가 있다면 큐에 넣어주고
                postfixStack.add(c);
                // numCnt를 하나 줄인다, 0이 되었다면 다시 1로 설정한다.
                if (--numCnt == 0){
                    postfixStack.add('+'); // 아직 연산자가 + 밖에 없으므로..
                    numCnt = 1;
                }
            }

            int firstNum = 0; // 연산을 진행해 나갈 첫번째 숫자

            // 주어지는 문자열 길이가 0일 때를 대비한 조건문
            if (!postfixStack.isEmpty())
                firstNum = postfixStack.poll() - '0';

            // 후위 표현법을 토대로 계산을 진행한다.
            while(!postfixStack.isEmpty()){
                int secondNum = postfixStack.poll() - '0';
                postfixStack.poll(); // 무조건 '+' 이다..

                firstNum += secondNum;
            }

            // 결과 출력
			System.out.printf("#%d %d\n", test_case, firstNum);
        }
    }
}

