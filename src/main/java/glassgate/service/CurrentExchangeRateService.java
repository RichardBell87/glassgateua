package glassgate.service;

import glassgate.domain.Basecurrency;
import glassgate.repository.BasecurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@EnableScheduling
public class CurrentExchangeRateService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BasecurrencyRepo basecurrencyRepo;

    @Autowired
    private HtmlExchangeRatesParserService parser;

    @Scheduled(fixedRate = 600000)
    public Double usd() {

        List<Basecurrency> basecurrencyusd = basecurrencyRepo.findAll();
        Double basecurrencyusdvalue = 1.00000;
        Iterator<Basecurrency> iteratorUsd = basecurrencyusd.iterator();
        while (iteratorUsd .hasNext() ) {
            Basecurrency nextCat = iteratorUsd .next();
            basecurrencyusdvalue = nextCat.getBasecurrencyusdvalue();
        }

        Double minfinUsd = parser.minfinusd();
        Double goverlaUsd = parser.goverlausd();

        Double usd;
        if((minfinUsd / basecurrencyusdvalue) >= 0.9 && (minfinUsd / basecurrencyusdvalue) <= 1.1){
            usd = (1 / minfinUsd);
        }else{

            if((goverlaUsd / basecurrencyusdvalue) >= 0.9 && (goverlaUsd / basecurrencyusdvalue) <= 1.1){
                usd = (1 / goverlaUsd);
            }else{

                    usd = (1 / basecurrencyusdvalue);}
        }

        return usd;
    }

    @Scheduled(fixedRate = 600000)
    public Double euro() {

        List<Basecurrency> basecurrencyeuro = basecurrencyRepo.findAll();
        Double basecurrencyeurovalue = 1.00000;
        Iterator<Basecurrency> iteratorEuro = basecurrencyeuro.iterator();
        while (iteratorEuro.hasNext() ) {
            Basecurrency nextCat = iteratorEuro.next();
            basecurrencyeurovalue = nextCat.getBasecurrencyeurovalue();
        }

        Double minfinEuro = parser.minfineuro();
        Double goverlaEuro = parser.goverlaeuro();

        Double euro;
        if((minfinEuro / basecurrencyeurovalue) >= 0.9 && (minfinEuro / basecurrencyeurovalue) <= 1.1){
            euro = (1 / minfinEuro);
        }else{

            if((goverlaEuro / basecurrencyeurovalue) >= 0.9 && (goverlaEuro / basecurrencyeurovalue) <= 1.1){
                euro = (1 / goverlaEuro);
            }else{

                euro = (1 / basecurrencyeurovalue);}
        }

        return euro;
    }
}