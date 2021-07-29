package pl.coderslab.springboot.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springboot.model.Ownedcryptocurrencies;
import pl.coderslab.springboot.model.Ownedstocks;
import pl.coderslab.springboot.model.Stocks;
import pl.coderslab.springboot.repository.OwnedstocksRepository;
import pl.coderslab.springboot.repository.StocksRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminStocksController {
    private final StocksRepository stocksRepository;
    private final OwnedstocksRepository ownedstocksRepository;

    public AdminStocksController(StocksRepository stocksRepository, OwnedstocksRepository ownedstocksRepository) {
        this.stocksRepository = stocksRepository;
        this.ownedstocksRepository = ownedstocksRepository;
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

    @GetMapping("usersOwnedStocks")
    public String usersOwnedStocks(Model model) {
        List<Ownedstocks> ownedstocks = ownedstocksRepository.findAll();
        model.addAttribute("usersStocks", ownedstocks);
        return "admin/stocks/usersOwnedStocks";
    }
    @RequestMapping("/usersOwnedStocksConfirmDelete")
    public String usersOwnedStocksConfirmDelete() {
        return "admin/stocks/usersOwnedStocksConfirmDelete";
    }

    @GetMapping(value = {"/usersOwnedStocksDelete/{id}"})
    public String usersOwnedStocksDelete(@PathVariable long id) {
        ownedstocksRepository.deleteById(id);
        return "redirect:/usersOwnedStocks";
    }

    @GetMapping(value = {"/usersOwnedStocksEdit/{id}"})
    public String usersOwnedStocksEditForm(@PathVariable long id, Model model) {
        model.addAttribute("adminUsersStocksEdit", ownedstocksRepository.findById(id));
        return "admin/stocks/usersOwnedStocksEdit";
    }

    @PostMapping(value = {"usersOwnedStocksEdit/{id}"})
    public String usersOwnedStocksEditSave(@Valid Ownedstocks ownedstocks) {
        ownedstocksRepository.save(ownedstocks);
        return "redirect:/usersOwnedStocksConfirmEditing/{id}";
    }

    @RequestMapping("/usersOwnedStocksConfirmEditing/{id}")
    public String usersOwnedStocksConfirmEditing(@PathVariable long id, Model model) {
        Optional<Ownedstocks> stocks = ownedstocksRepository.findById(id);
        if (stocks.isPresent()) {
            model.addAttribute("adminUsersStocksEdit", stocks.get());
        } else {
            return "admin/adminError";
        }
        return "admin/stocks/usersOwnedStocksConfirmEdit";
    }
    @GetMapping(value = {"/usersOwnedStocksDetails/{id}"})
    public String usersOwnedStocksDetails(@PathVariable long id, Model model) {
        Optional<Ownedstocks> stocksDetails = ownedstocksRepository.findById(id);
        if (stocksDetails.isPresent()) {
            model.addAttribute("adminUsersStocksDetails", stocksDetails.get());
        }
        else{ return "admin/adminError";
        }
        return "admin/stocks/usersOwnedStocksDetails";
    }
    @GetMapping(value = {"/oneStocksUser/{id}"})
    public String oneStocksUser(@PathVariable long id, Model model) {
        List<Ownedstocks> oneStocksUser = ownedstocksRepository.findUserByStocksId(id);
        model.addAttribute("oneStocksUser", oneStocksUser);
        return "admin/stocks/oneStocksUser";
    }
}
