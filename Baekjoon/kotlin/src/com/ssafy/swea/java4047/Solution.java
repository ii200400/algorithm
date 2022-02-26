// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIsY84KEPMDFAWN

// 입력값이 1부터 시작하는데 신경안썼다가 런타임 에러가 났었다.
// 다행히도 20초만에 고쳤다.

package com.ssafy.swea.java4047;

import java.util.HashMap;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스 만큼 반복
		testCase: for(int test_case = 1; test_case <= T; test_case++)
		{
			String input = sc.next();
			boolean[][] havCards = new boolean[4][14];	// 특정 카드의 소유 여부
			int[] typeCardsNum = new int[]{13, 13, 13, 13};	// 카드 종류별 수
			HashMap<Character, Integer> strToInt = new HashMap<>();	// 문자를 배열에 편하게 넣기 위해 사용
			strToInt.put('S', 0);	// 스페이드는 인덱스 0
			strToInt.put('D', 1);	// 다이아는 인덱스 1
			strToInt.put('H', 2);	// 하트는 인덱스 2
			strToInt.put('C', 3);	// 클로버는 인덱스 3

			// 3칸씩 넘으면서 값을 읽는다.
			for (int i = 0; i<input.length(); i+=3){
				int type = strToInt.get(input.charAt(i));	// 카드 종류
				int number = Integer.parseInt(input.substring(i+1, i+3));	// 카드 숫자
				
				// 이미 가지고 있는 숫자라면
				if (havCards[type][number]){
					// 에러 출력 후 다른 테스트 케이스 진행
					System.out.printf("#%d ERROR\n", test_case);
					continue testCase;
				}

				// 그렇지 않으면 카드를 가지고 있다는 표시를 하고 해당 카드 종류 -1
				havCards[type][number] = true;
				typeCardsNum[type]--;
			}

			// 종류별로 가지고 있는 카드 수 출력
			System.out.printf("#%d %d %d %d %d\n"
					, test_case, typeCardsNum[0], typeCardsNum[1], typeCardsNum[2], typeCardsNum[3]);
		}
	}
}
