n=int(input())

i=0
u=True
while True:
    if i==-1:
        break
    
    for x in range(i):
        print(" ",end="")
    for x in range((n-i)*2-1):
        print("*",end="")
    print("")
    if i==n-1:
        u=False
    if u:
        i+=1
    else:
        i-=1
