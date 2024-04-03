package com.uc.supplymgmtapi.repository;

import com.uc.supplymgmtapi.dto.AppUserDTO;
import com.uc.supplymgmtapi.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByEmail(String email);

    @Query("SELECT user FROM AppUser as user WHERE user.company.id= :companyId")
    List<AppUser> findAllByCompanyId(String companyId);

}
