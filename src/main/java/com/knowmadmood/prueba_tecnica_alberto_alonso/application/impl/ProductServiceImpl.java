package com.knowmadmood.prueba_tecnica_alberto_alonso.application.impl;

import com.knowmadmood.prueba_tecnica_alberto_alonso.application.ProductApiClient;
import com.knowmadmood.prueba_tecnica_alberto_alonso.application.ProductService;
import com.knowmadmood.prueba_tecnica_alberto_alonso.domain.ProductDetail;
import com.knowmadmood.prueba_tecnica_alberto_alonso.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductApiClient productApiClient;

    //Inyección de dependencia por constructor en lugar de @Autowired
    public ProductServiceImpl(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    @Override
    public List<ProductDetail> getSimilarProducts(String productId) {
        List<String> similarIds = getSimilarProductIds(productId)
                .orElseThrow(() -> new ProductNotFoundException("No existe un producto con id: " + productId));

        return fetchAsyncProductDetails(similarIds);
    }

    // LLamada a la API externa para la obtención de productos similares.
    private Optional<List<String>> getSimilarProductIds(String productId) {
        try {
            return Optional.ofNullable(productApiClient.getSimilarProductIds(productId));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Obtención del detalle de los productos similares de forma asíncrona, aumentando el rendimiento.
    private List<ProductDetail> fetchAsyncProductDetails(List<String> similarIds) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try {
            return similarIds.stream()
                    .map(id -> CompletableFuture.supplyAsync(() -> productApiClient.getProduct(id), executor))
                    .map(CompletableFuture::join)
                    .toList();
        } finally {
            executor.shutdown();
        }
    }
}
