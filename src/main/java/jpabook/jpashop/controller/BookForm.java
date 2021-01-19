package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BookForm{
    private Long id;
    @NotEmpty( message = "상품명 은 필수 입니다.")
    private String name;
    @Range(min = 0,max = 99_999_999,message = "0~99,999,999 사이만 입력할 수 있습니다.")
    private int price;
    @Range(min = 0,max = 99_999_999,message = "0~99,999,999 사이만 입력할 수 있습니다.")
    private int stockQuantity;
    @NotEmpty( message = "저자 는 필수 입니다.")
    private String author;
    @NotEmpty( message = "isbn 은 필수 입니다.")
    private String isbn;
}
