package Exception;

@SuppressWarnings("serial")
public class FuncionarioJaCadastradoException extends RuntimeException {
	public FuncionarioJaCadastradoException(String msg){
		super(msg);
	}
}
