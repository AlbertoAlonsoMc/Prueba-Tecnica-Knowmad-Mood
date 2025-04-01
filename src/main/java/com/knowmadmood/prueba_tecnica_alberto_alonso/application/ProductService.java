package com.knowmadmood.prueba_tecnica_alberto_alonso.application;

import com.knowmadmood.prueba_tecnica_alberto_alonso.domain.ProductDetail;

import java.util.List;

public interface ProductService {
    List<ProductDetail> getSimilarProducts(String productId);
}
