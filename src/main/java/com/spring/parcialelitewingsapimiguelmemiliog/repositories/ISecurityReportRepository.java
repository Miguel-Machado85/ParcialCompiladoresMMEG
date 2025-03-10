package com.spring.parcialelitewingsapimiguelmemiliog.repositories;

import com.spring.parcialelitewingsapimiguelmemiliog.models.SecurityReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISecurityReportRepository extends JpaRepository<SecurityReport, Long> {
}
