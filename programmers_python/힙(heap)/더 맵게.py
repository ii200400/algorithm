##파이썬에서 제공하는 큐를 사용한다.
##import queue를 사용했더니 시간초과가 나와서import heapq를 사용했다.
##솔직히 저 heapq를 몰랐다면 틀릴 문제..;

import heapq

def solution(scoville, K):
    answer = -1
    
    heap = []
    for i in scoville: heapq.heappush(heap, i)
    
    count = 0
    while(True):
        temp = heapq.heappop(heap)
        if temp >= K:
            answer = count
            break
        if len(heap) < 1: break
            
        count += 1
        heapq.heappush(heap, (temp + heapq.heappop(heap)*2))
    
    return answer

##정확성: 76.2
##효율성: 23.8
##합계: 100.0 / 100.0
