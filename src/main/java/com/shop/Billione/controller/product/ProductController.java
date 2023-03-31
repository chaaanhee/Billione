package com.shop.Billione.controller.product;

import com.shop.Billione.dto.product.ProductDTO;
import com.shop.Billione.entity.ProductEntity;
import com.shop.Billione.repository.ProductRepository;
import com.shop.Billione.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor // 생성자 주입
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public String detailPage(){
        return "/customer/product/productDetailTest";
    }

    /*상품 디테일 페이지*/
    @GetMapping("/{productNo}")
    public String product(@PathVariable("productNo") Long productNo, Model model){
        ProductEntity product = productRepository.findById(productNo).get();
        model.addAttribute("product", product);
        return "/customer/product/product-detail";
    }

}
