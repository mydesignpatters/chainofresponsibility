package app.controle.negocio;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que define o recuperador que define o cache em memória
 */
public class RecuperadorCacheMemoria extends RecuperadorArquivo {
    Map<String, Arquivo> cache = new HashMap<>();

    public RecuperadorCacheMemoria(RecuperadorArquivo proximo) {
        super(proximo);
    }

    @Override
    protected Arquivo recuperaArquivo(String nome) {
        //faz a busca do arquivo no mapa (cache) de arquivos
        if (cache.containsKey(nome)){
            cache.get(nome);
        }
        return null;
    }

    /**
     * Chama o proximo arquivo e coloca o arquivo corrente na cache de arquivos
     */
    protected Arquivo chamarProximo(String nome){
        //chama o proximo
        Arquivo a = super.chamarProximo(nome);
        //coloca o arquivo corrente no mapa (cache) de arquivos
        cache.put(nome, a);
        return a;
    }
    
}