package co.kyle.golfers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Players {

	@JsonProperty("WorldGolfRank")
	private Integer rank;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("TotalPoints")
	private Double points;

	@JsonProperty("Season")
	private Integer season;

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer ranking) {
		this.rank = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String named) {
		this.name = named;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double point) {
		this.points = point;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ",rank=" + rank + "points=" + points + "]";
	}

}
