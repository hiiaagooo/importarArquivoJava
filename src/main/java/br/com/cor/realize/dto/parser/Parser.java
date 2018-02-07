package br.com.correios.realize.dto.parser;

public interface Parser<T, E> {

    public T toEntity(E dto);

    public E toDTO(T entity);

}
