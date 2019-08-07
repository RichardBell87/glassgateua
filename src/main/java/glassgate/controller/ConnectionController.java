package glassgate.controller;

import glassgate.domain.Connection;
import glassgate.domain.User;
import glassgate.repository.ConnectionRepo;
import glassgate.service.UserService;
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
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class ConnectionController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConnectionRepo connectionRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/connection")
    public String connection() {

        return "connection";
    }

    @PostMapping("/connection")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String connectionuserfirstname,
            @RequestParam String connectionuserpatronymic,
            @RequestParam String connectionuserphone,
            @RequestParam String connectionuseremail,
            @RequestParam String connectioncategory,
            @RequestParam String connectiondescription,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) throws IOException, ParseException {

        Date date = new Date();

        Connection connection = new Connection(
                connectionuserfirstname,
                connectionuserpatronymic,
                connectionuserphone,
                connectionuseremail,
                connectioncategory,
                connectiondescription,
                date,
                user);

        connection.setConnectionuserfirstname(connectionuserfirstname);
        connection.setConnectionuserpatronymic(connectionuserpatronymic);
        connection.setConnectionuserphone(connectionuserphone);
        connection.setConnectionuseremail(connectionuseremail);
        connection.setConnectioncategory(connectioncategory);
        connection.setConnectiondescription(connectiondescription);
        connection.setConnectiondate(date);
        connection.setAuthor(user);

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
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            connection.setFilename(resultFilename);
        }

        model.put("message", "Ваше повідомлення успішно відправлено. НЕ ПРАЦЮЄ!!!!!");

        connection.setActive(true);

        connectionRepo.save(connection);

        return "redirect:/connection";
    }
}