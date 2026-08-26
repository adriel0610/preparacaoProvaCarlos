package preparacaoProva.CarlosPreparacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * dados que são utilizados para criar o filme
 * @param titulo
 * @param descricao
 * @param anoLancamento
 * @param idiomaID
 * @param idiomaOriginalId
 * @param duracaoLocacao
 * @param precoLocacao
 * @param duracaoFilme
 * @param custoSubstituicao
 * @param classificacao
 * @param recusrsosEspeciais
 * @param ultimaAtualizacao
 */

@Schema(description = "dados para criação de filme")
public record FilmeCreateRequest (

    @Schema(
            description = "Titulo do filme",
            example ="Homem aranha - Um novo dia "
    )
    @NotBlank(message = "O titulo do filme é obrigatorio")
    @Size(min = 3,max = 255,message = "O titulo deve conter entre 3 a 255 caracteres")
    String titulo,


    @Schema(
            description = "Descrição do filme",
            example = "Peter Parker vive completamente sozinho e anônimo em Nova York, quatro anos após ter sua identidade apagada da memória de todos no final de Sem Volta Para Casa"
    )
    String descricao,


    @Schema(
            description = "Indica o ano de lançamento do filme",
            example = "2026"
    )
    Integer anoLancamento,


    @Schema(
            description = "indica qual o idioma do filme pelo id",
            example = "1"
    )
    @NotNull(message = "id idioma não pode ser vazio!")
    @Positive(message = "O valor deve ser positivo")
    Short idiomaID,


    @Schema(
            description = "indica qual é o idioma original do filme ",
            example = "1"
    )
    @Positive(message = "o valor deve ser positivo")
    Short idiomaOriginalId,


    @Schema(
            description = "Vai falar quanto tempo voce pode ficar com o filme em dias",
            example = "2"
    )
    @NotNull(message = "duração locação não pode ser null")
    @Positive(message = "o valor deve ser positivo")
    Short duracaoLocacao,

    @Schema(
            description = "Preço da locação do filme",
            example = "10.00"
    )
    @NotNull(message = "Preco não poder null!!")
    @Positive(message = "o valor deve ser positivo")
    BigDecimal precoLocacao,

    @Schema(
            description = "Indica quanto tempo de duração tem o filme em horas",
            example = "2"
    )
    @Positive(message = "o valor deve ser posito")
    Short duracaoFilme,


    @Schema(
            description = "indica o preco da multa quando quiser trocar o filme",
            example = "20.00"
    )
    @NotNull(message = "O valor não deve ser null")
    @Positive(message = "o valor deve ser positivo")
    BigDecimal custoSubstituicao,

    @Schema(
            description = "Indica a classificação do filme",
            example = "G"
    )
    String classificacao,

    @Schema(
            description = "recusos que o filme contem",
            example = "Trailer"
    )
    String recusrsosEspeciais,


    @Schema(
            description = "fala a ultima aualização do filme",
            example = "25/08/2026 19:28:00"
    )
    @NotNull(message = "o valor não pode ser null")
    Timestamp ultimaAtualizacao

){}
