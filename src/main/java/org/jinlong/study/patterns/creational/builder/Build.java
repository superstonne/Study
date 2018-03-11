package org.jinlong.study.patterns.creational.builder;

public class Build {

    private ProductBuilder builder;

    public Build(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product construct() {
        Product product;
        builder.buildType();
        builder.buildHead();
        builder.buildBody();
        product = builder.buildProduct();
        return product;
    }
}

abstract class ProductBuilder {
    Product product = new Product();

    abstract void buildType();
    abstract void buildHead();
    abstract void buildBody();

    Product buildProduct() {
        return product;
    }
}

class ABuilder extends ProductBuilder {

    @Override
    void buildType() {

    }

    @Override
    void buildHead() {

    }

    @Override
    void buildBody() {

    }
}

class BBuilder extends ProductBuilder {

    @Override
    void buildType() {

    }

    @Override
    void buildHead() {

    }

    @Override
    void buildBody() {

    }
}

class Product {
    String type;
    String head;
    String body;
}
