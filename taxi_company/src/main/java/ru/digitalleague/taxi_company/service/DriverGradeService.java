package ru.digitalleague.taxi_company.service;

public interface DriverGradeService {

    int getDriverGradeSumById(Long driverId);

    int getDriverTripSumById(Long driverId);

    void updateSumTrip(Long driverId);

    void updateGrade(Long driverId, int grade);

}
