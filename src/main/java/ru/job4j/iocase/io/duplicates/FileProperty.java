package ru.job4j.iocase.io.duplicates;

import java.util.Objects;

public class FileProperty {

    private long size;

    private String name;
    private String absolutePath;

    public FileProperty(long size, String name, String absolutePath) {
        this.size = size;
        this.name = name;
        this.absolutePath = absolutePath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return size == that.size && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
