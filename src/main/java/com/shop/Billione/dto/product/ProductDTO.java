package com.shop.Billione.dto.product;

import lombok.*;

import java.sql.Timestamp;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productNo;
    private Integer categoryNo;
    private String pName;
    private Integer pPrice;
    private Integer pCost;
    private Integer pDiscount;
    private Integer pRate;
    private Timestamp pUpdated;
    private Integer pQty;
    private String pDesc;
    private String pShortDesc;
    private String pStockStatus;
    private String pThumbnail;
    private String pSize;
    private String pColor;


}
