# 정렬을 사용해서 해결
def solution(A):
    A.sort()
    
    answer = 1
    for num in A:
        if num == answer:
            answer += 1
    
    return answer

# 나올 수 있는 숫자들 만큼의 크기를 가진 리스트를 활용해여 해결
def solution(A):
    num_list = [1] + [0] * 1000000

    for num in A:
        if num > 0:
            num_list[num] = 1

    return num_list.index(0)