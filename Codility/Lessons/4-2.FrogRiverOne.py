def solution(X, A):
    dic = {}
    
    for ind, num in enumerate(A):
        dic[num] = dic.get(num, 0) + 1
        
        if len(dic) == X:
            return ind
            
    return -1
