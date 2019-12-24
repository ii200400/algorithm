'''
최대 공배수 사이에서 일정 수가 돌아가면서 나타나는데 그것을 이용해서 푼 방법
e,s,m = map(int,input().split())

dif = -s+1
m = m+dif if m+dif>0 else m+dif + 19
e = e+dif if e+dif>0 else e+dif + 15

m_lo = {1:1,10:2,19:3,9:4,18:5,8:6,17:7,7:8,16:9,6:10,
 15:11,5:12,14:13,4:14,13:15,3:16,12:17,2:18,11:19}.get(m)
e_lo = {1:1,14:2,12:3,10:4,8:5,6:6,4:7,2:8,15:9,13:10,
 11:11,9:12,7:13,5:14,3:15}.get(e)

ans = 28 * (m_lo-1)
if m_lo>15 : m_lo -= 15
dif = e_lo-m_lo if e_lo-m_lo>=0 else e_lo-m_lo+15
com = {0:0,1:4,2:8,3:12,4:1,5:5,6:9,7:13,8:2,9:6,10:10,
 11:14,12:3,13:7,14:11}.get(dif)

ans += 28 * 19 * com + s
print(ans)
'''

e,s,m = map(int,input().split())
cnt = 0
while True:
    cnt += 1
    if ((cnt-1)%15+1==e and (cnt-1)%28+1==s and (cnt-1)%19+1==m) : break

print(cnt)
