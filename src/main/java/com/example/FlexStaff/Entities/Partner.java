package com.example.FlexStaff.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Partner extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idP")
    private int idP;

    @NonNull
    @Column(name = "businessName")
    private String businessName;

    @Column(name = "description")
    private String description;

    @Column(name = "businessLocation")
    private String businessLocation;

    @Column(name = "sector")
    private String sector;

    @Lob
    @Column(name = "profileImgData")
    private byte[] profileImgData;

    @Column(name = "profileImgName")
    private String profileImgName;

    @OneToMany (mappedBy = "partner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference (value = "partner-jobs")
    private List<Job> jobs;

    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
    @JsonManagedReference (value = "partner-rate")
    private List<PartnerRating> ratings;

    @ManyToMany (mappedBy = "favorites")
    @JsonIgnore
    private List<Client> favoredBy;

    public Partner(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, String region, @NonNull String businessName, String description, String businessLocation, String sector) {
        super(firstName, lastName, email, password, region);
        this.businessName = businessName;
        this.description = description;
        this.businessLocation = businessLocation;
        this.sector = sector;
    }

    public Partner(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, String region, @NonNull String businessName, String description, String businessLocation, String sector, List<Job> jobs) {
        super(firstName, lastName, email, password, region);
        this.businessName = businessName;
        this.description = description;
        this.businessLocation = businessLocation;
        this.sector = sector;
        this.jobs = jobs;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public byte[] getProfileImgData() {
        return profileImgData;
    }

    public void setProfileImgData(byte[] profileImgData) {
        this.profileImgData = profileImgData;
    }

    public String getProfileImgName() {
        return profileImgName;
    }

    public void setProfileImgName(String profileImgName) {
        this.profileImgName = profileImgName;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<PartnerRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<PartnerRating> ratings) {
        this.ratings = ratings;
    }

    public List<Client> getFavoredBy() {
        return favoredBy;
    }

    public void setFavoredBy(List<Client> favoredBy) {
        this.favoredBy = favoredBy;
    }

    public void addJob(Job j) {
        jobs.add(j);
    }
}
