
public class ParametrosInvalidosException extends Exception {

    //construtor padrão
    public ParametrosInvalidosException() {
        super("O primeiro parâmetro deve ser menor que o segundo parâmetro.");
    }

    //construtor com mensagem personalizada
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}
