##뭔가 쓸대없이 어렵게 푼건가..
##collections로 스테이지당 몇개씩 사람들이 못 통과했는지 세고(dic 변수에 저장)
##answer에 값을 저장하는 방식으로 했다.
##그런데 내가 너무 어렵게 푼듯;;

import collections

def solution(N, stages):
    answer = [[0,i+1] for i in range(N)]
    dic = dict(collections.Counter(stages))
    print(dic)
    num = 0
    for i in range(N+1,0,-1):
        fail = 0
        if dic.get(i): 
            fail = dic[i]
            num += fail
            
        if i == N+1 or num == 0:  continue
        answer[i-1][0] = fail/num
    
    answer.sort(key=lambda x: (x[0],-x[1]),reverse=True)
    for i in range(N):
        answer[i] = answer[i][1]
    
    return answer
