package net.codejava.world.transform;

public interface DtoTransformer<U, V> {

	U transform(V obj);
}
