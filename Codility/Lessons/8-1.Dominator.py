def solution(A):
    dic = {}
    
    for index, num in enumerate(A):
        temp = dic.get(num, [index, 0])
        temp[1] += 1
        dic[num] = temp
        
    l = len(A)/2
    for _, (index, cnt) in dic.items():
        if cnt > l:
            return index
    return -1
