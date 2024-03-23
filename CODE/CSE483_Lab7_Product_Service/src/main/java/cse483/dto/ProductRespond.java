package cse483.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRespond {
    private String productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private Inventory inventory;
}
