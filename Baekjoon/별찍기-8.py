n=int(input())

u=True
i=1
while True:
    if i==0:
        break
    for x in range(i):
        print("*",end="")
    for x in range((n-i)*2):
        print(" ",end="")
    for x in range(i):
        print("*",end="")
    print("")

    if i==n:
        u=False
    if u:
        i+=1
    else:
        i-=1
