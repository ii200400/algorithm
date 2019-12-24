def solution(X, A):
    dic = {}
    
    for cnt, num in enumerate(A):
        dic[num] = dic.get(num, 0) + 1
        
        if len(dic) == X:
            return cnt
            
    return -1
