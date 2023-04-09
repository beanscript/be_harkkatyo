package k23BE.Harkkatyo.web;

//import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import k23BE.Harkkatyo.domain.Kayttaja;
import k23BE.Harkkatyo.domain.KayttajaRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	private final KayttajaRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(KayttajaRepository kayttajaRepository) {
		this.repository = kayttajaRepository;
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("kayttajaByUsername: " + username);
    	Kayttaja curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getSalasana(), 
        		AuthorityUtils.createAuthorityList(curruser.getRooli()));
        return user;
    }
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Kayttaja> user = repository.findByUsername(username);
//
//		UserBuilder builder = null;
//		if (user.isPresent()) {
//			Kayttaja currentUser = user.get();
//			builder = org.springframework.security.core.userdetails.User.withUsername(username);
//			builder.password(currentUser.getSalasana());
//			builder.roles(currentUser.getRooli());
//		} else {
//			throw new UsernameNotFoundException("User not found.");
//		}
//
//		return builder.build();	    
//	}
	
}
