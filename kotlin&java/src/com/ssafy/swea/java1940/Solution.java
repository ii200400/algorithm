// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjMgaALgDFAUq

// 문제를 보고 오해할 수도 있는 지문.. 보다는 오해를 보통 한다.
// 교수님은 테스트 케이스를 토대로 문제를 이해하라는 의미로 풀어보라고 하신것이라고 하셨다.

package com.ssafy.swea.java1940;

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
			int distance = 0;	// rc 카가 이동한 거리
			int speed = 0;		// rc 카의 속도

			// 커맨드 수만큼 또 반복
			for (int i = sc.nextInt(); i>0; i--){
				// 커맨드에 따라 가감속 진행
				switch (sc.nextInt()){
					case 1:
						speed += sc.nextInt();
						break;
					case 2:
						speed = Math.max(speed-sc.nextInt(), 0);
						break;
				}

				// rc카의 이동거리 계산
				distance += speed;
			}

			// 총 이동거리 출력
			System.out.printf("#%d %d\n", test_case, distance);
		}
	}
}
