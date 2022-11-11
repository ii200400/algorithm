# 문제 링크 : https://www.acmicpc.net/problem/1208
# 제출 공유 링크 : http://boj.kr/9d45027732d44b20ad94064cbe3597b5

# 알고는 있었지만 메모리 초과
import itertools

def solution1():
    _, expect = map(int, input().split())
    nums = list(map(int, input().split()))
    answer = 0

    for count in range(1, len(nums)):
        combination = list(itertools.combinations(nums, count))

        for c in combination:
            if expect == sum(c): answer += 1

    print(answer)

# 재귀함수 시간초과
l, expect = map(int, input().split())
nums = list(map(int, input().split()))
answer = 0

def sub(index, s):
    global answer
    if index >= l: return

    s += nums[index]
    if s == expect: answer += 1

    sub(index+1, s-nums[index])
    sub(index+1, s)

def solution2():
    sub(0, 0)
    print(answer)

# 세번째.. 마참내..
def sub2(nums, dic, index, sum_):
    if len(nums) <= index: return

    sum_ += nums[index]
    dic[sum_] = dic.get(sum_, 0) + 1
    
    sub2(nums, dic, index+1, sum_-nums[index])
    sub2(nums, dic, index+1, sum_)

def solution3():
    answer = 0 if expect != 0 else -1
    l_nums, r_nums = nums[:l//2], nums[l//2:]
    l_dic, r_dic = {0:1}, {0:1}

    sub2(l_nums, l_dic, 0, 0)
    sub2(r_nums, r_dic, 0, 0)
    
    for num, cnt in l_dic.items():
        if expect-num in r_dic: answer += cnt*r_dic[expect-num]

    print(answer)

solution3()