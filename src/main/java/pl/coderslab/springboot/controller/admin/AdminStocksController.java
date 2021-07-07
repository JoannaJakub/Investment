package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.repository.StocksRepository;

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

}
