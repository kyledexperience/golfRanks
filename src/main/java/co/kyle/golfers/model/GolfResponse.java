package co.kyle.golfers.model;

import java.util.List;

public class GolfResponse {

	private List<Players> players;

	public List<Players> getPlayers() {
		return players;
	}

	public void setPlayers(List<Players> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "GolfResponse = [" + players + "]";
	}

}
