### API 개발 고급 - 지연로딩과 조회 성능 최적화
#### 간단한 주문 조회 V2: 엔티티를 DTO로 변환

ORDER -> SQL 1번 -> 결과 주문수 2개
루프가 돌때
MEMBER 1번
DELIVERY 1번
근데 같은 식벽자 일시 한번만 조회하고 그이후는 영속성컨텍스트 1차캐시에서 가져와 쿼리가 나가지 않는다. 

![image](https://user-images.githubusercontent.com/40969203/106753624-40d47300-666f-11eb-8af9-a196fe25d085.png)
![image](https://user-images.githubusercontent.com/40969203/106753633-4467fa00-666f-11eb-899a-55f2de618e63.png)
