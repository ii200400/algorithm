// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748?language=kotlin

// 정렬 함수를 사용할 수 있는지 확인하는 문제

class Solution42748 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return IntArray(commands.size){
            val (i,j,k) = commands[it]
            array.slice(i-1 until j).sorted()[k-1]
        }
    }
}

//정확성  테스트
//테스트 1 〉	통과 (21.44ms, 61MB)
//테스트 2 〉	통과 (23.59ms, 60.4MB)
//테스트 3 〉	통과 (24.82ms, 60.1MB)
//테스트 4 〉	통과 (21.84ms, 60.2MB)
//테스트 5 〉	통과 (22.85ms, 60.6MB)
//테스트 6 〉	통과 (21.15ms, 60.6MB)
//테스트 7 〉	통과 (22.09ms, 59.9MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0