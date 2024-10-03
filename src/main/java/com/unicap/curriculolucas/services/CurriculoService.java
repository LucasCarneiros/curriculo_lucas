package com.unicap.curriculolucas.services;

import com.unicap.curriculolucas.models.Curriculo;
import com.unicap.curriculolucas.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CurriculoService {

    @Autowired
    private  CurriculoRepository curriculoRepository;

    public Curriculo criarCurriculo(Curriculo curriculo){
        return curriculoRepository.save(curriculo);
    }

    public Curriculo obterCurriculo(Long id){
        return curriculoRepository.findById(id).orElse(null);
    }

    public List<Curriculo> obterTodosCurriculos() {
        return curriculoRepository.findAll();
    }
}
