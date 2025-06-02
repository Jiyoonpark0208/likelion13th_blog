package likelion13th.blog.dto.resonse;

import likelion13th.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SimpleArticleResponse {

    private final Long id;
    private final String title;
    private final String author;

    /*
    settings -> plugin / marketplace에서 lombok을 설치해야했음
     */

    public static SimpleArticleResponse of(Article article) {
        return SimpleArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .author(article.getAuthor())
                .build();
    }
}
