// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb

// 크루스칼은 싸피 전에 자주 사용해 봤었으니 프림 알고리즘을 사용해보겠다.
// 문제가.. 프림 알고리즘을 잘못 알아서 조금 다르게 사용해서 좀 문제 구현이 햇갈린다;;
// 아.. 또 정점 갯수가 간선에 비해서 너무 많고 시간은 2초이다;;
// 인접 리스트로 구현하겠다;

// 아.. 잠시 유향그래프인줄 알고 런타임에러가 떠서 당황했다.
// 무향 그래프로 바꿔주니(1줄 추가) 잘 해결되었다.

package com.ssafy.swea.java3124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());	// 정점의 수
			int e = Integer.parseInt(st.nextToken());	// 간선의 수
			ArrayList<int[]>[] adjList = new ArrayList[v+1];	// 인접 리스트

			// 인접 리스트 초기화
			for (int i = 1; i<v+1; i++){
				adjList[i] = new ArrayList<>();
			}
			for (int i = 0; i<e; i++){
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				adjList[from].add(new int[]{to, weight});
				adjList[to].add(new int[]{from, weight});
			}
			
			// 음수쪽으로든 양수쪽으로든 int형은 오버플로우가 날 수 있다.
			long weightSumMST = 0;	// MST의 가중치 총합
			// 배열의 두번째 값(가중치)를 기준으로 정렬을 하는 우선순위 큐
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(i -> i[1]));
			pq.offer(new int[]{1, 0});	// 첫번째 정점에서 이어나간다.

			boolean[] isVisited = new boolean[v+1];	// 방문 여부 배열
			int cnt = 0;	// MST에 연결한 정점 수
			while(cnt != v){
				int[] current = pq.poll();
				int vertex = current[0], weight = current[1];

				// 만일 방문했다면 생략
				if (isVisited[vertex])
					continue;

				// 방문한 적이 없다면 정점 수 +1, MST 총 가중치 추가, 방문 기록
				cnt++;
				weightSumMST += weight;
				isVisited[vertex] = true;
				
				for (int[] edge: adjList[vertex]){
					// 이미 방문한 정점과 관련된 간선이라면 생략
					if (isVisited[edge[0]])
						continue;

					// 그렇지 않다면 우선순위 큐에 추가
					pq.offer(edge);
				}
			}

			// 최소 가중 트리의 총 가중치 출력
			System.out.printf("#%d %d%n", test_case, weightSumMST);
		}
	}
}
