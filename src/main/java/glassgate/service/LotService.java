package glassgate.service;

import glassgate.domain.Lot;
import glassgate.domain.User;
import glassgate.repository.LotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LotRepo lotRepo;

    public Page <Lot> findAllByLottypeMainHome(String lotType, Date date, String filter, Pageable pageable) {

        Page <Lot> page;
        Long id;
        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if (preid >= 1000001 && preid <= 4999999) {
                id = ((preid - 1000000 + 1) / 2);
            } else {
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLotexpiringdatetimecontrolIsAfterAndAuthor_ActiveAndId(date, true, id, pageable);
        } else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLottypeAndLotexpiringdatetimecontrolIsAfterAndAuthor_ActiveAndLotcategory(lotType, date, true, filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLottypeAndLotexpiringdatetimecontrolIsAfterAndAuthor_Active(lotType, date, true, pageable);
            }
        }
        return page;
    }

    public Page <Lot> findAllMainHome(Date date, String filter, Pageable pageable) {

        Page <Lot> page;
        Long id;
        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if (preid >= 1000001 && preid <= 4999999) {
                id = ((preid - 1000000 + 1) / 2);
            } else {
                id = ((preid - 5000000 + 1) / 2);
            }

            page = lotRepo.findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLotexpiringdatetimecontrolIsAfterAndAuthor_ActiveAndId(date, true, id, pageable);
        } else {

            if (filter != null && !filter.isEmpty()) {
                page = lotRepo.findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLotexpiringdatetimecontrolIsAfterAndAuthor_ActiveAndLotcategory(date, true, filter, pageable);
            } else {
                page = lotRepo.findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLotexpiringdatetimecontrolIsAfterAndAuthor_Active(date, true, pageable);
            }
        }
        return page;
    }

    public Page<Lot> findAllByLottypePersonaloffice(User user, String lotType, Date lotfulfillmentdeadlinedate, String filter, Pageable pageable) {

        Long idUser = user.getId();
        Long id;
        List <Lot> lots;
        List <Long> idLots = new ArrayList <>();

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if (preid >= 1000001 && preid <= 4999999) {
                id = ((preid - 1000000 + 1) / 2);
            } else {
                id = ((preid - 5000000 + 1) / 2);
            }

            lots = lotRepo.findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndId(lotfulfillmentdeadlinedate, id);
        }else if (filter != null && !filter.isEmpty()){
            lots = lotRepo.findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndLottypeAndLotcategory(lotfulfillmentdeadlinedate,lotType, filter);
        }else{
            lots = lotRepo.findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndLottype(lotfulfillmentdeadlinedate,lotType);
        }

        List <Lot> lots2 = new ArrayList <>();
        Iterator <Lot> iteratorLots = lots.iterator();
        while (iteratorLots.hasNext()) {
            Lot lot = iteratorLots.next();
            if ( idUser.equals(lot.getLotauthorid()) ||
                    idUser.equals(lot.getLotbet1authorid()) ||
                    idUser.equals(lot.getLotbet2authorid()) ||
                    idUser.equals(lot.getLotbet3authorid()) ||
                    idUser.equals(lot.getLotbet4authorid()) ||
                    idUser.equals(lot.getLotbet5authorid()) ||
                    idUser.equals(lot.getLotbet6authorid()) ||
                    idUser.equals(lot.getLotbet7authorid()) ||
                    idUser.equals(lot.getLotbet8authorid()) ||
                    idUser.equals(lot.getLotbet9authorid()) ){
                lots2.add(lot);
                idLots.add(lot.getId());
            }
        }

        Page<Lot> page = lotRepo.findByIdIn(idLots, pageable);

        return page;
    }

    public Page<Lot> findAllPersonaloffice(User user, Date lotfulfillmentdeadlinedate, String filter, Pageable pageable) {

        Long idUser = user.getId();
        Long id;
        List <Lot> lots;
        List <Long> idLots = new ArrayList <>();

        if (filter != null && !filter.isEmpty() && filter.matches("\\d*")) {
            long preid = Long.parseLong(filter);

            if (preid >= 1000001 && preid <= 4999999) {
                id = ((preid - 1000000 + 1) / 2);
            } else {
                id = ((preid - 5000000 + 1) / 2);
            }

            lots = lotRepo.findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndId(lotfulfillmentdeadlinedate, id);
        }else if (filter != null && !filter.isEmpty()){
            lots = lotRepo.findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndLotcategory(lotfulfillmentdeadlinedate, filter);
        }else{
            lots = lotRepo.findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfter(lotfulfillmentdeadlinedate);
        }

        List <Lot> lots2 = new ArrayList <>();
        Iterator <Lot> iteratorLots = lots.iterator();
        while (iteratorLots.hasNext()) {
            Lot lot = iteratorLots.next();
            if ( idUser.equals(lot.getLotauthorid()) ||
                    idUser.equals(lot.getLotbet1authorid()) ||
                    idUser.equals(lot.getLotbet2authorid()) ||
                    idUser.equals(lot.getLotbet3authorid()) ||
                    idUser.equals(lot.getLotbet4authorid()) ||
                    idUser.equals(lot.getLotbet5authorid()) ||
                    idUser.equals(lot.getLotbet6authorid()) ||
                    idUser.equals(lot.getLotbet7authorid()) ||
                    idUser.equals(lot.getLotbet8authorid()) ||
                    idUser.equals(lot.getLotbet9authorid()) ){
                lots2.add(lot);
                idLots.add(lot.getId());
            }
        }

        Page<Lot>  page = lotRepo.findByIdIn(idLots, pageable);
        return page;
    }
}