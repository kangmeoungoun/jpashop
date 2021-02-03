### API 개발 고급 - 지연로딩과 조회 성능 최적화
#### 간단한 주문 조회 V3: 엔티티를 DTO로 변환 - 페치 조인 최적화

LEFT JOIN FETCH
JOIN FETCH
둘다 가능
FETCH 할시 fetch = FetchType.LAZY 무시하고 한방에 다가져와 서 쿼리 한번만 실행된다.
![image](https://user-images.githubusercontent.com/40969203/106755510-8eea7600-6671-11eb-9f21-8dd581fe12ba.png)
![image](https://user-images.githubusercontent.com/40969203/106755522-93169380-6671-11eb-9308-0237d081cd34.png)
