n=int(input())

i=1
u=True
while i!=0:
    for x in range(n-i):
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
