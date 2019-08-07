package glassgate.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "gg_connection")
public class Connection {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Pattern(regexp = "(?=^.{2,50}$)((?=.*\\W+)|(?![.\\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*", message = "Мова вводу - українська, Ваше справжнє ім'я.")
    @Column (name = "connectionuserfirstname")
    private String connectionuserfirstname;

    @Pattern(regexp = "(?=^.{2,50}$)((?=.*\\W+)|(?![.\\n]))(?=.*[А-ЯЁЄҐІЇ])(?=.*[а-яёєґії']).*", message = "Мова вводу - українська, Ваше справжнє по батькові.")
    @Column (name = "connectionuserpatronymic")
    private String connectionuserpatronymic;

    @Pattern(regexp = "[\\+][3][8][0][6][7]\\d{7}|[\\+][3][8][0][9][6]\\d{7}|[\\+][3][8][0][9][7]\\d{7}|[\\+][3][8][0][9][8]\\d{7}|[\\+][3][8][0][5][0]\\d{7}|[\\+][3][8][0][6][6]\\d{7}|[\\+][3][8][0][9][5]\\d{7}|[\\+][3][8][0][9][9]\\d{7}|[\\+][3][8][0][6][3]\\d{7}|[\\+][3][8][0][7][3]\\d{7}|[\\+][3][8][0][9][3]\\d{7}", message = "Ваш дійсний мобільний номер в формафті +380ХХХХХХХХХ")
    @Column (name = "connectionuserphone")
    private String connectionuserphone;

    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message = "Ваша актуальна електронна скринька в форматі some@some.com")
    @Column (name = "connectionuseremail")
    private String connectionuseremail;

    //    @Pattern(regexp = "[А-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{2,16}", message = "Введіть категорію лота. (мова вводу - українська, довжина опису від 2 до 16 символів)")
    @Column (name = "lotcategory")
    private String connectioncategory;

    //    @Pattern(regexp = "[A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{16,2048}", message = "Введіть опис лота. (довжина опису від 16 до 2048 символів)")
    @Column (name = "lotdescription", length = 4096)
    private String connectiondescription;

    @Pattern(regexp = "([0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][p][n][g]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][j][p][g]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][b][m][p]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][g][i][f]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][r][a][w]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][t][i][f][f]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][p][s][d]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][j][p][2]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][w][e][b][p]|[0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][s][v][g])", message = "Тільки графічні файли, максимальна довжина назви файлу <= 255 символів")
    @Column (name = "filename")
    private String filename;

    @Column (name = "connectiondate")
    private Date connectiondate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gguserid")
    private User author;

    private boolean active;

    public Connection() {
    }

    public Connection(String connectionuserfirstname, String connectionuserpatronymic, String connectionuserphone, String connectionuseremail, String connectioncategory, String connectiondescription, Date date, User user) {
    }

    public Connection(String connectionuserfirstname,
                      String connectionuserpatronymic,
                      String connectionuserphone,
                      String connectionuseremail,
                      String connectioncategory,
                      String connectiondescription,
                      String filename,
                      Date connectiondate,
                      User author) {
        this.connectionuserfirstname = connectionuserfirstname;
        this.connectionuserpatronymic = connectionuserpatronymic;
        this.connectionuserphone = connectionuserphone;
        this.connectionuseremail = connectionuseremail;
        this.connectioncategory = connectioncategory;
        this.connectiondescription = connectiondescription;
        this.filename = filename;
        this.connectiondate = connectiondate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConnectionuserfirstname() {
        return connectionuserfirstname;
    }

    public void setConnectionuserfirstname(String connectionuserfirstname) {
        this.connectionuserfirstname = connectionuserfirstname;
    }

    public String getConnectionuserpatronymic() {
        return connectionuserpatronymic;
    }

    public void setConnectionuserpatronymic(String connectionuserpatronymic) {
        this.connectionuserpatronymic = connectionuserpatronymic;
    }

    public String getConnectionuserphone() {
        return connectionuserphone;
    }

    public void setConnectionuserphone(String connectionuserphone) {
        this.connectionuserphone = connectionuserphone;
    }

    public String getConnectionuseremail() {
        return connectionuseremail;
    }

    public void setConnectionuseremail(String connectionuseremail) {
        this.connectionuseremail = connectionuseremail;
    }

    public String getConnectioncategory() {
        return connectioncategory;
    }

    public void setConnectioncategory(String connectioncategory) {
        this.connectioncategory = connectioncategory;
    }

    public String getConnectiondescription() {
        return connectiondescription;
    }

    public void setConnectiondescription(String connectiondescription) {
        this.connectiondescription = connectiondescription;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getConnectiondate() {
        return connectiondate;
    }

    public void setConnectiondate(Date connectiondate) {
        this.connectiondate = connectiondate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}