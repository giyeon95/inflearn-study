package yh.inflearn.itemservice.domain.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new ConcurrentHashMap<>();
    private static AtomicLong sequenceAtomic = new AtomicLong(0L);

    public Item save(Item item) {
        item.setId(sequenceAtomic.addAndGet(1L));
        store.put(item.getId(), item);
        return item;
    }

    public List<Item> saveAll(Item... items) {
        List<Item> saveItems = new ArrayList<>();
        for (Item item : items) {
            saveItems.add(save(item));
        }
        return saveItems;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, ItemUpdateDTO itemUpdateDTO) {
        Item findItem = findById(id);

        findItem.setItemName(itemUpdateDTO.getItemName());
        findItem.setPrice(itemUpdateDTO.getPrice());
        findItem.setQuantity(itemUpdateDTO.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }

}
