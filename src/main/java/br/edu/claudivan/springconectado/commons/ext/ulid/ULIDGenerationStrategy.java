package br.edu.claudivan.springconectado.commons.ext.ulid;


public class ULIDGenerationStrategy {

    public static final ULIDGenerationStrategy INSTANCE = new ULIDGenerationStrategy();

    public ULID generateULID() {
        return new ULID(io.azam.ulidj.ULID.random());
    }
}
