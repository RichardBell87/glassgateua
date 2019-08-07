package glassgate.controller;

import glassgate.domain.Lot;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HomeController {

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

    Date date = new Date();
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

    @GetMapping("/home/uk/buy/uah/activeperiodends")
    public String ukbuyuahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {

        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/uah/activeperiodbegins")
    public String ukbuyuahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/uah/new")
    public String ukbuyuaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/uah/old")
    public String ukbuyuahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/uah/expensive")
    public String ukbuyuahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/uah/inexpensive")
    public String ukbuyuahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/uah/fromatoz")
    public String ukbuyuahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/uah/fromztoa")
    public String ukbuyuahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/activeperiodends")
    public String ukbuyusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/activeperiodbegins")
    public String ukbuyusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/new")
    public String ukbuyusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/old")
    public String ukbuyusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/expensive")
    public String ukbuyusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/inexpensive")
    public String ukbuyusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/fromatoz")
    public String ukbuyusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/usd/fromztoa")
    public String ukbuyusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/activeperiodends")
    public String ukbuyeuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/activeperiodbegins")
    public String ukbuyeuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/new")
    public String ukbuyeurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/old")
    public String ukbuyeuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/expensive")
    public String ukbuyeuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/inexpensive")
    public String ukbuyeuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/fromatoz")
    public String ukbuyeurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/buy/euro/fromztoa")
    public String ukbuyeurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/activeperiodends")
    public String uksaleuahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/activeperiodbegins")
    public String uksaleuahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/new")
    public String uksaleuaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/old")
    public String uksaleuahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/expensive")
    public String uksaleuahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/inexpensive")
    public String uksaleuahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/fromatoz")
    public String uksaleuahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/uah/fromztoa")
    public String uksaleuahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/activeperiodends")
    public String uksaleusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/activeperiodbegins")
    public String uksaleusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/new")
    public String uksaleusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/old")
    public String uksaleusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/expensive")
    public String uksaleusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/inexpensive")
    public String uksaleusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/fromatoz")
    public String uksaleusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/usd/fromztoa")
    public String uksaleusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/activeperiodends")
    public String uksaleeuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/activeperiodbegins")
    public String uksaleeuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/new")
    public String uksaleeurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/old")
    public String uksaleeuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/expensive")
    public String uksaleeuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/inexpensive")
    public String uksaleeuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/fromatoz")
    public String uksaleeurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/sale/euro/fromztoa")
    public String uksaleeurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/activeperiodends")
    public String ukalluahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {

        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/activeperiodbegins")
    public String ukalluahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/new")
    public String ukalluaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/old")
    public String ukalluahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/expensive")
    public String ukalluahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/inexpensive")
    public String ukalluahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/fromatoz")
    public String ukalluahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/uah/fromztoa")
    public String ukalluahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/activeperiodends")
    public String ukallusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/activeperiodbegins")
    public String ukallusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/new")
    public String ukallusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/old")
    public String ukallusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/expensive")
    public String ukallusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/inexpensive")
    public String ukallusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/fromatoz")
    public String ukallusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/usd/fromztoa")
    public String ukallusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/activeperiodends")
    public String ukalleuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/activeperiodbegins")
    public String ukalleuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/new")
    public String ukalleurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/old")
    public String ukalleuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/expensive")
    public String ukalleuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/inexpensive")
    public String ukalleuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/fromatoz")
    public String ukalleurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }

    @GetMapping("/home/uk/all/euro/fromztoa")
    public String ukalleurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "home");
        model.addAttribute("interfacelanguage", "0000000000");
        model.addAttribute("lottype", "0200000000");
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

        return "home";
    }
}