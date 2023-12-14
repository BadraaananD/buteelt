package portfolio;

import java.util.Collection;
import java.util.HashMap;

import javax.sound.sampled.DataLine;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{

}