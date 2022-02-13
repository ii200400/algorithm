// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD

// 후위표현식을 저장할 자료구조가 큐일 필요가 없어서 배열로 바꾸었다.

package com.ssafy.swea.java1223;

import java.util.Scanner;
import java.util.Stack;

public class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T = 10; // 테스트 케이스 10개로 고정

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 입력받기
            int n = Integer.parseInt(sc.nextLine());
            char[] postfixArr = new char[n]; // 후위 표현식을 저장할 배열 (큐일 필요가 없었다..)
            Stack<Character> ops = new Stack<>();  // 연산자를 저장하는 스택


            // 중위 표현식을 한 칸씩 읽어나간다.
            String line = sc.nextLine();
            int postfixIdx = 0;
            for (int i = 0; i<line.length(); i++){
                char c = line.charAt(i);

                // c가 연산자라면
                if (c == '+'){ // '+'인 경우
                    // 스택에 저장된 연산자들을 모두 배열로 옮긴 뒤
                    while (!ops.isEmpty()){
                        postfixArr[postfixIdx++] = ops.pop();
                    }

                    // '+'를 연산자 스택에 저장한다.
                    ops.push(c);
                    continue;

                }else if (c == '*'){ // '*'인 경우
                    // 바로 연산자 스택에 저장한다.
                    ops.push(c);
                    continue;
                }

                // c가 숫자라면 바로 배열에 넣어준다.
                postfixArr[postfixIdx++] = c;
            }

            // 아직 연산자 스택에 남아있는 연사자들을 큐로 옮긴다.
            while (!ops.isEmpty()){
                postfixArr[postfixIdx++] = ops.pop();
            }

            // 후위 표현법을 토대로 계산을 진행한다.
            Stack<Integer> numbers = new Stack<>();
            for (postfixIdx = 0; postfixIdx<postfixArr.length; postfixIdx++){
                if (postfixArr[postfixIdx] == '+'){ // '+' 연산을 받은 경우
                    numbers.push(numbers.pop()+numbers.pop());
                }else if (postfixArr[postfixIdx] == '*'){ // '*' 연산을 받은 경우
                    numbers.push(numbers.pop()*numbers.pop());
                }else{ // 숫자를 받은 경우
                    numbers.push(postfixArr[postfixIdx] - '0');
                }
            }

            // 결과 출력
            System.out.printf("#%d %d\n", test_case, numbers.pop());
        }
    }
}

