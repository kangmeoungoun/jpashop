package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class ItemUpdateTest{
    @Autowired
    EntityManager em;

    @Test
    void updateTest() throws Exception{
        //given
        Book book = em.find(Book.class , 1L);
        //when
        book.setName("asdfe");

        //변경감지 == dirty checking
        //then

    }
}
