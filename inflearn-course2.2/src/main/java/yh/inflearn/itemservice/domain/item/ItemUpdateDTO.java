package yh.inflearn.itemservice.domain.item;


import java.util.List;
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

    private final Boolean open; // 판매여부
    private final List<String> regions; // 등록 지역
    private final ItemType itemType; // 상품 종류
    private final String deliveryCode; // 배송 방법
}
