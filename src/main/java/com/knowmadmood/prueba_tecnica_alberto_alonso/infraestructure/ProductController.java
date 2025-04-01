package com.knowmadmood.prueba_tecnica_alberto_alonso.infraestructure;

import com.knowmadmood.prueba_tecnica_alberto_alonso.application.ProductService;
import com.knowmadmood.prueba_tecnica_alberto_alonso.domain.ProductDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controlador REST que expone el endpoint definido en el contrato OpenAPI.
@RestController
@RequestMapping("/product")
@Tag(name = "Similar Products", description = "API to get similar products")
public class ProductController {

    private final ProductService productService;

    //Inyección de dependencia por constructor en lugar de @Autowired.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Implementación el endpoint para la obtención productos similares, según el contrato OpenAPI.
    @Operation(
            summary = "Get similar products",
            description = "Retrieves all data from similar products related to the given product ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Product Not Found")
    })
    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDetail>> getSimilarProducts(@PathVariable String productId) {
        List<ProductDetail> productDetails = productService.getSimilarProducts(productId);
        return ResponseEntity.ok(productDetails);
    }
}

