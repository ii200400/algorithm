// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWl0ZQ8qn7UDFAXz

// 딱 보고 해시맵이 생각나네..

package com.ssafy.swea.java7272;

import java.util.HashMap;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 두 문자열의
			String str1 = sc.next();	// 입력 문자열 1
			String str2 = sc.next();	// 입력 문자열 2

			// ADOPQR는 1, B는 2로 키를 부여한다, 다른 알파벳은 라이브러리를 통해 해결한다.
			HashMap<Character, Integer> lookSame = new HashMap<>();
			// 해시맵 초기화
			for (char c: new char[]{'A', 'D', 'O', 'P', 'Q', 'R'})
				lookSame.put(c, 1);
			lookSame.put('B', 2);

			// 길이가 다르다면 바로 다르다는 것을 알 수 있고
			if (str1.length() != str2.length()){
				System.out.printf("#%d DIFF%n", test_case);
				continue;
			}

			boolean flag = true;	// 동일 여부
			// 각 자리의 문자
			for (int i = 0; i<str1.length(); i++){

				// 같아보이는지 본다.
				char char1 = str1.charAt(i), char2 = str2.charAt(i);
				if (!lookSame.getOrDefault(char1, 0).equals(
						lookSame.getOrDefault(char2, 0))){
					// 같지 않아보이면 동일 여부 기록을 하고 반복문을 탈출한다.
					flag = false;
					break;
				}
			}

			// 동일 문자 여부 출력!
			System.out.printf("#%d %s%n", test_case, flag? "SAME": "DIFF");
		}
	}
}
