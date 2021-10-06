// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42747?language=kotlin

// h-index라는  개념을 숙지하고 해결하면 되는 문제
// 이상하게 이해가 잘 안된다..

class Solution42747 {
    fun solution(citations: IntArray): Int {
        citations.sort()
        for (idx in citations.indices)
            if (citations.size - idx <= citations[idx]) return citations.size - idx
        return 0
    }
}

//정확성  테스트
//테스트 1 〉	통과 (11.04ms, 59.1MB)
//테스트 2 〉	통과 (8.27ms, 58.9MB)
//테스트 3 〉	통과 (9.51ms, 59.4MB)
//테스트 4 〉	통과 (8.30ms, 58.3MB)
//테스트 5 〉	통과 (8.95ms, 59.4MB)
//테스트 6 〉	통과 (8.93ms, 59.7MB)
//테스트 7 〉	통과 (8.31ms, 59.8MB)
//테스트 8 〉	통과 (8.81ms, 59MB)
//테스트 9 〉	통과 (12.02ms, 58.7MB)
//테스트 10 〉	통과 (10.81ms, 59.3MB)
//테스트 11 〉	통과 (8.65ms, 58.4MB)
//테스트 12 〉	통과 (8.29ms, 59.1MB)
//테스트 13 〉	통과 (8.57ms, 58.7MB)
//테스트 14 〉	통과 (8.12ms, 59.3MB)
//테스트 15 〉	통과 (10.98ms, 59.1MB)
//테스트 16 〉	통과 (8.51ms, 58.7MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0