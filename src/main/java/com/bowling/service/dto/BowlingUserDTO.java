package com.bowling.service.dto;

public class BowlingUserDTO {
	
    private Long id;

    private String name;

    private Integer score;

    private String paymentType;

    private Integer maxScore;

    FrameDTO frame;

	public BowlingUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BowlingUserDTO(Long id, String name, Integer score, String paymentType, Integer maxScore, FrameDTO frame) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.paymentType = paymentType;
		this.maxScore = maxScore;
		this.frame = frame;
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

	public FrameDTO getFrame() {
		return frame;
	}

	public void setFrame(FrameDTO frame) {
		this.frame = frame;
	}

	@Override
	public String toString() {
		return "BowlingUserDTO [id=" + id + ", name=" + name + ", score=" + score + ", paymentType=" + paymentType
				+ ", maxScore=" + maxScore + ", frame=" + frame + "]";
	}

	
}
