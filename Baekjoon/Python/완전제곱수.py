m=int(input())
n=int(input())

sum=0
min=0
b=False

for i in range (1,101):
    if i*i<=n and i*i>=m:
        sum+=i*i
        if b==False:
            min=i*i
            b=True
        
    if i*i>n:
        break

if min==0:
    print(-1)
else:
    print(sum)
    print(min)
