package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.repository.StocksRepository;
import pl.coderslab.springboot.service.StocksService;

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
        return "admin/stocks/adminAddStocks";
    }

    @PostMapping(value = "/adminStocksSuccess")
    public String processAdminStocksSuccess(@Valid Stocks stocks, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/stocks/adminAddStocks";
        } else {
            stocksRepository.save(stocks);
            return "admin/stocks/adminStocksSuccess";
        }
    }

    @RequestMapping("/adminStocksConfirmDelete")
    public String adminStocksConfirmDelete() {
        return "admin/stocks/adminStocksConfirmDelete";
    }

    @GetMapping(value = {"/adminStocksDelete/{id}"})
    public String adminStocksDelete(@PathVariable long id) {
        stocksRepository.deleteById(id);
        return "redirect:/adminStocks";
    }

    @GetMapping(value = {"/adminStocksEdit/{id}"})
    public String adminStocksEditForm(@PathVariable long id, Model model) {
        model.addAttribute("adminStocksEdit", stocksRepository.findById(id));
        return "admin/stocks/adminStocksEdit";
    }

    @PostMapping(value = {"adminStocksEdit/{id}"})
    public String adminStocksEditSave(@Valid Stocks stocks) {
        stocksRepository.save(stocks);
        return "redirect:/adminStocksConfirmEditing/{id}";
    }

    @RequestMapping("/adminStocksConfirmEditing/{id}")
    public String adminStocksConfirmEditing(@PathVariable long id, Model model) {
        Optional<Stocks> stocks = stocksRepository.findById(id);
        if (stocks.isPresent()) {
            model.addAttribute("adminStocksConfirmEdit", stocks.get());
        } else {
            return "admin/adminError";
        }
        return "admin/stocks/adminStocksConfirmEdit";
    }

    @GetMapping(value = {"/adminStocksDetails/{id}"})
    public String adminStocksDetails(@PathVariable long id, Model model) {
        Optional<Stocks> stocksDetails = stocksRepository.findById(id);
        if (stocksDetails.isPresent()) {
            model.addAttribute("adminStocksDetails", stocksDetails.get());
        }
        else{ return "admin/adminError";
        }
        return "admin/stocks/adminStocksDetails";
    }
    @RequestMapping(value = {"/stockApi"})
    public String stockApi(Model model) {
        StocksService stockService = new StocksService();

        String stock = String.valueOf(stockService.findStock("GOOG").getStock().getStats());
        String stock1 = String.valueOf(stockService.findStock("GOOG").getStock().getQuote().getBid());
        model.addAttribute("stockAPI", stock);
        System.out.println(stock + stock1);
          return "admin/stocks/stockApi";
    }
}
