package br.com.exemplo.produtor.service;

import br.com.exemplo.produtor.cache.CustomCacheKeyGenerator;
import br.com.exemplo.produtor.model.Pessoa;
import io.quarkus.cache.CacheResult;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    @CacheResult(cacheName = "pessoa-cache", keyGenerator = CustomCacheKeyGenerator.class)
    public Pessoa getPessoa(String codigoTipoRegistro, String dataReferencia) {
        // Simula uma chamada demorada
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Pessoa("Fulano", 30, LocalDate.of(1994, 7, 30));
    }

    @CacheResult(cacheName = "pessoas-cache")
    public List<Pessoa> getPessoas() {
        // Simula uma chamada demorada
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(
                new Pessoa("Beltrano", 25, LocalDate.of(1999, 1, 15)),
                new Pessoa("Ciclano", 40, LocalDate.of(1984, 5, 20)),
                new Pessoa("Fulana", 35, LocalDate.of(1989, 10, 10))
        );
    }

    public Pessoa recuperaPessoa(String codigoTipoRegistro, String dataReferencia) {
        var pessoa = getPessoa(codigoTipoRegistro, dataReferencia);
        Log.infof("Recuperando pessoa: %s", pessoa);
        return pessoa;
    }

    public List<Pessoa> listaPessoas() {
        var pessoas = getPessoas();
        Log.infof("Listando pessoas: %s", pessoas);
        return pessoas;
    }
}
