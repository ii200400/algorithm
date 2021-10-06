## 2021년 9월 29일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 힙

1. [더 맵게](https://programmers.co.kr/learn/courses/30/lessons/42626)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/%ED%9E%99(heap)/%EB%8D%94%20%EB%A7%B5%EA%B2%8C.py)
	+ 코틀린으로 제출이 불가능하여, 이전에 풀었던 파이썬 코드로 대체
	+ heapq를 사용하여 힙 자료구조로 해결

2. [디스크 컨트롤러](https://programmers.co.kr/learn/courses/30/lessons/42627)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42627.kt)
	+ PriorityQueue를 사용하여 힙을 구현하여 해결

3. [이중우선순위큐](https://programmers.co.kr/learn/courses/30/lessons/42628)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42628.kt)
	+ PriorityQueue를 사용하여 힙을 구현하고 해당 자료형의 함수를 사용하여 간단하게 해결


## 2021년 9월 15일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 스택/큐

1. [기능개발](https://programmers.co.kr/learn/courses/30/lessons/42586)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42586.kt)
	+ 스택을 활용하여 해결

2. [프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42587.kt)
	+ 큐를 사용해야 하는 문제 같았지만, 큐의 개념을 사용하되 큐 자료구조를 사용하지는 않았다.

3. [다리를 지나는 트럭](https://programmers.co.kr/learn/courses/30/lessons/42583)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42583.kt)
	+ 큐(bridgeTrucks)를 이용하여 해결

4. [주식가격](https://programmers.co.kr/learn/courses/30/lessons/42584)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/%EC%8A%A4%ED%83%9D%EA%B3%BC%20%ED%81%90/%EC%A3%BC%EC%8B%9D%EA%B0%80%EA%B2%A9.py)
	+ 브루트포스와 큐를 이용하여 두 가지 방식으로 각각 해결
	+ 이전에 풀었던 내용이나 크게 수정할 점이 없어서 그대로 올렷다.

</br>

#### 백준

1. [트리](https://www.acmicpc.net/problem/1068)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1068.kt)
	+ [백준 공유 링크](http://boj.kr/365b2835f3ac40249d01f3f1a31181cb)
	+ 기본적인 트리 구조를 만들어 해결

2. [부분수열의 합](https://www.acmicpc.net/problem/1182)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1182.kt)
	+ [백준 공유 링크](http://boj.kr/cd73038bbfe4447db9886fbc2dd664f6)
	+ 재귀함수를 이용한 백트래킹 + 부르트포스 구현

3. [에디터](https://www.acmicpc.net/problem/1406)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1406.kt)
	+ [백준 공유 링크](http://boj.kr/b806e0de7dc346978494e96857f3fb4d)
	+ 연결리스트로 두개의 스택을 구현하여 커서의 왼쪽/오른쪽 문자열들을 넣고 빼며 해결

4. [카드 정렬하기](https://www.acmicpc.net/problem/1715)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1715.kt)
	+ [백준 공유 링크](https://www.acmicpc.net/source/share/9ea6de9e7bd04fcc83eee14454aa903f)
	+ 우선순위 큐 통해 최소힙으로 풀이, 최소힙으로 풀수 있는 간단한 문제 중 하나

5. [피보나치 수의 확장](https://www.acmicpc.net/problem/1788)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1788.kt)
	+ [백준 공유 링크](http://boj.kr/09e6aa8c0bc642cbb94e7d15c90d3100)
	+ 일반화된 피보나치 수열의 특징을 찾아내어 해결, 분류는 다이나믹 프로그래밍 / 수학


6. [알파벳](https://www.acmicpc.net/problem/1987)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1987.kt)
	+ [백준 공유 링크](http://boj.kr/79700c91e73f41e48be5e8e64217fe05)
	+ 재귀함수를 활용하여 DFS를 구현하여 해결

7. [소수의 곱](https://www.acmicpc.net/problem/2014)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/2014.kt)
	+ [백준 공유 링크](https://www.acmicpc.net/source/share/d1ce5692cb0745199e28e4d7287e2f3a)
	+ 재귀함수를 활용한 완전탐색 구현 + 중복 방지 알고리즘으로 해결

8. [별 찍기 - 10](https://www.acmicpc.net/problem/2447)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/2447.kt)
	+ [백준 공유 링크](http://boj.kr/78b4370e92f645baaf84dc7ee75687b2)
	+ 언제 공백을 출력하고 별을 출력할지 조건을 찾아 해결   
	  알고리즘 분류에는 분할정복과 재귀가 있지만, 본인은 생각도 못했다.

9. [피보나치 수 3](https://www.acmicpc.net/problem/2749)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/2749.kt)
	+ [백준 공유 링크](http://boj.kr/130e3509865040dcb788ecf9d8c21886)
	+ 피보나치 수열의 피사노 주기 특징 숙지 후 해결

10. [토마토](https://www.acmicpc.net/problem/7576)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/7576.kt)
	+ [백준 공유 링크](https://www.acmicpc.net/source/share/cb904e3883ec4fef92efe79204314ce4)
	+ BFS를 이용하여 해결, BFS로 풀 수 있는 간단한 문제이다.

</br>

#### 2022 카카오 신입공채 1차 온라인 코딩테스트

1. 문제1 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges1.kt)
	+ 해시 2개로 해결

2. 문제2 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges2.kt)
	+ K진법 변환 알고리즘 및 소수 확인 알고리즘 사용

3. 문제3 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges3.kt)
	+ 해시 및 간단한 계산 코드로 해결

4. 문제4 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges4.kt)
	+ 재귀를 통한 완전탐색으로 풀이   
		화살을 어느 과녁에 쏘는지에 탐색하면 최대 10^10 번의 탐색으로 인한 시간초과가 생겨   
		해당 과녁의 점수를 가져가는지 아닌지의 여부로 2^10 번의 탐색으로 바꾸었다.
	  추가로 두 선수의 점수 차이가 가장 크면서 가장 점수가 낮은 과녁을 더 많이 맞춘 배열을 반환하는 독특한 조건으로 인하여   
		재귀의 탐색 순서와 약간의 예외처리를 신경써서 구현하였다.
		
</br>

## 2021년 9월 1일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 해시(Hash) 4문제 중 kotlin 언어를 지원하는 두 문제

1. [위장](https://programmers.co.kr/learn/courses/30/lessons/42586?language=kotlin)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42578.kt)
	+ 순열/조합 수학식을 사용하여 해결
  
2. [베스트앨범](https://programmers.co.kr/learn/courses/30/lessons/42579)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42579.kt)
	+ 해시와 정렬(내림차순)을 사용하여 해결   
    변수의 자료형을 조금 복잡하게 썼다.
  
</br>	
	
## 2021년 8월 25일

#### 백준

1. [1197번 최소 스패닝 트리](https://www.acmicpc.net/problem/1197)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1197.kt)
	+ [백준 공유 링크](http://boj.kr/d341a35ed1604dcbb430f76004b9b20f)
	+ Prim 알고리즘을 활용하여 최소 스패닝 트리 구현

2. [13244번 Tree](https://www.acmicpc.net/problem/13244)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/13244.kt)
	+ [백준 공유 코드](https://www.acmicpc.net/source/share/9d290605611f4b0ea933b35ab7d8d38c)
	+ Union-Find(유니온 파인드 혹은 Disjoint-set)를 활용하여 해결

  