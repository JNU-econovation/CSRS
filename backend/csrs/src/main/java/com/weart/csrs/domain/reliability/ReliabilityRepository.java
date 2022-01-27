//package com.weart.csrs.domain.reliability;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//public interface ReliabilityRepository extends JpaRepository<Reliability, Long> {
//    @Query("SELECT a FROM Reliability a where a.member.id = :memberidValue ")
//    List<Reliability> findByMemberId(@Param("memberidValue") Long memberidValue);
//}