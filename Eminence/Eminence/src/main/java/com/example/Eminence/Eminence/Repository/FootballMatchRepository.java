package com.example.Eminence.Eminence.Repository;

import com.example.Eminence.Eminence.Entity.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch, Long> {
}

