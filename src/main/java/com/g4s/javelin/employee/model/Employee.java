package com.g4s.javelin.employee.model;

import com.google.appengine.api.datastore.GeoPt;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.List;

/**
 * Created by sromares on 3/15/16.
 */
@Entity
public class Employee {

    @Id
    private String id;
    private String title;
    private String initials;
    private String firstname;
    private String middlename;
    private String surname;
    private String dateOfBirth;
    private String mobileNumber;
    private String landlineNumber;
    private String emergencyContactNumber;
    private String emailAddress;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String country;
    private String postCode;
    private GeoPt geoLocation;
    private String payIndicator;
    private String payGroup;
    private String basicHours;
    private String overtimeThreshold;
    private String rank;
    private Key<OverTimePeriod> overTimePeriod;
    private Key<JobType> jobType;
    private Key<RegulationOption> regulationOption;
    private List<Key<Role>> roles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public GeoPt getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoPt geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getPayIndicator() {
        return payIndicator;
    }

    public void setPayIndicator(String payIndicator) {
        this.payIndicator = payIndicator;
    }

    public String getPayGroup() {
        return payGroup;
    }

    public void setPayGroup(String payGroup) {
        this.payGroup = payGroup;
    }

    public String getBasicHours() {
        return basicHours;
    }

    public void setBasicHours(String basicHours) {
        this.basicHours = basicHours;
    }

    public String getOvertimeThreshold() {
        return overtimeThreshold;
    }

    public void setOvertimeThreshold(String overtimeThreshold) {
        this.overtimeThreshold = overtimeThreshold;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Key<RegulationOption> getRegulationOption() {
        return regulationOption;
    }

    public void setRegulationOption(
            Key<RegulationOption> regulationOption) {
        this.regulationOption = regulationOption;
    }

    public List<Key<Role>> getRoles() {
        return roles;
    }

    public void setRoles(List<Key<Role>> roles) {
        this.roles = roles;
    }

    public Key<OverTimePeriod> getOverTimePeriod() {
        return overTimePeriod;
    }

    public void setOverTimePeriod(
            Key<OverTimePeriod> overTimePeriod) {
        this.overTimePeriod = overTimePeriod;
    }

    public Key<JobType> getJobType() {
        return jobType;
    }

    public void setJobType(Key<JobType> jobType) {
        this.jobType = jobType;
    }
}
