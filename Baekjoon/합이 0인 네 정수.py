# 문제 링크 : https://www.acmicpc.net/problem/7453
# 제출 공유 링크 : http://boj.kr/508e87ddc0c54bb99ed5f9b95ed43358
# python 으로는 시간초과가 나서 pypy3로 제출하였다. 코드는 완전히 같다.

cnt = int(input())
a, b, c, d = [0]*cnt, [0]*cnt, [0]*cnt, [0]*cnt
answer = 0

for i in range(cnt):
    a[i], b[i], c[i], d[i] = map(int, input().split())

ab = [0]*cnt**2
dic = {}
for i in range (cnt):
    for j in range (cnt): 
        ab[i*cnt+j] = a[i]+b[j]
        dic[c[i]+d[j]] = dic.get(c[i]+d[j], 0) + 1

for num in ab:
    answer += dic.get(-num, 0)

print(answer)