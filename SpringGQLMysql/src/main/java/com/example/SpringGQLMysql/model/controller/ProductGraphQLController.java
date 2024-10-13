package com.example.SpringGQLMysql.model.controller;

import com.example.SpringGQLMysql.model.Product;
import com.example.SpringGQLMysql.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;

import java.util.List;

@Controller
public class ProductGraphQLController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProductService productService;

    // Query to get all products
    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Query to get a product by ID
    @QueryMapping
    public Product getProductById(@Argument Long id) {
        return productService.getProductById(id);
    }

    // Mutation to create a product
    @MutationMapping
    public Product createProduct(
            @Argument String name,
            @Argument String description,
            @Argument double price,
            @Argument int quantity) {
        // Call service to create product
        return productService.createProduct(new Product(null, name, description, price, quantity));
    }


    // Mutation to Update a product
    @MutationMapping
    public Product updateProduct(
            @Argument Long id,
            @Argument String name,
            @Argument String description,
            @Argument double price,
            @Argument int quantity) {
        // Call service to update product
        return productService.updateProduct(id, new Product(id, name, description, price, quantity));
    }

    // Mutation to Delete a product
    @MutationMapping
    public boolean deleteProduct(@Argument Long id) {
        // Call service to delete product
        productService.deleteProduct(id);
        return true;
    }

}

