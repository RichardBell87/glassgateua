package glassgate.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "gg_currency")
public class Basecurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Pattern(regexp = "(d{1,3})+(,\\d{0,5})?", message = "55555555555555555Введіть нікнейм для доступа на сайт.")
    @Column (name = "basecurrencyusdvalue")
    private Double basecurrencyusdvalue;

//    @Pattern(regexp = "(d{1,3})+(.\\d{0,5})?", message = "5555555555555Мова вводу - англійська, розмір - від 8 символів, з них: мінімум 1 цифра, 1 маленка літера, 1 велика літера.")
    @Column (name = "basecurrencyeurovalue")
    private Double basecurrencyeurovalue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gguserid")
    private User author;

    @Column(name = "basecurrencydatetime")
//    @Temporal(TemporalType.TIMESTAMP)
    private Date basecurrencydatetime;

    public Basecurrency() {
    }

    public Basecurrency(User user, Double basecurrencyusdvalue, Double basecurrencyeurovalue, Date basecurrencydatetime) {
    }

    public Basecurrency(Double basecurrencyusdvalue, Double basecurrencyeurovalue, User author) {
        this.basecurrencyusdvalue = basecurrencyusdvalue;
        this.basecurrencyeurovalue = basecurrencyeurovalue;
        this.author = author;
        this.basecurrencydatetime = basecurrencydatetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBasecurrencyusdvalue() {
        return basecurrencyusdvalue;
    }

    public void setBasecurrencyusdvalue(Double basecurrencyusdvalue) {
        this.basecurrencyusdvalue = basecurrencyusdvalue;
    }

    public Double getBasecurrencyeurovalue() {
        return basecurrencyeurovalue;
    }

    public void setBasecurrencyeurovalue(Double basecurrencyeurovalue) {
        this.basecurrencyeurovalue = basecurrencyeurovalue;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getBasecurrencydatetime() {
        return basecurrencydatetime;
    }

    public void setBasecurrencydatetime(Date basecurrencydatetime) {
        this.basecurrencydatetime = basecurrencydatetime;
    }
}