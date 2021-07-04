package com.bowling.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "frame")
public class Frame implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_strike")
    private Boolean isStrike;

    @Column(name = "is_spare")
    private Boolean isSpare;

    @Column(name = "no_of_rolls")
    private Integer noOfRolls;

    @Column(name = "score")
    private Integer score;

    @ManyToOne
    @JsonIgnoreProperties("frames")
    private BowlingUser bowlingUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsStrike() {
        return isStrike;
    }

    public Frame isStrike(Boolean isStrike) {
        this.isStrike = isStrike;
        return this;
    }

    public void setIsStrike(Boolean isStrike) {
        this.isStrike = isStrike;
    }

    public Boolean isIsSpare() {
        return isSpare;
    }

    public Frame isSpare(Boolean isSpare) {
        this.isSpare = isSpare;
        return this;
    }

    public void setIsSpare(Boolean isSpare) {
        this.isSpare = isSpare;
    }

    public Integer getNoOfRolls() {
        return noOfRolls;
    }

    public Frame noOfRolls(Integer noOfRolls) {
        this.noOfRolls = noOfRolls;
        return this;
    }

    public void setNoOfRolls(Integer noOfRolls) {
        this.noOfRolls = noOfRolls;
    }

    public Integer getScore() {
        return score;
    }

    public Frame score(Integer score) {
        this.score = score;
        return this;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public BowlingUser getBowlingUser() {
        return bowlingUser;
    }

    public Frame bowlingUser(BowlingUser bowlingUser) {
        this.bowlingUser = bowlingUser;
        return this;
    }

    public void setBowlingUser(BowlingUser bowlingUser) {
        this.bowlingUser = bowlingUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Frame)) {
            return false;
        }
        return id != null && id.equals(((Frame) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Frame{" +
            "id=" + getId() +
            ", isStrike='" + isIsStrike() + "'" +
            ", isSpare='" + isIsSpare() + "'" +
            ", noOfRolls=" + getNoOfRolls() +
            ", score=" + getScore() +
            "}";
    }
}
