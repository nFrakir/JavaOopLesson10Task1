package com.gmail.seliverstova.hanna;

import java.io.IOException;

public interface DictionaryDAO<T> {
    public void save(T obj) throws IOException;
    public T load() throws IOException;
}
