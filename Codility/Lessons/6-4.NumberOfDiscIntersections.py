# heap을 활용해서 해결한 알고리즘이다.
import heapq

def solution(A):
    points = [0 for _ in range(len(A)*2)]
    
    for index, rad in enumerate(A):
        points[index*2] = (index-rad, 0)
        points[index*2+1] = (index+rad, 1)
    
    heapq.heapify(points)
    count = 0
    answer = 0
    while len(points) > 0:
        _, mod = heapq.heappop(points)
        if mod:
            count -= 1
        else:
            answer += count
            count += 1

    if answer > 10000000:
        return -1
    else:
        return answer

# 위와 같은 알고리즘을 heap대신 sort함수로 구현한 것
def solution(A):
    stack = [(idx // 2 - A[idx // 2], 1) if idx % 2 == 0
             else (idx // 2 + A[idx // 2], 0)
             for idx in range(len(A) * 2)]

    answer = 0
    count = 0
    stack.sort(key=lambda x: (x[0], -x[1]))
    for _, typ in stack:
        if typ == 1:
            answer += count
            count += 1
        else:
            count -= 1

    return answer if answer <= 10000000 else -1
