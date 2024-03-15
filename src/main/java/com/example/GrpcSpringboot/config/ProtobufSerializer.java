package com.example.GrpcSpringboot.config;

import com.example.protobuf.Students;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ProtobufSerializer extends StdSerializer<Students> {

    public ProtobufSerializer() {
        this(null);
    }

    protected ProtobufSerializer(Class<Students> t) {
        super(t);
    }

    @Override
    public void serialize(Students students, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        byte[] data = students.toByteArray();
        jsonGenerator.writeBinary(data);
    }
}
