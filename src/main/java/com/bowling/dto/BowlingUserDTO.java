package com.bowling.dto;

import java.util.Collections;
import java.util.List;

public class BowlingUserDTO {
	
    private Long id;

    private String name;

    private Integer score;

    private String paymentType;

    private Integer maxScore;

    List<FrameDTO> frames;

	private BowlingUserDTO(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.score = builder.score;
		this.paymentType = builder.paymentType;
		this.maxScore = builder.maxScore;
		this.frames = builder.frames;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

	public List<FrameDTO> getFrames() {
		return frames;
	}

	public void setFrames(List<FrameDTO> frames) {
		this.frames = frames;
	}

	public BowlingUserDTO(Long id, String name, Integer score, String paymentType, Integer maxScore,
			List<FrameDTO> frames) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.paymentType = paymentType;
		this.maxScore = maxScore;
		this.frames = frames;
	}

	public BowlingUserDTO() {
		super();
	}

	@Override
	public String toString() {
		return "BowlingUserDTO [id=" + id + ", name=" + name + ", score=" + score + ", paymentType=" + paymentType
				+ ", maxScore=" + maxScore + ", frame=" + frames + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String name;
		private Integer score;
		private String paymentType;
		private Integer maxScore;
		private List<FrameDTO> frames = Collections.emptyList();

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withScore(Integer score) {
			this.score = score;
			return this;
		}

		public Builder withPaymentType(String paymentType) {
			this.paymentType = paymentType;
			return this;
		}

		public Builder withMaxScore(Integer maxScore) {
			this.maxScore = maxScore;
			return this;
		}

		public Builder withFrames(List<FrameDTO> frames) {
			this.frames = frames;
			return this;
		}

		public BowlingUserDTO build() {
			return new BowlingUserDTO(this);
		}
	}
	
}
