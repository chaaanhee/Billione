package com.shop.Billione.repository;

import com.shop.Billione.entity.MemberEntity;
import com.shop.Billione.entity.ProductEntity;
import com.shop.Billione.vo.ProductVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
