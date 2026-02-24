package bookstrore.hw.web;

import bookstrore.hw.domain.Category;
import bookstrore.hw.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

  private final CategoryRepository categoryRepository;

  CategoryController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  // List all categories from db
  @GetMapping("/categories")
  public String getCategories(Model model) {

    model.addAttribute("categories", categoryRepository.findAll());

    return "categorylist"; // categorylist.html
  }

  // Save a new Category
  @PostMapping("/savecategory")
  public String saveCategory(Category category) {

    categoryRepository.save(category);

    return "redirect:/categories"; // categorylist.html
  }

  // Add a new Category
  @RequestMapping("/addcategory")
  public String addCategory(Model model) {

    model.addAttribute("category", new Category());

    return "addCategory"; // addCategory.html
  }
}
