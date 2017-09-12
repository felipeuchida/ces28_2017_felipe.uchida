public class CaninePrincipal {
	private String latidoPrincipal;
	private CanineGancho gancho;
	
	public CaninePrincipal(String latido, CanineGancho gancho){
		latidoPrincipal = latido;
		this.gancho = gancho;
	}
	
	public String BarkPrincipal(){
		return latidoPrincipal + gancho.BarkGancho();
	}
}
