package com.shop.Billione.service.admin;

import com.shop.Billione.dto.product.ProductDTO;
import com.shop.Billione.entity.MemberEntity;
import com.shop.Billione.entity.ProductEntity;
import com.shop.Billione.repository.ProductRepository;
import com.shop.Billione.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


}
