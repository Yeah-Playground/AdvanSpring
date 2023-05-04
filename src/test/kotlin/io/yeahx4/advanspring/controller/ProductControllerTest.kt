package io.yeahx4.advanspring.controller

import io.yeahx4.advanspring.dto.ProductDto
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import io.yeahx4.advanspring.service.impl.ProductServiceImpl
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc

//@WebMvcTest(ProductController::class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc
    // ProductController가 쓴느 Bean객체를 Mock 형태로 생성
    @MockBean
    private lateinit var productService: ProductServiceImpl

    @Test
    @DisplayName("Get product test")
    fun getProductTest() {
        // Mock 객체가 해야하는 결과를 확인
        given(productService.getProduct(12315)).willReturn(
            ProductDto("pen", 5000, 2000)
        )

        // 값이 맞는지 확인
        val productId = 12315L
        mockMvc.perform(get("/product/${productId}"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.productName").exists())
            .andDo(print())

        // 객체의 메소드가 실행됐는지 확인
        verify(productService).getProduct(12315)
    }
}
