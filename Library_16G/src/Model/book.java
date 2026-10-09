package Model;

public class book 
{

	private int book_id;
	private String isbn;
	private String title;
	private int author_id;
	private int published_year;
	private int category_id;
	private String discription;
	private int Copies;
	private int publisher_id;
	private String image;
	
	public book(){}
	
	public book(int book_id, String isbn, String title, int published_year, String discription, int copies,
			String image) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.title = title;
		this.published_year = published_year;
		this.discription = discription;
		Copies = copies;
		this.image = image;
	}

	public book(int book_id, String isbn, String title, int author_id, int published_year, int category_id,
			String discription, int copies, int publisher_id, String image) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.title = title;
		this.author_id = author_id;
		this.published_year = published_year;
		this.category_id = category_id;
		this.discription = discription;
		Copies = copies;
		this.publisher_id = publisher_id;
		this.image = image;
	}
	@Override
	public String toString() {
		return "book [book_id=" + book_id + ", isbn=" + isbn + ", title=" + title + ", author_id=" + author_id
				+ ", published_year=" + published_year + ", category_id=" + category_id + ", discription=" + discription
				+ ", Copies=" + Copies + ", publisher_id=" + publisher_id + ", image=" + image + "]";
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getPublished_year() {
		return published_year;
	}
	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public int getCopies() {
		return Copies;
	}
	public void setCopies(int copies) {
		Copies = copies;
	}
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
