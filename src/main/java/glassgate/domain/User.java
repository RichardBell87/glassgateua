package glassgate.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "gg_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Pattern(regexp = "[0-9 A-Za-zА-Яа-яЁёЄєҐґІіЇї']{2,50}", message = "Введіть нікнейм для доступа на сайт.")
    @Column (name = "username")
    private String username;

    @Pattern(regexp = "(?=^.{8,255}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*", message = "Мова вводу - англійська, розмір - від 8 символів, з них: мінімум 1 цифра, 1 маленка літера, 1 велика літера.")
    @Column (name = "password")
    private String password;

//    @Transient
//    @Pattern(regexp = "(?=^.{8,255}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*", message = "Паролі мають збігатися.")
//    @Column (name = "userconfirmpassword")
//    private String userconfirmpassword;

    @Pattern(regexp = "(?=^.{2,50}$)((?=.*\\W+)|(?![.\\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*", message = "Мова вводу - українська, Ваше справжнє прізвище.")
    @Column (name = "userlastname")
    private String userlastname;

    @Pattern(regexp = "(?=^.{2,50}$)((?=.*\\W+)|(?![.\\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*", message = "Мова вводу - українська, Ваше справжнє ім'я.")
    @Column (name = "userfirstname")
    private String userfirstname;

    @Pattern(regexp = "(?=^.{2,50}$)((?=.*\\W+)|(?![.\\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*", message = "Мова вводу - українська, Ваше справжнє по батькові.")
    @Column (name = "userpatronymic")
    private String userpatronymic;

    @Pattern(regexp = "[\\+][3][8][0][6][7]\\d{7}|[\\+][3][8][0][9][6]\\d{7}|[\\+][3][8][0][9][7]\\d{7}|[\\+][3][8][0][9][8]\\d{7}|[\\+][3][8][0][5][0]\\d{7}|[\\+][3][8][0][6][6]\\d{7}|[\\+][3][8][0][9][5]\\d{7}|[\\+][3][8][0][9][9]\\d{7}|[\\+][3][8][0][6][3]\\d{7}|[\\+][3][8][0][7][3]\\d{7}|[\\+][3][8][0][9][3]\\d{7}", message = "Ваш дійсний мобільний номер в формафті +380ХХХХХХХХХ")
    @Column (name = "userphone")
    private String userphone;

    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message = "Ваша актуальна електронна скринька в форматі some@some.com")
    @Column (name = "useremail")
    private String useremail;

    private String activationCode;

    @Column (name = "userregistrationdatetime")
    private Date userregistrationdatetime;

    private boolean active;

    public User() {
    }

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "gg_user_role", joinColumns = @JoinColumn(name = "userid"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public boolean isUser (){
        return roles.contains(UserRole.USER);
    }

    public boolean isAdmin (){
        return roles.contains(UserRole.ADMIN);
    }

    public boolean isCreator (){
        return roles.contains(UserRole.CREATOR);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

//    public String getUserconfirmpassword() {
//        return userconfirmpassword;
//    }
//
//    public void setUserconfirmpassword(String userconfirmpassword) {
//        this.userconfirmpassword = userconfirmpassword;
//    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserpatronymic() {
        return userpatronymic;
    }

    public void setUserpatronymic(String userpatronymic) {
        this.userpatronymic = userpatronymic;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Date getUserregistrationdatetime() {
        return userregistrationdatetime;
    }

    public void setUserregistrationdatetime(Date userregistrationdatetime) {
        this.userregistrationdatetime = userregistrationdatetime;
    }
}