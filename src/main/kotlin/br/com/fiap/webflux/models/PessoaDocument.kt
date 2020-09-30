package br.com.fiap.webflux.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PessoaDocument (
    @Id
    val id: String? = null,
    val nome: String
)