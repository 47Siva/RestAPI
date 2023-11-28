package com.EBRAIN.Staffes.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.EBRAIN.Staffes.entity.Staffes;

@Repository
public interface StaffesRepositoroy extends JpaRepository<Staffes, UUID>{

	Optional<Staffes> findByName(String name);

	// named Query
	List<Staffes> findAllBystatus(String status);

	List<Staffes> findAllByStatus(String status);

//	Staffes findAllByStatusAndNameAndPhoennum(String status, String name, int phoen);

	// Raw Query
//	@Query(value = "select * from staffes as st where st.Status=:status",nativeQuery = true)
//	List<Staffes> findAllStatus(String status);
	
	@Query(value = "Select * from staffes  s where s.status =:s And s.phoen =:p And s.name =:n",nativeQuery = true)
	Staffes findByFields(@Param("s") String status, @Param("n") String name, @Param("p") String phoennum);

}
