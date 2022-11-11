// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXxNn6GaPW4DFASZ

package com.ssafy.swea.java13038;

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
			int N = sc.nextInt();	// 듣고싶은 강의 회수
			int[] week = new int[7];	// 강의가 열리는 여부 배열
			// 강의 배열 초기화
			for (int i = 0; i<7; i++){
				week[i] = sc.nextInt();
			}

			int min = Integer.MAX_VALUE;	// N번의 강의를 듣는데 필요한 최소 일 수
			// 각 요일부터 듣기 시작했다고 가정해보자
			for (int start = 0; start<7; start++){
				// 그렇다고 수업이 없는 요일부터 시작하는건 좀 아니고
				if (week[start] == 0)
					continue;

				// 수업이 있는 날부터
				int day = start, cnt = 0;
				while (true){
					// 강의를 빠짐없이 들었을 때
					if(week[day % 7] == 1)
							cnt++;

					day++;
					// N번째 강의를 들은 날을
					if (cnt == N){
						// 저장한다.
						min = Math.min(min, day-start);
						break;
					}
				}
			}

			// N번의 강의를 듣는데 필요한 최소 일 수 출력
			System.out.printf("#%d %d%n", test_case, min);
		}
	}
}
