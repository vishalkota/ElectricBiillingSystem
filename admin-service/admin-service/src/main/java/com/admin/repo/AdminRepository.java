package com.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
}
