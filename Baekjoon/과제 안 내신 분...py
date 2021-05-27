# 문제 링크 : https://www.acmicpc.net/problem/5597
# 제출 공유 링크 : http://boj.kr/385121f55be148eab9a54305fa1d4fd0

list_ = [False for _ in range(30)]
for _ in range(28):
    list_[int(input())-1] = True
for i in range(30):
    if not list_[i]: print(i+1)