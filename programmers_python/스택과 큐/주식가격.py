## 

## 부르트포스로 푼 것 같은데 그냥 풀렸다. 카테고리는 스텍/큐이지만 나는 안 썼다.

def solution(prices):
    answer = [0 for _ in range(len(prices))]
    leng = len(prices)
    
    def search(i):
        for j in range(i,leng):
            if prices[i] > prices[j]: return j-i
        return leng-i-1
                
    for i in range(leng-1):
        answer[i] = search(i)
    
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 10.1MB)
# 테스트 2 〉	통과 (0.05ms, 10.1MB)
# 테스트 3 〉	통과 (0.58ms, 10MB)
# 테스트 4 〉	통과 (0.66ms, 10.1MB)
# 테스트 5 〉	통과 (0.79ms, 10.3MB)
# 테스트 6 〉	통과 (0.03ms, 9.95MB)
# 테스트 7 〉	통과 (0.37ms, 10MB)
# 테스트 8 〉	통과 (0.46ms, 10.2MB)
# 테스트 9 〉	통과 (0.03ms, 10.1MB)
# 테스트 10 〉	통과 (1.45ms, 10.2MB)
# 효율성  테스트
# 테스트 1 〉	통과 (97.07ms, 18.8MB)
# 테스트 2 〉	통과 (80.63ms, 17.6MB)
# 테스트 3 〉	통과 (127.81ms, 19.4MB)
# 테스트 4 〉	통과 (92.56ms, 18.2MB)
# 테스트 5 〉	통과 (62.93ms, 17MB)
# 채점 결과
# 정확성: 66.7
# 효율성: 33.3
# 합계: 100.0 / 100.0

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

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 10.1MB)
# 테스트 2 〉	통과 (0.06ms, 10.2MB)
# 테스트 3 〉	통과 (0.42ms, 10.3MB)
# 테스트 4 〉	통과 (0.66ms, 10.2MB)
# 테스트 5 〉	통과 (0.52ms, 10.3MB)
# 테스트 6 〉	통과 (0.03ms, 10.3MB)
# 테스트 7 〉	통과 (0.50ms, 10.3MB)
# 테스트 8 〉	통과 (0.33ms, 10.3MB)
# 테스트 9 〉	통과 (0.03ms, 10.3MB)
# 테스트 10 〉	통과 (0.59ms, 10.2MB)
# 효율성  테스트
# 테스트 1 〉	통과 (49.57ms, 18.7MB)
# 테스트 2 〉	통과 (31.26ms, 17.6MB)
# 테스트 3 〉	통과 (55.75ms, 19.4MB)
# 테스트 4 〉	통과 (39.07ms, 18.1MB)
# 테스트 5 〉	통과 (30.05ms, 17.1MB)
# 채점 결과
# 정확성: 66.7
# 효율성: 33.3
# 합계: 100.0 / 100.0