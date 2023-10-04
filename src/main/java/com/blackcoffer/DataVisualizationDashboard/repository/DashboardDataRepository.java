package com.blackcoffer.DataVisualizationDashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcoffer.DataVisualizationDashboard.model.DashboardData;

public interface DashboardDataRepository extends JpaRepository<DashboardData, Long>{

}
