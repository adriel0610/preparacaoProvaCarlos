package preparacaoProva.CarlosPreparacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import preparacaoProva.CarlosPreparacao.entity.Filme;

import java.util.List;

/**
 * Ele é responsavel pelo acesso de dados de Filme
 */
public interface Filmerepository extends JpaRepository<Filme,Short> {
    /**
     * Vai ver se o Filme existe com o nome enviado
     * ignorando letras maiusculas e minusculas
     * @param titulo titulo que vai ser pesquisado
     * @return ira retornar um boolena que vai ser {true} caso o filme exista com o nome
     */
    boolean existsByNomeIgnoreCase(String titulo);


    /**
     * Vai buscar o filme com o nome informado
     * @param titulo titulo do filme que vai ser buscado
     * @return filmes encontrados
     */
    List<Filme> findByNomeContainingIgnoreCase(String titulo);
}
