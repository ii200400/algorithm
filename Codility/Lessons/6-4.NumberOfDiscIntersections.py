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
