b,n=input().split(" ")
n=int(n)

sum=0
i=0
while i<len(b):
    if 64<ord(b[i]):
        sum+=(ord(b[i])-55)*n**(len(b)-1-i)
    else:
        sum+=(ord(b[i])-48)*n**(len(b)-1-i)
    i+=1

print(sum)
