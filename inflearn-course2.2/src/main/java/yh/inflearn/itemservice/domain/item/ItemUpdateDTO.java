package yh.inflearn.itemservice.domain.item;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ItemUpdateDTO {
    private final String itemName;
    private final Integer price;
    private final Integer quantity;

}
