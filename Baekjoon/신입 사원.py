t=int(input())

for i in range(t):
    n=int(input())
    cnt=n
    li=[0 for _ in range(n)]
    for j in range(n):
        x,y=input().split(" ")
        x=int(x)
        y=int(y)
        li[x-1]=y

    hi=li[0]
    for j in range(1,n):
        if li[j]<hi:
            hi=li[j]
        else:
            cnt-=1

    print(cnt)
