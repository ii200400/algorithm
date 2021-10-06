// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42746?language=kotlin
// 참고 : https://github.com/ii200400/algorithm/blob/master/programmers/%EC%A0%95%EB%A0%AC/%EA%B0%80%EC%9E%A5%20%ED%81%B0%20%EC%88%98.py

// 이전 파이썬 해결 방법을 보고 해결하였다, 당시에도 같은 문제로 고민했었다.
// 숫자를 문자열로 바꾸고 3번 반복(각 숫자는 1000이 넘지 않으므로)하고 기본적인 문자열 정렬(도서관 책 정렬법)으로 정렬시키면 된다.

class Solution42746 {
    fun solution(numbers: IntArray): String {
        val stringNumbers = numbers.map { it.toString() }.sortedByDescending { it+it+it }
        return if (stringNumbers[0]=="0") return "0" else stringNumbers.joinToString("")
    }
}

//정확성  테스트
//테스트 1 〉	통과 (167.63ms, 98.3MB)
//테스트 2 〉	통과 (124.28ms, 87.7MB)
//테스트 3 〉	통과 (184.42ms, 111MB)
//테스트 4 〉	통과 (35.12ms, 65.1MB)
//테스트 5 〉	통과 (134.19ms, 101MB)
//테스트 6 〉	통과 (132.78ms, 101MB)
//테스트 7 〉	통과 (19.69ms, 60.3MB)
//테스트 8 〉	통과 (19.21ms, 61.5MB)
//테스트 9 〉	통과 (19.27ms, 60.5MB)
//테스트 10 〉	통과 (19.06ms, 60.4MB)
//테스트 11 〉	통과 (16.36ms, 59.8MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0