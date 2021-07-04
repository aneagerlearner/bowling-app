package com.bowling.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bowling_user")
public class BowlingUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "score")
    private Integer score;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "max_score")
    private Integer maxScore;

    @OneToMany(mappedBy = "bowlingUser")
    private Set<Frame> frames = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("bowlingUsers")
    private Game game;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BowlingUser name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public BowlingUser score(Integer score) {
        this.score = score;
        return this;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public BowlingUser paymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public BowlingUser maxScore(Integer maxScore) {
        this.maxScore = maxScore;
        return this;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Set<Frame> getFrames() {
        return frames;
    }

    public BowlingUser frames(Set<Frame> frames) {
        this.frames = frames;
        return this;
    }

    public BowlingUser addFrame(Frame frame) {
        this.frames.add(frame);
        frame.setBowlingUser(this);
        return this;
    }

    public BowlingUser removeFrame(Frame frame) {
        this.frames.remove(frame);
        frame.setBowlingUser(null);
        return this;
    }

    public void setFrames(Set<Frame> frames) {
        this.frames = frames;
    }

    public Game getGame() {
        return game;
    }

    public BowlingUser game(Game game) {
        this.game = game;
        return this;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BowlingUser)) {
            return false;
        }
        return id != null && id.equals(((BowlingUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BowlingUser{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", score=" + getScore() +
            ", paymentType='" + getPaymentType() + "'" +
            ", maxScore=" + getMaxScore() +
            "}";
    }
}
