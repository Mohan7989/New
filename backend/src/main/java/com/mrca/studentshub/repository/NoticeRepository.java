package com.mrca.studentshub.repository;

import com.mrca.studentshub.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
