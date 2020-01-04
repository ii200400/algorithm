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
