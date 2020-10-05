package com.training.admissions.security;

import com.training.admissions.entity.Candidate;
import com.training.admissions.repository.CandidateRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CandidateRepository candidateRepository;

    public UserDetailsServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Candidate candidate = candidateRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User does't exists"));
        return SecurityUser.getUserFromCandidate(candidate);
    }
}
