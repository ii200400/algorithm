// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42747?language=kotlin

// h-index라는  개념을 숙지하고 해결하면 되는 문제
// 이상하게 이해가 잘 안된다..

// citations [3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6]
// 1번째 : citations[0] 0번 이상 인용된 논문이 5편 이상
// 2번째 : citations[1] 1번 이상 인용된 논문이 4편 이상
// 1번째 : citations[2] 3번 이상 인용된 논문이 3편 이상 *최대 h는 3*
// 1번째 : citations[3] 5번 이상 인용된 논문이 2편 이상
// 1번째 : citations[4] 6번 이상 인용된 논문이 1편 이상

// citations [5, 5] -> [5, 5]
// 1번째 : citations[0] 5번 이상 인용된 논문이 2편 이상 *최대 h는 2*
// 2번째 : citations[1] 5번 이상 인용된 논문이 1편 이상

// citations [0, 0] -> [0, 0]
// 1번째 : citations[0] 0번 이상 인용된 논문이 2편 이상
// 2번째 : citations[1] 0번 이상 인용된 논문이 1편 이상
// 최대 h는 0

// citations을 정렬을 한 이후에 순서대로 탐색을 하였을 때,
// citations[index]는 점점 커지고, citations[index]번 이상 인용된 논문 수가 '1씩' 작아진다.
// citations[index]가 citations[index]번 이상 인용된 논문 수 보다 크거나 같아지는 순간
// citations[index]번 이상 인용된 논문의 수가 최대 h가 되는 점을 이용해서 만든 코드이다.

// 수학적으로 자명하게 증명하고 싶었으나 못하겠어서 위와같이 문제의 특징을 찾아내어 코드를 만들었다.
// 세번째 예시의 예외처리를 위해서 코드가 for 문 내에서 return을 하지 못하고 나오는 경우를 위하여
// 마지막에 꼭 return 0을 해주어야 한다.

class Solution42747 {
    fun solution(citations: IntArray): Int {
        citations.sort()
        for (idx in citations.indices)
            if (citations.size - idx <= citations[idx]) return citations.size - idx
        return 0
    }
}

//정확성  테스트
//테스트 1 〉	통과 (11.04ms, 59.1MB)
//테스트 2 〉	통과 (8.27ms, 58.9MB)
//테스트 3 〉	통과 (9.51ms, 59.4MB)
//테스트 4 〉	통과 (8.30ms, 58.3MB)
//테스트 5 〉	통과 (8.95ms, 59.4MB)
//테스트 6 〉	통과 (8.93ms, 59.7MB)
//테스트 7 〉	통과 (8.31ms, 59.8MB)
//테스트 8 〉	통과 (8.81ms, 59MB)
//테스트 9 〉	통과 (12.02ms, 58.7MB)
//테스트 10 〉	통과 (10.81ms, 59.3MB)
//테스트 11 〉	통과 (8.65ms, 58.4MB)
//테스트 12 〉	통과 (8.29ms, 59.1MB)
//테스트 13 〉	통과 (8.57ms, 58.7MB)
//테스트 14 〉	통과 (8.12ms, 59.3MB)
//테스트 15 〉	통과 (10.98ms, 59.1MB)
//테스트 16 〉	통과 (8.51ms, 58.7MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0