package com.api.book.bootrestbook.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookServices;

@RestController
public class BookController {
    
    @Autowired
    private BookServices  bookServices;
    //@RequestMapping(value ="/books", method = RequestMethod.GET )
   //GET
    @GetMapping("/books")
     public ResponseEntity<List<Book>> getBooks(){
        List<Book> list =this.bookServices.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

     @GetMapping("/books/{id}")
     public ResponseEntity<Book> getBook(@PathVariable("id") int id){
     Book book= bookServices.getBookById(id);
     if(book==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
     return ResponseEntity.of(Optional.of(book));
    }

    //POST
    @PostMapping("/books")
   public ResponseEntity<Book> addBook(@RequestBody Book book){
    Book b=null;
    try {
        b=this.bookServices.addBook(book);
      System.out.println(book);
      return ResponseEntity.status(HttpStatus.CREATED).body(b);
        
    } catch (Exception e) {
        e.printStackTrace();
      return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
   
 }

//DELETE
@DeleteMapping("/books/{bookId}")
     public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId)
     {
        try {
            this. bookServices.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
           return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
      
    }

 //UPDATE
@PutMapping("/books/{bookId}")
     public ResponseEntity<Book> UpdateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
      {
        try {
            this. bookServices.updateBook(book,bookId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
             return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
      
      
    }   
}



// BEFORE RESPONSEENTITY less code easy


// @Autowired
//     private BookServices  bookServices;
//     //@RequestMapping(value ="/books", method = RequestMethod.GET )
//    //GET
//     @GetMapping("/books")
//      public List<Book> getBooks(){
//         return   this.bookServices.getAllBooks();
//     }

//      @GetMapping("/books/{id}")
//      public Book getBook(@PathVariable("id") int id)
//      {
//         return   bookServices.getBookById(id);
//     }

//     //POST
//     @PostMapping("/books")
//    public Book addBook(@RequestBody Book book){
//     Book b=this.bookServices.addBook(book);
//     System.out.println(book);
//     return b;
//  }

// //DELETE
// @DeleteMapping("/books/{bookId}")
//      public void deleteBook(@PathVariable("bookId") int bookId)
//      {
//        bookServices.deleteBook(bookId);
//     }

//  //UPDATE
// @PutMapping("/books/{bookId}")
//      public Book UpdateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
//      {
//        bookServices.updateBook(book,bookId);
//        return book;
//     }   