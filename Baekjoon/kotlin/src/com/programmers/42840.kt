// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42840?language=kotlin

// 문제에 쓰인데로 구현하였다.
// 완전탐색 카테고리에 맞게 완전탐색을 진행하였다.

class Solution42840 {
    fun solution(answers: IntArray): IntArray {
        val OMRs = arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(2, 1, 2, 3, 2, 4, 2, 5), intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
        var solutionAnswer = mutableListOf<Int>()
        var maxScore = 0
        for (idx in OMRs.indices) {
            val omr = OMRs[idx]
            val scoring = Array(answers.size){ if (omr[it%omr.size] == answers[it]) 1 else 0}
            val score = scoring.sum()
            if (maxScore < score){
                maxScore = score
                solutionAnswer = mutableListOf(idx+1)
            }else if (maxScore == score)
                solutionAnswer.add(idx+1)
        }
        return solutionAnswer.toIntArray()
    }
}

//정확성  테스트
//테스트 1 〉	통과 (16.15ms, 60.4MB)
//테스트 2 〉	통과 (16.23ms, 60.3MB)
//테스트 3 〉	통과 (16.33ms, 61.5MB)
//테스트 4 〉	통과 (16.93ms, 60.6MB)
//테스트 5 〉	통과 (17.61ms, 59.5MB)
//테스트 6 〉	통과 (16.20ms, 59.6MB)
//테스트 7 〉	통과 (17.68ms, 60.3MB)
//테스트 8 〉	통과 (17.30ms, 60.2MB)
//테스트 9 〉	통과 (29.43ms, 60.2MB)
//테스트 10 〉	통과 (28.15ms, 60.3MB)
//테스트 11 〉	통과 (19.79ms, 61.4MB)
//테스트 12 〉	통과 (19.71ms, 60.8MB)
//테스트 13 〉	통과 (18.68ms, 60.3MB)
//테스트 14 〉	통과 (23.46ms, 61.5MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0