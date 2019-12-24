num = int(input())
cnt = 99
if(num<=99): cnt = num
else:
    for i in range(111,num+1):
        a = i//100
        b = i//10 - a * 10
        c = i - i//10 * 10
        if (b-a == c-b): cnt+=1

print(cnt)
