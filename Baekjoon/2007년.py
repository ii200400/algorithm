m,d = map(int,input().split())

tot = {1:0,2:31,3:59,4:90,5:120,6:151,7:181,8:212,9:243,10:273,
       11:304,12:334}.get(m) + d
print({1:"MON",2:"TUE",3:"WED",4:"THU",5:"FRI",6:"SAT",7:"SUN"}.get((tot-1)%7+1))
