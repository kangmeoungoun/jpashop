### API 개발 고급 - 지연로딩과 조회 성능 최적화
#### 간단한 주문 조회 V4 : JPA 에서 DTO로 바로 조회

DTO 는 엔티티를 참조해도 괜찮다.
의존관계는 한방향 으로 흘려야 된다.
CONTORLLER -> SERVICE -> REPOSITORY (O)
REPOSITORY -> CONTROLLER (X)
em.createQuery(반환값은 엔티티와 값타입만 가능하다. new Operation 사용시 dto 가능)

![image](https://user-images.githubusercontent.com/40969203/106822928-655a3a80-66c3-11eb-8f39-f1eb68da257a.png)
![image](https://user-images.githubusercontent.com/40969203/106822937-68edc180-66c3-11eb-95fa-55a3c1ca0bc0.png)
![image](https://user-images.githubusercontent.com/40969203/106822942-6be8b200-66c3-11eb-9ef0-24071535e86f.png)
![image](https://user-images.githubusercontent.com/40969203/106822949-7014cf80-66c3-11eb-8944-39beaae9e6a4.png)
![image](https://user-images.githubusercontent.com/40969203/106822957-74d98380-66c3-11eb-9611-81df729f9579.png)
