package glassgate.service;

import glassgate.domain.Lot;
import glassgate.domain.User;
import glassgate.repository.BasecurrencyRepo;
import glassgate.repository.LotRepo;
import glassgate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class LotusdService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LotRepo lotRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BasecurrencyRepo basecurrencyRepo;

    public Lot updateLot(User user, Double lotbet, Long id, Double usd, Double euro) {

        Lot lotnonamebet = new Lot();

        Lot lot = lotRepo.findById(id).get();
        Long currentuserid = user.getId();
        Long lotathorid = lot.getLotauthorid();

        Date date = new Date();
        Date datevirgin = new Date(System.currentTimeMillis() - (300 * 1000));

        String lotbetauthorusername = user.getUsername();
        String lotbetauthoruserlastnamefirstnamepatronymic = user.getUserlastname() + " " + user.getUserfirstname() + " " + user.getUserpatronymic();
        String lotbetauthoruserphone = user.getUserphone();
        String lotbetauthoruseremail = user.getUseremail();
        String lotbasecurrency = lot.getLotbasecurrency();

        Double minlotbet = 0.50;
        Double lotbetnull = null;
        Double lottotalprice = lot.getLottotalprice();
        String lottype = lot.getLottype();

        Double lottotalbestprice = lot.getLottotalbestprice();

        Double lotbet1 = lot.getLotbet1();
        Double lotbet2 = lot.getLotbet2();
        Double lotbet3 = lot.getLotbet3();
        Double lotbet4 = lot.getLotbet4();
        Double lotbet5 = lot.getLotbet5();
        Double lotbet6 = lot.getLotbet6();
        Double lotbet7 = lot.getLotbet7();
        Double lotbet8 = lot.getLotbet8();
        Double lotbet9 = lot.getLotbet9();

        Long lotbet1authorid = lot.getLotbet1authorid();
        Long lotbet2authorid = lot.getLotbet2authorid();
        Long lotbet3authorid = lot.getLotbet3authorid();
        Long lotbet4authorid = lot.getLotbet4authorid();
        Long lotbet5authorid = lot.getLotbet5authorid();
        Long lotbet6authorid = lot.getLotbet6authorid();
        Long lotbet7authorid = lot.getLotbet7authorid();
        Long lotbet8authorid = lot.getLotbet8authorid();
        Long lotbet9authorid = lot.getLotbet9authorid();

        Date lotbet1datetime = lot.getLotbet1datetime();
        Date lotbet2datetime = lot.getLotbet2datetime();
        Date lotbet3datetime = lot.getLotbet3datetime();
        Date lotbet4datetime = lot.getLotbet4datetime();
        Date lotbet5datetime = lot.getLotbet5datetime();
        Date lotbet6datetime = lot.getLotbet6datetime();
        Date lotbet7datetime = lot.getLotbet7datetime();
        Date lotbet8datetime = lot.getLotbet8datetime();
        Date lotbet9datetime = lot.getLotbet9datetime();

        Double lotbasecurrencycoefficient;
        if ( (lotbasecurrency.equals("0000000000")) ) {
            lotbasecurrencycoefficient = (1.0 / usd);
        } else {
            if ( (lotbasecurrency.equals("0010000000")) ) {
                lotbasecurrencycoefficient = 1.0;
            } else {
                lotbasecurrencycoefficient = (1.0 / usd * euro);
            }
        }

        Double lotbetfinal = (lotbet * lotbasecurrencycoefficient);

        Boolean prelotbetrange;
        if ((lottype.equals("0000000000")) && (lotbetfinal <= (lottotalbestprice * 0.99)) && (lotbetfinal >= (lottotalbestprice * 0.90)) ||
                ((lottype.equals("0100000000")) && (lotbetfinal >= (lottotalbestprice * 1.01)) && (lotbetfinal <= (lottotalbestprice * 1.10)))) {
            prelotbetrange = true;
        } else {
            prelotbetrange = false;
        }

        Boolean lotbettimeout;
        if ((currentuserid.equals(lotbet1authorid) && lotbet1datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet2authorid) && lotbet2datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet3authorid) && lotbet3datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet4authorid) && lotbet4datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet5authorid) && lotbet5datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet6authorid) && lotbet6datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet7authorid) && lotbet7datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet8authorid) && lotbet8datetime.after(datevirgin)) ||
                (currentuserid.equals(lotbet9authorid) && lotbet9datetime.after(datevirgin))) {
            lotbettimeout = true;
        } else {
            lotbettimeout = false;
        }

        Boolean samopomich;
        if (currentuserid.equals(lotathorid)) {
            samopomich = true;
        } else {
            samopomich = false;
        }

        Boolean half;
        if (lotbetfinal >= ((lottotalprice * minlotbet) + 0.01)) {
            half = true;
        } else {
            half = false;
        }

        Boolean preliqpay;
        if ( (prelotbetrange.equals(true)) && (lotbettimeout.equals(false)) && (samopomich.equals(false)) && (half.equals(false)) ) {
            preliqpay = true;
//            модуль оплаты
        } else {
            if ( (prelotbetrange.equals(true)) && (lotbettimeout.equals(false)) && (samopomich.equals(false)) && (half.equals(true)) ) {
                preliqpay = true;
//            модуль оплаты с МОДИФИЦИРОВАННОЙ СУММОЙ ОПЛАТЫ
            } else {
                preliqpay = false;
            }
        }

//        результат оплаты - true/false

        Boolean liqpay;
//        if ( ("результат оплаты".equals(true)) ) {
        liqpay = true;
//        } else {
//            liqpay = false;
//        }

        Boolean lotbetrange;
        if ((lottype.equals("0000000000")) && (lotbetfinal <= (lottotalbestprice * 0.99)) && (lotbetfinal >= (lottotalbestprice * 0.90)) ||
                ((lottype.equals("0100000000")) && (lotbetfinal >= (lottotalbestprice * 1.01)) && (lotbetfinal <= (lottotalbestprice * 1.10)))) {
            lotbetrange = true;
        } else {
            lotbetrange = false;
        }

        if (lotbet1 == null && lotbet2 == null && lotbet3 == null && lotbet4 == null && lotbet5 == null && lotbet6 == null && lotbet7 == null && lotbet8 == null && lotbet9 == null) {
            if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {

                if ( (half.equals(false)) ) {
                    lot.setLotbet1(lottotalprice * minlotbet);
                    lot.setLothalftotalprice(false);
                    lot.setLotbet1authorid(user.getId());
                    lot.setLotbet1datetime(date);
                    lot.setLotbetactive("0000000001");
                    lot.setId(id);
                    lot.setLotbet1authorusername(lotbetauthorusername);
                    lot.setLotbet1authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                    lot.setLotbet1authoruserphone(lotbetauthoruserphone);
                    lot.setLotbet1authoruseremail(lotbetauthoruseremail);
                    lot.setLottotalbestprice(lottotalprice * minlotbet);

                    lotnonamebet = lotRepo.save(lot);
                    return lotnonamebet;
                } else {
                    lot.setLotbet1(lotbetfinal);
                    lot.setLotbet2(lotbetnull);
                    lot.setLotbet1authorid(user.getId());
                    lot.setLotbet1datetime(date);
                    lot.setLotbetactive("0000000001");
                    lot.setId(id);
                    lot.setLotbet1authorusername(lotbetauthorusername);
                    lot.setLotbet1authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                    lot.setLotbet1authoruserphone(lotbetauthoruserphone);
                    lot.setLotbet1authoruseremail(lotbetauthoruseremail);
                    lot.setLottotalbestprice(lotbetfinal);

                    lotnonamebet = lotRepo.save(lot);
                    return lotnonamebet;
                }
            }
        }

        switch (lot.getLotbetactive()) {
            case "0000000001":
                if ( ((lotbetrange.equals(true))  && (liqpay.equals(true))) ) {
                    if ( (half.equals(false)) ) {
                        lot.setLotbet2(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet3(lotbetnull);
                        lot.setLotbet2authorid(user.getId());
                        lot.setLotbet2datetime(date);
                        lot.setLotbetactive("0000000002");
                        lot.setId(id);
                        lot.setLotbet2authorusername(lotbetauthorusername);
                        lot.setLotbet2authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet2authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet2authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet2(lotbetfinal);
                        lot.setLotbet3(lotbetnull);
                        lot.setLotbet2authorid(user.getId());
                        lot.setLotbet2datetime(date);
                        lot.setLotbetactive("0000000002");
                        lot.setId(id);
                        lot.setLotbet2authorusername(lotbetauthorusername);
                        lot.setLotbet2authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet2authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet2authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000002":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ((half.equals(false))) {
                        lot.setLotbet3(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet4(lotbetnull);
                        lot.setLotbet3authorid(user.getId());
                        lot.setLotbet3datetime(date);
                        lot.setLotbetactive("0000000003");
                        lot.setId(id);
                        lot.setLotbet3authorusername(lotbetauthorusername);
                        lot.setLotbet3authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet3authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet3authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet3(lotbetfinal);
                        lot.setLotbet4(lotbetnull);
                        lot.setLotbet3authorid(user.getId());
                        lot.setLotbet3datetime(date);
                        lot.setLotbetactive("0000000003");
                        lot.setId(id);
                        lot.setLotbet3authorusername(lotbetauthorusername);
                        lot.setLotbet3authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet3authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet3authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000003":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ((half.equals(false))) {
                        lot.setLotbet4(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet5(lotbetnull);
                        lot.setLotbet4authorid(user.getId());
                        lot.setLotbet4datetime(date);
                        lot.setLotbetactive("0000000004");
                        lot.setId(id);
                        lot.setLotbet4authorusername(lotbetauthorusername);
                        lot.setLotbet4authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet4authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet4authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet4(lotbetfinal);
                        lot.setLotbet5(lotbetnull);
                        lot.setLotbet4authorid(user.getId());
                        lot.setLotbet4datetime(date);
                        lot.setLotbetactive("0000000004");
                        lot.setId(id);
                        lot.setLotbet4authorusername(lotbetauthorusername);
                        lot.setLotbet4authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet4authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet4authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000004":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ((half.equals(false))) {
                        lot.setLotbet5(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet6(lotbetnull);
                        lot.setLotbet5authorid(user.getId());
                        lot.setLotbet5datetime(date);
                        lot.setLotbetactive("0000000005");
                        lot.setId(id);
                        lot.setLotbet5authorusername(lotbetauthorusername);
                        lot.setLotbet5authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet5authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet5authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet5(lotbetfinal);
                        lot.setLotbet6(lotbetnull);
                        lot.setLotbet5authorid(user.getId());
                        lot.setLotbet5datetime(date);
                        lot.setLotbetactive("0000000005");
                        lot.setId(id);
                        lot.setLotbet5authorusername(lotbetauthorusername);
                        lot.setLotbet5authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet5authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet5authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000005":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ( (half.equals(false)) ) {
                        lot.setLotbet6(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet7(lotbetnull);
                        lot.setLotbet6authorid(user.getId());
                        lot.setLotbet6datetime(date);
                        lot.setLotbetactive("0000000006");
                        lot.setId(id);
                        lot.setLotbet6authorusername(lotbetauthorusername);
                        lot.setLotbet6authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet6authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet6authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet6(lotbetfinal);
                        lot.setLotbet7(lotbetnull);
                        lot.setLotbet6authorid(user.getId());
                        lot.setLotbet6datetime(date);
                        lot.setLotbetactive("0000000006");
                        lot.setId(id);
                        lot.setLotbet6authorusername(lotbetauthorusername);
                        lot.setLotbet6authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet6authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet6authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000006":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ( (half.equals(false)) ) {
                        lot.setLotbet7(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet8(lotbetnull);
                        lot.setLotbet7authorid(user.getId());
                        lot.setLotbet7datetime(date);
                        lot.setLotbetactive("0000000007");
                        lot.setId(id);
                        lot.setLotbet7authorusername(lotbetauthorusername);
                        lot.setLotbet7authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet7authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet7authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet7(lotbetfinal);
                        lot.setLotbet8(lotbetnull);
                        lot.setLotbet7authorid(user.getId());
                        lot.setLotbet7datetime(date);
                        lot.setLotbetactive("0000000007");
                        lot.setId(id);
                        lot.setLotbet7authorusername(lotbetauthorusername);
                        lot.setLotbet7authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet7authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet7authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000007":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ( (half.equals(false)) ) {
                        lot.setLotbet8(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet9(lotbetnull);
                        lot.setLotbet8authorid(user.getId());
                        lot.setLotbet8datetime(date);
                        lot.setLotbetactive("0000000008");
                        lot.setId(id);
                        lot.setLotbet8authorusername(lotbetauthorusername);
                        lot.setLotbet8authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet8authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet8authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet8(lotbetfinal);
                        lot.setLotbet9(lotbetnull);
                        lot.setLotbet8authorid(user.getId());
                        lot.setLotbet8datetime(date);
                        lot.setLotbetactive("0000000008");
                        lot.setId(id);
                        lot.setLotbet8authorusername(lotbetauthorusername);
                        lot.setLotbet8authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet8authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet8authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000008":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ( (half.equals(false)) ) {
                        lot.setLotbet9(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet1(lotbetnull);
                        lot.setLotbet9authorid(user.getId());
                        lot.setLotbet9datetime(date);
                        lot.setLotbetactive("0000000009");
                        lot.setId(id);
                        lot.setLotbet9authorusername(lotbetauthorusername);
                        lot.setLotbet9authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet9authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet9authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet9(lotbetfinal);
                        lot.setLotbet1(lotbetnull);
                        lot.setLotbet9authorid(user.getId());
                        lot.setLotbet9datetime(date);
                        lot.setLotbetactive("0000000009");
                        lot.setId(id);
                        lot.setLotbet9authorusername(lotbetauthorusername);
                        lot.setLotbet9authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet9authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet9authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
            case "0000000009":
                if ( ((lotbetrange.equals(true)) && (liqpay.equals(true))) ) {
                    if ( (half.equals(false)) ) {
                        lot.setLotbet1(lottotalprice * minlotbet);
                        lot.setLothalftotalprice(false);
                        lot.setLotbet2(lotbetnull);
                        lot.setLotbet1authorid(user.getId());
                        lot.setLotbet1datetime(date);
                        lot.setLotbetactive("0000000001");
                        lot.setId(id);
                        lot.setLotbet1authorusername(lotbetauthorusername);
                        lot.setLotbet1authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet1authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet1authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lottotalprice * minlotbet);

                        lotnonamebet = lotRepo.save(lot);
                        return lotnonamebet;
                    } else {
                        lot.setLotbet1(lotbetfinal);
                        lot.setLotbet2(lotbetnull);
                        lot.setLotbet1authorid(user.getId());
                        lot.setLotbet1datetime(date);
                        lot.setLotbetactive("0000000001");
                        lot.setId(id);
                        lot.setLotbet1authorusername(lotbetauthorusername);
                        lot.setLotbet1authoruserlastnamefirstnamepatronymic(lotbetauthoruserlastnamefirstnamepatronymic);
                        lot.setLotbet1authoruserphone(lotbetauthoruserphone);
                        lot.setLotbet1authoruseremail(lotbetauthoruseremail);
                        lot.setLottotalbestprice(lotbetfinal);

                        lotnonamebet = lotRepo.save(lot);
                    }
                }
                break;
        }

        return lotnonamebet;
    }

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