##왜 실패하는지 잘 모르겠다;; heapq로 다시 풀어보았다.

##def solution(stock, dates, supplies, k):
##    answer = 0
##    
##    li = []
##    while stock < k:
##        while len(dates) > 0 and dates[0] <= stock: 
##            dates.pop(0)
##            li.append(supplies.pop(0))
##        
##        pick = max(li)
##        li.remove(pick)
##        stock += pick
##        answer += 1
##    
##    return answer

##정확성  테스트
##테스트 1 〉	통과 (0.04ms, 10.8MB)
##테스트 2 〉	통과 (0.07ms, 10.7MB)
##테스트 3 〉	통과 (0.05ms, 10.7MB)
##테스트 4 〉	통과 (0.10ms, 10.7MB)
##테스트 5 〉	통과 (0.10ms, 10.8MB)
##테스트 6 〉	통과 (0.09ms, 10.8MB)
##테스트 7 〉	통과 (0.09ms, 10.6MB)
##테스트 8 〉	통과 (0.09ms, 10.8MB)
##테스트 9 〉	통과 (0.07ms, 10.7MB)
##테스트 10 〉	통과 (0.06ms, 10.7MB)
##테스트 11 〉	통과 (0.04ms, 10.7MB)
##효율성  테스트
##테스트 1 〉	실패 (시간 초과)
##테스트 2 〉	통과 (2.76ms, 18.3MB)
##테스트 3 〉	통과 (3.98ms, 11.8MB)
##채점 결과
##정확성: 73.3
##효율성: 13.3
##합계: 86.7 / 100.0

##결국 효율성 1 못 뚫음..

##import heapq
##
##def solution(stock, dates, supplies, k):
##    answer = 0
##    heap = []
##    
##    while stock < k:
##        while len(dates) > 0 and dates[0] <= stock: 
##            dates.pop(0)
##            heapq.heappush(heap, -supplies.pop(0))
##            
##        stock -= heapq.heappop(heap)
##        answer += 1
##    
##    return answer

##정확성  테스트
##테스트 1 〉	통과 (0.08ms, 10.7MB)
##테스트 2 〉	통과 (0.08ms, 10.7MB)
##테스트 3 〉	통과 (0.06ms, 10.6MB)
##테스트 4 〉	통과 (0.09ms, 10.7MB)
##테스트 5 〉	통과 (0.09ms, 10.7MB)
##테스트 6 〉	통과 (0.08ms, 10.7MB)
##테스트 7 〉	통과 (0.08ms, 10.7MB)
##테스트 8 〉	통과 (0.09ms, 10.7MB)
##테스트 9 〉	통과 (0.08ms, 10.7MB)
##테스트 10 〉	통과 (0.07ms, 10.7MB)
##테스트 11 〉	통과 (0.04ms, 10.7MB)
##효율성  테스트
##테스트 1 〉	실패 (시간 초과)
##테스트 2 〉	통과 (2.94ms, 18.3MB)
##테스트 3 〉	통과 (2.47ms, 11.8MB)
##채점 결과
##정확성: 73.3
##효율성: 13.3
##합계: 86.7 / 100.0


##리스트의 append와 remove가 시간을 많이 잡아 먹는다는 것을 다시 생각하고
##해당 함수를 사용하지 않는 방법으로 풀었음
##결과적으로 잘 되었음.
##아니 카테고리는 힙에 있으면서 힙으로 풀면 안되는건 뭔뎈ㅋ

def solution(stock, dates, supplies, k):
    answer = 0
    supply = stock
    loc = 0
    while supply < k:
        for i in range(loc,len(dates)):
            if dates[i] > supply: 
                loc = i
                break
            if i == len(dates)-1: loc = i+1
                
        num = max(supplies[:loc])
        supplies[supplies.index(num)] = 0
        answer += 1
        supply += num
    
    return answer

##정확성: 73.3
##효율성: 26.7
##합계: 100.0 / 100.0
