### 변경 감지와 병합(merge)

##### 준영속 entity
```java
    Book book = new Book();
    book.setId(form.getId());
    //이때 book 가 준영속 엔티티
    //jpa 가 식별 할수 있는 아이디를 가지고 있을때
    //jpa 가 관리하지 않는다. 변경감지가 일어나지 않는다.

```
##### 변경감지 == dirty checking ,권장
    - 트랜잭션 커밋 시점에 flush 를 날린다. 영속성 entity 에서 변경된 에들 찾아서 update쿼리 날린다.
```java
 @Transactional
    public void updateItem(Long itemId, int price , String name,int stockQuantity){
        Item findItem = itemRepository.findOne(itemId);
        findItem.itemChange(price,name,stockQuantity);
    }
```
    -  업데이트 문은 전부 다 일어 나지 만 변경된 변경되지 않은 기존값 들은 기존값 그대로 유지하고 변경된 값들만 
        변경된다.
##### merge
    - merge(book) -> 1차 캐시 엔티티 찾기 없으면 DB 조회 mergeBook 를 영속상태로 만듦
      mergeBook 필드를 book 에서 가져온 필드로 전부 바꿔치기 후 mergeBook 리턴
      book 는 영속성 컨텍스트 관리하지 않고 리턴받은 mergeBook 이 관리된다.
      모든 필드 속성이 전부 변경된다.

##### merge 를 사용하지 말고 변경감지를 사용해야한다.

##### 변경도 Entity 레벨에서 하기 setter 사용하지 말기
``` java
       public void updateItem(Long itemId, Book param){
            Item findItem = itemRepository.findOne(itemId);
            findItem.setPrice(param.getPrice());
            findItem.setName(param.getName());
            findItem.setStockQuantity(param.getStockQuantity());
            //이런식으로 설계 역추정 가능하도록 여기서 바뀌는구나 알수 있게.
            findItem.change(int price,String name,int quantity);
        }
```
![image](https://user-images.githubusercontent.com/40969203/105039166-91f73b00-5aa3-11eb-86d9-272e1a524f7f.png)
![image](https://user-images.githubusercontent.com/40969203/105039174-958ac200-5aa3-11eb-88ff-f1daff9c68e9.png)
![image](https://user-images.githubusercontent.com/40969203/105039195-9a4f7600-5aa3-11eb-8171-24189c9e558c.png)
![image](https://user-images.githubusercontent.com/40969203/105039212-a0dded80-5aa3-11eb-91e4-cd7541e7ad00.png)
![image](https://user-images.githubusercontent.com/40969203/105039232-a63b3800-5aa3-11eb-82b1-5301f86c763e.png)
![image](https://user-images.githubusercontent.com/40969203/105039251-aaffec00-5aa3-11eb-8a17-f81d923f06ad.png)
![image](https://user-images.githubusercontent.com/40969203/105039264-afc4a000-5aa3-11eb-8f66-a4bc538cba58.png)
![image](https://user-images.githubusercontent.com/40969203/105039280-b4895400-5aa3-11eb-8e94-5d6d7bc4af8c.png)
![image](https://user-images.githubusercontent.com/40969203/105039294-b8b57180-5aa3-11eb-9f94-7ea0f99737e5.png)
