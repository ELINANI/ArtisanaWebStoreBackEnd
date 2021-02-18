package com.artisanastore.ecommerce.Service.ServiceDetails;


import com.artisanastore.ecommerce.Dao.PersonneRepo;
import com.artisanastore.ecommerce.Models.Personne;
import com.artisanastore.ecommerce.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private PersonneRepo personneRepo;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Personne p = personneRepo.findByEmailPersonne(email);
        return new User(p.getEmailPersonne(),p.getPwdPersonne(),getRoles(p.getRole()));
    }
    public Collection<? extends GrantedAuthority> getRoles(Role role){
         List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
             grantedAuthorities.add(new SimpleGrantedAuthority(role.getNomRole()));
         return grantedAuthorities;
    }


}
