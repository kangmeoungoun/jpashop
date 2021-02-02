### API 개발 고급 -준비
#### 조회용 샘플 데이터 입력
```java
//InitDb 안에 inner 클래스로 구현

@PostConstruct
public void init(){
        initService.dbInit1();
        initService.dbInit2();
        }
//InitDb 에 바로 하면 스프링 라이프사이클로 인해 트랜잭션이  안먹힌다고 한다.별도은 빈으로 등록해서 사용.
```
![image](https://user-images.githubusercontent.com/40969203/106677105-80617780-65fb-11eb-8719-99ba0d600910.png)
![image](https://user-images.githubusercontent.com/40969203/106677113-835c6800-65fb-11eb-9ce2-7fe59fdf49ff.png)
![image](https://user-images.githubusercontent.com/40969203/106677118-86efef00-65fb-11eb-8917-e482b5d11fa7.png)
![image](https://user-images.githubusercontent.com/40969203/106677125-89524900-65fb-11eb-992e-118206194395.png)
![image](https://user-images.githubusercontent.com/40969203/106677132-8d7e6680-65fb-11eb-9684-5f06fd3ac8f2.png)
