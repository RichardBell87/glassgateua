package glassgate.repository;

import glassgate.domain.Lot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LotRepo extends CrudRepository<Lot, Long> {
    //    Main,Home
    Page<Lot> findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLotexpiringdatetimecontrolIsAfterAndAuthor_ActiveAndId(Date date,  Boolean active, Long id, Pageable pageable);
    Page<Lot> findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLottypeAndLotexpiringdatetimecontrolIsAfterAndAuthor_ActiveAndLotcategory(String lottype, Date date,  Boolean active, String lotcategory, Pageable pageable);
    Page<Lot> findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLottypeAndLotexpiringdatetimecontrolIsAfterAndAuthor_Active(String lottype, Date date, Boolean active, Pageable pageable);
    Page<Lot> findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLotexpiringdatetimecontrolIsAfterAndAuthor_ActiveAndLotcategory(Date date,  Boolean active, String lotcategory, Pageable pageable);
    Page<Lot> findAllByLotactiveTrueAndLothalftotalpriceIsTrueAndLotexpiringdatetimecontrolIsAfterAndAuthor_Active(Date date, Boolean active, Pageable pageable);

    //    Personaloffice
    List<Lot> findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndId(Date lotfulfillmentdeadlinedate, Long id);
    List<Lot> findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndLottypeAndLotcategory(Date lotfulfillmentdeadlinedate,String lottype, String lotcategory);
    List<Lot> findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndLottype(Date lotfulfillmentdeadlinedate, String lottype);
    List<Lot> findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfterAndLotcategory(Date lotfulfillmentdeadlinedate, String lotcategory);
    List<Lot> findAllByLotactiveTrueAndLotexpiringdatetimecontrolIsAfter(Date lotfulfillmentdeadlinedate);
    Page<Lot> findByIdIn(List<Long> idLots, Pageable pageable);

    //    Adminpanel
    Page<Lot> findAllByLotactiveTrueAndId(Long id, Pageable pageable);
    Page<Lot> findAllByLotactiveTrueAndLottypeAndLotcategory(String lottype, String lotcategory, Pageable pageable);
    Page<Lot> findAllByLotactiveTrueAndLottype(String lottype, Pageable pageable);

}