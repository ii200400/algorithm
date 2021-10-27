// 문제 링크 : https://www.acmicpc.net/problem/13244
// 제출 공유 링크 : http://boj.kr/9d290605611f4b0ea933b35ab7d8d38c
// 본인 문제 참고 : https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/13244.kt

// 이전에 풀었던 문제를 참고하여 풀었다.
// 유니온 파인드를 활용하여 크루스칼(?) 알고리즘을 구현하여 해결한 문제였는데
// 해당 문제도 똑같이 풀면 해결이 되어 참고하였다.

// bridgeCount : 다리를 건설 횟수
// 섬의 갯수 - 1 만큼의 다리를 건설하면 모든 섬이 연결되었음을 알 수 있기 때문에 추가했는데 안써도 무방하다.
// totalCost : 모든 다리를 건설하는데 사용한 총 비용
// 이외의 변수는 유니온 파인드에 대한 변수이므로 생략한다.

class Solution42861 {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        // 유니온 파인드
        val ids = IntArray(n){ it }
        fun getId(land: Int): Int{
            if (ids[land] == land) return land

            ids[land] = getId(ids[land])
            return ids[land]
        }

        var bridgeCount = 0
        fun union(land1: Int, land2:Int): Boolean{
            // 섬들 사이에 이미 통행이 가능한 경우
            if (getId(land1) == getId(land2)) return false

            // 섬들 사이에 통행이 불가능한 경우 (다리를 세워야 하는 경우)
            ids[getId(land2)] = getId(land1)
            return true
        }

        // 비용 순으로 정렬을 한 뒤, 유니온-파인드를 활용하여 다리를 건설해나간다.
        var totalCost = 0
        costs.sortBy { it[2] }
        for ((land1, land2, cost) in costs){
            if (union(land1, land2)){
                bridgeCount += 1
                totalCost += cost
                if (bridgeCount == n-1) break
            }
        }

        return totalCost
    }
}

//정확성  테스트
//테스트 1 〉	통과 (14.52ms, 59.2MB)
//테스트 2 〉	통과 (11.47ms, 59.3MB)
//테스트 3 〉	통과 (11.63ms, 59.2MB)
//테스트 4 〉	통과 (14.10ms, 58.7MB)
//테스트 5 〉	통과 (10.05ms, 59.5MB)
//테스트 6 〉	통과 (10.95ms, 59.2MB)
//테스트 7 〉	통과 (9.74ms, 59.7MB)
//테스트 8 〉	통과 (10.08ms, 59.2MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0