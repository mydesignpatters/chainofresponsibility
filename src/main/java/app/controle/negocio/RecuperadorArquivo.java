package app.controle.negocio;

/**
 * Superclasse que define um elemento da cadeia
 */
public abstract class RecuperadorArquivo {
    //representa o próximo elemento
    RecuperadorArquivo proximo;

    public RecuperadorArquivo(RecuperadorArquivo proximo) {
        this.proximo = proximo;
    }

    /**
     * Tenta recuperar o arquivo, retornando-o se ele for válido e chamando o próximo elemento da cadeia em caso negativo.
     */
    public Arquivo recuperar(String nome) {
        Arquivo a = recuperaArquivo(nome);

        if (a == null || !a.isValido())
            return chamarProximo(nome);
        else
            return a;
    }

    /**
     * Responsável por verificar se existe um próximo elemento e invocá-lo
     */
    protected Arquivo chamarProximo(String nome) {
        if (proximo == null) {
            throw new RuntimeException("Não foi possível " + " recuperar o arquivo");
        }
        return proximo.recuperar(nome);
    }

    /**
     * Hook method que deve ser implementado pelas subclasses para a recuperação do arquivo de acordo com a estratégia desejada.
     * @param nome Nome do Arquivo
     * @return o Arquivo recuperado
     */
    protected abstract Arquivo recuperaArquivo(String nome);
}