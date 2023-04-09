package k23BE.Harkkatyo.web;

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
    public UserDetails loadUserByUsername(String tunnus) throws UsernameNotFoundException {
		log.info("kayttajaByTunnus: " + tunnus);
    	Kayttaja curruser = repository.findByTunnus(tunnus);
        UserDetails user = new org.springframework.security.core.userdetails.User(tunnus, curruser.getSalasana(), AuthorityUtils.createAuthorityList(curruser.getRooli()));
        return user;
    }
	
}
