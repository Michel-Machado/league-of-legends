package br.com.foguete.leagueOfLegends.adapter.in;

import br.com.foguete.leagueOfLegends.adapter.in.dto.CampeaoDto;
import br.com.foguete.leagueOfLegends.core.CampeaoPortIn;
import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lol/v1/campeoes")
public class HttpCampeaoAdapterIn {
    public final CampeaoPortIn campeaoPortIn;

    public HttpCampeaoAdapterIn(CampeaoPortIn campeaoPortIn) {
        this.campeaoPortIn = campeaoPortIn;
    }

    @GetMapping

    public ResponseEntity<List<CampeaoDto>> consultaGeralCampeoes(@RequestParam(value = "name", required = false)String name,
                                                                  @RequestParam(value = "gender", required = false)String gender,
                                                                  @RequestParam(value = "position", required = false) Posicao position,
                                                                  @RequestParam(value = "species", required = false)String species,
                                                                  @RequestParam(value = "resource", required = false)String resource,
                                                                  @RequestParam(value = "rangeType", required = false)String rangeType,
                                                                  @RequestParam(value = "region", required = false)String region,
                                                                  @RequestParam(value = "yearOfLaunch", required = false)Integer yearOfLaunch){

        List<Campeao> findAllCampeaoReturn = this.campeaoPortIn.findAllCampeao(name,gender, position, species, resource, rangeType, region, yearOfLaunch);
        List<CampeaoDto> campeaoDtoList = new ArrayList<>();

        for(Campeao campeao: findAllCampeaoReturn){
            CampeaoDto campeaoDto = CampeaoDto.from(campeao);
            campeaoDtoList.add(campeaoDto);
        }
        return ResponseEntity.ok(campeaoDtoList);
    }

    @PostMapping

    public ResponseEntity<String> criacaoCampeao(@RequestBody @Valid CampeaoDto campeaoDto){
        Campeao campeao = new Campeao(campeaoDto.getNome(),
                campeaoDto.getGenero(),
                campeaoDto.getPosicao(),
                campeaoDto.getEspecie(),
                campeaoDto.getRecurso(),
                campeaoDto.getTipoDeAlcance(),
                campeaoDto.getRegiao(),
                campeaoDto.getAnoDeLancamento());

        String idCampeao = this.campeaoPortIn.createCampeao(campeao);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idCampeao).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeaoDto> buscaCampeaoPorId(@PathVariable("id")String id){
        Campeao campeao = this.campeaoPortIn.buscaPorId(id);

        return ResponseEntity.ok(CampeaoDto.from(campeao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCampeaoPorId(@PathVariable("id")String id){
        this.campeaoPortIn.deletaCampeao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<String>> buscaCampeaoPorNome(@PathVariable("nome")String nome){
     List<Campeao>findAllCampeaoReturn =  this.campeaoPortIn.findAllCampeao(nome, null,
                null,
                null,
                null,
                null,
                null,
                null);
     List<String> nomeCampeaoList = new ArrayList<>();
        for ( Campeao campeao: findAllCampeaoReturn ) {
            nomeCampeaoList.add(campeao.getName());
        }
        return ResponseEntity.ok(nomeCampeaoList);
    }

    @DeleteMapping("/nome/{nome}")
    public ResponseEntity<Void> deletaCampeaoPorNome(@PathVariable("nome")String nome){
        this.campeaoPortIn.deletaCampeaoPorNome(nome);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/nome/{nome}")
    public ResponseEntity<Void> atualizaCampeaoPorNome(@PathVariable("nome") String nome,
                                                       @RequestBody @Valid CampeaoDto campeaoDto){
        Campeao campeao = Campeao.fromDto(campeaoDto);
        this.campeaoPortIn.atualizaCampeaoPorNome(nome, campeao);
        return ResponseEntity.noContent().build();
    }




}
