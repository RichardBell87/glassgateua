package glassgate.repository;

import glassgate.domain.Basecurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasecurrencyRepo extends JpaRepository<Basecurrency, Long> {}
