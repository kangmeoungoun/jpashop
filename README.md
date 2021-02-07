### API 개발 고급 - 컬렉션 조회 최적화
#### 주문 조회 V3:엔티티를 DTO 로 변환-페치 조인 최적화
```
fetch join 시 distinct : id 값이 같으면 중복 제거 애플리케이션 까지 같고 와서 한번더 중복제거.
1:다 FETCH 할시 페이징 처리 불가능
```

![image](https://user-images.githubusercontent.com/40969203/107144033-bd22cb00-697b-11eb-8ef4-5cd70e6d0624.png)
![image](https://user-images.githubusercontent.com/40969203/107144034-bf852500-697b-11eb-8a69-6773a3d77c8d.png)
![image](https://user-images.githubusercontent.com/40969203/107144035-c1e77f00-697b-11eb-9668-f6cd760ddd21.png)

 