package io.yeahx4.advanspring.handler.impl

import io.yeahx4.advanspring.dao.ProductDao
import io.yeahx4.advanspring.entity.ProductEntity
import io.yeahx4.advanspring.handler.ProductDataHandler
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class ProductDataHandlerImpl(private val productDao: ProductDao): ProductDataHandler {
    override fun saveProductEntity(
        productName: String,
        productPrice: Int,
        productStock: Int
    ): ProductEntity {
        val productEntity = ProductEntity(-1, productName, productPrice, productStock)

        return productDao.saveProduct(productEntity)
    }

    override fun getProductEntity(productId: Long): ProductEntity {
        return productDao.getProduct(productId)
    }
}
