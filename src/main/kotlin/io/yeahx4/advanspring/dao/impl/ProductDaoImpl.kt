package io.yeahx4.advanspring.dao.impl

import io.yeahx4.advanspring.dao.ProductDao
import io.yeahx4.advanspring.entity.ProductEntity
import io.yeahx4.advanspring.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductDaoImpl(val productRepository: ProductRepository): ProductDao {
    override fun saveProduct(productEntity: ProductEntity): ProductEntity {
        productRepository.save(productEntity)
        return productEntity
    }

    override fun getProduct(productId: Long): ProductEntity {
        return productRepository.getReferenceById(productId)
    }
}
