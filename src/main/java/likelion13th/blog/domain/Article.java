package likelion13th.blog.domain;

import java.time.LocalDateTime;

public class Article {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdAt;

    public Article(String content, Long id, String title, String author, String password) {
        this.content = content;
        this.id = id;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.title=title;

    }
    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getId() {return id; }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPassword() {return password;}
}




