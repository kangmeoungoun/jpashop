### 상품주문

##### controller -> service 식별할수 있는 식별자id 값만 넘긴다. controller 에서 식별자아이디 조회후 엔티티 객체를 넘겨도 트랜잭션 처리 상태에서 조회하지 않았기때문에영속성 컨텍스트에서 관리를 하지 않는다.

![image](https://user-images.githubusercontent.com/40969203/105042973-41cea780-5aa8-11eb-8be6-a860217f31d5.png)
![image](https://user-images.githubusercontent.com/40969203/105042986-45622e80-5aa8-11eb-8a8d-7b86b130232d.png)
![image](https://user-images.githubusercontent.com/40969203/105042999-498e4c00-5aa8-11eb-9a18-8b327bceb475.png)
![image](https://user-images.githubusercontent.com/40969203/105043022-501cc380-5aa8-11eb-9f3b-26c4921843a3.png)
![image](https://user-images.githubusercontent.com/40969203/105043028-527f1d80-5aa8-11eb-912b-76ae9fcc7d59.png)
![image](https://user-images.githubusercontent.com/40969203/105043042-557a0e00-5aa8-11eb-8543-e96de1314afe.png)
