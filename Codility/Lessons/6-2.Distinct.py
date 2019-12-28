def solution(A):
    dic = {}
    for num in A:
        dic[num] = dic.get(num,0) + 1
    
    return len(dic)
