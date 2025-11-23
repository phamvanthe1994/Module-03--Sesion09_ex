package re.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.com.dto.request.ProductDto;
import re.com.dto.request.UpdateProductDto;
import re.com.model.Categories;
import re.com.service.CategoriesService;
import re.com.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        model.addAttribute("listProduct", productService.findAll());
        return "products";
    }

    @GetMapping("/initCreate")
    public String initCreateProduct(Model model) {
        List<Categories> listCategories = categoriesService.findAll();
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("listCategories", listCategories);
        return "newProduct";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newProduct";
        }
        boolean result = productService.addProduct(productDto);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
    public String initUpdateProduct(Model model, String productId) {
        UpdateProductDto updateProductDto = productService.findById(productId);
        model.addAttribute("updateProductDto", updateProductDto);
        model.addAttribute("listCategories", categoriesService.findAll());
        return "updateProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("updateProductDto") UpdateProductDto updateProductDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateProduct";
        }
        boolean result = productService.updateProduct(updateProductDto);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }


    @GetMapping("/delete")
    public String deleteProduct(String productId) {
        boolean result = productService.deleteProduct(productId);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
}
