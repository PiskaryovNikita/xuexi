package com.xuexi.sonya;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

public class ObjectReference {

    public static void main(String[] args) {
        Product product = new Product("name");
        Product anotherProduct = new Product("name");

        System.out.println(product.hashCode());
        System.out.println(System.identityHashCode(product));

        System.out.println(anotherProduct.hashCode());
        System.out.println(System.identityHashCode(anotherProduct));
    }

}

@AllArgsConstructor
@EqualsAndHashCode
class Product {
    private String name;
}
