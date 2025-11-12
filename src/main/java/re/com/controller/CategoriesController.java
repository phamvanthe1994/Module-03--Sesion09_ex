package re.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.com.model.Categories;
import re.com.service.CategoriesService;

import java.util.List;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/findAll")
    public String findAllCategories(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) {

        List<Categories> listCategories = categoriesService.findByPage(page, size);
        long total = categoriesService.countAll();
        int totalPages = (int) Math.ceil((double) total / size);
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "categories";

    }

    @GetMapping("initCreate")
    public String initCreateCatalog(Model model) {
        Categories catalog = new Categories();
        model.addAttribute("catalog", catalog);
        return "newCatalog";
    }

    @PostMapping("create")
    public String createCatalog(Categories catalog) {
        boolean result = categoriesService.save(catalog);
        if (result) {
            return "redirect:findAll";
        }
        return "error";

    }
}
