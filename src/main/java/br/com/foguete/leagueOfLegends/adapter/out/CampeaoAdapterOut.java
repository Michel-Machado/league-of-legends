package br.com.foguete.leagueOfLegends.adapter.out;

import br.com.foguete.leagueOfLegends.adapter.in.exception.NotFoundException;
import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;
import br.com.foguete.leagueOfLegends.repository.CampeaoRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service

public class CampeaoAdapterOut implements CampeaoPortOut{
    private final MongoTemplate mongoTemplate;
    private final CampeaoRepository campeaoRepository;

    public CampeaoAdapterOut(MongoTemplate mongoTemplate, CampeaoRepository campeaoRepository) {
        this.mongoTemplate = mongoTemplate;
        this.campeaoRepository = campeaoRepository;
    }

    @Override
    public List<CampeaoControl> findAllCampeao(String name,
                                               String gender,
                                               Posicao position,
                                               String species,
                                               String resource,
                                               String rangeType,
                                               String region,
                                               Integer yearOfLaunch) {
        Query query = this.buildQuery(name, gender,position,species,resource,rangeType,region,yearOfLaunch);

        return mongoTemplate.find(query, CampeaoControl.class);

    }

    @Override
    public Optional<CampeaoControl> findByNome(String nome) {
        return this.campeaoRepository.findByNome(nome);
    }

    @Override
    public String criaCampeao(Campeao campeao) {
        CampeaoControl campeaoControl = CampeaoControl.campeaoControl(campeao);
        CampeaoControl campeaoSave = this.campeaoRepository.save(campeaoControl);
        return campeaoSave.getId();
    }

    @Override
    public Campeao buscaPorId(String id) {
        Optional<CampeaoControl> campeaoControlOptional = this.campeaoRepository.findById(id);
        if (campeaoControlOptional.isEmpty()){
            System.out.println("404");
        }
        CampeaoControl campeaoControl = campeaoControlOptional.get();
        return Campeao.from(campeaoControl);
    }

    @Override
    public void deletaCampeao(String id) {
        CampeaoControl campeaoControl = this.campeaoRepository.findById(id).orElseThrow(NotFoundException::new);
        this.campeaoRepository.delete(campeaoControl);
    }

    @Override
    public void deletaCampeaoPorNome(String nome) {
        CampeaoControl campeaoControl = this.campeaoRepository.findByNome(nome).orElseThrow(NotFoundException::new);
        this.campeaoRepository.delete(campeaoControl);

    }

    @Override
    public void atualizaCampeao(String nome, Campeao campeao) {
        CampeaoControl campeaoControl = this.campeaoRepository.findByNome(nome).orElseThrow(NotFoundException::new);
        CampeaoControl campeaoAtualizado = CampeaoControl.atualizaCampeao(campeaoControl, campeao);
        this.campeaoRepository.save(campeaoAtualizado);
    }

    private Query buildQuery(String name, String gender, Posicao position,
                             String species, String resource,
                             String rangeType, String region,
                             Integer locationDateTimeyearOfLaunch) {
        Query query = new Query();


        if (!ObjectUtils.isEmpty(name)) {
            query.addCriteria(Criteria.where("nome").regex(name, "i"));

        }
        if (!ObjectUtils.isEmpty(gender)) {
            query.addCriteria(Criteria.where("genero").regex(gender, "i"));
        }
        if (!ObjectUtils.isEmpty(position)) {
            query.addCriteria(Criteria.where("posicao").regex(String.valueOf(position), "i"));
        }
        if (!ObjectUtils.isEmpty(species)) {
            query.addCriteria(Criteria.where("especie").regex(species, "i"));
        }
        if (!ObjectUtils.isEmpty(resource)) {
            query.addCriteria(Criteria.where("recurso").regex(resource, "i"));
        }
        if (!ObjectUtils.isEmpty(rangeType)) {
            query.addCriteria(Criteria.where("tipoDeAlcance").regex(rangeType, "i"));
        }
        if (!ObjectUtils.isEmpty(region)) {
            query.addCriteria(Criteria.where("regiao").regex(region, "i"));
        }
        if (!ObjectUtils.isEmpty(locationDateTimeyearOfLaunch)) {
            query.addCriteria(Criteria.where("anoDeLancamento").is(locationDateTimeyearOfLaunch));
        }

        return query;
    }


}
