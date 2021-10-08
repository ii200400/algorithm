// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42746?language=kotlin
// 참고 : https://github.com/ii200400/algorithm/blob/master/programmers/%EC%A0%95%EB%A0%AC/%EA%B0%80%EC%9E%A5%20%ED%81%B0%20%EC%88%98.py

// 이전 파이썬 해결 방법을 보고 해결하였다, 당시에도 같은 문제로 고민했었다.
// 숫자를 문자열로 바꾸고 3번 반복하고 기본적인 문자열 정렬(도서관 책 정렬법)으로 정렬시키면 된다.

// 3번 반복하는 이유는 각 숫자는 1000이 넘지 않는 입력이 들어오는데
// 어떤 숫자가 들어와도 3번을 반복해주어야 들어올 수 있는 수들의 비교가 정확히 되기 때문이다.
// 예를 들어 32, 3, 34 를
// 기본 정렬하면 32, 34, 3 이 나온다.
// 하지만 문제 해결을 위해서는 32, 3, 34 로 정렬되기 원하기 때문에
// 강제로 32를 323232, 3을 333, 34를 343434로 만들어준 후 비교를 하여
// 32, 3, 34 로 정렬이 되도록 만드는 것이다.

// -추가-
// 스터디 중 다른 사람의 풀이가 더 이해하기 쉽고 직관적이라서 solution2로 구현하였다.

class Solution42746 {
    fun solution(numbers: IntArray): String {
        val stringNumbers = numbers.map { it.toString() }.sortedByDescending { it+it+it }
        return if (stringNumbers[0]=="0") return "0" else stringNumbers.joinToString("")
    }

    fun solution2(numbers: IntArray): String {
        val stringNumbers = numbers.map { it.toString() }.sortedWith { num1, num2 ->
            when {
                // num2가 앞에 올 때 더 크다면 바꿔줌
                num1 + num2 < num2 + num1 -> 1
                else -> -1
            }
        }
        return if (stringNumbers[0]=="0") return "0" else stringNumbers.joinToString("")
    }
}

//정확성  테스트 (solution)
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