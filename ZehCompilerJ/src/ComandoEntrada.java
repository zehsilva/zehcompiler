import java.util.ArrayDeque;



public class ComandoEntrada extends Comando {
	public ArrayDeque<String> listaVar=null;
	public ComandoEntrada(String msg,ArrayDeque<String> vars) {
		// TODO Auto-generated constructor stub
		this.comando=comtype.ENTRADA;
		this.str=msg;
		this.listaVar=vars;
	}

}
