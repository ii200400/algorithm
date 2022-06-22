// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43164
// 프로그래머스 여행경로

// 음.. dfs.. 방문체크..
// 그런데 그 전에 알파벳 순으로 앞서는 것이 정답이 되므로 정렬부터 해야겠다.

package com.programmers.java43164;

import java.util.Arrays;

class Solution {
    String[][] tickets; // 행선지 티켓들
    String[] answer;  // 도시 방문 순서
    boolean[] used;  // 티켓 사용 여부

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";  // 시작도시는 항상 ICN이므로
        used = new boolean[tickets.length];

        // 티켓 정렬
        Arrays.sort(this.tickets, (o1,o2) -> {
            if (o1[0].compareTo(o2[0]) == 0) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
//        System.out.println(Arrays.deepToString(tickets));

        dfs(0, "ICN");

        return answer;
    }

    // 도시 방문처리를 하는 dfs
    // 도시 방문 회수, 현재 도시 이름,
    boolean dfs(int cnt, String city){
        // 모든 도시를 방문했다면 정답을 찾은 것
        if (cnt == tickets.length){
            return true;
        }

        // 티켓을 살펴본다.
        for (int i = 0; i<tickets.length; i++){
            // 이미 티켓을 사용했다면 생략
            if (used[i])
                continue;

            // 사용할 수 있는 티켓인지 확인
            if (city.compareTo(tickets[i][0]) == 0){
                used[i] = true;
                answer[cnt+1] = tickets[i][1];
                if (dfs(cnt+1, tickets[i][1]))
                    return true;
                used[i] = false;
            }
        }

        return false;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.53ms, 72.6MB)
//테스트 2 〉	통과 (0.69ms, 75.7MB)
//테스트 3 〉	통과 (0.66ms, 73.5MB)
//테스트 4 〉	통과 (0.65ms, 76MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0
