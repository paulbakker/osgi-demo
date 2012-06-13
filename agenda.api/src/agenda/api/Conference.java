package agenda.api;

public class Conference {
	private String name;
	private String location;
	private String _id;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Conference(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public Conference() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Conference [name=" + name + ", location=" + location + "]";
	}

}
