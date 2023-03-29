package com.shop.Billione.controller.product;

import com.shop.Billione.entity.ProductEntity;
import com.shop.Billione.repository.ProductRepository;
import com.shop.Billione.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
@Log4j2
@RequiredArgsConstructor // 생성자 주입
public class CategoryController {
    @Autowired
    private ProductRepository productRepository;
    ProductService productService;

    /*카테고리 페이지*/
    @GetMapping("")
    public String category(Model model){
        model.addAttribute("category", productRepository.findAll());
        return "/customer/product/productList";
    }

}
