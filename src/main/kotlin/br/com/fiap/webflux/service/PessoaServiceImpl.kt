package br.com.fiap.webflux.service

import br.com.fiap.webflux.dto.CreatePessoaDTO
import br.com.fiap.webflux.dto.PessoaDTO
import br.com.fiap.webflux.models.PessoaDocument
import br.com.fiap.webflux.repository.PessoaRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Service
class PessoaServiceImpl(
        private val pessoaRepository: PessoaRepository
) : PessoaService {

    override fun create(createPessoaDTO: CreatePessoaDTO) =
            Mono.create<PessoaDocument> { createPessoaDTO }
                    .map {
                        PessoaDocument(nome = createPessoaDTO.nome
                                ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST))
                    }
                    .flatMap { pessoaRepository.save(it) }
                    .map { PessoaDTO(id = it.id ?: String(), nome = it.nome) }

    override fun getAll() = pessoaRepository.findAll()
            .map { PessoaDTO(id = it.id ?: "", nome = it.nome) }

}