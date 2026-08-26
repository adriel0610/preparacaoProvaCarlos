package preparacaoProva.CarlosPreparacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Retorna o filme com os seguintes atributos
 *
 * @param id identificador do filme
 * @param titulo titulo do filme
 */
@Schema(description = "Dados do filme retornado pela Api")
public record FilmeResponse(
  @Schema(description = "Identificador do filme")
  Short id,
  @Schema(description = "Titulo do filme")
  String titulo
){}
