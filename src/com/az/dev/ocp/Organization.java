package com.az.dev.ocp;

import java.io.Closeable;
import java.io.IOException;

public class Organization implements Closeable {
    
    @Override
    public void close() throws IOException {
        System.out.println("close() method from 'Organization' class");
    }
}
