package ifsuldeminas.telefonia.controller;

import ifsuldeminas.telefonia.model.entity.comercial.Plano;
import ifsuldeminas.telefonia.model.repository.PlanoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")          //indica a rota URI que os metodos vao trafegar
public class PlanoController {
    //Este controlador ira tratar as requisicoes para as operacoes CRUD Plano, seu nome pode ser PlanoResource tambem

    private PlanoRepository planoRepository;

    public PlanoController(PlanoRepository planoRepository){     // construtor que recebe a instancia repositório Plano
        this.planoRepository = planoRepository;                 // inicializar os atributos com os objetos recebidos do repositorio
    }

    //OPERACAO QUE CONSULTA UM UNICO PLANO POR ID
    @GetMapping("/{id}")                                          // complemento da URI, dizendo que é um GET filtrando por ID do Plano
    public Plano show(@PathVariable Long id){                     // indica que o ID é recebido como um parametro da URI
        //tratamento de erros ...
        //busca no BD um plano pelo id
        return planoRepository.getReferenceById(id);
    }

    // OPERACAO QUE CONSULTA A LISTA DE PLANOS EXISTENTE
    @GetMapping
   public List<Plano> list(){
        return planoRepository.findAll();
    }

    //OPERACAO CREATE PARA CADASTRAR UM PLANO
    @PostMapping                                                    // complemento da URI, dizendo que é um POST de criação de Informação
    public Plano save (@RequestBody Plano plano){                   // metodo recebe a instancia objeto de um plano
        return planoRepository.save(plano);
    }

    //OPERACAO DE EXCLUIR DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        planoRepository.deleteById(id);
    }

    //OPERACAO UPDATE PARA ATUALIZAR UM CADASTRO DE PLANO
   @PutMapping("/{id}")                                                   // complemento da URI, dizendo que é um POST de criação de Informação
    public Plano update (@PathVariable Long id, @RequestBody Plano plano){                   // metodo recebe a instancia objeto de um plano
        //buscar o plano pelo id
       Plano planoAux = planoRepository.getReferenceById(id);           // objeto auxiliar primeiro busca o plano para ver se existe na base

       planoAux.setNome(plano.getNome());                           // dados que podem ser atualizados
       planoAux.setValorPorMinuto(plano.getValorPorMinuto());

       return planoRepository.save(planoAux);                       // comando para salvar as alteracoes
    }
}
