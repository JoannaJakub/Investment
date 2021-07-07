package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.model.Storage;
import pl.coderslab.springboot.repository.StocksRepository;

import javax.validation.Valid;
import java.util.List;

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
}
