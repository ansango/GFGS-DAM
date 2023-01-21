package interfaz;

import logica.Excepciones.NumDepartDuplicado;

import org.neodatis.odb.ODB;

public interface Interfazdepart {

	public abstract void insertardep(ODB odb) throws NumDepartDuplicado;

	public abstract void borrardep(ODB odb);

	public abstract void consultardep(ODB odb);

	public abstract void modificardep(ODB odb);

}