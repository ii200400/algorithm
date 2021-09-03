// 문제 링크 : https://www.welcomekakao.com/learn/courses/30/lessons/42578

// 옷 종류별로 수를 세고
// 순열/조합 파트에서 배운 수학 식을 적용하여 답을 도출하는 방식이다.

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val clotheMap = mutableMapOf<String, Int>()
        for ((_, type) in clothes){
            clotheMap[type] = clotheMap.getOrDefault(type, 0) + 1
        }

        var answer = 1
        for ((_, num) in clotheMap){
            answer *= num+1
        }
        return answer - 1
    }
}

//결과
//정확성  테스트
//테스트 1 〉	통과 (0.21ms, 56.1MB)
//테스트 2 〉	통과 (0.17ms, 56.4MB)
//테스트 3 〉	통과 (0.20ms, 56.6MB)
//테스트 4 〉	통과 (0.21ms, 55.8MB)
//테스트 5 〉	통과 (0.30ms, 56.4MB)
//테스트 6 〉	통과 (0.21ms, 56.4MB)
//테스트 7 〉	통과 (0.24ms, 56.8MB)
//테스트 8 〉	통과 (0.26ms, 56.3MB)
//테스트 9 〉	통과 (0.21ms, 56MB)
//테스트 10 〉	통과 (0.24ms, 56.6MB)
//테스트 11 〉	통과 (0.17ms, 56.5MB)
//테스트 12 〉	통과 (0.30ms, 56.3MB)
//테스트 13 〉	통과 (0.23ms, 56.5MB)
//테스트 14 〉	통과 (0.26ms, 56.1MB)
//테스트 15 〉	통과 (0.33ms, 56.1MB)
//테스트 16 〉	통과 (0.17ms, 56.7MB)
//테스트 17 〉	통과 (0.23ms, 56.3MB)
//테스트 18 〉	통과 (0.17ms, 56.8MB)
//테스트 19 〉	통과 (0.21ms, 56.6MB)
//테스트 20 〉	통과 (0.20ms, 56.4MB)
//테스트 21 〉	통과 (0.19ms, 56.1MB)
//테스트 22 〉	통과 (0.35ms, 55.8MB)
//테스트 23 〉	통과 (0.21ms, 56.5MB)
//테스트 24 〉	통과 (0.20ms, 56.3MB)
//테스트 25 〉	통과 (0.27ms, 56.6MB)
//테스트 26 〉	통과 (0.21ms, 56.9MB)
//테스트 27 〉	통과 (0.24ms, 56.8MB)
//테스트 28 〉	통과 (0.19ms, 56.5MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0