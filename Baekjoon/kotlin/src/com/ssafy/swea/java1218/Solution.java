// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD

// 스택 사용 한다ㅏ아아아 필요있다아..

package com.ssafy.swea.java1218;

import java.util.Scanner;
import java.util.Stack;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;	// 항상 10개의 테케

		// 테스트 케이스만큼 반복
		testCase: for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.next();	// 안 쓰는 변수
			String baskets = sc.next();	// 괄호들
			Stack<Character> stack = new Stack<>();	// 괄호 검사에 쓰일 스택

			// 입력받은 괄호를 검사하면서 출력한다.
			System.out.printf("#%d ", test_case);
			for (int i = 0; i<baskets.length(); i++){
				char c = baskets.charAt(i);
				// 여는 괄호들이라면 스택에 넣고
				switch (c){
					case '(':
					case '[':
					case '{':
					case '<':
						stack.add(c);
						break;
						
						// 닫는 괄호들이라면 스택 바로 위에 해당하는 괄호와 짝이 맞는 것이 있는지 확인한다.
					// 짝이 맞지 않다면 유효성 여부 출력 후 바로 다음 테케로 넘어간다.
					case ')':
						if (stack.pop() != '('){
							System.out.println(0);
							continue testCase;
						}
						break;

					case ']':
						if (stack.pop() != '['){
							System.out.println(0);
							continue testCase;
						}
						break;

					case '}':
						if (stack.pop() != '{'){
							System.out.println(0);
							continue testCase;
						}
						break;

					case '>':
						if (stack.pop() != '<'){
							System.out.println(0);
							continue testCase;
						}
						break;
				}
			}

			// 스택이 비워져 있다면 1 아니면 0을 출력한다.
			System.out.println(stack.isEmpty()? 1:0);
		}
	}
}
