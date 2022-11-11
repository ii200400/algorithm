// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14QpAaAAwCFAYi

// 영어로 펠린드룸이 한국말로 회문인줄은 몰랐네..
// 모든 회문을 구하라는 줄 알고 아주.. 골머리 썩을 뻔했는데 다행히도 길이를 주었다.
// 사실 모든 회문이라도 for문 하나만 추가하는 것 뿐이지만, 너무.. 복잡해보인다.

package com.ssafy.swea.java1215;

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스는 10개로 고정

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[][] board = new char[8][8];	// 글자판
			int charLen = sc.nextInt();	// 회문 길이

			// 글자판 초기화
			for (int i = 0; i<8; i++){
				String line = sc.next();
				for (int j = 0; j<8; j++){
					board[i][j] = line.charAt(j);
				}
			}

			int cnt = 0; // 회문 수
			boolean isPalindrome;	// 회문 여부
			// 가로/세로 회문 탐색 (정사각형이라서 가능한 부분;)
			for (int i = 0; i<8; i++) {
				for (int j = 0; j < 8 - charLen + 1; j++) {

					// 가로로 한 문자씩 살펴볼 때
					isPalindrome = true;
					for (int k = 0; k < charLen / 2; k++) {
						// 대칭되는 곳의 알파벳이 다르다면
						if (board[i][j+k] != board[i][j+charLen-k-1]){
							// 회문이 아니다.
							isPalindrome = false;
							break;
						}
					}

					// 회문이 맞다면 카운팅
					if (isPalindrome)
						cnt++;

					// 세로로 한 문자씩 살펴볼 때
					isPalindrome = true;
					for (int k = 0; k < charLen / 2; k++) {
						// 대칭되는 곳의 알파벳이 다르다면
						if (board[j+k][i] != board[j+charLen-k-1][i]){
							// 회문이 아니다.
							isPalindrome = false;
							break;
						}
					}

					// 회문이 맞다면 카운팅
					if (isPalindrome)
						cnt++;
				}
			}

			// 회문의 수 출력!
			System.out.printf("#%d %d%n", test_case, cnt);
		}
	}
}
