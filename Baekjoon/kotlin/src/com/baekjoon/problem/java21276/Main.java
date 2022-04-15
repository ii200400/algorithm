// 문제 링크 : https://www.acmicpc.net/problem/21276
// 제출 공유 링크 : http://boj.kr/1c9f11d6f66244ab84c14264f8d59a61
// 백준 계보 복원가 호석

// 이것 저것 따져봤는데.. 주어진 조건에서 가장 적당한 알고리즘은 위상정렬인 것 같다.
// 주민들이 자신의 조상을 완벽하게 기억하고 있고 그것을 호석이한테 말한다는 전제가 있긴 하지만..
// 예를 들어 C-B-A의 계보인 집안을
// (자식-조상) C-A, B-A, C-B 이렇게 주지 않고
// C-B, B-A 같은 식으로 준다면.. 어렵다.. 조건을 보면 당연히 다 말하는 것같으니 시도하겠다!

// 어.. 가문 수를 출력하는 것을 잊었는데 어떻게 75퍼까지 채점이 되었는지 의문이다;
// 어쨋든 위의 방법으로 무사히 해결하였다!
// 해시를 오랫만에 써서 조금 풀이가 햇갈렸다.

package com.baekjoon.problem.java21276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 사람 수
        // 사람 이름을 확인하고 찾아가야 하기 때문에 해시 사용
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();   // 인접리스트
        HashMap<String, Integer> inDegree = new HashMap<>();    // 해당 사람의 조상 수

        // 인접 리스트와 조상 수(inDegree) 초기화 (사실 아래의 for문과 합치기 가능)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            String name = st.nextToken();
            adjList.put(name, new ArrayList<>());
            inDegree.put(name, 0);
        }

        int m = Integer.parseInt(br.readLine());    // 기억하는 관계 수
        // 인접 리스트와 조상 수(inDegree) 초기화2..
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String desc = st.nextToken();
            String ancestor = st.nextToken();

            adjList.get(ancestor).add(desc);
            inDegree.put(desc, inDegree.get(desc)+1);
        }

        // 이름 순으로 출력하기 위해
        List<String> tempList = new ArrayList<>(adjList.keySet());
        Collections.sort(tempList);

        // 각 가문의 시조들을 탐색 (indegree가 0인 사람들)
        ArrayList<String> house = new ArrayList<>();
        for (String person: tempList){
            if (inDegree.get(person) == 0)
                house.add(person);
        }
        // 가문의 수 출력
        System.out.println(house.size());
        // 각 가문의 시조들의 이름을 사전순으로 출력
        for (String name: house){
            System.out.print(name + " ");
        }
        System.out.println();

        // 각자의 이름과 자식수, 자식의 이름 출력
        for (String person: tempList){
            System.out.print(person + " ");
            ArrayList<String> children = new ArrayList<>();
            for (String desc: adjList.get(person)){

                // desc가 person의 직계 자손이라면 저장한다.
               if (inDegree.get(desc) -1 == inDegree.get(person))
                   children.add(desc);
            }

            // 직계 자손의 수를 출력하고 각자의 이름을 출력한다.
            System.out.print(children.size() + " ");
            Collections.sort(children);
            for (String child: children)
                System.out.print(child + " ");

            System.out.println();
        }
    }
}
