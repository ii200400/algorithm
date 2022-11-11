// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWczm7QaACgDFAWn

// 이게.. 무슨 소리인고..?
// 아니 문제는 쉬운 것 같은데 이해갘ㅋㅋㅋ

// 아.. 메모리 제한을 안보고 했다가 메모리 제한에 걸렸었다.
// 될 수 있는대로 변수를 줄이니 통과되었다.

package com.ssafy.swea.java6485;

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
			int[] busStationLines = new int[5001];	// 정류장 별 지나는 버스 노선
			int busLineNum = sc.nextInt();	// 버스 노선 수
			// 정류장 별 지나는 버스 노선 수 초기화
			for (int i = 0; i<busLineNum; i++){
				// 한 버스 노선이 지나는 정류장 범위 내의 정류장들을
				int start = sc.nextInt(), end = sc.nextInt();
				// 모두 +1 해준다.
				for (int j = start; j<=end; j++){
					busStationLines[j] += 1;
				}
			}

			// 정류장 배열에 맞춰서 정류장을 지나는 버스 노선 수 출력
			System.out.printf("#%d ", test_case);
			// 확인하고 싶은 버스 정류장 수
			int busStationNum = sc.nextInt();
			for (int i = 0; i<busStationNum; i++){
				// 입력을 받은 대로 변수에서 바로 정보를 가져와 출력한다.
				System.out.print(busStationLines[sc.nextInt()] + " ");
			}
			System.out.println();
		}
	}
}
