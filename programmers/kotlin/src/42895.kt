// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42895
// 참고 : https://gurumee92.tistory.com/164

// 해법을 모르겠어서 결국 다른 사람의 문제해결 방법을 찾아보았다.
// 이전에 본 적이 있는 풀이 방법이라서 슬펐다.. (꼭 풀이 방법은 기억 안나고 본 기억만 있다.)

// 참고 링크에 있던 글을 인용해서 풀이법을 적어보면 다음과 같다.

// 5를 1번 사용해서 만들 수 있는 수 : 5

// 1 = 1

// 5를 2번 사용해서 만들 수 있는 수 : 55, 10(5+5), 0(5-5), 25(5*5), 1(5/5)
// 55,              5를 연속으로 이어붙인 수
// 10, 0, 25, 1     1번 SET 과 1번 SET 사칙연산한 결과 값들

// 2 = 2
//   = 1 + 1

// 5를 3번 사용해서 만들 수 있는 수 (여기서, U는 합집합을 나타냅니다.) :
// 555 U
// (1번 SET 과 2번 SET 사칙연산한 결과 값들) U
// (2번 SET 과 1번 SET 사칙연산한 결과 값들)
//  -, / 연산은 자리가 바뀌게 되면 다른 수를 나타낸다는 점으로 인하여 위와 같이 표현할 수 있다.

// 3 = 3
//   = 1 + 2
//   = 2 + 1

// expressN : 숫자 N이 사용되는 횟수 별로 구할 수 있는 수들의 리스트, numberSet의 리스트
// numberSet : 숫자 N을 특정 횟수 만큼 사용하여 만들 수 있는 수 집합
// cnt : N이 몇 번 쓰이는지 저장하는 변수

// 4중 for문 쓰게 될 줄은 몰랐다, 알고리즘을 하면서 처음있는 일이다;;
// 혼란을 덜기 위해서 for문의 역할을 여기에 정리해보겠다.
// 1번 for 문 - 숫자 N이 사용되는 횟수만큼 반복
// 2번 for 문 - 숫자 집합을 순서대로 선택하기 위해 반복
// 3번 for 문 - 위에서 선택한 첫 번째 숫자 집합의 숫자들 순서대로 선택하며 반복
// 4번 for 문 - 위에서 선택한 두 번째 숫자 집합의 숫자들 순서대로 선택하며 반복
// 어려운 내용은 아닌데 혹시 몰라 적어놓았다.

class Solution42895 {
    fun solution(N: Int, number: Int): Int {
        // 인덱스 1부터 실질적인 값을 넣는다.
        val expressN = mutableListOf(mutableSetOf(), mutableSetOf(N))
        if (number == N) return 1

        // N이 사용되는 횟수만큼 반복 (1번)
        for (cnt in 2..8){
            // 55 혹은 555와 같이 숫자 N이 붙어있는 수 만들면서 초기화
            val numberSet = mutableSetOf("$N".repeat(cnt).toInt())
            // set들 끼리 사칙연산 시작 (2번)
            for (setIdx in 1..(cnt+1)/2){
                for (value1 in expressN[setIdx]){ // (3번)
                    for (value2 in expressN[expressN.size - setIdx]){ // (4번)
                        numberSet.add(value1 + value2)
                        numberSet.add(value1 - value2)
                        numberSet.add(value1 * value2)
                        if (value2 != 0) numberSet.add(value1 / value2)
                        numberSet.add(value2 - value1)
                        if (value1 != 0) numberSet.add(value2 / value1)
                    }
                }
            }
//            println(numberSet.toString())
            if (numberSet.contains(number)) return cnt
            expressN.add(numberSet)
        }

        return -1
    }
}

// 정확성  테스트
//테스트 1 〉	통과 (27.28ms, 66.5MB)
//테스트 2 〉	통과 (24.65ms, 60.9MB)
//테스트 3 〉	통과 (23.80ms, 60.6MB)
//테스트 4 〉	통과 (43.25ms, 65.2MB)
//테스트 5 〉	통과 (37.15ms, 68MB)
//테스트 6 〉	통과 (30.23ms, 61.4MB)
//테스트 7 〉	통과 (26.35ms, 62MB)
//테스트 8 〉	통과 (47.03ms, 67.3MB)
//테스트 9 〉	통과 (17.63ms, 60.3MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0