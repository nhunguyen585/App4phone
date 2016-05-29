package Model;

public class Object {
	private String id;
	private String name;
	private String path;
	private String table;
	public Object(String id, String name, String path, String table) {
		this.id = id;
		this.name = name;
		this.path = path;
		this.table = table;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
}
