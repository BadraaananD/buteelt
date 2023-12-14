package portfolio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	private RegisterRepository registerRepository;
	@Autowired
	public RegisterService(RegisterRepository registerRepository) {
		super();
		this.registerRepository = registerRepository;
	}
	
	
	public Collection<Register> getUsers(){
		return this.registerRepository.findAll();
	}
	
	public Register findByEmail(String email) {
		
		Register user = this.registerRepository.findByEmail(email);
		return user;
	}
	
	public void addUser(Register user) {
		this.registerRepository.save(user);
	}


	public Register searchUsers(String email) {
		// TODO Auto-generated method stub
		 return registerRepository.findByEmail(email);
	}


	public void deleteUser(Long id) {
		this.registerRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}


	public Register getUser(Long id) {
		// TODO Auto-generated method stub
		Register user = this.registerRepository.getById(id);
		return user;
	}


	public void updateUser(Register user) {
		this.registerRepository.save(user);
		// TODO Auto-generated method stub
		
	}
}