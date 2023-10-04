package com.blackcoffer.DataVisualizationDashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcoffer.DataVisualizationDashboard.model.DashboardData;

public interface DashboardDataRepository extends JpaRepository<DashboardData, Long> {
    List<DashboardData> findByEndYear(String endYear);
    
    List<DashboardData> findByTopic(String topic);

	List<DashboardData> findBySector(String sector);

	List<DashboardData> findByRegion(String region);

	List<DashboardData> findByPestle(String pest);

	List<DashboardData> findBySourceTitle(String source);

	List<DashboardData> findBySwot(String swot);

	List<DashboardData> findByCountry(String country);

	List<DashboardData> findByCity(String city);
    
    
}
