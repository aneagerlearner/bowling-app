package com.bowling.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * A Game.
 */
@Entity
@Table(name = "game")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private ZonedDateTime startTime;

    @Column(name = "end_time")
    private ZonedDateTime endTime;

    @NotNull
    @Column(name = "alley_no", nullable = false)
    private String alleyNo;

    @Column(name = "no_of_players")
    private Integer noOfPlayers;

    @OneToMany(mappedBy = "game")
    private Set<BowlingUser> bowlingUsers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public Game startTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public Game endTime(ZonedDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public String getAlleyNo() {
        return alleyNo;
    }

    public Game alleyNo(String alleyNo) {
        this.alleyNo = alleyNo;
        return this;
    }

    public void setAlleyNo(String alleyNo) {
        this.alleyNo = alleyNo;
    }

    public Integer getNoOfPlayers() {
        return noOfPlayers;
    }

    public Game noOfPlayers(Integer noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        return this;
    }

    public void setNoOfPlayers(Integer noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    public Set<BowlingUser> getBowlingUsers() {
        return bowlingUsers;
    }

    public Game bowlingUsers(Set<BowlingUser> bowlingUsers) {
        this.bowlingUsers = bowlingUsers;
        return this;
    }

    public Game addBowlingUser(BowlingUser bowlingUser) {
        this.bowlingUsers.add(bowlingUser);
        bowlingUser.setGame(this);
        return this;
    }

    public Game removeBowlingUser(BowlingUser bowlingUser) {
        this.bowlingUsers.remove(bowlingUser);
        bowlingUser.setGame(null);
        return this;
    }

    public void setBowlingUsers(Set<BowlingUser> bowlingUsers) {
        this.bowlingUsers = bowlingUsers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Game)) {
            return false;
        }
        return id != null && id.equals(((Game) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Game{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", alleyNo='" + getAlleyNo() + "'" +
            ", noOfPlayers=" + getNoOfPlayers() +
            "}";
    }
}
