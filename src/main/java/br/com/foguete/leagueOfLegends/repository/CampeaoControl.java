package br.com.foguete.leagueOfLegends.repository;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Document(collection = "league-of-legends")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CampeaoControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;

    private String genero;

    private Posicao posicao;

    private String especie;

    private String recurso;

    private String tipodeAlcance;

    private String regiao;

    private Integer AnoDeLancamento;

    public CampeaoControl() {
    }

    public CampeaoControl(String id, String nome, String genero, Posicao posicao, String especie, String recurso, String tipodeAlcance, String regiao, Integer anoDeLancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.posicao = posicao;
        this.especie = especie;
        this.recurso = recurso;
        this.tipodeAlcance = tipodeAlcance;
        this.regiao = regiao;
        AnoDeLancamento = anoDeLancamento;
    }

    public String getId() {
        return id;
    }

    public CampeaoControl setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CampeaoControl setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public CampeaoControl setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public CampeaoControl setPosicao(Posicao posicao) {
        this.posicao = posicao;
        return this;
    }

    public String getEspecie() {
        return especie;
    }

    public CampeaoControl setEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    public String getRecurso() {
        return recurso;
    }

    public CampeaoControl setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    public String getTipodeAlcance() {
        return tipodeAlcance;
    }

    public CampeaoControl setTipodeAlcance(String tipodeAlcance) {
        this.tipodeAlcance = tipodeAlcance;
        return this;
    }

    public String getRegiao() {
        return regiao;
    }

    public CampeaoControl setRegiao(String regiao) {
        this.regiao = regiao;
        return this;
    }

    public Integer getAnoDeLancamento() {
        return AnoDeLancamento;
    }

    public CampeaoControl setAnoDeLancamento(Integer anoDeLancamento) {
        AnoDeLancamento = anoDeLancamento;
        return this;
    }
    public static CampeaoControl campeaoControl(Campeao campeao){
        return new CampeaoControl()
                .setNome(campeao.getName())
                .setGenero(campeao.getGender())
                .setPosicao(campeao.getPosition())
                .setEspecie(campeao.getSpecies())
                .setRecurso(campeao.getResource())
                .setTipodeAlcance(campeao.getRangeType())
                .setRegiao(campeao.getRegion())
                .setAnoDeLancamento(campeao.getYearOfLaunch());
    }

    public static CampeaoControl atualizaCampeao(CampeaoControl campeaoControl, Campeao campeao){
        return campeaoControl.setNome(campeao.getName())
                .setGenero(campeao.getGender())
                .setPosicao(campeao.getPosition())
                .setEspecie(campeao.getSpecies())
                .setRecurso(campeao.getResource())
                .setTipodeAlcance(campeao.getRangeType())
                .setRegiao(campeao.getRegion())
                .setAnoDeLancamento(campeao.getYearOfLaunch());



    }
}
