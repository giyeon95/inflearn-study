package yh.inflearn.itemservice.domain.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemType {

    BOOD("도서"), FOOD("음식"), ETC("기타");

    private final String description;

}
