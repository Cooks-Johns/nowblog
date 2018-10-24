package com.bloggertime.nowblog.repositories;

import com.bloggertime.nowblog.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRole extends JpaRepository<Role, Long> {
}
