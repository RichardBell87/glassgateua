package glassgate.service;

import glassgate.domain.User;
import glassgate.domain.UserRole;
import glassgate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        Date date = new Date();

        if (userFromDb != null) {
            return false;

        }

//        user.setActive(false);
        user.setActive(true); //змінити на false!!!
        user.setRoles(Collections.singleton(UserRole.USER));
        user.setActivationCode(UUID.randomUUID().toString());

//        if (isEmailChanged) {
//            sendMessage(user); //прописать отдельное сообщение
//        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserregistrationdatetime(date);
        userRepo.save(user);
        sendMessage(user); //прописать отдельное сообщение

        return true;
    }

    public void sendMessage(User user) {
        if (!StringUtils.isEmpty(user.getUseremail())) {
            String message = String.format(
                    "Доброго дня, %s! \n" +
                            "Вітаємо у GlassGateUA. " +
                            "Для закінчення реєстрації, підтвердіть свій email відвідавши наступне посилання: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSender.send(user.getUseremail(), "Код активації", message);
        }
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        user.setActive(true);
        userRepo.save(user);

        return true;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, Map<String,String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(UserRole.values())
                .map(UserRole::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(UserRole.valueOf(key));
            }
        }

        userRepo.save(user);
    }

    public void updateProfile(User user,
                              String password,
                              String userlastname,
                              String userfirstname,
                              String userpatronymic,
                              String userphone,
                              String email) {

        String userPassword = user.getPassword();
        String userUserlastname = user.getUserlastname();
        String userUserfirstname = user.getUserfirstname();
        String userUserpatronymic = user.getUserpatronymic();
        String userUserphone = user.getUserphone();
        String userEmail = user.getUseremail();

        boolean isPasswordChanged = (password != null && !password.equals(userPassword)) ||
                (userPassword != null && !userPassword.equals(password));

        boolean isUserlastnameChanged = (userlastname != null && !userlastname.equals(userUserlastname)) ||
                (userUserlastname != null && !userUserlastname.equals(userlastname));

        boolean isUserfirstnameChanged = (userfirstname != null && !userfirstname.equals(userUserfirstname)) ||
                (userfirstname != null && !userfirstname.equals(userfirstname));

        boolean isUserpatronymicChanged = (userpatronymic != null && !userpatronymic.equals(userUserpatronymic)) ||
                (userUserpatronymic != null && !userpatronymic.equals(userpatronymic));

        boolean isUserphoneChanged = (userphone != null && !userphone.equals(userphone)) ||
                (userUserphone != null && !userUserphone.equals(userphone));

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));


        if (isEmailChanged) {
            user.setUseremail(email);
        }


        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }

        if (!StringUtils.isEmpty(userlastname)) {
            user.setUserlastname(userlastname);
        }

        if (!StringUtils.isEmpty(userfirstname)) {
            user.setUserfirstname(userfirstname);
        }

        if (!StringUtils.isEmpty(userpatronymic)) {
            user.setUserpatronymic(userpatronymic);
        }

        if (!StringUtils.isEmpty(userphone)) {
            user.setUserphone(userphone);
        }

        if (!StringUtils.isEmpty(email)) {
            user.setUseremail(email);
        }

        if(isEmailChanged) {

            user.setActivationCode(UUID.randomUUID().toString());
            user.setActive(false);

            userRepo.save(user);
            sendMessage(user); //прописать отдельное сообщение

        }

        if(isPasswordChanged ||
                isUserlastnameChanged ||
                isUserfirstnameChanged ||
                isUserpatronymicChanged ||
                isUserphoneChanged) {

            userRepo.save(user);
        }
    }
}