package preparacaoProva.CarlosPreparacao.entity;

import com.sun.jdi.ShortType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Table(name = "filme")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filme_id")
    private Short id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ano_de_lancamento")
    private Integer anoLancamento;

    @Column(name = "idioma_id")
    private Short idiomaID;

    @Column(name = "idioma_original_id")
    private Short idiomaOriginalId;

    @Column(name = "duracao_da_locacao")
    private Short duracaoLocacao;

    @Column(name = "preco_da_locacao")
    private BigDecimal precoLocacao;

    @Column(name = "duracao_do_filme")
    private Short duracaoFilme;

    @Column(name = "custo_de_substituicao")
    private BigDecimal custoSubstituicao;

    @Column(name = "classificacao")
    private String classificacao;

    @Column(name = "recursos_especiais")
    private String recursosEspecias;

    @Column(name = "ultima_atualizacao")
    private Timestamp ultimaAtualizacao;

}
