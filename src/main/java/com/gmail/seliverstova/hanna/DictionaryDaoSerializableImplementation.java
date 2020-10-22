package com.gmail.seliverstova.hanna;

import java.io.*;

public class DictionaryDaoSerializableImplementation<T> implements DictionaryDAO<T> {
    private File file;

    public DictionaryDaoSerializableImplementation(File path) {
        super();
        this.file = path;
    }

    public DictionaryDaoSerializableImplementation() {
        super();
    }

    public File getPath() {
        return file;
    }

    public void setPath(File path) {
        this.file = path;
    }

    @Override
    public String toString() {
        return "DictionaryDaoSerializableImplementation [path=" + file + "]";
    }

    @Override
    public void save(T obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.file))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public T load() throws IOException {
        T obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.file))) {
            obj = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return obj;
    }
}
