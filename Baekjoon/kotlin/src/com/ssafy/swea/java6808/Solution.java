// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0

// 단순한 순열 문제이긴 한데
// 초기화를 어떻게 해야할지 조금 해맷다.

package com.ssafy.swea.java6808;

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스 만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 사용한 카드이면 true 그렇지 않으면 false를 저장한다.
			deck = new boolean[19];
			// 규현이?였나 가지고 있는 카드
			kyuDeck = new int[9];
			// kyuDeck, deck 초기화
			for (int i = 0; i<9; i++){
				kyuDeck[i] = sc.nextInt();
				deck[kyuDeck[i]] = true;
			}

			// 규현이가 이기는 경우의 수 저장
			answer = 0;
			dfs(0, 0, 0);

			// 정답 출력 (362880는 9!)
			System.out.printf("#%d %d %d\n", test_case, answer, 362880 - answer);
		}
	}

	static boolean[] deck;
	static int[] kyuDeck;
	static int answer;

	static void dfs(int cnt, int kScore, int iScore){
		// 라운드를 모두 마치면
		if (cnt == 9){
			// 총점에 따라 누가 이겼는지 확인하고
			if (kScore > iScore)
				answer++;

			// 돌아간다.
			return;
		}

		// 인영이가 남은 카드 중 하나를 선택해서 낸다.
		for (int i = 1; i<=18; i++){
			// 카드가 사용 중이라면 생략한다.
			if (deck[i])
				continue;

			// 선택한 카드에 따라 점수계산을 하고 다음 라운드를 시작한다.
			deck[i] = true;
			dfs(cnt+1,
				(kyuDeck[cnt] > i)? kScore+kyuDeck[cnt]+i : kScore,
				(kyuDeck[cnt] < i)? iScore+kyuDeck[cnt]+i : iScore);

			// 덱에 카드를 다시 넣는다.
			deck[i] = false;
		}
	}
}
