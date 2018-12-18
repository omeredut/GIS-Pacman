package game;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import file_format.CsvWriter;
import geom.Point3D;


public class Game implements Set<GameElement> {
	private Set<GameElement> set;
	private Map map;

	public Game(String picPath,Point3D rightCornerUp,Point3D leftCornerDown) {
		set=new HashSet<GameElement>();
		map=new Map(rightCornerUp,leftCornerDown,null,null,picPath);
	}

	@Override
	public boolean add(GameElement arg0) {
		return set.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GameElement> c) {
		return set.addAll(c);
	}

	@Override
	public void clear() {
		set.clear();
	}

	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return set.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	@Override
	public Iterator<GameElement> iterator() {
		return set.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return set.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return set.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return set.retainAll(c);
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public Object[] toArray() {
		return set.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return set.toArray(a);
	}
	
	public void save() throws FileNotFoundException {
		String header="Type,id,Lat,Lon,Alt,speed/weight,radius";
		CsvWriter csvWriter=new CsvWriter();
		csvWriter.write(header,set);
		}
	}

