##부르트포스로 푼 것 같은데 그냥 풀렸다. 카테고리는 스텍/큐이지만 나는 안 썼다.

def solution(prices):
    answer = []
    leng = len(prices)
    
    def search(i):
        for j in range(i,leng):
            if prices[i] > prices[j]: return j-i
        return leng-i-1
                
    for i in range(leng-1):
        answer.append(search(i))
            
    answer.append(0)
    
    return answer

##정확성: 66.7
##효율성: 33.3
##합계: 100.0 / 100.0

#스택으로 풀었다.
#prices의 길이가 여간 짧지 않은 이상 이 방법이 더 빨랐다.
def solution(prices):
    answer = [0 for _ in range(len(prices))]
    stack = []
    
    for i in range(len(prices)):
        while(len(stack) != 0 and stack[len(stack)-1][0] > prices[i]):
            p = stack.pop()
            answer[p[1]] = i - p[1]
            
        stack.append((prices[i],i))
    
    while (len(stack) != 0):
        p = stack.pop()
        answer[p[1]] = len(prices) - p[1] - 1
        
    return answer
