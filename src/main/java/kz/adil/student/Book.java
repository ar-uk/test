package kz.adil.student;

public class Book{
	private String title;
	private String author;



	private String status;
	public Book(String title, String author, String status) {
		this.title = title;
		this.author = author;
		this.status = status;
	}
	//Get, Set
	public String GetTitle(){
		return this.title;
	}
	public void SetTitle(String title){
		this.title = title;
	}

	public String GetAuthor(){
		return this.author;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void SetAuthor(String Author){
		this.author	 = Author;
	}
}
