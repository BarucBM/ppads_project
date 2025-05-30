package com.TCC.services;

import com.TCC.domain.company.Company;
import com.TCC.domain.company.CompanyDTO;
import com.TCC.domain.company.CompanyUserDTO;
import com.TCC.domain.user.User;
import com.TCC.domain.user.UserRole;
import com.TCC.repositories.CompanyRepository;
import com.TCC.specifications.CompanySpecification;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final PreferenceService preferenceService;

    public CompanyService(CompanyRepository companyRepository, UserService userService, PreferenceService preferenceService) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.preferenceService = preferenceService;
    }

    public List<Company> getAllCompanies(String name, String address, String phone, String email) {
        Specification<Company> spec = Specification
                .where(CompanySpecification.emailContains(email))
                .and(CompanySpecification.phoneContains(phone))
                .and(CompanySpecification.nameContains(name))
                .and(CompanySpecification.adrressContains(address));
        return companyRepository.findAll(spec);
    }


    public Company findCompanyById(String id) {
        return this.companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + id));
    }

    public Company findCompanyByUserId(String id) {
        return this.companyRepository.findByUserId(id);
    }

    @Transactional
    public Company createCompanyWithUser(CompanyUserDTO data) {
        User user = new User();
        BeanUtils.copyProperties(data.user(), user);
        user.setRole(UserRole.COMPANY);

        Company company = new Company();
        BeanUtils.copyProperties(data.company(), company);

        company.setUser(userService.createUser(user));
        preferenceService.newUserPreferences(company.getUser().getId());
        return companyRepository.save(company);
    }

    @Transactional
    public void updateCompany(String id, CompanyDTO companyDTO) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + id));

        BeanUtils.copyProperties(companyDTO, existingCompany);

        companyRepository.save(existingCompany);
    }
}
