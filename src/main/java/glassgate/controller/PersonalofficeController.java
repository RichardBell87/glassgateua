package glassgate.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class PersonalofficeController {

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

    Date lotfulfillmentdeadlinedate = new Date(System.currentTimeMillis() - (72 * 3600 * 1000));
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

    @GetMapping("/personaloffice/uk/buy/uah/activeperiodends")
    public String ukbuyuahactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/uah/activeperiodbegins")
    public String ukbuyuahactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/uah/new")
    public String ukbuyuaholdlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/uah/old")
    public String ukbuyuahnewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/uah/expensive")
    public String ukbuyuahexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/uah/inexpensive")
    public String ukbuyuahinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/uah/fromatoz")
    public String ukbuyuahfromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/uah/fromztoa")
    public String ukbuyuahfromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/activeperiodends")
    public String ukbuyusdactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/activeperiodbegins")
    public String ukbuyusdactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/new")
    public String ukbuyusdoldlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/old")
    public String ukbuyusdnewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/expensive")
    public String ukbuyusdexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/inexpensive")
    public String ukbuyusdinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/fromatoz")
    public String ukbuyusdfromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/usd/fromztoa")
    public String ukbuyusdfromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/activeperiodends")
    public String ukbuyeuroactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/activeperiodbegins")
    public String ukbuyeuroactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/new")
    public String ukbuyeurooldlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {

        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/old")
    public String ukbuyeuronewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/expensive")
    public String ukbuyeuroexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/inexpensive")
    public String ukbuyeuroinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/fromatoz")
    public String ukbuyeurofromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/buy/euro/fromztoa")
    public String ukbuyeurofromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0000000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/activeperiodends")
    public String uksaleuahactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/activeperiodbegins")
    public String uksaleuahactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/new")
    public String uksaleuaholdlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/old")
    public String uksaleuahnewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/expensive")
    public String uksaleuahexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/inexpensive")
    public String uksaleuahinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/fromatoz")
    public String uksaleuahfromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/uah/fromztoa")
    public String uksaleuahfromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/activeperiodends")
    public String uksaleusdactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/activeperiodbegins")
    public String uksaleusdactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/new")
    public String uksaleusdoldlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/old")
    public String uksaleusdnewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/expensive")
    public String uksaleusdexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/inexpensive")
    public String uksaleusdinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/fromatoz")
    public String uksaleusdfromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/usd/fromztoa")
    public String uksaleusdfromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/activeperiodends")
    public String uksaleeuroactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/activeperiodbegins")
    public String uksaleeuroactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotexpiringdatetime"}, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/new")
    public String uksaleeurooldlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/old")
    public String uksaleeuronewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/expensive")
    public String uksaleeuroexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/inexpensive")
    public String uksaleeuroinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lottotalbestprice"}, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/fromatoz")
    public String uksaleeurofromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/sale/euro/fromztoa")
    public String uksaleeurofromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = {"lotcategory"}, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllByLottypePersonaloffice(user,"0100000000", lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/activeperiodends")
    public String ukalluahactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {

        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/activeperiodbegins")
    public String ukalluahactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/new")
    public String ukalluaholdlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/old")
    public String ukalluahnewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/expensive")
    public String ukalluahexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/inexpensive")
    public String ukalluahinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/fromatoz")
    public String ukalluahfromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/uah/fromztoa")
    public String ukalluahfromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/activeperiodends")
    public String ukallusdactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/activeperiodbegins")
    public String ukallusdactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/new")
    public String ukallusdoldlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/old")
    public String ukallusdnewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/expensive")
    public String ukallusdexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/inexpensive")
    public String ukallusdinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/fromatoz")
    public String ukallusdfromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/usd/fromztoa")
    public String ukallusdfromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/activeperiodends")
    public String ukalleuroactiveperiodends(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.ASC) /*період активності закінчується*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/activeperiodbegins")
    public String ukalleuroactiveperiodbegins(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotexpiringdatetime" }, direction = Sort.Direction.DESC) /*період активності триваліший*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/new")
    public String ukalleurooldlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.DESC) /*новіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/old")
    public String ukalleuronewlots(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "id" }, direction = Sort.Direction.ASC) /*старіші лоти*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/expensive")
    public String ukalleuroexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.DESC) /*від дорогого до дешевшого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/inexpensive")
    public String ukalleuroinexpensive(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lottotalbestprice" }, direction = Sort.Direction.ASC) /*від девшого до дорожчого*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/fromatoz")
    public String ukalleurofromatoz(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.ASC) /*по категориї від А до Я*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }

    @GetMapping("/personaloffice/uk/all/euro/fromztoa")
    public String ukalleurofromztoa(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(size = 8, sort = { "lotcategory" }, direction = Sort.Direction.DESC) /*по категориї від Я до А*/

                    Pageable pageable
    )

    {
        Page<Lot> page = lotService.findAllPersonaloffice(user,lotfulfillmentdeadlinedate, filter, pageable);

        parserExchange();

        model.addAttribute("adminpanelmainhomepersonaloffice", "personaloffice");
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

        return "personaloffice";
    }
}