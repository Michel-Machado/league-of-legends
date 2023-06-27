package br.com.foguete.leagueOfLegends.adapter.out;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;

import java.util.List;
import java.util.Optional;

public interface CampeaoPortOut {
    List<CampeaoControl> findAllCampeao(String name, String gender, Posicao position, String species, String resource, String rangeType, String region, Integer yearOfLaunch);

    Optional<CampeaoControl> findByNome(String nome);

    String criaCampeao(Campeao campeao);

    Campeao buscaPorId(String id);

    void deletaCampeao(String id);


    void deletaCampeaoPorNome(String nome);

    void atualizaCampeao(String nome, Campeao campeao);
}
