package br.edu.claudivan.springconectado.commons.ext.ulid;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class ULIDGenerator implements IdentifierGenerator, Configurable {

    private ULIDGenerationStrategy strategy;
    private ULIDTypeDescriptor.ValueTransformer valueTransformer;

    public ULIDGenerator() {
        this.strategy = ULIDGenerationStrategy.INSTANCE;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return this.valueTransformer.transform(this.strategy.generateULID());
    }

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
        if (ULID.class.isAssignableFrom(type.getReturnedClass())) {
            this.valueTransformer = ULIDTypeDescriptor.PassThroughTransformer.INSTANCE;
        } else if (String.class.isAssignableFrom(type.getReturnedClass())) {
            this.valueTransformer = ULIDTypeDescriptor.ToStringTransformer.INSTANCE;
        } else {
            throw new HibernateException("Unanticipated return type [" + type.getReturnedClass().getName() + "] for ULID conversion");
        }
    }
}
