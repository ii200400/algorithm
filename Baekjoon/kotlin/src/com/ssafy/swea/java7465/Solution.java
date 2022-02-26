// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU

// 그냥 유니온 파인드 연습하라고 준 문제같다.

package com.ssafy.swea.java7465;

import java.util.Scanner;

public class Solution
{
	static int[] parent;

	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트케이스 만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int group = sc.nextInt();	// 총 그룹 수
			parent = new int[group+1];	// 유니온 파인드 배열 (입력의 편의상 크기 +1)
			// 배열 초기화
			for (int i = 1; i<group+1; i++){
				parent[i] = i;
			}

			int m = sc.nextInt();	// 사람의 관계 수
			for (int i = 0; i<m; i++){
				// 집합을 합친다.
				if (union(sc.nextInt(), sc.nextInt()))
					group--;
			}

			// 그룹 수를 출력한다.
			System.out.printf("#%d %d\n", test_case, group);
		}
	}

	// 집합의 대표자 찾기
	static int findRoot(int a){
		if (parent[a] == a) return a;
		return parent[a] = findRoot(parent[a]);
	}

	// 두 집합 합치기
	static boolean union(int a, int b){
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		if (rootA == rootB) return false;

		parent[rootB] = rootA;
		return true;
	}
}
