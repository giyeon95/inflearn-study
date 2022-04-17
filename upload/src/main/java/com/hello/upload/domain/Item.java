package com.hello.upload.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
