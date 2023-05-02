package io.yeahx4.advanspring.entity

import io.yeahx4.advanspring.dto.ProductDto
import jakarta.persistence.*

@Table(name = "product")
@Entity
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val productId: Long,
    @Column(name = "name")
    val productName: String,
    @Column(name = "price")
    val productPrice: Int,
    @Column(name = "stock")
    val productStock: Int,
) {
    fun toDto(): ProductDto = ProductDto(productName, productPrice, productStock)
    constructor() : this(-1, "unknown", -1, -1)
}
