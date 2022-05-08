package group1.projectgroup1.Model;

public class Book {
    String author_Book, book_Cover, id_Book, lengths_Book, name_Book, price_Book,description_Book,recommend_Book,saleOff_Book;
    int view_Book;


    public Book() {
    }

    public Book(String author_Book, String book_Cover, String id_Book, String lengths_Book, String name_Book, String price_Book,String description_Book, String recommend_Book,String saleOff_Book,int view_Book) {
        this.author_Book = author_Book;
        this.book_Cover = book_Cover;
        this.id_Book = id_Book;
        this.lengths_Book = lengths_Book;
        this.name_Book = name_Book;
        this.price_Book = price_Book;
        this.description_Book=description_Book;
        this.recommend_Book=recommend_Book;
        this.saleOff_Book=saleOff_Book;
        this.view_Book=view_Book;
    }

    public String getAuthor_Book() {
        return author_Book;
    }

    public void setAuthor_Book(String author_Book) {
        this.author_Book = author_Book;
    }

    public String getBook_Cover() {
        return book_Cover;
    }

    public void setBook_Cover(String book_Cover) {
        this.book_Cover = book_Cover;
    }

    public String getId_Book() {
        return id_Book;
    }

    public void setId_Book(String id_Book) {
        this.id_Book = id_Book;
    }

    public String getLengths_Book() {
        return lengths_Book;
    }

    public void setLengths_Book(String lengths_Book) {
        this.lengths_Book = lengths_Book;
    }

    public String getName_Book() {
        return name_Book;
    }

    public void setName_Book(String name_Book) {
        this.name_Book = name_Book;
    }

    public String getPrice_Book() {
        return price_Book;
    }

    public void setPrice_Book(String price_Book) {
        this.price_Book = price_Book;
    }
    public String getDescription_Book() {
        return description_Book;
    }

    public void setDescription_Book(String description_Book) {
        this.description_Book = description_Book;
    }

    public String getRecommend_Book() {
        return recommend_Book;
    }

    public void setRecommend_Book(String recommend_Book) {
        this.recommend_Book = recommend_Book;
    }

    public String getSaleOff_Book() {
        return saleOff_Book;
    }

    public void setSaleOff_Book(String saleOff_Book) {
        this.saleOff_Book = saleOff_Book;
    }

    public int getView_Book() {
        return view_Book;
    }

    public void setView_Book(int view_Book) {
        this.view_Book = view_Book;
    }
}
