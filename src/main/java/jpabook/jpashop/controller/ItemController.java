package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Item controller.
 */
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /**
     * Create form string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/items/new")
    public String createForm(final Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    /**
     * Create string.
     *
     * @param form          the form
     * @param bindingResult the binding result
     * @return the string
     */
    @PostMapping("/items/new")
    public String create(@ModelAttribute("form") @Valid final BookForm form,
                         final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "items/createItemForm";
        }
        Book book = Book.createBook(form);
        itemService.saveItme(book);
        return "redirect:/";
    }
    @GetMapping("/items")
    public String list(Model model){
        model.addAttribute("items", itemService.findItmes());
        return "items/itemList";
    }
}
