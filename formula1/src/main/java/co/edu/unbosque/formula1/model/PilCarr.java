package co.edu.unbosque.formula1.model;

public class PilCarr {
	private int idPiloto;
	private int idCarrera;
	private int rankingFinal;

	public PilCarr() {
	}

	public PilCarr(int idPiloto, int idCarrera, int rankingFinal) {
		this.idPiloto = idPiloto;
		this.idCarrera = idCarrera;
		this.rankingFinal = rankingFinal;
	}

	public int getIdPiloto() {
		return idPiloto;
	}

	public void setIdPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public int getRankingFinal() {
		return rankingFinal;
	}

	public void setRankingFinal(int rankingFinal) {
		this.rankingFinal = rankingFinal;
	}

}
