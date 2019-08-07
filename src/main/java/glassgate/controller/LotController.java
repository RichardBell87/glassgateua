package glassgate.controller;

import glassgate.domain.Lot;
import glassgate.domain.User;
import glassgate.repository.LotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class LotController {

    @Autowired
    private LotRepo lotRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/lotcreated")
    public String lot() {

        return "lotcreated";
    }

    @PostMapping("/lotcreated")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String lottype,
            @RequestParam String lotcategory,
            @RequestParam("file") MultipartFile file,
            @RequestParam String lotdescription,
            @RequestParam Long lotunittotal,
            @RequestParam String lotmeasure,
            @RequestParam Double lotmeasuretotal,
            @RequestParam String lotbasecurrency,
            @RequestParam Double lotunitprice,
            @RequestParam String lotexpiringdate,
            @RequestParam String lotexpiringtime,
            @RequestParam String lotdelivery,
            Map<String, Object> model) throws IOException, ParseException {

        String dateformatdate = lotexpiringdate + " " + lotexpiringtime + ":00";
        Double lottotalprice = lotunitprice * lotunittotal;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        String dateInString = dateformatdate;
        Date date = formatter.parse(dateInString);
        String formattedDateString = formatter.format(date);
        String lotbetactive = "0000000000";
        String lotauthoruserlastnamefirstnamepatronymic = user.getUserlastname() + " " + user.getUserfirstname() + " " + user.getUserpatronymic();
        String lotauthoruserphone = user.getUserphone();
        String lotauthoruseremail = user.getUseremail();
        Long lotauthorid = user.getId();

        Lot lot = new Lot(
                lottype,
                lotauthoruserlastnamefirstnamepatronymic,
                lotcategory,
                lotdescription,
                lotunittotal,
                lotmeasure,
                lotmeasuretotal,
                lotbasecurrency,
                lotunitprice,
                lottotalprice,
                lotexpiringdate,
                lotexpiringtime,
                dateformatdate,
                date,
                lotdelivery,
                user);

        lot.setLotbasecurrency(lotbasecurrency);
        lot.setLotbetactive(lotbetactive);
        lot.setLotcategory(lotcategory);
        lot.setLotdescription(lotdescription);
        lot.setLotexpiringdatetime(dateformatdate);
        lot.setLotexpiringdatetimecontrol(date);
        lot.setLotmeasure(lotmeasure);
        lot.setLotmeasuretotal(lotmeasuretotal);
        lot.setLotmeasuretotal(lotmeasuretotal);
        lot.setLottotalprice(lottotalprice);
        lot.setLottotalbestprice(lottotalprice);
        lot.setLotauthoruserlastnamefirstnamepatronymic(lotauthoruserlastnamefirstnamepatronymic);
        lot.setLotauthoruserphone(lotauthoruserphone);
        lot.setLotauthoruseremail(lotauthoruseremail);
        lot.setLottype(lottype);
        lot.setLotunitprice(lotunitprice);
        lot.setLotunittotal(lotunittotal);
        lot.setLotdelivery(lotdelivery);
        lot.setLotauthorid(lotauthorid);
        lot.setAuthor(user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            File tempDir = new File("/tmp" + uploadPath);
            if(!uploadDir.exists() || !tempDir.exists()){

                tempDir.mkdirs();
                uploadDir.mkdirs();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename =  lotexpiringdate + "." + uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            lot.setFilename(resultFilename);
        }

        model.put("message", "Ваш новий лот успішно створено. НЕ ПРАЦЮЄ!!!!!");

//        на оплату
//            lot.setLotactive(false);
            lot.setLotactive(true);
            lot.setLothalftotalprice(true);
            lotRepo.save(lot);

        return "redirect:/personaloffice/uk/all/uah/new";
    }
}