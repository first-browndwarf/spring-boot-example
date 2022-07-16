package com.browndwarf.trycatchinstream.common.custominterface;

@FunctionalInterface
public interface FunctionWithThrows<T, R> {
    R apply(T t) throws Exception;
}
