package com.knowmadmood.prueba_tecnica_alberto_alonso.application;

import com.knowmadmood.prueba_tecnica_alberto_alonso.domain.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// Cliente Feign para comunicarse con la API externa de productos.
@FeignClient(name = "productApiClient", url = "${api.client.base-url}")
public interface ProductApiClient {

    // Obtiene los IDs de los productos similares a un producto dado.
    @GetMapping("/{productId}/similarids")
    List<String> getSimilarProductIds(@PathVariable("productId") String productId);

    // Obtiene los detalles de un producto específico.
    @GetMapping("/{productId}")
    ProductDetail getProduct(@PathVariable("productId") String productId);
}

