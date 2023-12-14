package portfolio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {
private PortfolioRepository portfolioRepository;
	
	@Autowired
	public PortfolioService(PortfolioRepository portfolioRepository){
		super();
		this.portfolioRepository = portfolioRepository;
	}
	
	public Collection<Portfolio> getPortfolios(){
		Sort sort = Sort.by(Sort.Order.asc("id"));
		return this.portfolioRepository.findAll(sort);
	}
	
	public void addPortfolio(Portfolio p) {
		this.portfolioRepository.save(p);
	}
	
	public void deletePortfolio(Long id) {
		this.portfolioRepository.deleteById(id);
	}
	
	public Portfolio getPortfolio(Long id) {
		Portfolio por = this.portfolioRepository.getById(id);
		return por;
	}
	
	public void updatePortfolio(Portfolio updatePortfolio) {
		this.portfolioRepository.save(updatePortfolio);
	}
}
	
