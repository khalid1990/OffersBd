package com.babar.offer.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sherlock
 * @since 2/8/18.
 */
@Entity
public class Offer {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String offerUrl;

    private String description;

    private String imageUrl;

    @ManyToOne
    private Company company;

    @ManyToOne
    private OfferType offerType;

    private Date fromDate;

    private Date toDate;

    @ManyToOne
    private Login createdBy;

    private Date created;

    @ManyToOne
    private Login lastUpdatedBy;

    private Date updated;

    private long upVote;

    private long downVote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOfferUrl() {
        return offerUrl;
    }

    public void setOfferUrl(String offerUrl) {
        this.offerUrl = offerUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Login getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Login createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Login getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Login lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public long getUpVote() {
        return upVote;
    }

    public void setUpVote(long upVote) {
        this.upVote = upVote;
    }

    public long getDownVote() {
        return downVote;
    }

    public void setDownVote(long downVote) {
        this.downVote = downVote;
    }
}
