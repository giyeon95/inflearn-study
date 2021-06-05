package yh.inflearn.itemservice.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yh.inflearn.itemservice.domain.item.ItemUpdateDTO.ItemUpdateDTOBuilder;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();


    @BeforeEach
    void beforeEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);
        Item item3 = new Item("itemC", 30000, 30);

        List<Item> saveItems = itemRepository.saveAll(item1, item2, item3);

        //when
        List<Item> findAllItems = itemRepository.findAll();

        //then
        assertThat(findAllItems.size()).isEqualTo(saveItems.size());
        assertThat(findAllItems).contains(item1, item2, item3);

    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("itemA", 10000, 10);
        Item saveItem = itemRepository.save(item);
        Long itemId = saveItem.getId();

        //when
        ItemUpdateDTO updateDto = ItemUpdateDTO.builder()
            .itemName("updateItemName")
            .price(20000)
            .quantity(3)
            .build();
        itemRepository.update(itemId, updateDto);

        //then
        Item resultItem = itemRepository.findById(itemId);
        assertThat(resultItem.getId()).isEqualTo(itemId);
        assertThat(resultItem.getItemName()).isEqualTo(updateDto.getItemName());
        assertThat(resultItem.getPrice()).isEqualTo(updateDto.getPrice());
        assertThat(resultItem.getQuantity()).isEqualTo(updateDto.getQuantity());


    }
}