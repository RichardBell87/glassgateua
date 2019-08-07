package glassgate.controller;

import glassgate.domain.Lot;
import glassgate.domain.User;
import glassgate.repository.BasecurrencyRepo;
import glassgate.repository.LotRepo;
import glassgate.service.*;
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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CurrentExchangeRateService exchange;

    @Autowired
    private HtmlExchangeRatesParserService parser;

    @Autowired
    private LotService lotService;

    @Autowired
    private LotuahService lotuahService;

    @Autowired
    private LotusdService lotusdService;

    @Autowired
    private LoteuroService loteuroService;

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

    @GetMapping("/main/uk/buy/uah/activeperiodends")
    public String ukbuyuahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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
        model.addAttribute("bankEuro", bankEuro);;

        return "main";
    }

    @GetMapping("/main/uk/buy/uah/activeperiodbegins")
    public String ukbuyuahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/uah/new")
    public String ukbuyuaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/uah/old")
    public String ukbuyuahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/uah/expensive")
    public String ukbuyuahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/uah/inexpensive")
    public String ukbuyuahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/uah/fromatoz")
    public String ukbuyuahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/uah/fromztoa")
    public String ukbuyuahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/activeperiodends")
    public String ukbuyusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/activeperiodbegins")
    public String ukbuyusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/new")
    public String ukbuyusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/old")
    public String ukbuyusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/expensive")
    public String ukbuyusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/inexpensive")
    public String ukbuyusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/fromatoz")
    public String ukbuyusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/usd/fromztoa")
    public String ukbuyusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/activeperiodends")
    public String ukbuyeuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/activeperiodbegins")
    public String ukbuyeuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/new")
    public String ukbuyeurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/old")
    public String ukbuyeuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/expensive")
    public String ukbuyeuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/inexpensive")
    public String ukbuyeuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/fromatoz")
    public String ukbuyeurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/buy/euro/fromztoa")
    public String ukbuyeurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0000000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/activeperiodends")
    public String uksaleuahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/activeperiodbegins")
    public String uksaleuahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/new")
    public String uksaleuaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/old")
    public String uksaleuahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/expensive")
    public String uksaleuahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/inexpensive")
    public String uksaleuahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/fromatoz")
    public String uksaleuahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/uah/fromztoa")
    public String uksaleuahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/activeperiodends")
    public String uksaleusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/activeperiodbegins")
    public String uksaleusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/new")
    public String uksaleusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/old")
    public String uksaleusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/expensive")
    public String uksaleusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/inexpensive")
    public String uksaleusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/fromatoz")
    public String uksaleusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/usd/fromztoa")
    public String uksaleusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/activeperiodends")
    public String uksaleeuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/activeperiodbegins")
    public String uksaleeuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/new")
    public String uksaleeurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/old")
    public String uksaleeuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/expensive")
    public String uksaleeuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/inexpensive")
    public String uksaleeuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/fromatoz")
    public String uksaleeurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/sale/euro/fromztoa")
    public String uksaleeurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypeMainHome("0100000000", date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/activeperiodends")
    public String ukalluahactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {

        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/activeperiodbegins")
    public String ukalluahactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/new")
    public String ukalluaholdlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/old")
    public String ukalluahnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/expensive")
    public String ukalluahexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/inexpensive")
    public String ukalluahinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/fromatoz")
    public String ukalluahfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/uah/fromztoa")
    public String ukalluahfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/activeperiodends")
    public String ukallusdactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/activeperiodbegins")
    public String ukallusdactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/new")
    public String ukallusdoldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/old")
    public String ukallusdnewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/expensive")
    public String ukallusdexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/inexpensive")
    public String ukallusdinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/fromatoz")
    public String ukallusdfromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/usd/fromztoa")
    public String ukallusdfromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/activeperiodends")
    public String ukalleuroactiveperiodends(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/activeperiodbegins")
    public String ukalleuroactiveperiodbegins(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/new")
    public String ukalleurooldlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/old")
    public String ukalleuronewlots(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/expensive")
    public String ukalleuroexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/inexpensive")
    public String ukalleuroinexpensive(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/fromatoz")
    public String ukalleurofromatoz(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @GetMapping("/main/uk/all/euro/fromztoa")
    public String ukalleurofromztoa(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllMainHome(date, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "main");
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

        return "main";
    }

    @PostMapping("/main/uah/lotbet/test")
//    @PostMapping("https://www.liqpay.ua/api/3/checkout")
        public String buyuahlotbet(
                @AuthenticationPrincipal User user,
                @RequestParam Double lotbet,
                @RequestParam Long id,
                Map <String, Object> model, HttpServletRequest request) throws IOException, ParseException {

            Lot lot = lotuahService.updateLot(user, lotbet, id, usd, euro);

            String main = request.getHeader("referer");

            return "redirect:" + main;
    }

    @PostMapping("/main/usd/lotbet/test")
//    @PostMapping("https://www.liqpay.ua/api/3/checkout")
    public String buyusdlotbet(
            @AuthenticationPrincipal User user,
            @RequestParam Double lotbet,
            @RequestParam Long id,
            Map <String, Object> model, HttpServletRequest request) throws IOException, ParseException {

        Lot lot = lotusdService.updateLot(user, lotbet, id, usd, euro);

        String main = request.getHeader("referer");

        return "redirect:" + main;
    }

    @PostMapping("/main/euro/lotbet/test")
//    @PostMapping("https://www.liqpay.ua/api/3/checkout")
    public String buyeurolotbet(
            @AuthenticationPrincipal User user,
            @RequestParam Double lotbet,
            @RequestParam Long id,
            Map <String, Object> model, HttpServletRequest request) throws IOException, ParseException {

        Lot lot = loteuroService.updateLot(user, lotbet, id, usd, euro);

        String main = request.getHeader("referer");

        return "redirect:" + main;
    }
}