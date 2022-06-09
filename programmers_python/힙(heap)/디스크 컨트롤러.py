##heap부분의 모든 문제들이 무슨,,
##min()/max(), heapq의 최대/최소힙을 활용하면 다 풀리는 듯 하다.;;
##다른 사람들도 거의 heapq로 풀었고 간혹 class를 써서 사용한 사람도 있다.
##있는 함수 안 쓰고 저렇게해서 푸는 것을 보면 참 여러의미로 대단하다..

import heapq

def solution(jobs):
    jobs.sort()
    time = 0
    work = []
    done = []
    
    while True:
        while len(jobs) > 0 and time >= jobs[0][0]:
            p = jobs.pop(0)
            heapq.heappush(work, [p[1],p[0]])
        if len(work) == 0: time += 1
        else:
            p = heapq.heappop(work)
            time += p[0]
            p.append(time)
            done.append(p)
            
        if len(work) ==0 and len(jobs) == 0: break
    
    answer = 0
    print(done)
    for i in done: answer += i[2]-i[1]
    
    return int(answer/len(done))

##정확성: 100.0
##합계: 100.0 / 100.0
