package glassgate.controller;

import glassgate.domain.Basecurrency;
import glassgate.domain.Lot;
import glassgate.domain.User;
import glassgate.repository.BasecurrencyRepo;
import glassgate.repository.LotRepo;
import glassgate.service.CurrentExchangeRateService;
import glassgate.service.HtmlExchangeRatesParserService;
import glassgate.service.LotService;
import glassgate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class AdminpanelController {

    @Autowired
    private CurrentExchangeRateService exchange;

    @Autowired
    private HtmlExchangeRatesParserService parser;

    @Autowired
    private LotService lotService;

    @Autowired
    private UserService userService;

    @Autowired
    private BasecurrencyRepo basecurrencyRepo;

    @Autowired
    private LotRepo lotRepo;

    private String uploadPath;

    Date lotfulfillmentdeadlinedate = new Date(System.currentTimeMillis() + (120 * 3600 * 1000));
    Double usd;
    Double minfinUsd;
    Double goverlaUsd;
    Double bankUsd;
    Double euro;
    Double minfinEuro;
    Double goverlaEuro;
    Double bankEuro;

    private void parserExchange() {
        usd = exchange.usd();
        minfinUsd = parser.minfinusd();
        goverlaUsd = parser.goverlausd();
        bankUsd = parser.bankusd();
        euro = exchange.euro();
        minfinEuro = parser.minfineuro();
        goverlaEuro = parser.goverlaeuro();
        bankEuro = parser.bankeuro();
    }

    @GetMapping("/adminpanel/uk/buy/uah/activeperiodends")
    public String ukbuyuahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000000000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodends");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/uah/activeperiodbegins")
    public String ukbuyuahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000100000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodbegins");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/uah/new")
    public String ukbuyuaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000200000");
        model.addAttribute("page", page);
        model.addAttribute("url", "new");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/uah/old")
    public String ukbuyuahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000300000");
        model.addAttribute("page", page);
        model.addAttribute("url", "old");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/uah/expensive")
    public String ukbuyuahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000400000");
        model.addAttribute("page", page);
        model.addAttribute("url", "expensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/uah/inexpensive")
    public String ukbuyuahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000500000");
        model.addAttribute("page", page);
        model.addAttribute("url", "inexpensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/uah/fromatoz")
    public String ukbuyuahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000600000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromatoz");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/uah/fromztoa")
    public String ukbuyuahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000700000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromztoa");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/activeperiodends")
    public String ukbuyusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000000000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodends");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/activeperiodbegins")
    public String ukbuyusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000100000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodbegins");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/new")
    public String ukbuyusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000200000");
        model.addAttribute("page", page);
        model.addAttribute("url", "new");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/old")
    public String ukbuyusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000300000");
        model.addAttribute("page", page);
        model.addAttribute("url", "old");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/expensive")
    public String ukbuyusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000400000");
        model.addAttribute("page", page);
        model.addAttribute("url", "expensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/inexpensive")
    public String ukbuyusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000500000");
        model.addAttribute("page", page);
        model.addAttribute("url", "inexpensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/fromatoz")
    public String ukbuyusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000600000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromatoz");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/usd/fromztoa")
    public String ukbuyusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000700000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromztoa");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/activeperiodends")
    public String ukbuyeuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000000000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodends");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/activeperiodbegins")
    public String ukbuyeuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000100000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodbegins");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/new")
    public String ukbuyeurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000200000");
        model.addAttribute("page", page);
        model.addAttribute("url", "new");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/old")
    public String ukbuyeuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000300000");
        model.addAttribute("page", page);
        model.addAttribute("url", "old");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/expensive")
    public String ukbuyeuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000400000");
        model.addAttribute("page", page);
        model.addAttribute("url", "expensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/inexpensive")
    public String ukbuyeuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000500000");
        model.addAttribute("page", page);
        model.addAttribute("url", "inexpensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/fromatoz")
    public String ukbuyeurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000600000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromatoz");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/buy/euro/fromztoa")
    public String ukbuyeurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0000000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0000000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0000000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000700000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromztoa");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/activeperiodends")
    public String uksaleuahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000000000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodends");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/activeperiodbegins")
    public String uksaleuahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000100000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodbegins");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/new")
    public String uksaleuaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000200000");
        model.addAttribute("page", page);
        model.addAttribute("url", "new");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/old")
    public String uksaleuahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000300000");
        model.addAttribute("page", page);
        model.addAttribute("url", "old");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/expensive")
    public String uksaleuahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000400000");
        model.addAttribute("page", page);
        model.addAttribute("url", "expensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/inexpensive")
    public String uksaleuahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000500000");
        model.addAttribute("page", page);
        model.addAttribute("url", "inexpensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/fromatoz")
    public String uksaleuahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000600000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromatoz");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/uah/fromztoa")
    public String uksaleuahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0000000000");
        model.addAttribute("assortment", "0000700000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromztoa");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/activeperiodends")
    public String uksaleusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000000000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodends");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/activeperiodbegins")
    public String uksaleusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000100000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodbegins");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/new")
    public String uksaleusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000200000");
        model.addAttribute("page", page);
        model.addAttribute("url", "new");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/old")
    public String uksaleusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000300000");
        model.addAttribute("page", page);
        model.addAttribute("url", "old");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/expensive")
    public String uksaleusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000400000");
        model.addAttribute("page", page);
        model.addAttribute("url", "expensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/inexpensive")
    public String uksaleusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000500000");
        model.addAttribute("page", page);
        model.addAttribute("url", "inexpensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/fromatoz")
    public String uksaleusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000600000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromatoz");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/usd/fromztoa")
    public String uksaleusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0010000000");
        model.addAttribute("assortment", "0000700000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromztoa");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/activeperiodends")
    public String uksaleeuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000000000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodends");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/activeperiodbegins")
    public String uksaleeuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000100000");
        model.addAttribute("page", page);
        model.addAttribute("url", "activeperiodbegins");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/new")
    public String uksaleeurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000200000");
        model.addAttribute("page", page);
        model.addAttribute("url", "new");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/old")
    public String uksaleeuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000300000");
        model.addAttribute("page", page);
        model.addAttribute("url", "old");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/expensive")
    public String uksaleeuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000400000");
        model.addAttribute("page", page);
        model.addAttribute("url", "expensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/inexpensive")
    public String uksaleeuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000500000");
        model.addAttribute("page", page);
        model.addAttribute("url", "inexpensive");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/fromatoz")
    public String uksaleeurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000600000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromatoz");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/uk/sale/euro/fromztoa")
    public String uksaleeurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page;

        Long id;

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if(preid >= 1000001 && preid <= 4999999){
                id = ((preid - 1000000 + 1) / 2);
            } else{
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndId(id, pageable);
        }else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLottypeAndLotcategory("0100000000", filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLottype("0100000000", pageable);
            }
        }

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "adminpanel");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0100000000");
        model.addAttribute("currency", "0020000000");
        model.addAttribute("assortment", "0000700000");
        model.addAttribute("page", page);
        model.addAttribute("url", "fromztoa");
        model.addAttribute("filter", filter);
        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "adminpanel";
    }

    @GetMapping("/adminpanel/exchange")
    public String adminpanelexchange(Model model) {

        parserExchange();

        model.addAttribute("usd", usd);
        model.addAttribute("minfinUsd", minfinUsd);
        model.addAttribute("goverlaUsd", goverlaUsd);
        model.addAttribute("bankUsd", bankUsd);
        model.addAttribute("euro", euro);
        model.addAttribute("minfinEuro", minfinEuro);
        model.addAttribute("goverlaEuro", goverlaEuro);
        model.addAttribute("bankEuro", bankEuro);

        return "exchange";
    }


    @PostMapping("/adminpanel/exchange")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam Double basecurrencyusdvalue,
            @RequestParam Double basecurrencyeurovalue,
            Map <String, Object> model) {
        Basecurrency basecurrency = new Basecurrency();

        Date date = new Date();

        basecurrency.setBasecurrencyusdvalue(basecurrencyusdvalue);
        basecurrency.setBasecurrencyeurovalue(basecurrencyeurovalue);
        basecurrency.setAuthor(user);
        basecurrency.setBasecurrencydatetime(date);

        model.put("message", "5555555555555555Ваш новий лот успішно створено. НЕ ПРАЦЮЄ!!!!!");

        basecurrencyRepo.save(basecurrency);

        return "redirect:/adminpanel/exchange";
    }
}