from queue import PriorityQueue

def solution(routes):
    routes.sort()
    que = PriorityQueue()

    answer = 0
    for route in routes:
        print(route)
        if que.empty() or que.queue[0] >= route[0]: que.put(route[1])
        else: 
            answer += 1
            que = PriorityQueue()
            que.put(route[1])
        print(que.queue)
    
    return answer if not que.empty else answer+1

# 정확성  테스트
# 테스트 1 〉	통과 (0.28ms, 10.4MB)
# 테스트 2 〉	통과 (0.37ms, 10.5MB)
# 테스트 3 〉	통과 (0.24ms, 10.4MB)
# 테스트 4 〉	통과 (0.24ms, 10.5MB)
# 테스트 5 〉	통과 (0.27ms, 10.4MB)
# 효율성  테스트
# 테스트 1 〉	통과 (4.07ms, 10.5MB)
# 테스트 2 〉	통과 (2.72ms, 10.6MB)
# 테스트 3 〉	통과 (8.06ms, 10.8MB)
# 테스트 4 〉	통과 (0.50ms, 10.4MB)
# 테스트 5 〉	통과 (8.59ms, 10.8MB)
# 채점 결과
# 정확성: 50.0
# 효율성: 50.0
# 합계: 100.0 / 100.0