# 순열 조합은 사용하는 경우가 은근 있어서 기억하는 것이 좋지만 역시 필요할 때마다 검색하게 된다 ㅎㅎ;;
import itertools

def solution(A):
    pos_list = []
    neg_list = []
    for num in A:
        if num >= 0:
            pos_list.append(num)
        else:
            neg_list.append(num)

    pos_list = sorted(pos_list, key=lambda x: -x)[:3]
    if len(pos_list) == 0:
        neg_list = sorted(neg_list, key=lambda x: -x)[:3]
    else:
        neg_list = sorted(neg_list, key=lambda x: x)[:3]
    combinations = list(itertools.combinations(pos_list + neg_list, 3))

    answer = -1000000001
    for n1, n2, n3 in combinations:
        if n1 * n2 * n3 > answer:
            answer = n1 * n2 * n3

    return answer
