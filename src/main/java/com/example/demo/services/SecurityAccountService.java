package com.example.demo.services;

import com.example.demo.model.SecurityAccount;
import com.example.demo.repository.SecurityAccountRepository;
import com.example.demo.repository.SecurityRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityAccountService {

    Logger log = LoggerFactory.getLogger(SecurityAccountService.class);

    private SecurityAccountRepository accountRepository;
    private SecurityRoleRepository roleRepository;

    @Autowired
    public void setAccountRepo(SecurityAccountRepository accountRepo) {
        this.accountRepository = accountRepo;
    }

    @Autowired
    public void setRoleRepository(SecurityRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public void save(SecurityAccount securityAccount){
        if (!accountRepository.findAll().contains(securityAccount))
            accountRepository.save(securityAccount);
    }


    public List<SecurityAccount> findAll(){
        return accountRepository.findAll();
    }

    public SecurityAccount findByUsername(String userName){
        return accountRepository.findByUsername(userName);
    }


    public void delete(int id){
        accountRepository.deleteById(id);
    }

    /*public void addRole(SecurityAccount acc, SecurityRole securityRole){
       SecurityRole tempRole =  roleRepository.findByRole(securityRole.getRole());
       if (tempRole == null){
           log.info("Запись {} отсутствует в базе данных",securityRole);
           acc.addRole(securityRole);
       }
       else{
           log.info("Запись {} в базе данных уже существует", tempRole);
           log.info("добавляю");
           acc.addRole(tempRole);
       }


    }*/

}
