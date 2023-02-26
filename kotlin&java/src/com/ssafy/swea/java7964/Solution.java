// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWuSgKpqmooDFASy

// 그냥.. 한쪽으로 이동하면서 제한 이동거리인데 차원문이 없으면 설치하면 되는거 아닌가?

package com.ssafy.swea.java7964;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int cityNum = Integer.parseInt(st.nextToken());	// 도시 수 (사용 안함)
			int limit = Integer.parseInt(st.nextToken());	// 제한 이동 거리

			st = new StringTokenizer(br.readLine());
			int installNum = 0, distance = 1;	// 추가 설치가 필요한 차원문 수, 왼쪽 차원문과의 거리
			while (st.hasMoreTokens()){	// 입력값이 있을 때 까지 반복
				if (Integer.parseInt(st.nextToken()) == 1) {
					// 차원문이 있다면 거리를 초기화하고
					distance = 1;
				}else if (distance == limit){
					// 차원문이 없는데 제한 이동거리라면 차원문을 설치하고 거리를 초기화하고
					installNum++;
					distance = 1;
				}else{
					// 그 외이면 거리만 +1
					distance++;
				}
			}

			// 추가로 설치가 필요한 차원문 수 출력
			System.out.printf("#%d %d\n", test_case, installNum);
		}
	}
}
