package com.spring.parcialelitewingsapimiguelmemiliog.repositories;

import com.spring.parcialelitewingsapimiguelmemiliog.models.SecurityReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISecurityReportRepository extends JpaRepository<SecurityReport, Long> {
    public List<SecurityReport> findSecurityReportByResolved(boolean resolved);
}
