def solution(A):
    dic = {}
    for num in A:
        dic[num] = dic.get(num,0) + 1
    
    return len(dic)

# 위의 코드를 압축하면 아래와 같다.
def solution(A):
    return len({num:1 for num in A})