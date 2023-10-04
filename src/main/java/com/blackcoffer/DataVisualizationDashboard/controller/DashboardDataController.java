package com.blackcoffer.DataVisualizationDashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackcoffer.DataVisualizationDashboard.model.DashboardData;
import com.blackcoffer.DataVisualizationDashboard.repository.DashboardDataRepository;

@RestController
@RequestMapping("/")
public class DashboardDataController {
    @Autowired
    private DashboardDataRepository dataRepository;

    // API to filter data by End Year
    @GetMapping("/by-end-year/{endYear}")
    public ResponseEntity<List<DashboardData>> filterByEndYear(@PathVariable String endYear) {
        List<DashboardData> data = dataRepository.findByEndYear(endYear);
        return ResponseEntity.ok(data);
    }

    // API to filter data by Topics
    @GetMapping("/by-topic/{topic}")
    public ResponseEntity<List<DashboardData>> filterByTopic(@PathVariable String topic) {
        List<DashboardData> data = dataRepository.findByTopic(topic);
        return ResponseEntity.ok(data);
    }

    // API to filter data by Sector
    @GetMapping("/by-sector/{sector}")
    public ResponseEntity<List<DashboardData>> filterBySector(@PathVariable String sector) {
        List<DashboardData> data = dataRepository.findBySector(sector);
        return ResponseEntity.ok(data);
    }

    // API to filter data by Region
    @GetMapping("/by-region/{region}")
    public ResponseEntity<List<DashboardData>> filterByRegion(@PathVariable String region) {
        List<DashboardData> data = dataRepository.findByRegion(region);
        return ResponseEntity.ok(data);
    }

    // API to filter data by PESTLE Factor
    @GetMapping("/by-pest/{pest}")
    public ResponseEntity<List<DashboardData>> filterByPest(@PathVariable String pest) {
        List<DashboardData> data = dataRepository.findByPestle(pest);
        return ResponseEntity.ok(data);
    }

    // API to filter data by Sourcetitle
    @GetMapping("/by-source/{source}")
    public ResponseEntity<List<DashboardData>> filterBySource(@PathVariable String source) {
        List<DashboardData> data = dataRepository.findBySourceTitle(source);
        return ResponseEntity.ok(data);
    }

    // API to filter data by SWOT Factor
    @GetMapping("/by-swot/{swot}")
    public ResponseEntity<List<DashboardData>> filterBySwot(@PathVariable String swot) {
        List<DashboardData> data = dataRepository.findBySwot(swot);
        return ResponseEntity.ok(data);
    }

    // API to filter data by Country
    @GetMapping("/by-country/{country}")
    public ResponseEntity<List<DashboardData>> filterByCountry(@PathVariable String country) {
        List<DashboardData> data = dataRepository.findByCountry(country);
        return ResponseEntity.ok(data);
    }

    // API to filter data by City
    @GetMapping("/by-city/{city}")
    public ResponseEntity<List<DashboardData>> filterByCity(@PathVariable String city) {
        List<DashboardData> data = dataRepository.findByCity(city);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/list-all")
    public ResponseEntity<List<DashboardData>> listAllData() {
        List<DashboardData> data = dataRepository.findAll();
        return ResponseEntity.ok(data);
    }
}


