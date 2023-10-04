package com.blackcoffer.DataVisualizationDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blackcoffer.DataVisualizationDashboard.service.DataImportService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DataVisualizationDashboardApplication {

	@Autowired
    private DataImportService dataImportService;

    public static void main(String[] args) {
        SpringApplication.run(DataVisualizationDashboardApplication.class, args);
    }

    @PostConstruct
    public void onApplicationStartup() {
        dataImportService.importDataFromCSV();
    }
}
