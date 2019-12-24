##다른 사람들 참 잘 풀었다 내것과 크게 다른점은 없으니 봐도 무방할 것 같다.

def dfs(numbers,target,s):
    if not len(numbers) :
        if target == s: return 1
        else: return 0
    
    p = numbers[0]
    li = numbers[1:]
    return dfs(li,target,s-p) + dfs(li,target,s+p)

def solution(numbers, target):
    answer = dfs(numbers,target,0)
    
    return answer

##정확성: 100.0
##합계: 100.0 / 100.0
