public class Book {

    private static final String INVALID_TITLE_EXCEPTION = "Title not valid!";
    private static final String INVALID_AUTHOR_EXCEPTION = "Author not valid!";
    private static final String INVALID_PRICE_EXCEPTION = "Price not valid!";

    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title == null || title.length() < 3) {
            throw new IllegalArgumentException(INVALID_TITLE_EXCEPTION);
        }
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        String[] authorInfo = author.split("\\s+");
        if (authorInfo.length == 2) {
            String authorLastName = authorInfo[1];
            if (Character.isDigit(authorLastName.charAt(0))) {
                throw new IllegalArgumentException(INVALID_AUTHOR_EXCEPTION);
            }
        }
        this.author = author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE_EXCEPTION);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}