package com.blackcoffer.DataVisualizationDashboard.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffer.DataVisualizationDashboard.model.DashboardData;
import com.blackcoffer.DataVisualizationDashboard.repository.DashboardDataRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class DataImportService {
    @Autowired
    private DashboardDataRepository dataRepository;

    public void importDataFromCSV() {
        try (InputStream is = getClass().getResourceAsStream("/Data.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {

            String[] nextLine; // To hold each row of data from the CSV

            // Skip the header row if it exists
            try {
				reader.readNext();
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            try {
				while ((nextLine = reader.readNext()) != null) {
				    DashboardData data = new DashboardData();

				    // Validate and map CSV columns to DashboardData fields
				    data.setEndYear(nextLine[0]);
				    data.setCityLng(parseDoubleOrZero(nextLine[1]));
				    data.setCityLat(parseDoubleOrZero(nextLine[2]));
				    data.setIntensity(parseDoubleOrZero(nextLine[3]));
				    data.setSector(nextLine[4]);
				    data.setTopic(nextLine[5]);

				    // Handle 'insight' field length
				    String insight = nextLine[6];
				    if (insight != null && insight.length() > 255) {
				        insight = insight.substring(0, 255); // Truncate to 255 characters
				    }
				    data.setInsight(insight);

				    data.setSwot(nextLine[7]);
				    data.setUrl(nextLine[8]);
				    data.setRegion(nextLine[9]);
				    data.setStartYear(nextLine[10]);
				    data.setImpact(nextLine[11]);
				    data.setAdded(nextLine[12]);
				    data.setPublished(nextLine[13]);
				    data.setCity(nextLine[14]);
				    data.setCountry(nextLine[15]);

				    // Handle 'relevance' field length
				    String relevance = nextLine[16];
				    if (relevance != null && relevance.length() > 255) {
				        relevance = relevance.substring(0, 255); // Truncate to 255 characters
				    }
				    data.setRelevance(relevance);

				    data.setPestle(nextLine[17]);
				    data.setSourceTitle(nextLine[18]);

				    // Handle 'likelihood' field length
				    String likelihood = nextLine[19];
				    if (likelihood != null && likelihood.length() > 255) {
				        likelihood = likelihood.substring(0, 255); // Truncate to 255 characters
				    }
				    data.setLikelihood(likelihood);

				    // Save the data to the database using the repository
				    dataRepository.save(data);
				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Double parseDoubleOrZero(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            // Handle invalid or empty values by returning 0.0
            return 0.0;
        }
    }
}

