import kotlin.math.sqrt

// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42842?language=kotlin

// 카펫의 전체 크기와 노란색의 크기에 알맞는 직사각형을 찾으면 된다.
// 완전탐색 외의 어려운 점은 없다.

class Solution42842 {
    fun solution(brown: Int, yellow: Int): IntArray {
        val size = brown+yellow
        for (div in 3 until size){
            if (size % div == 0 && ((size / div)-2)*(div-2) == yellow)
                return intArrayOf(size / div, div)
        }

        // 에러로 인한 더미 return
        return intArrayOf(0, 0)
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.02ms, 55.8MB)
//테스트 2 〉	통과 (0.03ms, 56.2MB)
//테스트 3 〉	통과 (0.03ms, 56.7MB)
//테스트 4 〉	통과 (0.02ms, 56.9MB)
//테스트 5 〉	통과 (0.01ms, 57.7MB)
//테스트 6 〉	통과 (0.03ms, 56MB)
//테스트 7 〉	통과 (0.02ms, 58.6MB)
//테스트 8 〉	통과 (0.03ms, 56.8MB)
//테스트 9 〉	통과 (0.03ms, 56.4MB)
//테스트 10 〉	통과 (0.03ms, 56.8MB)
//테스트 11 〉	통과 (0.02ms, 56.5MB)
//테스트 12 〉	통과 (0.01ms, 57.1MB)
//테스트 13 〉	통과 (0.02ms, 56.5MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0