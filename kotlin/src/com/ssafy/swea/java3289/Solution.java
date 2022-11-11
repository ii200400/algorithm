// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr

// 유니온 파인드.. 가 아니라 디스조인트 셋 구현 테스트 문제
// 오랫만에 만드니까 햇갈리고 참 머리아프다 ^ㅠ^

package com.ssafy.swea.java3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution
{
	static int[] parent;

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 원소 수
			int m = Integer.parseInt(st.nextToken());	// 연산 수
			// 입력값이 1부터 시작해서 편의를 위해 크기를 +1
			parent = new int[n+1];	// 원소별 유니온 집합
			for (int i = 1; i<=n; i++){
				parent[i] = i;
			}

			StringBuilder sb = new StringBuilder();	// 연산 결과를 저장하기 위한 변수
			// 연산을 진행한다.
			for (int i = 0; i<m; i++){
				st = new StringTokenizer(br.readLine());

				// 0 이라면 주어진 두 수를 합치고
				if (st.nextToken().equals("0")){
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}else{	// 1이라면 주어진 두 수가 같은 집합인지 살펴봐서
					if (findRoot(Integer.parseInt(st.nextToken())) == findRoot(Integer.parseInt(st.nextToken()))){
						sb.append(1);	// 같으면 1
					}else{
						sb.append(0);	// 다르면 0을 추가한다.
					}
				}
			}

			// 테스트 케이스와 연산 결과를 출력한다.
			bw.write(String.format("#%d %s\n", test_case, sb));
		}

		br.close();
		bw.close();
	}

	// 집합의 최상위 원소 찾기
	static int findRoot(int a){
		if (parent[a] == a) return a;
		return parent[a] = findRoot(parent[a]);
	}

	// 두 집합 합치기
	static void union(int a, int b){
		// 각 집합의 루트를 찾고
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		// 같다면 합치지 않는다.
		if (rootA == rootB) return;

		// 다르다면 한 집합의 루트가 다른 집합의 루트를 가리키도록 만든다.
		parent[rootB] = rootA;
	}
}
