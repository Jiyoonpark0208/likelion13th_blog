package likelion13th.blog.exception;

import jakarta.persistence.EntityNotFoundException;
import likelion13th.blog.dto.resonse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //추가
    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ApiResponse> handleArticleNotFoundException(ArticleNotFoundException ex){
        return buildErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
    }

    //추가
    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCommentNotFoundException(CommentNotFoundException ex){
        return buildErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
    }

    @ExceptionHandler(PermissionDeniedException.class)
    public ResponseEntity<ApiResponse> handlePermissionDeniedException(PermissionDeniedException ex){
        return buildErrorResponse(HttpStatus.FORBIDDEN,ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEntityNotFoundException(EntityNotFoundException e){
       // ApiResponse response=new ApiResponse(false,HttpStatus.NOT_FOUND.value(), e.getMessage());
        //return ResponseEntity
          //      .status(HttpStatus.NOT_FOUND)
            //    .body(response);
        return buildErrorResponse(HttpStatus.NOT_FOUND,e.getMessage());
    }

    //ApiResponse 생성하는 공통 메서드
    private ResponseEntity<ApiResponse> buildErrorResponse(HttpStatus status,String message){
        ApiResponse response=new ApiResponse(false,status.value(),message);
        return ResponseEntity
                .status(status)
                .body(response);
    }
}
