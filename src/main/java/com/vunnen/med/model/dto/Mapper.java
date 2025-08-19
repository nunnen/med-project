package com.vunnen.med.model.dto;

public interface Mapper<F, T> {
    T map(F from);
}
