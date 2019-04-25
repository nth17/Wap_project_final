package com.ethioProject.Bean;


public class Team {

	private int TeamId;
	private String TeamName;
	
	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	@Override
	public String toString() {
		return "Team{" +
				"TeamId :" + TeamId +
				", TeamName :'" + TeamName + '\'' +
				'}';
	}
}

