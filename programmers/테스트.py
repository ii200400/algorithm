#정규표현식.. 으렵따..
##import re
##
##e = ['asd@asd.com','as.ad@asd.com','asd@.com']
##p = re.compile('[a-z.]+')
##for i in e:
##    print(p.search(i).group())

t = (1,2)
##print(t[1])
##
##print(dir(list))
##
##print(sorted(['121', '12', '30','3','33','35'], key=lambda x: str(x)*3, reverse = True))
##print(sorted(['121', '12', '30','3','33','35'], reverse = True))
##print(sorted(['ㄱ','기','김']))

import itertools

print(dir(itertools))
print(list(itertools.combinations(['1','2','3','4'], 2)))
print([i for i in ['6','7','8','9']])
