package sample.cafekiosk.spring.domain.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProductTypeTest {

    @DisplayName("상품 타입이 제고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType1(){
        // Given
        ProductType productType = ProductType.HANDMADE;
        
        // When
        boolean result = ProductType.containsStockType(productType);

        // Then
        assertThat(result).isFalse();
    }

    @DisplayName("상품 타입이 제고 관련 타입인지를 체크한다.")
    @Test
    void containsStockType2(){
        // Given
        ProductType productType = ProductType.BAKERY;

        // When
        boolean result = ProductType.containsStockType(productType);

        // Then
        assertThat(result).isTrue();
    }
}