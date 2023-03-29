package com.shop.Billione.entity;

import com.shop.Billione.dto.member.RegisterDTO;
import com.shop.Billione.dto.product.ProductDTO;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@DynamicInsert
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNo;
    @Column(length = 30, nullable = false)
    private Integer categoryNo;
    @Column(length = 50, nullable = false)
    private String pName;
    @Column(length = 3)
    private Integer pRate;
    @Column(length = 30, nullable = false)
    private Integer pPrice;
    @Column(length = 30)
    private Integer pCost;
    @Column(length = 30)
    private Integer pDiscount;
    @CreationTimestamp
    @Column(nullable = false,  columnDefinition = "TIMESTAMP DEFAULT now()")
    private Timestamp pUpdated;
    @ColumnDefault("0")
    @Column(length = 1)
    private Integer pQty;
    @Column(length = 150, nullable = false)
    private String pDesc;
    @Column(length = 50)
    private String pShortDesc;
    @ColumnDefault("'Sale'")
    @Column(length = 10)
    private String pStockStatus;
    @Column(length = 100, nullable = false)
    private String pThumbnail;
    @ColumnDefault("'Free'")
    @Column(length = 10)
    private String pSize;
    @Column(length = 20)
    private String pColor;
    @ColumnDefault("'N'")
    @Column(length = 1)
    private String pDeleted;

}
