package Exception;

@SuppressWarnings("serial")
public class FuncionarioInexistenteException extends RuntimeException  {
	public FuncionarioInexistenteException(String msg){
		super(msg);
	}
}
