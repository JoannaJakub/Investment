package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.repository.StocksRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminStocksController {
    private final StocksRepository stocksRepository;

    public AdminStocksController(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
    }


    @GetMapping("adminStocks")
    public String stocks(Model model) {
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("adminStocks", stocks);
        return "admin/stocks/adminStocks";
    }
    @GetMapping("/adminAddStocks")
    public String adminAddStocks(Model model) {
        model.addAttribute("adminAddStocks", new Stocks());
        return "admin/stocks/addStocks";
    }
    @PostMapping(value = "/adminStocksSuccess")
    public String processAdminStocksSuccess(@Valid Stocks stocks, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/stocks/adminAddStocks";
        } else {
            stocksRepository.save(stocks);
            return "admin/stocks/stocksSuccess";
        }
    }

    @RequestMapping("/stocksConfirmDelete")
    public String stocksConfirmDelete() {
        return "admin/stocks/stocksConfirmDelete";
    }

    @GetMapping(value = {"/stocksDelete/{id}"})
    public String stocksDelete(@PathVariable long id) {
        stocksRepository.deleteById(id);
        return "redirect:/adminStocks";
    }

    @GetMapping(value = {"/stocksDetails/{id}"})
    public String stocksDetails(@PathVariable long id, Model model) {
        Optional<Stocks> stocksDetails = stocksRepository.findById(id);
        if (stocksDetails.isPresent()) {
            model.addAttribute("stocksDetails", stocksDetails.get());
        }
        else{ return "admin/adminError";
        }
        return "admin/stocks/stocksDetails";
    }
}
