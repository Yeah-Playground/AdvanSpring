package io.yeahx4.advanspring.service.impl

import io.yeahx4.advanspring.dto.ProductDto
import io.yeahx4.advanspring.handler.ProductDataHandler
import io.yeahx4.advanspring.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val productDataHandler: ProductDataHandler): ProductService {
    override fun saveProduct(productName: String, productPrice: Int, productStock: Int): ProductDto {
        val entity = productDataHandler.saveProductEntity(productName, productPrice, productStock)
        return entity.toDto()
    }

    override fun getProduct(productId: Long): ProductDto {
        val entity = productDataHandler.getProductEntity(productId)
        return entity.toDto()
    }
}
