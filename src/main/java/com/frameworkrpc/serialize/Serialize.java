package com.frameworkrpc.serialize;

public interface Serialize {

	<T> byte[] serialize(T object);

	<T> T deserialize(byte[] data, Class<T>... cls);
}
