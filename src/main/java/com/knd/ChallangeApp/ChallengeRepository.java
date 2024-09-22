package com.knd.ChallangeApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challange,Long> {
Optional<Challange> findByMonthIgnoreCase(String month);
}
