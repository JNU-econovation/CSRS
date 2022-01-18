package com.weart.csrs.domain.art;


import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.member.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArtRepository extends JpaRepository<Art, Long> {
    @Query("SELECT a FROM Art a where a.title = :titleValue ")
    List<Art> findByTitle(@Param("titleValue") String titleValue);
}