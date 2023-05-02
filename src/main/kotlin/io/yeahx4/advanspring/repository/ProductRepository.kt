package io.yeahx4.advanspring.repository

import io.yeahx4.advanspring.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

// JpaRepository<TargetEntity, PrimaryKeyType>
interface ProductRepository: JpaRepository<ProductEntity, Long>
