# 스택을 이용하여 만들었다, 우선 수를 무조건 더하고 특정상황이면 빼도록 만들었다.
def solution(H):
    answer = 0
    stack = []
    
    for h in H:
        #print(stack, answer)
        answer += 1
        
        index = len(stack) - 1
        while index >= -1:
            if index == -1:
                stack.append(h)
                break
            
            if stack[index] == h:
                answer -= 1
                break
            elif stack[index] < h:
                stack.append(h)
                break
            else:
                stack.pop()
            
            index -= 1
            
    return answer

# 위와 같은 알고리즘이지만 스택에 0을 넣어서 스택의 길이가 최소 1이되도록 만들어 예외처리가 필요하지 않도록 만들었다.
def solution(H):
    answer = 0
    stack = [0]

    for h in H:
        if h > stack[-1]:
            answer += 1
            stack.append(h)
        else:
            while True:
                if stack[-1] > h:
                    stack.pop()
                else:
                    if stack[-1] < h:
                        stack.append(h)
                        answer += 1
                    break

    return answer