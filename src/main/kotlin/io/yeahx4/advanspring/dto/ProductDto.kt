package io.yeahx4.advanspring.dto

import io.yeahx4.advanspring.entity.ProductEntity
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import org.jetbrains.annotations.NotNull

class ProductDto(
    @NotNull val productName: String,
    @NotNull @Min(500) @Max(10000000) val productPrice: Int,
    @NotNull @Min(0) @Max(9999) val productStock: Int,
) {
    fun toEntity(): ProductEntity = ProductEntity(-1, productName, productPrice, productStock)
}
