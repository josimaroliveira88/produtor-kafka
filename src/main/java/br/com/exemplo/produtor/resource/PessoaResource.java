package br.com.exemplo.produtor.resource;

import br.com.exemplo.produtor.model.Pessoa;
import br.com.exemplo.produtor.service.PessoaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoa")
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa getPessoa(
            @QueryParam("codigo-tipo-registro") String codigoTipoRegistro,
            @QueryParam("data-referencia") String dataReferencia) {
        return pessoaService.recuperaPessoa(codigoTipoRegistro, dataReferencia);
    }

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> getPessoas() {
        return pessoaService.listaPessoas();
    }
}
