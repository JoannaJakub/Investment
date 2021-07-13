package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.model.*;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class StocksController {
    private final StocksRepository stocksRepository;
    private final OwnedstocksRepository ownedstocksRepository;
    private final StorageRepository storageRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public StocksController(StocksRepository stocksRepository, OwnedstocksRepository ownedstocksRepository, StorageRepository storageRepository, UserRepository userRepository, UserService userService) {
        this.stocksRepository = stocksRepository;
        this.ownedstocksRepository = ownedstocksRepository;
        this.storageRepository = storageRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @RequestMapping("/yourStocks")
    public String yourStocks(Model model, @AuthenticationPrincipal UserDetails customUser) {
        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        List<Ownedstocks> ownedStocks = ownedstocksRepository.findByUser(user);
        model.addAttribute("ownedStocks", ownedStocks);
        return "user/yourStock/yourStocks";
    }

    @GetMapping("/addStocks")
    public String addStocks(Model model, Authentication authentication) {
        model.addAttribute("ownedStocks", new Ownedstocks());
        model.addAttribute("stocks", stocksRepository.findAll());
        model.addAttribute("storage", storageRepository.findAll());
       model.addAttribute("user", userService.findByUserName(authentication.getName()));
        return "user/yourStock/addStocks";
    }

    @PostMapping(value = "/stocksSuccess")
    public String processAddingStocks(@Valid Ownedstocks ownedstocks, BindingResult result
            , @AuthenticationPrincipal UserDetails customUser) {
        if (result.hasErrors()) {
            return "user/yourStock/addStocks";
        }
        ownedstocksRepository.save(ownedstocks);
        return "user/yourStock/stocksSuccess";
    }

    @GetMapping("/allStocks")
    public String allStocks(Model model) {
        List<Stocks> stocks = stocksRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "user/yourStock/allStocks";
    }
    @GetMapping(value = {"/stocksDetails/{id}"})
    public String storageDetails(@PathVariable long id, Model model) {
        Optional<Ownedstocks> stocksDetails = ownedstocksRepository.findById(id);
        if (stocksDetails.isPresent()) {
            model.addAttribute("stocksDetails", stocksDetails.get());
        }
        else{ return "user/userError";}
        return "user/yourStock/stocksDetails";
    }

    @GetMapping(value = {"/stocksEdit/{id}"})
    public String stocksEditForm(@PathVariable long id, Model model) {
        model.addAttribute("stocksEdit", ownedstocksRepository.findById(id));
        return "user/yourStock/stocksEdit";
    }

    @PostMapping(value = {"stocksEdit/{id}"})
    public String stocksEditSave(@Valid Ownedstocks ownedstocks) {
        ownedstocksRepository.save(ownedstocks);
        return "redirect:/stocksConfirmEditing/{id}";
    }

    @RequestMapping("/stocksConfirmEditing/{id}")
    public String stocksConfirmEditing(@PathVariable long id, Model model) {
        Optional<Ownedstocks> stocks = ownedstocksRepository.findById(id);
        if (stocks.isPresent()) {
            model.addAttribute("stocksConfirmEdit", stocks.get());
        } else {
            return "user/userError";
        }
        return "user/yourStock/stocksConfirmEdit";
    }
}





