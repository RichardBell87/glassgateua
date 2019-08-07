package glassgate.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "gg_lot")
public class Lot {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    //    @Pattern(regexp = "([0][0][0][0][0][0][0][0][0][0])", message = "Введіть тип лота - купівля або продаж")
    @Column (name = "lottype")
    private String lottype;

    @Pattern(regexp = "[А-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{2,16}", message = "Введіть категорію лота. (мова вводу - українська, довжина опису від 2 до 16 символів)")
    @Column (name = "lotcategory")
    private String lotcategory;

    @Pattern(regexp = "([2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][p][n][g]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][j][p][g]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][b][m][p]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][g][i][f]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][r][a][w]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][t][i][f][f]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][p][s][d]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][j][p][2]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][w][e][b][p]|[2][0][1-2][0-9][\\-][0-1][0-9][\\-][0-3][0-9][\\.][0-9 A-Za-z]{8}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{4}[\\-][0-9 A-Za-z]{12}[\\.][A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{1,255}[\\.][s][v][g])", message = "Тільки графічні файли, максимальна довжина назви файлу <= 255 символів")
    @Column (name = "filename")
    private String filename;

    //    @Pattern(regexp = "[A-Za-zА-Яа-яЁёЄєҐґІіЇї\\s'0-9.,_%+-]{16,2048}", message = "Введіть опис лота. (довжина опису від 16 до 2048 символів)")
    @Column (name = "lotdescription", length = 4096)
    private String lotdescription;

    //    @Pattern(regexp = "[0-9]{1,9}", message = "Введіть кількість одиниць товару в шт")
    @Column (name = "lotunittotal")
    private Long lotunittotal;

    @Pattern(regexp = "[0][0][0][0][0][0][0][0][0][0]|[0][0][0][1][0][0][0][0][0][0]", message = "Виберить базову одиницю виміру (БО). (Кілограм або Літр)")
    @Column(name = "lotmeasure")
    private String lotmeasure;

    //    @Pattern(regexp = "\\d{1,9}+(,\\d{0,3})?|\\d{1,9}+(.\\d{0,3})?", message = "Введіть кількість одиниць товару в БО")
    @Column (name = "lotmeasuretotal")
    private Double lotmeasuretotal;

    @Pattern(regexp = "[0][0][0][0][0][0][0][0][0][0]|[0][0][1][0][0][0][0][0][0][0]|[0][0][2][0][0][0][0][0][0][0]", message = "Виберить базову валюту лота. (Гривня, або Доллар США, або Євро)")
    @Column(name = "lotbasecurrency")
    private String lotbasecurrency;

    //    @Pattern(regexp = "\\d{1,9}+(,\\d{0,2})?|\\d{1,9}+(.\\d{0,2})?", message = "Введіть максимальна вартість одиниці товару")
    @Column (name = "lotunitprice")
    private Double lotunitprice;

    //    @Pattern(regexp = "\\d{1,9}+(,\\d{0,2})?|\\d{1,9}+(.\\d{0,2})?", message = "Введіть максимальна вартість одиниці товару")
    @Column (name = "lottotalprice")
    private Double lottotalprice;

    //    @Pattern(regexp = "\\d{1,9}+(,\\d{0,2})?|\\d{1,9}+(.\\d{0,2})?", message = "Введіть максимальна вартість одиниці товару")
    @Column (name = "lottotalbestprice")
    private Double lottotalbestprice;

    @Transient
    //    @Pattern(regexp = "^[0-3]{1}[0-9]{1}-[0-1]{1}[1-2]{1}-[1-9]{1}[0-9]{3}$", message = "Введіть кінцеву дату актуальності лота")
    @Column (name = "lotexpiringdate")
    private String lotexpiringdate;

    @Transient
    @Pattern(regexp = "(0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9])", message = "Введіть кінцевий час актуальності лота")
    @Column (name = "lotexpiringtime")
    private String lotexpiringtime;

    //    @Pattern(regexp = "/([0-2][0-9]{3})\\-([0-1][0-9])\\-([0-3][0-9])T([0-5][0-9])\\:([0-5][0-9])/")
    @Column (name = "lotexpiringdatetime")
    private String lotexpiringdatetime;

    @Column (name = "lotexpiringdatetimecontrol")
    private Date lotexpiringdatetimecontrol;

    @Column (name = "lotbetactive")
    private String lotbetactive;

    @Column (name = "lotdelivery")
    private String lotdelivery;

    @Column (name = "lotauthorid")
    private  Long lotauthorid;

    @Transient
    @Column (name = "lotauthoruserlastname")
    private String lotauthoruserlastname;

    @Transient
    @Column (name = "lotauthoruserfirstname")
    private String lotauthoruserfirstname;

    @Transient
    @Column (name = "lotauthoruserpatronymic")
    private String lotauthoruserpatronymic;

    @Column (name = "loauthoruserlastnamefirstnamepatronymic")
    private String lotauthoruserlastnamefirstnamepatronymic;

    @Column (name = "lotauthoruserphone")
    private String lotauthoruserphone;

    @Column (name = "lotauthoruseremail")
    private String lotauthoruseremail;

    @Column (name = "lothalftotalprice")
    private Boolean lothalftotalprice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gguserid")
    private User author;

    @Transient
    @Column (name = "lotbet")
    private Double lotbet;

    @Column (name = "lotbet1")
    private Double lotbet1;

    @Column (name = "lotbet2")
    private Double lotbet2;

    @Column (name = "lotbet3")
    private Double lotbet3;

    @Column (name = "lotbet4")
    private Double lotbet4;

    @Column (name = "lotbet5")
    private Double lotbet5;

    @Column (name = "lotbet6")
    private Double lotbet6;

    @Column (name = "lotbet7")
    private Double lotbet7;

    @Column (name = "lotbet8")
    private Double lotbet8;

    @Column (name = "lotbet9")
    private Double lotbet9;

    @Transient
    @Column (name = "lotbetauthorid")
    private Long lotbetauthorid;

    @Column (name = "lotbet1authorid")
    private Long lotbet1authorid;

    @Column (name = "lotbet2authorid")
    private Long lotbet2authorid;

    @Column (name = "lotbet3authorid")
    private Long lotbet3authorid;

    @Column (name = "lotbet4authorid")
    private Long lotbet4authorid;

    @Column (name = "lotbet5authorid")
    private Long lotbet5authorid;

    @Column (name = "lotbet6authorid")
    private Long lotbet6authorid;

    @Column (name = "lotbet7authorid")
    private Long lotbet7authorid;

    @Column (name = "lotbet8authorid")
    private Long lotbet8authorid;

    @Column (name = "lotbet9authorid")
    private Long lotbet9authorid;

    @Transient
    @Column (name = "lotbetdatetime")
    private Date lotbetdatetime;

    @Column (name = "lotbet1datetime")
    private Date lotbet1datetime;

    @Column (name = "lotbet2datetime")
    private Date lotbet2datetime;

    @Column (name = "lotbet3datetime")
    private Date lotbet3datetime;

    @Column (name = "lotbet4datetime")
    private Date lotbet4datetime;

    @Column (name = "lotbet5datetime")
    private Date lotbet5datetime;

    @Column (name = "lotbet6datetime")
    private Date lotbet6datetime;

    @Column (name = "lotbet7datetime")
    private Date lotbet7datetime;

    @Column (name = "lotbet8datetime")
    private Date lotbet8datetime;

    @Column (name = "lotbet9datetime")
    private Date lotbet9datetime;

    @Transient
    @Column (name = "lotbetauthorusername")
    private String lotbetauthorusername;

    @Column (name = "lotbet1authorusername")
    private String lotbet1authorusername;

    @Column (name = "lotbet2authorusername")
    private String lotbet2authorusername;

    @Column (name = "lotbet3authorusername")
    private String lotbet3authorusername;

    @Column (name = "lotbet4authorusername")
    private String lotbet4authorusername;

    @Column (name = "lotbet5authorusername")
    private String lotbet5authorusername;

    @Column (name = "lotbet6authorusername")
    private String lotbet6authorusername;

    @Column (name = "lotbet7authorusername")
    private String lotbet7authorusername;

    @Column (name = "lotbet8authorusername")
    private String lotbet8authorusername;

    @Column (name = "lotbet9authorusername")
    private String lotbet9authorusername;

    @Transient
    @Column (name = "lotbetauthoruserlastname")
    private String lotbetauthoruserlastname;

    @Transient
    @Column (name = "lotbetauthoruserfirstname")
    private String lotbetauthoruserfirstname;

    @Transient
    @Column (name = "lotbetauthoruserpatronymic")
    private String lotbetauthoruserpatronymic;

    @Column (name = "lotbet1authoruserlastnamefirstnamepatronymic")
    private String lotbet1authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet2authoruserlastnamefirstnamepatronymic")
    private String lotbet2authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet3authoruserlastnamefirstnamepatronymic")
    private String lotbet3authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet4authoruserlastnamefirstnamepatronymic")
    private String lotbet4authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet5authoruserlastnamefirstnamepatronymic")
    private String lotbet5authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet6authoruserlastnamefirstnamepatronymic")
    private String lotbet6authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet7authoruserlastnamefirstnamepatronymic")
    private String lotbet7authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet8authoruserlastnamefirstnamepatronymic")
    private String lotbet8authoruserlastnamefirstnamepatronymic;

    @Column (name = "lotbet9authoruserlastnamefirstnamepatronymic")
    private String lotbet9authoruserlastnamefirstnamepatronymic;

    @Transient
    @Column (name = "lotbetauthoruserphone")
    private String lotbetauthoruserphone;

    @Column (name = "lotbet1authoruserphone")
    private String lotbet1authoruserphone;

    @Column (name = "lotbet2authoruserphone")
    private String lotbet2authoruserphone;

    @Column (name = "lotbet3authoruserphone")
    private String lotbet3authoruserphone;

    @Column (name = "lotbet4authoruserphone")
    private String lotbet4authoruserphone;

    @Column (name = "lotbet5authoruserphone")
    private String lotbet5authoruserphone;

    @Column (name = "lotbet6authoruserphone")
    private String lotbet6authoruserphone;

    @Column (name = "lotbet7authoruserphone")
    private String lotbet7authoruserphone;

    @Column (name = "lotbet8authoruserphone")
    private String lotbet8authoruserphone;

    @Column (name = "lotbet9authoruserphone")
    private String lotbet9authoruserphone;

    @Transient
    @Column (name = "lotbetauthoruseremail")
    private String lotbetauthoruseremail;

    @Column (name = "lotbet1authoruseremail")
    private String lotbet1authoruseremail;

    @Column (name = "lotbet2authoruseremail")
    private String lotbet2authoruseremail;

    @Column (name = "lotbet3authoruseremail")
    private String lotbet3authoruseremail;

    @Column (name = "lotbet4authoruseremail")
    private String lotbet4authoruseremail;

    @Column (name = "lotbet5authoruseremail")
    private String lotbet5authoruseremail;

    @Column (name = "lotbet6authoruseremail")
    private String lotbet6authoruseremail;

    @Column (name = "lotbet7authoruseremail")
    private String lotbet7authoruseremail;

    @Column (name = "lotbet8authoruseremail")
    private String lotbet8authoruseremail;

    @Column (name = "lotbet9authoruseremail")
    private String lotbet9authoruseremail;

    @Column (name = "lotactive")
    private Boolean lotactive;



    public Lot(String lottype,
               String lotcategory,
               String lotdescription,
               Long lotunittotal,
               String lotmeasure,
               Double lotmeasuretotal,
               String lotbasecurrency,
               Double lotunitprice,
               Double lottotalprice,
               Double lottotalbestprice,
               String lotexpiringdate,
               String lotexpiringtime,
               String dateformatdate,
               Date date,
               String lotdelivery,
               Long lotauthorid,
               String lotauthoruserlastname,
               String lotauthoruserfirstname,
               String lotauthoruserpatronymic,
               String lotauthoruserlastnamefirstnamepatronymic,
               String lotauthoruserphone,
               String lotauthoruseremail,
               String lotbetactive,
               Boolean lothalftotalprice,
               Boolean lotactive,
               User user) {
    }

    public Lot(String lottype,
               String lotcategory,
               String lotdescription,
               Long lotunittotal,
               String lotmeasure,
               Double lotmeasuretotal,
               String lotbasecurrency,
               Double lotunitprice,
               Double lottotalprice,
               Double lottotalbestprice,
               String lotexpiringdate,
               String lotexpiringtime,
               String lotexpiringdatetime,
               Date lotexpiringdatetimecontrol,
               String lotdelivery,
               Long lotauthorid,
               String lotauthoruserlastname,
               String lotauthoruserfirstname,
               String lotauthoruserpatronymic,
               String lotauthoruserlastnamefirstnamepatronymic,
               String lotauthoruserphone,
               String lotauthoruseremail,
               Boolean lothalftotalprice,
               User user) {
        this.lottype = lottype;
        this.lotcategory = lotcategory;
        this.lotdescription = lotdescription;
        this.lotunittotal = lotunittotal;
        this.lotmeasure = lotmeasure;
        this.lotmeasuretotal = lotmeasuretotal;
        this.lotbasecurrency = lotbasecurrency;
        this.lotunitprice = lotunitprice;
        this.lottotalprice = lottotalprice;
        this.lottotalbestprice = lottotalbestprice;
        this.lotexpiringdate = lotexpiringdate;
        this.lotexpiringtime = lotexpiringtime;
        this.lotexpiringdatetime = lotexpiringdatetime;
        this.lotexpiringdatetimecontrol = lotexpiringdatetimecontrol;
        this.lotdelivery = lotdelivery;
        this.lotauthorid = lotauthorid;
        this.lotauthoruserlastname = lotauthoruserlastname;
        this.lotauthoruserfirstname = lotauthoruserfirstname;
        this.lotauthoruserpatronymic = lotauthoruserpatronymic;
        this.lotauthoruserlastnamefirstnamepatronymic = lotauthoruserlastnamefirstnamepatronymic;
        this.lotauthoruserphone = lotauthoruserphone;
        this.lotauthoruseremail = lotauthoruseremail;
        this.lotbetactive = lotbetactive;
        this.lothalftotalprice = lothalftotalprice;
        this.lotactive = lotactive;
        this.author = user;
    }

    public Lot(String lottype, String lotauthoruserlastnamefirstnamepatronymic, String lotcategory, String lotdescription, Long lotunittotal, String lotmeasure, Double lotmeasuretotal, String lotbasecurrency, Double lotunitprice, Double lottotalprice, String lotexpiringdate, String lotexpiringtime, String dateformatdate, Date date, String lotbetactive, User user) {
        this.lottype = this.lottype;
        this.lotbet1 = lotbet;
        this.lotbet1 = lotbet1;
        this.lotbet1 = lotbet2;
        this.lotbet1 = lotbet3;
        this.lotbet1 = lotbet4;
        this.lotbet1 = lotbet5;
        this.lotbet1 = lotbet6;
        this.lotbet1 = lotbet7;
        this.lotbet1 = lotbet8;
        this.lotbet1 = lotbet9;
        this.lotbetauthorid = lotbetauthorid;
        this.lotbet1authorid = lotbetauthorid;
        this.lotbet2authorid = lotbetauthorid;
        this.lotbet3authorid = lotbetauthorid;
        this.lotbet4authorid = lotbetauthorid;
        this.lotbet5authorid = lotbetauthorid;
        this.lotbet6authorid = lotbetauthorid;
        this.lotbet7authorid = lotbetauthorid;
        this.lotbet8authorid = lotbetauthorid;
        this.lotbet9authorid = lotbetauthorid;
        this.lotbetdatetime = lotbetdatetime;
        this.lotbet1datetime = lotbetdatetime;
        this.lotbet2datetime = lotbetdatetime;
        this.lotbet3datetime = lotbetdatetime;
        this.lotbet4datetime = lotbetdatetime;
        this.lotbet5datetime = lotbetdatetime;
        this.lotbet6datetime = lotbetdatetime;
        this.lotbet7datetime = lotbetdatetime;
        this.lotbet8datetime = lotbetdatetime;
        this.lotbet9datetime = lotbetdatetime;
        this.lotbetauthorusername = lotbetauthorusername;
        this.lotbet1authorusername = lotbet1authorusername;
        this.lotbet2authorusername = lotbet2authorusername;
        this.lotbet3authorusername = lotbet3authorusername;
        this.lotbet4authorusername = lotbet4authorusername;
        this.lotbet5authorusername = lotbet5authorusername;
        this.lotbet6authorusername = lotbet6authorusername;
        this.lotbet7authorusername = lotbet7authorusername;
        this.lotbet8authorusername = lotbet8authorusername;
        this.lotbet9authorusername = lotbet9authorusername;
        this.lotbetauthoruserlastname = lotbetauthoruserlastname;
        this.lotbetauthoruserfirstname = lotbetauthoruserfirstname;
        this.lotbetauthoruserpatronymic = lotbetauthoruserpatronymic;
        this.lotbet1authoruserlastnamefirstnamepatronymic = lotbet1authoruserlastnamefirstnamepatronymic;
        this.lotbet2authoruserlastnamefirstnamepatronymic = lotbet2authoruserlastnamefirstnamepatronymic;
        this.lotbet3authoruserlastnamefirstnamepatronymic = lotbet3authoruserlastnamefirstnamepatronymic;
        this.lotbet4authoruserlastnamefirstnamepatronymic = lotbet4authoruserlastnamefirstnamepatronymic;
        this.lotbet5authoruserlastnamefirstnamepatronymic = lotbet5authoruserlastnamefirstnamepatronymic;
        this.lotbet6authoruserlastnamefirstnamepatronymic = lotbet6authoruserlastnamefirstnamepatronymic;
        this.lotbet7authoruserlastnamefirstnamepatronymic = lotbet7authoruserlastnamefirstnamepatronymic;
        this.lotbet8authoruserlastnamefirstnamepatronymic = lotbet8authoruserlastnamefirstnamepatronymic;
        this.lotbet9authoruserlastnamefirstnamepatronymic = lotbet9authoruserlastnamefirstnamepatronymic;
        this.lotbetauthoruserphone = lotbetauthoruserphone;
        this.lotbet1authoruserphone = lotbet1authoruserphone;
        this.lotbet2authoruserphone = lotbet2authoruserphone;
        this.lotbet3authoruserphone = lotbet3authoruserphone;
        this.lotbet4authoruserphone = lotbet4authoruserphone;
        this.lotbet5authoruserphone = lotbet5authoruserphone;
        this.lotbet6authoruserphone = lotbet6authoruserphone;
        this.lotbet7authoruserphone = lotbet7authoruserphone;
        this.lotbet8authoruserphone = lotbet8authoruserphone;
        this.lotbet9authoruserphone = lotbet9authoruserphone;
        this.lotbetauthoruseremail = lotbetauthoruseremail;
        this.lotbet1authoruseremail = lotbet1authoruseremail;
        this.lotbet2authoruseremail = lotbet2authoruseremail;
        this.lotbet3authoruseremail = lotbet3authoruseremail;
        this.lotbet4authoruseremail = lotbet4authoruseremail;
        this.lotbet5authoruseremail = lotbet5authoruseremail;
        this.lotbet6authoruseremail = lotbet6authoruseremail;
        this.lotbet7authoruseremail = lotbet7authoruseremail;
        this.lotbet8authoruseremail = lotbet8authoruseremail;
        this.lotbet9authoruseremail = lotbet9authoruseremail;
    }

    public Lot() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLottype() {
        return lottype;
    }

    public void setLottype(String lottype) {
        this.lottype = lottype;
    }

    public String getLotcategory() {
        return lotcategory;
    }

    public void setLotcategory(String lotcategory) {
        this.lotcategory = lotcategory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getLotdescription() {
        return lotdescription;
    }

    public void setLotdescription(String lotdescription) {
        this.lotdescription = lotdescription;
    }

    public Long getLotunittotal() {
        return lotunittotal;
    }

    public void setLotunittotal(Long lotunittotal) {
        this.lotunittotal = lotunittotal;
    }

    public String getLotmeasure() {
        return lotmeasure;
    }

    public void setLotmeasure(String lotmeasure) {
        this.lotmeasure = lotmeasure;
    }

    public Double getLotmeasuretotal() {
        return lotmeasuretotal;
    }

    public void setLotmeasuretotal(Double lotmeasuretotal) {
        this.lotmeasuretotal = lotmeasuretotal;
    }

    public String getLotbasecurrency() {
        return lotbasecurrency;
    }

    public void setLotbasecurrency(String lotbasecurrency) {
        this.lotbasecurrency = lotbasecurrency;
    }

    public Double getLotunitprice() {
        return lotunitprice;
    }

    public void setLotunitprice(Double lotunitprice) {
        this.lotunitprice = lotunitprice;
    }

    public Double getLottotalprice() {
        return lottotalprice;
    }

    public void setLottotalprice(Double lottotalprice) {
        this.lottotalprice = lottotalprice;
    }

    public Double getLottotalbestprice() {
        return lottotalbestprice;
    }

    public void setLottotalbestprice(Double lottotalbestprice) {
        this.lottotalbestprice = lottotalbestprice;
    }

    public String getLotexpiringdate() {
        return lotexpiringdate;
    }

    public void setLotexpiringdate(String lotexpiringdate) {
        this.lotexpiringdate = lotexpiringdate;
    }

    public String getLotexpiringtime() {
        return lotexpiringtime;
    }

    public void setLotexpiringtime(String lotexpiringtime) {
        this.lotexpiringtime = lotexpiringtime;
    }

    public String getLotexpiringdatetime() {
        return lotexpiringdatetime;
    }

    public void setLotexpiringdatetime(String lotexpiringdatetime) {
        this.lotexpiringdatetime = lotexpiringdatetime;
    }

    public Date getLotexpiringdatetimecontrol() {
        return lotexpiringdatetimecontrol;
    }

    public void setLotexpiringdatetimecontrol(Date lotexpiringdatetimecontrol) {
        this.lotexpiringdatetimecontrol = lotexpiringdatetimecontrol;
    }

    public String getLotdelivery() {
        return lotdelivery;
    }

    public void setLotdelivery(String lotdelivery) {
        this.lotdelivery = lotdelivery;
    }

    public Long getLotauthorid() {
        return lotauthorid;
    }

    public void setLotauthorid(Long lotauthorid) {
        this.lotauthorid = lotauthorid;
    }

    public Boolean getLotactive() {
        return lotactive;
    }

    public void setLotactive(Boolean lotactive) {
        this.lotactive = lotactive;
    }

    public String getLotauthoruserlastname() {
        return lotauthoruserlastname;
    }

    public void setLotauthoruserlastname(String lotauthoruserlastname) {
        this.lotauthoruserlastname = lotauthoruserlastname;
    }

    public String getLotauthoruserfirstname() {
        return lotauthoruserfirstname;
    }

    public void setLotauthoruserfirstname(String lotauthoruserfirstname) {
        this.lotauthoruserfirstname = lotauthoruserfirstname;
    }

    public String getLotauthoruserpatronymic() {
        return lotauthoruserpatronymic;
    }

    public void setLotauthoruserpatronymic(String lotauthoruserpatronymic) {
        this.lotauthoruserpatronymic = lotauthoruserpatronymic;
    }

    public String getLotauthoruserlastnamefirstnamepatronymic() {
        return lotauthoruserlastnamefirstnamepatronymic;
    }

    public void setLotauthoruserlastnamefirstnamepatronymic(String lotauthoruserlastnamefirstnamepatronymic) {
        this.lotauthoruserlastnamefirstnamepatronymic = lotauthoruserlastnamefirstnamepatronymic;
    }

    public String getLotauthoruserphone() {
        return lotauthoruserphone;
    }

    public void setLotauthoruserphone(String lotauthoruserphone) {
        this.lotauthoruserphone = lotauthoruserphone;
    }

    public String getLotauthoruseremail() {
        return lotauthoruseremail;
    }

    public void setLotauthoruseremail(String lotauthoruseremail) {
        this.lotauthoruseremail = lotauthoruseremail;
    }

    public String getLotbetactive() {
        return lotbetactive;
    }

    public void setLotbetactive(String lotbetactive) {
        this.lotbetactive = lotbetactive;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Double getLotbet() {
        return lotbet;
    }

    public void setLotbet(Double lotbet) {
        this.lotbet = lotbet;
    }

    public Double getLotbet1() {
        return lotbet1;
    }

    public void setLotbet1(Double lotbet1) {
        this.lotbet1 = lotbet1;
    }

    public Double getLotbet2() {
        return lotbet2;
    }

    public void setLotbet2(Double lotbet2) {
        this.lotbet2 = lotbet2;
    }

    public Double getLotbet3() {
        return lotbet3;
    }

    public void setLotbet3(Double lotbet3) {
        this.lotbet3 = lotbet3;
    }

    public Double getLotbet4() {
        return lotbet4;
    }

    public void setLotbet4(Double lotbet4) {
        this.lotbet4 = lotbet4;
    }

    public Double getLotbet5() {
        return lotbet5;
    }

    public void setLotbet5(Double lotbet5) {
        this.lotbet5 = lotbet5;
    }

    public Double getLotbet6() {
        return lotbet6;
    }

    public void setLotbet6(Double lotbet6) {
        this.lotbet6 = lotbet6;
    }

    public Double getLotbet7() {
        return lotbet7;
    }

    public void setLotbet7(Double lotbet7) {
        this.lotbet7 = lotbet7;
    }

    public Double getLotbet8() {
        return lotbet8;
    }

    public void setLotbet8(Double lotbet8) {
        this.lotbet8 = lotbet8;
    }

    public Double getLotbet9() {
        return lotbet9;
    }

    public void setLotbet9(Double lotbet9) {
        this.lotbet9 = lotbet9;
    }

    public Long getLotbetauthorid() {
        return lotbetauthorid;
    }

    public void setLotbetauthorid(Long lotbetauthorid) {
        this.lotbetauthorid = lotbetauthorid;
    }

    public Long getLotbet1authorid() {
        return lotbet1authorid;
    }

    public void setLotbet1authorid(Long lotbet1authorid) {
        this.lotbet1authorid = lotbet1authorid;
    }

    public Long getLotbet2authorid() {
        return lotbet2authorid;
    }

    public void setLotbet2authorid(Long lotbet2authorid) {
        this.lotbet2authorid = lotbet2authorid;
    }

    public Long getLotbet3authorid() {
        return lotbet3authorid;
    }

    public void setLotbet3authorid(Long lotbet3authorid) {
        this.lotbet3authorid = lotbet3authorid;
    }

    public Long getLotbet4authorid() {
        return lotbet4authorid;
    }

    public void setLotbet4authorid(Long lotbet4authorid) {
        this.lotbet4authorid = lotbet4authorid;
    }

    public Long getLotbet5authorid() {
        return lotbet5authorid;
    }

    public void setLotbet5authorid(Long lotbet5authorid) {
        this.lotbet5authorid = lotbet5authorid;
    }

    public Long getLotbet6authorid() {
        return lotbet6authorid;
    }

    public void setLotbet6authorid(Long lotbet6authorid) {
        this.lotbet6authorid = lotbet6authorid;
    }

    public Long getLotbet7authorid() {
        return lotbet7authorid;
    }

    public void setLotbet7authorid(Long lotbet7authorid) {
        this.lotbet7authorid = lotbet7authorid;
    }

    public Long getLotbet8authorid() {
        return lotbet8authorid;
    }

    public void setLotbet8authorid(Long lotbet8authorid) {
        this.lotbet8authorid = lotbet8authorid;
    }

    public Long getLotbet9authorid() {
        return lotbet9authorid;
    }

    public void setLotbet9authorid(Long lotbet9authorid) {
        this.lotbet9authorid = lotbet9authorid;
    }

    public Date getLotbetdatetime() {
        return lotbetdatetime;
    }

    public void setLotbetdatetime(Date lotbetdatetime) {
        this.lotbetdatetime = lotbetdatetime;
    }

    public Date getLotbet1datetime() {
        return lotbet1datetime;
    }

    public void setLotbet1datetime(Date lotbet1datetime) {
        this.lotbet1datetime = lotbet1datetime;
    }

    public Date getLotbet2datetime() {
        return lotbet2datetime;
    }

    public void setLotbet2datetime(Date lotbet2datetime) {
        this.lotbet2datetime = lotbet2datetime;
    }

    public Date getLotbet3datetime() {
        return lotbet3datetime;
    }

    public void setLotbet3datetime(Date lotbet3datetime) {
        this.lotbet3datetime = lotbet3datetime;
    }

    public Date getLotbet4datetime() {
        return lotbet4datetime;
    }

    public void setLotbet4datetime(Date lotbet4datetime) {
        this.lotbet4datetime = lotbet4datetime;
    }

    public Date getLotbet5datetime() {
        return lotbet5datetime;
    }

    public void setLotbet5datetime(Date lotbet5datetime) {
        this.lotbet5datetime = lotbet5datetime;
    }

    public Date getLotbet6datetime() {
        return lotbet6datetime;
    }

    public void setLotbet6datetime(Date lotbet6datetime) {
        this.lotbet6datetime = lotbet6datetime;
    }

    public Date getLotbet7datetime() {
        return lotbet7datetime;
    }

    public void setLotbet7datetime(Date lotbet7datetime) {
        this.lotbet7datetime = lotbet7datetime;
    }

    public Date getLotbet8datetime() {
        return lotbet8datetime;
    }

    public void setLotbet8datetime(Date lotbet8datetime) {
        this.lotbet8datetime = lotbet8datetime;
    }

    public Date getLotbet9datetime() {
        return lotbet9datetime;
    }

    public void setLotbet9datetime(Date lotbet9datetime) {
        this.lotbet9datetime = lotbet9datetime;
    }

    public String getLotbetauthorusername() {
        return lotbetauthorusername;
    }

    public void setLotbetauthorusername(String lotbetauthorusername) {
        this.lotbetauthorusername = lotbetauthorusername;
    }

    public String getLotbet1authorusername() {
        return lotbet1authorusername;
    }

    public void setLotbet1authorusername(String lotbet1authorusername) {
        this.lotbet1authorusername = lotbet1authorusername;
    }

    public String getLotbet2authorusername() {
        return lotbet2authorusername;
    }

    public void setLotbet2authorusername(String lotbet2authorusername) {
        this.lotbet2authorusername = lotbet2authorusername;
    }

    public String getLotbet3authorusername() {
        return lotbet3authorusername;
    }

    public void setLotbet3authorusername(String lotbet3authorusername) {
        this.lotbet3authorusername = lotbet3authorusername;
    }

    public String getLotbet4authorusername() {
        return lotbet4authorusername;
    }

    public void setLotbet4authorusername(String lotbet4authorusername) {
        this.lotbet4authorusername = lotbet4authorusername;
    }

    public String getLotbet5authorusername() {
        return lotbet5authorusername;
    }

    public void setLotbet5authorusername(String lotbet5authorusername) {
        this.lotbet5authorusername = lotbet5authorusername;
    }

    public String getLotbet6authorusername() {
        return lotbet6authorusername;
    }

    public void setLotbet6authorusername(String lotbet6authorusername) {
        this.lotbet6authorusername = lotbet6authorusername;
    }

    public String getLotbet7authorusername() {
        return lotbet7authorusername;
    }

    public void setLotbet7authorusername(String lotbet7authorusername) {
        this.lotbet7authorusername = lotbet7authorusername;
    }

    public String getLotbet8authorusername() {
        return lotbet8authorusername;
    }

    public void setLotbet8authorusername(String lotbet8authorusername) {
        this.lotbet8authorusername = lotbet8authorusername;
    }

    public String getLotbet9authorusername() {
        return lotbet9authorusername;
    }

    public void setLotbet9authorusername(String lotbet9authorusername) {
        this.lotbet9authorusername = lotbet9authorusername;
    }

    public String getLotbetauthoruserlastname() {
        return lotbetauthoruserlastname;
    }

    public void setLotbetauthoruserlastname(String lotbetauthoruserlastname) {
        this.lotbetauthoruserlastname = lotbetauthoruserlastname;
    }

    public String getLotbetauthoruserfirstname() {
        return lotbetauthoruserfirstname;
    }

    public void setLotbetauthoruserfirstname(String lotbetauthoruserfirstname) {
        this.lotbetauthoruserfirstname = lotbetauthoruserfirstname;
    }

    public String getLotbetauthoruserpatronymic() {
        return lotbetauthoruserpatronymic;
    }

    public void setLotbetauthoruserpatronymic(String lotbetauthoruserpatronymic) {
        this.lotbetauthoruserpatronymic = lotbetauthoruserpatronymic;
    }

    public String getLotbet1authoruserlastnamefirstnamepatronymic() {
        return lotbet1authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet1authoruserlastnamefirstnamepatronymic(String lotbet1authoruserlastnamefirstnamepatronymic) {
        this.lotbet1authoruserlastnamefirstnamepatronymic = lotbet1authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet2authoruserlastnamefirstnamepatronymic() {
        return lotbet2authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet2authoruserlastnamefirstnamepatronymic(String lotbet2authoruserlastnamefirstnamepatronymic) {
        this.lotbet2authoruserlastnamefirstnamepatronymic = lotbet2authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet3authoruserlastnamefirstnamepatronymic() {
        return lotbet3authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet3authoruserlastnamefirstnamepatronymic(String lotbet3authoruserlastnamefirstnamepatronymic) {
        this.lotbet3authoruserlastnamefirstnamepatronymic = lotbet3authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet4authoruserlastnamefirstnamepatronymic() {
        return lotbet4authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet4authoruserlastnamefirstnamepatronymic(String lotbet4authoruserlastnamefirstnamepatronymic) {
        this.lotbet4authoruserlastnamefirstnamepatronymic = lotbet4authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet5authoruserlastnamefirstnamepatronymic() {
        return lotbet5authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet5authoruserlastnamefirstnamepatronymic(String lotbet5authoruserlastnamefirstnamepatronymic) {
        this.lotbet5authoruserlastnamefirstnamepatronymic = lotbet5authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet6authoruserlastnamefirstnamepatronymic() {
        return lotbet6authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet6authoruserlastnamefirstnamepatronymic(String lotbet6authoruserlastnamefirstnamepatronymic) {
        this.lotbet6authoruserlastnamefirstnamepatronymic = lotbet6authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet7authoruserlastnamefirstnamepatronymic() {
        return lotbet7authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet7authoruserlastnamefirstnamepatronymic(String lotbet7authoruserlastnamefirstnamepatronymic) {
        this.lotbet7authoruserlastnamefirstnamepatronymic = lotbet7authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet8authoruserlastnamefirstnamepatronymic() {
        return lotbet8authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet8authoruserlastnamefirstnamepatronymic(String lotbet8authoruserlastnamefirstnamepatronymic) {
        this.lotbet8authoruserlastnamefirstnamepatronymic = lotbet8authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbet9authoruserlastnamefirstnamepatronymic() {
        return lotbet9authoruserlastnamefirstnamepatronymic;
    }

    public void setLotbet9authoruserlastnamefirstnamepatronymic(String lotbet9authoruserlastnamefirstnamepatronymic) {
        this.lotbet9authoruserlastnamefirstnamepatronymic = lotbet9authoruserlastnamefirstnamepatronymic;
    }

    public String getLotbetauthoruserphone() {
        return lotbetauthoruserphone;
    }

    public void setLotbetauthoruserphone(String lotbetauthoruserphone) {
        this.lotbetauthoruserphone = lotbetauthoruserphone;
    }

    public String getLotbet1authoruserphone() {
        return lotbet1authoruserphone;
    }

    public void setLotbet1authoruserphone(String lotbet1authoruserphone) {
        this.lotbet1authoruserphone = lotbet1authoruserphone;
    }

    public String getLotbet2authoruserphone() {
        return lotbet2authoruserphone;
    }

    public void setLotbet2authoruserphone(String lotbet2authoruserphone) {
        this.lotbet2authoruserphone = lotbet2authoruserphone;
    }

    public String getLotbet3authoruserphone() {
        return lotbet3authoruserphone;
    }

    public void setLotbet3authoruserphone(String lotbet3authoruserphone) {
        this.lotbet3authoruserphone = lotbet3authoruserphone;
    }

    public String getLotbet4authoruserphone() {
        return lotbet4authoruserphone;
    }

    public void setLotbet4authoruserphone(String lotbet4authoruserphone) {
        this.lotbet4authoruserphone = lotbet4authoruserphone;
    }

    public String getLotbet5authoruserphone() {
        return lotbet5authoruserphone;
    }

    public void setLotbet5authoruserphone(String lotbet5authoruserphone) {
        this.lotbet5authoruserphone = lotbet5authoruserphone;
    }

    public String getLotbet6authoruserphone() {
        return lotbet6authoruserphone;
    }

    public void setLotbet6authoruserphone(String lotbet6authoruserphone) {
        this.lotbet6authoruserphone = lotbet6authoruserphone;
    }

    public String getLotbet7authoruserphone() {
        return lotbet7authoruserphone;
    }

    public void setLotbet7authoruserphone(String lotbet7authoruserphone) {
        this.lotbet7authoruserphone = lotbet7authoruserphone;
    }

    public String getLotbet8authoruserphone() {
        return lotbet8authoruserphone;
    }

    public void setLotbet8authoruserphone(String lotbet8authoruserphone) {
        this.lotbet8authoruserphone = lotbet8authoruserphone;
    }

    public String getLotbet9authoruserphone() {
        return lotbet9authoruserphone;
    }

    public void setLotbet9authoruserphone(String lotbet9authoruserphone) {
        this.lotbet9authoruserphone = lotbet9authoruserphone;
    }

    public String getLotbetauthoruseremail() {
        return lotbetauthoruseremail;
    }

    public void setLotbetauthoruseremail(String lotbetauthoruseremail) {
        this.lotbetauthoruseremail = lotbetauthoruseremail;
    }

    public String getLotbet1authoruseremail() {
        return lotbet1authoruseremail;
    }

    public void setLotbet1authoruseremail(String lotbet1authoruseremail) {
        this.lotbet1authoruseremail = lotbet1authoruseremail;
    }

    public String getLotbet2authoruseremail() {
        return lotbet2authoruseremail;
    }

    public void setLotbet2authoruseremail(String lotbet2authoruseremail) {
        this.lotbet2authoruseremail = lotbet2authoruseremail;
    }

    public String getLotbet3authoruseremail() {
        return lotbet3authoruseremail;
    }

    public void setLotbet3authoruseremail(String lotbet3authoruseremail) {
        this.lotbet3authoruseremail = lotbet3authoruseremail;
    }

    public String getLotbet4authoruseremail() {
        return lotbet4authoruseremail;
    }

    public void setLotbet4authoruseremail(String lotbet4authoruseremail) {
        this.lotbet4authoruseremail = lotbet4authoruseremail;
    }

    public String getLotbet5authoruseremail() {
        return lotbet5authoruseremail;
    }

    public void setLotbet5authoruseremail(String lotbet5authoruseremail) {
        this.lotbet5authoruseremail = lotbet5authoruseremail;
    }

    public String getLotbet6authoruseremail() {
        return lotbet6authoruseremail;
    }

    public void setLotbet6authoruseremail(String lotbet6authoruseremail) {
        this.lotbet6authoruseremail = lotbet6authoruseremail;
    }

    public String getLotbet7authoruseremail() {
        return lotbet7authoruseremail;
    }

    public void setLotbet7authoruseremail(String lotbet7authoruseremail) {
        this.lotbet7authoruseremail = lotbet7authoruseremail;
    }

    public String getLotbet8authoruseremail() {
        return lotbet8authoruseremail;
    }

    public void setLotbet8authoruseremail(String lotbet8authoruseremail) {
        this.lotbet8authoruseremail = lotbet8authoruseremail;
    }

    public String getLotbet9authoruseremail() {
        return lotbet9authoruseremail;
    }

    public void setLotbet9authoruseremail(String lotbet9authoruseremail) {
        this.lotbet9authoruseremail = lotbet9authoruseremail;
    }

    public boolean isLotactive() {
        return lotactive;
    }

    public void setLotactive(boolean lotactive) {
        this.lotactive = lotactive;
    }

    public Boolean getLothalftotalprice() {
        return lothalftotalprice;
    }

    public void setLothalftotalprice(Boolean lothalftotalprice) {
        this.lothalftotalprice = lothalftotalprice;
    }
}