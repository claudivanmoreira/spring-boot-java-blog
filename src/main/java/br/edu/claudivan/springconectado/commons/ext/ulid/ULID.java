package br.edu.claudivan.springconectado.commons.ext.ulid;

import java.io.Serializable;
import java.util.Objects;

public class ULID implements Comparable <ULID>, Serializable {

    private String value;

    public ULID(String value) {
        if (io.azam.ulidj.ULID.isValid(value)) {
            this.value = value;
        } else throw new IllegalArgumentException("Invalid ulid value: " + value);
    }

    public String getValue() {
        return value;
    }

    public static ULID random() {
        return new ULID(io.azam.ulidj.ULID.random());
    }

    @Override
    public int compareTo(ULID other) {
        return value.compareTo(other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ULID ulid = (ULID) o;
        return Objects.equals(getValue(), ulid.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return this.value;
    }
}
