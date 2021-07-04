package com.bowling.dto;

import java.util.Collections;
import java.util.List;

public class GameDTO {
	
	
	private Long id;

    private String alleyNo;

    private Integer noOfPlayers;

    List<BowlingUserDTO> users;

	private GameDTO(Builder builder) {
		this.id = builder.id;
		this.alleyNo = builder.alleyNo;
		this.noOfPlayers = builder.noOfPlayers;
		this.users = builder.users;
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

	public List<BowlingUserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<BowlingUserDTO> users) {
		this.users = users;
	}

	public GameDTO(Long id, String alleyNo, Integer noOfPlayers, List<BowlingUserDTO> users) {
		super();
		this.id = id;
		this.alleyNo = alleyNo;
		this.noOfPlayers = noOfPlayers;
		this.users = users;
	}

	public GameDTO() {
		super();
	}

	@Override
	public String toString() {
		return "GameDTO [id=" + id + ", alleyNo=" + alleyNo + ", noOfPlayers=" + noOfPlayers + ", user=" + users + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String alleyNo;
		private Integer noOfPlayers;
		private List<BowlingUserDTO> users = Collections.emptyList();

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withAlleyNo(String alleyNo) {
			this.alleyNo = alleyNo;
			return this;
		}

		public Builder withNoOfPlayers(Integer noOfPlayers) {
			this.noOfPlayers = noOfPlayers;
			return this;
		}

		public Builder withUsers(List<BowlingUserDTO> users) {
			this.users = users;
			return this;
		}

		public GameDTO build() {
			return new GameDTO(this);
		}
	}
 }
