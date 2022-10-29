package pe.unjfsc.daw.spring5.entity;

public class CERutaDTOEntrada {
	private int id;
	private String empresa;
	private int ruc;
	private String direccion;
	private String ubicacion;
	private String fecha;
	private String hora;
	private String tipo_comp;
	private String n_comp;
	private String categoria;
	private double importe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getRuc() {
		return ruc;
	}
	public void setRuc(int ruc) {
		this.ruc = ruc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getTipo_comp() {
		return tipo_comp;
	}
	public void setTipo_comp(String tipo_comp) {
		this.tipo_comp = tipo_comp;
	}
	public String getN_comp() {
		return n_comp;
	}
	public void setN_comp(String n_comp) {
		this.n_comp = n_comp;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CERutaDTOEntrada [id=");
		builder.append(id);
		builder.append(", empresa=");
		builder.append(empresa);
		builder.append(", ruc=");
		builder.append(ruc);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", ubicacion=");
		builder.append(ubicacion);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", hora=");
		builder.append(hora);
		builder.append(", tipo_comp=");
		builder.append(tipo_comp);
		builder.append(", n_comp=");
		builder.append(n_comp);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append(", importe=");
		builder.append(importe);
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}
	
	
	
	
}
