# Optimizer

# 👣 개요

그동안의 프로젝트는 기능 구현에 초점이 맞춰져 있을 뿐 서버 최적화에 대해

진지한 논의가 있던 프로젝트는 없었다. 때문에 오로지 서버 최적화에 대해서만

실험하는 프로젝트를 진행하고자 하여 Optimizer 프로젝트를 진행하고자 한다.

<br/><br/>

Optimizer 프로젝트는 다음과 같은 형식으로 진행될 예정이다.
<br/>

1. 다양한 연관 관계의 엔티티들을 정의한다.

2. 각 엔티티를 위한 더미 데이터를 **최소 1만개 ~ 최대 1억개** 적재한다.

3. 테스트 코드를 이용해 각 코드마다 n번 실행 후 n번 동안의 실행 시간을 로그로 기록하기

![Untitled](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F3bYPu%2FbtsAWf8n6cE%2FfSZcTj5S0RKaHKiGZK4Wc0%2Fimg.png)
<br/>

---
<br/><br/>
# 👣 실험 목록

다양한 최적화 전략에 의한

최적화 여부와 성능 개선 정도를 확인하기 위해

다음과 같은 최적화 전략들을 실험하고자 한다.

<br/><br/>

1. 인덱스 여부에 따른 검색 속도 향상

[Optimizer 中 인덱스 여부에 따른 검색 속도 향상](https://ikadnorth.tistory.com/225)

2. 캐싱에 따른 검색 속도 향상

[Optimizer 中 캐싱에 따른 검색 속도 향상](https://ikadnorth.tistory.com/230)

3. 인덱스에 따른 삽입 속도 저하

[Optimizer 中 인덱스에 따른 삽입 속도 저하](https://ikadnorth.tistory.com/226)

4. 반정규화에 의한 통계 쿼리 실행 속도 향상

[Optimizer 中 반정규화에 의한 통계 쿼리 실행 속도 향상](https://ikadnorth.tistory.com/227)

5. N+1 문제 해결 시 검색 속도 향상

[Optimizer 中 N+1 문제 해결 시 검색 속도 향상](https://ikadnorth.tistory.com/228)

6. Projection 연산 적용 시 검색 속도 향상
[](https://ikadnorth.tistory.com/229)

[Optimizer 中 Projection 연산 적용 시 검색 속도 향상](https://ikadnorth.tistory.com/229)
