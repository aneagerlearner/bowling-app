package com.bowling.service.dto;

/**
 * A DTO representing a Game
 */
public class GameDTO {
	
	
	private Long id;

    private String alleyNo;

    private Integer noOfPlayers;

    BowlingUserDTO user;
    

	public GameDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public GameDTO(Long id, String alleyNo, Integer noOfPlayers, BowlingUserDTO user) {
		super();
		this.id = id;
		this.alleyNo = alleyNo;
		this.noOfPlayers = noOfPlayers;
		this.user = user;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlleyNo() {
		return alleyNo;
	}

	public void setAlleyNo(String alleyNo) {
		this.alleyNo = alleyNo;
	}

	public Integer getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(Integer noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public BowlingUserDTO getUser() {
		return user;
	}

	public void setUser(BowlingUserDTO user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "GameDTO [id=" + id + ", alleyNo=" + alleyNo + ", noOfPlayers=" + noOfPlayers + ", user=" + user + "]";
	}

 }
