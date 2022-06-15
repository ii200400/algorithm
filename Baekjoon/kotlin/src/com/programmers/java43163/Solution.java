// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43163
// 프로그래머스 단어 변환

// 50개의 단어.. 길이는 3이상 10이하..
// 대충 bfs 생각했다가 시간초과 날 것 같았는데 고민이 사라졌다.

package com.programmers.java43163;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] used = new boolean[words.length];

        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        int answer = 0;    // 변환 회수
        while(!q.isEmpty()){
            int size = q.size();
            answer++;

            for (int i = 0; i<size; i++) {
                String word = q.poll();

                for (int j = 0; j<words.length; j++){
                    // 이미 사용된 단어라면 패스
                    if (used[j])
                        continue;

                    // 그렇지 않다면 한 알파벳만 다른 단어인지 체크한다.
                    String otherWord = words[j];
                    int diff = 0;
                    for (int k = 0; k<otherWord.length(); k++){
                        if (word.charAt(k) != otherWord.charAt(k))
                            diff++;
                    }

                    // 한 단어만 다르면
                    if (diff == 1){
                        // 해당 단어가 target인지 확인하고 맞다면 answer 반환
                        if (otherWord.equals(target)){
                            return answer;
                        }

                        // 단어 사용 처리
                        used[j] = true;
                        q.offer(otherWord);
                    }
                }
            }
        }

        // target으로 변환 불가능
        return 0;
    }
}

// 정확성  테스트
//테스트 1 〉	통과 (0.17ms, 71.5MB)
//테스트 2 〉	통과 (0.18ms, 75.6MB)
//테스트 3 〉	통과 (0.37ms, 74.5MB)
//테스트 4 〉	통과 (0.18ms, 77.4MB)
//테스트 5 〉	통과 (0.10ms, 65.7MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0
