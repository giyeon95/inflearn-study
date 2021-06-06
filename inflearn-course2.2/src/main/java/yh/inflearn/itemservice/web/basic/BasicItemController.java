package yh.inflearn.itemservice.web.basic;

import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yh.inflearn.itemservice.domain.item.Item;
import yh.inflearn.itemservice.domain.item.ItemRepository;
import yh.inflearn.itemservice.domain.item.ItemUpdateDTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/item";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("item") Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("isSave", true); // ?isSave=true
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/add")
    public String addItem() {
        return "/basic/addForm";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "/basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String editForm(@ModelAttribute("item") Item item, Model model) {
        itemRepository.update(item.getId(), ItemUpdateDTO.builder()
            .itemName(item.getItemName())
            .price(item.getPrice())
            .quantity(item.getQuantity())
            .build());

        return "redirect:/basic/item/{itemId}";
    }


    /**
     * 테스트용 데이터
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}

