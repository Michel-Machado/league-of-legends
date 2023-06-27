package br.com.foguete.leagueOfLegends.adapter.in.dto;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampeaoDto {

    private String nome;
    private String genero;

    private Posicao posicao;

    private String especie;

    private String recurso;

    private String tipoDeAlcance;

    private String regiao;

    private Integer anoDeLancamento;

    public CampeaoDto(String nome, String genero, Posicao posicao, String especie, String recurso, String tipoDeAlcance, String regiao, Integer anoDeLancamento) {
        this.nome = nome;
        this.genero = genero;
        this.posicao = posicao;
        this.especie = especie;
        this.recurso = recurso;
        this.tipoDeAlcance = tipoDeAlcance;
        this.regiao = regiao;
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public CampeaoDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public CampeaoDto setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public CampeaoDto setPosicao(Posicao posicao) {
        this.posicao = posicao;
        return this;
    }

    public String getEspecie() {
        return especie;
    }

    public CampeaoDto setEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    public String getRecurso() {
        return recurso;
    }

    public CampeaoDto setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    public String getTipoDeAlcance() {
        return tipoDeAlcance;
    }

    public CampeaoDto setTipoDeAlcance(String tipoDeAlcance) {
        this.tipoDeAlcance = tipoDeAlcance;
        return this;
    }

    public String getRegiao() {
        return regiao;
    }

    public CampeaoDto setRegiao(String regiao) {
        this.regiao = regiao;
        return this;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public CampeaoDto setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
        return this;
    }

    public static CampeaoDto from(Campeao campeao){

        return new CampeaoDto(campeao.getName(),
                campeao.getGender(),
                campeao.getPosition(),
                campeao.getSpecies(),
                campeao.getResource(),
                campeao.getRangeType(),
                campeao.getRegion(),
                campeao.getYearOfLaunch());

    }
}
