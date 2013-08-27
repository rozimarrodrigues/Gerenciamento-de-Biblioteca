package Exception;

@SuppressWarnings("serial")
public class ProfessorInexistenteException extends RuntimeException {
	
	public ProfessorInexistenteException(String msg){
		super(msg);
	}
}
