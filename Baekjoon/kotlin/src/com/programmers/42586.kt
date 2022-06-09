// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42586

// 스택의 개념을 생각하면서 문제를 풀었다.
// 조건이 성립하면(개발이 완료되면) 연속으로 배포하는 수를 세고 answer 변수에 배포 수를 넣는다.

// day는 작업일, count는 연속하여 배포하는 작업의 수

import kotlin.math.ceil

class Solution42586 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = arrayListOf<Int>()

        // 초기화
        var day = ceil((100.0 - progresses[0]) / speeds[0]).toInt()
        var count = 1
        for (idx in 1 until progresses.size){
            // 작업 일수 계산 후 100 이상 이면 count +1
            if (progresses[idx] + speeds[idx] * day >= 100)
                count += 1
            else{ // 100보다 작으면 answer 변수에 count 추가 및 작업일 수 재계산, count초기화
                answer.add(count)
                day = ceil((100.0 - progresses[idx]) / speeds[idx]).toInt()
                count = 1
            }
        }
        answer.add(count)

        return answer.toIntArray()
    }
}

//정확성  테스트
//테스트 1 〉	통과 (7.71ms, 56.8MB)
//테스트 2 〉	통과 (7.73ms, 57.2MB)
//테스트 3 〉	통과 (7.39ms, 56.3MB)
//테스트 4 〉	통과 (7.63ms, 56.2MB)
//테스트 5 〉	통과 (7.74ms, 56.5MB)
//테스트 6 〉	통과 (7.01ms, 57MB)
//테스트 7 〉	통과 (5.44ms, 56.5MB)
//테스트 8 〉	통과 (5.26ms, 56.8MB)
//테스트 9 〉	통과 (16.07ms, 56.4MB)
//테스트 10 〉	통과 (11.46ms, 56MB)
//테스트 11 〉	통과 (5.66ms, 56.2MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0