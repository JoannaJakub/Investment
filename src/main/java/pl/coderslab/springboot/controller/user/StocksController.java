package pl.coderslab.springboot.controller.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springboot.excel.UserStocksExcelExporter;
import pl.coderslab.springboot.model.*;
import pl.coderslab.springboot.repository.*;
import pl.coderslab.springboot.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String processAddingStocks(@Valid Ownedstocks ownedstocks, BindingResult result) {
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
    @RequestMapping("/stocksConfirmDelete")
    public String stocksConfirmDelete() {
        return "user/yourStock/stocksConfirmDelete";
    }

    @GetMapping(value = {"/stocksDelete/{id}"})
    public String stocksDelete(@PathVariable long id) {
        ownedstocksRepository.deleteById(id);
        return "redirect:/yourStocks";
    }

    @GetMapping(value = {"/allStocksDetails/{id}"})
    public String allStocksDetails(@PathVariable long id, Model model) {
        Optional<Stocks> stocks = stocksRepository.findById(id);
        if (stocks.isPresent()) {
            model.addAttribute("allStocksDetails", stocks.get());
        }
        else{ return "user/userError";}
        return "user/yourStock/allStocksDetails";
    }

    @GetMapping("/usersStocks/export/excel")
    public void usersStocksExportToExcel(HttpServletResponse response, @AuthenticationPrincipal UserDetails customUser) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=stocks_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);


        String entityUser = customUser.getUsername();
        User user = userRepository.findByUsername(entityUser);
        List<Ownedstocks> ownedstocks = ownedstocksRepository.findByUser(user);


        UserStocksExcelExporter excelExporter = new UserStocksExcelExporter(ownedstocks);

        excelExporter.export(response);
    }
}





