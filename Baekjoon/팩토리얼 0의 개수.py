n=int(input())

cont=0
while n!=0:
    temp=n
    c=0
    while True:
        if temp%5!=0:
            break
        c+=1
        temp=int(temp/5)
    cont+=c
    n-=1

print(cont)
