import java.util.*

// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42583

// 1초씩 진행시키면서 다리를 빠져나가는 트럭과 다리에 진입하는 트럭을 스택을 사용해서 넣고 뺀다.
// truckWeights 스택을 편하게 사용하기 위해서 truck_weights 자료형을 MutableList로 바꾼것
// bridgeTrucks 다리에 있는 트럭을 저장한다
// [(트럭의 무개, 트럭이 진입한 초), ... ] 와 같이 저장한다.
// bridgeWeight 다리에 있는 트럭 무개의 총합이다.

class Solution42583 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        // 변수 초기화
        var day = 1
        val truckWeights = truck_weights.toMutableList()
        val bridgeTrucks = mutableListOf<Pair<Int, Int>>()
        var bridgeWeight = 0

        // 트럭이 모두 다리를 건널 때 까지 무한 반복
        while (true){
            // 다리를 건넌 트럭이 있는지 확인한다.
            if (bridgeTrucks.isNotEmpty() &&
                bridgeTrucks[0].second + bridge_length <= day){
                val (truckWeight, _) = bridgeTrucks.removeAt(0)
                bridgeWeight -= truckWeight
            }
            // 다리에 진입하는 트럭이 있는지 확인한다.
            if (truckWeights.isNotEmpty() &&
                weight - bridgeWeight >= truckWeights[0]){
                val truckWeight = truckWeights.removeAt(0)
                bridgeTrucks.add(Pair(truckWeight, day))
                bridgeWeight += truckWeight
            }

            // 트럭이 모두 건넜다면 반복문을 나간다.
            if (truckWeights.isEmpty() && bridgeTrucks.isEmpty()) break
//            println("--$day--")
//            println(truckWeights)
//            println(bridgeTrucks)

            day += 1
        }

        return day
    }
}

//정확성  테스트
//테스트 1 〉	통과 (11.60ms, 58.9MB)
//테스트 2 〉	통과 (20.32ms, 59MB)
//테스트 3 〉	통과 (10.67ms, 58.7MB)
//테스트 4 〉	통과 (16.84ms, 59MB)
//테스트 5 〉	통과 (41.81ms, 59.4MB)
//테스트 6 〉	통과 (28.64ms, 58.7MB)
//테스트 7 〉	통과 (11.42ms, 59.4MB)
//테스트 8 〉	통과 (10.95ms, 58.8MB)
//테스트 9 〉	통과 (13.45ms, 59.5MB)
//테스트 10 〉	통과 (11.25ms, 58.8MB)
//테스트 11 〉	통과 (10.89ms, 59.1MB)
//테스트 12 〉	통과 (11.25ms, 58.9MB)
//테스트 13 〉	통과 (11.91ms, 59.3MB)
//테스트 14 〉	통과 (10.93ms, 58.6MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0