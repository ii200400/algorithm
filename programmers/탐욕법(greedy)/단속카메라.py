from queue import PriorityQueue

# routes에서 차량이 들어오는 기점(첫번째 원소)으로 정렬을 한 뒤,
# 순서대로 탐색을 하다가 서로 만날 수 없는 차량이 생기면 
# cctv를 설치하고 다시 탐색을 진행하는 방식이다.

# que : 차량이 나가는 기점을 저장하는 최대 힙
# routes의 두번째 원소를 저장한다.
# 위의 값이 큐의 첫 원소(가장 먼저 나가는 차량)보다 작다면(늦게 들어오는 차량)이 온다면 큐를 비워버린다.
# cctv : 설치한 cctv의 수, answer 대신 사용하였다.

def solution(routes):
    routes.sort()
    que = PriorityQueue()

    cctv = 0
    for route in routes:
        print(route)
        # 특정 구간을 지나가는 차가 맞다면 큐에 추가
        if que.empty() or que.queue[0] >= route[0]: que.put(route[1])
        else: 
            cctv += 1
            que = PriorityQueue()
            que.put(route[1])
        print(que.queue)
    
    return cctv if not que.empty else cctv+1

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