def solution(S):
    if len(S) == 0:
        return 1
    
    stack = [S[0]]
    for char in S[1:]:
        if char in ['(', '[', '{']:
            stack.append(char)
        elif len(stack) > 0:
            p = stack[len(stack)-1]
            if ((char == ')' and p == '(') or (char == ']' and p == '[') or (char == '}' and p == '{')):
                stack.pop()
        else :
            return 0
    
    if len(stack) == 0:
        return 1
    else:
        return 0
