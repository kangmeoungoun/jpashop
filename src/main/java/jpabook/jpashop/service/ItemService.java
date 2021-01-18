package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Item service.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService{
    private final ItemRepository itemRepository;

    /**
     * Save itme.
     * 아이템 저장
     * @param item the item
     */
    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    /**
     * Find one item.
     *
     * @param itemId the item id
     * @return the item
     */
    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

    /**
     * Find itmes list.
     *
     * @return the list
     */
    public List<Item> findItems(){
        return itemRepository.findALl();
    }

}
