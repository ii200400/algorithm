l = [-1] *26

a = input()
for i in range(len(a)):
    if (l[ord(a[i])-97]==-1): l[ord(a[i])-97] = i

st = ""
for i in range(len(l)):
    st += str(l[i])+" "
print(st)
