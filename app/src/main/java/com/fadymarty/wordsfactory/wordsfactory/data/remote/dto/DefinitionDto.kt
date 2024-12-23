package com.fadymarty.wordsfactory.domain.model

import com.fadymarty.wordsfactory.wordsfactory.domain.model.Definition

data class DefinitionDto(
    val definition: String,
    val example: String?
) {
    fun toDefinition(): Definition {
        return Definition(
            definition = definition,
            example = example
        )
    }
}