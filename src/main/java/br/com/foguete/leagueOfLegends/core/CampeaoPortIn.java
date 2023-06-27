package br.com.foguete.leagueOfLegends.core;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;

import java.util.List;

public interface CampeaoPortIn {
    List<Campeao> findAllCampeao(String name, String gender, Posicao position, String species, String resource, String rangeType, String region, Integer yearOfLaunch);

    String createCampeao(Campeao campeao);

    Campeao buscaPorId(String id);

    void deletaCampeao(String id);

    void deletaCampeaoPorNome(String nome);

    void atualizaCampeaoPorNome(String nome, Campeao campeao);
}
