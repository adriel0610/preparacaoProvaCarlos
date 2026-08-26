package preparacaoProva.CarlosPreparacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ErroResponse (
        @Schema(description = "Codigo de status http", example = "404")
        Integer status,
        @Schema(description = "descreve o tipo de erro", example = "recurso não encontrado")
        String erro,
        @Schema(description = "mensagem detalhada do erro", example = "filme não encontrado com id = 1")
        String mensagem,
        @Schema(description = "Url de onde surgiu o erro", example = "/filme/2")
        String caminho,
        @Schema(description = "data e hora do erro", example = "2026-08-25T20:20:37")
        LocalDateTime timeStamp

){
    public static @NotNull ErroResponse criar(Integer status,String erro, String mensagem, String caminho){
        return new ErroResponse(status,erro,mensagem,caminho,LocalDateTime.now());
    }
}
