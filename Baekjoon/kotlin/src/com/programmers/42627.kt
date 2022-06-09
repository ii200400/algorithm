// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42627?language=kotlin

// 평균 대기시간을 줄이는 방법은 단순히 작업이 짧은 것을 우선으로 선택하면 되므로
// 최소힙을 사용하여 해결을 진행하였다.

// count : 총 대기 시간
// heap : 최소힙 자료구조를 가지는 작업 대기열
// time : 시점 저장 변수
// idx : jobs 탐색용 인덱스

import java.util.*

class Solution42627 {
    fun solution(jobs: Array<IntArray>): Int {
        var count = 0
        val heap = PriorityQueue<IntArray>{ a, b ->
            if (a[1] < b[1]) -1 else 1
        }
        jobs.sortBy { it[0] }

        var time = 0
        var idx = 0
        // 작업이 모두 완료될 때까지 진행
        while (heap.isNotEmpty() || idx < jobs.size){
            // 현재 시간에 따라 받은 작업 확인
            while (idx < jobs.size && jobs[idx][0] <= time){
                heap.add(jobs[idx])
                idx += 1
            }
            // 미래에 받을 작업은 있지만 당장 할 작업은 없을 때를 위한 예외 처리
            if (heap.isEmpty()) {
                time = jobs[idx][0]
                continue
            }

            val job = heap.poll()
            println(job.contentToString())
            time += job[1]
            count += time - job[0]
//            println("$time")
        }

        return count/jobs.size
    }
}

//결과
//정확성  테스트
//테스트 1 〉	통과 (17.85ms, 60.7MB)
//테스트 2 〉	통과 (16.73ms, 60.5MB)
//테스트 3 〉	통과 (16.12ms, 59.8MB)
//테스트 4 〉	통과 (15.62ms, 60MB)
//테스트 5 〉	통과 (16.82ms, 60.3MB)
//테스트 6 〉	통과 (12.50ms, 59.6MB)
//테스트 7 〉	통과 (18.51ms, 60MB)
//테스트 8 〉	통과 (15.51ms, 59.4MB)
//테스트 9 〉	통과 (12.84ms, 59.5MB)
//테스트 10 〉	통과 (18.10ms, 60.5MB)
//테스트 11 〉	통과 (9.79ms, 59.9MB)
//테스트 12 〉	통과 (9.94ms, 59.3MB)
//테스트 13 〉	통과 (9.49ms, 59.2MB)
//테스트 14 〉	통과 (9.60ms, 59.3MB)
//테스트 15 〉	통과 (9.54ms, 58.5MB)
//테스트 16 〉	통과 (9.98ms, 60.1MB)
//테스트 17 〉	통과 (10.41ms, 59.1MB)
//테스트 18 〉	통과 (9.62ms, 59.3MB)
//테스트 19 〉	통과 (9.33ms, 59.1MB)
//테스트 20 〉	통과 (0.70ms, 59.7MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0