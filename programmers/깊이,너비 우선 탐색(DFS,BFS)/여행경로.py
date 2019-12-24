##알파벳 순서상 가장 빠른 것이 먼저 오도록 하기 위해서 먼저 tickets를 정렬한다.
##깊은 복사를 위해서 dfs에 리스트를 넣을 때 꼭 슬라이싱을 사용했다.


def solution(tickets):
    tickets.sort()
    steps = [False for _ in range(len(tickets))] #해당 티켓을 사용했는지 여부
    li = [0 if i != 0 else 'ICN' for i in range(len(tickets)+1)] #return할 리스트
    
    def dfs(count, steps):
        for i in range(len(tickets)):
            #현 위치와 티켓의 출발지가 같고 사용을 아직 하지 않은 티켓이라면
            if li[count] == tickets[i][0] and not steps[i]: 
                li[count+1] = tickets[i][1]

                #티켓을 모두 사용하였으면 리스트를 반환
                if count+1 == len(tickets): return li
                
                result = dfs(count+1, steps[:i]+[1]+steps[i+1:])
                #result가 False가 아니면 그 값을 그대로 반환하고
                if result: return result
                #False이면 다른 경로를 계속해서 찾는다.
        
        return 0
                
    return dfs(0,steps[:])

##정확성: 100.0
##합계: 100.0 / 100.0
