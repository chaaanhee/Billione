package com.shop.Billione.service.admin;

import com.shop.Billione.dto.member.RegisterDTO;
import com.shop.Billione.dto.product.ProductDTO;
import com.shop.Billione.entity.MemberEntity;
import com.shop.Billione.entity.ProductEntity;
import com.shop.Billione.vo.ProductVO;

import java.util.List;

public interface ProductService {
    public List<ProductEntity> findProduct();
}
