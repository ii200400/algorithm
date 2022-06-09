##어떨결에 풀음.. 생각없이 풀어서 어떻게 풀었는지 잘 모르겠는데
##기억상으로는 노드에 접근을 한 적이 있는지 없는지 확인하는 리스트(li)를 만들고
##재귀로 연결되어있는 노드들을 순회하면서
##리스트에 순회했던 노드를 채크(값을 0에서 1로 바꾸는 것)한다.

def solution(n, computers):
    answer = 0
    li = [0 for i in range(n)]
    
    def func(i):
        for j in range (n):
            if computers[i][j] and not li[j]:
                li[j] = 1
                func(j)
    
    for i in range(n):
        if li[i] : continue
        answer += 1
        li[i] = 1
        
        func(i)
            
    return answer

##정확성: 100.0
##합계: 100.0 / 100.0
