package com.future8.droneapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deliveries")
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "drone_id")
  @JsonBackReference
  private Drone drone;

  @OneToOne(
      mappedBy = "delivery",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  @JsonIgnore
  private Video video;

  private LocalDate deliveredDate;
  private String destiny;
  private String status;

  public Delivery() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }

  public LocalDate getDeliveredDate() {
    return deliveredDate;
  }

  public void setDeliveredDate(LocalDate deliveredDate) {
    this.deliveredDate = deliveredDate;
  }

  public String getDestiny() {
    return destiny;
  }

  public void setDestiny(String destiny) {
    this.destiny = destiny;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }
}
