package app.services;

import app.models.Officer;
import app.repositories.OfficerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OfficerService implements UserDetailsService {

    private final OfficerRepo officerRepo;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public OfficerService(OfficerRepo officerRepo) {
        this.officerRepo = officerRepo;
        saveOfficer(new Officer("admin", "admin"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return officerRepo.findOfficersByUsername(username);
    }

    @Transactional
    public boolean saveOfficer(Officer officer) {
        if(officerRepo.findOfficersByUsername(officer.getUsername()) == null) {
            officer.setPassword(passwordEncoder.encode(officer.getPassword()));
            officerRepo.save(officer);
            return true;
        } else {
            return false;
        }
    }
}
