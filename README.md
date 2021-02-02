### API 개발 기본
#### 회원 조회 API

```java
@JsonIgnore //컬럼에 줄시 리턴시에  빠진다
@GetMapping("/api/v2/members")
public Result<List<MemberDto>> memberV2(){
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
        .map(m -> new MemberDto(m.getName() , m.getAddress()))
        .collect(Collectors.toList());
        
                        //타입추론 
        return new Result(collect,collect.size());
        }
@Data
@AllArgsConstructor
static class Result<T> {
    private T data;
    private int count;
}
@Data
@AllArgsConstructor
static class MemberDto {
    private String name;
    private Address address;
}
```
```json
[
  {},
  {}
]
///처음부터 배열로 할시 유연성이 확떨어진다. 밑에처럼 할시 확장 용이하다.
{
  "count": 2
  "data": [
    {},
    {}
  ]
}
```
![image](https://user-images.githubusercontent.com/40969203/106608344-a2310f00-65a7-11eb-8380-5cec01bbaa90.png)
![image](https://user-images.githubusercontent.com/40969203/106608359-a6f5c300-65a7-11eb-86a2-9ff8d0a833fc.png)
![image](https://user-images.githubusercontent.com/40969203/106608371-ab21e080-65a7-11eb-87ef-490342b507e4.png)
![image](https://user-images.githubusercontent.com/40969203/106608381-aeb56780-65a7-11eb-9b28-a268418c520f.png)

