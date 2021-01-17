package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService{
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItme(Item item){
        itemRepository.save(item);
    }
    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

    public List<Item> findItmes(){
        return itemRepository.findALl();
    }

}