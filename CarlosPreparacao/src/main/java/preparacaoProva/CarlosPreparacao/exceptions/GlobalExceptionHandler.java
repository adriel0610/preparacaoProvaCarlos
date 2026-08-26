package preparacaoProva.CarlosPreparacao.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import preparacaoProva.CarlosPreparacao.dto.ErroResponse;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FilmeNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarFilmeNãoEncontrado(
            FilmeNaoEncontradoException ex, HttpServletRequest request){
        ErroResponse erroResponse = ErroResponse.criar(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroResponse);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> tratarRegraDeNegocio(
           IllegalArgumentException ex,
            HttpServletRequest request
    ){
        ErroResponse erroResponse = ErroResponse.criar(
                HttpStatus.BAD_REQUEST.value(),
                "Recurso não encontrado",
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> tratarErroDeValidacao(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ){

        String mensagemErro=ex.getBindingResult().getFieldErrors().stream()
                .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ErroResponse erro = ErroResponse.criar(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de Validação",
                ex.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

        
    }

}
