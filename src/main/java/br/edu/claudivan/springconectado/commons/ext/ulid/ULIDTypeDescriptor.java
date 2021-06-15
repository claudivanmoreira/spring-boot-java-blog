package br.edu.claudivan.springconectado.commons.ext.ulid;

import java.io.Serializable;

public class ULIDTypeDescriptor {

    public static class ToStringTransformer implements ULIDTypeDescriptor.ValueTransformer {

        public static final ULIDTypeDescriptor.ToStringTransformer INSTANCE = new ULIDTypeDescriptor.ToStringTransformer();

        public String transform(ULID ulid) {
            return ulid.toString();
        }

        public ULID parse(Object value) {
            return new ULID((String)value);
        }
    }

    public static class PassThroughTransformer implements ULIDTypeDescriptor.ValueTransformer {

        public static final ULIDTypeDescriptor.PassThroughTransformer INSTANCE = new ULIDTypeDescriptor.PassThroughTransformer();

        public ULID transform(ULID ulid) {
            return ulid;
        }

        public ULID parse(Object value) {
            return (ULID) value;
        }
    }

    public interface ValueTransformer {
        Serializable transform(ULID var1);

        ULID parse(Object var1);
    }

}
