package preparacaoProva.CarlosPreparacao.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import preparacaoProva.CarlosPreparacao.dto.FilmeCreateRequest;
import preparacaoProva.CarlosPreparacao.dto.FilmeResponse;
import preparacaoProva.CarlosPreparacao.dto.FilmeUpdateRequest;
import preparacaoProva.CarlosPreparacao.entity.Filme;
import preparacaoProva.CarlosPreparacao.exceptions.FilmeNaoEncontradoException;
import preparacaoProva.CarlosPreparacao.mapper.FilmeMapper;
import preparacaoProva.CarlosPreparacao.repository.Filmerepository;

import java.util.List;

@Service
public class FilmeService {
    private final Filmerepository repository;
    private final FilmeMapper mapper;


    public FilmeService(Filmerepository repository, FilmeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * cadas um novo filme com base nos dados recebidos apos ver se já contem algum filme igual
     * @param request objeto com os dados do novo filme
     * @return dto com os dados do filme
     * @throws IllegalArgumentException verifica se aquele filme já foi criado
     */
    @Transactional
    public FilmeResponse cadastrar(FilmeCreateRequest request){
        if (repository.existsByNomeIgnoreCase(request.titulo())){
            throw new IllegalArgumentException("Já existe filme");
        }
        Filme filme = mapper.toEntity(request);
        Filme salvo = repository.save(filme);

        return mapper.toResponse(salvo);
    }

    /**
     * Vai retornar todos os filmes cadastrados
     * @return Lista de dtos
     */
    @Transactional(readOnly = true)
    public List<FilmeResponse> listar(){
        List<Filme> filmes = repository.findAll();

        return mapper.toResponseList(filmes);
    }

    /**
     * busca um filme pelo seu id
     * @param id identificador unico
     * @return dto representando o filme encontrado
     */
    @Transactional(readOnly = true)
    public FilmeResponse buscarPorId(Short id){
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new FilmeNaoEncontradoException("Filme não encontrado com id: "+id));
    }


    /**
     * Busca filme pelo seu titulo
     * @param titulo titulo do filme
     * @return dto representando o filme encontrado
     */
    @Transactional(readOnly = true)
    public List<FilmeResponse> buscarPorNome(String titulo){

        return repository.findByNomeContainingIgnoreCase(titulo)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }


    /**
     * atualiza todos os dados de um produto existente
     * @param id identificador do filme
     * @param request dto dos novos dados do filme
     * @return dto representando o filme atualizado
     */
    @Transactional(readOnly = true)
    public FilmeResponse atualizar(Short id, FilmeUpdateRequest request){
        Filme filme = repository.findById(id)
                .orElseThrow(()-> new FilmeNaoEncontradoException("Filme não encontrado com id: "+id));

        mapper.update(request,filme);
        Filme atualizado = repository.save(filme);

        return mapper.toResponse(atualizado);
    }


    /**
     * remove o filme da base de dados pelo id
     * @param id identificador do filme
     */
    @Transactional
    public void remover(short id){
        Filme filme = repository.findById(id)
                .orElseThrow(()-> new FilmeNaoEncontradoException("Filme não encntrado com id:"+id));

        repository.delete(filme);
    }
}
