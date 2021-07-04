package com.bowling.dto;

public class FrameDTO {

	
	private Long id;

	private Boolean isStrike;

	private Boolean isSpare;

	private Integer noOfRolls;

	private Integer score;

	private FrameDTO(Builder builder) {
		this.id = builder.id;
		this.isStrike = builder.isStrike;
		this.isSpare = builder.isSpare;
		this.noOfRolls = builder.noOfRolls;
		this.score = builder.score;
	}

	public FrameDTO(Long id, Boolean isStrike, Boolean isSpare, Integer noOfRolls, Integer score) {
		super();
		this.id = id;
		this.isStrike = isStrike;
		this.isSpare = isSpare;
		this.noOfRolls = noOfRolls;
		this.score = score;
	}

	public FrameDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsStrike() {
		return isStrike;
	}

	public void setIsStrike(Boolean isStrike) {
		this.isStrike = isStrike;
	}

	public Boolean getIsSpare() {
		return isSpare;
	}

	public void setIsSpare(Boolean isSpare) {
		this.isSpare = isSpare;
	}

	public Integer getNoOfRolls() {
		return noOfRolls;
	}

	public void setNoOfRolls(Integer noOfRolls) {
		this.noOfRolls = noOfRolls;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "FrameDTO [id=" + id + ", isStrike=" + isStrike + ", isSpare=" + isSpare + ", noOfRolls=" + noOfRolls
				+ ", score=" + score + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private Boolean isStrike;
		private Boolean isSpare;
		private Integer noOfRolls;
		private Integer score;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withIsStrike(Boolean isStrike) {
			this.isStrike = isStrike;
			return this;
		}

		public Builder withIsSpare(Boolean isSpare) {
			this.isSpare = isSpare;
			return this;
		}

		public Builder withNoOfRolls(Integer noOfRolls) {
			this.noOfRolls = noOfRolls;
			return this;
		}

		public Builder withScore(Integer score) {
			this.score = score;
			return this;
		}

		public FrameDTO build() {
			return new FrameDTO(this);
		}
	}
	


}
