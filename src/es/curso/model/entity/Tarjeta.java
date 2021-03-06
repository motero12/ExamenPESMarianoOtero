package es.curso.model.entity;

public class Tarjeta {
	private int id;
	private String numeroTarjeta;
	private int cupoMaximo;
	private int cupoDisponible;
	private String tipoTarjeta;
	private String numeroComprobacion;
	private short contrasenha;
	private byte bloqueada;
	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tarjeta(int id, String numeroTarjeta, int cupoMaximo,
			int cupoDisponible, String tipoTarjeta, String numeroComprobacion,
			short contrasenha, byte bloqueada) {
		super();
		this.id = id;
		this.numeroTarjeta = numeroTarjeta;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipoTarjeta = tipoTarjeta;
		this.numeroComprobacion = numeroComprobacion;
		this.contrasenha = contrasenha;
		this.bloqueada = bloqueada;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public int getCupoMaximo() {
		return cupoMaximo;
	}
	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}
	public int getCupoDisponible() {
		return cupoDisponible;
	}
	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getNumeroComprobacion() {
		return numeroComprobacion;
	}
	public void setNumeroComprobacion(String numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}
	public short getContrasenha() {
		return contrasenha;
	}
	public void setContrasenha(short contrasenha) {
		this.contrasenha = contrasenha;
	}
	public byte getBloqueada() {
		return bloqueada;
	}
	public void setBloqueada(byte bloqueada) {
		this.bloqueada = bloqueada;
	}
	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", numeroTarjeta=" + numeroTarjeta
				+ ", cupoMaximo=" + cupoMaximo + ", cupoDisponible="
				+ cupoDisponible + ", tipoTarjeta=" + tipoTarjeta
				+ ", numeroComprobacion=" + numeroComprobacion
				+ ", contrasenha=" + contrasenha + ", bloqueada=" + bloqueada
				+ "]";
	}
	
}
