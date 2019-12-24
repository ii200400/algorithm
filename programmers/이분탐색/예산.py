#흔한 이진탐색에 약간의 조건을 변경시킨 것

def solution(budgets, M):
    answer = 0
    bottom = int(M/len(budgets))    #탐색한 값 중 가능한 최고 상한액
    top = max(budgets)              #탐색한 값 중 불가능한 최저 상한액
    
    if sum(budgets) <= M: return top
    
    while(True):
        if bottom+1 == top: return bottom
        
        line = int((bottom+top)/2)
        s = 0
        for i in budgets:
            if i <= line: s += i
            else: s += line
        if s <= M: bottom = line
        else: top = line
        print(bottom, top)

##정확성: 75.0
##효율성: 25.0
##합계: 100.0 / 100.0
