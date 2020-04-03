## Codility 문제 링크
해당 주제에 관련한 알고리즘을 블로그에서 글로 읽은 것 외에 모든 문제는 다른 사람의 도움을 일체 받지 않았다.\
때문에 코드가 조금 멍청할 수 있다.\
다른 사람의 코드를 참조한 경우는 스스로 통과가 되는 코드를 만든 이후이다. (그래야 비교가 확실히 되기 때문이다.)

Lesson 01 Iterations

1. BinaryGap

+ https://app.codility.com/demo/results/trainingTNRQW5-ZGJ/ (100/100)

Lesson 02 Arrays

1. OddOccurrencesInArray
+ https://app.codility.com/demo/results/trainingSH3MWH-5GA/ (100/100)
  + {특정 값: 특정 값 등장 횟수} 딕셔너리를 만든다.\
  딕셔너리를 전부 읽으면서 홀수인 value를 가진 값을 반환한다.
+ https://app.codility.com/demo/results/trainingRZK5ZA-KQH/ (100/100)
  + 위와 같이 딕셔너리를 활용하지만 딕셔너리에 이미 key값이 존재하면 해당 값을 삭제하는 방식으로 하였다.\
  마지막에는 홀수인 key하나만이 딕셔너리에 남아있게 된다.\
  위의 방법보다 빠른 것으로 미뤄볼 때 리스트와 다르게 딕셔너리는 값을 삭제를 해도 큰 부담이 없는 것 같다.

2. CyclicRotation
+ https://app.codility.com/demo/results/trainingZPZP4F-8N3/ (100/100)
  + 원래는 return A[len(A)-K:] + A[:len(A)-K] 한줄이었다. \
  len(A)-K가 음수여도 잘 되는 것을 확인하였지만 리스트의 길이를 넘는 음수는 생각하는대로 작동하지 않았다.\
  예를들어 A = [1,2,3,4,5], K > 10이면 그냥 [1,2,3,4,5]만 나온다.\
  그래서 위의 코드로 바꾸었다.

Lesson 03 Time Complexity

1. FrogJmp
+ https://app.codility.com/demo/results/trainingCW7GMJ-KGS/ (100/100)
  + 그냥 두 값을 나누고 반올림시키면 된다. 너무 쉬워서 왜 시간복잡도 레슨에 있는지 잘 모르겠다.
  
2. PermMissingElem
+ https://app.codility.com/demo/results/training6PBYPB-ZG3/ (100/100)
  + 1~N까지 더하는 수학 공식으로 한줄에 답을 구할 수 있다.\
  하지만 공식을 몰라도 10줄 내로 구현은 가능하다.

3. TapeEquilibrium
+ https://app.codility.com/demo/results/trainingGXN8UE-5P4/ (100/100)
  + 먼저 왼쪽과 오른쪽의 합을 의미하는 변수를 만들고\
  한칸씩 이동하면서 왼쪽과 오른쪽의 차이값을 구하여 정답을 구한다.

Lesson 04 Counting Elements

1. PermCheck
+ https://app.codility.com/demo/results/training8XJUVM-UBH/ (100/100)
  + 중복이 있다는 생각을 하지 못해서 여러번 시도하였다.\
  딕셔너리에 모든 숫자를 기록하면서 중복이 생기는지 확인하고 마지막에 최대숫자와 숫자들의 갯수가 같은지 확인한다.
  
  (2개월 지나서 다시보니까 참 이런 생각은 어떻게 했나 싶다.)
  
+ https://app.codility.com/demo/results/trainingD5DC9V-M7Q/ (100/100)
  + 딕셔너리에 숫자를 넣을 때 그 숫자가 중복되는지와 주어진 리스트의 길이보다 작은 숫자인지 확인한다.
  
두 가지 모두 크게 다른 점이 없는 알고리즘이기 때문에 속도면에서 큰 차이는 없다.
  
2. FrogRiverOne
+ https://app.codility.com/demo/results/trainingZC97JH-MFH/ (100/100)
  + 평소에 자주 사용하는 알고리즘 방식으로 풀었다.\
  (딕셔너리 사용해서 특정 데이터 수를 세고 조건에 부합하는지 확인하는 방식)
  
3. MaxCounters
+ https://app.codility.com/demo/results/training6KBPXV-49B/ (60/100)
  + N 크기의 리스트를 만들고 숫자를 리스트에 기록하다가 \
  N+1숫자가 나오면 리스트를 모두 0으로 초기화하고 가장 자주나온 숫자는 다른 변수에 기록해둔다.\
  시간복잡도가 너무 커서 좋지 못한 결과가 나왔다.\

+ https://app.codility.com/demo/results/trainingVZ9C3H-32W/ (100/100)
  + 위의 알고리즘 속도 해결하기 위하여 다른 사람의 코드를 참고하여 알고리즘을 구현했다.\
  위와 방법은 같은데 리스트 대신에 딕셔너리를 사용한 점만 다르다.
  
4. MissingInteger
+ https://app.codility.com/demo/results/trainingYWAHKV-TMV/ (100/100)
  +  나올 수 있는 숫자만큼의 크기를 가진 리스트를 만들고 list.index() 함수를 활용하여 해결했다.
  
Lesson 05 Prefix Sums

1. PassingCars
+ 링크 (100/100)
  + 내용 서술
  
2. GenomicRangeQuery
+ 링크 (100/100)
  + 내용 서술
  
3. MinAvgTwoSlice
+ 링크 (100/100)
  + 내용 서술
  
4. CountDiv
+ 링크 (100/100)
  + 내용 서술
  
Lesson 06 Sort

1. MaxProductOfThree
+ 링크 (100/100)
  + 내용 서술

2. Distinct
+ 링크 (100/100)
  + 내용 서술
  
3. Triangle
+ 링크 (100/100)
  + 내용 서술
  
4. NumberOfDiscIntersections
+ 링크 (100/100)
  + 내용 서술
  
Lesson 07 Stacks and Queues

1. Brackets
+ 링크 (100/100)
  + 내용 서술
  
2. Fish
+ 링크 (100/100)
  + 내용 서술
  
3. Nesting
+ 링크 (100/100)
  + 내용 서술
  
4. StoneWall
+ 링크 (100/100)
  + 내용 서술
  
Lesson 08 Leader

1. Dominator
+ 링크 (100/100)
  + 내용 서술
  
2. EquiLeader
+ 링크 (100/100)
  + 내용 서술
  
Lesson 09 Maximum slice problem

1. MaxProfit
+ 링크 (100/100)
  + 내용 서술
  
2. MaxSliceSum
+ 링크 (100/100)
  + 내용 서술
  
3. MaxDoubleSliceSum
+ 링크 (100/100)
  + 내용 서술
  
Lesson 10 Prime and composite numbers

1. MinPerimeterRectangle
+ https://app.codility.com/demo/results/trainingQFE98F-9KN/ (100/100)
  + 주어진 숫자의 제곱근에서 가장 가까운 약수를 구하면 답이 빠르게 나온다.
  + 에라테스어쩌구의 체를 이용하면 더 빨라지는 것으로 알고는 있으나 값이 작아서 그냥 전부 0.036초가 나와 시도는 하지 않았다.
  
2. CountFactors
+ https://app.codility.com/demo/results/trainingT8FNEX-QB8/ (100/100)
  + 위와 같이 주어진 숫자의 제곱근에서 숫자 하나씩 탐색하여 모든 약수를 구하였다.
  + 약수를 빠르게 구하는 방법을 찾다가 유클리드 호제법까지 갔는데 최대공약수를 구하는 방법이였다;;
  
3. Peaks
+ https://app.codility.com/demo/results/training7TNVRN-H7P/ (45/100)
  + 블록의 크기가 항상 같아야 하는 점을 못 이해해서 계속 틀리고 있었다;;
+ https://app.codility.com/demo/results/trainingGHCE7T-54U/ (100/100)
  + 먼저 peak들의 위치를 리스트로 만들고 중앙의 약수부터 위 혹은 아래로 이동하면서 되는 약수 중 가장 큰 것(정확히 말하면 길이//약수)을 반환하는 코드
