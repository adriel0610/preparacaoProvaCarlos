package preparacaoProva.CarlosPreparacao.mapper;

import preparacaoProva.CarlosPreparacao.dto.FilmeCreateRequest;
import preparacaoProva.CarlosPreparacao.dto.FilmeResponse;
import preparacaoProva.CarlosPreparacao.dto.FilmeUpdateRequest;
import preparacaoProva.CarlosPreparacao.entity.Filme;

import java.util.List;

public class FilmeMapper {

    /**
     * converte os dados em uma entidade filme
     * @param request dados
     * @return Filme
     */
    public Filme toEntity(FilmeCreateRequest request){

        return Filme.builder()
                .titulo(request.titulo())
                .descricao(request.descricao())
                .anoLancamento(request.anoLancamento())
                .idiomaID(request.idiomaID())
                .idiomaOriginalId(request.idiomaOriginalId())
                .duracaoLocacao(request.duracaoLocacao())
                .precoLocacao(request.precoLocacao())
                .duracaoFilme(request.duracaoFilme())
                .custoSubstituicao(request.custoSubstituicao())
                .classificacao(request.classificacao())
                .recursosEspecias(request.recusrsosEspeciais())
                .ultimaAtualizacao(request.ultimaAtualizacao())
                .build();
    }

    /**
     * converte uma entidade filme para dto de resposta
     * @param filme entidade fornecida
     * @return representação do filme
     */

    public FilmeResponse toResponse(Filme filme){
        return new FilmeResponse(
                filme.getId(),
                filme.getTitulo()
        );
    }

    /**
     * Converte uma lista de entidades em dto resposta
     */
    public List<FilmeResponse> toResponseList(List<Filme> filmes){
        return filmes.stream()
                .map(this::toResponse)
                .toList();
    }

    public void update(FilmeUpdateRequest request, Filme filme){
        filme.setTitulo(request.titulo());
        filme.setDescricao(request.descricao());
        filme.setAnoLancamento(request.anoLancamento());
        filme.setIdiomaID(request.idiomaID());
        filme.setIdiomaOriginalId(request.idiomaOriginalId());
        filme.setDuracaoLocacao(request.duracaoLocacao());
        filme.setPrecoLocacao(request.precoLocacao());
        filme.setDuracaoFilme(request.duracaoFilme());
        filme.setCustoSubstituicao(request.custoSubstituicao());
        filme.setClassificacao(request.classificacao());
        filme.setRecursosEspecias(request.recusrsosEspeciais());
        filme.setUltimaAtualizacao(request.ultimaAtualizacao());
    }
}
