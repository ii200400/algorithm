// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42628?language=kotlin
// 참고 : https://lts0606.tistory.com/474

// 무슨 의도로 문제를 만들었는지 잘 모르겠다.
// 채점도 정확성 결과 뿐 효율성 테스트는 없어서 사실 큐가 아니라 배열로 풀어도 된다.
// (실재로 파이썬에서는 배열로 max min 함수로 해결)

// 이유는 잘 모르겠으나 priorityQueue.maxOrNull() 가 프로그래머스에서는 에러가 발생한다.
// 때문에 대신 priorityQueue.max() 를 사용하였다.

import java.util.*

class Solution42628 {
    fun solution(operations: Array<String>): IntArray {
        val priorityQueue = PriorityQueue<Int>()

        for (str in operations){
            val (op, num) = str.split(" ")
            when(op){
                "I" -> {
                    priorityQueue.add(num.toInt())
                }
                "D" -> {
                    if (num == "1"){
                        // 최대값 삭제
                        if (priorityQueue.isNotEmpty()) {
                            val maxNum = priorityQueue.max()
                            priorityQueue.remove(maxNum)
                        }
                    }else{
                        // 최소값 삭제
                        priorityQueue.poll()
                    }
                }
            }
        }

        return if (priorityQueue.isEmpty()) intArrayOf(0,0)
        else intArrayOf(priorityQueue.max() ?: 0, priorityQueue.peek())
    }
}

//정확성  테스트
//테스트 1 〉	통과 (11.73ms, 57.8MB)
//테스트 2 〉	통과 (10.94ms, 57.7MB)
//테스트 3 〉	통과 (11.29ms, 58.4MB)
//테스트 4 〉	통과 (6.63ms, 58.2MB)
//테스트 5 〉	통과 (11.60ms, 58.7MB)
//테스트 6 〉	통과 (10.96ms, 58MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0