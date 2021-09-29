// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42587

// 각 우선순위를 가진 작업들의 수를 세고
// (특정 우선순위 작업의 가장 늦게 출력되는 인쇄물의 위치를 알기 위해) 주어진 큐를 왼쪽으로 이동시키며 순서를 세고
// 인쇄를 요청한 문서의 우선순위가 오면 오른쪽으로 이동시키며 순서를 세면서 요청 문서가 오면 답을 반환한다.
// 위의 방법은 코딩을 잘 못해서인지 통과가 안되었다.

// 무한정 idx를 오른쪽으로 옮겨서(마치 큐를 오른쪽에서 왼쪽으로 진행시키는 것처럼)
// 특정 조건(자신보다 큰 우선순위가 없으면서 요청한 인쇄물이 출력)이 만족되면 답을 반환한다.

// prioritiesCounts 각 우선순위 별 개수를 세고 저장
// request 특정조건이 충족되는지 판단하기 위함, 요청한 인쇄물 위치와 인쇄물 우선순위 저장
// searchIdx 탐색할 인쇄물 위치

class Solution42587 {
    fun solution(priorities: IntArray, location: Int): Int {
        // 변수 초기화
        var answer = 0
        val prioritiesCounts = Array(10){0}
        val request = Pair(location, priorities[location])

        for (priority in priorities) prioritiesCounts[priority] += 1

        var searchIdx = -1
        // 우선순위가 높은 것부터 탐색한다.
        for (priority in 9 downTo 1){
            // 해당 우선순위 인쇄물이 없으면 생략
            if (prioritiesCounts[priority] == 0) continue
            while (true){
                // 오른쪽으로 한칸씩 움직이면서 인쇄물 탐색
                searchIdx += 1
                if (searchIdx >= priorities.size) searchIdx = 0
                if (priority == priorities[searchIdx]){
                    answer += 1
                    prioritiesCounts[priority] -= 1

                    // 만일 자신이 인쇄할 인쇄물을 찾는다면 answer 출력
                    if (priorities[searchIdx] == request.second &&
                        searchIdx == request.first)
                            return answer
                    if (prioritiesCounts[priority] == 0) break
                }
            }
        }

        return answer
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.29ms, 56.5MB)
//테스트 2 〉	통과 (0.34ms, 56.2MB)
//테스트 3 〉	통과 (0.34ms, 56MB)
//테스트 4 〉	통과 (0.27ms, 56.3MB)
//테스트 5 〉	통과 (0.28ms, 56.2MB)
//테스트 6 〉	통과 (0.27ms, 56.5MB)
//테스트 7 〉	통과 (0.36ms, 56.9MB)
//테스트 8 〉	통과 (0.28ms, 56.3MB)
//테스트 9 〉	통과 (0.26ms, 55.8MB)
//테스트 10 〉	통과 (0.24ms, 56.5MB)
//테스트 11 〉	통과 (0.29ms, 55.5MB)
//테스트 12 〉	통과 (0.30ms, 55.8MB)
//테스트 13 〉	통과 (0.27ms, 55.3MB)
//테스트 14 〉	통과 (0.28ms, 56.5MB)
//테스트 15 〉	통과 (0.36ms, 56.3MB)
//테스트 16 〉	통과 (0.34ms, 56.1MB)
//테스트 17 〉	통과 (0.41ms, 56.3MB)
//테스트 18 〉	통과 (0.40ms, 56.1MB)
//테스트 19 〉	통과 (0.29ms, 56.4MB)
//테스트 20 〉	통과 (0.26ms, 56.3MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0