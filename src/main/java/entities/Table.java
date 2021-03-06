package entities;


public class Table {
	private Integer id;
	private String name;
	private TableStatus status;
	
	public Table() {
	}
        
        public void copy(Table table){
            this.setId(table.getId());
            this.setName(table.getName());
            this.setStatus(table.getStatus());
        }
	
	public Table(Integer id, String name, TableStatus status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TableStatus getStatus() {
		return status;
	}
	public void setStatus(TableStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
