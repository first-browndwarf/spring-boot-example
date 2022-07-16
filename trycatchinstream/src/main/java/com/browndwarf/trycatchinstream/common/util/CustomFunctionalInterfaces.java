package com.browndwarf.trycatchinstream.common.util;

import com.browndwarf.trycatchinstream.common.custominterface.FunctionWithThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class CustomFunctionalInterfaces {
    public static <T,R> Function<T,R> functionWithThrows(FunctionWithThrows<T, R> functionWithThrows) {
        return item->{
            try{
                return functionWithThrows.apply(item);
            }catch(Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <T,R> Function<T,R> functionWithNull(FunctionWithThrows<T, R> functionWithThrows) {
        return item->{
            try{
                return functionWithThrows.apply(item);
            }catch(Exception e) {
                log.error(">>> Occur an exception : {} (Message = {})", e.toString(), e.getMessage());
                return null;
            }
        };
    }
}
