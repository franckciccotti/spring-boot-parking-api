package com.formation.parking.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReponseParkingAPIEntity {
    @JsonProperty(value = "records")
    public List<RecordEntity> records;

    public List<RecordEntity> getRecords() {
        return records;
    }
    public void setRecords(List<RecordEntity> records) {
        this.records = records;
    }

    @JsonProperty(value = "results")
    public List<ResultsEntity> results;

    public List<ResultsEntity> getResults() {
        return results;
    }
    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }
}
